package com.arcusys.learn.scorm.tracking.storage.impl

import com.arcusys.learn.scorm.tracking.model.User
import com.arcusys.learn.storage.impl.EntityStorageExt
import com.arcusys.learn.scorm.tracking.storage.UserStorage

/**
 * User: Yulia.Glushonkova
 * Date: 28.03.13
 */
@deprecated
trait UserEntityStorage extends UserStorage with EntityStorageExt[User] {
  def createAndGetID(user: User): Int = {
    create(user)
    user.id
  }

  def getByID(userID: Int): Option[User] = getOne("id" -> userID)

  def delete(userID: Int) {
    delete("id" -> userID)
  }

  //TODO: review the query for effectiveness (DISTINCT detected)
  def getUsersWithAttempts: Seq[User] = {
    getAll("_users")
  }

  //TODO: review the query for effectiveness (DISTINCT detected)
  def getUsersWithAttemptsInPackage(packageID: Int): Seq[User] = {
    getAll("_users", "packageID" -> packageID)
  }

}
