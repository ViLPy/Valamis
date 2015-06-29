package com.arcusys.learn.export.quiz

import com.arcusys.learn.export.question.{ AnswerExport, QuestionExport }
import com.arcusys.learn.facades._
import com.arcusys.learn.models.AnswerResponse
import com.arcusys.valamis.export.ExportProcessor
import com.arcusys.valamis.file.service.FileService
import com.arcusys.valamis.questionbank.model.{ Question, Answer }
import com.arcusys.valamis.quiz.model._
import com.arcusys.valamis.quiz.service.QuizService
import com.arcusys.valamis.util.ZipBuilder
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }

class QuizExportProcessor(implicit val bindingModule: BindingModule) extends ExportProcessor[Quiz, QuizExportResponse] with Injectable {

  private lazy val quizService = inject[QuizService]

  private lazy val fileService = inject[FileService]
  private lazy val questionFacade = inject[QuestionFacadeContract]

  override def exportItemsImpl(zip: ZipBuilder, items: Seq[Quiz]): Seq[QuizExportResponse] = {
    items.map(q => {
      var logoName = q.logo
      if (logoName != null && !logoName.isEmpty) {
        zip.addFile(q.id + "_" + q.logo, fileService.getFileContent("quiz_logo_" + q.id, q.logo))
        logoName = q.id + "_" + q.logo
      }
      toQuizExportResponse(q.copy(logo = logoName), zip)
    })
  }

  private def toQuizExportResponse(quiz: Quiz, zip: ZipBuilder) = {
    val contents = getContentForExport(quiz.id, zip)
    QuizExportResponse(
      quiz.title,
      quiz.description,
      quiz.logo,
      contents)
  }

  private def getContentForExport(quizId: Int, zip: ZipBuilder): Seq[QuizContentExport] = {
    val rootCategories = quizService.getCategories(quizId, None)
      .map(c => toCategoryExport(c, quizService.getQuestionsByCategory(quizId, Option(c.id)), zip))

    val rootContent: Seq[QuizContentExport] = rootCategories ++
      quizService.getQuestionsByCategory(quizId, None).map(c => toQuestionExport(c, zip))

    //TODO: add not root categories
    rootContent.sortBy(_.arrangementIndex)
  }

  private def toQuestionExport(question: QuizQuestion, zip: ZipBuilder): QuizQuestionExport = {
    val arrangementIndex = quizService.getQuestionIndex(question.quizID, question.id)
    question match {
      case q: QuestionBankQuizQuestion => QuizQuestionBankExport(
        q.question.title, toQuestionExport(q.question), q.autoShowAnswer, arrangementIndex // TODO: convert answer
      )
      case q: PlainTextQuizQuestion => QuizQuestionPlainTextExport(
        q.title.getOrElse(""), q.text, arrangementIndex
      )
      case q: PlainRevealJSQuizQuestion => QuizQuestionRevealPlainTextExport(
        q.title.getOrElse(""), q.content, arrangementIndex
      )
      case q: PDFQuizQuestion =>
        if (!zip.contains(q.filename)) zip.addFile(q.filename, fileService.getFileContent("quizData" + q.quizID, q.filename))
        QuizQuestionPDFExport(q.title.getOrElse(""), q.filename, arrangementIndex)
      case q: ExternalQuizQuestion => QuizQuestionExternalExport(
        q.title.getOrElse(""), q.url, arrangementIndex
      )
      case q: RevealJSQuizQuestion => QuizQuestionRevealJSExport(
        q.title.getOrElse(""), q.content, arrangementIndex
      )
      case q: DLVideoQuizQuestion => {

        val fileEntry = fileService.getFileEntry(q.uuid, q.groupId.get)
        val mimeType = fileEntry.getMimeType
        val videoTitle = fileEntry.getTitle
        val extension = fileEntry.getExtension
        val size = fileEntry.getSize

        if (!zip.contains(q.uuid)) zip.addFile(q.uuid, fileService.getFileContent(q.uuid, q.groupId.get))
        QuizQuestionVideoExport(q.title.getOrElse(""), q.arrangementIndex, q.uuid, videoTitle, extension, mimeType, size)
      }
      case q: PPTXQuizQuestion => {
        if (!zip.contains(q.file)) zip.addFile(q.file, fileService.getFileContent("quizData" + q.quizID, q.file))
        QuizQuestionPptxExport(q.title.getOrElse(""), q.file, arrangementIndex)
      }
    }
  }

  private def toCategoryExport(c: QuizQuestionCategory, qs: Seq[QuizQuestion], zip: ZipBuilder) = {
    val arrangementIndex = quizService.getCategoryIndex(c.quizID, c.id)
    QuizCategoryExport(
      c.title, arrangementIndex, qs.map(q => toQuestionExport(q, zip))
    )
  }

  private def toQuestionExport(question: Question[Answer]) = {
    val questionResponse = questionFacade.buildQuestionResponse(question)
    QuestionExport(questionResponse.entityType,
      questionResponse.title,
      questionResponse.text,
      questionResponse.explanationText,
      Some(questionResponse.rightAnswerText),
      Some(questionResponse.wrongAnswerText),
      questionResponse.forceCorrectCount,
      questionResponse.isCaseSensitive,
      questionResponse.answers.map(toAnswerExport),
      questionResponse.questionType,
      questionResponse.arrangementIndex)
  }

  private def toAnswerExport(answer: AnswerResponse) = {
    AnswerExport(answer.answerText, answer.isCorrect, answer.rangeFrom, answer.rangeTo, answer.matchingText, answer.score)
  }
}

