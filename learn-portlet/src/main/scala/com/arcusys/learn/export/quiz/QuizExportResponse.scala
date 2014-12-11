package com.arcusys.learn.export.quiz

import com.arcusys.learn.export.question.QuestionExport

case class QuizExportResponse(
  title: String,
  description: String,
  logo: String,
  contents: Seq[QuizContentExport])

case class QuizPublishStatusExportResponse(
  status: Boolean)

sealed trait QuizContentExport {
  def contentType: String

  def title: String

  def arrangementIndex: Int
}

case class QuizCategoryExport(
    title: String,
    arrangementIndex: Int = 1,
    children: Seq[QuizQuestionExport],
    contentType: String = "category") extends QuizContentExport {
}

sealed trait QuizQuestionExport extends QuizContentExport {
}

case class QuizQuestionExternalExport(
  title: String,
  url: String,
  arrangementIndex: Int = 1,
  contentType: String = "questionExternalResource") extends QuizQuestionExport

case class QuizQuestionPlainTextExport(
  title: String,
  text: String,
  arrangementIndex: Int = 1,
  contentType: String = "questionPlainText") extends QuizQuestionExport

case class QuizQuestionPDFExport(
  title: String,
  filename: String,
  arrangementIndex: Int = 1,
  contentType: String = "questionPDF") extends QuizQuestionExport

case class QuizQuestionRevealPlainTextExport(
  title: String,
  content: String,
  arrangementIndex: Int = 1,
  contentType: String = "questionRevealPlainText") extends QuizQuestionExport

case class QuizQuestionBankExport(
  title: String,
  question: QuestionExport,
  autoShowAnswer: Boolean,
  arrangementIndex: Int = 1,
  contentType: String = "question") extends QuizQuestionExport

case class QuizQuestionRevealJSExport(
  title: String,
  text: String,
  arrangementIndex: Int = 1,
  contentType: String = "questionRevealJS") extends QuizQuestionExport

case class QuizQuestionVideoExport(
  title: String,
  arrangementIndex: Int = 1,
  uuid: String,
  videoTitle: String,
  extension: String,
  mimeType: String,
  size: Long,
  contentType: String = "questionVideo") extends QuizQuestionExport

case class QuizQuestionPptxExport(
  title: String,
  filename: String,
  arrangementIndex: Int = 1,
  contentType: String = "questionPPTX") extends QuizQuestionExport
