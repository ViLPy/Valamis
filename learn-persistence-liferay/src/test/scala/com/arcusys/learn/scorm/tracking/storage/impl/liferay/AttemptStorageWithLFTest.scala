package com.arcusys.learn.scorm.tracking.storage.impl.liferay

import com.arcusys.learn.scorm.tracking.storage.AttemptStorageJUnit
import com.arcusys.learn.storage.impl.liferay.LFStorages
import org.junit.{Ignore, Test}

class AttemptStorageWithLFTest extends AttemptStorageJUnit {
  val packagesStorage = LFStorages.packageStorage
  val attemptStorage = LFStorages.attemptStorage
  val userStorage = LFStorages.userStorage
}
