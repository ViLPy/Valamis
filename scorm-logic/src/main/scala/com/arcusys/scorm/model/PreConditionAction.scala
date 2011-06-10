package com.arcusys.scorm.model

object PreConditionAction extends Enumeration {
  type PreConditionAction = Value
  val Skip, Disabled, HiddenFromChoice, StopForwardTraversal = Value
}