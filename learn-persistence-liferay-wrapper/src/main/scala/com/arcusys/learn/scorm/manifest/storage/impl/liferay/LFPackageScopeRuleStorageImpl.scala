package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.scorm.manifest.model.{ScopeType, PackageScopeRule}
import com.arcusys.learn.persistence.liferay.service.LFPackageScopeRuleLocalServiceUtil
import com.arcusys.learn.storage.impl.liferay.LiferayCommon
import com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule
import scala.collection.JavaConverters._

/**
 * User: Yulia.Glushonkova
 * Date: 12.04.13
 */
trait LFPackageScopeRuleStorageImpl extends EntityStorage[PackageScopeRule] {
  protected def doRenew() { LFPackageScopeRuleLocalServiceUtil.removeAll()}

  def getOne(parameters: (String, Any)*) = {
    val lfRule = parameters match {
      case Seq(("packageID", packageID: Int), ("scope", scope: String), ("scopeID", scopeID: String)) =>
        LFPackageScopeRuleLocalServiceUtil.fetchByPackageIDAndScope(packageID, scope, if (scopeID == "-1") null else scopeID)
    }
    if (lfRule == null) None
    else Option(extract(lfRule))
  }

  def getAll(parameters: (String, Any)*) = {
    val rules = parameters match {
      case Seq(("packageID", packageID: Int), ("scope", scope: String), ("scopeID", scopeID: String)) =>
        LFPackageScopeRuleLocalServiceUtil.findByAllByPackageIDAndScope(packageID, scope, if (scopeID == "-1") null else scopeID)

      case Seq(("scope", scope: String), ("scopeID", scopeID: String), ("visibility", visibility: Boolean)) =>
        LFPackageScopeRuleLocalServiceUtil.findByVisibility(scope, scopeID, visibility)
    }
    rules.asScala map {
      extract
    }
  }

  private def extract(lfEntity: LFPackageScopeRule): PackageScopeRule = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    new PackageScopeRule(lfEntity.getPackageID, ScopeType.withName(lfEntity.getScope), lfEntity.getScopeID.toOption,
      lfEntity.getVisibility, lfEntity.getIsDefault)
  }

  def create(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def create(entity: PackageScopeRule, parameters: (String, Any)*) {
    val newEntity = LFPackageScopeRuleLocalServiceUtil.createLFPackageScopeRule()

    newEntity.setPackageID(entity.packageID)
    newEntity.setScope(LiferayCommon.getParameter("scope", parameters: _*).get)
    newEntity.setScopeID(entity.scopeID.getOrElse(null))
    newEntity.setVisibility(entity.visibility)
    newEntity.setIsDefault(entity.isDefault)

    LFPackageScopeRuleLocalServiceUtil.addLFPackageScopeRule(newEntity)
  }

  def delete(parameters: (String, Any)*) {
    LFPackageScopeRuleLocalServiceUtil.findByPackageID(LiferayCommon.getParameter("packageID", parameters: _*).get).asScala.foreach(i=>{
      LFPackageScopeRuleLocalServiceUtil.deleteLFPackageScopeRule(i.getId)
    })
  }

  def modify(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def modify(entity: PackageScopeRule, parameters: (String, Any)*) {
    val scope = if (entity.scopeID.isEmpty) null.asInstanceOf[String] else entity.scopeID.get
    val lfEntinty = LFPackageScopeRuleLocalServiceUtil.findByPackageIDAndScope(entity.packageID, entity.scope.toString, scope)
    lfEntinty.setVisibility(entity.visibility)
    lfEntinty.setIsDefault(entity.isDefault)
    LFPackageScopeRuleLocalServiceUtil.updateLFPackageScopeRule(lfEntinty)
  }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = {
    if (sqlKey.equalsIgnoreCase("_getDefaultPackage")) {
      parameters match {
        case Seq(("scope", scope: String), ("scopeID", scopeID: String)) => {
          try{
          Option(LFPackageScopeRuleLocalServiceUtil.findByScopeAndIsDefault(scope, if (scopeID == "-1") null else scopeID, true)).map(extract)
          }
          catch {
            case _ => None
          }
        }
        case _ => None
      }
    } else {
      None
    }
  }

  def modify(sqlKey: String, parameters: (String, Any)*) {
    if (sqlKey.equalsIgnoreCase("_cleanIsDefault")) {
      parameters match {
        case Seq(("scope", scope: String), ("scopeID", scopeID: String)) => {
          val rules = LFPackageScopeRuleLocalServiceUtil.findByScope(scope, if (scopeID == "-1") null else scopeID).asScala
          rules.foreach(rule => {
            rule.setIsDefault(false)
            LFPackageScopeRuleLocalServiceUtil.updateLFPackageScopeRule(rule)
          })
        }
      }
    } else if (sqlKey.equalsIgnoreCase("_setAsDefault")) {
      parameters match {
        case Seq(("packageID", packageID: Int), ("scope", scope: String), ("scopeID", scopeID: String)) =>
          val rules = LFPackageScopeRuleLocalServiceUtil.findByAllByPackageIDAndScope(packageID, scope, if (scopeID == "-1") null else scopeID).asScala
          rules.foreach(rule => {
            rule.setIsDefault(true)
            LFPackageScopeRuleLocalServiceUtil.updateLFPackageScopeRule(rule)
          })
      }
    }
  }
}
