package com.arcusys.learn.scorm.manifest.storage.impl.orbroker

import org.junit._
import Assert._
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.storage.impl.orbroker.ParameterizedUnitTests
import runner.RunWith
import runners.Parameterized

@RunWith(value = classOf[Parameterized])
class ResourcesStorageTest(dbFileName: String) extends ParameterizedUnitTests(dbFileName){
  val packagesStorage = new PackagesStorageImpl
  val resourcesStorage = new ResourcesStorageImpl

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
    val pId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title"))
    val rId = resourcesStorage.createForPackageAndGetID(pId, new ScoResource("HJF23-13", "http://google.com", None, Nil, Nil))
    assertEquals(1, resourcesStorage.getAll.size)
  }

  @Test
  def canGetByID() {
    val pId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title"))
    packagesStorage.createAndGetID(new Manifest(123, None, None, "", Some("defaultOrganizationIdentifierDummy"), Some("resourcesBase/"), "DummyTitle"))
    val r = new ScoResource("1", "http://google.com", Some("None/"), Nil, Nil)
    val createdResourceId = resourcesStorage.createForPackageAndGetID(pId, r)
    val newResource = resourcesStorage.getByID(createdResourceId).get
    assertEquals(newResource.id, r.id)
    assertEquals(newResource.href, r.href)
    assertEquals(newResource.base, r.base)

    val newResource2 = resourcesStorage.getByID(pId, "1").get
    assertEquals(newResource2.id, "1")
    assertEquals(newResource2.href, r.href)
    assertEquals(newResource2.base, r.base)
  }

  @Test
  def canGetByPackageID() {
    val package1Id = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title"))
    val package2Id = packagesStorage.createAndGetID(new Manifest(123, None, None, "", Some("defaultOrganizationIdentifierDummy"), Some("resourcesBase/"), "DummyTitle"))
    resourcesStorage.createForPackageAndGetID(package1Id, new ScoResource("HJF23-13", "http://google.com", Some("None/"), Nil, Nil))
    resourcesStorage.createForPackageAndGetID(package1Id, new ScoResource("HJF23-14", "http://google.com", Some("None/"), Nil, Nil))
    resourcesStorage.createForPackageAndGetID(package1Id, new ScoResource("HJF23-15", "http://google.com", Some("None/"), Nil, Nil))
    resourcesStorage.createForPackageAndGetID(package2Id, new ScoResource("HJF23-16", "http://google.com", Some("None/"), Nil, Nil))

    assertEquals(3, resourcesStorage.getByPackageID(package1Id).size)
    assertEquals(1, resourcesStorage.getByPackageID(package2Id).size)
  }
}