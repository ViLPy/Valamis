package com.arcusys.learn.scorm.manifest.storage.impl

import com.arcusys.learn.scorm.manifest.storage.{ PackagesStorage, ResourcesStorage }
import com.arcusys.learn.scorm.manifest.model.{ ScoResource, Manifest }

import org.junit.Assert._
import org.junit.{ Test, Before }

trait ResourcesStorageJUnit {
  def packagesStorage: PackagesStorage
  def resourcesStorage: ResourcesStorage

  @Before
  def setUp() {
    packagesStorage.renew()
    resourcesStorage.renew()
  }

  @Test
  def noDataInitially() {
    assertEquals(0, resourcesStorage.getAll.size)
  }

  @Test
  def canCreate() {
    val pId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = Some(0), isDefault = false), Some(0))
    val rId = resourcesStorage.createForPackageAndGetID(pId, new ScoResource("HJF23-13", "http://google.com", None, Nil, Nil))
    assertEquals(1, resourcesStorage.getAll.size)
  }

  @Test
  def canGetByID() {
    val pId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = Some(0), isDefault = false), Some(0))
    packagesStorage.createAndGetID(new Manifest(123, None, None, "", Some("defaultOrganizationIdentifierDummy"), Some("resourcesBase/"), "DummyTitle", courseID = Some(0), isDefault = false), Some(0))
    val r = new ScoResource("1", "http://google.com", Some("None/"), Nil, Nil)
    resourcesStorage.createForPackageAndGetID(pId, r)
    val newResource = resourcesStorage.getByID(pId, r.id).get
    assertEquals(newResource.id, r.id)
    assertEquals(newResource.href, r.href)
    assertEquals(newResource.base, r.base)
  }

  @Test
  def canGetByPackageID() {
    val package1Id = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = Some(0), isDefault = false), Some(0))
    val package2Id = packagesStorage.createAndGetID(new Manifest(123, None, None, "", Some("defaultOrganizationIdentifierDummy"), Some("resourcesBase/"), "DummyTitle", courseID = Some(0), isDefault = false), Some(0))
    resourcesStorage.createForPackageAndGetID(package1Id, new ScoResource("HJF23-13", "http://google.com", Some("None/"), Nil, Nil))
    resourcesStorage.createForPackageAndGetID(package1Id, new ScoResource("HJF23-14", "http://google.com", Some("None/"), Nil, Nil))
    resourcesStorage.createForPackageAndGetID(package1Id, new ScoResource("HJF23-15", "http://google.com", Some("None/"), Nil, Nil))
    resourcesStorage.createForPackageAndGetID(package2Id, new ScoResource("HJF23-16", "http://google.com", Some("None/"), Nil, Nil))

    assertEquals(3, resourcesStorage.getByPackageID(package1Id).size)
    assertEquals(1, resourcesStorage.getByPackageID(package2Id).size)
  }
}
