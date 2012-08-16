package com.arcusys.scorm.lms.sequencing

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