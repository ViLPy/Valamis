package com.arcusys.learn.questionbank.model

import org.scalatest.{ Matchers, FlatSpec }
import org.junit.runner.RunWith

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class PositioningQuestionTest extends FlatSpec with Matchers {
  "Positioning answer" can "be constructed" in {
    val answer = new PositioningAnswer(7, "turn on", true)
    answer.id should equal(7)
    answer.text should equal("turn on")
    answer.isCorrect should equal(true)
  }

  private def someAnswers = Seq(
    new PositioningAnswer(7, "turn on", true),
    new PositioningAnswer(9, "turn around", false),
    new PositioningAnswer(8, "turn off", true)
  )

  private def constructQuestion(categoryId: Option[Int], answers: Seq[PositioningAnswer]) = new PositioningQuestion(
    id = 55,
    categoryID = categoryId,
    title = "Turning",
    text = "How do yoy turn things on and back off?",
    explanationText = "Turning around is some other kind of turning",
    answers = answers,
    forceCorrectCount = true,
    courseID = Some(1)
  )

  private def checkFields(question: PositioningQuestion, categoryId: Option[Int], answers: Seq[PositioningAnswer]) {
    question.questionTypeCode should equal(3)
    question.id should equal(55)
    question.categoryID should equal(categoryId)
    question.title should equal("Turning")
    question.text should equal("How do yoy turn things on and back off?")
    question.explanationText should equal("Turning around is some other kind of turning")
    question.forceCorrectCount should equal(true)
    question.answers should equal(answers)
  }

  "Positioning question" can "be constructed" in {
    val answers = someAnswers
    val question = constructQuestion(categoryId = Some(33), answers = answers)
    checkFields(question, categoryId = Some(33), answers = answers)
  }

  it can "be constructed with empty category" in {
    val answers = someAnswers
    val question = constructQuestion(categoryId = None, answers = answers)
    checkFields(question, categoryId = None, answers = answers)
  }

  it can "be constructed without answers" in {
    val question = constructQuestion(categoryId = Some(33), answers = Nil)
    checkFields(question, categoryId = Some(33), answers = Nil)
  }
}
