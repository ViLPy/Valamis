package com.arcusys.learn.quiz.storage.impl.liferay

import com.arcusys.learn.quiz.storage.impl.QuizCategoryStorageJUnitMethods
import com.arcusys.learn.storage.impl.liferay.LFStorages
import org.junit.{Test, Ignore}

/**
 * User: dkudinov
 * Date: 19.3.2013
 */
class QuizQuestionCategoryStorageWithLFTest extends QuizCategoryStorageJUnitMethods {
  val quizCategoryStorage = LFStorages.quizCategoryStorage
  val quizStorage = LFStorages.quizStorage
}
