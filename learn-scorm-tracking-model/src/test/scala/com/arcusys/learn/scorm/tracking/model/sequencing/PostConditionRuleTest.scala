package com.arcusys.learn.scorm.tracking.model.sequencing

import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.tracking.model.{ObjectiveState, ActivityState}

@org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
class PostConditionRuleTest extends ActivityStateTreeTestBase {
  def container(attemptLimit: Option[Int] = None, postConditionRules: Seq[PostConditionRule] = Nil) = containerActivity("C1", Some(organizationId), attemptLimit = attemptLimit, postConditionRules = postConditionRules)

  def activityState(attemptCompleted: Option[Boolean] = None, attemptCount: Int = 0, attemptLimit: Option[Int] = None, objectiveStates: Map[Option[String], ObjectiveState] = Map(), postConditionRules: Seq[PostConditionRule] = Nil) =
    new ActivityState(activity = container(attemptLimit, postConditionRules), active = false, suspended = false, attemptCompleted = attemptCompleted,
      attemptCompletionAmount = None, attemptAbsoluteDuration = 0, attemptExperiencedDuration = 0,
      activityAbsoluteDuration = 0, activityExperiencedDuration = 0, attemptCount = attemptCount, objectiveStates = objectiveStates)

  "Post condition rules" should "return action of first rule if all rules evaluate to true" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = Some(4), attemptCount = 5,
      objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = Some(0), objectiveMapInfo = ObjectiveMap.Empty)),
      postConditionRules = Seq(
        new PostConditionRule(RuleConditionSet(new RuleCondition(ConditionType.ActivityAttemptLimitExceeded)), PostConditionAction.Continue),
        new PostConditionRule(RuleConditionSet(new RuleCondition(ConditionType.ObjectiveMeasureKnown, objectiveId = Some("OBJ1"))), PostConditionAction.ExitAll)
      )
    )
    activity.postConditionRuleAction should equal(Some(PostConditionAction.Continue))
  }

  it should "return action of second rule if first rule evaluates to false" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = Some(4), attemptCount = 3,
      objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = Some(0), objectiveMapInfo = ObjectiveMap.Empty)),
      postConditionRules = Seq(
        new PostConditionRule(RuleConditionSet(new RuleCondition(ConditionType.ActivityAttemptLimitExceeded)), PostConditionAction.Continue),
        new PostConditionRule(RuleConditionSet(new RuleCondition(ConditionType.ObjectiveMeasureKnown, objectiveId = Some("OBJ1"))), PostConditionAction.ExitAll)
      )
    )
    activity.postConditionRuleAction should equal(Some(PostConditionAction.ExitAll))
  }

  it should "return action of first rule if first rule evaluates to true" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = Some(4), attemptCount = 5,
      objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = None, objectiveMapInfo = ObjectiveMap.Empty)),
      postConditionRules = Seq(
        new PostConditionRule(RuleConditionSet(new RuleCondition(ConditionType.ActivityAttemptLimitExceeded)), PostConditionAction.Continue),
        new PostConditionRule(RuleConditionSet(new RuleCondition(ConditionType.ObjectiveMeasureKnown, objectiveId = Some("OBJ1"))), PostConditionAction.ExitAll)
      )
    )
    activity.postConditionRuleAction should equal(Some(PostConditionAction.Continue))
  }

  it should "return action of single rule if evaluates to true" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = Some(4), attemptCount = 5,
      objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = Some(0), objectiveMapInfo = ObjectiveMap.Empty)),
      postConditionRules = Seq(
        new PostConditionRule(RuleConditionSet(new RuleCondition(ConditionType.ObjectiveMeasureKnown, objectiveId = Some("OBJ1"))), PostConditionAction.ExitAll)
      )
    )
    activity.postConditionRuleAction should equal(Some(PostConditionAction.ExitAll))
  }

  it should "return None if all rules are false" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = Some(4), attemptCount = 3,
      objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = None, objectiveMapInfo = ObjectiveMap.Empty)),
      postConditionRules = Seq(
        new PostConditionRule(RuleConditionSet(new RuleCondition(ConditionType.ActivityAttemptLimitExceeded)), PostConditionAction.Continue),
        new PostConditionRule(RuleConditionSet(new RuleCondition(ConditionType.ObjectiveMeasureKnown, objectiveId = Some("OBJ1"))), PostConditionAction.ExitAll)
      )
    )
    activity.postConditionRuleAction should equal(None)
  }

  it should "return None if single rule is false" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = Some(4), attemptCount = 3,
      objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = None, objectiveMapInfo = ObjectiveMap.Empty)),
      postConditionRules = Seq(
        new PostConditionRule(RuleConditionSet(new RuleCondition(ConditionType.ObjectiveMeasureKnown, objectiveId = Some("OBJ1"))), PostConditionAction.ExitAll)
      )
    )
    activity.postConditionRuleAction should equal(None)
  }

  it should "return None if there're no rules" in {
    val activity = activityState(attemptCompleted = Some(false), attemptLimit = Some(4), attemptCount = 3,
      objectiveStates = Map(Some("OBJ1") -> new ObjectiveState(satisfied = Some(true), normalizedMeasure = None, objectiveMapInfo = ObjectiveMap.Empty)),
      postConditionRules = Nil
    )
    activity.postConditionRuleAction should equal(None)
  }
}
