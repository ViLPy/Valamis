package com.arcusys.scorm.model
import scala.collection.immutable.IndexedSeq

class ExitConditionRule(conditionCombination: ConditionCombination.Value, conditionCollection: IndexedSeq[SequencingRuleCondition])
  extends SequencingRule(conditionCombination, conditionCollection)