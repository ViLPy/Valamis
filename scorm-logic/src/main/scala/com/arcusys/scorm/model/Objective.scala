package com.arcusys.scorm.model
import scala.collection.mutable.Map

class Objective(
  /**
   * True if comparison against minNormalizedMeasure shall be used to determine if objective is satisfied
   */
  val satisfiedByMeasure: Boolean,
  /**
   * Objective identifier (mandatory for non-primary objectives and if an objective has a map)
   */
  val identifier: Option[String],
  /**
   * Minimum satisfaction measure for objective
   */
  val minNormalizedMeasure: BigDecimal) {
  /**
   * Maps this objective to global objectives by ID
   */  
  val objectiveMap = Map [String, ObjectiveMapInfo]()
}