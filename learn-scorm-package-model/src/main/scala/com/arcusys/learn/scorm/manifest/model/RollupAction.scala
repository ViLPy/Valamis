package com.arcusys.learn.scorm.manifest.model

/**Rollup rule action*/
object RollupAction extends Enumeration {
  type RollupAction = Value
  /** Rollup satisfied status */
  val Satisfied = Value("satisfied")
  /** Rollup not satisfied status */
  val NotSatisfied = Value("notSatisfied")
  /** Rollup completed  status */
  val Completed = Value("completed")
  /** Rollup incomplete status */
  val Incomplete = Value("incomplete")
}