package com.arcusys.learn.scorm.manifest.model

/**
 * A rule for package in scope
 * @param packageID  ID of scorm package
 * @param scope      Type of scope
 * @param scopeID    Scope Layout ID (it might be SiteID, pageID or portletID)
 * @param visibility Identifies if package is visible in scope
 */
class PackageScopeRule(
  val packageID: Int,
  val scope: ScopeType.Value,
  val scopeID: Option[String],
  val visibility: Boolean
)