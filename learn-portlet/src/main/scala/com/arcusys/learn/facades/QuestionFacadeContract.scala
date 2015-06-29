package com.arcusys.learn.facades

import java.io.{ File, InputStream }

import com.arcusys.learn.models.{ AnswerResponse, QuestionResponse }
import com.arcusys.valamis.questionbank.model.{ Question, Answer }

/**
 * User: Yulia.Glushonkova
 * Date: 05.05.14
 */
trait QuestionFacadeContract {
  def getQuestion(id: Int): QuestionResponse

  def getChildren(categoryID: Option[Int], courseID: Option[Int]): Seq[QuestionResponse]

  def createQuestion(categoryId: Option[Int],
    questionType: Int,
    title: String,
    text: String,
    explanationText: String,
    rightAnswerText: String,
    wrongAnswerText: String,
    forceCorrectCount: Boolean,
    isCaseSensitive: Boolean,
    courseID: Option[Int],
    answers: Seq[AnswerResponse]): QuestionResponse

  def updateQuestion(id: Int,
    categoryId: Option[Int],
    questionType: Int,
    title: String,
    text: String,
    explanationText: String,
    rightAnswerText: String,
    wrongAnswerText: String,
    forceCorrectCount: Boolean,
    isCaseSensitive: Boolean,
    courseID: Option[Int],
    answers: List[AnswerResponse]): QuestionResponse

  def deleteQuestion(id: Int)

  def move(id: Int,
    index: Int,
    parentID: Option[Int])

  def moveToCourse(id: Int, courseID: Option[Int])

  def exportAllQuestionsBase(courseID: Option[Int]): InputStream

  def exportQuestions(categoryIds: Seq[Int], questionIds: Seq[Int], courseID: Option[Int]): InputStream

  def importQuestions(file: File, courseID: Int): Unit

  def buildQuestionResponse(question: Question[Answer]): QuestionResponse
  //  def createAnswer(
  //    questionId: Long,
  //    answerText: String,
  //    isCorrect: Boolean,
  //    rangeFrom: BigDecimal,
  //    rangeTo: BigDecimal,
  //    matchingText: String,
  //    score: Option[Double]): AnswerResponse
  //
  //  def updateAnswer(answerId: Long,
  //    answerText: String,
  //    isCorrect: Boolean,
  //    rangeFrom: BigDecimal,
  //    rangeTo: BigDecimal,
  //    matchingText: String,
  //    score: Option[Double]): AnswerResponse
  //
  //  def deleteAnswer(answerId: Long)
}
