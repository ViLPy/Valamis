package com.arcusys.scorm.model.parsers
import com.arcusys.scorm.model._
import XMLImplicits._
import scala.xml.Elem

class SequencingRuleConditionParser(ruleConditionElement: Elem) {
  def parse = {
    val objectiveId = ruleConditionElement %? "referencedObjective"
    val conditionType = TokenParser.parseRuleConditionType(ruleConditionElement %! "condition")
    val inverse = TokenParser.parseIsInverseRuleOperator((ruleConditionElement %? "operator").getOrElse("noOp"))
    val measureThreshold = (ruleConditionElement %?  "measureThreshold").map(BigDecimal(_))
    if ((measureThreshold.getOrElse(BigDecimal(0)) > 1) || (measureThreshold.getOrElse(BigDecimal(0)) < -1)) throw new SCORMParserException("Invalid `measureThreshold` attribute value")
    SequencingRuleCondition(conditionType,inverse,objectiveId,measureThreshold)
  }
}