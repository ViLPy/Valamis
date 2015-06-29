package com.arcusys.valamis.questionbank.model

import org.scalatest.{ FlatSpec, Matchers }

class ChoiceQuestionTest extends FlatSpec with Matchers {
  "Choice answer" can "be constructed" in {
    val answer = new ChoiceAnswer(11, "Scala", isCorrect = true)
    answer.id should equal(11)
    answer.text should equal("Scala")
    answer.isCorrect should equal(true)
  }

  private def someAnswers = Seq(
    new ChoiceAnswer(11, "Scala", isCorrect = true),
    new ChoiceAnswer(2, "Java", isCorrect = false),
    new ChoiceAnswer(33, "C#", isCorrect = true)
  )

  private def constructQuestion(categoryId: Option[Int], answers: Seq[ChoiceAnswer]) = new ChoiceQuestion(
    id = 11,
    categoryID = categoryId,
    title = "Check programming language taste",
    text = "Which programming language is good",
    explanationText = "You know why",
    rightAnswerText = "Your answer is correct",
    wrongAnswerText = "Your answer is incorrect",
    answers = answers,
    forceCorrectCount = false,
    courseID = Some(1)
  )

  private def checkFields(question: ChoiceQuestion, categoryId: Option[Int], answers: Seq[ChoiceAnswer]) {
    question.questionTypeCode should equal(0)
    question.id should equal(11)
    question.categoryID should equal(categoryId)
    question.title should equal("Check programming language taste")
    question.text should equal("Which programming language is good")
    question.explanationText should equal("You know why")
    question.rightAnswerText should equal("Your answer is correct")
    question.wrongAnswerText should equal("Your answer is incorrect")
    question.forceCorrectCount should equal(false)
    question.answers should equal(answers)
  }

  "Choice question" can "be constructed" in {
    val answers = someAnswers
    val question = constructQuestion(categoryId = Some(2), answers = answers)
    checkFields(question, categoryId = Some(2), answers = answers)
  }

  it can "be constructed with empty category" in {
    val answers = someAnswers
    val question = constructQuestion(categoryId = None, answers = answers)
    checkFields(question, categoryId = None, answers = answers)
  }

  it can "be constructed without answers" in {
    val question = constructQuestion(categoryId = Some(2), answers = Nil)
    checkFields(question, categoryId = Some(2), answers = Nil)
  }

}
