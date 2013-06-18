package com.arcusys.learn.scorm.tracking.storage

import com.arcusys.learn.scorm.tracking.model.User

import org.junit.Assert._
import org.junit.{Test, Before}


trait UserStorageJUnit {
  def userStorage: UserStorage

  @Before
  def setUp() {
    userStorage.renew()
  }

  @Test
  def noDataInitially() {
    // should be one guest
    assertEquals(1, userStorage.getAll.size)
  }

  @Test
  def canCreate() {
    userStorage.createAndGetID(User(0, "user1"))
    userStorage.createAndGetID(User(1, "user2"))
    // should be one guest
    assertEquals(3, userStorage.getAll.size)
  }

  @Test
  def canGetByID() {
    val user = User(0, "user1")
    val testQuizId = userStorage.createAndGetID(user)
    assertEquals(user.id, testQuizId)
    val fetchedQuiz = userStorage.getByID(testQuizId).get
    assertEquals(user, fetchedQuiz)
    assertEquals("user1", fetchedQuiz.name)
  }

  @Test
  def canUpdate() {
    val user = User(0, "user1")
    val testQuizId = userStorage.createAndGetID(user)
    assertEquals(user.id, testQuizId)
    userStorage.modify(user.copy(name="user test"))
    val fetchedQuiz = userStorage.getByID(testQuizId).get
    assertEquals("user test", fetchedQuiz.name)
  }

  @Test
  def canDelete() {
    // should be one guest
    val user1 = User(0, "user1")
    val user2 = User(1, "user2")
    val user3 = User(2, "user3")
    userStorage.createAndGetID(user1)
    userStorage.createAndGetID(user2)
    val testQuizId = userStorage.createAndGetID(user3)

    assertEquals(4, userStorage.getAll.size)

    userStorage.delete(testQuizId)

    assertEquals(3, userStorage.getAll.size)
  }
}
