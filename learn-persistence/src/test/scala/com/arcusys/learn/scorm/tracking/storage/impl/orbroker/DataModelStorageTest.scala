package com.arcusys.learn.scorm.tracking.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.ParameterizedUnitTests
import com.arcusys.learn.scorm.manifest.storage.impl.orbroker.{PackagesStorageImpl, ActivitiesStorageImpl}
import com.arcusys.learn.scorm.tracking.storage.DataModelStorageJUnit

import org.junit._
import runner.RunWith
import runners.Parameterized


@RunWith(value = classOf[Parameterized])
class DataModelStorageTest(dbFileName: String) extends ParameterizedUnitTests(dbFileName)
                                               with DataModelStorageJUnit {
  val dataModelStorage = new DataModelStorageImpl
  val packagesStorage = new PackagesStorageImpl
  val attemptStorage = new AttemptStorageImpl
  val activityStorage = new ActivitiesStorageImpl
  val userStorage = new UserStorageImpl
}