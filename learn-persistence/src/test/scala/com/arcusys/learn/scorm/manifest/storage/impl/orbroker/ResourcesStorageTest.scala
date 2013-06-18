package com.arcusys.learn.scorm.manifest.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.ParameterizedUnitTests
import com.arcusys.learn.scorm.manifest.storage.impl.ResourcesStorageJUnit

import org.junit._
import runner.RunWith
import runners.Parameterized


@RunWith(value = classOf[Parameterized])
class ResourcesStorageTest(dbFileName: String) extends ParameterizedUnitTests(dbFileName) with ResourcesStorageJUnit {
  val packagesStorage = new PackagesStorageImpl
  val resourcesStorage = new ResourcesStorageImpl
}