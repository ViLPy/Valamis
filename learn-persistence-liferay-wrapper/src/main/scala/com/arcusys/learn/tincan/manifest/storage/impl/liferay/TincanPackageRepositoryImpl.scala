package com.arcusys.learn.tincan.manifest.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFTincanPackage
import com.arcusys.learn.persistence.liferay.service.persistence.LFLessonLimitPK
import com.arcusys.learn.persistence.liferay.service.{ LFLessonLimitLocalServiceUtil, LFTincanPackageLocalServiceUtil }
import com.arcusys.learn.scorm.manifest.model.PeriodType._
import com.arcusys.learn.scorm.manifest.model.{ PeriodType, LessonType, PackageScopeRule, ScopeType }
import com.arcusys.learn.scorm.manifest.storage.PackageScopeRuleStorage
import com.arcusys.learn.tincan.manifest.model.TincanManifest
import com.arcusys.learn.tincan.manifest.storage.TincanPackageStorage
import scala.collection.JavaConverters._
import scala.util.Try

/**
 * Created by mminin on 15.10.14.
 */
trait TincanPackageRepositoryImpl extends TincanPackageStorage {

  def packageScopeRuleRepository: PackageScopeRuleStorage

  override def renew(): Unit = {
    LFTincanPackageLocalServiceUtil.removeAll()
  }

  override def createAndGetID(entity: TincanManifest, courseID: Option[Int]): Int = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    val newEntity = LFTincanPackageLocalServiceUtil.createLFTincanPackage()

    newEntity.setCourseID(courseID)
    newEntity.setSummary(entity.summary.getOrElse(null))
    newEntity.setTitle(entity.title)

    LFTincanPackageLocalServiceUtil.addLFTincanPackage(newEntity).getId.toInt
  }

  override def delete(id: Int): Unit = {
    packageScopeRuleRepository.delete(id)

    LFTincanPackageLocalServiceUtil.deleteLFTincanPackage(getLong(id))
    Try(LFLessonLimitLocalServiceUtil.findByID(getLong(id), LessonType.tincanPackage.toString)).map { passingLimitEntity =>
      LFLessonLimitLocalServiceUtil.deleteLFLessonLimit(passingLimitEntity)
    }
  }

  override def getAll: Seq[TincanManifest] = {
    Seq(LFTincanPackageLocalServiceUtil.getLFTincanPackage(-1)).map(extract)
  }

  override def getByID(id: Int): Option[TincanManifest] = {
    Try(LFTincanPackageLocalServiceUtil.getLFTincanPackage(getLong(id))).toOption.map(extract)
  }

  override def getByRefID(refID: Long): Option[TincanManifest] = {
    Try(LFTincanPackageLocalServiceUtil.findByRefID(getLong(refID))).toOption.map(extract)
  }

  override def getByCourseID(courseID: Option[Int]): Seq[TincanManifest] = {
    courseID.map(courseID => getByScope(courseID, ScopeType.Site, courseID.toString)).getOrElse(Seq())
  }

  override def getByScope(courseID: Int, scope: ScopeType.Value, scopeID: String): Seq[TincanManifest] = {
    LFTincanPackageLocalServiceUtil.findByCourseID(courseID).asScala
      .map(extract)
      .flatMap(fillManifestWithScopeValues(scope, Option(scopeID)))
  }

  override def getByExactScope(courseIDs: List[Int], scope: ScopeType.Value, scopeID: String): Seq[TincanManifest] = {
    LFTincanPackageLocalServiceUtil.findByInstance(courseIDs.toArray.map(i => i: java.lang.Integer)).asScala
      .map(extract)
      .flatMap(fillManifestWithScopeValuesWithFilter(scope, Option(scopeID)))
  }

  override def getAllForInstance(courseIDs: List[Int]): Seq[TincanManifest] = {
    LFTincanPackageLocalServiceUtil.findByInstance(courseIDs.toArray.map(i => i: java.lang.Integer)).asScala
      .filter(_ != null).map(extract)
      .flatMap(fillManifestWithScopeValues())
  }

  override def getOnlyVisibile(scope: ScopeType.Value, scopeID: String): Seq[TincanManifest] = {
    packageScopeRuleRepository.getAllVisible(scope, Option(scopeID)).flatMap {
      scopeRule =>
        Option(LFTincanPackageLocalServiceUtil.getLFTincanPackage(getLong(scopeRule.packageID)))
          .map(extract)
          .map(e => fillByScopeRule(e)(scopeRule))
    }
  }

  override def getInstanceScopeOnlyVisible(courseIDs: List[Int]): Seq[TincanManifest] = {
    getAllForInstance(courseIDs).filter(_.visibility.getOrElse(false))
  }

  override def setLimits(id: Int, passingLimit: Int, rerunInterval: Int, rerunIntervalType: PeriodType) = {
    val entity = LFTincanPackageLocalServiceUtil.findByPackageID(Array(id.toLong: java.lang.Long)).get(0)
    try {
      val limitEntity = LFLessonLimitLocalServiceUtil.findByID(entity.getId, LessonType.tincanPackage.toString)
      limitEntity.setPassingLimit(passingLimit)
      limitEntity.setRerunInterval(rerunInterval)
      limitEntity.setRerunIntervalType(rerunIntervalType.toString)
      LFLessonLimitLocalServiceUtil.updateLFLessonLimit(limitEntity)
    } catch {
      case _ => {
        val limitEntity = LFLessonLimitLocalServiceUtil.createLFLessonLimit(new LFLessonLimitPK(id.toLong, LessonType.tincanPackage.toString))
        limitEntity.setPassingLimit(passingLimit)
        limitEntity.setRerunInterval(rerunInterval)
        limitEntity.setRerunIntervalType(rerunIntervalType.toString)
        LFLessonLimitLocalServiceUtil.addLFLessonLimit(limitEntity)
      }
    }
    entity
  }

  override def setAssetRefID(id: Int, assetRefID: Long): Unit = {
    val lfEntity = LFTincanPackageLocalServiceUtil.findByPackageID(Array(getLong(id).toLong: java.lang.Long)).get(0)
    lfEntity.setAssetRefID(getLong(assetRefID))
    LFTincanPackageLocalServiceUtil.updateLFTincanPackage(lfEntity)
  }

  override def setDescriptions(id: Int, title: String, summary: String): Unit = {
    val lfEntity = LFTincanPackageLocalServiceUtil.findByPackageID(Array(getLong(id).toLong: java.lang.Long)).get(0)
    lfEntity.setTitle(title)
    lfEntity.setSummary(summary)
    LFTincanPackageLocalServiceUtil.updateLFTincanPackage(lfEntity)
  }

  override def setLogo(id: Int, logo: Option[String]): Unit = {
    val lfEntity = LFTincanPackageLocalServiceUtil.findByPackageID(Array(getLong(id).toLong: java.lang.Long)).get(0)
    logo.foreach(lfEntity.setLogo)
    LFTincanPackageLocalServiceUtil.updateLFTincanPackage(lfEntity)
  }

  private def fillManifestWithScopeValues(scope: ScopeType.Value = ScopeType.Instance, scopeID: Option[String] = None): (TincanManifest) => Seq[TincanManifest] = {
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

  private def fillByScopeRule(manifest: TincanManifest): (PackageScopeRule) => TincanManifest = {
    scopeRule =>
      manifest.copy(
        visibility = Option(scopeRule.visibility),
        isDefault = scopeRule.isDefault)
  }

  private def extract(lfEntity: LFTincanPackage) = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    val lessonLimit = Try({
      val limit = LFLessonLimitLocalServiceUtil.findByID(lfEntity.getId, LessonType.tincanPackage.toString)
      (limit.getPassingLimit.toInt, limit.getRerunInterval.toInt, limit.getRerunIntervalType)
    }
    ).getOrElse((0, 0, ""))

    TincanManifest(
      lfEntity.getId.toInt,
      lfEntity.getTitle,
      Option(lfEntity.getSummary),
      lfEntity.getCourseID.toOption,
      lfEntity.getAssetRefID.toOption,
      None, Option(lfEntity.getLogo),
      false,
      lessonLimit._1,
      lessonLimit._2,
      PeriodType(lessonLimit._3))
  }

  private def fillManifestWithScopeValuesWithFilter(scope: ScopeType.Value = ScopeType.Instance, scopeID: Option[String] = None): (TincanManifest) => Seq[TincanManifest] = {
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
}
