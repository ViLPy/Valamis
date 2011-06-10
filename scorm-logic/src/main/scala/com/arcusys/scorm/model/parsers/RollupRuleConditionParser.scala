package com.arcusys.scorm.model.parsers

import com.arcusys.scorm.model._
import scala.xml.Elem
import XMLImplicits._

class RollupRuleConditionParser(rollupConditionElement: Elem) {
  def parse = {    
    val conditionType = TokenParser.parseRuleConditionType(rollupConditionElement %! "condition")
    if ((conditionType == ConditionType.ObjectiveMeasureGreaterThan) || (conditionType == ConditionType.ObjectiveMeasureLessThan) || (conditionType == ConditionType.Always))
      throw new SCORMParserException("Invalid `condition` attribute value");    
    val inverse = TokenParser.parseIsInverseRuleOperator((rollupConditionElement %? "operator").getOrElse("noOp"))
    new RollupRuleCondition(conditionType, inverse)
  }
}