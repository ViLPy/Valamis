package com.arcusys.scorm.model
import scala.collection.immutable.IndexedSeq

class PostConditionRule(
  conditionCombination: ConditionCombination.Value,
  conditionCollection: IndexedSeq[SequencingRuleCondition],
  /**
   * Rule action
   */
  val action: PostConditionAction.Value) extends SequencingRule(conditionCombination, conditionCollection)