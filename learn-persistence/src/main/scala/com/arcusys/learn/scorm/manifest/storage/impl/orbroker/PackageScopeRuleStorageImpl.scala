package com.arcusys.learn.scorm.manifest.storage.impl.orbroker

import org.orbroker.{RowExtractor, Row}
import com.arcusys.learn.storage.impl.orbroker._
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.storage.impl.PackageScopeRuleEntityStorage

class PackageScopeRuleStorageImpl extends GenericEntityStorageBaseImpl[PackageScopeRule]("PackageScopeRule") with PackageScopeRuleEntityStorage with PackageScopeRuleExtractor

trait PackageScopeRuleExtractor extends RowExtractor[PackageScopeRule] {
  def extract(row: Row) = PackageScopeRule(
    row.integer("packageID").get,
    ScopeType.withName(row.string("scope").get),
    row.string("scopeID"),
    row.bit("visibility").get,
    row.bit("isDefault").getOrElse(false)
  )
}
