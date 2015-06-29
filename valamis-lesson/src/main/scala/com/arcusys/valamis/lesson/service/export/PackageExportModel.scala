package com.arcusys.valamis.lesson.service.export

import org.joda.time.DateTime

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
  packageFile: String,
  beginDate: Option[DateTime],
  endDate: Option[DateTime])

