package com.arcusys.learn.models.request

object PackagePublishType extends Enumeration {
  val SCORM = Value("scorm")
  val TinCan = Value("tincan")

  type PackagePublishType = Value
}
