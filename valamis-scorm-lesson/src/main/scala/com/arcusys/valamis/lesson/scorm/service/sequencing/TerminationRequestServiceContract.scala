package com.arcusys.valamis.lesson.scorm.service.sequencing

import com.arcusys.valamis.lesson.scorm.model.sequencing.{ TerminationResponse, TerminationRequestType }
import com.arcusys.valamis.lesson.scorm.model.tracking.ActivityStateTree

/**
 * Termination Request Process [TB.2.3]
 * Ends the current attempt on the Current Activity
 */
trait TerminationRequestServiceContract {
  /**
   * Termination Request Process [TB.2.3]
   * Ends the current attempt on the Current Activity
   * @param tree        Activity state tree for attempt
   * @param requestType termination request
   * @return validity of the termination request; may return a sequencing request; may return an exception code
   */
  def apply(tree: ActivityStateTree, requestType: TerminationRequestType.Value): TerminationResponse
}