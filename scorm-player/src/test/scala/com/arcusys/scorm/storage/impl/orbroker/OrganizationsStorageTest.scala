package com.arcusys.scorm.storage.impl.orbroker

import org.junit._
import Assert._
import com.arcusys.scorm.model._
import com.arcusys.scorm.storage.impl.orbroker.BrokerFactory._

class OrganizationStorageTest
{
  val packagesStorage = new PackagesStorageImpl
  val organizationsStorage = new OrganizationsStorageImpl

  @Before
  def setUp: Unit =
  {
    packagesStorage.renew
    organizationsStorage.renew
  }

  @Test
  def noDataInitially =
  {
    assertEquals(0, organizationsStorage.getAll.size)
  }

  @Test
  def canCreate =
  {
    //TODO: bad metadata
    val p = packagesStorage.create(new Manifest("12", None, None, null, Some("defaultOrganizationIdentifier"), Some("resourcesBase"), "title"))
    val o = organizationsStorage.create(p.id.toInt, new Organization("Organization1", "", false, false, "Test organization 1", null, null, null))
    assertEquals(1, organizationsStorage.getAll.size)
  }
  
  @Test
  def canGetByID =
  {
    val testPackage = packagesStorage.create(new Manifest("12", None, None, null, Some("defaultOrganizationIdentifier"), Some("resourcesBase"), "title"))
    val organization = new Organization("1", "", false, false, "Test organization 1", null, null, null)
    val createdOrganization = organizationsStorage.create(testPackage.id.toInt, organization)
    val testOrganization = organizationsStorage.getByID(createdOrganization.id.toInt).get
    assertEquals(organization.id, testOrganization.id)
    assertEquals(organization.title, testOrganization.title)
    
    val testOrganization2 = organizationsStorage.getByID(testPackage.id.toInt, createdOrganization.id.toInt).get
    assertEquals(organization.id, testOrganization2.id)
    assertEquals(organization.title, testOrganization2.title)
  }
  
  @Test
  def canGetByPackage =
  {
    val testPackage1 = packagesStorage.create(new Manifest("12", None, None, null, Some("defaultOrganizationIdentifier"), Some("resourcesBase"), "title"))
    val testPackage2 = packagesStorage.create(new Manifest("122", None, None, null, Some("defaultOrganizationIdentifier2"), Some("resourcesBase2"), "title2"))
    organizationsStorage.create(testPackage1.id.toInt, new Organization("Organization1", "", false, false, "Test organization 1", null, null, null))
    organizationsStorage.create(testPackage1.id.toInt, new Organization("Organization2", "", false, false, "Test organization 2", null, null, null))
    organizationsStorage.create(testPackage1.id.toInt, new Organization("Organization3", "", false, false, "Test organization 3", null, null, null))
    organizationsStorage.create(testPackage2.id.toInt, new Organization("Organization4", "", false, false, "Test organization 4", null, null, null))
    
    assertEquals(3, organizationsStorage.getByPackageID(testPackage1.id.toInt).size)
    assertEquals(1, organizationsStorage.getByPackageID(testPackage2.id.toInt).size)
  }
}
