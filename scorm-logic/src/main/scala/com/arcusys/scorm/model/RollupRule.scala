package com.arcusys.scorm.model
import scala.collection.mutable.Buffer

class RollupRule(
  /**
   * What child activities are to meet the rule conditions
   */
  val childActivitySet: ChildActivitySet.Value,
  /**
   * Minimum amount of child activities to meet the rule conditions (if childActivitySet = atLeastCount)
   */
  val minimumCount: Int,
  /**
   * Minimum share of child activities to meet the rule conditions (if childActivitySet = atLeastPercent)
   */
  val minimumPercent: BigDecimal,
  /**
   * How rule conditions are combined when evaluating the rule
   */
  val conditionCombination: ConditionCombination.Value,
  /**
   * Rule action
   */
  val action: RollupAction.Value) {
  /**
   * Rule conditions
   */ 
  val conditions = Buffer[RollupRuleCondition]()
}