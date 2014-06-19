package com.arcusys.learn.scorm.manifest.model

import com.arcusys.learn.util.Extensions._

/**
 * Information about how activity contributes to the evaluation of its parent's Satisfied and Not Satisfied rollup rules
 * @param contributeToSatisfied     The way activity contributes to rolled up Satisfied status of parent
 * @param contributeToNotSatisfied  The way activity contributes to rolled up Not Satisfied status of parent
 */
class SatisfactionRollupContribution(
  val contributeToSatisfied: RollupConsiderationType.Value,
  val contributeToNotSatisfied: RollupConsiderationType.Value)

/**
 * Information about how activity contributes to the evaluation of its parent's Completed and Incomplete rollup rules
 * @param contributeToCompleted     The way activity contributes to rolled up Completed status of parent
 * @param contributeToIncomplete    The way activity contributes to rolled up Incomplete status of parent
 */
class CompletionRollupContribution(
  val contributeToCompleted: RollupConsiderationType.Value,
  val contributeToIncomplete: RollupConsiderationType.Value)

/**
 * Information about how activity contributes to container's rollup
 * @param satisfaction                  How activity contributes to the evaluation of its parent's Satisfied and Not Satisfied rollup rules. None if it doesn't
 * @param completion                    How activity contributes to the evaluation of its parent's Completed and Incomplete rollup rules. None if it doesn't
 * @param objectiveMeasureWeight        Weighting factor applied to the objective's normalized measure used during rollup for the parent activity
 * @param measureSatisfactionIfActive   Measure should be used to determine satisfaction during rollup when activity is active
 */
class RollupContribution(
    val satisfaction: Option[SatisfactionRollupContribution],
    val completion: Option[CompletionRollupContribution],
    val objectiveMeasureWeight: BigDecimal,
    val measureSatisfactionIfActive: Boolean) {
  require(objectiveMeasureWeight between (0, 1))
}

/**
 * Factory for rollup contribution
 */
object RollupContribution {
  /**
   * Default rollup contribution - contributes to everything always with measure weight 1
   */
  val Default = new RollupContribution(
    satisfaction = Some(new SatisfactionRollupContribution(contributeToSatisfied = RollupConsiderationType.Always, contributeToNotSatisfied = RollupConsiderationType.Always)),
    completion = Some(new CompletionRollupContribution(contributeToCompleted = RollupConsiderationType.Always, contributeToIncomplete = RollupConsiderationType.Always)),
    objectiveMeasureWeight = 1,
    measureSatisfactionIfActive = true
  )
}
