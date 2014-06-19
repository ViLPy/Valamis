package com.arcusys.learn.scorm.tracking.model.sequencing

import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.tracking.model.{ ObjectiveState, ActivityState }

@org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
class PreConditionRuleTest extends ActivityStateTreeTestBase {
  def container(attemptLimit: Option[Int] = None, preConditionRules: Seq[PreConditionRule] = Nil) = containerActivity("C1", Some(organizationId), attemptLimit = attemptLimit, preConditionRules = preConditionRules)

  def activityState(attemptCompleted: Option[Boolean] = None, attemptCount: Int = 0, attemptLimit: Option[Int] = None, objectiveStates: Map[Option[String], ObjectiveState] = Map(), preConditionRules: Seq[PreConditionRule] = Nil) =
    new ActivityState(activity = container(attemptLimit, preConditionRules), active = false, suspended = false, attemptCompleted = attemptCompleted,
      attemptCompletionAmount = None, attemptAbsoluteDuration = 0, attemptExperiencedDuration = 0,
      activityAbsoluteDuration = 0, activityExperiencedDuration = 0, attemptCount = attemptCount, objectiveStates = objectiveStates)

  "Pre condition rules" should "evaluate to true if all rules are true" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = Some(4), attemptCount = 5,
      objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = Some(0), objectiveMapInfo = ObjectiveMap.Empty)),
      preConditionRules = Seq(
        new PreConditionRule(RuleConditionSet(new RuleCondition(ConditionType.ActivityAttemptLimitExceeded)), PreConditionAction.HiddenFromChoice),
        new PreConditionRule(RuleConditionSet(new RuleCondition(ConditionType.ObjectiveMeasureKnown, objectiveId = Some("OBJ1"))), PreConditionAction.HiddenFromChoice)
      )
    )
    activity.preConditionRuleApplies(PreConditionAction.HiddenFromChoice) should equal(true)
  }

  it should "evaluate to true if at least one rule is true" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = Some(4), attemptCount = 3,
      objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = Some(0), objectiveMapInfo = ObjectiveMap.Empty)),
      preConditionRules = Seq(
        new PreConditionRule(RuleConditionSet(new RuleCondition(ConditionType.ActivityAttemptLimitExceeded)), PreConditionAction.HiddenFromChoice),
        new PreConditionRule(RuleConditionSet(new RuleCondition(ConditionType.ObjectiveMeasureKnown, objectiveId = Some("OBJ1"))), PreConditionAction.HiddenFromChoice)
      )
    )
    activity.preConditionRuleApplies(PreConditionAction.HiddenFromChoice) should equal(true)
  }

  it should "evaluate to true if single rule is true" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = Some(4), attemptCount = 3,
      objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = Some(0), objectiveMapInfo = ObjectiveMap.Empty)),
      preConditionRules = Seq(
        new PreConditionRule(RuleConditionSet(new RuleCondition(ConditionType.ObjectiveMeasureKnown, objectiveId = Some("OBJ1"))), PreConditionAction.HiddenFromChoice)
      )
    )
    activity.preConditionRuleApplies(PreConditionAction.HiddenFromChoice) should equal(true)
  }

  it should "evaluate to false if all rules are false" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = Some(4), attemptCount = 3,
      objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = None, objectiveMapInfo = ObjectiveMap.Empty)),
      preConditionRules = Seq(
        new PreConditionRule(RuleConditionSet(new RuleCondition(ConditionType.ActivityAttemptLimitExceeded)), PreConditionAction.HiddenFromChoice),
        new PreConditionRule(RuleConditionSet(new RuleCondition(ConditionType.ObjectiveMeasureKnown, objectiveId = Some("OBJ1"))), PreConditionAction.HiddenFromChoice)
      )
    )
    activity.preConditionRuleApplies(PreConditionAction.HiddenFromChoice) should equal(false)
  }

  it should "evaluate to true if single rule is false" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = Some(4), attemptCount = 3,
      objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = None, objectiveMapInfo = ObjectiveMap.Empty)),
      preConditionRules = Seq(
        new PreConditionRule(RuleConditionSet(new RuleCondition(ConditionType.ObjectiveMeasureKnown, objectiveId = Some("OBJ1"))), PreConditionAction.HiddenFromChoice)
      )
    )
    activity.preConditionRuleApplies(PreConditionAction.HiddenFromChoice) should equal(false)
  }

  it should "evaluate to false if there're no rules" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = Some(4), attemptCount = 3,
      objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = None, objectiveMapInfo = ObjectiveMap.Empty)),
      preConditionRules = Nil
    )
    activity.preConditionRuleApplies(PreConditionAction.HiddenFromChoice) should equal(false)
  }

  it should "consider only rules with given action" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = Some(4), attemptCount = 3,
      objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = None, objectiveMapInfo = ObjectiveMap.Empty)),
      preConditionRules = Seq(
        new PreConditionRule(RuleConditionSet(new RuleCondition(ConditionType.ActivityAttemptLimitExceeded)), PreConditionAction.HiddenFromChoice),
        new PreConditionRule(RuleConditionSet(new RuleCondition(ConditionType.ObjectiveMeasureKnown, objectiveId = Some("OBJ1"))), PreConditionAction.HiddenFromChoice),
        new PreConditionRule(RuleConditionSet(new RuleCondition(ConditionType.Always)), PreConditionAction.Skip)
      )
    )
    activity.preConditionRuleApplies(PreConditionAction.HiddenFromChoice) should equal(false)
  }
}
