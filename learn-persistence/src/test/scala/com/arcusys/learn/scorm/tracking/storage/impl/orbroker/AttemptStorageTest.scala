package com.arcusys.learn.scorm.tracking.storage.impl.orbroker

import org.junit._
import Assert._
import com.arcusys.learn.scorm.tracking.model._
import com.arcusys.learn.storage.impl.orbroker.ParameterizedUnitTests
import runner.RunWith
import runners.Parameterized
import com.arcusys.learn.scorm.manifest.storage.impl.orbroker.{PackagesStorageImpl, ActivitiesStorageImpl}
import com.arcusys.learn.scorm.manifest.model.{LeafActivity, ContainerActivity, Organization, Manifest}

@RunWith(value = classOf[Parameterized])
class AttemptStorageTest(dbFileName: String) extends ParameterizedUnitTests(dbFileName) {
  val packagesStorage = new PackagesStorageImpl
  val attemptStorage = new AttemptStorageImpl
  val userStorage = new UserStorageImpl


  @Before
  def setUp() {
    packagesStorage.renew()
    userStorage.renew()
    attemptStorage.renew()
  }

  @Test
  def canCreate() {
    val testPackageId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = Some(0), isDefault = false))
    val organization = new Organization("Organization1", "Test organization 1")

    val user = userStorage.getByID(userStorage.createAndGetID(User(0, "user1"))).get

    val attemptID = attemptStorage.createAndGetID(user.id, testPackageId, organization.id)
    val attempt = attemptStorage.getByID(attemptID)

    assertTrue(attempt.nonEmpty)
    assertEquals(testPackageId, attempt.get.packageID)
    assertEquals(organization.id, attempt.get.organizationID)

    val activeAttempt = attemptStorage.getActive(user.id, testPackageId)
    assertTrue(activeAttempt.nonEmpty)
    assertEquals(testPackageId, activeAttempt.get.packageID)
    assertEquals(organization.id, activeAttempt.get.organizationID)
  }

  @Test
  def canGetLastIncomplete() {
    val testPackageId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = Some(0), isDefault = false))
    val organization = new Organization("Organization1", "Test organization 1")
    val organization2 = new Organization("Organization2", "Test organization 2")

    val user = userStorage.getByID(userStorage.createAndGetID(User(0, "user1"))).get

    val attemptID = attemptStorage.createAndGetID(user.id, testPackageId, organization.id)
    attemptStorage.markAsComplete(attemptID)

    attemptStorage.checkIfComplete(user.id, testPackageId)

    attemptStorage.createAndGetID(user.id, testPackageId, organization2.id)

    val attempt = attemptStorage.getLast(user.id, testPackageId, complete = false)

    assertTrue(attempt.nonEmpty)
    assertEquals(testPackageId, attempt.get.packageID)
    assertEquals(organization2.id, attempt.get.organizationID)
  }

  @Test
  def canOperateWithPackages() {
    val testPackageId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = Some(0), isDefault = false))
    val testPackageId2 = packagesStorage.createAndGetID(new Manifest(13, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title2", courseID = Some(1), isDefault = false))
    val organization = new Organization("Organization1", "Test organization 1")
    val organization2 = new Organization("Organization2", "Test organization 2")

    val user = userStorage.getByID(userStorage.createAndGetID(User(0, "user1"))).get
    val user2 = userStorage.getByID(userStorage.createAndGetID(User(1, "user2"))).get

    val attemptID = attemptStorage.createAndGetID(user.id, testPackageId, organization.id)
    attemptStorage.markAsComplete(attemptID)
    attemptStorage.createAndGetID(user.id, testPackageId, organization2.id)
    attemptStorage.createAndGetID(user2.id, testPackageId2, organization2.id)

    val packages = attemptStorage.getPackagesWithAttempts
    assertEquals(2, packages.size)

    val packagesForUser = attemptStorage.getPackagesWithUserAttempts(user2.id)
    assertEquals(1, packagesForUser.size)
    assertEquals(testPackageId2, packagesForUser.head.id)
  }

  @Test
  def canOperateWithUsers() {
    val testPackageId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = Some(0), isDefault = false))
    val testPackageId2 = packagesStorage.createAndGetID(new Manifest(13, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title2", courseID = Some(1), isDefault = false))
    val organization = new Organization("Organization1", "Test organization 1")
    val organization2 = new Organization("Organization2", "Test organization 2")

    val user = userStorage.getByID(userStorage.createAndGetID(User(0, "user1"))).get
    val user2 = userStorage.getByID(userStorage.createAndGetID(User(1, "user2"))).get

    val attemptID = attemptStorage.createAndGetID(user.id, testPackageId, organization.id)
    attemptStorage.markAsComplete(attemptID)
    attemptStorage.createAndGetID(user.id, testPackageId, organization2.id)
    attemptStorage.createAndGetID(user2.id, testPackageId2, organization2.id)

    val packages = attemptStorage.getUsersWithAttempts
    assertEquals(2, packages.size)

    val packagesForUser = attemptStorage.getUsersWithAttemptsInPackage(testPackageId)
    assertEquals(1, packagesForUser.size)
    assertEquals(user.id, packagesForUser.head.id)
  }
}