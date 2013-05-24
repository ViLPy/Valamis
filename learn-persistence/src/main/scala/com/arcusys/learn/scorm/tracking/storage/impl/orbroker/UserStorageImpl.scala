package com.arcusys.learn.scorm.tracking.storage.impl.orbroker

import com.arcusys.learn.scorm.tracking.model.User
import com.arcusys.learn.storage.impl.orbroker.GenericEntityStorageImpl
import org.orbroker.{RowExtractor, Row}
import com.arcusys.learn.scorm.tracking.storage.impl.UserEntityStorage

class UserStorageImpl extends GenericEntityStorageImpl[User]("User") with UserEntityStorage with UserExtractor

trait UserExtractor extends RowExtractor[User] {
  def extract(row: Row) = User(
    row.integer("id").get,
    row.string("username").get,
    row.real("preferredAudioLevel").get,
    row.string("preferredLanguage").get,
    row.real("preferredDeliverySpeed").get,
    row.integer("preferredAudioCaptioning").get
  )
}
