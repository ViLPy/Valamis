package com.arcusys.learn.quiz.storage.impl.orbroker

import org.junit._
import com.arcusys.learn.storage.impl.orbroker.ParameterizedUnitTests
import com.arcusys.learn.questionbank.storage.impl.orbroker._
import runner.RunWith
import runners.Parameterized
import com.arcusys.learn.quiz.storage.QuizQuestionStorageJUnitMethods

@RunWith(value = classOf[Parameterized])
class QuizQuestionStorageTest(dbFileName: String) extends ParameterizedUnitTests(dbFileName) with QuizQuestionStorageJUnitMethods {
  val quizStorage = new QuizStorageImpl
  val quizCategoryStorage = new QuizQuestionCategoryStorageImpl
  val quizQuestionStorage = new QuizQuestionStorageImpl
  val answerStorage = new AnswerStorageImpl
  val questionCategoryStorage = new QuestionCategoryStorageImpl
  val questionStorage = new QuestionStorageImpl
}

