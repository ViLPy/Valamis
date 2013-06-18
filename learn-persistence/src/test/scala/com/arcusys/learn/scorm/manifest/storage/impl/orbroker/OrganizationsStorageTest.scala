package com.arcusys.learn.scorm.manifest.storage.impl.orbroker

import com.arcusys.learn.scorm.manifest.storage.impl.OrganizationsStorageJUnitMethods
import com.arcusys.learn.storage.impl.orbroker.ParameterizedUnitTests

import org.junit._
import runner.RunWith
import runners.Parameterized
import com.arcusys.learn.scorm.manifest.storage.PackagesStorage


@RunWith(value = classOf[Parameterized])
class OrganizationsStorageTest(dbFileName: String) extends ParameterizedUnitTests(dbFileName)
                                                   with OrganizationsStorageJUnitMethods {
  val packagesStorage: PackagesStorage = new PackagesStorageImpl
  val organizationsStorage = new ActivitiesStorageImpl
}
