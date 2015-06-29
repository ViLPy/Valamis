package com.arcusys.valamis.user.storage

import com.arcusys.valamis.user.model.User

trait UserStorage {
  def getAll: Seq[User]
  def getByID(userID: Int): Option[User]
  def getByName(name: String): Seq[User]
  def createAndGetID(user: User): Int
  def modify(user: User)
  def delete(userID: Int)
  def getUsersWithAttempts: Seq[User]
  def getUsersWithAttemptsInPackage(packageId: Long): Seq[User]
  def renew()
}
