package com.arcusys.learn.export.quiz

import java.io.{ File, FileInputStream }

import com.arcusys.learn.facades._
import com.arcusys.valamis.export.ImportProcessor
import com.arcusys.valamis.file.service.FileService
import com.arcusys.valamis.quiz.model.Quiz
import com.arcusys.valamis.quiz.service.QuizService
import com.arcusys.valamis.quiz.storage.QuizStorage
import com.arcusys.valamis.util.{ FileSystemUtil, StreamUtil }
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import org.joda.time.DateTime
import org.json4s.{ DefaultFormats, Formats }

//TODO need to reafctor
class QuizImportProcessor(implicit configuration: BindingModule) extends ImportProcessor[QuizExportResponse] with Injectable {

  override implicit def bindingModule: BindingModule = configuration

  private lazy val quizStorage = inject[QuizStorage]

  private lazy val quizFacade = inject[QuizFacadeContract]
  private lazy val questionFacade = inject[QuestionFacadeContract]
  private lazy val categoryFacade = inject[CategoryFacadeContract]
  private lazy val fileService = inject[FileService]
  private lazy val quizService = inject[QuizService]

  def importItems(items: List[QuizExportResponse], courseId: Long, tempDirectory: File, userId: Long): Unit = {
    items.foreach(q => {
      // new logo name for quiz logo file
      val newLogo = if (q.logo.nonEmpty) q.logo.substring(Math.max(q.logo.indexOf("_"), 0)) else ""
      val quizId = quizStorage.createAndGetID(Quiz(-1, q.title, q.description, "", "", Option(courseId.toInt), newLogo, None))
      if (q.logo.nonEmpty) {
        try {
          val content = FileSystemUtil.getFileContent(new File(tempDirectory, q.logo))
          fileService.setFileContent("quiz_logo_" + quizId, newLogo, content)
        } catch {
          case _: Throwable => {
            // if logo saving failed, clear logo in quiz model
            quizStorage.modify(quizStorage.getByID(quizId).get.copy(logo = ""))
          }
        }
      }
      val categoryBankId = categoryFacade.create("Imported_" + DateTime.now.toString("YYYY-MM-dd"), "Imported questions at " + DateTime.now.toString("YYYY-MM-dd"), None, Option(courseId.toInt)).id
      q.contents.foreach(addImportContent(quizId, _, None, courseId, categoryBankId, tempDirectory))
      if (questionFacade.getChildren(Option(categoryBankId), Option(courseId.toInt)).size == 0)
        categoryFacade.delete(categoryBankId, Some(courseId.toInt))
    })
  }

  private def addImportContent(newQuizId: Int, content: QuizContentExport, categoryId: Option[String], courseId: Long, categoryBankId: Int, tempDirectory: File) {
    content match {
      case c: QuizCategoryExport =>
        val newCategory = quizFacade.addCategory(newQuizId, c.title)
        c.children.foreach(addImportContent(newQuizId, _, Option(newCategory.id), courseId, categoryBankId, tempDirectory))
      case q: QuizQuestionRevealJSExport =>
        quizFacade.addQuestionRevealJS(newQuizId, categoryId, q.title, q.text)
      case q: QuizQuestionExternalExport =>
        quizFacade.addQuestionExternal(newQuizId, categoryId, q.title, q.url)
      case q: QuizQuestionRevealPlainTextExport =>
        quizFacade.addQuestionRevealJS(newQuizId, categoryId, q.title, q.content)
      case q: QuizQuestionPDFExport =>
        quizFacade.addQuestionPDF(newQuizId, categoryId, q.title, q.filename)
        val content = FileSystemUtil.getFileContent(new File(tempDirectory, q.filename))
        fileService.setFileContent("quizData" + newQuizId, q.filename, content, false)
      case q: QuizQuestionPlainTextExport =>
        quizFacade.addQuestionPlainText(newQuizId, categoryId, q.title, q.text)
      case q: QuizQuestionBankExport =>
        val questionId = questionFacade.createQuestion(Option(categoryBankId),
          q.question.questionType,
          q.question.title,
          q.question.text,
          q.question.explanationText,
          q.question.rightAnswerText.getOrElse(""),
          q.question.wrongAnswerText.getOrElse(""),
          q.question.forceCorrectCount,
          q.question.isCaseSensitive,
          Option(courseId.toInt),
          q.question.answers.map(_.toAnswerResponse()).toList).id
        val res = quizFacade.addQuestion(newQuizId, categoryId, questionId)
        quizFacade.updateQuestion(newQuizId, res.id, q.question.title, q.autoShowAnswer)
      case q: QuizQuestionVideoExport =>
        val file = new File(tempDirectory, q.uuid)
        val videoTitle = q.videoTitle
        val uuid = fileService.addToDocumentLibrary(file.getPath, courseId, videoTitle, q.extension, q.mimeType, q.size)
        val catId = getCategoryId(categoryId)

        quizService.createQuestionDocumentLibrary(newQuizId, catId, q.title, uuid, courseId.toInt)
      case q: QuizQuestionPptxExport =>

        val catId = getCategoryId(categoryId)
        val content = StreamUtil.toByteArray(new FileInputStream(new File(tempDirectory, q.filename)))
        fileService.setFileContent("quizData" + newQuizId, q.filename, content, false)

        quizService.createQuestionPPTX(newQuizId, catId, q.title, q.filename)
    }
  }

  //TODO need to reafctor
  private def getCategoryId(categoryId: Option[String]) = {
    if (categoryId.isEmpty) None
    else Option(categoryId.get.replace("c_", "").toInt)
  }
}

