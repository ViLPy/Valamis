package com.arcusys.learn.scorm.tracking.storage.impl.orbroker

import com.arcusys.learn.scorm.tracking.model.User
import com.arcusys.learn.storage.impl.orbroker.KeyedEntityStorageImpl
import com.arcusys.learn.scorm.tracking.storage._
import org.orbroker.Row

class UserStorageImpl extends KeyedEntityStorageImpl[User]("User", "id") with UserStorage {
  def extract(row: Row) = User(
    row.integer("id").get,
    row.string("username").get,
    row.real("preferredAudioLevel").get,
    row.string("preferredLanguage").get,
    row.real("preferredDeliverySpeed").get,
    row.integer("preferredAudioCaptioning").get
  )
}
