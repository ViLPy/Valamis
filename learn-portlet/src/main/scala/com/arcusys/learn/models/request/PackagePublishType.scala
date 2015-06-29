package com.arcusys.learn.models.request

object PackagePublishType extends Enumeration {
  val Scorm = Value("scorm")
  val TinCan = Value("tincan")

  type PackagePublishType = Value
}
