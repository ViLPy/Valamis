package com.arcusys.learn.questionbank.model

import org.scalatest.{ Matchers, FlatSpec }
import org.junit.runner.RunWith

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class NumericQuestionTest extends FlatSpec with Matchers {
  "Numeric answer" can "be constructed" in {
    val answer = new NumericAnswer(110, BigDecimal("11.11"), BigDecimal("12.34"))
    answer.id should equal(110)
    answer.notLessThan should equal(BigDecimal("11.11"))
    answer.notGreaterThan should equal(BigDecimal("12.34"))
  }

  private def someAnswers = Seq(
    new NumericAnswer(110, BigDecimal("11.11"), BigDecimal("12.34")),
    new NumericAnswer(100, BigDecimal("0"), BigDecimal("0"))
  )

  private def constructQuestion(categoryId: Option[Int], answers: Seq[NumericAnswer]) = new NumericQuestion(
    id = 5,
    categoryID = categoryId,
    title = "Nice numbers",
    text = "What numbers are nice?",
    explanationText = "Yeees that's a nice one",
    answers = answers,
    courseID = Some(1)
  )

  private def checkFields(question: NumericQuestion, categoryId: Option[Int], answers: Seq[NumericAnswer]) {
    question.questionTypeCode should equal(2)
    question.id should equal(5)
    question.categoryID should equal(categoryId)
    question.title should equal("Nice numbers")
    question.text should equal("What numbers are nice?")
    question.explanationText should equal("Yeees that's a nice one")
    question.answers should equal(answers)
  }

  "Numeric question" can "be constructed" in {
    val answers = someAnswers
    val question = constructQuestion(categoryId = Some(3), answers = answers)
    checkFields(question, categoryId = Some(3), answers = answers)
  }

  it can "be constructed with empty category" in {
    val answers = someAnswers
    val question = constructQuestion(categoryId = None, answers = answers)
    checkFields(question, categoryId = None, answers = answers)
  }

  it can "be constructed without answers" in {
    val question = constructQuestion(categoryId = Some(3), answers = Nil)
    checkFields(question, categoryId = Some(3), answers = Nil)
  }

}
