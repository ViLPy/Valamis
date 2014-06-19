package com.arcusys.learn.scorm.manifest.storage

import com.arcusys.learn.scorm.manifest.model.{ PackageScopeRule, ScopeType }

trait PackageScopeRuleStorage {
  def get(packageID: Int, scope: ScopeType.Value, scopeID: Option[String]): Option[PackageScopeRule]
  def getAll(packageID: Int, scope: ScopeType.Value, scopeID: Option[String]): Seq[PackageScopeRule]
  def getAllVisible(scope: ScopeType.Value, scopeID: Option[String]): Seq[PackageScopeRule]
  def create(packageID: Int, scope: ScopeType.Value, scopeID: Option[String], visibility: Boolean, isDefault: Boolean)
  def update(packageID: Int, scope: ScopeType.Value, scopeID: Option[String], visibility: Boolean, isDefault: Boolean)
  //def updateIsDefaultProperty(packageID: Int, scope: ScopeType.Value, scopeID: Option[String], isDefault: Boolean)
  def getDefaultPackageID(scope: ScopeType.Value, scopeID: Option[String]): Option[Int]
  def delete(packageID: Int)
  def renew()
}
