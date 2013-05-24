package com.arcusys.learn.scorm.manifest.storage.impl.orbroker

import com.arcusys.learn.scorm.manifest.storage.impl.PackagesStorageJUnit
import com.arcusys.learn.storage.impl.orbroker.ParameterizedUnitTests

import org.junit._
import runner.RunWith
import runners.Parameterized


@RunWith(value = classOf[Parameterized])
class PackagesStorageTest(dbFileName: String) extends ParameterizedUnitTests(dbFileName)
                                              with PackagesStorageJUnit {
  val packagesStorage = new PackagesStorageImpl
}
