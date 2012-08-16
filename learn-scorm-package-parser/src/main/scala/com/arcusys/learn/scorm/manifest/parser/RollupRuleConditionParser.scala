package com.arcusys.learn.scorm.manifest.parser

import com.arcusys.learn.util.Extensions._
import com.arcusys.learn.scorm.manifest.model._
import scala.xml.Elem
import XMLImplicits._

class RollupRuleConditionParser(rollupConditionElement: Elem) {
  def parse = {
    val conditionType = rollupConditionElement attr "condition" requiredEnum ConditionType
    if (conditionType oneOf(ConditionType.ObjectiveMeasureGreaterThan, ConditionType.ObjectiveMeasureLessThan, ConditionType.Always)) throw new SCORMParserException("Invalid `condition` attribute value")
    val inverse = InverseOperatorParser.parse(rollupConditionElement attr "operator" withDefault "noOp")
    new RuleCondition(conditionType, inverse = inverse)
  }
}