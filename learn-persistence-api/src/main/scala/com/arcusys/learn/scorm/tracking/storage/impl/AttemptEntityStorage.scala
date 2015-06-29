package com.arcusys.learn.scorm.tracking.storage.impl

import com.arcusys.learn.storage.impl.{ EntityStorageExt, KeyedEntityStorageExt }
import com.arcusys.valamis.lesson.scorm.model.tracking.Attempt
import com.arcusys.valamis.lesson.scorm.storage.ScormPackagesStorage
import com.arcusys.valamis.lesson.scorm.storage.tracking.AttemptStorage
import com.arcusys.valamis.user.model.User
import com.arcusys.valamis.user.storage.UserStorage

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
      userStorage.getByID(mapper.userID).getOrElse(new User(mapper.userID, "guest")), //.getOrElse(throw new Exception("User not found!")),
      mapper.packageID,
      mapper.organizationID,
      mapper.isComplete)
  }
}
