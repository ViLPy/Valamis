package com.arcusys.learn.export.quiz

import java.io.{ ByteArrayOutputStream, InputStream, File, FileInputStream }

import com.arcusys.learn.bl.export._
import com.arcusys.learn.bl.services.{ QuizServiceContract, FileServiceContract }
import com.arcusys.learn.facades._
import com.arcusys.learn.quiz.model._
import com.arcusys.learn.quiz.storage.QuizStorage
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import org.joda.time.DateTime
import org.json4s.{ DefaultFormats, Formats }

//TODO need to reafctor
class QuizImportProcessor(implicit configuration: BindingModule) extends ImportProcessor[Quiz] with Injectable {

  override implicit def bindingModule: BindingModule = configuration

  private lazy val quizStorage = inject[QuizStorage]

  private lazy val quizFacade = inject[QuizFacadeContract]
  private lazy val questionFacade = inject[QuestionFacadeContract]
  private lazy val categoryFacade = inject[CategoryFacadeContract]
  private lazy val fileService = inject[FileServiceContract]
  private lazy val quizService = inject[QuizServiceContract]

  def importItemsImpl(raw: String, courseID: Int, exportTempDirectory: String): Unit = {
    implicit val fs: Formats = DefaultFormats + new QuizContentSerializer + new QuizQuestionSerializer
    val quizes = parseJson[List[QuizExportResponse]](raw).get //OrElse(List())//throw new BadRequestException("Cannot deserialize lessons"))
    quizes.foreach(q => {
      // new logo name for quiz logo file
      val newLogo = if (q.logo.nonEmpty) q.logo.substring(Math.max(q.logo.indexOf("_"), 0)) else ""
      val quizId = quizStorage.createAndGetID(Quiz(-1, q.title, q.description, "", "", Option(courseID), newLogo, None))
      if (q.logo.nonEmpty) {
        try {
          val contentSource = scala.io.Source.fromInputStream(new FileInputStream(exportTempDirectory + q.logo))(scala.io.Codec.ISO8859)
          val content = contentSource.map(_.toByte).toArray
          contentSource.close()
          fileService.setFileContent("quiz_logo_" + quizId, newLogo, content)
        } catch {
          case _ => {
            // if logo saving failed, clear logo in quiz model
            quizStorage.modify(quizStorage.getByID(quizId).get.copy(logo = ""))
          }
        }
      }
      val categoryBankId = categoryFacade.create("Imported_" + DateTime.now.toString("YYYY-MM-dd"), "Imported questions at " + DateTime.now.toString("YYYY-MM-dd"), None, Option(courseID)).id
      q.contents.foreach(addImportContent(quizId, _, None, courseID, categoryBankId, exportTempDirectory))
      if (questionFacade.getChildren(Option(categoryBankId), Option(courseID)).size == 0)
        categoryFacade.delete(categoryBankId, Some(courseID))
    })
  }

  private def addImportContent(newQuizId: Int, content: QuizContentExport, categoryId: Option[String], courseID: Int, categoryBankId: Int, exportTempDirectory: String) {
    content match {
      case c: QuizCategoryExport =>
        val newCategory = quizFacade.addCategory(newQuizId, c.title)
        c.children.foreach(addImportContent(newQuizId, _, Option(newCategory.id), courseID, categoryBankId, exportTempDirectory))
      case q: QuizQuestionRevealJSExport =>
        quizFacade.addQuestionRevealJS(newQuizId, categoryId, q.title, q.text)
      case q: QuizQuestionExternalExport =>
        quizFacade.addQuestionExternal(newQuizId, categoryId, q.title, q.url)
      case q: QuizQuestionRevealPlainTextExport =>
        quizFacade.addQuestionRevealJS(newQuizId, categoryId, q.title, q.content)
      case q: QuizQuestionPDFExport =>
        quizFacade.addQuestionPDF(newQuizId, categoryId, q.title, q.filename)
        val contentSource = scala.io.Source.fromInputStream(new FileInputStream(exportTempDirectory + q.filename))(scala.io.Codec.ISO8859)
        val content = contentSource.map(_.toByte).toArray
        contentSource.close()
        fileService.setFileContent("quizData" + newQuizId, q.filename, content, false)
      case q: QuizQuestionPlainTextExport =>
        quizFacade.addQuestionPlainText(newQuizId, categoryId, q.title, q.text)
      case q: QuizQuestionBankExport =>
        val questionId = questionFacade.createQuestion(Option(categoryBankId),
          q.question.questionType,
          q.question.title,
          q.question.text,
          q.question.explanationText,
          q.question.forceCorrectCount,
          q.question.isCaseSensitive,
          Option(courseID)).id
        questionFacade.updateQuestion(questionId, Option(categoryBankId),
          q.question.questionType,
          q.question.title,
          q.question.text,
          q.question.explanationText,
          q.question.forceCorrectCount,
          q.question.isCaseSensitive,
          Option(courseID),
          q.question.answers.map(_.toAnswerResponse()).toList)
        val res = quizFacade.addQuestion(newQuizId, categoryId, questionId)
        quizFacade.updateQuestion(newQuizId, res.id, q.question.title, q.autoShowAnswer)
      case q: QuizQuestionVideoExport =>
        val filename = exportTempDirectory + q.uuid
        val videoTitle = q.videoTitle
        val groupId = courseID
        val uuid = fileService.addToDocumentLibrary(filename, groupId, videoTitle, q.extension, q.mimeType, q.size)
        val catId = getCategoryId(categoryId)

        quizService.createQuestionDocumentLibrary(newQuizId, catId, q.title, uuid, groupId)
      case q: QuizQuestionPptxExport =>

        val catId = getCategoryId(categoryId)
        val content = streamToByteArray(new FileInputStream(exportTempDirectory + q.filename))
        fileService.setFileContent("quizData" + newQuizId, q.filename, content, false)

        quizService.createQuestionPPTX(newQuizId, catId, q.title, q.filename)
    }
  }

  //TODO need to reafctor
  private def getCategoryId(categoryId: Option[String]) = {
    if (categoryId.isEmpty) None
    else Option(categoryId.get.replace("c_", "").toInt)
  }

  private def streamToByteArray(input: InputStream) = {
    val buffer = new Array[Byte](8192)
    val baos = new ByteArrayOutputStream

    def copy() {
      val read = input.read(buffer)
      if (read >= 0) {
        baos.write(buffer, 0, read)
        copy()
      }
    }
    copy()

    input.close()
    baos.toByteArray
  }
}

