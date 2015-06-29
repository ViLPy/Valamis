package com.arcusys.valamis.settings.model

case class SiteDependentSetting(
  id: Int,
  siteID: Int,
  key: String,
  value: Option[String])
