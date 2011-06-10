package com.arcusys.scorm.model

object RollupAction extends Enumeration {
  type RollupAction = Value
  val Satisfied, NotSatisfied, Completed, Incomplete = Value
}