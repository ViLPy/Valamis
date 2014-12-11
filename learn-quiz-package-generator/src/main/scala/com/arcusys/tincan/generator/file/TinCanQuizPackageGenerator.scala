package com.arcusys.tincan.generator.file

import java.io.{ ByteArrayInputStream, InputStream }

import com.arcusys.learn.filestorage.storage.FileStorage
import com.arcusys.learn.quiz.model._
import com.arcusys.learn.quiz.storage.{ QuizTreeStorage, QuizQuestionStorage }
import com.arcusys.scorm.util.{ FileProcessing, FileSystemUtil }

import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }

import scala.collection.mutable
import java.net.URLDecoder
import com.arcusys.scorm.generator.file.ZipFile
import com.arcusys.scorm.generator.util.ResourceHelpers
import com.arcusys.learn.questionbank.model.{ DLVideo, PlainText }
import org.apache.commons.lang.StringEscapeUtils
import com.arcusys.tincan.generator.file.html.TinCanQuestionViewGenerator
import com.arcusys.generator.PackageGenerator

class TinCanQuizPackageGenerator(quiz: Quiz, theme: Option[String], portalURL: Option[String] = None)(implicit val bindingModule: BindingModule) extends Injectable with PackageGenerator {
  private val quizQuestionStorage = inject[QuizQuestionStorage]
  private val quizTreeStorage = inject[QuizTreeStorage]
  private val fileStorage = inject[FileStorage]

  private val resourceFiles = mutable.HashSet[String]()
  private val commonResourceURLs = Seq("jquery-1.7.2.min.js", "jquery-ui-1.8.20.custom.min.js",
    "jquery-ui-1.8.20.custom.css", "base.js", "tincan-min.js", "icheck.min.js", "player_tincan_content.css", "buttons.css")

  private val commonRevealResourceURLs = Seq("reveal.min.js", "head.min.js", "plugin/highlight/highlight.js", "css/zenburn.css", "css/reveal.css", "css/theme/beige.css",
    "css/theme/blood.css", "css/theme/default.css", "css/theme/moon.css", "css/theme/night.css",
    "css/theme/serif.css", "css/theme/simple.css", "css/theme/sky.css", "css/theme/solarized.css",
    "skins/polaris/polaris.css", "skins/polaris/polaris.png", "skins/polaris/polaris@2x.png")
  private val questionViewGenerator = new TinCanQuestionViewGenerator(isPreview = false)
  private val resourcesToAdd = mutable.ListBuffer[(String, InputStream)]()

  private def getResourceInputStream(name: String) = Thread.currentThread.getContextClassLoader.getResourceAsStream(name)

  private def decode(source: String) = URLDecoder.decode(source, "UTF-8")

  private def generateManifest = {
    <tincan xmlns="http://projecttincan.com/tincan.xsd">
      <activities>
        <activity id={ "http://valamislearning.com/quiz/" + quiz.id } type="http://adlnet.gov/expapi/activities/course">
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

  def generateZip(courseID: Option[Int], randomOrdering: Boolean, questionsPerUser: Option[Int]) = {
    val zipName = FileProcessing.getTempFileName("Quiz" + quiz.id.toString, ".zip")
    val zip = new ZipFile(FileSystemUtil.getRealTmpDir + zipName)
    if (portalURL.isDefined) zip.addEntry("index.html", questionViewGenerator.generateExternalIndex(portalURL.get))
    zip.addFilesFromZip(getResourceInputStream("common/pdf.zip"))
    zip.addEntry("tincan.xml", generateManifest.toString())
    zip.addEntry(
      "data/index.html",
      questionViewGenerator.generateRevealJSQuiz(
        quiz.id,
        quiz.title,
        quiz.description,
        theme,
        processQuizData.mkString,
        randomOrdering,
        questionsPerUser,
        quiz.maxDuration,
        "Quiz" + quiz.id
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

    zipName
  }

  private def gatherQuizData = {
    val quizTreeElements = quizTreeStorage.getByQuizID(quiz.id)
    quizTreeElements.filter(_.parentID.isEmpty).sortBy(_.arrangementIndex).foldLeft(Seq[QuizQuestion]())((acc, el) => {
      if (el.isCategory) {
        val filtered = quizTreeElements.filter(_.parentID == Some(el.id))
        val mappedCollection = quizTreeElements.filter(_.parentID == Some(el.elementID)).sortBy(_.arrangementIndex).map(e => {
          val id = quizTreeStorage.getRealElementID(e)
          quizQuestionStorage.getByID(id).getOrElse(throw new Exception("Unknown question ID " + id))
        })
        acc ++ mappedCollection
      } else {
        val id = quizTreeStorage.getRealElementID(el)
        acc :+ quizQuestionStorage.getByID(id).getOrElse(throw new Exception("Unknown question ID " + id))
      }
    })
  }

  private def processQuizData = {
    val questions = gatherQuizData
    // map to rendered HTML blocks for each page
    questions.map {
      case questionBankQuestion: QuestionBankQuizQuestion =>
        val realQuestion = questionBankQuestion.question
        val imageResources = ResourceHelpers.fetchResources(decode(realQuestion.text))
        imageResources.foreach(res => {
          resourceFiles += res
        })
        questionViewGenerator.getHTMLByQuestionId(realQuestion, questionBankQuestion.autoShowAnswer)
      case plain: PlainTextQuizQuestion =>
        val realQuestion = new PlainText(plain.id, plain.categoryID, plain.title.getOrElse(""), StringEscapeUtils.unescapeJavaScript(plain.text), None)
        val imageResources = ResourceHelpers.fetchResources(decode(realQuestion.text))
        imageResources.foreach(res => {
          resourceFiles += res
        })
        questionViewGenerator.getHTMLByQuestionId(realQuestion, false)
      case external: ExternalQuizQuestion =>
        questionViewGenerator.getHTMLForIframePage(external.id, external.title.getOrElse(external.url), external.url)
      case reveal: RevealJSQuizQuestion =>
        val imageResources = ResourceHelpers.fetchResources(decode(reveal.content))
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
        val imageResources = ResourceHelpers.fetchResources(decode(realQuestion.text))
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
  }
}