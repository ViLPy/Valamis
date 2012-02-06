package com.arcusys.scorm.storage.impl.orbroker

import org.junit._
import Assert._
import com.arcusys.scorm.model._
import com.arcusys.scorm.storage.impl.orbroker.BrokerFactory._

class ResourcesStorageTest
{
  val packagesStorage = new PackagesStorageImpl
  val resourcesStorage = new ResourcesStorageImpl

  @Before
  def setUp: Unit =
  {
    packagesStorage.renew
    resourcesStorage.renew
  }

  @Test
  def noDataInitially =
  {
    assertEquals(0, resourcesStorage.getAll.size)
  }

  @Test
  def canCreate =
  {
    val p = packagesStorage.create(new Manifest("12", None, None, null, Some("defaultOrganizationIdentifier"), Some("resourcesBase"), "title"))
    val r = resourcesStorage.create(p.id.toInt, new Resource("HJF23-13", "sco", Some("http://google.com"), None, ResourceScormType.Sco, None))
    assertEquals(1, resourcesStorage.getAll.size)
  }
  
  @Test
  def canGetByID =
  {
    val p = packagesStorage.create(new Manifest("12", None, None, null, Some("defaultOrganizationIdentifier"), Some("resourcesBase"), "title"))
    packagesStorage.create(new Manifest("Dummy", None, None, null, Some("defaultOrganizationIdentifierDummy"), Some("resourcesBase"), "DummyTitle"))
    val r = new Resource("1", "sco", Some("http://google.com"), Some("None"), ResourceScormType.Sco, None)
    val createdResource = resourcesStorage.create(p.id.toInt, r)
    val newResource = resourcesStorage.getByID(createdResource.id.toInt).get
    assertEquals(newResource.id, r.id)
    assertEquals(newResource.resourceType, r.resourceType)
    assertEquals(newResource.href, r.href)
    assertEquals(newResource.base, r.base)
    
    val newResource2 = resourcesStorage.getByID(p.id.toInt, r.id.toInt).get
    assertEquals(newResource2.id, r.id)
    assertEquals(newResource2.resourceType, r.resourceType)
    assertEquals(newResource2.href, r.href)
    assertEquals(newResource2.base, r.base)
  }
  
  @Test
  def canGetByPackageID = 
  {
    val package1 = packagesStorage.create(new Manifest("12", None, None, null, Some("defaultOrganizationIdentifier"), Some("resourcesBase"), "title"))
    val package2 = packagesStorage.create(new Manifest("Dummy", None, None, null, Some("defaultOrganizationIdentifierDummy"), Some("resourcesBase"), "DummyTitle"))
    resourcesStorage.create(package1.id.toInt, new Resource("HJF23-13", "sco", Some("http://google.com"), Some("None"), ResourceScormType.Sco, None))
    resourcesStorage.create(package1.id.toInt, new Resource("HJF23-14", "sco", Some("http://google.com"), Some("None"), ResourceScormType.Sco, None))
    resourcesStorage.create(package1.id.toInt, new Resource("HJF23-15", "sco", Some("http://google.com"), Some("None"), ResourceScormType.Sco, None))
    resourcesStorage.create(package2.id.toInt, new Resource("HJF23-16", "sco", Some("http://google.com"), Some("None"), ResourceScormType.Sco, None))
    
    assertEquals(3, resourcesStorage.getByPackageID(package1.id.toInt).size)
    assertEquals(1, resourcesStorage.getByPackageID(package2.id.toInt).size)
  }
}