package com.arcusys.scorm.model

object NavigationControlType extends Enumeration {
  type NavigationControlType = Value
  val Previous, Continue, Exit, ExitAll, Abandon, AbandonAll, SuspendAll = Value
}