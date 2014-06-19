package com.arcusys.learn.scorm.manifest.model

/**
 * A rule for package in scope
 * @param playerID  ID of Player portlet
 * @param scope      Type of scope
 */
class PlayerScopeRule(
  val playerID: String,
  val scope: ScopeType.Value)