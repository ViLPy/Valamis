package com.arcusys.learn.scorm.tracking.model.sequencing

object TerminationRequestType extends Enumeration {
  type TerminationRequestType = Value
  val Exit, ExitParent, ExitAll, SuspendAll, Abandon, AbandonAll = Value

  def forNavigationRequest(navigationRequest: NavigationRequestType.Value): TerminationRequestType.Value =
    navigationRequest match {
      case NavigationRequestType.Start | NavigationRequestType.ResumeAll |
        NavigationRequestType.Continue | NavigationRequestType.Previous |
        NavigationRequestType.Choice | NavigationRequestType.Jump | NavigationRequestType.Exit => Exit
      case NavigationRequestType.ExitAll    => ExitAll
      case NavigationRequestType.SuspendAll => SuspendAll
      case NavigationRequestType.Abandon    => Abandon
      case NavigationRequestType.AbandonAll => AbandonAll
    }
}