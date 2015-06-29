package com.arcusys.valamis.lesson.scorm.storage.tracking

import com.arcusys.valamis.lesson.scorm.model.tracking.Attempt

trait AttemptStorage {
  def getActive(userID: Int, packageId: Long): Option[Attempt]
  def getAllComplete(userID: Int, packageId: Long): Seq[Attempt]
  def getByID(id: Long): Option[Attempt]
  def getLast(userID: Int, packageId: Long, complete: Boolean = false): Option[Attempt]
  def createAndGetID(userID: Int, packageId: Long, organizationID: String): Long
  def markAsComplete(id: Long)
  def checkIfComplete(userID: Int, packageId: Long): Boolean
  def renew()
}
