package com.arcusys.learn.scorm.manifest.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.ParameterizedUnitTests
import com.arcusys.learn.scorm.manifest.storage.impl.PackageScopeRuleStorageJUnit

import org.junit._
import runner.RunWith
import runners.Parameterized


@RunWith(value = classOf[Parameterized])
class PackageScopeRuleStorageTest(dbFileName: String) extends ParameterizedUnitTests(dbFileName)
                                                      with PackageScopeRuleStorageJUnit {
  val packagesScopeRuleStorage = new PackageScopeRuleStorageImpl
  val packagesStorage = new PackagesStorageImpl
  val tincanPackagesStorage = new TincanPackagesStorageImpl
}
