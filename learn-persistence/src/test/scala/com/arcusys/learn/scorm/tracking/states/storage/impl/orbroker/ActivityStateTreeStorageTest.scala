package com.arcusys.learn.scorm.tracking.states.storage.impl.orbroker

import com.arcusys.scorm.util.PropertyUtil
import com.arcusys.learn.storage.impl.orbroker.BrokerFactory
import com.arcusys.learn.scorm.tracking.storage.impl.orbroker.{UserStorageImpl, AttemptStorageImpl}
import org.junit.{Test, Before}
import com.arcusys.learn.scorm.manifest.storage.impl.orbroker.{PackagesStorageImpl, ActivitiesStorageImpl}
import com.arcusys.scorm.lms.sequencing._
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.tracking.model._
import org.junit.Assert._
import scala.Some
import com.arcusys.learn.scorm.tracking.model.User
import com.arcusys.learn.scorm.tracking.model.Attempt
import scala.Some
import com.arcusys.learn.scorm.tracking.model.User
import com.arcusys.learn.scorm.tracking.model.Attempt
import scala.collection.mutable

class ActivityStateTreeStorageTest {
  BrokerFactory.init(PropertyUtil.load("db"))
  val attemptStorage = new AttemptStorageImpl
  val activityStorage = new ActivitiesStorageImpl
  val packagesStorage = new PackagesStorageImpl
  val treeStateStorage = new ActivityStateTreeStorageImpl
  val userStorage = new UserStorageImpl

  @Before
  def setUp() {
    packagesStorage.renew()
    activityStorage.renew()
    userStorage.renew()
    attemptStorage.renew()
    treeStateStorage.renew()
  }

  @Test
  def canStoreAndModify() {
    val testPackageId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title"))
    val organization = new Organization("Organization1", "Test organization 1")
    val container = new ContainerActivity("container1", "Test container", "Organization1", "Organization1")
    val leaf1 = new LeafActivity("leaf1", "test leaf1", "container1", "Organization1", "sco", Some("param"))
    val leaf2 = new LeafActivity("leaf2", "test leaf2", "container1", "Organization1", "sco", Some("param"))
    activityStorage.create(testPackageId, organization)
    activityStorage.create(testPackageId, container)
    activityStorage.create(testPackageId, leaf1)
    activityStorage.create(testPackageId, leaf2)

    val organizationState = new ActivityState(
      activity = organization,
      active = true,
      suspended = false,
      attemptCompleted = Some(false),
      attemptCompletionAmount = None,
      attemptAbsoluteDuration = BigDecimal(-1),
      attemptExperiencedDuration = BigDecimal(-2),
      activityAbsoluteDuration = BigDecimal(-3),
      activityExperiencedDuration = BigDecimal(-4),
      attemptCount = 0,
      objectiveStates = Map[Option[String], ObjectiveState]())

    val containerState = new ActivityState(
      activity = container,
      active = true,
      suspended = false,
      attemptCompleted = Some(false),
      attemptCompletionAmount = None,
      attemptAbsoluteDuration = BigDecimal(1),
      attemptExperiencedDuration = BigDecimal(2),
      activityAbsoluteDuration = BigDecimal(3),
      activityExperiencedDuration = BigDecimal(4),
      attemptCount = 0,
      objectiveStates = Map[Option[String], ObjectiveState]())

    val leaf1State = new ActivityState(
      activity = leaf1,
      active = true,
      suspended = false,
      attemptCompleted = Some(false),
      attemptCompletionAmount = None,
      attemptAbsoluteDuration = BigDecimal(5),
      attemptExperiencedDuration = BigDecimal(6),
      activityAbsoluteDuration = BigDecimal(7),
      activityExperiencedDuration = BigDecimal(8),
      attemptCount = 0,
      objectiveStates = Map[Option[String], ObjectiveState](None -> new ObjectiveState(Some(true), None, ObjectiveMap.Empty),
        Some("foo") -> new ObjectiveState(Some(false), Some(BigDecimal(1.2)), ObjectiveMap.Empty)))

    val leaf2State = new ActivityState(
      activity = leaf2,
      active = true,
      suspended = false,
      attemptCompleted = Some(false),
      attemptCompletionAmount = None,
      attemptAbsoluteDuration = BigDecimal(9),
      attemptExperiencedDuration = BigDecimal(10),
      activityAbsoluteDuration = BigDecimal(11),
      activityExperiencedDuration = BigDecimal(12),
      attemptCount = 0,
      objectiveStates = Map[Option[String], ObjectiveState]())

    val leaf1Node = new ActivityStateNode(leaf1State, Nil)
    val leaf2Node = new ActivityStateNode(leaf2State, Nil)

    val tree = new ActivityStateTree(
      organizationState,
      children = Seq(new ActivityStateNode(containerState, Seq(leaf1Node, leaf2Node))),
      currentActivityID = None,
      suspendedActivityID = None,
      globalObjectiveData = mutable.Map())

    val user = userStorage.getByID(userStorage.createAndGetID(User(0, "user1"))).get

    val attempt = attemptStorage.getByID(attemptStorage.createAndGetID(new Attempt(0,
      user = user,
      packageID = testPackageId,
      organizationID = organization.id,
      isComplete = false))).get

    treeStateStorage.create(attempt.id, tree)

    val fetchedTreeOption = treeStateStorage.get(attempt.id)
    assertEquals(true, fetchedTreeOption.isDefined)

    val fetchedTree = fetchedTreeOption.get
    assertEquals(None, fetchedTree.currentActivity)
    assertEquals(None, fetchedTree.suspendedActivity)
    assertEquals(organization.id, fetchedTree.item.activity.id) // check organization

    val organizationChildren = fetchedTree.children
    assertEquals(1, organizationChildren.size)
    assertEquals(container.id, organizationChildren.head.item.activity.id) // check container

    val containerChildren = organizationChildren.head.children
    assertEquals(2, containerChildren.size)
    assertEquals(leaf1.id, containerChildren.head.item.activity.id) // check leaf1
    assertEquals(Some(true), containerChildren.head.item.objectiveStates(None).getSatisfiedStatus)
    assertEquals(Some(BigDecimal(1.2)), containerChildren.head.item.objectiveStates(Some("foo")).getNormalizedMeasure)

    assertEquals(leaf2.id, containerChildren.last.item.activity.id) // check leaf2
    assertEquals(Some(false), containerChildren.last.item.getCompletionStatus()) // check leaf2
    assertEquals(None, containerChildren.last.item.attemptCompletionAmount) // check leaf2
    assertEquals(BigDecimal(11), containerChildren.last.item.activityAbsoluteDuration) // check leaf2
    assertEquals(BigDecimal(12), containerChildren.last.item.activityExperiencedDuration) // check leaf2

    // Modify test
    fetchedTree.currentActivity = Some(leaf1Node)
    fetchedTree.suspendedActivity = Some(leaf2Node)
    containerChildren.head.item.objectiveStates(None).setSatisfiedStatus(Some(false))
    containerChildren.head.item.objectiveStates(Some("foo")).setNormalizedMeasure(Some(BigDecimal(2.2)))
    containerChildren.last.item.setCompletionStatus(Some(true))
    containerChildren.last.item.attemptCompletionAmount = Some(BigDecimal(1))
    treeStateStorage.modify(attempt.id, fetchedTree)

  }

  @Test
  def canAutoDeleteWithAttempt() {
    val testPackageId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title"))
    val organization = new Organization("Organization1", "Test organization 1")
    val container = new ContainerActivity("container1", "Test container", "Organization1", "Organization1")
    val leaf1 = new LeafActivity("leaf1", "test leaf1", "container1", "Organization1", "sco", Some("param"))
    val leaf2 = new LeafActivity("leaf2", "test leaf2", "container1", "Organization1", "sco", Some("param"))
    activityStorage.create(testPackageId, organization)
    activityStorage.create(testPackageId, container)
    activityStorage.create(testPackageId, leaf1)
    activityStorage.create(testPackageId, leaf2)

    val organizationState = new ActivityState(
      activity = organization,
      active = true,
      suspended = false,
      attemptCompleted = Some(false),
      attemptCompletionAmount = None,
      attemptAbsoluteDuration = BigDecimal(-1),
      attemptExperiencedDuration = BigDecimal(-2),
      activityAbsoluteDuration = BigDecimal(-3),
      activityExperiencedDuration = BigDecimal(-4),
      attemptCount = 0,
      objectiveStates = Map[Option[String], ObjectiveState]())

    val containerNodeState = new ActivityState(
      activity = container,
      active = true,
      suspended = false,
      attemptCompleted = Some(false),
      attemptCompletionAmount = None,
      attemptAbsoluteDuration = BigDecimal(1),
      attemptExperiencedDuration = BigDecimal(2),
      activityAbsoluteDuration = BigDecimal(3),
      activityExperiencedDuration = BigDecimal(4),
      attemptCount = 0,
      objectiveStates = Map[Option[String], ObjectiveState]())

    val tree = new ActivityStateTree(
      organizationState,
      children = Seq(new ActivityStateNode(containerNodeState, Nil)),
      currentActivityID = None,
      suspendedActivityID = None,
      globalObjectiveData = mutable.Map())

    val user = userStorage.getByID(userStorage.createAndGetID(User(0, "user1"))).get

    val attempt = attemptStorage.getByID(attemptStorage.createAndGetID(new Attempt(0,
      user = user,
      packageID = testPackageId,
      organizationID = organization.id,
      isComplete = false))).get

    treeStateStorage.create(attempt.id, tree)

    attemptStorage.delete(attempt.id)

    assertEquals(false, treeStateStorage.get(attempt.id).isDefined)
  }

  @Test
  def canStoreAndModifyGlobalObjectives() {
    val testPackageId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title"))
    val organization = new Organization("Organization1", "Test organization 1")
    val container = new ContainerActivity("container1", "Test container", "Organization1", "Organization1")
    val leaf1 = new LeafActivity("leaf1", "test leaf1", "container1", "Organization1", "sco", Some("param"))
    val leaf2 = new LeafActivity("leaf2", "test leaf2", "container1", "Organization1", "sco", Some("param"))
    activityStorage.create(testPackageId, organization)
    activityStorage.create(testPackageId, container)
    activityStorage.create(testPackageId, leaf1)
    activityStorage.create(testPackageId, leaf2)

    val organizationState = new ActivityState(
      activity = organization,
      active = true,
      suspended = false,
      attemptCompleted = Some(false),
      attemptCompletionAmount = None,
      attemptAbsoluteDuration = BigDecimal(-1),
      attemptExperiencedDuration = BigDecimal(-2),
      activityAbsoluteDuration = BigDecimal(-3),
      activityExperiencedDuration = BigDecimal(-4),
      attemptCount = 0,
      objectiveStates = Map[Option[String], ObjectiveState]())

    val containerNodeState = new ActivityState(
      activity = container,
      active = true,
      suspended = false,
      attemptCompleted = Some(false),
      attemptCompletionAmount = None,
      attemptAbsoluteDuration = BigDecimal(1),
      attemptExperiencedDuration = BigDecimal(2),
      activityAbsoluteDuration = BigDecimal(3),
      activityExperiencedDuration = BigDecimal(4),
      attemptCount = 0,
      objectiveStates = Map[Option[String], ObjectiveState]())

    val tree = new ActivityStateTree(
      organizationState,
      children = Seq(new ActivityStateNode(containerNodeState, Nil)),
      currentActivityID = None,
      suspendedActivityID = None,
      globalObjectiveData = mutable.Map("test1" -> new GlobalObjectiveState(Some(true), None, None)))

    val user = userStorage.getByID(userStorage.createAndGetID(User(0, "user1"))).get

    val attempt = attemptStorage.getByID(attemptStorage.createAndGetID(new Attempt(0,
      user = user,
      packageID = testPackageId,
      organizationID = organization.id,
      isComplete = false))).get

    treeStateStorage.create(attempt.id, tree)

    val fetchedTree = treeStateStorage.get(attempt.id)
    assertEquals(true, fetchedTree.isDefined)
    assertEquals(true, fetchedTree.get.globalObjectiveData.get("test1").isDefined)
    assertEquals(Some(true), fetchedTree.get.globalObjectiveData.get("test1").get.satisfied)

    // test if can store one more objective on modify
    fetchedTree.get.globalObjectiveData("test2") = new GlobalObjectiveState(Some(true), Some(BigDecimal(1.2)), None)

    // test if can modify already created
    fetchedTree.get.globalObjectiveData("test1") = new GlobalObjectiveState(Some(false), Some(BigDecimal(2.1)), None)

    treeStateStorage.modify(attempt.id, fetchedTree.get)

    val reFetchedTree = treeStateStorage.get(attempt.id)
    assertEquals(true, reFetchedTree.isDefined)
    assertEquals(true, reFetchedTree.get.globalObjectiveData.get("test1").isDefined)
    assertEquals(true, reFetchedTree.get.globalObjectiveData.get("test2").isDefined)
    assertEquals(Some(false), reFetchedTree.get.globalObjectiveData.get("test1").get.satisfied)
    assertEquals(Some(BigDecimal(2.1)), reFetchedTree.get.globalObjectiveData.get("test1").get.normalizedMeasure)
    assertEquals(Some(true), reFetchedTree.get.globalObjectiveData.get("test2").get.satisfied)
    assertEquals(Some(BigDecimal(1.2)), reFetchedTree.get.globalObjectiveData.get("test2").get.normalizedMeasure)
  }
}
