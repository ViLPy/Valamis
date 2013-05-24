package com.arcusys.learn.scorm.tracking.storage.impl

import com.arcusys.learn.storage.impl.{EntityStorageExt, KeyedEntityStorageExt}
import com.arcusys.learn.scorm.tracking.model.{User, Attempt}
import com.arcusys.learn.scorm.tracking.storage.{UserStorage, AttemptStorage}
import com.arcusys.learn.scorm.manifest.storage.PackagesStorage

trait AttemptFieldsMapper {
  def id: Int

  def userID: Int

  def packageID: Int

  def organizationID: String

  def isComplete: Boolean
}

trait AttemptCreator {
  def userStorage: UserStorage

  def createAttempt(mapper: AttemptFieldsMapper): Attempt = {
    Attempt(
      mapper.id,
      userStorage.getByID(mapper.userID).getOrElse(throw new Exception("User not found!")),
      mapper.packageID,
      mapper.organizationID,
      mapper.isComplete)
  }
}

trait AttemptEntityStorage extends AttemptStorage with KeyedEntityStorageExt[Attempt] with EntityStorageExt[Attempt] {
  def userStorage: UserStorage

  def packageStorage: PackagesStorage

  def getActive(userID: Int, packageID: Int) = getOne("userID" -> userID, "packageID" -> packageID, "isComplete" -> false)

  def getLast(userID: Int, packageID: Int, complete: Boolean = false) = getOne("userID" -> userID, "packageID" -> packageID, "getLast" -> true, "isComplete" -> complete)

  def createAndGetID(userID: Int, packageID: Int, organizationID: String) = createAndGetID(Attempt(0, User(userID), packageID, organizationID, isComplete = false))

  def markAsComplete(id: Int) {
    execute("_setcomplete", "id" -> id, "isComplete" -> true)
  }

  def checkIfComplete(userID: Int, packageID: Int) = {
    val attempt = getAll("userID" -> userID, "packageID" -> packageID, "isComplete" -> true)
    !attempt.isEmpty
  }
}
