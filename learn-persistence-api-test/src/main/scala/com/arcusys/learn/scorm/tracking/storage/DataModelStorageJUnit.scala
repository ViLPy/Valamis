package com.arcusys.learn.scorm.tracking.storage

import com.arcusys.learn.scorm.tracking.model.{ Attempt, User }
import com.arcusys.learn.scorm.manifest.storage.{ ActivitiesStorage, PackagesStorage }
import com.arcusys.learn.scorm.tracking.storage.impl.{ AttemptEntityStorage, DataModelEntityStorage }
import com.arcusys.learn.scorm.manifest.model._

import org.junit.Assert._
import org.junit.{ Test, Before }

trait DataModelStorageJUnit {
  def dataModelStorage: DataModelEntityStorage
  def packagesStorage: PackagesStorage
  def attemptStorage: AttemptEntityStorage
  def activityStorage: ActivitiesStorage
  def userStorage: UserStorage

  @Before
  def setUp() {
    packagesStorage.renew()
    activityStorage.renew()
    userStorage.renew()
    attemptStorage.renew()
    dataModelStorage.renew()
  }

  @Test
  def noDataInitially() {
    assertEquals(0, dataModelStorage.getAll.size)
  }

  @Test
  def canSetValue() {
    val testPackageId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = Some(0), isDefault = false), Some(0))
    val organization = new Organization("Organization1", "Test organization 1")
    val container = new ContainerActivity("container1", "Test container", "Organization1", "Organization1")
    val leaf1 = new LeafActivity("leaf1", "test leaf1", "container1", "Organization1", "sco", Some("param"))
    activityStorage.create(testPackageId, organization)
    activityStorage.create(testPackageId, container)
    activityStorage.create(testPackageId, leaf1)

    val user = userStorage.getByID(userStorage.createAndGetID(User(0, "user1"))).get

    val attempt = attemptStorage.getByID(attemptStorage.createAndGetID(new Attempt(0,
      user = user,
      packageID = testPackageId,
      organizationID = organization.id,
      isComplete = false))).get

    val value1 = "ok"
    val value2 = "ko"
    dataModelStorage.setValue(attempt.id, leaf1.id, "test", value1)
    assertEquals(value1, dataModelStorage.getValue(attempt.id, leaf1.id, "test").get)
    dataModelStorage.setValue(attempt.id, leaf1.id, "test", value2)
    assertEquals(value2, dataModelStorage.getValue(attempt.id, leaf1.id, "test").get)
  }

  @Test
  def canGetCollectionsAndKeyedValues() {
    val testPackageId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = Some(0), isDefault = false), Some(0))
    val organization = new Organization("Organization1", "Test organization 1")
    val container = new ContainerActivity("container1", "Test container", "Organization1", "Organization1")
    val leaf1 = new LeafActivity("leaf1", "test leaf1", "container1", "Organization1", "sco", Some("param"))
    activityStorage.create(testPackageId, organization)
    activityStorage.create(testPackageId, container)
    activityStorage.create(testPackageId, leaf1)

    val user = userStorage.getByID(userStorage.createAndGetID(User(0, "user1"))).get

    val attempt = attemptStorage.getByID(attemptStorage.createAndGetID(new Attempt(0,
      user = user,
      packageID = testPackageId,
      organizationID = organization.id,
      isComplete = false))).get

    val value1 = "ok"
    val value2 = "ko"
    dataModelStorage.setValue(attempt.id, leaf1.id, "test.1", value1)
    dataModelStorage.setValue(attempt.id, leaf1.id, "test.2", value2)
    val response = dataModelStorage.getCollectionValues(attempt.id, leaf1.id, "test")
    assertEquals(Set("test.1", "test.2"), response.keySet)
    assertEquals(value1, response("test.1").get)
    assertEquals(value2, response("test.2").get)

    val keyedResponse = dataModelStorage.getKeyedValues(attempt.id, leaf1.id)
    assertEquals(Set("test.1", "test.2"), keyedResponse.keySet)
    assertEquals(value1, keyedResponse("test.1").get)
    assertEquals(value2, keyedResponse("test.2").get)
  }

  @Test
  def canGetValuesByKey() {
    val testPackageId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = Some(0), isDefault = false), Some(0))
    val organization = new Organization("Organization1", "Test organization 1")
    val container = new ContainerActivity("container1", "Test container", "Organization1", "Organization1")
    val leaf1 = new LeafActivity("leaf1", "test leaf1", "container1", "Organization1", "sco", Some("param"))
    val leaf2 = new LeafActivity("leaf2", "test leaf2", "container1", "Organization1", "sco", Some("param"))
    activityStorage.create(testPackageId, organization)
    activityStorage.create(testPackageId, container)
    activityStorage.create(testPackageId, leaf1)
    activityStorage.create(testPackageId, leaf2)

    val user = userStorage.getByID(userStorage.createAndGetID(User(0, "user1"))).get

    val attempt = attemptStorage.getByID(attemptStorage.createAndGetID(new Attempt(0,
      user = user,
      packageID = testPackageId,
      organizationID = organization.id,
      isComplete = false))).get

    val value1 = "ok"
    val value2 = "ko"
    dataModelStorage.setValue(attempt.id, leaf1.id, "test", value1)
    dataModelStorage.setValue(attempt.id, leaf2.id, "test", value2)
    val response = dataModelStorage.getValuesByKey(attempt.id, "test")
    assertEquals(Set(leaf1.id, leaf2.id), response.keySet)
    assertEquals(value1, response(leaf1.id).get)
    assertEquals(value2, response(leaf2.id).get)
  }
}
