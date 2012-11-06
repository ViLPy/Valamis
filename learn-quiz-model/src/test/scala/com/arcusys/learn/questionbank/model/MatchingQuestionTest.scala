package com.arcusys.learn.questionbank.model

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class MatchingQuestionTest extends FlatSpec with ShouldMatchers {
  "Matching answer" can "be constructed" in {
    val answer = new MatchingAnswer(17, "C#", Some("Microsoft"))
    answer.id should equal(17)
    answer.text should equal("C#")
    answer.keyText should equal(Some("Microsoft"))
  }
  it can "be constructed with empty answer category" in {
    val answer = new MatchingAnswer(17, "C#", None)
    answer.id should equal(17)
    answer.text should equal("C#")
    answer.keyText should equal(None)
  }
  private def someAnswers = Seq(
    new MatchingAnswer(17, "C#", Some("Microsoft")),
    new MatchingAnswer(19, "Java", Some("Oracle")),
    new MatchingAnswer(18, "Scala", None)
  )

  private def constructQuestion(categoryId: Option[Int], answers: Seq[MatchingAnswer]) = new MatchingQuestion(
    id = 555,
    categoryID = categoryId,
    title = "Language owners",
    text = "Which languages do these companies owe?",
    explanationText = "Yep, Scala is not owned by these companies",
    answers = answers
  )

  private def checkFields(question: MatchingQuestion, categoryId: Option[Int], answers: Seq[MatchingAnswer]) {
    question.questionTypeCode should equal(4)
    question.id should equal(555)
    question.categoryID should equal(categoryId)
    question.title should equal("Language owners")
    question.text should equal("Which languages do these companies owe?")
    question.explanationText should equal("Yep, Scala is not owned by these companies")
    question.answers should equal(answers)
  }

  "Matching question" can "be constructed" in {
    val answers = someAnswers
    val question = constructQuestion(categoryId = Some(4), answers = answers)
    checkFields(question, categoryId = Some(4), answers = answers)
  }

  it can "be constructed with empty category" in {
    val answers = someAnswers
    val question = constructQuestion(categoryId = None, answers = answers)
    checkFields(question, categoryId = None, answers = answers)
  }

  it can "be constructed without answers" in {
    val question = constructQuestion(categoryId = Some(4), answers = Nil)
    checkFields(question, categoryId = Some(4), answers = Nil)
  }
}
