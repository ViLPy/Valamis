package com.arcusys.learn.scorm.manifest.model

import org.joda.time._

case class PackageGrade(userId: Long,
  packageId: Long,
  grade: String,
  comment: String,
  date: Option[DateTime] = None)
