package com.arcusys.learn.quiz.storage

import com.arcusys.learn.quiz.model._

trait QuizStorage {
  def getAll: Seq[Quiz]
  def getByCourseID(courseID: Option[Int]): Seq[Quiz]
  def getByID(id: Int): Option[Quiz]
  def createAndGetID(entity: Quiz): Int
  def delete(id: Int)
  def modify(entity: Quiz)
}
