package com.arcusys.learn.scorm.manifest.model

/**
 * Information about how activity is tracked - used only for tracked activities
 * @param completionSetByContent  Attempt completion status will be set by the SCO
 * @param objectiveSetByContent   Objective satisfied status will be set by the SCO
 */
class SequencingTracking(
  val completionSetByContent: Boolean,
  val objectiveSetByContent: Boolean)

/**
 * Factory for sequencing tracking
 */
object SequencingTracking {
  /**
   * Default sequencing tracking (everything set by sequencing, not content)
   */
  val Default = new SequencingTracking(completionSetByContent = false, objectiveSetByContent = false)
}