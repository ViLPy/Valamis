package com.arcusys.scorm.model
import scala.collection.immutable.IndexedSeq

abstract class SequencingRule(
  /**
   * How rule conditions are combined when evaluating the rule
   */
  val conditionCombination: ConditionCombination.Value,
  /**
   * Rule conditions
   */
  val conditions: IndexedSeq[SequencingRuleCondition])