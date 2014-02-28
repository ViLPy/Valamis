package com.arcusys.learn.scorm.tracking.storage.impl.liferay

import com.arcusys.learn.scorm.tracking.storage.UserStorageJUnit
import com.arcusys.learn.storage.impl.liferay.LFStorages

import org.junit.Ignore
import com.arcusys.learn.scorm.tracking.model.User

class UserStorageWithLFTest extends UserStorageJUnit {
  val userStorage = LFStorages.userStorage
}
