package com.arcusys.learn.models

import com.arcusys.learn.questionbank.model.{ Answer, Question }

case class QuizResponse(id: Int, title: String, description: String, logo: String, size: Int, maxDuration: Option[Int])

case class QuizPublishStatusResponse(status: Boolean)

sealed trait QuizContentResponse {
  def id: String
  def contentType: String
  def title: String
  def arrangementIndex: Int
  def lessonId: Int
}

case class QuizCategoryResponse(
    id: String,
    lessonId: Int,
    title: String,
    arrangementIndex: Int = 1,
    children: Seq[QuizQuestionResponse],
    contentType: String = "category") extends QuizContentResponse {
}

sealed trait QuizQuestionResponse extends QuizContentResponse {
}

case class QuizQuestionExternalResponse(
  id: String,
  lessonId: Int,
  categoryID: Option[Int],
  title: String,
  url: String,
  arrangementIndex: Int = 1,
  contentType: String = "questionExternalResource") extends QuizQuestionResponse

case class QuizQuestionPlainTextResponse(
  id: String,
  lessonId: Int,
  categoryID: Option[Int],
  title: String,
  text: String,
  arrangementIndex: Int = 1,
  contentType: String = "questionPlainText") extends QuizQuestionResponse

case class QuizQuestionBankResponse(
  id: String,
  lessonId: Int,
  categoryID: Option[Int],
  title: String,
  question: Question[Answer],
  autoShowAnswer: Boolean,
  arrangementIndex: Int = 1,
  contentType: String = "question") extends QuizQuestionResponse

case class QuizQuestionRevealJSResponse(
  id: String,
  lessonId: Int,
  categoryID: Option[Int],
  title: String,
  text: String,
  arrangementIndex: Int = 1,
  contentType: String = "questionRevealJS") extends QuizQuestionResponse

case class QuizQuestionPDFResponse(
  id: String,
  lessonId: Int,
  categoryID: Option[Int],
  title: String,
  filename: String,
  arrangementIndex: Int = 1,
  contentType: String = "questionPDF") extends QuizQuestionResponse

case class QuizQuestionPPTXResponse(
  id: String,
  lessonId: Int,
  categoryID: Option[Int],
  title: String,
  arrangementIndex: Int = 1,
  contentType: String = "questionPPTX") extends QuizQuestionResponse

case class QuizQuestionVideoDLResponse(
  id: String,
  lessonId: Int,
  categoryID: Option[Int],
  title: String,
  uuid: String,
  arrangementIndex: Int = 1,
  contentType: String = "questionVideoDL") extends QuizQuestionResponse

abstract class QuizQuestionPreview
case class QuizQuestionPreviewContent(content: String) extends QuizQuestionPreview
case class QuizQuestionPreviewRedirect(url: String) extends QuizQuestionPreview