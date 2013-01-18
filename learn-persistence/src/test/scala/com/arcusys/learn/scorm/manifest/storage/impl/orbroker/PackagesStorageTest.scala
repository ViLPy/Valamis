package com.arcusys.learn.scorm.manifest.storage.impl.orbroker

import org.junit._
import Assert._
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.storage.impl.orbroker.ParameterizedUnitTests
import runner.RunWith
import runners.Parameterized

@RunWith(value = classOf[Parameterized])
class PackagesStorageTest(dbFileName: String) extends ParameterizedUnitTests(dbFileName){
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
    val pId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title",courseID= Some(0) ))
    assertEquals(1, packagesStorage.getAll.size)
  }

  @Test
  def canGetByID() {
    val manifest = new Manifest(12, None, Some("NoneBase/"), "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title",courseID= Some(0) )
    val testPackageId = packagesStorage.createAndGetID(manifest)
    val createdPackage = packagesStorage.getByID(testPackageId).get
    assertEquals(createdPackage.base, manifest.base)
    assertEquals(createdPackage.defaultOrganizationID, manifest.defaultOrganizationID)
    assertEquals(createdPackage.resourcesBase, manifest.resourcesBase)
    assertEquals(createdPackage.title, manifest.title)
  }
}
