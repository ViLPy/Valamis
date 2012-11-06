package com.arcusys.learn.questionbank.model

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class QuestionCategoryTest extends FlatSpec with ShouldMatchers {
  "Question bank question category entity" can "be constructed" in {
    val category = new QuestionCategory(1, "t", "d", Some(12))
    category.id should equal(1)
    category.title should equal("t")
    category.description should equal("d")
    category.parentID should equal(Some(12))
  }
  it can "be constructed with empty parent" in {
    val category = new QuestionCategory(1, "t", "d", None)
    category.id should equal(1)
    category.title should equal("t")
    category.description should equal("d")
    category.parentID should equal(None)
  }

}
