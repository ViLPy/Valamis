package com.arcusys.learn.scorm.manifest.storage.impl

import org.junit._
import Assert._
import com.arcusys.learn.scorm.manifest.model._
import scala.Some
import com.arcusys.learn.scorm.manifest.storage.{ActivitiesStorage, PackagesStorage}

/**
 * User: dkudinov
 * Date: 25.4.2013
 */
trait ActivitiesStorageJUnitMethods {
  def packagesStorage: PackagesStorage
  def activitiesStorage: ActivitiesStorage

  @Before
  def setUp() {
    packagesStorage.renew()
    activitiesStorage.renew()
  }

  @Test
  def noDataInitially() {
    assertEquals(0, activitiesStorage.getAll.size)
  }

  @Test
  def canCreate() {
    val courseID: Option[Int] = Some(0)
    val testPackageId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = courseID, isDefault = false), courseID)
    activitiesStorage.create(testPackageId, new Organization("Organization1", "Test organization 1"))
    activitiesStorage.create(testPackageId, new ContainerActivity("container1", "Test container", "Organization1", "Organization1"))
    activitiesStorage.create(testPackageId, new LeafActivity("leaf1", "test leaf1", "container1", "Organization1", "sco", Some("param")))
    assertEquals(3, activitiesStorage.getAll.size)
  }

  @Test
  def canGetByID() {
    val courseID: Option[Int] = Some(0)
    val testPackageId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = courseID, isDefault = false), courseID)
    activitiesStorage.create(testPackageId, new Organization("Organization1", "Test organization 1"))

    val newContainer = new ContainerActivity("container1", "Test container", "Organization1", "Organization1")
    val newLeafActivity = new LeafActivity("leaf1", "test leaf1", "container1", "Organization1", "sco", Some("param"))
    activitiesStorage.create(testPackageId, newContainer)
    activitiesStorage.create(testPackageId, newLeafActivity)

    val testContainer = activitiesStorage.get(testPackageId, "container1").get.asInstanceOf[ContainerActivity]
    val testLeafActivity = activitiesStorage.get(testPackageId, "leaf1").get.asInstanceOf[LeafActivity]

    assertEquals(newContainer.title, testContainer.title)
    assertEquals(Some("Organization1"), testContainer.parentID)

    assertEquals(newLeafActivity.title, testLeafActivity.title)
    assertEquals("container1", testLeafActivity.parentID.get)
    assertEquals(newLeafActivity.resourceIdentifier, testLeafActivity.resourceIdentifier)
  }

  @Test
  def canGetAllByParam() {
    val courseID: Option[Int] = Some(0)
    //TODO: bad metadata
    val testPackageId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = courseID, isDefault = false), courseID)
    activitiesStorage.create(testPackageId, new Organization("Organization1", "Test organization 1"))
    activitiesStorage.create(testPackageId, new Organization("Organization2", "Test organization 2"))
    activitiesStorage.create(testPackageId, new ContainerActivity("container1", "Test container", "Organization1", "Organization1"))
    activitiesStorage.create(testPackageId, new LeafActivity("leaf1", "test leaf1", "container1", "Organization1", "sco", Some("param")))
    activitiesStorage.create(testPackageId, new LeafActivity("leaf2", "test leaf2", "container1", "Organization1", "sco", Some("param")))

    activitiesStorage.create(testPackageId, new ContainerActivity("container2", "Test container", "Organization2", "Organization2"))
    activitiesStorage.create(testPackageId, new LeafActivity("leaf3", "test leaf3", "container2", "Organization2", "sco", Some("param")))
    // tree doesn't contains LeafActivities, coz they are already placed in container
    assertEquals(1, activitiesStorage.getOrganizationTree(testPackageId, "Organization1").children.size)
    assertEquals(1, activitiesStorage.getOrganizationTree(testPackageId, "Organization2").children.size)
  }

  @Test
  def canPersistNonDefaultSequencing() {
    val primaryObjective = new Objective(Some("test"), satisfiedByMeasure = true, minNormalizedMeasure = BigDecimal(1))

    val conditions = Seq(new RuleCondition(ConditionType.ObjectiveSatisfied, Some("test"), None, inverse = false))
    val conditionSet = new RuleConditionSet(conditions, ConditionCombination.All)
    val rollupRule = new RollupRule(childActivitySet = ChildActivitySet.atLeastCount(10), conditions = conditionSet, action = RollupAction.Completed)

    val exitConditions = Seq(new RuleCondition(ConditionType.ObjectiveMeasureLessThan, Some("test"), Some(BigDecimal(0.5)), inverse = false))
    val exitConditionSet = new RuleConditionSet(exitConditions, ConditionCombination.Any)
    val exitRules = Seq(new ExitConditionRule(exitConditionSet))

    val preConditions = Seq(new RuleCondition(ConditionType.ObjectiveMeasureKnown, Some("test"), None, inverse = false))
    val preConditionSet = new RuleConditionSet(preConditions, ConditionCombination.Any)
    val preRules = Seq(new PreConditionRule(preConditionSet, PreConditionAction.StopForwardTraversal))

    val postConditions = Seq(new RuleCondition(ConditionType.ObjectiveMeasureGreaterThan, Some("test"), Some(BigDecimal(0.9)), inverse = false))
    val postConditionSet = new RuleConditionSet(postConditions, ConditionCombination.Any)
    val postRules = Seq(new PostConditionRule(postConditionSet, PostConditionAction.Continue))

    val nonPrimaryObjective = new Objective(Some("testNonPrimary"), satisfiedByMeasure = true, minNormalizedMeasure = BigDecimal(0.5))
    val sequencing = new Sequencing(
      sharedId = None,
      sharedSequencingIdReference = None,
      permissions = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = false, forwardOnlyForChildren = false),
      onlyCurrentAttemptObjectiveProgressForChildren = true,
      onlyCurrentAttemptAttemptProgressForChildren = true,
      attemptLimit = None,
      durationLimitInMilliseconds = None,
      rollupContribution = new RollupContribution(
        satisfaction = None,
        completion = None,
        objectiveMeasureWeight = 1,
        measureSatisfactionIfActive = true
      ),
      primaryObjective = Some(primaryObjective),
      nonPrimaryObjectives = Seq(nonPrimaryObjective),
      childrenSelection = new ChildrenSelection(15, RandomizationTimingType.OnEachNewAttempt, RandomizationTimingType.OnEachNewAttempt),
      tracking = Some(new SequencingTracking(completionSetByContent = false, objectiveSetByContent = false)),
      preventChildrenActivation = false,
      constrainChoice = false,
      preConditionRules = preRules, postConditionRules = postRules, exitConditionRules = exitRules, rollupRules = Seq(rollupRule)
    )

    val courseID: Option[Int] = Some(0)
    val testPackageId = packagesStorage.createAndGetID(new Manifest(12, None, None, "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = courseID, isDefault = false), courseID)
    activitiesStorage.create(testPackageId, new Organization("Organization1", "Test organization 1"))
    activitiesStorage.create(testPackageId, new ContainerActivity("container1", "Test container", "Organization1", "Organization1"))
    activitiesStorage.create(testPackageId, new LeafActivity("leaf1", "test leaf1", "container1", "Organization1", "sco", Some("param"), sequencing = sequencing))

    assertEquals(true, activitiesStorage.get(testPackageId, "leaf1").isDefined)
    assertEquals(true, activitiesStorage.get(testPackageId, "leaf1").get.sequencing.primaryObjective.isDefined)
    assertEquals(Some("test"), activitiesStorage.get(testPackageId, "leaf1").get.sequencing.primaryObjective.get.id)
    assertEquals(1, activitiesStorage.get(testPackageId, "leaf1").get.sequencing.nonPrimaryObjectives.size)
    assertEquals(Some("testNonPrimary"), activitiesStorage.get(testPackageId, "leaf1").get.sequencing.nonPrimaryObjectives(0).id)
  }
}
