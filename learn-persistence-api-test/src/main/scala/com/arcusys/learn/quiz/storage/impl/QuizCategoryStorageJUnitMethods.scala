package com.arcusys.learn.quiz.storage.impl

import org.junit._
import Assert._
import com.arcusys.learn.quiz.model._
import com.arcusys.learn.quiz.storage.{QuizStorage, QuizQuestionCategoryStorage}

/**
 * User: dkudinov
 * Date: 19.3.2013
 */
trait QuizCategoryStorageJUnitMethods {
  def quizCategoryStorage: QuizQuestionCategoryStorage
  def quizStorage: QuizStorage

  @Before
  def setUp() {
    quizStorage.renew()
    quizCategoryStorage.renew()
  }

  @Test
  def noDataInitially() {
    assertEquals(0, quizCategoryStorage.getAll.size)
  }

  @Test
  def canCreate() {
    val quizId = quizStorage.createAndGetID(new Quiz(0, "title1", "description1", "welcome", "final", None))
    quizCategoryStorage.createAndGetID(new QuizQuestionCategory(0, "title1", "description1", quizId, None))
    quizCategoryStorage.createAndGetID(new QuizQuestionCategory(1, "title2", "description2", quizId, None))
    assertEquals(2, quizCategoryStorage.getAll.size)
  }

  @Test
  def canGetByID() {
    val quizId = quizStorage.createAndGetID(new Quiz(0, "title1", "description1", "welcome", "final", None))
    val testCategoryId = quizCategoryStorage.createAndGetID(new QuizQuestionCategory(0, "title1", "description1", quizId, None))
    val fetchedCategory = quizCategoryStorage.getByID(testCategoryId).get
    assertEquals("title1", fetchedCategory.title)
    assertEquals("description1", fetchedCategory.description)
  }

  @Test
  def canUpdate() {
    val quizId = quizStorage.createAndGetID(new Quiz(0, "title1", "description1", "welcome", "final", None))
    val testCategoryId = quizCategoryStorage.createAndGetID(new QuizQuestionCategory(0, "title1", "description1", quizId, None))
    quizCategoryStorage.modify(testCategoryId, "titleTest", "description1")
    val fetchedCategory = quizCategoryStorage.getByID(testCategoryId).get
    assertEquals("titleTest", fetchedCategory.title)
  }

  @Test
  def canDelete() {
    val quizId = quizStorage.createAndGetID(new Quiz(0, "title1", "description1", "welcome", "final", None))
    quizCategoryStorage.createAndGetID(new QuizQuestionCategory(0, "title1", "description1", quizId, None))
    quizCategoryStorage.createAndGetID(new QuizQuestionCategory(1, "title2", "description3", quizId, None))
    val testCategoryId = quizCategoryStorage.createAndGetID(new QuizQuestionCategory(2, "title3", "description3", quizId, None))

    assertEquals(3, quizCategoryStorage.getAll.size)

    quizCategoryStorage.delete(testCategoryId)

    assertEquals(2, quizCategoryStorage.getAll.size)
  }

  @Test
  def canCascadeDeleteByQuiz() {
    val quizId = quizStorage.createAndGetID(new Quiz(0, "title1", "description1", "welcome", "final", None))
    quizCategoryStorage.createAndGetID(new QuizQuestionCategory(0, "title1", "description1", quizId, None))
    quizCategoryStorage.createAndGetID(new QuizQuestionCategory(1, "title2", "description3", quizId, None))
    val testCategoryId = quizCategoryStorage.createAndGetID(new QuizQuestionCategory(2, "title3", "description3", quizId, None))
    assertEquals(3, quizCategoryStorage.getAll.size)
    quizStorage.delete(quizId)
    assertEquals(0, quizStorage.getAll.size)
    assertEquals(0, quizCategoryStorage.getAll.size)
  }

  @Test
  def canCascadeDeleteByCategory() {
    val quizId = quizStorage.createAndGetID(new Quiz(0, "title1", "description1", "welcome", "final", None))
    val testCategoryId = quizCategoryStorage.createAndGetID(new QuizQuestionCategory(2, "title3", "description3", quizId, None))
    quizCategoryStorage.createAndGetID(new QuizQuestionCategory(0, "title1", "description1", quizId, Some(testCategoryId)))
    quizCategoryStorage.createAndGetID(new QuizQuestionCategory(1, "title2", "description3", quizId, Some(testCategoryId)))

    assertEquals(3, quizCategoryStorage.getAll.size)

    quizCategoryStorage.delete(testCategoryId)

    assertEquals(0, quizCategoryStorage.getAll.size)
  }
}
