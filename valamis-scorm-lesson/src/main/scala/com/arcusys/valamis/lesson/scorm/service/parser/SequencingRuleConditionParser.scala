package com.arcusys.valamis.lesson.scorm.service.parser

import com.arcusys.valamis.lesson.scorm.model.manifest.{ ConditionType, RuleCondition }
import com.arcusys.valamis.util.XMLImplicits
import com.arcusys.valamis.util.XMLImplicits._

import scala.xml.Elem

class SequencingRuleConditionParser(ruleConditionElement: Elem) {
  def parse = {
    val objectiveId = ruleConditionElement attr "referencedObjective" optional string
    val conditionType = ruleConditionElement attr "condition" requiredEnum ConditionType
    val inverse = InverseOperatorParser.parse(ruleConditionElement attr "operator" withDefault "noOp")
    val measureThreshold = ruleConditionElement attr "measureThreshold" optional bigDecimal
    new RuleCondition(conditionType, objectiveId, measureThreshold, inverse)
  }
}