package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule
import com.arcusys.learn.persistence.liferay.service.LFPackageScopeRuleLocalServiceUtil
import com.arcusys.valamis.lesson.model.PackageScopeRule
import com.arcusys.valamis.lesson.storage.PackageScopeRuleStorage
import com.arcusys.valamis.model.ScopeType
import com.liferay.portal.kernel.dao.orm.{ ProjectionFactoryUtil, RestrictionsFactoryUtil }

import scala.collection.JavaConverters._

/**
 * Created by mminin on 15.10.14.
 */

object PackageScopeRuleHelper {
  def getPackageIdVisibleDynamicQuery(scope: ScopeType.Value, scopeID: Option[String]) = {
    val visiblePackagesDynamicQuery = LFPackageScopeRuleLocalServiceUtil.dynamicQuery()

    visiblePackagesDynamicQuery.add(RestrictionsFactoryUtil.eq("visibility", true))
    visiblePackagesDynamicQuery.add(RestrictionsFactoryUtil.eq("scope", scope.toString))
    if (scopeID.isDefined) visiblePackagesDynamicQuery.add(RestrictionsFactoryUtil.eq("scopeID", scopeID.orNull))
    visiblePackagesDynamicQuery.setProjection(ProjectionFactoryUtil.property("packageID"))
  }
}

class PackageScopeRuleRepositoryImpl extends PackageScopeRuleStorage {
  override def renew(): Unit = {
    LFPackageScopeRuleLocalServiceUtil.removeAll()
  }

  override def create(packageID: Long, scope: ScopeType.Value, scopeID: Option[String], visibility: Boolean, isDefault: Boolean): PackageScopeRule = {
    if (isDefault)
      cleanIsDefault(isDefault, scope, scopeID)

    val newEntity = LFPackageScopeRuleLocalServiceUtil.createLFPackageScopeRule()

    newEntity.setPackageID(packageID.toInt)
    newEntity.setScope(scope.toString)
    newEntity.setScopeID(scopeID.orNull)
    newEntity.setVisibility(visibility)
    newEntity.setIsDefault(isDefault)

    extract(LFPackageScopeRuleLocalServiceUtil.addLFPackageScopeRule(newEntity))
  }

  override def get(packageID: Long, scope: ScopeType.Value, scopeID: Option[String]): Option[PackageScopeRule] = {
    Option(LFPackageScopeRuleLocalServiceUtil.fetchByPackageIDAndScope(packageID.toInt, scope.toString, scopeID.orNull))
      .map(extract)
  }

  override def getAll(packageID: Long, scope: ScopeType.Value, scopeID: Option[String]): Seq[PackageScopeRule] = {
    LFPackageScopeRuleLocalServiceUtil.findByAllByPackageIDAndScope(packageID.toInt, scope.toString, scopeID.orNull).asScala
      .map(extract)
  }

  override def getAllVisible(scope: ScopeType.Value, scopeID: Option[String]): Seq[PackageScopeRule] = {
    LFPackageScopeRuleLocalServiceUtil.findByVisibility(scope.toString, scopeID.orNull, true).asScala
      .map(extract)
  }

  override def getDefaultPackageID(scope: ScopeType.Value, scopeID: Option[String]): Option[Int] = {
    val rule = try {
      Option(LFPackageScopeRuleLocalServiceUtil.findByScopeAndIsDefault(scope.toString, scopeID.orNull, true)).map(extract)
    } catch {
      case _ : Exception => None
    }
    rule.map(_.packageID)
  }

  override def update(packageID: Long, scope: ScopeType.Value, scopeID: Option[String], visibility: Boolean, isDefault: Boolean): PackageScopeRule = {
    if (isDefault)
      cleanIsDefault(isDefault, scope, scopeID)

    val lfEntinty = LFPackageScopeRuleLocalServiceUtil.findByPackageIDAndScope(packageID.toInt, scope.toString, scopeID.orNull)
    lfEntinty.setVisibility(visibility)
    lfEntinty.setIsDefault(isDefault)
    extract(LFPackageScopeRuleLocalServiceUtil.updateLFPackageScopeRule(lfEntinty))
  }

  override def delete(packageID: Long): Unit = {

    LFPackageScopeRuleLocalServiceUtil.findByPackageID(packageID.toInt).asScala.foreach(i => {
      LFPackageScopeRuleLocalServiceUtil.deleteLFPackageScopeRule(i.getId)
    })
  }

  private def cleanIsDefault(isDefault: Boolean, scope: ScopeType.Value, scopeID: Option[String]) {
    val rules = LFPackageScopeRuleLocalServiceUtil.findByScope(scope.toString, scopeID.orNull).asScala
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
