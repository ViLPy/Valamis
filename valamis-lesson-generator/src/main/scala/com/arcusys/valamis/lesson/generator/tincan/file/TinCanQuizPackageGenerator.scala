package com.arcusys.valamis.lesson.generator.tincan.file

import java.io.{ ByteArrayInputStream, InputStream }
import com.arcusys.valamis.lesson.generator.PackageGenerator
import com.arcusys.valamis.lesson.generator.tincan.file.html.TinCanQuestionViewGenerator
import com.arcusys.valamis.lesson.generator.tincan.{ TinCanPackageGeneratorProperties, TinCanPackageGenerator }
import com.arcusys.valamis.lesson.generator.util.ResourceHelpers
import com.arcusys.valamis.file.storage.FileStorage
import com.arcusys.valamis.questionbank.model.{ DLVideo, PlainText }
import com.arcusys.valamis.quiz.model._
import com.arcusys.valamis.quiz.storage.{ QuizTreeStorage, QuizQuestionStorage, QuizQuestionCategoryStorage }
import com.arcusys.valamis.util.{ FileSystemUtil, ZipBuilder }
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import org.apache.commons.lang.StringEscapeUtils

import scala.collection.mutable

class TinCanQuizPackageGenerator(quiz: Quiz, rootActivityId: String, properties: TinCanPackageGeneratorProperties, portalURL: Option[String] = None)(implicit val bindingModule: BindingModule) extends Injectable with PackageGenerator with TinCanPackageGenerator {
  case class Category(id: Int, title: String, categoryQuestions: Seq[QuizQuestion])
  private val quizQuestionStorage = inject[QuizQuestionStorage]
  private val quizTreeStorage = inject[QuizTreeStorage]
  private val fileStorage = inject[FileStorage]
  private val categoryStorage = inject[QuizQuestionCategoryStorage]

  private val resourceFiles = mutable.HashSet[String]()
  private val questionViewGenerator = new TinCanQuestionViewGenerator(isPreview = false)
  private val resourcesToAdd = mutable.ListBuffer[(String, InputStream)]()

  private def generateManifest = {
    <tincan xmlns="http://projecttincan.com/tincan.xsd">
      <activities>
        <activity id={ rootActivityId } type="http://adlnet.gov/expapi/activities/course">
          <name>
            { quiz.title }
          </name>
          <description lang="en-US">
            { quiz.description }
          </description>
          <launch lang="en-us">data/index.html</launch>
        </activity>
      </activities>
    </tincan>
  }

  def generateZip(courseID: Option[Int]) = {
    val zipFile = FileSystemUtil.getTempFile("Quiz_" + quiz.id.toString + "_", "zip")

    val zip = new ZipBuilder(zipFile)

    if (portalURL.isDefined) zip.addEntry("index.html", questionViewGenerator.generateExternalIndex(portalURL.get))
    zip.addFilesFromZip(getResourceInputStream("common/pdf.zip"))
    zip.addEntry("tincan.xml", generateManifest.toString())
    zip.addEntry(
      "data/index.html",
      questionViewGenerator.generateRevealJSQuiz(
        quiz.id,
        rootActivityId,
        quiz.title,
        quiz.description.replace("\n", ""),
        serializedQuestionData,
        processQuizData.mkString,
        quiz.maxDuration,
        properties
      )
    )
    (commonResourceURLs ++ commonRevealResourceURLs).foreach(filename =>
      zip.addFile(getResourceInputStream("common/" + filename), "data/" + filename)
    )
    resourceFiles.foreach(filename => {
      zip.addFile(
        "data/" + filename,
        fileStorage.getFile(filename).getOrElse(throw new Exception("Can't find file '" + filename + "' in DB"))
          .content.getOrElse(throw new Exception("File '" + filename + "' has no content"))
      )
    })
    resourcesToAdd.foreach {
      case (fileName, content) =>
        zip.addFile(content, "data/" + fileName)
    }
    zip.close()

    zipFile
  }

  private def serializedQuestionData = {
    import org.json4s.jackson.Serialization
    import org.json4s.{ Formats, ShortTypeHints }
    /*
    * import com.arcusys.util.JsonSerializer._
    * gatherQuizData.toJson
    * */
    import org.json4s.jackson.Serialization._
    implicit val fs: Formats = Serialization.formats(ShortTypeHints(List(classOf[Category], classOf[QuizQuestion])))
    write(gatherQuizData)
  }

  private def gatherQuizData: Seq[Any] = {
    val quizTreeElements = quizTreeStorage.getByQuizID(quiz.id)
    quizTreeElements.filter(_.parentID.isEmpty).sortBy(_.arrangementIndex).foldLeft(Seq[Any]())((acc, el) => {
      if (el.isCategory) {
        val mappedCollection = quizTreeElements.filter(_.parentID == Some(el.elementID)).sortBy(_.arrangementIndex).map(e => {
          val id = quizTreeStorage.getRealElementID(e)
          quizQuestionStorage.getByID(id).getOrElse(throw new Exception("Unknown question ID " + id))
        })
        val category = categoryStorage.getByID(el.elementID.drop("c_".length).toInt).getOrElse(throw new IllegalStateException("Inconsistency in DB"))
        acc :+ Category(
          category.id,
          category.title,
          mappedCollection
        )
      } else {
        val id = quizTreeStorage.getRealElementID(el)
        acc :+ quizQuestionStorage.getByID(id).getOrElse(throw new Exception("Unknown question ID " + id))
      }
    })
  }

  private def processQuestion(question: QuizQuestion) = question match {
    case questionBankQuestion: QuestionBankQuizQuestion =>
      val realQuestion = questionBankQuestion.question
      val imageResources = ResourceHelpers.fetchResources(realQuestion.text)
      imageResources.foreach(res => {
        resourceFiles += res
      })
      questionViewGenerator.getHTMLByQuestionId(realQuestion, questionBankQuestion.autoShowAnswer)
    case plain: PlainTextQuizQuestion =>
      val realQuestion = new PlainText(plain.id, plain.categoryID, plain.title.getOrElse(""), StringEscapeUtils.unescapeJavaScript(plain.text), None)
      val imageResources = ResourceHelpers.fetchResources(realQuestion.text)
      imageResources.foreach(res => {
        resourceFiles += res
      })
      questionViewGenerator.getHTMLByQuestionId(realQuestion, false)
    case external: ExternalQuizQuestion =>
      questionViewGenerator.getHTMLForIframePage(external.id, external.title.getOrElse(external.url), external.url)
    case reveal: RevealJSQuizQuestion =>
      val imageResources = ResourceHelpers.fetchResources(reveal.content)
      imageResources.foreach(res => {
        resourceFiles += res
      })
      questionViewGenerator.getHTMLForRevealPage(reveal.content)
    case pdf: PDFQuizQuestion =>
      val filename = "files/quizData" + pdf.quizID + "/" + pdf.filename
      resourceFiles += filename
      questionViewGenerator.getHTMLForPDFPage(pdf.id, pdf.title.getOrElse(pdf.filename), filename)
    case dlVideo: DLVideoQuizQuestion =>
      val realQuestion = new DLVideo(dlVideo.id, dlVideo.categoryID, dlVideo.title.getOrElse(""), "", None, dlVideo.uuid, dlVideo.groupId)
      val imageResources = ResourceHelpers.fetchResources(realQuestion.text)
      imageResources.foreach(res => {
        resourceFiles += res
      })
      questionViewGenerator.getHTMLByQuestionId(realQuestion, false)
    case pptx: PPTXQuizQuestion =>
      val filename = "files/quizData" + pptx.quizID + "/" + pptx.file
      resourceFiles += filename

      val pptxContent = questionViewGenerator.getHTMLForPPTXForegroundPage(pptx).getBytes

      resourcesToAdd += ((s"pptx-foreground-iframe-${pptx.id}.html", new ByteArrayInputStream(pptxContent)))
      questionViewGenerator.getHTMLForPPTXPage(pptx)
    case _ => throw new UnsupportedOperationException("Unknown question type")
  }

  private def processQuizData = {
    val questions = gatherQuizData
    questions.map {
      case category: Category     => category.categoryQuestions.map(processQuestion).mkString
      case question: QuizQuestion => processQuestion(question)
      case _                      => throw new UnsupportedOperationException("Unknown question type")
    }
  }
}