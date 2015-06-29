package com.arcusys.valamis.lesson.scorm.service.sequencing

import com.arcusys.valamis.lesson.scorm.model.sequencing.{ SequencingResponse, SequencingRequestType }
import com.arcusys.valamis.lesson.scorm.model.tracking.ActivityStateTree

/**
 * Sequencing Request Process [SB.2.12] - contract
 * Validates the sequencing request
 */
trait SequencingRequestServiceContract {
  /**
   * Sequencing Request Process [SB.2.12]
   * Validates the sequencing request
   * @param tree              Activity state tree for attempt
   * @param requestType       Type of the sequencing request
   * @param targetActivityID  ID of the target activity; has sense only for Choice and Jump requests
   * @return                  A delivery request; may indicate control be returned to the LTS; may return an exception code
   */
  def apply(tree: ActivityStateTree, requestType: SequencingRequestType.Value, targetActivityID: String = ""): SequencingResponse
}
