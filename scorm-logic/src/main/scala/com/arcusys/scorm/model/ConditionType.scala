package com.arcusys.scorm.model

object ConditionType extends Enumeration {
  type ConditionType = Value
  val ObjectiveSatisfied, ObjectiveStatusKnown, ObjectiveMeasureKnown, ObjectiveMeasureGreaterThan, ObjectiveMeasureLessThan, ActivityCompleted, ActivityProgressKnown, ActivityAttempted, ActivityAttemptLimitExceeded, TimeLimitExceeded, OutsideAvailableTimeRange, Always = Value
}