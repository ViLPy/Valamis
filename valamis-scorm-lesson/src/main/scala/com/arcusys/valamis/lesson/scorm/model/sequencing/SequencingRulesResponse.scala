package com.arcusys.valamis.lesson.scorm.model.sequencing

case class SequencingRulesResponse(terminationRequest: Option[TerminationRequestType.Value] = None,
  sequencingRequest: Option[SequencingRequestType.Value] = None)

object SequencingRulesResponse {
  //That ugly option is to avoid type erasure clashes
  def termination(terminationRequest: TerminationRequestType.Value) = new SequencingRulesResponse(terminationRequest = Some(terminationRequest))

  def sequencing(sequencingRequest: SequencingRequestType.Value) = new SequencingRulesResponse(sequencingRequest = Some(sequencingRequest))

  def apply(terminationRequest: TerminationRequestType.Value, sequencingRequest: SequencingRequestType.Value) =
    new SequencingRulesResponse(terminationRequest = Some(terminationRequest), sequencingRequest = Some(sequencingRequest))
}
