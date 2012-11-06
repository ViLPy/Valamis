package com.arcusys.learn.scorm.tracking.model.sequencing

import org.slf4j.LoggerFactory

// Termination request response model for handling termination request result
// taken from Termination Request Process [TB.2.3] (SN SCORM book)

sealed abstract class TerminationResponse {}

case class TerminationResponseValid(sequencingRequest: Option[SequencingRequestType.Value] = None) extends TerminationResponse

case object TerminationResponseInvalid extends TerminationResponse

object TerminationResponse {
  private val LOG = LoggerFactory.getLogger(classOf[TerminationResponse])

  def invalid(message: String) = {
    LOG.warn(message)
    TerminationResponseInvalid
  }

  def apply(sequencingRequest: SequencingRequestType.Value) = TerminationResponseValid(Some(sequencingRequest))
}