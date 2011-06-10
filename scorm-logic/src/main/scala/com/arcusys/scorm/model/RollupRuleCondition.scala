package com.arcusys.scorm.model

case class RollupRuleCondition(
  /**
   * Type of the rollup rule condition ('IF <rule>')
   */
  conditionType: ConditionType.Value,
  /**
   * True if condition should be read as opposite ('NOT')
   */
  inverseCondition: Boolean)