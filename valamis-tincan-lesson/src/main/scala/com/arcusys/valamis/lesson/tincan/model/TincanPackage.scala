package com.arcusys.valamis.lesson.tincan.model

import com.arcusys.valamis.lesson.model.PackageBase
import org.joda.time.DateTime

case class TincanPackage(
  id: Long,
  title: String,
  summary: Option[String],
  courseID: Option[Int],
  assetRefId: Option[Long],
  logo: Option[String],
  beginDate: Option[DateTime],
  endDate: Option[DateTime]) extends PackageBase
