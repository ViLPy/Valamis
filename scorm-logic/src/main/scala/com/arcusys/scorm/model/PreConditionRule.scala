package com.arcusys.scorm.model
import scala.collection.immutable.IndexedSeq

class PreConditionRule(
  conditionCombination: ConditionCombination.Value,
  conditionCollection: IndexedSeq[SequencingRuleCondition],
  /**
   * Rule action
   */
  val action: PreConditionAction.Value) extends SequencingRule(conditionCombination, conditionCollection)