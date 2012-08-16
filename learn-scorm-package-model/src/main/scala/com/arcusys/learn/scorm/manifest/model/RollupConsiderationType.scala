package com.arcusys.learn.scorm.manifest.model

/** When to include activity in rollup for parent */
object RollupConsiderationType extends Enumeration {
  type RollupConsiderationType = Value
  /** Include always */
  val Always = Value("always")
  /** Include if attempted */
  val IfAttempted = Value("ifAttempted")
  /** Include if was not skipped */
  val IfNotSkipped = Value("ifNotSkipped")
  /** Include if was not suspended */
  val IfNotSuspended = Value("ifNotSuspended")
}