package com.arcusys.learn.scorm.manifest.storage.impl

import com.arcusys.learn.scorm.manifest.storage.{PackageScopeRuleStorage, PackagesStorage}
import com.arcusys.learn.storage.impl.{EntityStorageExt, KeyedEntityStorageExt}
import com.arcusys.learn.scorm.manifest.model.ScopeType
import scala.Predef._
import com.arcusys.learn.scorm.manifest.model.PackageScopeRule
import com.arcusys.learn.scorm.manifest.model.Manifest

/**
 * User: dkudinov
 * Date: 3.4.2013
 */
trait PackagesEntityStorage extends PackagesStorage with KeyedEntityStorageExt[Manifest] with EntityStorageExt[Manifest]{
  def packageScopeRuleStorage: PackageScopeRuleStorage

  def getByRefID(refID: Long): Option[Manifest] = getOne("refID" -> refID)

  def createAndGetID(entity: Manifest, courseID: Option[Int]): Int = {
    val newEntity = Manifest(0, entity.version, entity.base, entity.scormVersion, entity.defaultOrganizationID,
      entity.resourcesBase, entity.title, entity.summary, entity.metadata, entity.assetRefID, courseID, isDefault = false)
    createAndGetID(newEntity)
  }

  def getByID(id: Int, courseID: Int, scope: ScopeType.Value, scopeID: String) = {
    if (scope == ScopeType.Instance) {
      getOne("packageId" -> id).map(fillManifestWithScopeValues()(_).head)
    }
    else {
      getOne("packageId" -> id).filter(_.courseID == Option(courseID)).map(fillManifestWithScopeValues(scope, Option(scopeID))(_).head)
    }
  }

  def getByCourseID(courseID: Option[Int]) = {
    courseID.map(courseID => getByScope(courseID, ScopeType.Site, courseID.toString)).getOrElse(Seq())
  }

  def getAllForInstance(courseIDs: List[Int]) = {
    getAll("ids" -> courseIDs).flatMap(fillManifestWithScopeValues())
  }

  def getByScope(courseID: Int, scope: ScopeType.Value, scopeID: String) = {
    getAll("courseID" -> courseID).flatMap(fillManifestWithScopeValues(scope, Option(scopeID)))
  }

  private def fillManifestWithScopeValues(scope: ScopeType.Value = ScopeType.Instance, scopeID: Option[String] = None): (Manifest) => Seq[Manifest] = {
    manifest => {
      val scopeRules = packageScopeRuleStorage.getAll(manifest.id, scope, scopeID)
      if (scopeRules.isEmpty) {
        Seq(manifest)
      } else {
        scopeRules.map(fillByScopeRule(manifest))
      }
    }
  }

  private def fillByScopeRule(manifest: Manifest): (PackageScopeRule) => Manifest = {
    scopeRule =>
      manifest.copy(
        visibility = Option(scopeRule.visibility),
        isDefault = scopeRule.isDefault)
  }

  def getOnlyVisbile(scope: ScopeType.Value, scopeID: String) = {
    packageScopeRuleStorage.getAllVisible(scope, Option(scopeID)).flatMap{
      scopeRule =>
        getOne("packageId" -> scopeRule.packageID).map(fillByScopeRule(_)(scopeRule))
    }
  }

  def getInstanceScopeOnlyVisbile(courseIDs: List[Int]) = {
    getAllForInstance(courseIDs).filter(_.visibility.getOrElse(false))
  }

  def setDescriptions(id: Int, title: String, summary: String) {
    modify("id" -> id, "title" -> title, "summary" -> summary)
  }

  def setAssetRefID(id: Int, refID: Long) {
    modify("id" -> id, "assetRefID" -> refID)
  }

  //TODO: review the query for effectiveness (DISTINCT detected)
  def getPackagesWithAttempts:Seq[Manifest] = {
    getAll("_packages")
  }

  //TODO: review the query for effectiveness (DISTINCT detected)
  def getPackagesWithUserAttempts(userID: Int):Seq[Manifest] = {
    getAll("_packages", "userID" -> userID)
  }
}
