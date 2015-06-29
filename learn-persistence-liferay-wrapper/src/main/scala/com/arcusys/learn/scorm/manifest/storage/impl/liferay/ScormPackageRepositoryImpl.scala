package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import com.arcusys.valamis.lesson.model.{ PackageScopeRule, LessonType }
import com.arcusys.valamis.lesson.scorm.model
import com.arcusys.valamis.lesson.scorm.model.{ ScormPackage, manifest }
import com.arcusys.valamis.lesson.scorm.model.manifest.Manifest
import com.arcusys.valamis.lesson.scorm.storage.ScormPackagesStorage
import com.arcusys.valamis.lesson.storage.PackageScopeRuleStorage
import com.arcusys.valamis.model.{ ScopeType, PeriodTypes }
import org.joda.time.DateTime
import com.arcusys.learn.persistence.liferay.model.LFPackage
import com.arcusys.learn.persistence.liferay.service.persistence.LFLessonLimitPK
import com.arcusys.learn.persistence.liferay.service.{ LFAttemptLocalServiceUtil, LFLessonLimitLocalServiceUtil, LFPackageLocalServiceUtil }
import com.liferay.portal.kernel.dao.orm.{ PropertyFactoryUtil, RestrictionsFactoryUtil }

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

  override def createAndGetID(entity: manifest.Manifest, courseID: Option[Int]): Long = {
    val manifest = model.manifest.Manifest(0, entity.version, entity.base, entity.scormVersion, entity.defaultOrganizationID,
      entity.resourcesBase, entity.title, entity.summary, entity.metadata, entity.assetRefId,
      courseID, logo = entity.logo, isDefault = false, beginDate = None, endDate = None)

    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    val newEntity = LFPackageLocalServiceUtil.createLFPackage()

    newEntity.setDefaultOrganizationID(manifest.defaultOrganizationID.orNull)
    newEntity.setTitle(manifest.title)
    newEntity.setBase(manifest.base.orNull)
    newEntity.setResourcesBase(manifest.resourcesBase.orNull)
    newEntity.setSummary(manifest.summary.orNull)
    newEntity.setAssetRefID(manifest.assetRefId)
    newEntity.setCourseID(manifest.courseId)
    newEntity.setBeginDate(null)
    newEntity.setEndDate(null)
    manifest.logo.foreach(newEntity.setLogo)

    val id = LFPackageLocalServiceUtil.addLFPackage(newEntity).getId

    val limitEntity = LFLessonLimitLocalServiceUtil.createLFLessonLimit(new LFLessonLimitPK(id.toLong, LessonType.Scorm.toString))
    limitEntity.setPassingLimit(entity.passingLimit)
    limitEntity.setRerunInterval(entity.rerunInterval)
    limitEntity.setRerunIntervalType(entity.rerunIntervalType.toString)
    LFLessonLimitLocalServiceUtil.addLFLessonLimit(limitEntity)
    id
  }

  override def delete(id: Long): Unit = {
    val limitEntity = LFLessonLimitLocalServiceUtil.findByID(id, LessonType.Scorm.toString)
    LFLessonLimitLocalServiceUtil.deleteLFLessonLimit(limitEntity)

    LFPackageLocalServiceUtil.deleteLFPackage(id)

    packageScopeRuleRepository.delete(id.toInt)
  }

  override def getById(id: Long): Option[ScormPackage] = {
    Option(LFPackageLocalServiceUtil.fetchLFPackage(id)).map(extractPackage)
  }

  override def getById(id: Long, courseID: Int, scope: ScopeType.Value, scopeID: String): Option[manifest.Manifest] = {
    if (scope == ScopeType.Instance) {
      Option(LFPackageLocalServiceUtil.getLFPackage(id))
        .map(extract)
        .map(fillManifestWithScopeValues()(_).head)
    } else {
      Option(LFPackageLocalServiceUtil.getLFPackage(id))
        .map(extract)
        .filter(_.courseId == Option(courseID))
        .map(fillManifestWithScopeValues(scope, Option(scopeID))(_).head)
    }
  }

  override def getByRefID(refID: Long): Option[manifest.Manifest] = {
    Option(LFPackageLocalServiceUtil.findByRefID(getLong(refID))) map extract
  }

  override def getAll: Seq[manifest.Manifest] = {
    LFPackageLocalServiceUtil.getLFPackages(-1, -1).asScala map extract
  }

  override def getByTitleAndCourseId(titlePattern: String, courseIds: Seq[Int]): Seq[ScormPackage] = {
    LFPackageLocalServiceUtil.findByTitleAndCourseID(titlePattern + "%", courseIds.toArray.map(i => i: java.lang.Integer)).asScala
      .map(extractPackage)
  }

  override def getCountByTitleAndCourseId(titlePattern: String, courseIds: Seq[Int]): Int = {
    LFPackageLocalServiceUtil.countByTitleAndCourseID(titlePattern, courseIds.toArray.map(i => i: java.lang.Integer))
  }

  // get all in course with visibility
  override def getByCourseId(courseID: Option[Int]): Seq[manifest.Manifest] = {
    courseID.map(courseID => getByScope(courseID, ScopeType.Site, courseID.toString)).getOrElse(Seq())
  }

  // get all in instance with visibility
  override def getAllForInstance(courseIDs: List[Int]): Seq[manifest.Manifest] = {
    LFPackageLocalServiceUtil.findByInstance(courseIDs.toArray.map(i => i: java.lang.Integer)).asScala
      .map(extract)
      .flatMap(fillManifestWithScopeValues())
  }

  // get all in current course (liferay site) by scope with visibility
  override def getByScope(courseID: Int, scope: ScopeType.Value, scopeID: String): Seq[manifest.Manifest] = {
    LFPackageLocalServiceUtil.findByCourseID(courseID).asScala
      .map(extract)
      .flatMap(fillManifestWithScopeValues(scope, Option(scopeID)))
  }

  override def getByExactScope(courseIDs: List[Int], scope: ScopeType.Value, scopeID: String): Seq[manifest.Manifest] = {
    LFPackageLocalServiceUtil.findByInstance(courseIDs.toArray.map(i => i: java.lang.Integer)).asScala
      .map(extract)
      .flatMap(fillManifestWithScopeValuesWithFilter(scope, Option(scopeID)))
  }

  // for Player show only visible in current scope
  override def getOnlyVisible(scope: ScopeType.Value, scopeID: String, titlePattern: Option[String], date: DateTime): Seq[ScormPackage] = {
    val visiblePackageIdQuery = PackageScopeRuleHelper.getPackageIdVisibleDynamicQuery(scope, Option(scopeID))

    val packageQuery = LFPackageLocalServiceUtil.dynamicQuery()
      .add(PropertyFactoryUtil.forName("id").in(visiblePackageIdQuery))
      .add(RestrictionsFactoryUtil.or(
        RestrictionsFactoryUtil.isNull("beginDate"),
        RestrictionsFactoryUtil.le("beginDate", date.toDate))
      )
      .add(RestrictionsFactoryUtil.or(
        RestrictionsFactoryUtil.isNull("endDate"),
        RestrictionsFactoryUtil.ge("endDate", date.toDate))
      )

    var packages = LFPackageLocalServiceUtil.dynamicQuery(packageQuery).asScala.map(_.asInstanceOf[LFPackage])

    packages = titlePattern.map(_.toLowerCase) match {
      case Some(title) => packages.filter(_.getTitle.toLowerCase.contains(title))
      case None        => packages
    }

    packages.map(extractPackage)
  }

  override def getInstanceScopeOnlyVisible(courseIDs: List[Int], titlePattern: Option[String], date: DateTime): Seq[ScormPackage] = {
    if (courseIDs.isEmpty) return Seq()

    val visiblePackageIdQuery = PackageScopeRuleHelper.getPackageIdVisibleDynamicQuery(ScopeType.Instance, None)

    val packageQuery = LFPackageLocalServiceUtil.dynamicQuery()
      .add(RestrictionsFactoryUtil.in("courseID", courseIDs.asJava))
      .add(PropertyFactoryUtil.forName("id").in(visiblePackageIdQuery))
      .add(RestrictionsFactoryUtil.or(
        RestrictionsFactoryUtil.isNull("beginDate"),
        RestrictionsFactoryUtil.le("beginDate", date.toDate))
      )
      .add(RestrictionsFactoryUtil.or(
        RestrictionsFactoryUtil.isNull("endDate"),
        RestrictionsFactoryUtil.ge("endDate", date.toDate))
      )

    var packages = LFPackageLocalServiceUtil.dynamicQuery(packageQuery).asScala.map(_.asInstanceOf[LFPackage])

    packages = titlePattern.map(_.toLowerCase) match {
      case Some(title) => packages.filter(_.getTitle.toLowerCase.contains(title))
      case None        => packages
    }

    packages.map(extractPackage)
  }

  override def getPackagesWithUserAttempts(userID: Int): Seq[manifest.Manifest] = {
    val packageIDs = LFAttemptLocalServiceUtil.findByUserID(userID).asScala.map(_.getPackageID.toLong.asInstanceOf[java.lang.Long]).toSet
    LFPackageLocalServiceUtil.findByPackageID(packageIDs.toArray).asScala.map(extract)
  }

  // These 2 methods is only for SCORM packages
  override def getPackagesWithAttempts: Seq[manifest.Manifest] = {
    val packageIDs = LFAttemptLocalServiceUtil.getLFAttempts(-1, -1).asScala.map(_.getPackageID.toLong.asInstanceOf[java.lang.Long]).toSet
    LFPackageLocalServiceUtil.findByPackageID(packageIDs.toArray).asScala.map(extract)
  }

  override def modify(id: Long, title: String, description: String, beginDate: Option[DateTime], endDate: Option[DateTime]) = {
    val entity = LFPackageLocalServiceUtil.getLFPackage(id)
    entity.setTitle(title)
    entity.setSummary(description)
    entity.setBeginDate(beginDate.map(_.toDate).orNull)
    entity.setEndDate(endDate.map(_.toDate).orNull)
    val updatedEntity = LFPackageLocalServiceUtil.updateLFPackage(entity)

    extractPackage(updatedEntity)
  }

  override def setLogo(id: Long, logo: Option[String]): Unit = {
    val entity = LFPackageLocalServiceUtil.getLFPackage(id)
    logo.foreach { l =>
      entity.setLogo(l)
      LFPackageLocalServiceUtil.updateLFPackage(entity)
    }
  }

  override def setAssetRefID(id: Long, refID: Long): Unit = {
    val entity = LFPackageLocalServiceUtil.getLFPackage(id)
    entity.setAssetRefID(getLong(refID))
    LFPackageLocalServiceUtil.updateLFPackage(entity)
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

  private def extractPackage(lfEntity: LFPackage): ScormPackage = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

    new ScormPackage(
      lfEntity.getId.toInt,
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
      Option(lfEntity.getLogo),
      Option(lfEntity.getBeginDate).map(new DateTime(_)),
      Option(lfEntity.getEndDate).map(new DateTime(_))
    )
  }

  private def extract(lfEntity: LFPackage) = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    val lessonLimit = Try({
      val limit = LFLessonLimitLocalServiceUtil.findByID(lfEntity.getId, LessonType.Scorm.toString)
      (limit.getPassingLimit.toInt, limit.getRerunInterval.toInt, limit.getRerunIntervalType)
    }
    ).getOrElse((0, 0, ""))

    new manifest.Manifest(lfEntity.getId.toInt,
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
      PeriodTypes(lessonLimit._3),
      Option(lfEntity.getBeginDate).map(new DateTime(_)),
      Option(lfEntity.getEndDate).map(new DateTime(_))
    )
  }

  private def fillManifestWithScopeValues(scope: ScopeType.Value = ScopeType.Instance, scopeID: Option[String] = None): (manifest.Manifest) => Seq[manifest.Manifest] = {
    manifest =>
      {
        val scopeRules = packageScopeRuleRepository.getAll(manifest.id.toInt, scope, scopeID)
        if (scopeRules.isEmpty) {
          Seq(manifest)
        } else {
          scopeRules.map(fillByScopeRule(manifest))
        }
      }
  }

  private def fillManifestWithScopeValuesWithFilter(scope: ScopeType.Value = ScopeType.Instance, scopeID: Option[String] = None): (manifest.Manifest) => Seq[manifest.Manifest] = {
    manifest =>
      {
        val scopeRules = packageScopeRuleRepository.getAll(manifest.id.toInt, scope, scopeID)
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
