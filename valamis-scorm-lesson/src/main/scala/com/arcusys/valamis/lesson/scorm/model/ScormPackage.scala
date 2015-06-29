package com.arcusys.valamis.lesson.scorm.model

import com.arcusys.valamis.lesson.model.PackageBase
import com.arcusys.valamis.lesson.scorm.model.manifest.Metadata
import org.joda.time.DateTime

/**
 * Created by mminin on 13.04.15.
 */
case class ScormPackage(
  id: Long,
  version: Option[String],
  base: Option[String],
  scormVersion: String,
  defaultOrganizationID: Option[String],
  resourcesBase: Option[String],
  title: String,
  summary: Option[String] = None,
  metadata: Option[Metadata] = None,
  assetRefId: Option[Long] = None,
  courseID: Option[Int],

  logo: Option[String] = None,
  beginDate: Option[DateTime],
  endDate: Option[DateTime]) extends PackageBase
