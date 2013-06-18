package com.arcusys.learn.quiz.model

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class QuizTest extends FlatSpec with ShouldMatchers {
  "Quiz entity" can "be constructed" in {
    val quiz = new Quiz(1, "tit", "desc", "welcome", "final", None)
    quiz.id should equal(1)
    quiz.title should equal("tit")
    quiz.description should equal("desc")
    quiz.welcomePageContent should equal("welcome")
    quiz.finalPageContent should equal("final")
  }
}
