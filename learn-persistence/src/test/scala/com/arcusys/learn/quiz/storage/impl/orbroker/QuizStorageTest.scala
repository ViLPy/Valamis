package com.arcusys.learn.quiz.storage.impl.orbroker

import org.junit._
import Assert._
import com.arcusys.learn.quiz.model._
import com.arcusys.learn.storage.impl.orbroker.ParameterizedUnitTests
import runner.RunWith
import runners.Parameterized

@RunWith(value = classOf[Parameterized])
class QuizStorageTest(dbFileName: String) extends ParameterizedUnitTests(dbFileName){
  val quizStorage = new QuizStorageImpl

  @Before
  def setUp() {
    quizStorage.renew()
  }

  @Test
  def noDataInitially() {
    assertEquals(0, quizStorage.getAll.size)
  }

  @Test
  def canCreate() {
    quizStorage.createAndGetID(new Quiz(0, "title1", "description1", "welcome", "final"))
    quizStorage.createAndGetID(new Quiz(1, "title2", "description2", "welcome", "final"))
    assertEquals(2, quizStorage.getAll.size)
  }

  @Test
  def canGetByID() {
    val testQuizId = quizStorage.createAndGetID(new Quiz(0, "title1", "description1", "welcome", "final"))
    val fetchedQuiz = quizStorage.getByID(testQuizId).get
    assertEquals("title1", fetchedQuiz.title)
    assertEquals("description1", fetchedQuiz.description)
  }

  @Test
  def canUpdate() {
    val testQuizId = quizStorage.createAndGetID(new Quiz(0, "title1", "description1", "welcome", "final"))
    quizStorage.modify(new Quiz(testQuizId, "titleTest", "description1", "welcome", "final"))
    val fetchedQuiz = quizStorage.getByID(testQuizId).get
    assertEquals("titleTest", fetchedQuiz.title)
  }

  @Test
  def canDelete() {
    quizStorage.createAndGetID(new Quiz(0, "title1", "description1", "welcome", "final"))
    quizStorage.createAndGetID(new Quiz(1, "title2", "description2", "welcome", "final"))
    val testQuizId = quizStorage.createAndGetID(new Quiz(2, "title2", "description", "welcome", "final"))

    assertEquals(3, quizStorage.getAll.size)

    quizStorage.delete(testQuizId)

    assertEquals(2, quizStorage.getAll.size)
  }
}