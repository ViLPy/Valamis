package com.arcusys.valamis.questionbank.model

import org.scalatest.{ FlatSpec, Matchers }

class EssayQuestionTest extends FlatSpec with Matchers {
  "Essay question" can "be constructed" in {
    val question = new EssayQuestion(
      id = 1,
      categoryID = Some(2),
      title = "Test",
      text = "Write an essay",
      explanationText = "A good essay should just look nice!",
      courseID = Some(1)
    )
    question.questionTypeCode should equal(5)
    question.id should equal(1)
    question.categoryID should equal(Some(2))
    question.title should equal("Test")
    question.text should equal("Write an essay")
    question.explanationText should equal("A good essay should just look nice!")
  }

  it can "be constructed with empty category" in {
    val question = new EssayQuestion(
      id = 1,
      categoryID = None,
      title = "Test",
      text = "Write an essay",
      explanationText = "A good essay should just look nice!",
      courseID = Some(1)
    )
    question.questionTypeCode should equal(5)
    question.id should equal(1)
    question.categoryID should equal(None)
    question.title should equal("Test")
    question.text should equal("Write an essay")
    question.explanationText should equal("A good essay should just look nice!")
  }

}
