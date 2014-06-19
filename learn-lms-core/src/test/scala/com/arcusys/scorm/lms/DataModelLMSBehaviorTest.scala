package com.arcusys.scorm.lms

import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.scorm.tracking.model._
import com.escalatesoft.subcut.inject.NewBindingModule
import org.scalatest.{ Matchers, FlatSpec }
import org.scalamock.scalatest.MockFactory
import org.junit.runner.RunWith

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class DataModelLMSBehaviorTest extends FlatSpec with Matchers with MockFactory {
  private val storageFactory = mock[StorageFactoryContract]
  val someAttempt = new Attempt(id = 1, user = new User(12, "Me"), packageID = 13, organizationID = "org1", isComplete = false)
  val attemptWithoutCurrentActivity = new Attempt(id = 1, user = new User(12, "Me"), packageID = 13, organizationID = "org1", isComplete = false)
  val configuration = new NewBindingModule({
    implicit module =>
      import module._
      bind[StorageFactoryContract] toSingle storageFactory
  })

  // TODO: implement with ActivityStateTree
  /*def service = new DataModelLMSBehavior(someAttempt)(configuration)

  def serviceWithoutCurrentActivity = new DataModelLMSBehavior(attemptWithoutCurrentActivity)(configuration)

  private def expectGetStorage() {
    storageFactory expects 'activityStorage returning activityStorage once()
  }

  "DataModel LMS service" can "return nothing on get completion threshold" in {
    expectGetStorage()
    serviceWithoutCurrentActivity.getCompletionThreshold should equal(None)
  }

  it can "return nothing on get completion threshold if not completed by measure" in {
    expectGetStorage()
    val activity = new ContainerActivity("org1", "", "", "org1", Sequencing.Default, new CompletionThreshold(false, BigDecimal(1), BigDecimal(1)), Set(), true, None)
    activityStorage expects 'get returning Some(activity) once()
    service.getCompletionThreshold should equal(None)
  }

  it can "get completion threshold" in {
    expectGetStorage()
    val activity = new ContainerActivity("org1", "", "", "org1", Sequencing.Default, new CompletionThreshold(true, BigDecimal(1), BigDecimal(1)), Set(), true, None)
    activityStorage expects 'get returning Some(activity) once()
    service.getCompletionThreshold should equal(Some("1"))
  }

  it can "return nothing on get time limit action" in {
    expectGetStorage()
    serviceWithoutCurrentActivity.getTimeLimitAction should equal(None)
  }

  it can "return nothing on get time limit action if timeLimitAction isn't defined" in {
    expectGetStorage()
    val activity = new LeafActivity("org1", "", "", "org1", "res", timeLimitAction = None)
    activityStorage expects 'get returning Some(activity) once()
    service.getTimeLimitAction should equal(None)
  }

  it can "get time limit action" in {
    expectGetStorage()
    val activity = new LeafActivity("org1", "", "", "org1", "res", timeLimitAction = Some(TimeLimitAction.ContinueMessage))
    activityStorage expects 'get returning Some(activity) once()
    service.getTimeLimitAction should equal(Some("continue,message"))
  }

  it can "return nothing on get launch data" in {
    expectGetStorage()
    serviceWithoutCurrentActivity.getLaunchData should equal(None)
  }

  it can "get launch data" in {
    expectGetStorage()
    val activity = new LeafActivity("org1", "", "", "org1", "res", dataFromLMS = Some("test"))
    activityStorage expects 'get returning Some(activity) once()
    service.getLaunchData should equal(Some("test"))
  }

  it can "return nothing on getMaxTimeAllowed" in {
    expectGetStorage()
    serviceWithoutCurrentActivity.getMaxTimeAllowed should equal(None)
  }

  it can "return nothing on getMaxTimeAllowed if durationLimitInMilliseconds isn't defined" in {
    expectGetStorage()
    val sequencing = new Sequencing(
      sharedId = None,
      sharedSequencingIdReference = None,
      permissions = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = false, forwardOnlyForChildren = false),
      onlyCurrentAttemptObjectiveProgressForChildren = true,
      onlyCurrentAttemptAttemptProgressForChildren = true,
      attemptLimit = None,
      durationLimitInMilliseconds = None,
      rollupContribution = RollupContribution.Default,
      primaryObjective = None,
      nonPrimaryObjectives = Nil,
      childrenSelection = new ChildrenSelection(),
      tracking = Some(new SequencingTracking(completionSetByContent = false, objectiveSetByContent = false)),
      preventChildrenActivation = false,
      constrainChoice = false,
      preConditionRules = Nil, postConditionRules = Nil, exitConditionRules = Nil, rollupRules = Nil)

    val activity = new LeafActivity("org1", "", "", "org1", "res", sequencing = sequencing)
    activityStorage expects 'get returning Some(activity) once()
    service.getMaxTimeAllowed should equal(None)
  }

  it can "get max time allowed" in {
    expectGetStorage()
    val sequencing = new Sequencing(
      sharedId = None,
      sharedSequencingIdReference = None,
      permissions = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = false, forwardOnlyForChildren = false),
      onlyCurrentAttemptObjectiveProgressForChildren = true,
      onlyCurrentAttemptAttemptProgressForChildren = true,
      attemptLimit = None,
      durationLimitInMilliseconds = Some(("100").toLong),
      rollupContribution = RollupContribution.Default,
      primaryObjective = None,
      nonPrimaryObjectives = Nil,
      childrenSelection = new ChildrenSelection(),
      tracking = Some(new SequencingTracking(completionSetByContent = false, objectiveSetByContent = false)),
      preventChildrenActivation = false,
      constrainChoice = false,
      preConditionRules = Nil, postConditionRules = Nil, exitConditionRules = Nil, rollupRules = Nil)

    val activity = new LeafActivity("org1", "", "", "org1", "res", sequencing = sequencing)
    activityStorage expects 'get returning Some(activity) once()
    service.getMaxTimeAllowed should equal(Some("100"))
  }

  it can "return nothing on getScaledPassingScore" in {
    expectGetStorage()
    serviceWithoutCurrentActivity.getScaledPassingScore should equal(None)
  }

  it can "return nothing on getScaledPassingScore if primaryObjective isn't defined" in {
    expectGetStorage()
    val sequencing = new Sequencing(
      sharedId = None,
      sharedSequencingIdReference = None,
      permissions = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = false, forwardOnlyForChildren = false),
      onlyCurrentAttemptObjectiveProgressForChildren = true,
      onlyCurrentAttemptAttemptProgressForChildren = true,
      attemptLimit = None,
      durationLimitInMilliseconds = None,
      rollupContribution = RollupContribution.Default,
      primaryObjective = None,
      nonPrimaryObjectives = Nil,
      childrenSelection = new ChildrenSelection(),
      tracking = Some(new SequencingTracking(completionSetByContent = false, objectiveSetByContent = false)),
      preventChildrenActivation = false,
      constrainChoice = false,
      preConditionRules = Nil, postConditionRules = Nil, exitConditionRules = Nil, rollupRules = Nil)

    val activity = new LeafActivity("org1", "", "", "org1", "res", sequencing = sequencing)
    activityStorage expects 'get returning Some(activity) once()
    service.getScaledPassingScore should equal(None)
  }

  it can "return nothing on getScaledPassingScore if satisfiedByMeasure in primaryObjective isn't defined" in {
    expectGetStorage()
    val sequencing = new Sequencing(
      sharedId = None,
      sharedSequencingIdReference = None,
      permissions = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = false, forwardOnlyForChildren = false),
      onlyCurrentAttemptObjectiveProgressForChildren = true,
      onlyCurrentAttemptAttemptProgressForChildren = true,
      attemptLimit = None,
      durationLimitInMilliseconds = None,
      rollupContribution = RollupContribution.Default,
      primaryObjective = Some(new Objective(id = None, satisfiedByMeasure = false, minNormalizedMeasure = BigDecimal(0))),
      nonPrimaryObjectives = Nil,
      childrenSelection = new ChildrenSelection(),
      tracking = Some(new SequencingTracking(completionSetByContent = false, objectiveSetByContent = false)),
      preventChildrenActivation = false,
      constrainChoice = false,
      preConditionRules = Nil, postConditionRules = Nil, exitConditionRules = Nil, rollupRules = Nil)

    val activity = new LeafActivity("org1", "", "", "org1", "res", sequencing = sequencing)
    activityStorage expects 'get returning Some(activity) once()
    service.getScaledPassingScore should equal(None)
  }

  it can "get scaled passing score" in {
    expectGetStorage()
    val sequencing = new Sequencing(
      sharedId = None,
      sharedSequencingIdReference = None,
      permissions = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = false, forwardOnlyForChildren = false),
      onlyCurrentAttemptObjectiveProgressForChildren = true,
      onlyCurrentAttemptAttemptProgressForChildren = true,
      attemptLimit = None,
      durationLimitInMilliseconds = None,
      rollupContribution = RollupContribution.Default,
      primaryObjective = Some(new Objective(id = None, satisfiedByMeasure = true, minNormalizedMeasure = BigDecimal(0.7))),
      nonPrimaryObjectives = Nil,
      childrenSelection = new ChildrenSelection(),
      tracking = Some(new SequencingTracking(completionSetByContent = false, objectiveSetByContent = false)),
      preventChildrenActivation = false,
      constrainChoice = false,
      preConditionRules = Nil, postConditionRules = Nil, exitConditionRules = Nil, rollupRules = Nil)

    val activity = new LeafActivity("org1", "", "", "org1", "res", sequencing = sequencing)
    activityStorage expects 'get returning Some(activity) once()
    service.getScaledPassingScore should equal(Some("0.7"))
  }

  it can "return default comments from LMS" in {
    expectGetStorage()
    service.getCommentsFromLMS should equal(Map("cmi.comments_from_lms._count" -> Some("0")))
  }

  it can "get empty ADL Data" in {
    expectGetStorage()
    serviceWithoutCurrentActivity.getAdlData should equal(Map("adl.data._count" -> Some("0")))
  }

  it can "get ADL Data" in {
    expectGetStorage()
    val activity = new LeafActivity("org1", "", "", "org1", "res", data = Seq(new ActivityDataMap("e1", false, false), new ActivityDataMap("e2", false, false)))
    activityStorage expects 'get returning Some(activity) once()

    val result = service.getAdlData
    result("adl.data._count") should equal(Some("2"))
    result("adl.data.0.id") should equal(Some("e1"))
    result("adl.data.1.id") should equal(Some("e2"))
  }

  it can "return empty collection on getObjectives" in {
    expectGetStorage()
    serviceWithoutCurrentActivity.getObjectives should equal(Map("cmi.objectives._count" -> Some("0")))
  }

  it can "return nothing on getObjectives if there is no objectives" in {
    expectGetStorage()
    val sequencing = new Sequencing(
      sharedId = None,
      sharedSequencingIdReference = None,
      permissions = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = false, forwardOnlyForChildren = false),
      onlyCurrentAttemptObjectiveProgressForChildren = true,
      onlyCurrentAttemptAttemptProgressForChildren = true,
      attemptLimit = None,
      durationLimitInMilliseconds = None,
      rollupContribution = RollupContribution.Default,
      primaryObjective = None,
      nonPrimaryObjectives = Nil,
      childrenSelection = new ChildrenSelection(),
      tracking = Some(new SequencingTracking(completionSetByContent = false, objectiveSetByContent = false)),
      preventChildrenActivation = false,
      constrainChoice = false,
      preConditionRules = Nil, postConditionRules = Nil, exitConditionRules = Nil, rollupRules = Nil)

    val activity = new LeafActivity("org1", "", "", "org1", "res", sequencing = sequencing)
    activityStorage expects 'get returning Some(activity) once()
    service.getObjectives should equal(Map("cmi.objectives._count" -> Some("0")))
  }

  it can "return nothing on getObjectives if there is primary objective without id and there is no non-primary objectives" in {
    expectGetStorage()
    val sequencing = new Sequencing(
      sharedId = None,
      sharedSequencingIdReference = None,
      permissions = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = false, forwardOnlyForChildren = false),
      onlyCurrentAttemptObjectiveProgressForChildren = true,
      onlyCurrentAttemptAttemptProgressForChildren = true,
      attemptLimit = None,
      durationLimitInMilliseconds = None,
      rollupContribution = RollupContribution.Default,
      primaryObjective = Some(new Objective(id = None, satisfiedByMeasure = false, minNormalizedMeasure = BigDecimal(0))),
      nonPrimaryObjectives = Nil,
      childrenSelection = new ChildrenSelection(),
      tracking = Some(new SequencingTracking(completionSetByContent = false, objectiveSetByContent = false)),
      preventChildrenActivation = false,
      constrainChoice = false,
      preConditionRules = Nil, postConditionRules = Nil, exitConditionRules = Nil, rollupRules = Nil)

    val activity = new LeafActivity("org1", "", "", "org1", "res", sequencing = sequencing)
    activityStorage expects 'get returning Some(activity) once()
    service.getObjectives should equal(Map("cmi.objectives._count" -> Some("0")))
  }

  it can "get primary and non-primary objectives" in {
    expectGetStorage()
    val sequencing = new Sequencing(
      sharedId = None,
      sharedSequencingIdReference = None,
      permissions = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = false, forwardOnlyForChildren = false),
      onlyCurrentAttemptObjectiveProgressForChildren = true,
      onlyCurrentAttemptAttemptProgressForChildren = true,
      attemptLimit = None,
      durationLimitInMilliseconds = None,
      rollupContribution = RollupContribution.Default,
      primaryObjective = Some(new Objective(Some("obj1"), satisfiedByMeasure = true, minNormalizedMeasure = BigDecimal(0.7))),
      nonPrimaryObjectives = Seq(new Objective(Some("obj2"), satisfiedByMeasure = true, minNormalizedMeasure = BigDecimal(0.6)),
        new Objective(Some("obj3"), satisfiedByMeasure = true, minNormalizedMeasure = BigDecimal(0.5))),
      childrenSelection = new ChildrenSelection(),
      tracking = Some(new SequencingTracking(completionSetByContent = false, objectiveSetByContent = false)),
      preventChildrenActivation = false,
      constrainChoice = false,
      preConditionRules = Nil, postConditionRules = Nil, exitConditionRules = Nil, rollupRules = Nil)

    val activity = new LeafActivity("org1", "", "", "org1", "res", sequencing = sequencing)
    activityStorage expects 'get returning Some(activity) once()

    val result = service.getObjectives
    result("cmi.objectives._count") should equal(Some("3"))
    result("cmi.objectives.0.id") should equal(Some("obj1"))
    result("cmi.objectives.1.id") should equal(Some("obj2"))
    result("cmi.objectives.2.id") should equal(Some("obj3"))
  }

  it can "evaluate completion status if completion threshold not defined" in {
    storageFactory expects 'activityStorage returning activityStorage once()
    val service = new DataModelLMSBehavior(someAttempt)(configuration)

    val activity = new ContainerActivity("org1", "", "", "org1", Sequencing.Default, new CompletionThreshold(false, BigDecimal(1), BigDecimal(1)), Set(), true, None)
    activityStorage expects 'get returning Some(activity) once()

    service.evaluateCompletionStatus(None, None) should equal(None)
    service.evaluateCompletionStatus(None, Some("incomplete")) should equal(Some("incomplete"))
    service.evaluateCompletionStatus(None, Some("completed")) should equal(Some("completed"))
    service.evaluateCompletionStatus(Some("0.5"), Some("completed")) should equal(Some("completed"))
    service.evaluateCompletionStatus(Some("0.5"), Some("incomplete")) should equal(Some("incomplete"))
    service.evaluateCompletionStatus(Some("0.5"), None) should equal(None)
  }

  it can "evaluate completion status if completion threshold greater than progress measure or progress measure unknown" in {
    storageFactory expects 'activityStorage returning activityStorage once()
    val service = new DataModelLMSBehavior(someAttempt)(configuration)

    val activity = new ContainerActivity("org1", "", "", "org1", Sequencing.Default, new CompletionThreshold(true, BigDecimal(0.8), BigDecimal(1)), Set(), true, None)
    activityStorage expects 'get returning Some(activity) once()

    service.evaluateCompletionStatus(Some("0.5"), Some("completed")) should equal(Some("incomplete"))
    service.evaluateCompletionStatus(Some("0.5"), Some("incomplete")) should equal(Some("incomplete"))
    service.evaluateCompletionStatus(None, None) should equal(None)
    service.evaluateCompletionStatus(Some("0.5"), None) should equal(Some("incomplete"))
    service.evaluateCompletionStatus(None, Some("completed")) should equal(None)
    service.evaluateCompletionStatus(None, Some("incomplete")) should equal(None)
  }

  it can "evaluate completion status if completion threshold less than progress measure" in {
    storageFactory expects 'activityStorage returning activityStorage once()
    val service = new DataModelLMSBehavior(someAttempt)(configuration)

    val activity = new ContainerActivity("org1", "", "", "org1", Sequencing.Default, new CompletionThreshold(true, BigDecimal(0.8), BigDecimal(1)), Set(), true, None)
    activityStorage expects 'get returning Some(activity) once()

    service.evaluateCompletionStatus(Some("0.9"), Some("incomplete")) should equal(Some("completed"))
    service.evaluateCompletionStatus(Some("0.9"), Some("completed")) should equal(Some("completed"))
    service.evaluateCompletionStatus(Some("0.9"), None) should equal(Some("completed"))
  }

  it can "get success status if scaled passing score not defined" in {
    storageFactory expects 'activityStorage returning activityStorage once()
    val service = new DataModelLMSBehavior(someAttempt)(configuration)

    val activity = new ContainerActivity("org1", "", "", "org1", Sequencing.Default, new CompletionThreshold(false, BigDecimal(1), BigDecimal(1)), Set(), true, None)

    service.getSuccessStatus(None, None, None) should equal(None)
    service.getSuccessStatus(None, None, Some("passed")) should equal(Some("passed"))
    service.getSuccessStatus(None, Some("0.5"), Some("passed")) should equal(Some("passed"))
    service.getSuccessStatus(None, Some("0.5"), None) should equal(None)
  }

  it can "get success status if scaled passing score greater than passing score or passing score unknown" in {
    storageFactory expects 'activityStorage returning activityStorage once()
    val service = new DataModelLMSBehavior(someAttempt)(configuration)

    val activity = new ContainerActivity("org1", "", "", "org1", Sequencing.Default, new CompletionThreshold(true, BigDecimal(0.8), BigDecimal(1)), Set(), true, None)

    service.getSuccessStatus(Some("0.8"), Some("0.5"), Some("passed")) should equal(Some("failed"))
    service.getSuccessStatus(Some("0.8"), None, None) should equal(None)
    service.getSuccessStatus(Some("0.8"), Some("0.5"), None) should equal(Some("failed"))
    service.getSuccessStatus(Some("0.8"), None, Some("passed")) should equal(None)
  }

  it can "get success status if scaled passing score less than passing score" in {
    storageFactory expects 'activityStorage returning activityStorage once()
    val service = new DataModelLMSBehavior(someAttempt)(configuration)

    val activity = new ContainerActivity("org1", "", "", "org1", Sequencing.Default, new CompletionThreshold(true, BigDecimal(0.8), BigDecimal(1)), Set(), true, None)

    service.getSuccessStatus(Some("0.8"), Some("0.9"), Some("passed")) should equal(Some("passed"))
    service.getSuccessStatus(Some("0.8"), Some("0.9"), None) should equal(Some("passed"))
  }*/
}