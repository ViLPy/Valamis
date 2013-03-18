package com.arcusys.learn.scorm.manifest.storage.impl.orbroker

import com.arcusys.learn.scorm.manifest.storage._
import org.orbroker.Row
import com.arcusys.learn.storage.impl.orbroker._
import com.arcusys.learn.scorm.manifest.model._

class PackageScopeRuleStorageImpl extends GenericEntityStorageImpl[PackageScopeRule]("PackageScopeRule") with PackageScopeRuleStorage {
  def get(packageID: Int, scope: ScopeType.Value, scopeID: Option[String]) = {
    if (scopeID.isEmpty)
      getOne("packageID" -> packageID, "scope" -> scope.toString)
    else getOne("packageID" -> packageID, "scope" -> scope.toString, "scopeID" -> scopeID)
  }

  def get(packageID: Int) = {
    getOne("_getByID", "packageID" -> packageID)
  }

  def create(packageID: Int, scope: ScopeType.Value, scopeID: Option[String], visibility: Boolean) {
    val newEntity = new PackageScopeRule(packageID, scope, scopeID, visibility, None)
    create(newEntity, "scope" -> scope.toString)
  }

  def update(packageID: Int, scope: ScopeType.Value, scopeID: Option[String], visibility: Boolean) {
    val newEntity = new PackageScopeRule(packageID, scope, scopeID, visibility, None)
    if (scopeID.isEmpty) modify(newEntity, "scope" -> scope.toString)
    else modify(newEntity, "scope" -> scope.toString, "scopeID" -> scopeID)
  }

  def updateIsDefaultProperty(packageID: Int, scope: ScopeType.Value, scopeID: Option[String], isDefault: Boolean) {
    if (scopeID.isEmpty) {
      modify("_cleanIsDefault", "scope" -> scope.toString)
      if (isDefault) modify("_setAsDefault", "packageID" -> packageID, "scope" -> scope.toString)
    }
    else {
      modify("_cleanIsDefault", "scope" -> scope.toString, "scopeID" -> scopeID)
      if (isDefault) modify("_setAsDefault", "packageID" -> packageID, "scope" -> scope.toString, "scopeID" -> scopeID)
    }
  }

  def getDefaultPackageID(scope: ScopeType.Value, scopeID: Option[String]) = {
    val rule = if (scopeID.isEmpty) getOne("_getDefaultPackage", "scope" -> scope.toString)
    else getOne("_getDefaultPackage", "scope" -> scope.toString, "scopeID" -> scopeID)
    if (rule.isEmpty) None else Option(rule.get.packageID)
  }

  def delete(packageID: Int) {
    delete("packageID" -> packageID)
  }

  def extract(row: Row) = new PackageScopeRule(
    row.integer("packageID").get,
    ScopeType.withName(row.string("scope").get),
    row.string("scopeID"),
    row.bit("visibility").get,
    row.bit("isDefault")
  )
}
