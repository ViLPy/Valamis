package com.arcusys.learn.scorm.manifest.model

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class ContainerActivityTest extends FlatSpec with ShouldMatchers {
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

  "Container activity" can "be constructed" in {
    val container = new ContainerActivity("A11", "Activity 11", parentID = "A1", organizationID = "O1",
      sequencing = someSequencing, completionThreshold = someThreshold,
      hiddenNavigationControls = Set(NavigationControlType.Abandon, NavigationControlType.AbandonAll),
      visible = false, metadata = Some(someMetadata))
    container.id should equal("A11")
    container.title should equal("Activity 11")
    container.parentID should equal(Some("A1"))
    container.organizationID should equal("O1")
    container.sequencing should equal(someSequencing)
    container.completionThreshold should equal(someThreshold)
    container.hiddenNavigationControls should equal(Set(NavigationControlType.Abandon, NavigationControlType.AbandonAll))
    container.visible should equal(false)
    container.metadata should equal(Some(someMetadata))
  }

  it can "be constructed with defaults" in {
    val container = new ContainerActivity("A11", "Activity 11", parentID = "A1", organizationID = "O1")
    container.id should equal("A11")
    container.title should equal("Activity 11")
    container.parentID should equal(Some("A1"))
    container.organizationID should equal("O1")
    container.sequencing should equal(Sequencing.Default)
    container.completionThreshold should equal(CompletionThreshold.Default)
    container.hiddenNavigationControls should equal(Set())
    container.visible should equal(true)
    container.metadata should equal(None)
  }
}
