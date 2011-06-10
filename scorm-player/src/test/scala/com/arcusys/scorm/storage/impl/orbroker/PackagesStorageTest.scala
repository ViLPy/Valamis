package com.arcusys.scorm.storage.impl.orbroker

import org.junit._
import Assert._
import com.arcusys.scorm.model._
import com.arcusys.scorm.storage.impl.orbroker.BrokerFactory._

class PackagesStorageTest
{

  val packagesStorage = new PackagesStorageImpl

  @Before
  def setUp: Unit =
  {
    packagesStorage.renew
  }

  @Test
  def noDataInitially =
  {
    assertEquals(0, packagesStorage.getAll.size)
    assertEquals(None, packagesStorage.getByID(1))
  }

  @Test
  def canCreate =
  {
    val p = packagesStorage.create(new Manifest("12", None, None, null, Some("defaultOrganizationIdentifier"), Some("resourcesBase"), "title"))
    assertEquals(1, packagesStorage.getAll.size)
  }
  
  @Test
  def canGetByID =
  {
    val manifest = new Manifest("12", None, Some("NoneBase"), null, Some("defaultOrganizationIdentifier"), Some("resourcesBase"), "title")
    val testPackage = packagesStorage.create(manifest)
    val createdPackage = packagesStorage.getByID(testPackage._1).get
    assertEquals(createdPackage.base, manifest.base)
    assertEquals(createdPackage.defaultOrganizationIdentifier, manifest.defaultOrganizationIdentifier)
    assertEquals(createdPackage.resourcesBase, manifest.resourcesBase)
    assertEquals(createdPackage.title, manifest.title)
  }
}
