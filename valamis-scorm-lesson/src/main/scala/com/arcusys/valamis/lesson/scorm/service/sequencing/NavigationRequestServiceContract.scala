package com.arcusys.valamis.lesson.scorm.service.sequencing

import com.arcusys.valamis.lesson.scorm.model.sequencing.{ NavigationResponse, NavigationRequestType }
import com.arcusys.valamis.lesson.scorm.model.tracking.ActivityStateTree

/**
 * Navigation Request Process [NB.2.1] - contract
 * Checks if a navigation request is valid and whether termination is required to process it.
 * Does not change attempt state / tracking information
 */
trait NavigationRequestServiceContract {
  /**
   * Navigation Request Process [NB.2.1]
   * @param tree        Activity state tree for attempt
   * @param requestType       Type of the navigation request
   * @param targetActivityId  ID of the target activity; has sense only for Choice and Jump requests
   * @return Validity of the navigation request + whether termination is needed
   */
  def apply(tree: ActivityStateTree, requestType: NavigationRequestType.Value, targetActivityId: String = ""): NavigationResponse
}
