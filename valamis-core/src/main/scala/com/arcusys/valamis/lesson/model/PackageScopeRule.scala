package com.arcusys.valamis.lesson.model

import com.arcusys.valamis.model.ScopeType

/**
 * A rule for package in scope
 * @param packageID  ID of scorm package
 * @param scope      Type of scope
 * @param scopeID    Scope Layout ID (it might be SiteID, pageID or portletID)
 * @param visibility Identifies if package is visible in scope
 * @param isDefault  Identifies if package is default in current scope
 */
case class PackageScopeRule(
  packageID: Int,
  scope: ScopeType.Value,
  scopeID: Option[String],
  visibility: Boolean,
  isDefault: Boolean)