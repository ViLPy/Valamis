package com.arcusys.learn.scorm.tracking.model.sequencing

import com.arcusys.learn.scorm.tracking.model.ActivityStateTree

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