package com.arcusys.learn.scorm.tracking.storage

import com.arcusys.learn.scorm.tracking.model.User
import com.arcusys.learn.scorm.manifest.model.Manifest
import com.arcusys.learn.scorm.manifest.storage.PackagesStorage
import com.arcusys.learn.scorm.tracking.storage.impl.AttemptEntityStorage
import com.arcusys.learn.scorm.manifest.model.Organization

import org.junit.Assert._
import org.junit.{ Test, Before }

trait AttemptStorageJUnit {
  val packagesStorage: PackagesStorage
  val attemptStorage: AttemptStorage
  val userStorage: UserStorage

  @Before
  def setUp() {
    packagesStorage.renew()
    userStorage.renew()
    attemptStorage.renew()
  }

  @Test
  def canCreate() {
    val testPackageId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = Some(0), isDefault = false), Some(0))
    val organization = new Organization("Organization1", "Test organization 1")

    val userID = userStorage.createAndGetID(User(0, "user1"))
    val user = userStorage.getByID(userID).get

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
    val testPackageId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = Some(0), isDefault = false), Some(0))
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
    val testPackageId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = Some(0), isDefault = false), Some(0))
    val testPackageId2 = packagesStorage.createAndGetID(new Manifest(13, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title2", courseID = Some(1), isDefault = false), Some(1))
    val organization = new Organization("Organization1", "Test organization 1")
    val organization2 = new Organization("Organization2", "Test organization 2")

    val user = userStorage.getByID(userStorage.createAndGetID(User(0, "user1"))).get
    val user2 = userStorage.getByID(userStorage.createAndGetID(User(1, "user2"))).get

    val attemptID = attemptStorage.createAndGetID(user.id, testPackageId, organization.id)
    attemptStorage.markAsComplete(attemptID)
    attemptStorage.createAndGetID(user.id, testPackageId, organization2.id)
    attemptStorage.createAndGetID(user2.id, testPackageId2, organization2.id)

    val packages = packagesStorage.getPackagesWithAttempts
    assertEquals(2, packages.size)

    val packagesForUser = packagesStorage.getPackagesWithUserAttempts(user2.id)
    assertEquals(1, packagesForUser.size)
    assertEquals(testPackageId2, packagesForUser.head.id)
  }

  @Test
  def canOperateWithUsers() {
    val testPackageId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = Some(0), isDefault = false), Some(0))
    val testPackageId2 = packagesStorage.createAndGetID(new Manifest(13, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title2", courseID = Some(1), isDefault = false), Some(1))
    val organization = new Organization("Organization1", "Test organization 1")
    val organization2 = new Organization("Organization2", "Test organization 2")

    val user = userStorage.getByID(userStorage.createAndGetID(User(0, "user1"))).get
    val user2 = userStorage.getByID(userStorage.createAndGetID(User(1, "user2"))).get

    val attemptID = attemptStorage.createAndGetID(user.id, testPackageId, organization.id)
    attemptStorage.markAsComplete(attemptID)
    attemptStorage.createAndGetID(user.id, testPackageId, organization2.id)
    attemptStorage.createAndGetID(user2.id, testPackageId2, organization2.id)

    val packages = userStorage.getUsersWithAttempts
    assertEquals(2, packages.size)

    val packagesForUser = userStorage.getUsersWithAttemptsInPackage(testPackageId)
    assertEquals(1, packagesForUser.size)
    assertEquals(user.id, packagesForUser.head.id)
  }
}
