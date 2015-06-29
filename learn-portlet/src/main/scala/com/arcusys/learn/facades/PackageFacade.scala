package com.arcusys.learn.facades

import java.io.{File, InputStream}

import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.models.response.CollectionResponse
import com.arcusys.learn.models.valamispackage.PackageSortBy.PackageSortBy
import com.arcusys.learn.models.valamispackage.{PackageResponse, PackageSortBy, PackageUploadModel, PlayerPackageResponse}
import com.arcusys.valamis.gradebook.service.PackageGradeService
import com.arcusys.valamis.lesson.model
import com.arcusys.valamis.lesson.model.LessonType.LessonType
import com.arcusys.valamis.lesson.model._
import com.arcusys.valamis.lesson.service.export.{PackageExportProcessor, PackageImportProcessor, PackageMobileExportProcessor}
import com.arcusys.valamis.lesson.service.{LessonLimitChecker, TagServiceContract, ValamisPackageService}
import com.arcusys.valamis.lesson.tincan.model.ManifestActivity
import com.arcusys.valamis.lrs.api.StatementApi
import com.arcusys.valamis.model.PeriodTypes.PeriodType
import com.arcusys.valamis.model.ScopeType
import com.arcusys.valamis.util.StringExtensions._
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import org.joda.time.DateTime

/**
 * Created by Iliya Tryapitsin on 16.04.2014.
 */

class PackageFacade(configuration: BindingModule) extends PackageFacadeContract with Injectable {
  def this() = this(Configuration)

  implicit val bindingModule = configuration

  val packageService = inject[ValamisPackageService]
  val gradeService = new PackageGradeService()
  val packageChecker = inject[LessonLimitChecker]
  val tagService = inject[TagServiceContract]


  private[facades] def getPackageType(packageId: Int): LessonType = {
    packageService.getPackageType(packageId)
  }

  private[facades] def updatePackageGrade(valamisUserId: Int, packageId: Int, grade: String, comment: String) =
    gradeService.updatePackageGrade(valamisUserId, packageId, grade, comment)

  def getPackageGrade(valamisUserId: Int, packageId: Long) = {
    gradeService.getPackageGrade(valamisUserId, packageId)
  }

  def getManifestActivities(packageId: Long): Seq[ManifestActivity] =
    packageService.getManifestActivities(packageId)

  def getPackagesCount(courseId: Int): Int = packageService.getPackagesCount(courseId)

  def getCompletedPackagesCount(courseId: Int, userId: Int): Int =
    gradeService.getCompletedPackagesCount(courseId, userId)

  def getPackagesByCourse(courseId: Int): Seq[BaseManifest] =
    packageService.getPackagesByCourse(courseId)

  def getTincanPackagesByCourse(courseId: Int, onlyVisible: Boolean): Seq[BaseManifest] =
    packageService.getTincanPackagesByCourse(courseId, onlyVisible)

  def getPackage(packageId: Long): BaseManifest =
    packageService.getPackage(packageId)

  override def exportAllPackages(courseId: Int): InputStream = {
    new PackageExportProcessor().exportItems(packageService.getPackagesByCourse(courseId))
  }

  override def exportPackages(packagesIds: Seq[Long]): InputStream = {
    new PackageExportProcessor().exportItems(packagesIds.map(packageService.getPackage))
  }

  override def exportPackagesForMobile(packagesIds: Seq[Long]): InputStream = {
    new PackageMobileExportProcessor().exportItems(packagesIds.map(packageService.getPackage))
  }

  override def importPackages(file: File, courseId: Int, userId: Long): Unit = {
    new PackageImportProcessor().importItems(file, courseId, userId)
  }

  private def toResponse(model: ValamisPackage): PlayerPackageResponse = {
    PlayerPackageResponse(model.id,
      model.title,
      model.description.map(_.urlDecode).map(_.replaceAll("\n", "")),
      model.version,
      model.visibility,
      model.isDefault,
      model.packageType match {
        case LessonType.Tincan => "tincan"
        case LessonType.Scorm  => "scorm"
      },
      model.logo,
      model.suspendedId,
      model.passingLimit,
      model.rerunInterval,
      model.rerunIntervalType.toString,
      model.attemptsCount,
      model.stateType match {
        case PackageState.Attempted => "attempted"
        case PackageState.Finished  => "finished"
        case PackageState.None | _  => "none"
      },
      model.tags,
      model.beginDate.map(_.toString()).getOrElse(""),
      model.endDate.map(_.toString()).getOrElse("")
    )
  }

  private def toResponse(manifest: BaseManifest, user: LUser): PackageResponse = {
    PackageResponse(
      manifest.id,
      manifest.title,
      manifest.summary.map(_.urlDecode).map(_.replaceAll("\n", "")),
      manifest.visibility.getOrElse(false),
      manifest.isDefault,
      manifest.getType match {
        case LessonType.Tincan => "tincan"
        case LessonType.Scorm  => "scorm"
      },
      manifest.logo,
      manifest.passingLimit,
      manifest.rerunInterval,
      manifest.rerunIntervalType.toString,
      manifest.assetRefId.map(tagService.getEntryTags).getOrElse(Seq()),
      manifest.beginDate.map(_.toString()).getOrElse(""),
      manifest.endDate.map(_.toString()).getOrElse("")
    )
  }

  def getForPlayerConfig(playerId: String, companyId: Long, groupId: Long, user: LUser): Seq[PackageResponse] = {
    packageService.getPersonalForPlayer(playerId, companyId, groupId, user.getUserId.toInt).map(toResponse(_, user))
  }

  def getAllPackages(packageType: Option[String], courseId: Option[Int], scope: String, filter: String, tagId: Option[Long], 
    isSortDirectionAsc: Boolean, skip: Int, count: Int, page: Int, companyId: Long, user: LUser): CollectionResponse[PackageResponse] = {

    val lessonType = packageType match {
      case Some("scorm")  => Option(LessonType.Scorm)
      case Some("tincan") => Option(LessonType.Tincan)
      case _              => None
    }
    val pagedResult = packageService.getAllPackages(lessonType, courseId, ScopeType.withName(scope), filter, tagId, isSortDirectionAsc, skip, count, page, companyId, user.getUserId.toInt)

    CollectionResponse(
      page,
      pagedResult.items.map(p => toResponse(p, user)),
      pagedResult.total
    )
  }

  def getForPlayer(statementApi: StatementApi, companyId: Long, courseId: Int, pageId: String, filter: String, tagId: Option[Long], playerId: String,
    user: LUser, isSortDirectionAsc: Boolean, sortBy: PackageSortBy,
    page: Int, count: Int): CollectionResponse[PlayerPackageResponse] = {

    val skip = (page - 1) * count
    val sortByM = sortBy match {
      case PackageSortBy.Date => model.PackageSortBy.Date
      case PackageSortBy.Name => model.PackageSortBy.Name
      case _                  => model.PackageSortBy.Name
    }
    val pagedResult = packageService.getVisibleForPlayer(statementApi, companyId, courseId, pageId, filter, tagId, playerId, user, isSortDirectionAsc, sortByM, skip, count)

    CollectionResponse(
      page,
      pagedResult.items.map(toResponse),
      pagedResult.total
    )
  }

  def getByScopeType(courseId: Int, scope: String, pageId: Option[String], playerId: Option[String], companyId: Long,
    courseIds: List[Int], user: LUser): Seq[PackageResponse] = {
    packageService.getByScopeType(courseId, ScopeType.withName(scope), pageId, playerId, companyId, courseIds, user.getUserId.toInt).
      map(toResponse(_, user))
  }

  def uploadPackages(packages: Seq[PackageUploadModel], scope: String, courseId: Int, pageId: Option[String], playerId: Option[String]) {

    val uploadedPackages = packages.map(p => model.PackageUploadModel(
      p.id, p.title, p.description, p.packageType, p.logo
    ))
    packageService.uploadPackages(uploadedPackages, ScopeType.withName(scope), courseId, pageId, playerId)
  }

  def updatePackage(packageId: Long, tags: Seq[String], passingLimit: Int, rerunInterval: Int, rerunIntervalType: PeriodType, beginDate: Option[DateTime], endDate: Option[DateTime], scope: String, visibility: Boolean, isDefault: Boolean, companyId: Long, courseId: Int, title: String, description: String, packageType: String, pageID: Option[String], playerID: Option[String], user: LUser): PackageResponse = {

    val lessonType = getLessonType(packageType)

    val tagIds = tagService.getTagIds(tags, companyId)
    val updatedPackage = packageService.updatePackage(tagIds, passingLimit, rerunInterval, rerunIntervalType, beginDate, endDate, ScopeType.withName(scope), packageId, visibility, isDefault, courseId, title, description, lessonType, pageID, playerID, user.getUserId.toInt)
    toResponse(updatedPackage, user)
  }

  private def getLessonType(packageType: String): LessonType.Value = {
    packageType match {
      case "scorm"  => LessonType.Scorm
      case "tincan" => LessonType.Tincan
    }
  }

  def updatePackageLogo(packageId: Long, packageType: String, packageLogo: Option[String]) {
    packageService.updatePackageLogo(packageId, getLessonType(packageType), packageLogo)
  }

  def updatePackageScopeVisibility(id: Long, scope: String, courseId: Int, visibility: Boolean, isDefault: Boolean, pageId: Option[String], playerId: Option[String], user: LUser) {
    packageService.updatePackageScopeVisibility(id, ScopeType.withName(scope), courseId, visibility, isDefault, pageId, playerId, user.getUserId.toInt)
  }

  def addPackageToPlayer(playerId: String, packageId: Long) = {
    packageService.addPackageToPlayer(playerId, packageId)
  }

  def updatePlayerScope(scope: String, playerId: String) {
    packageService.updatePlayerScope(ScopeType.withName(scope), playerId)
  }

  def removePackage(packageId: Long, packageType: String): String = {

    packageService.removePackage(packageId, getLessonType(packageType))
    "ok"
  }

  def removePackages(packageIds: Seq[Long]): String = {
    packageService.removePackages(packageIds)
    "ok"
  }
}
