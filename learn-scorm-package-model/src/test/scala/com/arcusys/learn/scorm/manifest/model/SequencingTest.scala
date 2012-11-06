package com.arcusys.learn.scorm.manifest.model

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class SequencingTest extends FlatSpec with ShouldMatchers {
  "Sequencing" can "be constructed" in {
    val mainObjective = new Objective(Some("OBJ1"), satisfiedByMeasure = false, minNormalizedMeasure = BigDecimal("1"), globalObjectiveMap = new ObjectiveMap(readSatisfiedStatusFrom = Some("GO1")))
    val otherObjective = new Objective(Some("OBJ2"), satisfiedByMeasure = true, minNormalizedMeasure = BigDecimal("0.5"), globalObjectiveMap = new ObjectiveMap(writeMaxScoreTo = Some("GO2")))
    val preConditionRule = new PreConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityAttempted)), ConditionCombination.All), PreConditionAction.Disabled)
    val postConditionRule = new PostConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityProgressKnown)), ConditionCombination.All), PostConditionAction.Continue)
    val exitConditionRule = new ExitConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.Always)), ConditionCombination.All))
    val rollupRule = new RollupRule(ChildActivitySet.all, new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityCompleted)), ConditionCombination.All), RollupAction.Incomplete)
    val sequencing = new Sequencing(sharedId = None, sharedSequencingIdReference = Some("SID"),
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
    sequencing.sharedId should equal(None)
    sequencing.sharedSequencingIdReference should equal(Some("SID"))
    sequencing.permissions should equal(SequencingPermissions.Default)
    sequencing.onlyCurrentAttemptObjectiveProgressForChildren should equal(false)
    sequencing.onlyCurrentAttemptAttemptProgressForChildren should equal(false)
    sequencing.attemptLimit should equal(Some(2))
    sequencing.durationLimitInMilliseconds should equal(Some(50000))
    sequencing.rollupContribution should equal(RollupContribution.Default)
    sequencing.primaryObjective should equal(Some(mainObjective))
    sequencing.nonPrimaryObjectives should equal(Seq(otherObjective))
    sequencing.childrenSelection.take.get.count should equal(10)
    sequencing.childrenSelection.take.get.timing should equal(RandomizationTimingType.Once)
    sequencing.childrenSelection.reorder.get should equal(RandomizationTimingType.OnEachNewAttempt)
    sequencing.tracking.get.completionSetByContent should equal(true)
    sequencing.tracking.get.objectiveSetByContent should equal(false)
    sequencing.preventChildrenActivation should equal(false)
    sequencing.constrainChoice should equal(true)
    sequencing.preConditionRules should equal(Seq(preConditionRule))
    sequencing.postConditionRules should equal(Seq(postConditionRule))
    sequencing.exitConditionRules should equal(Seq(exitConditionRule))
    sequencing.rollupRules should equal(Seq(rollupRule))
  }

  it should "have a default value" in {
    val sequencing = Sequencing.Default
    sequencing.sharedId should equal(None)
    sequencing.sharedSequencingIdReference should equal(None)
    sequencing.permissions should equal(SequencingPermissions.Default)
    sequencing.onlyCurrentAttemptObjectiveProgressForChildren should equal(true)
    sequencing.onlyCurrentAttemptAttemptProgressForChildren should equal(true)
    sequencing.attemptLimit should equal(None)
    sequencing.durationLimitInMilliseconds should equal(None)
    sequencing.rollupContribution should equal(RollupContribution.Default)
    sequencing.primaryObjective should not equal(None)
    sequencing.nonPrimaryObjectives should equal(Nil)
    sequencing.childrenSelection.take should equal(None)
    sequencing.childrenSelection.reorder should equal(None)
    sequencing.tracking should equal(Some(SequencingTracking.Default))
    sequencing.preventChildrenActivation should equal(false)
    sequencing.constrainChoice should equal(false)
    sequencing.preConditionRules should equal(Nil)
    sequencing.postConditionRules should equal(Nil)
    sequencing.exitConditionRules should equal(Nil)
    sequencing.rollupRules should equal(Nil)
  }

  it can "not construct with non-primary objective ID not defined" in {
    val mainObjective = new Objective(Some("OBJ1"), satisfiedByMeasure = false, minNormalizedMeasure = BigDecimal("1"), globalObjectiveMap = new ObjectiveMap(readSatisfiedStatusFrom = Some("GO1")))
    val otherObjective = new Objective(Some("OBJ2"), satisfiedByMeasure = true, minNormalizedMeasure = BigDecimal("0.5"), globalObjectiveMap = new ObjectiveMap(writeMaxScoreTo = Some("GO2")))
    val yetAnotherObjective = new Objective(None, satisfiedByMeasure = true, minNormalizedMeasure = BigDecimal("0.5"), globalObjectiveMap = new ObjectiveMap(writeMaxScoreTo = Some("GO3")))
    val preConditionRule = new PreConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityAttempted)), ConditionCombination.All), PreConditionAction.Disabled)
    val postConditionRule = new PostConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityProgressKnown)), ConditionCombination.All), PostConditionAction.Continue)
    val exitConditionRule = new ExitConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.Always)), ConditionCombination.All))
    val rollupRule = new RollupRule(ChildActivitySet.all, new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityCompleted)), ConditionCombination.All), RollupAction.Incomplete)
    intercept[IllegalArgumentException] {
      new Sequencing(sharedId = None, sharedSequencingIdReference = Some("SID"),
        permissions = SequencingPermissions.Default,
        onlyCurrentAttemptObjectiveProgressForChildren = false, onlyCurrentAttemptAttemptProgressForChildren = false,
        attemptLimit = Some(2), durationLimitInMilliseconds = Some(50000),
        rollupContribution = RollupContribution.Default,
        primaryObjective = Some(mainObjective), nonPrimaryObjectives = Seq(otherObjective, yetAnotherObjective),
        childrenSelection = new ChildrenSelection(Some(new ChildrenSelectionTake(10, RandomizationTimingType.Once)), Some(RandomizationTimingType.OnEachNewAttempt)),
        tracking = Some(new SequencingTracking(completionSetByContent = true, objectiveSetByContent = false)),
        preventChildrenActivation = false, constrainChoice = true,
        preConditionRules = Seq(preConditionRule),
        postConditionRules = Seq(postConditionRule),
        exitConditionRules = Seq(exitConditionRule),
        rollupRules = Seq(rollupRule)
      )
    }
  }

  it can "not construct with non-unique non-primary objective IDs" in {
    val mainObjective = new Objective(Some("OBJ1"), satisfiedByMeasure = false, minNormalizedMeasure = BigDecimal("1"), globalObjectiveMap = new ObjectiveMap(readSatisfiedStatusFrom = Some("GO1")))
    val otherObjective = new Objective(Some("OBJ2"), satisfiedByMeasure = true, minNormalizedMeasure = BigDecimal("0.5"), globalObjectiveMap = new ObjectiveMap(writeMaxScoreTo = Some("GO2")))
    val yetAnotherObjective = new Objective(Some("OBJ2"), satisfiedByMeasure = true, minNormalizedMeasure = BigDecimal("0.5"), globalObjectiveMap = new ObjectiveMap(writeMaxScoreTo = Some("GO3")))
    val preConditionRule = new PreConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityAttempted)), ConditionCombination.All), PreConditionAction.Disabled)
    val postConditionRule = new PostConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityProgressKnown)), ConditionCombination.All), PostConditionAction.Continue)
    val exitConditionRule = new ExitConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.Always)), ConditionCombination.All))
    val rollupRule = new RollupRule(ChildActivitySet.all, new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityCompleted)), ConditionCombination.All), RollupAction.Incomplete)
    intercept[IllegalArgumentException] {
      new Sequencing(sharedId = None, sharedSequencingIdReference = Some("SID"),
        permissions = SequencingPermissions.Default,
        onlyCurrentAttemptObjectiveProgressForChildren = false, onlyCurrentAttemptAttemptProgressForChildren = false,
        attemptLimit = Some(2), durationLimitInMilliseconds = Some(50000),
        rollupContribution = RollupContribution.Default,
        primaryObjective = Some(mainObjective), nonPrimaryObjectives = Seq(otherObjective, yetAnotherObjective),
        childrenSelection = new ChildrenSelection(Some(new ChildrenSelectionTake(10, RandomizationTimingType.Once)), Some(RandomizationTimingType.OnEachNewAttempt)),
        tracking = Some(new SequencingTracking(completionSetByContent = true, objectiveSetByContent = false)),
        preventChildrenActivation = false, constrainChoice = true,
        preConditionRules = Seq(preConditionRule),
        postConditionRules = Seq(postConditionRule),
        exitConditionRules = Seq(exitConditionRule),
        rollupRules = Seq(rollupRule)
      )
    }
  }

  it can "not construct with primary objective ID equal to non-primary objective ID" in {
    val mainObjective = new Objective(Some("OBJ1"), satisfiedByMeasure = false, minNormalizedMeasure = BigDecimal("1"), globalObjectiveMap = new ObjectiveMap(readSatisfiedStatusFrom = Some("GO1")))
    val otherObjective = new Objective(Some("OBJ2"), satisfiedByMeasure = true, minNormalizedMeasure = BigDecimal("0.5"), globalObjectiveMap = new ObjectiveMap(writeMaxScoreTo = Some("GO2")))
    val yetAnotherObjective = new Objective(Some("OBJ1"), satisfiedByMeasure = true, minNormalizedMeasure = BigDecimal("0.5"), globalObjectiveMap = new ObjectiveMap(writeMaxScoreTo = Some("GO3")))
    val preConditionRule = new PreConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityAttempted)), ConditionCombination.All), PreConditionAction.Disabled)
    val postConditionRule = new PostConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityProgressKnown)), ConditionCombination.All), PostConditionAction.Continue)
    val exitConditionRule = new ExitConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.Always)), ConditionCombination.All))
    val rollupRule = new RollupRule(ChildActivitySet.all, new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityCompleted)), ConditionCombination.All), RollupAction.Incomplete)
    intercept[IllegalArgumentException] {
      new Sequencing(sharedId = None, sharedSequencingIdReference = Some("SID"),
        permissions = SequencingPermissions.Default,
        onlyCurrentAttemptObjectiveProgressForChildren = false, onlyCurrentAttemptAttemptProgressForChildren = false,
        attemptLimit = Some(2), durationLimitInMilliseconds = Some(50000),
        rollupContribution = RollupContribution.Default,
        primaryObjective = Some(mainObjective), nonPrimaryObjectives = Seq(otherObjective, yetAnotherObjective),
        childrenSelection = new ChildrenSelection(Some(new ChildrenSelectionTake(10, RandomizationTimingType.Once)), Some(RandomizationTimingType.OnEachNewAttempt)),
        tracking = Some(new SequencingTracking(completionSetByContent = true, objectiveSetByContent = false)),
        preventChildrenActivation = false, constrainChoice = true,
        preConditionRules = Seq(preConditionRule),
        postConditionRules = Seq(postConditionRule),
        exitConditionRules = Seq(exitConditionRule),
        rollupRules = Seq(rollupRule)
      )
    }
  }

  it can "not construct breaking global objective map 'write' attribute multiplicity" in {
    val mainObjective = new Objective(Some("OBJ1"), satisfiedByMeasure = false, minNormalizedMeasure = BigDecimal("1"), globalObjectiveMap = new ObjectiveMap(readSatisfiedStatusFrom = Some("GO1")))
    val otherObjective = new Objective(Some("OBJ2"), satisfiedByMeasure = true, minNormalizedMeasure = BigDecimal("0.5"), globalObjectiveMap = new ObjectiveMap(writeMaxScoreTo = Some("GO2")))
    val yetAnotherObjective = new Objective(Some("OBJ3"), satisfiedByMeasure = true, minNormalizedMeasure = BigDecimal("0.5"), globalObjectiveMap = new ObjectiveMap(writeMaxScoreTo = Some("GO2")))
    val preConditionRule = new PreConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityAttempted)), ConditionCombination.All), PreConditionAction.Disabled)
    val postConditionRule = new PostConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityProgressKnown)), ConditionCombination.All), PostConditionAction.Continue)
    val exitConditionRule = new ExitConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.Always)), ConditionCombination.All))
    val rollupRule = new RollupRule(ChildActivitySet.all, new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityCompleted)), ConditionCombination.All), RollupAction.Incomplete)
    intercept[IllegalArgumentException] {
      new Sequencing(sharedId = None, sharedSequencingIdReference = Some("SID"),
        permissions = SequencingPermissions.Default,
        onlyCurrentAttemptObjectiveProgressForChildren = false, onlyCurrentAttemptAttemptProgressForChildren = false,
        attemptLimit = Some(2), durationLimitInMilliseconds = Some(50000),
        rollupContribution = RollupContribution.Default,
        primaryObjective = Some(mainObjective), nonPrimaryObjectives = Seq(otherObjective, yetAnotherObjective),
        childrenSelection = new ChildrenSelection(Some(new ChildrenSelectionTake(10, RandomizationTimingType.Once)), Some(RandomizationTimingType.OnEachNewAttempt)),
        tracking = Some(new SequencingTracking(completionSetByContent = true, objectiveSetByContent = false)),
        preventChildrenActivation = false, constrainChoice = true,
        preConditionRules = Seq(preConditionRule),
        postConditionRules = Seq(postConditionRule),
        exitConditionRules = Seq(exitConditionRule),
        rollupRules = Seq(rollupRule)
      )
    }
  }
}
