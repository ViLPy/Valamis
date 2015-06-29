package com.arcusys.valamis.lesson.scorm.service.parser

import com.arcusys.valamis.lesson.scorm.model.manifest.{ ConditionType, RuleCondition }
import com.arcusys.valamis.util.XMLImplicits
import com.arcusys.valamis.util.XMLImplicits._
import com.arcusys.valamis.util.CollectionExtensions._

import scala.xml.Elem

class RollupRuleConditionParser(rollupConditionElement: Elem) {
  def parse = {
    val conditionType = rollupConditionElement attr "condition" requiredEnum ConditionType
    if (conditionType oneOf (ConditionType.ObjectiveMeasureGreaterThan, ConditionType.ObjectiveMeasureLessThan, ConditionType.Always)) throw new SCORMParserException("Invalid `condition` attribute value")
    val inverse = InverseOperatorParser.parse(rollupConditionElement attr "operator" withDefault "noOp")
    new RuleCondition(conditionType, inverse = inverse)
  }
}