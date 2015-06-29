package com.arcusys.valamis.lesson.scorm.service.parser

import com.arcusys.valamis.lesson.scorm.model.manifest._
import com.arcusys.valamis.util.XMLImplicits
import com.arcusys.valamis.util.XMLImplicits._

import scala.xml.Elem

class RollupRuleParser(val rollupRuleElement: Elem) {
  def parse = {
    val childActivitySet = rollupRuleElement attr "childActivitySet" withDefault "all"
    val minimumCount = rollupRuleElement attr "minimumCount" withDefault 0
    val minimumPercent = rollupRuleElement attr "minimumPercent" withDefault BigDecimal("0.0")
    val rollupConditionsElement = rollupRuleElement childElem ("imsss", "rollupConditions") required element
    val conditionCombination = rollupConditionsElement attr "conditionCombination" withDefault (ConditionCombination, ConditionCombination.Any)
    val action = rollupRuleElement childElem ("imsss", "rollupAction") required element attr "action" requiredEnum RollupAction
    val conditions = rollupConditionsElement children ("imsss", "rollupCondition") map parseRollupRuleCondition
    new RollupRule(ChildActivitySet.parse(childActivitySet, Some(minimumCount), Some(minimumPercent)), new RuleConditionSet(conditions, conditionCombination), action)
  }
}