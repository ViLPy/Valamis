package com.arcusys.valamis.lesson.scorm.model.manifest

import com.arcusys.valamis.util.CollectionExtensions._

/**
 * Information about completion threshold and progress weight
 * @param completedByMeasure  It true, minProgressMeasure should be used to determine if activity is completed
 * @param minProgressMeasure  Minimal progress to treat activity as completed [0..1]
 * @param progressWeight      Weighting factor applied to activity' progress measure used during completion rollup of parent [0..1]
 */

class CompletionThreshold(
    val completedByMeasure: Boolean,
    val minProgressMeasure: BigDecimal,
    val progressWeight: BigDecimal) {
  require(minProgressMeasure between (0, 1), "min progress measure should be between 0 and 1")
  require(progressWeight between (0, 1), "progress weight should be between 0 and 1")
}

/**Factory methods for completion threshold*/
object CompletionThreshold {
  /**Default completion threshold*/
  val Default = new CompletionThreshold(false, BigDecimal(1), BigDecimal(1))
}