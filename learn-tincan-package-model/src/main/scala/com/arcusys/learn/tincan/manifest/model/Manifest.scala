package com.arcusys.learn.tincan.manifest.model

case class Manifest
(
  id: Int,
  title: String,
  summary: Option[String],
  courseID: Option[Int],
  assetRefID: Option[Long] = None,

  visibility: Option[Boolean] = None,
  isDefault: Boolean
  )
