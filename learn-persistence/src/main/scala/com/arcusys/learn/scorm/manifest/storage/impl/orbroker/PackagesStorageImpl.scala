package com.arcusys.learn.scorm.manifest.storage.impl.orbroker

import org.orbroker.{RowExtractor, Row}
import com.arcusys.learn.storage.impl.orbroker._
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.storage.impl.PackagesEntityStorage
import com.arcusys.learn.scorm.manifest.storage.PackageScopeRuleStorage
import com.arcusys.learn.tincan.manifest.storage.impl.TincanPackageEntityStorage

class PackagesStorageImpl extends KeyedEntityStorageBaseImpl[Manifest]("Package", "id") with PackagesEntityStorage with PackageExtractor {
  val packageScopeRuleStorage: PackageScopeRuleStorage  = new PackageScopeRuleStorageImpl
}

class TincanPackagesStorageImpl extends KeyedEntityStorageBaseImpl[com.arcusys.learn.tincan.manifest.model.Manifest]("Package", "id") with TincanPackageEntityStorage with TincanPackageExtractor {
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
}

  //TODO: visibility and isdefault
  trait TincanPackageExtractor extends RowExtractor[com.arcusys.learn.tincan.manifest.model.Manifest] {
    def extract(row: Row) = com.arcusys.learn.tincan.manifest.model.Manifest(
      row.integer("id").get,
      row.string("title").get,
      row.string("summary"),
      row.integer("courseID"),
      row.bigInt("assetRefID"),
      if ((row.columns.find(_.equalsIgnoreCase("visibility")).nonEmpty) && !row.bit("visibility").isEmpty) row.bit("visibility") else Option(false),
      if (row.columns.find(_.equalsIgnoreCase("isdefault")).nonEmpty) row.bit("isDefault").getOrElse(false) else false
    )
  }

  //TODO: store SCORM version in DB

