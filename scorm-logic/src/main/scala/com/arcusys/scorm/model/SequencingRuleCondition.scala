package com.arcusys.scorm.model

case class SequencingRuleCondition(
  /**
   * Type of the sequencing rule condition ('IF <rule>')
   */  
  conditionType: ConditionType.Value,
  /**
   * True if condition should be read as opposite ('NOT')
   */
  inverseCondition: Boolean,
  objectiveId: Option[String],
  measureThreshold: Option[BigDecimal])