package com.arcusys.learn.scorm.manifest.storage.impl

import com.arcusys.learn.scorm.manifest.storage.PackagesStorage
import com.arcusys.learn.scorm.manifest.model.Manifest

import org.junit.Assert._
import org.junit.{Test, Before}


trait PackagesStorageJUnit {
  def packagesStorage: PackagesStorage

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
    val pId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title",courseID= Some(0), isDefault = false ), Some(0))
    assertEquals(1, packagesStorage.getAll.size)
  }

  @Test
  def canGetByID() {
    val manifest = new Manifest(12, None, Some("NoneBase/"), "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title",courseID= Some(0), isDefault = false )
    val testPackageId = packagesStorage.createAndGetID(manifest, manifest.courseID)
    val createdPackage = packagesStorage.getByID(testPackageId).get
    assertEquals(createdPackage.base, manifest.base)
    assertEquals(createdPackage.defaultOrganizationID, manifest.defaultOrganizationID)
    assertEquals(createdPackage.resourcesBase, manifest.resourcesBase)
    assertEquals(createdPackage.title, manifest.title)
  }
}
