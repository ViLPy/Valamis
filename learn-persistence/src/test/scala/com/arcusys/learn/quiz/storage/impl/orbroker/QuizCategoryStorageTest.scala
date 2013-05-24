package com.arcusys.learn.quiz.storage.impl.orbroker

import org.junit._
import runner.RunWith
import runners.Parameterized
import com.arcusys.learn.storage.impl.orbroker.ParameterizedUnitTests
import com.arcusys.learn.quiz.storage.impl.QuizCategoryStorageJUnitMethods

@RunWith(value = classOf[Parameterized])
class QuizCategoryStorageTest(dbFileName: String) extends ParameterizedUnitTests(dbFileName) with QuizCategoryStorageJUnitMethods {
  val quizStorage = new QuizStorageImpl
  val quizCategoryStorage = new QuizQuestionCategoryStorageImpl

}
