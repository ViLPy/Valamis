package com.arcusys.learn.scorm.tracking.model.sequencing

object SequencingRequestType extends Enumeration {
  type SequencingRequestType = Value
  val Start, ResumeAll, Continue, Previous, Choice, Retry, Exit, Jump = Value

  def forNavigationRequest(navigationRequest: NavigationRequestType.Value): SequencingRequestType.Value =
    navigationRequest match {
      case NavigationRequestType.Start     => Start
      case NavigationRequestType.ResumeAll => ResumeAll
      case NavigationRequestType.Continue  => Continue
      case NavigationRequestType.Previous  => Previous
      case NavigationRequestType.Choice    => Choice
      case NavigationRequestType.Jump      => Jump
      case NavigationRequestType.Exit | NavigationRequestType.ExitAll | NavigationRequestType.SuspendAll |
        NavigationRequestType.Abandon | NavigationRequestType.AbandonAll => Exit
    }
}