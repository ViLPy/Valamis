package com.arcusys.learn.scorm.tracking.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.ParameterizedUnitTests
import com.arcusys.learn.scorm.manifest.storage.impl.orbroker.PackagesStorageImpl
import com.arcusys.learn.scorm.tracking.storage.AttemptStorageJUnit

import org.junit._
import runner.RunWith
import runners.Parameterized


@RunWith(value = classOf[Parameterized])
class AttemptStorageTest(dbFileName: String) extends ParameterizedUnitTests(dbFileName)
                                             with AttemptStorageJUnit {
  val packagesStorage = new PackagesStorageImpl
  val attemptStorage = new AttemptStorageImpl
  val userStorage = new UserStorageImpl
}