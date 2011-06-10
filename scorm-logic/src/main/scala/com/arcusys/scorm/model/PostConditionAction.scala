package com.arcusys.scorm.model

object PostConditionAction extends Enumeration {
  type PostConditionAction = Value
  val ExitParent, ExitAll, Retry, RetryAll, Continue, Previous = Value
}