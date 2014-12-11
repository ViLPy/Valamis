package com.arcusys.learn.scorm.tracking.storage

import com.arcusys.learn.scorm.tracking.model._
import com.arcusys.learn.scorm.manifest.model._

trait AttemptStorage {
  def getActive(userID: Int, packageID: Int): Option[Attempt]
  def getAllComplete(userID: Int, packageID: Int): Seq[Attempt]
  def getByID(id: Int): Option[Attempt]
  def getLast(userID: Int, packageID: Int, complete: Boolean = false): Option[Attempt]
  def createAndGetID(userID: Int, packageID: Int, organizationID: String): Int
  def markAsComplete(id: Int)
  def checkIfComplete(userID: Int, packageID: Int): Boolean
  def renew()
}
