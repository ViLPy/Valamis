package com.arcusys.learn.scorm.manifest.storage

import com.arcusys.learn.scorm.manifest.model._

trait PackageScopeRuleStorage
{
  def get(packageID: Int, scope: ScopeType.Value, scopeID: Option[String]): Option[PackageScopeRule]
  def create(packageID: Int, scope: ScopeType.Value, scopeID: Option[String], visibility: Boolean)
  def update(packageID: Int, scope: ScopeType.Value, scopeID: Option[String], visibility: Boolean)
  def delete(packageID: Int)
}
