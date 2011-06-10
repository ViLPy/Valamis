package com.arcusys.scorm.model.parsers

import com.arcusys.scorm.model._
import scala.xml.Elem
import XMLImplicits._

class RollupRuleParser(val rollupRuleElement: Elem) {
  def parse = {
    val childActivitySet = (rollupRuleElement %? "childActivitySet").getOrElse("all")
    val minimumCount = (rollupRuleElement %? "minimumCount").getOrElse("0")
    val minimumPercent = (rollupRuleElement %? "minimumPercent").getOrElse("0.0")
    val rollupConditionsElement = rollupRuleElement \! ("imsss","rollupConditions")
    val conditionCombination = (rollupConditionsElement %? "conditionCombination").getOrElse("any")
    val ruleActionElement = rollupRuleElement \! ("imsss","ruleAction")
    val ruleAction = ruleActionElement %! "action"

    val rollupRule = new RollupRule(
      TokenParser.parseChildActivitySet(childActivitySet),
      minimumCount.toInt,
      BigDecimal.apply(minimumPercent),
      TokenParser.parseConditionCombination(conditionCombination),
      TokenParser.parseRollupAction(ruleAction));    
    for (rollupConditionElement <- rollupConditionsElement \!! ("imsss","rollupCondition"))
      rollupRule.conditions += new RollupRuleConditionParser(rollupConditionElement.asInstanceOf[Elem]).parse
    rollupRule
  }
}