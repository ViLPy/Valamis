package com.arcusys.scorm.model

object TimeLimitAction extends Enumeration {
  type TimeLimitAction = Value
  val NotDefined, ExitMessage, ExitNoMessage, ContinueMessage, ContinueNoMessage = Value
}