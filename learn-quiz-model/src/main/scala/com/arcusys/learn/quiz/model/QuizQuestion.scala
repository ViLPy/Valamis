package com.arcusys.learn.quiz.model

import com.arcusys.learn.questionbank.model._

object QuizQuestionType extends Enumeration {
  type QuizQuestionType = Value
  val External, QuestionBank, PlainText, RevealJS = Value
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
  arrangementIndex: Int = 1) extends QuizQuestion

case class RevealJSQuizQuestion(id: Int,
  quizID: Int,
  categoryID: Option[Int],
  title: Option[String],
  content: String,
  arrangementIndex: Int = 1) extends QuizQuestion