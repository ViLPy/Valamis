package com.arcusys.learn.scorm.tracking.storage

import com.arcusys.learn.scorm.tracking.model._
import com.arcusys.learn.scorm.manifest.model._

trait AttemptStorage
{
  def getAll(userID: Int, packageID: Int): Seq[Attempt]
  def getActive(userID: Int, packageID: Int): Option[Attempt]
  def getLast(userID: Int, packageID: Int, complete: Boolean = false): Option[Attempt]
  def createAndGetID(userID: Int, packageID: Int, organizationID:String): Int
  def markAsComplete(id: Int)
  def getPackagesWithAttempts: Seq[Manifest]
  def getPackagesWithUserAttempts(userID: Int): Seq[Manifest]
  def getUsersWithAttempts: Seq[User]
  def getUsersWithAttemptsInPackage(packageID: Int): Seq[User]
}
