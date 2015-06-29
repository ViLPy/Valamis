package com.arcusys.valamis.lesson.scorm.model.sequencing

import com.arcusys.valamis.lesson.scorm.model.tracking.ActivityStateTree

/**
 * Sequencing process response model for handling overall process results
 */

sealed abstract class ProcessorResponse {}

case class ProcessorResponseDelivery(tree: ActivityStateTree) extends ProcessorResponse

case class ProcessorResponseEndSession(tree: ActivityStateTree) extends ProcessorResponse

object ProcessorResponse {
  def apply(tree: ActivityStateTree) = ProcessorResponseDelivery(tree)
  def endSession(tree: ActivityStateTree) = ProcessorResponseEndSession(tree)
}