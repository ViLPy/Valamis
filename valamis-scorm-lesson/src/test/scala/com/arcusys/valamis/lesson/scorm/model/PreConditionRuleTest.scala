package com.arcusys.valamis.lesson.scorm.model

import com.arcusys.valamis.lesson.scorm.model.manifest._
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class PreConditionRuleTest extends FlatSpec with ShouldMatchers {
  val condition1 = new RuleCondition(ConditionType.ActivityAttempted)
  val condition2 = new RuleCondition(ConditionType.ObjectiveStatusKnown)
  val conditions = Seq(condition1, condition2)

  "Pre-condition rule" can "be constructed" in {
    val set = new RuleConditionSet(conditions, ConditionCombination.All)
    val rule = new PreConditionRule(set, PreConditionAction.Disabled)
    rule.conditions should equal(set)
    rule.action should equal(PreConditionAction.Disabled)
  }
}
