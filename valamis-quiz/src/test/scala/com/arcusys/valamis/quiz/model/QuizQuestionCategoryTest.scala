package com.arcusys.learn.quiz.model

import com.arcusys.valamis.quiz.model.QuizQuestionCategory
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class QuizQuestionCategoryTest extends FlatSpec with ShouldMatchers {
  "Quiz question category" can "be constructed" in {
    val category = new QuizQuestionCategory(1, "titl", "descr", quizID = 12, parentID = Some(3))
    category.id should equal(1)
    category.title should equal("titl")
    category.description should equal("descr")
    category.quizID should equal(12)
    category.parentID should equal(Some(3))
  }

  it can "be constructed with empty parent" in {
    val category = new QuizQuestionCategory(1, "titl", "descr", quizID = 12, parentID = None)
    category.id should equal(1)
    category.title should equal("titl")
    category.description should equal("descr")
    category.quizID should equal(12)
    category.parentID should equal(None)
  }
}
