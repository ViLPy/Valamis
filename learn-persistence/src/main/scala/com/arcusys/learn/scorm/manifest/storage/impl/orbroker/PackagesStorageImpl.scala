package com.arcusys.learn.scorm.manifest.storage.impl.orbroker

import org.orbroker.{RowExtractor, Row}
import com.arcusys.learn.storage.impl.orbroker._
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.storage.impl.PackagesEntityStorage
import com.arcusys.learn.scorm.manifest.storage.PackageScopeRuleStorage

class PackagesStorageImpl extends KeyedEntityStorageBaseImpl[Manifest]("Package", "id") with PackagesEntityStorage with PackageExtractor {
  val packageScopeRuleStorage: PackageScopeRuleStorage  = new PackageScopeRuleStorageImpl
}


//TODO: visibility and isdefault
trait PackageExtractor extends RowExtractor[Manifest] {
  def extract(row: Row) = Manifest(
    row.integer("id").get,
    None, // version
    row.string("base"),
    "",
    row.string("defaultOrganizationID"),
    row.string("resourcesBase"),
    row.string("title").get,
    row.string("summary"),
    None,
    row.bigInt("assetRefID"),
    row.integer("courseID"),
    if ((row.columns.find(_.equalsIgnoreCase("visibility")).nonEmpty) && !row.bit("visibility").isEmpty) row.bit("visibility") else Option(false),
    if (row.columns.find(_.equalsIgnoreCase("isdefault")).nonEmpty) row.bit("isDefault").getOrElse(false) else false
  )


  //TODO: store SCORM version in DB
}
