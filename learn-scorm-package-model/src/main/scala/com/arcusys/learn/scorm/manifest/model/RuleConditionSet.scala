package com.arcusys.learn.scorm.manifest.model

/**
 * A set of rule conditions combined with logical AND or OR
 * @param conditions  Individual conditions (at least one)
 * @param combination Condition logical combination type
 */
class RuleConditionSet(val conditions: Seq[RuleCondition], val combination: ConditionCombination.Value) {
  require(conditions.size > 0, "At least one condition should be specified")
}

/**Companion object with some nice condition set methods */
object RuleConditionSet {
  /**An AND-combination of rules */
  def allOf(conditions: RuleCondition*) = new RuleConditionSet(conditions, ConditionCombination.All)

  /**An OR-combination of rules*/
  def anyOf(conditions: RuleCondition*) = new RuleConditionSet(conditions, ConditionCombination.Any)

  /**A set of a single rule */
  def apply(condition: RuleCondition) = new RuleConditionSet(Seq(condition), ConditionCombination.Any)
}