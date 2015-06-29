package com.arcusys.valamis.lesson.scorm.model.sequencing

import com.arcusys.valamis.lesson.scorm.model.tracking.ActivityStateNode

/**
 * Sequencing request response model for handling sequencing request result
 * taken from Sequencing Request Process [SB.2.12] (SN SCORM book)
 */

sealed abstract class SequencingResponse {}

case class SequencingResponseDelivery(deliveryRequest: ActivityStateNode) extends SequencingResponse

case object SequencingResponseEndSession extends SequencingResponse

case object SequencingResponseEmpty extends SequencingResponse

case object SequencingResponseInvalid extends SequencingResponse

object SequencingResponse {

  def invalid(message: String) = {
    SequencingResponseInvalid
  }

  def delivery(deliveryRequest: ActivityStateNode) = SequencingResponseDelivery(deliveryRequest)

  def endSession = SequencingResponseEndSession

  def empty = SequencingResponseEmpty
}