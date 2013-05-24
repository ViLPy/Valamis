package com.arcusys.learn.quiz.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.ParameterizedUnitTests
import com.arcusys.learn.quiz.storage.impl.QuizStorageJUnitMethods

import org.junit._
import runner.RunWith
import runners.Parameterized

@RunWith(value = classOf[Parameterized])
class QuizStorageTest(dbFileName: String) extends ParameterizedUnitTests(dbFileName) with QuizStorageJUnitMethods {
  val quizStorage = new QuizStorageImpl

  @Before
  def setUp() {
    quizStorage.renew()
  }

}