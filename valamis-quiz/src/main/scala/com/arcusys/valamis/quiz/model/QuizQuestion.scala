package com.arcusys.valamis.quiz.model

import com.arcusys.valamis.questionbank.model.{ Answer, Question }

object QuizQuestionType extends Enumeration {
  type QuizQuestionType = Value
  val External, QuestionBank, PlainText, RevealJS, PDF, PPTX, DLVideo = Value
}

/**
 * A question binding from question bank to quiz
 * @param id            Unique internal ID of question binding
 * @param quizID        ID of quiz this question belongs to
 * @param categoryID    ID of a category this quiz question belongs to, or None if question is in root of quiz
 */
sealed trait QuizQuestion {
  def id: Int
  def quizID: Int
  def categoryID: Option[Int]
  def title: Option[String]
  def arrangementIndex: Int
}

case class ExternalQuizQuestion(id: Int,
  quizID: Int,
  categoryID: Option[Int],
  title: Option[String],
  url: String,
  arrangementIndex: Int = 1) extends QuizQuestion

case class PlainTextQuizQuestion(id: Int,
  quizID: Int,
  categoryID: Option[Int],
  title: Option[String],
  text: String,
  arrangementIndex: Int = 1) extends QuizQuestion

case class QuestionBankQuizQuestion(id: Int,
  quizID: Int,
  categoryID: Option[Int],
  title: Option[String],
  question: Question[Answer],
  autoShowAnswer: Boolean,
  arrangementIndex: Int = 1) extends QuizQuestion

case class RevealJSQuizQuestion(id: Int,
  quizID: Int,
  categoryID: Option[Int],
  title: Option[String],
  content: String,
  arrangementIndex: Int = 1) extends QuizQuestion

case class PDFQuizQuestion(id: Int,
  quizID: Int,
  categoryID: Option[Int],
  title: Option[String],
  filename: String,
  arrangementIndex: Int = 1) extends QuizQuestion

case class PPTXQuizQuestion(id: Int,
  quizID: Int,
  categoryID: Option[Int],
  title: Option[String],
  file: String,
  arrangementIndex: Int = 1) extends QuizQuestion

case class PlainRevealJSQuizQuestion(id: Int,
  quizID: Int,
  categoryID: Option[Int],
  title: Option[String],
  content: String,
  arrangementIndex: Int = 1) extends QuizQuestion

case class DLVideoQuizQuestion(id: Int,
  quizID: Int,
  categoryID: Option[Int],
  title: Option[String],
  uuid: String,
  groupId: Option[Int],
  arrangementIndex: Int = 1) extends QuizQuestion