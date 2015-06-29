package com.arcusys.valamis.lesson.storage

import com.arcusys.valamis.lesson.model.PackageScopeRule
import com.arcusys.valamis.model.ScopeType

trait PackageScopeRuleStorage {
  def get(packageID: Long, scope: ScopeType.Value, scopeID: Option[String]): Option[PackageScopeRule]
  def getAll(packageID: Long, scope: ScopeType.Value, scopeID: Option[String]): Seq[PackageScopeRule]
  def getAllVisible(scope: ScopeType.Value, scopeID: Option[String]): Seq[PackageScopeRule]
  def create(packageID: Long, scope: ScopeType.Value, scopeID: Option[String], visibility: Boolean, isDefault: Boolean): PackageScopeRule
  def update(packageID: Long, scope: ScopeType.Value, scopeID: Option[String], visibility: Boolean, isDefault: Boolean): PackageScopeRule
  //def updateIsDefaultProperty(packageID: Int, scope: ScopeType.Value, scopeID: Option[String], isDefault: Boolean)
  def getDefaultPackageID(scope: ScopeType.Value, scopeID: Option[String]): Option[Int]
  def delete(packageID: Long)
  def renew()
}
