package com.arcusys.scorm.storage.impl.orbroker

import org.junit._
import Assert._
import com.arcusys.scorm.model._
import com.arcusys.scorm.storage.impl.orbroker.BrokerFactory._

class ActivitiesStorageTest
{
  val packagesStorage = new PackagesStorageImpl
  val organizationsStorage = new OrganizationsStorageImpl
  val activitiesStorage = new ActivitiesStorageImpl

  @Before
  def setUp: Unit =
  {
    packagesStorage.renew
    organizationsStorage.renew
    activitiesStorage.renew
  }

  @Test
  def noDataInitially =
  {
    assertEquals(0, activitiesStorage.getAll.size)
  }

  @Test
  def canCreate =
  {
    //TODO: bad metadata
    val testPackage = packagesStorage.create(new Manifest("12", None, None, null, Some("defaultOrganizationIdentifier"), Some("resourcesBase"), "title"))
    val organization = organizationsStorage.create(testPackage.id.toInt, new Organization("Organization1", "", false, false, "Test organization 1", null, null, null))
    val container = activitiesStorage.create(testPackage.id.toInt, organization.id.toInt, new ContainerActivity("container1", true, "Test container", null, null, null, null, None), None)
    activitiesStorage.create(testPackage.id.toInt, organization.id.toInt, new LeafActivity("leaf1", true, "test leaf1", None, None, None, Set(), "sco", Some("param"), TimeLimitAction.NotDefined, None, None), Some(container.id.toInt))
    assertEquals(2, activitiesStorage.getAll.size)
  }
  
  @Test
  def canGetByID =
  {
    val testPackage = packagesStorage.create(new Manifest("12", None, None, null, Some("defaultOrganizationIdentifier"), Some("resourcesBase"), "title"))
    val organization = organizationsStorage.create(testPackage.id.toInt, new Organization("Organization1", "", false, false, "Test organization 1", null, null, null))
    
    val newContainer = new ContainerActivity("container1", true, "Test container", null, null, null, null, None)
    val newLeafActivity = new LeafActivity("leaf1", true, "test leaf1", None, None, None, Set(), "sco", Some("param"), TimeLimitAction.NotDefined, None, None)
    val createdContainer = activitiesStorage.create(testPackage.id.toInt, organization.id.toInt, newContainer)
    val createdActivity = activitiesStorage.create(testPackage.id.toInt, organization.id.toInt, newLeafActivity, Some(createdContainer.id.toInt))
    
    val testContainer = activitiesStorage.getByID(createdContainer.id.toInt).get.asInstanceOf[ContainerActivity]
    val testLeafActivity = activitiesStorage.getByID(createdActivity.id.toInt).get.asInstanceOf[LeafActivity]
    
    assertEquals(testContainer.title, createdContainer.title)
    assertEquals(testContainer.parentID, createdContainer.parentID)
    
    assertEquals(testLeafActivity.title, createdActivity.title)
    assertEquals(testLeafActivity.parentID, createdActivity.parentID)
    assertEquals(testLeafActivity.resourceIdentifier, createdActivity.asInstanceOf[LeafActivity].resourceIdentifier)
  }
  
  @Test
  def canGetAllByParam = 
  {
    //TODO: bad metadata
    val testPackage = packagesStorage.create(new Manifest("12", None, None, null, Some("defaultOrganizationIdentifier"), Some("resourcesBase"), "title"))
    val organization1 = organizationsStorage.create(testPackage.id.toInt, new Organization("Organization1", "", false, false, "Test organization 1", null, null, null))
    val organization2 = organizationsStorage.create(testPackage.id.toInt, new Organization("Organization2", "", false, false, "Test organization 2", null, null, null))
    val container = activitiesStorage.create(testPackage.id.toInt, organization1.id.toInt, new ContainerActivity("container1", true, "Test container", null, null, null, null, None), None)
    activitiesStorage.create(testPackage.id.toInt, organization1.id.toInt, new LeafActivity("leaf1", true, "test leaf1", None, None, None, Set(), "sco", Some("param"), TimeLimitAction.NotDefined, None, None), Some(container.id.toInt))
    activitiesStorage.create(testPackage.id.toInt, organization1.id.toInt, new LeafActivity("leaf2", true, "test leaf2", None, None, None, Set(), "sco", Some("param"), TimeLimitAction.NotDefined, None, None), Some(container.id.toInt))
    
    activitiesStorage.create(testPackage.id.toInt, organization2.id.toInt, new ContainerActivity("container1", true, "Test container", null, null, null, null, None), None)
    // tree doesn't contains LeafActivities, coz they are already placed in container
    assertEquals(1, activitiesStorage.getAllByParam(testPackage.id.toInt, organization1.id.toInt).size)
    assertEquals(1, activitiesStorage.getAllByParam(testPackage.id.toInt, organization2.id.toInt).size)
  }
}