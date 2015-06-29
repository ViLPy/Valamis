package com.arcusys.valamis.lesson.scorm.model.manifest

/** A condition for a rule */
object ConditionType extends Enumeration {
  type ConditionType = Value
  val ObjectiveSatisfied = Value("satisfied")
  val ObjectiveStatusKnown = Value("objectiveStatusKnown")
  val ObjectiveMeasureKnown = Value("objectiveMeasureKnown")
  val ObjectiveMeasureGreaterThan = Value("objectiveMeasureGreaterThan")
  val ObjectiveMeasureLessThan = Value("objectiveMeasureLessThan")
  val ActivityCompleted = Value("completed")
  val ActivityProgressKnown = Value("activityProgressKnown")
  val ActivityAttempted = Value("attempted")
  val ActivityAttemptLimitExceeded = Value("attemptLimitExceeded")
  val TimeLimitExceeded = Value("timeLimitExceeded")
  val OutsideAvailableTimeRange = Value("outsideAvailableTimeRange")
  val Always = Value("always")
}