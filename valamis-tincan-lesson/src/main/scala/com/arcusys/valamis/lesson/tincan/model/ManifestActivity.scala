package com.arcusys.valamis.lesson.tincan.model

case class ManifestActivity(
  id: Int,
  tincanId: String, // activity Id from tincan.xml
  packageId: Long,
  activityType: String,
  name: String,
  description: String,
  launch: Option[String],
  resource: Option[String])
