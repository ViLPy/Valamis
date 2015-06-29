package com.arcusys.valamis.lesson.scorm.model.manifest

import com.arcusys.valamis.util.CollectionExtensions._

/**
 * An objective for an activity. Can be listed as a primary or non-primary objective in the activity's Sequencing
 * @param id                    Objective identifier (mandatory for non-primary objectives and if an objective has a map)
 * @param satisfiedByMeasure    True if comparison against minNormalizedMeasure shall be used to determine if objective is satisfied
 * @param minNormalizedMeasure  Minimum satisfaction measure for objective
 * @param globalObjectiveMap    Describes mapping from this objective to a global objective
 */
class Objective(
    val id: Option[String],
    val satisfiedByMeasure: Boolean,
    val minNormalizedMeasure: BigDecimal,
    val globalObjectiveMap: ObjectiveMap = ObjectiveMap.Empty) {
  require(minNormalizedMeasure between (-1, 1), "min normalized measure should be between -1 and 1, but was " + minNormalizedMeasure)
}