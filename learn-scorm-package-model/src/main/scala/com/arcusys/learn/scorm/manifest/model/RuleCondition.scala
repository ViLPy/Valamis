package com.arcusys.learn.scorm.manifest.model

import com.arcusys.learn.util.Extensions._

/**
 * A single condition for invoking a rule
 * @param conditionType     Type of condition
 * @param objectiveId       ID of local objective to check status of when evaluating the condition.
 *                          If not set and condition needs an objective, activity's primary objective is assumed
 * @param measureThreshold  Measure threshold value if condition is measure-based
 * @param inverse           True if condition should be treated as opposite
 */
class RuleCondition
(
  val conditionType: ConditionType.Value,
  val objectiveId: Option[String] = None,
  val measureThreshold: Option[BigDecimal] = None,
  val inverse: Boolean = false
  ) {
  import ConditionType._
  measureThreshold match {
    case Some(value) => {
      require(value between(-1, 1), "Measure threshold should be between -1 and 1")
      require(conditionType oneOf (ObjectiveMeasureGreaterThan, ObjectiveMeasureLessThan), "Measure threshold is meaningless for this condition type")
    }
    case None => {
      require (conditionType noneOf (ObjectiveMeasureGreaterThan, ObjectiveMeasureLessThan), "Measure threshold needed for this condition type")
    }
  }
  /*if (objectiveId.isDefined)
    require (
      conditionType oneOf (ObjectiveSatisfied, ObjectiveStatusKnown, ObjectiveMeasureKnown, ObjectiveMeasureGreaterThan, ObjectiveMeasureLessThan),
      "Objective ID is meaningless for this condition type"
    )*/
}