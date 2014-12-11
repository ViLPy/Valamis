package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule
import com.arcusys.learn.persistence.liferay.service.LFPackageScopeRuleLocalServiceUtil
import com.arcusys.learn.scorm.manifest.model.{ PackageScopeRule, ScopeType }
import com.arcusys.learn.scorm.manifest.storage.PackageScopeRuleStorage
import com.arcusys.learn.storage.impl.liferay.LiferayCommon
import scala.collection.JavaConverters._

/**
 * Created by mminin on 15.10.14.
 */
class PackageScopeRuleRepositoryImpl extends PackageScopeRuleStorage {
  override def renew(): Unit = {
    LFPackageScopeRuleLocalServiceUtil.removeAll()
  }

  override def create(packageID: Int, scope: ScopeType.Value, scopeID: Option[String], visibility: Boolean, isDefault: Boolean): Unit = {
    cleanIsDefault(isDefault, scope, scopeID)

    val newEntity = LFPackageScopeRuleLocalServiceUtil.createLFPackageScopeRule()

    newEntity.setPackageID(packageID)
    newEntity.setScope(scope.toString)
    newEntity.setScopeID(scopeID.getOrElse(null))
    newEntity.setVisibility(visibility)
    newEntity.setIsDefault(isDefault)

    LFPackageScopeRuleLocalServiceUtil.addLFPackageScopeRule(newEntity)
  }

  override def get(packageID: Int, scope: ScopeType.Value, scopeID: Option[String]): Option[PackageScopeRule] = {
    Option(LFPackageScopeRuleLocalServiceUtil.fetchByPackageIDAndScope(packageID, scope.toString, scopeID.orNull))
      .map(extract)
  }

  override def getAll(packageID: Int, scope: ScopeType.Value, scopeID: Option[String]): Seq[PackageScopeRule] = {
    LFPackageScopeRuleLocalServiceUtil.findByAllByPackageIDAndScope(packageID, scope.toString, scopeID.orNull).asScala
      .map(extract)
  }

  override def getAllVisible(scope: ScopeType.Value, scopeID: Option[String]): Seq[PackageScopeRule] = {
    LFPackageScopeRuleLocalServiceUtil.findByVisibility(scope.toString, scopeID.getOrElse("-1"), true).asScala
      .map(extract)
  }

  override def getDefaultPackageID(scope: ScopeType.Value, scopeID: Option[String]): Option[Int] = {
    val rule = try {
      Option(LFPackageScopeRuleLocalServiceUtil.findByScopeAndIsDefault(scope.toString, scopeID.orNull, true)).map(extract)
    } catch {
      case _ => None
    }
    rule.map(_.packageID)
  }

  override def update(packageID: Int, scope: ScopeType.Value, scopeID: Option[String], visibility: Boolean, isDefault: Boolean): Unit = {
    cleanIsDefault(isDefault, scope, scopeID)

    val lfEntinty = LFPackageScopeRuleLocalServiceUtil.findByPackageIDAndScope(packageID, scope.toString, scopeID.orNull)
    lfEntinty.setVisibility(visibility)
    lfEntinty.setIsDefault(isDefault)
    LFPackageScopeRuleLocalServiceUtil.updateLFPackageScopeRule(lfEntinty)
  }

  override def delete(packageID: Int): Unit = {

    LFPackageScopeRuleLocalServiceUtil.findByPackageID(packageID).asScala.foreach(i => {
      LFPackageScopeRuleLocalServiceUtil.deleteLFPackageScopeRule(i.getId)
    })
  }

  private def cleanIsDefault(isDefault: Boolean, scope: ScopeType.Value, scopeID: Option[String]) {
    val rules = LFPackageScopeRuleLocalServiceUtil.findByScope(scope.toString, scopeID.getOrElse(null)).asScala
    rules.foreach(rule => {
      rule.setIsDefault(false)
      LFPackageScopeRuleLocalServiceUtil.updateLFPackageScopeRule(rule)
    })
  }

  private def extract(lfEntity: LFPackageScopeRule): PackageScopeRule = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    new PackageScopeRule(lfEntity.getPackageID, ScopeType.withName(lfEntity.getScope), lfEntity.getScopeID.toOption,
      lfEntity.getVisibility, lfEntity.getIsDefault)
  }

}
