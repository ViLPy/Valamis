package com.arcusys.scorm.model

object RollupConsiderationType extends Enumeration {
  type RollupConsiderationType = Value
  val Always, IfAttempted, IfNotSkipped, IfNotSuspended = Value
}