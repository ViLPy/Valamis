package com.arcusys.learn.bl.export.packages

import com.arcusys.learn.scorm.manifest.model.PeriodType.PeriodType

case class PackageExportModel(
  packageType: String,
  title: String,
  summary: Option[String],
  visibility: Option[Boolean],
  default: Boolean,
  passingLimit: Int,
  rerunInterval: Int,
  rerunIntervalType: String,
  logo: String,
  packageFile: String)

