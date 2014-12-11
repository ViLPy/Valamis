package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFPackage
import com.arcusys.learn.persistence.liferay.service.persistence.LFLessonLimitPK
import com.arcusys.learn.persistence.liferay.service.{ LFLessonLimitLocalServiceUtil, LFAttemptLocalServiceUtil, LFPackageLocalServiceUtil }
import com.arcusys.learn.scorm.manifest.model.PeriodType.PeriodType
import com.arcusys.learn.scorm.manifest.model.PeriodType._
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.storage.{ ScormPackagesStorage, PackageScopeRuleStorage }

import scala.collection.JavaConverters._
import scala.util.Try

/**
 * Created by mminin on 15.10.14.
 */
trait ScormPackageRepositoryImpl extends ScormPackagesStorage {

  def packageScopeRuleRepository: PackageScopeRuleStorage

  override def renew(): Unit = {
    LFPackageLocalServiceUtil.removeAll()
  }

  override def createAndGetID(entity: Manifest, courseID: Option[Int]): Int = {
    val manifest = Manifest(0, entity.version, entity.base, entity.scormVersion, entity.defaultOrganizationID,
      entity.resourcesBase, entity.title, entity.summary, entity.metadata, entity.assetRefID,
      courseID, logo = entity.logo, isDefault = false)

    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    val newEntity = LFPackageLocalServiceUtil.createLFPackage()

    newEntity.setDefaultOrganizationID(manifest.defaultOrganizationID.getOrElse(null))
    newEntity.setTitle(manifest.title)
    newEntity.setBase(manifest.base.getOrElse(null))
    newEntity.setResourcesBase(manifest.resourcesBase.getOrElse(null))
    newEntity.setSummary(manifest.summary.getOrElse(null))
    newEntity.setAssetRefID(manifest.assetRefID)
    newEntity.setCourseID(manifest.courseID)
    manifest.logo.foreach(newEntity.setLogo)

    val id = LFPackageLocalServiceUtil.addLFPackage(newEntity).getId.toInt

    val limitEntity = LFLessonLimitLocalServiceUtil.createLFLessonLimit(new LFLessonLimitPK(id.toLong, LessonType.scormPackage.toString))
    limitEntity.setPassingLimit(entity.passingLimit)
    limitEntity.setRerunInterval(entity.rerunInterval)
    limitEntity.setRerunIntervalType(entity.rerunIntervalType.toString)
    LFLessonLimitLocalServiceUtil.addLFLessonLimit(limitEntity)
    id
  }

  override def delete(id: Int): Unit = {
    val limitEntity = LFLessonLimitLocalServiceUtil.findByID(getLong(id), LessonType.scormPackage.toString)
    LFLessonLimitLocalServiceUtil.deleteLFLessonLimit(limitEntity)

    LFPackageLocalServiceUtil.deleteLFPackage(getLong(id))

    packageScopeRuleRepository.delete(id)
  }

  override def getByID(id: Int): Option[Manifest] = {
    Option(LFPackageLocalServiceUtil.getLFPackage(id)).map(extract)
  }

  override def getByID(id: Int, courseID: Int, scope: ScopeType.Value, scopeID: String): Option[Manifest] = {
    if (scope == ScopeType.Instance) {
      Option(LFPackageLocalServiceUtil.getLFPackage(getLong(id)))
        .map(extract)
        .map(fillManifestWithScopeValues()(_).head)
    } else {
      Option(LFPackageLocalServiceUtil.getLFPackage(getLong(id)))
        .map(extract)
        .filter(_.courseID == Option(courseID))
        .map(fillManifestWithScopeValues(scope, Option(scopeID))(_).head)
    }
  }

  override def getByRefID(refID: Long): Option[Manifest] = {
    Option(LFPackageLocalServiceUtil.findByRefID(getLong(refID))) map extract
  }

  override def getAll: Seq[Manifest] = {
    LFPackageLocalServiceUtil.getLFPackages(-1, -1).asScala map extract
  }

  // get all in course with visibility
  override def getByCourseID(courseID: Option[Int]): Seq[Manifest] = {
    courseID.map(courseID => getByScope(courseID, ScopeType.Site, courseID.toString)).getOrElse(Seq())
  }

  // get all in instance with visibility
  override def getAllForInstance(courseIDs: List[Int]): Seq[Manifest] = {
    LFPackageLocalServiceUtil.findByInstance(courseIDs.toArray.map(i => i: java.lang.Integer)).asScala
      .map(extract)
      .flatMap(fillManifestWithScopeValues())
  }

  // get all in current course (liferay site) by scope with visibility
  override def getByScope(courseID: Int, scope: ScopeType.Value, scopeID: String): Seq[Manifest] = {
    LFPackageLocalServiceUtil.findByCourseID(courseID).asScala
      .map(extract)
      .flatMap(fillManifestWithScopeValues(scope, Option(scopeID)))
  }

  override def getByExactScope(courseIDs: List[Int], scope: ScopeType.Value, scopeID: String): Seq[Manifest] = {
    LFPackageLocalServiceUtil.findByInstance(courseIDs.toArray.map(i => i: java.lang.Integer)).asScala
      .map(extract)
      .flatMap(fillManifestWithScopeValuesWithFilter(scope, Option(scopeID)))
  }

  // for Player show only visible in current scope
  override def getOnlyVisible(scope: ScopeType.Value, scopeID: String): Seq[Manifest] = {
    packageScopeRuleRepository.getAllVisible(scope, Option(scopeID)).flatMap {
      scopeRule =>
        Option(LFPackageLocalServiceUtil.getLFPackage(getLong(scopeRule.packageID)))
          .map(extract)
          .map(fillByScopeRule(_)(scopeRule))
    }
  }

  override def getInstanceScopeOnlyVisible(courseIDs: List[Int]): Seq[Manifest] = {
    getAllForInstance(courseIDs).filter(_.visibility.getOrElse(false))
  }

  override def getPackagesWithUserAttempts(userID: Int): Seq[Manifest] = {
    val packageIDs = LFAttemptLocalServiceUtil.findByUserID(userID).asScala.map(_.getPackageID.toLong.asInstanceOf[java.lang.Long]).toSet
    LFPackageLocalServiceUtil.findByPackageID(packageIDs.toArray).asScala.map(extract)
  }

  // These 2 methods is only for SCORM packages
  override def getPackagesWithAttempts: Seq[Manifest] = {
    val packageIDs = LFAttemptLocalServiceUtil.getLFAttempts(-1, -1).asScala.map(_.getPackageID.toLong.asInstanceOf[java.lang.Long]).toSet
    LFPackageLocalServiceUtil.findByPackageID(packageIDs.toArray).asScala.map(extract)
  }

  override def setLimits(id: Int, passingLimit: Int, rerunInterval: Int, rerunIntervalType: PeriodType) {
    val entity = LFPackageLocalServiceUtil.findByPackageID(Array(id.toLong: java.lang.Long)).asScala.headOption
    entity.foreach(e => {
      try {
        val limitEntity = LFLessonLimitLocalServiceUtil.findByID(e.getId, LessonType.scormPackage.toString)
        limitEntity.setPassingLimit(passingLimit)
        limitEntity.setRerunInterval(rerunInterval)
        limitEntity.setRerunIntervalType(rerunIntervalType.toString)
        LFLessonLimitLocalServiceUtil.updateLFLessonLimit(limitEntity)
      } catch {
        case _ => {
          val limitEntity = LFLessonLimitLocalServiceUtil.createLFLessonLimit(new LFLessonLimitPK(id.toLong, LessonType.scormPackage.toString))
          limitEntity.setPassingLimit(passingLimit)
          limitEntity.setRerunInterval(rerunInterval)
          limitEntity.setRerunIntervalType(rerunIntervalType.toString)
          LFLessonLimitLocalServiceUtil.addLFLessonLimit(limitEntity)
        }
      }
    })
    entity
  }

  override def setAssetRefID(id: Int, refID: Long): Unit = {
    val entity = LFPackageLocalServiceUtil.findByPackageID(Array(getLong(id).toLong: java.lang.Long)).asScala.headOption
    entity.foreach(e => {
      e.setAssetRefID(getLong(refID))
      LFPackageLocalServiceUtil.updateLFPackage(e)
    })
  }

  override def setDescriptions(id: Int, title: String, summary: String): Unit = {
    val entity = LFPackageLocalServiceUtil.findByPackageID(Array(id.toLong: java.lang.Long)).asScala.headOption
    entity.foreach(e => {
      e.setTitle(title)
      e.setSummary(summary)
      LFPackageLocalServiceUtil.updateLFPackage(e)
    })
  }

  override def setLogo(id: Int, logo: Option[String]): Unit = {
    val entity = LFPackageLocalServiceUtil.findByPackageID(Array(getLong(id).toLong: java.lang.Long)).asScala.headOption
    logo.foreach { l =>
      entity.foreach(e => {
        e.setLogo(l)
        LFPackageLocalServiceUtil.updateLFPackage(e)
      })
    }
  }

  private def getLong(value: Any): Long = {
    value match {
      case i: Int  => i.toLong
      case l: Long => l
      case _       => 0
    }
  }

  private def getInt(value: Any): Int = {
    value match {
      case i: Int  => i
      case l: Long => l.toInt
      case _       => 0
    }
  }

  private def extract(lfEntity: LFPackage) = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    val lessonLimit = Try({
      val limit = LFLessonLimitLocalServiceUtil.findByID(lfEntity.getId, LessonType.scormPackage.toString)
      (limit.getPassingLimit.toInt, limit.getRerunInterval.toInt, limit.getRerunIntervalType)
    }
    ).getOrElse((0, 0, ""))

    new Manifest(lfEntity.getId.toInt,
      None,
      lfEntity.getBase.toOption,
      "",
      lfEntity.getDefaultOrganizationID.toOption,
      lfEntity.getResourcesBase.toOption,
      lfEntity.getTitle,
      Option(lfEntity.getSummary),
      None,
      lfEntity.getAssetRefID.toOption,
      lfEntity.getCourseID.toOption,
      None,
      Option(lfEntity.getLogo),
      false,
      lessonLimit._1,
      lessonLimit._2,
      PeriodType(lessonLimit._3))
  }

  private def fillManifestWithScopeValues(scope: ScopeType.Value = ScopeType.Instance, scopeID: Option[String] = None): (Manifest) => Seq[Manifest] = {
    manifest =>
      {
        val scopeRules = packageScopeRuleRepository.getAll(manifest.id, scope, scopeID)
        if (scopeRules.isEmpty) {
          Seq(manifest)
        } else {
          scopeRules.map(fillByScopeRule(manifest))
        }
      }
  }

  private def fillManifestWithScopeValuesWithFilter(scope: ScopeType.Value = ScopeType.Instance, scopeID: Option[String] = None): (Manifest) => Seq[Manifest] = {
    manifest =>
      {
        val scopeRules = packageScopeRuleRepository.getAll(manifest.id, scope, scopeID)
        if (scopeRules.isEmpty) {
          Seq()
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
}
