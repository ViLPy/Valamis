package com.arcusys.scorm.model

object RandomizationTimingType extends Enumeration {
  type RandomizationTimingType = Value
  val Never, Once, OnEachNewAttempt = Value
}