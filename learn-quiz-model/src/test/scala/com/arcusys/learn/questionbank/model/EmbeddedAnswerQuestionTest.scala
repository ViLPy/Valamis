package com.arcusys.learn.questionbank.model

import org.scalatest.{ Matchers, FlatSpec }
import org.junit.runner.RunWith

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class EmbeddedAnswerQuestionTest extends FlatSpec with Matchers {
  "Embedded answer question" can "be constructed" in {
    val question = new EmbeddedAnswerQuestion(
      id = 1,
      categoryID = Some(2),
      title = "Embed",
      text = "Embed something",
      explanationText = "Nobody knows what this is",
      courseID = Some(1)
    )
    question.questionTypeCode should equal(6)
    question.id should equal(1)
    question.categoryID should equal(Some(2))
    question.title should equal("Embed")
    question.text should equal("Embed something")
    question.explanationText should equal("Nobody knows what this is")
  }

  it can "be constructed with empty category" in {
    val question = new EmbeddedAnswerQuestion(
      id = 1,
      categoryID = None,
      title = "Embed",
      text = "Embed something",
      explanationText = "Nobody knows what this is",
      courseID = Some(1)
    )
    question.questionTypeCode should equal(6)
    question.id should equal(1)
    question.categoryID should equal(None)
    question.title should equal("Embed")
    question.text should equal("Embed something")
    question.explanationText should equal("Nobody knows what this is")
  }
}
