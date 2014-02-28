package com.arcusys.learn.quiz.storage.impl.liferay

import com.arcusys.learn.quiz.storage.QuizQuestionStorageJUnitMethods
import com.arcusys.learn.storage.impl.liferay.LFStorages
import org.junit.Ignore

/**
 * User: dkudinov
 * Date: 15.3.2013
 */
class QuizQuestionStorageWithLFTest extends QuizQuestionStorageJUnitMethods {
  val quizStorage = LFStorages.quizStorage
  val quizCategoryStorage = LFStorages.quizCategoryStorage
  val quizQuestionStorage = LFStorages.quizQuestionStorage
  val answerStorage = LFStorages.answerStorage
  val questionCategoryStorage = LFStorages.questionCategoryStorage
  val questionStorage = LFStorages.questionStorage
}


