package com.arcusys.learn.scorm.manifest.model

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class RollupRuleTest extends FlatSpec with ShouldMatchers {
  val condition1 = new RuleCondition(ConditionType.ActivityAttempted)
  val condition2 = new RuleCondition(ConditionType.ObjectiveStatusKnown)
  val conditions = Seq(condition1, condition2)

  "Rollup rule" can "be constructed" in {
    val set = new RuleConditionSet(conditions, ConditionCombination.All)
    val rule = new RollupRule(ChildActivitySet.all, set, RollupAction.Completed)
    rule.childActivitySet should equal(ChildActivitySetAll)
    rule.conditions should equal(set)
    rule.action should equal(RollupAction.Completed)
  }
  it can "not be constructed if the condition set includes ObjectiveMeasureGreaterThan" in {
    val set = new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityAttempted), new RuleCondition(ConditionType.ObjectiveMeasureGreaterThan, Some("O1"), Some(0.5))), ConditionCombination.All)
    intercept[IllegalArgumentException] {
      new RollupRule(ChildActivitySet.all, set, RollupAction.Completed)
    }
  }

  it can "not be constructed if the condition set includes ObjectiveMeasureLessThan" in {
    val set = new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityAttempted), new RuleCondition(ConditionType.ObjectiveMeasureLessThan, Some("O1"), Some(0.5))), ConditionCombination.All)
    intercept[IllegalArgumentException] {
      new RollupRule(ChildActivitySet.all, set, RollupAction.Completed)
    }
  }

  it can "not be constructed if the condition set includes Always" in {
    val set = new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityAttempted), new RuleCondition(ConditionType.Always)), ConditionCombination.All)
    intercept[IllegalArgumentException] {
      new RollupRule(ChildActivitySet.all, set, RollupAction.Completed)
    }
  }
}
