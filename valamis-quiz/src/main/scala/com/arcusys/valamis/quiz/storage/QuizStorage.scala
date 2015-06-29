package com.arcusys.valamis.quiz.storage

import com.arcusys.valamis.quiz.model.Quiz

trait QuizStorage {
  def getAll: Seq[Quiz]
  def getByCourseID(courseID: Option[Int]): Seq[Quiz]
  def getByID(id: Int): Option[Quiz]
  def createAndGetID(entity: Quiz): Int
  def delete(id: Int)
  def modify(entity: Quiz)
  def renew()
}
