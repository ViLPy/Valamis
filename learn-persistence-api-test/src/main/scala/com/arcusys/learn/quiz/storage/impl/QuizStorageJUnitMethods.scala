package com.arcusys.learn.quiz.storage.impl

import com.arcusys.learn.quiz.model.Quiz
import com.arcusys.learn.quiz.storage.QuizStorage

import org.junit.Test
import org.junit.Assert._

trait QuizStorageJUnitMethods {
  def quizStorage: QuizStorage

  @Test
  def noDataInitially() {
    assertEquals(0, quizStorage.getAll.size)
  }

  @Test
  def canCreate() {
    quizStorage.createAndGetID(new Quiz(0, "title1", "description1", "welcome", "final", None, ""))
    quizStorage.createAndGetID(new Quiz(1, "title2", "description2", "welcome", "final", None, ""))
    assertEquals(2, quizStorage.getAll.size)
  }

  @Test
  def canGetByID() {
    val testQuizId = quizStorage.createAndGetID(new Quiz(0, "title1", "description1", "welcome", "final", None, ""))
    val fetchedQuiz = quizStorage.getByID(testQuizId).get
    assertEquals("title1", fetchedQuiz.title)
    assertEquals("description1", fetchedQuiz.description)
  }

  @Test
  def canUpdate() {
    val testQuizId = quizStorage.createAndGetID(new Quiz(0, "title1", "description1", "welcome", "final", None, ""))
    quizStorage.modify(new Quiz(testQuizId, "titleTest", "description1", "welcome", "final", None, ""))
    val fetchedQuiz = quizStorage.getByID(testQuizId).get
    assertEquals("titleTest", fetchedQuiz.title)
  }

  @Test
  def canDelete() {
    quizStorage.createAndGetID(new Quiz(0, "title1", "description1", "welcome", "final", None, ""))
    quizStorage.createAndGetID(new Quiz(1, "title2", "description2", "welcome", "final", None, ""))
    val testQuizId = quizStorage.createAndGetID(new Quiz(2, "title2", "description", "welcome", "final", None, ""))

    assertEquals(3, quizStorage.getAll.size)

    quizStorage.delete(testQuizId)

    assertEquals(2, quizStorage.getAll.size)
  }
}
