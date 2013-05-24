package com.arcusys.learn.scorm.tracking.storage.impl.liferay

import com.arcusys.learn.scorm.tracking.storage.DataModelStorageJUnit
import com.arcusys.learn.storage.impl.liferay.LFStorages

import org.junit.Ignore

class DataModelStorageWithTest extends DataModelStorageJUnit {
  val dataModelStorage = LFStorages.dataModelStorage
  val packagesStorage = LFStorages.packageStorage
  val attemptStorage = LFStorages.attemptStorage
  val activityStorage = LFStorages.activityStorage
  val userStorage = LFStorages.userStorage
}
