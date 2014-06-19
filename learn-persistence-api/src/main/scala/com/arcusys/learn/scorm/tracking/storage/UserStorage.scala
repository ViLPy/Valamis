package com.arcusys.learn.scorm.tracking.storage

import com.arcusys.learn.scorm.tracking.model.User

trait UserStorage {
  def getAll: Seq[User]
  def getByID(userID: Int): Option[User]
  def createAndGetID(user: User): Int
  def modify(user: User)
  def delete(userID: Int)
  def getUsersWithAttempts: Seq[User]
  def getUsersWithAttemptsInPackage(packageID: Int): Seq[User]
  def renew()
}
