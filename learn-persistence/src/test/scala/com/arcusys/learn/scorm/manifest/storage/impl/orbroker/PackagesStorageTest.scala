package com.arcusys.learn.scorm.manifest.storage.impl.orbroker

import org.junit._
import Assert._
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.storage.impl.orbroker.BrokerFactory
import com.arcusys.scorm.util.PropertyUtil

class PackagesStorageTest {
  BrokerFactory.init(PropertyUtil.load("db"))
  val packagesStorage = new PackagesStorageImpl

  @Before
  def setUp() {
    packagesStorage.renew()
  }

  @Test
  def noDataInitially() {
    assertEquals(0, packagesStorage.getAll.size)
    assertEquals(None, packagesStorage.getByID(1))
  }

  @Test
  def canCreate() {
    val pId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title"))
    assertEquals(1, packagesStorage.getAll.size)
  }

  @Test
  def canGetByID() {
    val manifest = new Manifest(12, None, Some("NoneBase/"), "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title")
    val testPackageId = packagesStorage.createAndGetID(manifest)
    val createdPackage = packagesStorage.getByID(testPackageId).get
    assertEquals(createdPackage.base, manifest.base)
    assertEquals(createdPackage.defaultOrganizationID, manifest.defaultOrganizationID)
    assertEquals(createdPackage.resourcesBase, manifest.resourcesBase)
    assertEquals(createdPackage.title, manifest.title)
  }
}
