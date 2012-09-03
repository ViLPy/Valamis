package com.arcusys.learn.scorm.tracking.model.sequencing

import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.tracking.model.{ObjectiveState, ActivityState}

@org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
class RuleConditionTest extends ActivityStateTreeTestBase {
  def container(attemptLimit: Option[Int] = None) = containerActivity("C1", Some(organizationId), attemptLimit = attemptLimit)

  def activityState(attemptCompleted: Option[Boolean] = None, attemptCount: Int = 0, attemptLimit: Option[Int] = None, objectiveStates: Map[Option[String], ObjectiveState] = Map()) =
    new ActivityState(activity = container(attemptLimit), active = false, suspended = false, attemptCompleted = attemptCompleted,
      attemptCompletionAmount = None, attemptAbsoluteDuration = 0, attemptExperiencedDuration = 0,
      activityAbsoluteDuration = 0, activityExperiencedDuration = 0, attemptCount = attemptCount, objectiveStates = objectiveStates)


  "'Objective satisfied'" should "evaluate to false if objective progress is not known (Table 3.4.2a 1)" in {
    val activity = activityState(objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = None, normalizedMeasure = None, objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionApplies(new RuleCondition(ConditionType.ObjectiveSatisfied, objectiveId = Some("OBJ1"))) should equal(false)
  }

  it should "evaluate to false if objective is not satisfied (Table 3.4.2a 1)" in {
    val activity = activityState(objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(false), normalizedMeasure = None, objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionApplies(new RuleCondition(ConditionType.ObjectiveSatisfied, objectiveId = Some("OBJ1"))) should equal(false)
  }

  it should "evaluate to true if objective is satisfied (Table 3.4.2a 1)" in {
    val activity = activityState(objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = None, objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionApplies(new RuleCondition(ConditionType.ObjectiveSatisfied, objectiveId = Some("OBJ1"))) should equal(true)
  }

  "'Objective status known'" should "evaluate to false if objective progress is not known (Table 3.4.2a 2)" in {
    val activity = activityState(objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = None, normalizedMeasure = None, objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionApplies(new RuleCondition(ConditionType.ObjectiveStatusKnown, objectiveId = Some("OBJ1"))) should equal(false)
  }

  it should "evaluate to true if objective is not satisfied (Table 3.4.2a 2)" in {
    val activity = activityState(objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(false), normalizedMeasure = None, objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionApplies(new RuleCondition(ConditionType.ObjectiveStatusKnown, objectiveId = Some("OBJ1"))) should equal(true)
  }

  it should "evaluate to true if objective is satisfied (Table 3.4.2a 2)" in {
    val activity = activityState(objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = None, objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionApplies(new RuleCondition(ConditionType.ObjectiveStatusKnown, objectiveId = Some("OBJ1"))) should equal(true)
  }

  "'Objective measure known'" should "evaluate to false if objective measure is not known (Table 3.4.2a 3)" in {
    val activity = activityState(objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = None, normalizedMeasure = None, objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionApplies(new RuleCondition(ConditionType.ObjectiveMeasureKnown, objectiveId = Some("OBJ1"))) should equal(false)
  }

  it should "evaluate to true if objective normalized measure is 0 (Table 3.4.2a 3)" in {
    val activity = activityState(objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = Some(0), objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionApplies(new RuleCondition(ConditionType.ObjectiveMeasureKnown, objectiveId = Some("OBJ1"))) should equal(true)
  }

  it should "evaluate to true if objective normalized measure is negative (Table 3.4.2a 3)" in {
    val activity = activityState(objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = Some(-0.5), objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionApplies(new RuleCondition(ConditionType.ObjectiveMeasureKnown, objectiveId = Some("OBJ1"))) should equal(true)
  }

  it should "evaluate to true if objective normalized measure is positive (Table 3.4.2a 3)" in {
    val activity = activityState(objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = Some(1), objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionApplies(new RuleCondition(ConditionType.ObjectiveMeasureKnown, objectiveId = Some("OBJ1"))) should equal(true)
  }

  "'Objective measure greater than'" should "evaluate to false if objective measure is not known (Table 3.4.2a 4)" in {
    val activity = activityState(objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = None, normalizedMeasure = None, objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionApplies(new RuleCondition(ConditionType.ObjectiveMeasureGreaterThan, objectiveId = Some("OBJ1"), measureThreshold = Some(0.3))) should equal(false)
  }

  it should "evaluate to false if objective measure is less than threshold (Table 3.4.2a 4)" in {
    val activity = activityState(objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = None, normalizedMeasure = Some(0.2), objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionApplies(new RuleCondition(ConditionType.ObjectiveMeasureGreaterThan, objectiveId = Some("OBJ1"), measureThreshold = Some(0.3))) should equal(false)
  }

  it should "evaluate to false if objective measure is equal to threshold (Table 3.4.2a 4)" in {
    val activity = activityState(objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = None, normalizedMeasure = Some(0), objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionApplies(new RuleCondition(ConditionType.ObjectiveMeasureGreaterThan, objectiveId = Some("OBJ1"), measureThreshold = Some(0))) should equal(false)
  }

  it should "evaluate to true if objective measure is greater than threshold (Table 3.4.2a 4)" in {
    val activity = activityState(objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = None, normalizedMeasure = Some(0.4), objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionApplies(new RuleCondition(ConditionType.ObjectiveMeasureGreaterThan, objectiveId = Some("OBJ1"), measureThreshold = Some(0.3))) should equal(true)
  }

  "'Objective measure less than'" should "evaluate to false if objective measure is not known (Table 3.4.2a 5)" in {
    val activity = activityState(objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = None, normalizedMeasure = None, objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionApplies(new RuleCondition(ConditionType.ObjectiveMeasureLessThan, objectiveId = Some("OBJ1"), measureThreshold = Some(0.3))) should equal(false)
  }

  it should "evaluate to false if objective measure is greater than threshold (Table 3.4.2a 5)" in {
    val activity = activityState(objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = None, normalizedMeasure = Some(0.4), objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionApplies(new RuleCondition(ConditionType.ObjectiveMeasureLessThan, objectiveId = Some("OBJ1"), measureThreshold = Some(0.3))) should equal(false)
  }

  it should "evaluate to false if objective measure is equal to threshold (Table 3.4.2a 5)" in {
    val activity = activityState(objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = None, normalizedMeasure = Some(0), objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionApplies(new RuleCondition(ConditionType.ObjectiveMeasureLessThan, objectiveId = Some("OBJ1"), measureThreshold = Some(0))) should equal(false)
  }

  it should "evaluate to true if objective measure is less than threshold (Table 3.4.2a 5)" in {
    val activity = activityState(objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = None, normalizedMeasure = Some(0.1), objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionApplies(new RuleCondition(ConditionType.ObjectiveMeasureLessThan, objectiveId = Some("OBJ1"), measureThreshold = Some(0.3))) should equal(true)
  }

  "'Activity completed'" should "evaluate to false if activity progess is not known (Table 3.4.2a 6)" in {
    val activity = activityState(attemptCompleted = None)
    activity.conditionApplies(new RuleCondition(ConditionType.ActivityCompleted)) should equal(false)
  }

  it should "evaluate to false if activity is not completed (Table 3.4.2a 6)" in {
    val activity = activityState(attemptCompleted = Some(false))
    activity.conditionApplies(new RuleCondition(ConditionType.ActivityCompleted)) should equal(false)
  }

  it should "evaluate to true if activity is completed (Table 3.4.2a 6)" in {
    val activity = activityState(attemptCompleted = Some(true))
    activity.conditionApplies(new RuleCondition(ConditionType.ActivityCompleted)) should equal(true)
  }

  "'Activity progress known'" should "evaluate to false if activity progess is not known (Table 3.4.2a 7)" in {
    val activity = activityState(attemptCompleted = None)
    activity.conditionApplies(new RuleCondition(ConditionType.ActivityProgressKnown)) should equal(false)
  }

  it should "evaluate to true if activity is not completed (Table 3.4.2a 7)" in {
    val activity = activityState(attemptCompleted = Some(false))
    activity.conditionApplies(new RuleCondition(ConditionType.ActivityProgressKnown)) should equal(true)
  }

  it should "evaluate to true if activity is completed (Table 3.4.2a 7)" in {
    val activity = activityState(attemptCompleted = Some(true))
    activity.conditionApplies(new RuleCondition(ConditionType.ActivityProgressKnown)) should equal(true)
  }

  "'Activity attempted'" should "evaluate to false for activity count = 0 (Table 3.4.2a 8)" in {
    val activity = activityState(attemptCount = 0)
    activity.conditionApplies(new RuleCondition(ConditionType.ActivityAttempted)) should equal(false)
  }

  it should "evaluate to true for activity count = 1 (Table 3.4.2a 8)" in {
    val activity = activityState(attemptCount = 1)
    activity.conditionApplies(new RuleCondition(ConditionType.ActivityAttempted)) should equal(true)
  }

  it should "evaluate to true for activity count = 100 (Table 3.4.2a 8)" in {
    val activity = activityState(attemptCount = 100)
    activity.conditionApplies(new RuleCondition(ConditionType.ActivityAttempted)) should equal(true)
  }

  "'Activity attempt limit exceeded'" should "evaluate to false if activity progess is not known (Table 3.4.2a 9)" in {
    val activity = activityState(attemptCompleted = None, attemptLimit = Some(5), attemptCount = 7)
    activity.conditionApplies(new RuleCondition(ConditionType.ActivityAttemptLimitExceeded)) should equal(false)
  }

  it should "evaluate to false if attempt limit is not defined (Table 3.4.2a 9)" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = None, attemptCount = 7)
    activity.conditionApplies(new RuleCondition(ConditionType.ActivityAttemptLimitExceeded)) should equal(false)
  }

  it should "evaluate to false if attempt count is less than attempt limit (Table 3.4.2a 9)" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = Some(5), attemptCount = 4)
    activity.conditionApplies(new RuleCondition(ConditionType.ActivityAttemptLimitExceeded)) should equal(false)
  }

  it should "evaluate to true if attempt count is equal to attempt limit (Table 3.4.2a 9)" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = Some(4), attemptCount = 4)
    activity.conditionApplies(new RuleCondition(ConditionType.ActivityAttemptLimitExceeded)) should equal(true)
  }

  it should "evaluate to true if attempt count is greater than attempt limit (Table 3.4.2a 9)" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = Some(4), attemptCount = 5)
    activity.conditionApplies(new RuleCondition(ConditionType.ActivityAttemptLimitExceeded)) should equal(true)
  }

  "'Always'" should "evaluate to true" in {
    val activity = activityState()
    activity.conditionApplies(new RuleCondition(ConditionType.Always)) should equal(true)
  }

  it should "evaluate to false when inversed" in {
    val activity = activityState()
    activity.conditionApplies(new RuleCondition(ConditionType.Always, inverse = true)) should equal(false)
  }

  "'Time limit exceeded'" should "evaluate to false" in {
    val activity = activityState()
    activity.conditionApplies(new RuleCondition(ConditionType.TimeLimitExceeded)) should equal(false)
  }

  "'Outside available time range'" should "evaluate to false" in {
    val activity = activityState()
    activity.conditionApplies(new RuleCondition(ConditionType.OutsideAvailableTimeRange)) should equal(false)
  }

  "'All' condition set" should "evaluate to true if all conditions are true" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = Some(4), attemptCount = 5,
      objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = Some(0), objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionSetApplies(new RuleConditionSet(Seq(
      new RuleCondition(ConditionType.ActivityAttemptLimitExceeded),
      new RuleCondition(ConditionType.ObjectiveMeasureKnown, objectiveId = Some("OBJ1"))
    ), ConditionCombination.All)) should equal(true)
  }

  it should "evaluate to false if one of the conditions is false" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = Some(4), attemptCount = 3,
      objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = Some(0), objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionSetApplies(new RuleConditionSet(Seq(
      new RuleCondition(ConditionType.ActivityAttemptLimitExceeded),
      new RuleCondition(ConditionType.ObjectiveMeasureKnown, objectiveId = Some("OBJ1"))
    ), ConditionCombination.All)) should equal(false)
  }

  it should "evaluate to false if another one of the conditions is false" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = Some(4), attemptCount = 5,
      objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = None, objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionSetApplies(new RuleConditionSet(Seq(
      new RuleCondition(ConditionType.ActivityAttemptLimitExceeded),
      new RuleCondition(ConditionType.ObjectiveMeasureKnown, objectiveId = Some("OBJ1"))
    ), ConditionCombination.All)) should equal(false)
  }

  it should "evaluate to false if all conditions are false" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = Some(4), attemptCount = 3,
      objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = None, objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionSetApplies(new RuleConditionSet(Seq(
      new RuleCondition(ConditionType.ActivityAttemptLimitExceeded),
      new RuleCondition(ConditionType.ObjectiveMeasureKnown, objectiveId = Some("OBJ1"))
    ), ConditionCombination.All)) should equal(false)
  }

  "'Any' condition set" should "evaluate to true if all conditions are true" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = Some(4), attemptCount = 5,
      objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = Some(0), objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionSetApplies(new RuleConditionSet(Seq(
      new RuleCondition(ConditionType.ActivityAttemptLimitExceeded),
      new RuleCondition(ConditionType.ObjectiveMeasureKnown, objectiveId = Some("OBJ1"))
    ), ConditionCombination.Any)) should equal(true)
  }

  it should "evaluate to true if one of the conditions is false" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = Some(4), attemptCount = 3,
      objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = Some(0), objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionSetApplies(new RuleConditionSet(Seq(
      new RuleCondition(ConditionType.ActivityAttemptLimitExceeded),
      new RuleCondition(ConditionType.ObjectiveMeasureKnown, objectiveId = Some("OBJ1"))
    ), ConditionCombination.Any)) should equal(true)
  }

  it should "evaluate to true if another one of the conditions is false" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = Some(4), attemptCount = 5,
      objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = None, objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionSetApplies(new RuleConditionSet(Seq(
      new RuleCondition(ConditionType.ActivityAttemptLimitExceeded),
      new RuleCondition(ConditionType.ObjectiveMeasureKnown, objectiveId = Some("OBJ1"))
    ), ConditionCombination.Any)) should equal(true)
  }

  it should "evaluate to false if all conditions are false" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = Some(4), attemptCount = 3,
      objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = None, objectiveMapInfo = ObjectiveMap.Empty)))
    activity.conditionSetApplies(new RuleConditionSet(Seq(
      new RuleCondition(ConditionType.ActivityAttemptLimitExceeded),
      new RuleCondition(ConditionType.ObjectiveMeasureKnown, objectiveId = Some("OBJ1"))
    ), ConditionCombination.Any)) should equal(false)
  }
}
