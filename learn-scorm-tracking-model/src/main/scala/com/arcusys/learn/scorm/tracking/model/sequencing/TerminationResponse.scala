package com.arcusys.learn.scorm.tracking.model.sequencing


// Termination request response model for handling termination request result
// taken from Termination Request Process [TB.2.3] (SN SCORM book)

sealed abstract class TerminationResponse {}

case class TerminationResponseValid(sequencingRequest: Option[SequencingRequestType.Value] = None) extends TerminationResponse

case object TerminationResponseInvalid extends TerminationResponse

object TerminationResponse {

  def invalid(message: String) = {
    TerminationResponseInvalid
  }

  def apply(sequencingRequest: SequencingRequestType.Value) = TerminationResponseValid(Some(sequencingRequest))
}