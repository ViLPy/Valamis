package com.arcusys.learn.scorm.manifest.storage.impl.orbroker

import org.junit._
import Assert._
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.storage.impl.orbroker.ParameterizedUnitTests
import runner.RunWith
import runners.Parameterized
import scala.Some
import com.arcusys.learn.scorm.manifest.storage.PackagesStorage
import com.arcusys.learn.scorm.manifest.storage.impl.ActivitiesStorageJUnitMethods

@RunWith(value = classOf[Parameterized])
@Ignore
class ActivitiesStorageTest(dbFileName: String) extends ParameterizedUnitTests(dbFileName) with ActivitiesStorageJUnitMethods {
  val packagesStorage: PackagesStorage = new PackagesStorageImpl
  val activitiesStorage = new ActivitiesStorageImpl
}