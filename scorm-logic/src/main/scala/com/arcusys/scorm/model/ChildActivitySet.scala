package com.arcusys.scorm.model

object ChildActivitySet extends Enumeration {
  type ChildActivitySet = Value
  val All, Any, None, AtLeastCount, AtLeastPercent = Value
}