package com.arcusys.valamis.lesson.scorm.service.sequencing

import com.arcusys.valamis.lesson.scorm.model.tracking.ActivityStateNode

/**
 * Processes for finishing attempts - contract
 */
trait EndAttemptServiceContract {

  /**
   * End Attempt Process [UP.4] for an activity
   * May set 'attempt completed' and 'primary objective satisfied'
   * Clears 'active' flag
   * Rolls up activity
   */
  def apply(activity: ActivityStateNode)
}