package com.arcusys.learn.scorm.manifest.storage.impl

import com.arcusys.learn.scorm.manifest.storage.PackageScopeRuleStorage
import com.arcusys.learn.storage.impl.EntityStorageExt
import com.arcusys.learn.scorm.manifest.model.{ ScopeType, PackageScopeRule }

/**
 * User: dkudinov
 * Date: 3.4.2013
 */
@deprecated
trait PackageScopeRuleEntityStorage extends PackageScopeRuleStorage with EntityStorageExt[PackageScopeRule] {

  def getAll(packageID: Int, scope: ScopeType.Value, scopeID: Option[String]) = {
    getAll("packageID" -> packageID, "scope" -> scope.toString, "scopeID" -> scopeID.getOrElse("-1"))
  }

  def getAllVisible(scope: ScopeType.Value, scopeID: Option[String]) = {
    getAll("scope" -> scope.toString, "scopeID" -> scopeID.getOrElse("-1"), "visibility" -> true)
  }

  def get(packageID: Int, scope: ScopeType.Value, scopeID: Option[String]) = {
    getOne("packageID" -> packageID, "scope" -> scope.toString, "scopeID" -> scopeID.getOrElse("-1"))
  }

  def create(packageID: Int, scope: ScopeType.Value, scopeID: Option[String], visibility: Boolean, isDefault: Boolean) {
    val newEntity = PackageScopeRule(packageID, scope, scopeID, visibility, isDefault)
    cleanIsDefault(isDefault, scope, scopeID)
    create(newEntity, "scope" -> scope.toString)
  }

  def update(packageID: Int, scope: ScopeType.Value, scopeID: Option[String], visibility: Boolean, isDefault: Boolean) {
    val newEntity = PackageScopeRule(packageID, scope, scopeID, visibility, isDefault)
    cleanIsDefault(isDefault, scope, scopeID)
    modify(newEntity, "scope" -> scope.toString, "scopeID" -> scopeID.getOrElse("-1"))
  }

  private def cleanIsDefault(isDefault: Boolean, scope: ScopeType.Value, scopeID: Option[String]) {
    if (isDefault) modify("_cleanIsDefault", "scope" -> scope.toString, "scopeID" -> scopeID.getOrElse("-1"))
  }

  def getDefaultPackageID(scope: ScopeType.Value, scopeID: Option[String]) = {
    val rule = getOne("_getDefaultPackage", "scope" -> scope.toString, "scopeID" -> scopeID.getOrElse("-1"))
    rule.map(_.packageID)
  }

  def delete(packageID: Int) {
    delete("packageID" -> packageID)
  }
}
