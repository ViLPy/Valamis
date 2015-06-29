package com.arcusys.valamis.lesson.service

import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.services.LayoutLocalServiceHelper
import com.arcusys.valamis.lesson.model.LessonType._
import com.arcusys.valamis.lesson.model.{LessonType, _}
import com.arcusys.valamis.lesson.scorm.model.ScormPackage
import com.arcusys.valamis.lesson.scorm.model.manifest.Manifest
import com.arcusys.valamis.lesson.scorm.storage.ScormPackagesStorage
import com.arcusys.valamis.lesson.service.extract.{ManifestWithScopeExtract, ValamisPackageExtract}
import com.arcusys.valamis.lesson.storage.{LessonLimitStorage, PackageScopeRuleStorage, PlayerScopeRuleStorage}
import com.arcusys.valamis.lesson.tincan.model.{TincanManifest, TincanPackage}
import com.arcusys.valamis.lesson.tincan.storage.TincanPackageStorage
import com.arcusys.valamis.lrs.api.StatementApi
import com.arcusys.valamis.model.ScopeType._
import com.arcusys.valamis.model.{ RangeResult, ScopeType }
import org.joda.time.DateTime

import scala.collection.JavaConverters._

trait PackageSelect extends ValamisPackageService with ManifestWithScopeExtract with ValamisPackageExtract {

  protected def tagService: TagServiceContract
  protected def packageService: PackageService
  protected def passingLimitChecker: LessonLimitChecker
  protected def tcpackageRepository: TincanPackageStorage
  protected def packageRepository: ScormPackagesStorage
  protected def packageScopeRuleStorage: PackageScopeRuleStorage
  protected def playerScopeRuleRepository: PlayerScopeRuleStorage
  protected def lessonLimitStorage: LessonLimitStorage

  def getAllPackages(packageType: Option[LessonType], courseId: Option[Int], scope: ScopeType, filter: String, tagId: Option[Long], isSortDirectionAsc: Boolean, skip: Int, count: Int, page: Int, companyID: Long, userId: Long): RangeResult[BaseManifest] = {

    val titlePattern = filter
    val courseIDs = scope match {
      case ScopeType.Instance => packageService.getAllCourseIDs(companyID)
      case ScopeType.Site     => List(courseId.get)
    }
    val scopeId = scope match {
      case ScopeType.Instance => None
      case ScopeType.Site     => courseId.map(_.toString)
    }

    lazy val tincanPackages = tcpackageRepository.getByTitleAndCourseId(titlePattern, courseIDs)
    lazy val scormPackages = packageRepository.getByTitleAndCourseId(titlePattern, courseIDs)

    var rawPackages = packageType match {
      case Some(LessonType.Scorm)  => scormPackages
      case Some(LessonType.Tincan) => tincanPackages
      case _                       => scormPackages ++ tincanPackages
    }

    for (tagIdLong <- tagId) {
      rawPackages = rawPackages
        .filter(_.assetRefId.isDefined)
        .filter(p => tagService.getEntryTags(p.assetRefId.get).map(_.id).contains(tagIdLong))
    }

    rawPackages = rawPackages.sortBy(_.title)

    val totalCount = rawPackages.size

    val packages = (if (isSortDirectionAsc) rawPackages else rawPackages.reverse)
      .drop(skip)
      .take(if (count == 0) totalCount else count)
      .flatMap {
        case t: TincanPackage => toTincanManifestWithScopeValues(t, scope, scopeId)
        case s: ScormPackage  => toScormManifestWithScopeValues(s, scope, scopeId)
      }

    RangeResult(totalCount, packages)
  }

  def getVisibleForPlayer(statementApi: StatementApi, companyID: Long, courseId: Int, pageID: String, filter: String, tagId: Option[Long], playerID: String, user: LUser, isSortDirectionAsc: Boolean, sortBy: PackageSortBy.PackageSortBy, skip: Int, count: Int): RangeResult[ValamisPackage] = {
    val userId = user.getUserId.toInt
    val rule = playerScopeRuleRepository.get(playerID)
    val scope = rule.map(_.scope).getOrElse(ScopeType.Site)
    val scopeId = scope match {
      case ScopeType.Instance => None
      case ScopeType.Site     => Some(courseId.toString)
      case ScopeType.Page     => Some(pageID)
      case ScopeType.Player   => Some(playerID)
    }
    val titlePattern = if (filter.isEmpty) None else Some(filter)

    val date = new DateTime()

    val scormPackages = scope match {
      case ScopeType.Instance => packageRepository.getInstanceScopeOnlyVisible(packageService.getAllCourseIDs(companyID), titlePattern, date)
      case _                  => packageRepository.getOnlyVisible(scope, scopeId.get, titlePattern, date)
    }
    val tincanPackages = scope match {
      case ScopeType.Instance => tcpackageRepository.getInstanceScopeOnlyVisible(packageService.getAllCourseIDs(companyID), titlePattern, date)
      case _                  => tcpackageRepository.getOnlyVisible(scope, scopeId.get, titlePattern, date)
    }

    val packagesWithLimits = lessonLimitStorage.getByIDs(scormPackages.map(_.id) ++ tincanPackages.map(_.id)).map(_.itemID)

    var packages: Seq[PackageBase] =
      tincanPackages.filter(p => !packagesWithLimits.contains(p.id) || passingLimitChecker.checkTincanPackage(user, p.id.toInt, statementApi)) ++
        scormPackages.filter(p => !packagesWithLimits.contains(p.id) || passingLimitChecker.checkScormPackage(user, p.id.toInt, statementApi))


    for (tagIdLong <- tagId) {
      packages = packages
        .filter(_.assetRefId.isDefined)
        .filter(p => tagService.getEntryTags(p.assetRefId.get).map(_.id).contains(tagIdLong))
    }

    val totalCount = packages.size

    val sorted = sortBy match {
      case PackageSortBy.Name => packages.sortBy(_.title)
      case PackageSortBy.Date => packages.sortBy(_.id)
    }

    val pagePackages = (if (isSortDirectionAsc) sorted else sorted.reverse)
      .drop(skip)
      .take(if (count == 0) totalCount else count)
      .flatMap({
        case t: TincanPackage => toTincanManifestWithScopeValues(t, scope, scopeId)
        case t: ScormPackage  => toScormManifestWithScopeValues(t, scope, scopeId)
      })

    new RangeResult(
      totalCount,
      pagePackages.map({
        case p: Manifest       => toValamisPackage(p, user, statementApi)
        case p: TincanManifest => toValamisPackage(p, user, statementApi)
      })
    )
  }

  def getPersonalForPlayer(playerID: String, companyID: Long, groupId: Long, userId: Int): Seq[BaseManifest] = {

    val courseIds = packageService.getAllCourseIDs(companyID)
    val layouts = LayoutLocalServiceHelper.getLayouts(groupId, privateLayout = true)

    val shown = packageRepository.getByExactScope(courseIds, ScopeType.Player, playerID).map(_.id)
    val personalPackages = packageRepository.getByCourseId(Some(layouts.asScala.last.getGroupId.toInt)).filter(p => !shown.contains(p.id))
    val shownTC = tcpackageRepository.getByExactScope(courseIds, ScopeType.Player, playerID).map(_.id)
    val personalTincanPackages = tcpackageRepository.getByCourseId(Some(layouts.asScala.last.getGroupId.toInt)).filter(p => !shownTC.contains(p.id))

    personalPackages ++ personalTincanPackages
  }

  def getByScopeType(courseID: Int, scope: ScopeType, pageID: Option[String], playerID: Option[String], companyID: Long, courseIds: List[Int], userId: Int): Seq[BaseManifest] = {
    scope match {
      case ScopeType.Page =>
        val pagePackages = packageRepository.getByScope(courseID, scope, pageID.get)
        val tincanPackages = tcpackageRepository.getByScope(courseID, scope, pageID.get)
        pagePackages ++ tincanPackages
      case ScopeType.Player =>
        val playerPackages = packageRepository.getByScope(courseID, scope, playerID.get)
        val tincanPackages = tcpackageRepository.getByScope(courseID, scope, playerID.get)
        val personalPackages = packageRepository.getByExactScope(courseIds, scope, playerID.get)
        val personalTincanPackages = tcpackageRepository.getByExactScope(courseIds, scope, playerID.get)
        playerPackages ++ tincanPackages ++ personalPackages ++ personalTincanPackages
      case ScopeType.Site =>
        val sitePackages = packageRepository.getByCourseId(Option(courseID))
        val tincanPackages = tcpackageRepository.getByCourseId(Option(courseID))
        sitePackages ++ tincanPackages
      case ScopeType.Instance =>
        val courseIds = packageService.getAllCourseIDs(companyID)
        val scormPackages = packageRepository.getAllForInstance(courseIds)
        val tincanPackages = tcpackageRepository.getAllForInstance(courseIds)
        scormPackages ++ tincanPackages
    }
  }
}
