package com.arcusys.scorm.lms.sequencing.model

object NavigationRequestType extends Enumeration {
  type NavigationRequestType = Value
  val Start = Value("start")
  val ResumeAll = Value("resumeAll")
  val Continue = Value("continue")
  val Previous = Value("previous")
  val Choice = Value("choice")
  val Jump = Value("jump")
  val Exit = Value("exit")
  val ExitAll = Value("exitAll")
  val SuspendAll = Value("suspendAll")
  val Abandon = Value("abandon")
  val AbandonAll = Value("abandonAll")
}
