package com.arcusys.learn.scorm.tracking.storage.impl.orbroker

import com.arcusys.learn.scorm.tracking.model.User
import com.arcusys.learn.storage.impl.orbroker.GenericEntityStorageImpl
import com.arcusys.learn.scorm.tracking.storage._
import org.orbroker.Row

class UserStorageImpl extends GenericEntityStorageImpl[User]("User") with UserStorage {
  def createAndGetID(user: User): Int = {
    create(user)
    user.id
  }

  def getByID(userID: Int): Option[User] = getOne("id"->userID)

  def delete(userID: Int) {
    delete("id"->userID)
  }

  def extract(row: Row) = User(
    row.integer("id").get,
    row.string("username").get,
    row.real("preferredAudioLevel").get,
    row.string("preferredLanguage").get,
    row.real("preferredDeliverySpeed").get,
    row.integer("preferredAudioCaptioning").get
  )
}
