package com.arcusys.learn.scorm.manifest.model

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class LeafActivityTest extends FlatSpec with ShouldMatchers {
  val someMetadata = new Metadata(Seq("meta.xml"), Seq("<info>data</info>"))
  val mainObjective = new Objective(Some("OBJ1"), satisfiedByMeasure = false, minNormalizedMeasure = BigDecimal("1"), globalObjectiveMap = new ObjectiveMap(readSatisfiedStatusFrom = Some("GO1")))
  val otherObjective = new Objective(Some("OBJ2"), satisfiedByMeasure = true, minNormalizedMeasure = BigDecimal("0.5"), globalObjectiveMap = new ObjectiveMap(writeMaxScoreTo = Some("GO2")))
  val preConditionRule = new PreConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityAttempted)), ConditionCombination.All), PreConditionAction.Disabled)
  val postConditionRule = new PostConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityProgressKnown)), ConditionCombination.All), PostConditionAction.Continue)
  val exitConditionRule = new ExitConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.Always)), ConditionCombination.All))
  val rollupRule = new RollupRule(ChildActivitySet.all, new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityCompleted)), ConditionCombination.All), RollupAction.Incomplete)
  val someSequencing = new Sequencing(sharedId = None, sharedSequencingIdReference = Some("SID"),
    permissions = SequencingPermissions.Default,
    onlyCurrentAttemptObjectiveProgressForChildren = false, onlyCurrentAttemptAttemptProgressForChildren = false,
    attemptLimit = Some(2), durationLimitInMilliseconds = Some(50000),
    rollupContribution = RollupContribution.Default,
    primaryObjective = Some(mainObjective), nonPrimaryObjectives = Seq(otherObjective),
    childrenSelection = new ChildrenSelection(Some(new ChildrenSelectionTake(10, RandomizationTimingType.Once)), Some(RandomizationTimingType.OnEachNewAttempt)),
    tracking = Some(new SequencingTracking(completionSetByContent = true, objectiveSetByContent = false)),
    preventChildrenActivation = false, constrainChoice = true,
    preConditionRules = Seq(preConditionRule),
    postConditionRules = Seq(postConditionRule),
    exitConditionRules = Seq(exitConditionRule),
    rollupRules = Seq(rollupRule)
  )
  val someThreshold = new CompletionThreshold(completedByMeasure = true, minProgressMeasure = 0.7, progressWeight = 0.8)
  val someDataMap = Seq(new ActivityDataMap(targetId = "TAR", readSharedData = false, writeSharedData = true))
  "Leaf activity" can "be constructed" in {
    val leaf = new LeafActivity("A11", "Activity 11", parentID = "A1", organizationID = "O1", resourceIdentifier = "RES1",
      resourceParameters = Some("par=A"), timeLimitAction = Some(TimeLimitAction.ContinueMessage),
      dataFromLMS = Some("DA_TA"), data = someDataMap,
      sequencing = someSequencing, completionThreshold = someThreshold,
      hiddenNavigationControls = Set(NavigationControlType.Abandon, NavigationControlType.AbandonAll),
      visible = false, metadata = Some(someMetadata))
    leaf.id should equal("A11")
    leaf.title should equal("Activity 11")
    leaf.parentID should equal(Some("A1"))
    leaf.organizationID should equal("O1")
    leaf.resourceIdentifier should equal("RES1")
    leaf.resourceParameters should equal(Some("par=A"))
    leaf.timeLimitAction should equal(Some(TimeLimitAction.ContinueMessage))
    leaf.dataFromLMS should equal(Some("DA_TA"))
    leaf.data should equal(someDataMap)
    leaf.sequencing should equal(someSequencing)
    leaf.completionThreshold should equal(someThreshold)
    leaf.hiddenNavigationControls should equal(Set(NavigationControlType.Abandon, NavigationControlType.AbandonAll))
    leaf.visible should equal(false)
    leaf.metadata should equal(Some(someMetadata))
  }

  it can "be constructed with defaults" in {
    val leaf = new LeafActivity("A11", "Activity 11", parentID = "A1", organizationID = "O1", resourceIdentifier = "RES1")
    leaf.id should equal("A11")
    leaf.title should equal("Activity 11")
    leaf.parentID should equal(Some("A1"))
    leaf.organizationID should equal("O1")
    leaf.resourceIdentifier should equal("RES1")
    leaf.resourceParameters should equal(None)
    leaf.timeLimitAction should equal(None)
    leaf.dataFromLMS should equal(None)
    leaf.data should equal(Nil)
    leaf.sequencing should equal(Sequencing.Default)
    leaf.completionThreshold should equal(CompletionThreshold.Default)
    leaf.hiddenNavigationControls should equal(Set())
    leaf.visible should equal(true)
    leaf.metadata should equal(None)
  }
}
