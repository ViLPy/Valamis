package com.arcusys.learn.tincan.manifest.model

case class ManifestActivity(
  id: Int,
  tincanId: String, // activity Id from tincan.xml
  packageId: Int,
  activityType: String,
  name: String,
  description: String,
  launch: Option[String],
  resource: Option[String])
