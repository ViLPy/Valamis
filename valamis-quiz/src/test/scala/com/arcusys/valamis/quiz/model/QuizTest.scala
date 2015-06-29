package com.arcusys.learn.quiz.model

import com.arcusys.valamis.quiz.model.Quiz
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class QuizTest extends FlatSpec with ShouldMatchers {
  "Quiz entity" can "be constructed" in {
    val quiz = new Quiz(1, "tit", "desc", "welcome", "final", None, "", None)
    quiz.id should equal(1)
    quiz.title should equal("tit")
    quiz.description should equal("desc")
    quiz.welcomePageContent should equal("welcome")
    quiz.finalPageContent should equal("final")
  }
}
