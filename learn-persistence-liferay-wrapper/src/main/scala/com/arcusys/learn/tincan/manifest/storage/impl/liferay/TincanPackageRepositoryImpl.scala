package com.arcusys.learn.tincan.manifest.storage.impl.liferay

import com.arcusys.valamis.lesson.model.{PackageScopeRule, LessonType}
import com.arcusys.valamis.lesson.storage.PackageScopeRuleStorage
import com.arcusys.valamis.lesson.tincan.model.{TincanPackage, TincanManifest}
import com.arcusys.valamis.lesson.tincan.storage.TincanPackageStorage
import com.arcusys.valamis.model.{ScopeType, PeriodTypes}
import org.joda.time.DateTime
import com.arcusys.learn.persistence.liferay.model.LFTincanPackage
import com.arcusys.learn.persistence.liferay.service.{LFLessonLimitLocalServiceUtil, LFTincanPackageLocalServiceUtil}
import com.arcusys.learn.persistence.liferay.service.persistence.LFLessonLimitPK
import com.arcusys.learn.scorm.manifest.storage.impl.liferay.PackageScopeRuleHelper
import com.liferay.portal.kernel.dao.orm.{PropertyFactoryUtil, RestrictionsFactoryUtil}

import scala.collection.JavaConverters._
import scala.util.Try

/**
 * Created by mminin on 15.10.14.
 */
trait TincanPackageRepositoryImpl extends TincanPackageStorage {

  def packageScopeRuleRepository: PackageScopeRuleStorage

  override def createAndGetID(title: String, summary: String, courseID: Option[Int]): Long = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    val newEntity = LFTincanPackageLocalServiceUtil.createLFTincanPackage()

    newEntity.setCourseID(courseID)
    newEntity.setSummary(summary)
    newEntity.setTitle(title)

    LFTincanPackageLocalServiceUtil.addLFTincanPackage(newEntity).getId
  }

  override def delete(id: Long): Unit = {
    packageScopeRuleRepository.delete(id.toInt)

    LFTincanPackageLocalServiceUtil.deleteLFTincanPackage(id)
    Try(LFLessonLimitLocalServiceUtil.findByID(id, LessonType.Tincan.toString)).map { passingLimitEntity =>
      LFLessonLimitLocalServiceUtil.deleteLFLessonLimit(passingLimitEntity)
    }
  }

  override def getAll: Seq[TincanManifest] = {
    Seq(LFTincanPackageLocalServiceUtil.getLFTincanPackage(-1)).map(extract)
  }

  override def getByTitleAndCourseId(titlePattern: String, courseIds: Seq[Int]): Seq[TincanPackage] = {
    LFTincanPackageLocalServiceUtil.findByTitleAndCourseID(titlePattern + "%", courseIds.toArray.map(i => i: java.lang.Integer)).asScala
      .map(extractPackage)
  }

  override def getCountByTitleAndCourseId(titlePattern: String, courseIds: Seq[Int]): Int = {
    LFTincanPackageLocalServiceUtil.countByTitleAndCourseID(titlePattern, courseIds.toArray.map(i => i: java.lang.Integer))
  }

  override def getById(id: Long): Option[TincanPackage] = {
    Option(LFTincanPackageLocalServiceUtil.fetchLFTincanPackage(id)).map(extractPackage)
  }

  override def getByRefID(refID: Long): Option[TincanManifest] = {
    Try(LFTincanPackageLocalServiceUtil.findByRefID(refID)).toOption.map(extract)
  }

  override def getByCourseId(courseID: Option[Int], onlyVisible: Boolean): Seq[TincanManifest] = {
    if (onlyVisible) {
      val packageQuery = courseID match {
        case Some(x) => val visiblePackageIdQuery = PackageScopeRuleHelper.getPackageIdVisibleDynamicQuery(ScopeType.Site, Option(x.toString))
          LFTincanPackageLocalServiceUtil.dynamicQuery()
            .add(PropertyFactoryUtil.forName("id").in(visiblePackageIdQuery))
        case _ => LFTincanPackageLocalServiceUtil.dynamicQuery()
      }

      val packages = LFTincanPackageLocalServiceUtil.dynamicQuery(packageQuery).asScala.map(_.asInstanceOf[LFTincanPackage])
      packages.map(extract)
    }
    else
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

  override def getOnlyVisible(scope: ScopeType.Value, scopeID: String, titlePattern: Option[String], date: DateTime): Seq[TincanPackage] = {
    val visiblePackageIdQuery = PackageScopeRuleHelper.getPackageIdVisibleDynamicQuery(scope, Option(scopeID))

    val packageQuery = LFTincanPackageLocalServiceUtil.dynamicQuery()
      .add(PropertyFactoryUtil.forName("id").in(visiblePackageIdQuery))
      .add(RestrictionsFactoryUtil.or(
      RestrictionsFactoryUtil.isNull("beginDate"),
      RestrictionsFactoryUtil.le("beginDate", date.toDate))
      )
      .add(RestrictionsFactoryUtil.or(
      RestrictionsFactoryUtil.isNull("endDate"),
      RestrictionsFactoryUtil.ge("endDate", date.toDate))
      )

    var packages = LFTincanPackageLocalServiceUtil.dynamicQuery(packageQuery).asScala.map(_.asInstanceOf[LFTincanPackage])

    packages = titlePattern.map(_.toLowerCase) match {
      case Some(title) => packages.filter(_.getTitle.toLowerCase.contains(title))
      case None => packages
    }

    packages.map(extractPackage)
  }

  override def getInstanceScopeOnlyVisible(courseIDs: List[Int], titlePattern: Option[String], date: DateTime): Seq[TincanPackage] = {
    if (courseIDs.isEmpty) return Seq()

    val visiblePackageIdQuery = PackageScopeRuleHelper.getPackageIdVisibleDynamicQuery(ScopeType.Instance, None)

    val packageQuery = LFTincanPackageLocalServiceUtil.dynamicQuery()
      .add(RestrictionsFactoryUtil.in("courseID", courseIDs.asJava))
      .add(PropertyFactoryUtil.forName("id").in(visiblePackageIdQuery))
      .add(RestrictionsFactoryUtil.or(
      RestrictionsFactoryUtil.isNull("beginDate"),
      RestrictionsFactoryUtil.lt("beginDate", date.toDate))
      )
      .add(RestrictionsFactoryUtil.or(
      RestrictionsFactoryUtil.isNull("endDate"),
      RestrictionsFactoryUtil.gt("endDate", date.toDate))
      )

    var packages = LFTincanPackageLocalServiceUtil.dynamicQuery(packageQuery).asScala.map(_.asInstanceOf[LFTincanPackage])

    packages = titlePattern.map(_.toLowerCase) match {
      case Some(title) => packages.filter(_.getTitle.toLowerCase.contains(title))
      case None => packages
    }

    packages.map(extractPackage)
  }

  override def modify(id: Long, title: String, summary: String, beginDate: Option[DateTime], endDate: Option[DateTime]) = {
    val lfEntity = LFTincanPackageLocalServiceUtil.getLFTincanPackage(id)
    lfEntity.setTitle(title)
    lfEntity.setSummary(summary)
    lfEntity.setBeginDate(beginDate.map(_.toDate).orNull)
    lfEntity.setEndDate(endDate.map(_.toDate).orNull)
    val updatedEntity = LFTincanPackageLocalServiceUtil.updateLFTincanPackage(lfEntity)
    extractPackage(updatedEntity)
  }

  override def setLogo(id: Long, logo: Option[String]): Unit = {
    val lfEntity = LFTincanPackageLocalServiceUtil.getLFTincanPackage(id)
    logo.foreach(l => {
      lfEntity.setLogo(l)
      LFTincanPackageLocalServiceUtil.updateLFTincanPackage(lfEntity)
    })
  }

  override def setAssetRefID(id: Long, assetRefID: Long): TincanPackage = {
    val lfEntity = LFTincanPackageLocalServiceUtil.getLFTincanPackage(id)
    lfEntity.setAssetRefID(assetRefID)
    val lfEntyUpdated = LFTincanPackageLocalServiceUtil.updateLFTincanPackage(lfEntity)
    extractPackage(lfEntyUpdated)
  }

  private def fillManifestWithScopeValues(scope: ScopeType.Value = ScopeType.Instance, scopeID: Option[String] = None): (TincanManifest) => Seq[TincanManifest] = {
    manifest => {
      val scopeRules = packageScopeRuleRepository.getAll(manifest.id.toInt, scope, scopeID)
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

  private def extractPackage(lfEntity: LFTincanPackage): TincanPackage = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

    TincanPackage(
      lfEntity.getId,
      lfEntity.getTitle,
      Option(lfEntity.getSummary),
      lfEntity.getCourseID.toOption,
      lfEntity.getAssetRefID.toOption,
      Option(lfEntity.getLogo),
      Option(lfEntity.getBeginDate).map(new DateTime(_)),
      Option(lfEntity.getEndDate).map(new DateTime(_))
    )
  }

  private def extract(lfEntity: LFTincanPackage) = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    val lfLimitPK = new LFLessonLimitPK(lfEntity.getId, LessonType.Tincan.toString)
    val lessonLimit = Option(LFLessonLimitLocalServiceUtil.fetchLFLessonLimit(lfLimitPK))

    TincanManifest(
      lfEntity.getId.toInt,
      lfEntity.getTitle,
      Option(lfEntity.getSummary),
      lfEntity.getCourseID.toOption,
      lfEntity.getAssetRefID.toOption,
      None, Option(lfEntity.getLogo),
      isDefault = false,
      lessonLimit.flatMap(_.getPassingLimit.toOption).getOrElse(0),
      lessonLimit.flatMap(_.getRerunInterval.toOption).getOrElse(0),
      PeriodTypes(lessonLimit.flatMap(_.getRerunIntervalType.toOption).getOrElse("")),
      Option(lfEntity.getBeginDate).map(new DateTime(_)),
      Option(lfEntity.getEndDate).map(new DateTime(_))
    )
  }

  private def fillManifestWithScopeValuesWithFilter(scope: ScopeType.Value = ScopeType.Instance, scopeID: Option[String] = None): (TincanManifest) => Seq[TincanManifest] = {
    manifest => {
      val scopeRules = packageScopeRuleRepository.getAll(manifest.id.toInt, scope, scopeID)
      if (scopeRules.isEmpty) {
        Seq()
      } else {
        scopeRules.map(fillByScopeRule(manifest))
      }
    }
  }

  private def getInt(value: Any): Int = {
    value match {
      case i: Int => i
      case l: Long => l.toInt
      case _ => 0
    }
  }
}
