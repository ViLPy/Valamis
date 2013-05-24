package com.arcusys.learn.scorm.manifest.storage.impl

import com.arcusys.learn.scorm.manifest.storage.{ActivitiesStorage, PackagesStorage}
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.storage.impl.KeyedEntityStorageExt

import org.junit._
import Assert._


trait OrganizationsStorageJUnitMethods {
  def packagesStorage: PackagesStorage
  def organizationsStorage: ActivitiesStorage

  @Before
  def setUp() {
    packagesStorage.renew()
    organizationsStorage.renew()
  }

  @Test
  def noDataInitially() {
    println(organizationsStorage)
    val size = organizationsStorage.getAll.size
    assertEquals(0, organizationsStorage.getAll.size)
  }

  @Test
  def canCreate() {
    //TODO: bad metadata
    val pId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title",courseID= Some(0), isDefault = false ), None)
    organizationsStorage.create(pId, new Organization("Organization1", "Test organization 1"))
    assertEquals(1, organizationsStorage.getAll.size)
  }

  @Test
  def canGetByID() {
    val testPackageId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title",courseID= Some(0), isDefault = false ), None)
    val organization = new Organization("1", "Test organization 1")
    organizationsStorage.create(testPackageId, organization)
    val testOrganization = organizationsStorage.get(testPackageId, "1").get
    assertTrue(testOrganization.isInstanceOf[Organization])
    assertEquals(organization.id, testOrganization.id)
    assertEquals(organization.title, testOrganization.title)

    val testOrganization2 = organizationsStorage.get(testPackageId, "1").get
    assertTrue(testOrganization2.isInstanceOf[Organization])
    assertEquals(organization.id, testOrganization2.id)
    assertEquals(organization.title, testOrganization2.title)
  }

  @Test
  def canGetByPackage() {
    val testPackage1Id = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title",courseID= Some(0) , isDefault = false), None)
    val testPackage2Id = packagesStorage.createAndGetID(new Manifest(122, None, None, "", Some("defaultOrganizationIdentifier2"), Some("resourcesBase2/"), "title2",courseID= Some(0), isDefault = false ), None)
    organizationsStorage.create(testPackage1Id, new Organization("Organization1", "Test organization 1"))
    organizationsStorage.create(testPackage1Id, new Organization("Organization2", "Test organization 2"))
    organizationsStorage.create(testPackage1Id, new Organization("Organization3", "Test organization 3"))
    organizationsStorage.create(testPackage2Id, new Organization("Organization4", "Test organization 4"))

    assertEquals(3, organizationsStorage.getAllOrganizations(testPackage1Id).size)
    assertEquals(1, organizationsStorage.getAllOrganizations(testPackage2Id).size)
  }
}
