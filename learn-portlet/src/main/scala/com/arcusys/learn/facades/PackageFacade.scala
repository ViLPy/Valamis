package com.arcusys.learn.facades

import java.io.InputStream
import java.util.Date
import com.arcusys.learn.bl.models.valamispackage
import com.arcusys.learn.bl.services.{ LessonLimitChecker, ValamisPackageServiceContract }
import com.arcusys.learn.models.response.CollectionResponse
import com.arcusys.learn.models.valamispackage.PackageSortBy.PackageSortBy
import com.arcusys.learn.models.valamispackage.{ PackageSortBy, PackageModel, PackageUploadModel }
import com.arcusys.learn.scorm.manifest.model.PackageType.PackageType
import com.arcusys.learn.scorm.manifest.model.PeriodType._
import com.liferay.portal.model.User
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.tincan.manifest.model.ManifestActivity
import com.arcusys.learn.tincan.model.Statement
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

/**
 * Created by Iliya Tryapitsin on 16.04.2014.
 */

class PackageFacade(configuration: BindingModule) extends PackageFacadeContract with Injectable {
  def this() = this(Configuration)

  implicit val bindingModule = configuration

  val packageService = inject[ValamisPackageServiceContract]
  val packageChecker = inject[LessonLimitChecker]

  private[facades] def getPackageType(packageId: Int): PackageType = {
    packageService.getPackageType(packageId)
  }

  private[facades] def updatePackageGrade(valamisUserId: Int, packageId: Int, grade: String, comment: String) =
    packageService.updatePackageGrade(valamisUserId, packageId, grade, comment)

  def getPackageGrade(valamisUserId: Int, packageId: Int) = {
    packageService.getPackageGrade(valamisUserId, packageId)
  }

  def getManifestActivities(packageId: Int): Seq[ManifestActivity] =
    packageService.getManifestActivities(packageId)

  def getPackagesCount(courseId: Int): Int = packageService.getPackagesCount(courseId)

  def getCompletedPackagesCount(courseId: Int, userId: Int): Int =
    packageService.getCompletedPackagesCount(courseId, userId)

  def getPackagesByCourse(courseId: Int): Seq[BaseManifest] =
    packageService.getPackagesByCourse(courseId)

  def getTincanPackagesByCourse(courseId: Int): Seq[BaseManifest] =
    packageService.getTincanPackagesByCourse(courseId)

  def getPackage(packageId: Int): BaseManifest =
    packageService.getPackage(packageId)

  def getStatementGrades(packageId: Int, valamisUserId: Int): Seq[Statement] = {
    packageService.getStatementGrades(packageId, valamisUserId)
  }

  def getStatements(packageObj: BaseManifest, valamisUserId: Int, dateSince: Option[Date] = None): Seq[Statement] = {
    packageService.getStatements(packageObj, valamisUserId, dateSince)
  }

  def getStatements(packageId: Int, valamisUserId: Int): Seq[Statement] = packageService.getStatements(packageId, valamisUserId)

  override def exportAllPackages(courseID: Int): InputStream = {
    packageService.exportAllPackages(courseID)
  }

  override def exportPackages(packagesIds: Seq[Int]): InputStream = {
    packageService.exportPackages(packagesIds)
  }

  override def exportPackagesForMobile(packagesIds: Seq[Int]): InputStream = {
    packageService.exportPackagesForMobile(packagesIds)
  }

  override def importPackages(raw: String, courseID: Int): Unit = {
    packageService.importPackages(raw, courseID)
  }

  def serialize(model: valamispackage.ValamisPackage, user: User) = PackageModel(model.id,
    model.title,
    model.description.map(_.replaceAll("\n", "")),
    model.version,
    model.visibility,
    model.isDefault,
    model.packageType,
    model.logo,
    model.suspendedID,
    model.passingLimit,
    model.rerunInterval,
    model.rerunIntervalType.toString,
    model.attemptCount)

  def getForPlayer(playerID: String, companyID: Long, groupId: Long, user: User): Seq[PackageModel] = {
    packageService.getForPlayer(playerID, companyID, groupId, user.getUserId.toInt)
      .map(p => serialize(p, user)) // PackageModel(p.id, p.title, p.description, p.version, p.visibility, p.isDefault, p.packageType, p.logo, p.suspendedID, p.passingLimit, p.rerunInterval, p.rerunIntervalType, p.attemptCount))
  }

  def getAllPackages(packageType: String, courseID: Option[Int], scope: String, filter: String, isSortDirectionAsc: Boolean, skip: Int, count: Int, page: Int, companyID: Long, user: User): CollectionResponse[PackageModel] = {
    val pagedResult = packageService.getAllPackages(PackageType.withName(packageType), courseID, ScopeType.withName(scope), filter, isSortDirectionAsc, skip, count, page, companyID, user.getUserId.toInt)

    CollectionResponse(
      page,
      pagedResult.items.map(p => serialize(p, user)),
      pagedResult.total
    )
  }

  def getVisiblePackages(companyID: Long, courseID: Option[Int], pageID: String, filter: String, playerID: String, user: User, isSortDirectionAsc: Boolean, sortBy: PackageSortBy): Seq[PackageModel] = {

    val sortByM = sortBy match {
      case PackageSortBy.Date => valamispackage.PackageSortBy.Date
      case PackageSortBy.Name => valamispackage.PackageSortBy.Name
      case _                  => valamispackage.PackageSortBy.Name
    }
    packageService.getVisiblePackages(companyID, courseID, pageID, filter, playerID, user, isSortDirectionAsc, sortByM).
      map(p => serialize(p, user))
  }

  def getVisiblePackagesByPage(companyID: Long, courseID: Option[Int], pageID: String, filter: String, playerID: String, user: User, isSortDirectionAsc: Boolean, sortBy: PackageSortBy, page: Int, count: Int): Seq[PackageModel] = {

    val sortByM = sortBy match {
      case PackageSortBy.Date => valamispackage.PackageSortBy.Date
      case PackageSortBy.Name => valamispackage.PackageSortBy.Name
      case _                  => valamispackage.PackageSortBy.Name
    }
    packageService.getVisiblePackagesByPage(companyID, courseID, pageID, filter, playerID, user, isSortDirectionAsc, sortByM, page, count).
      map(p => serialize(p, user))
  }

  override def getVisiblePackagesAmount(companyID: Long, courseID: Option[Int], pageID: String, filter: String, playerID: String, user: User): Int = {
    packageService.getVisiblePackagesAmount(companyID, courseID, pageID, filter, playerID, user)
  }

  def getByScopeType(courseID: Int, scope: String, pageID: Option[String], playerID: Option[String], companyID: Long, courseIds: List[Int], user: User): Seq[PackageModel] = {
    packageService.getByScopeType(courseID, ScopeType.withName(scope), pageID, playerID, companyID, courseIds, user.getUserId.toInt).
      map(p => serialize(p, user))
  }

  def uploadPackages(packages: Seq[PackageUploadModel], scope: String, courseId: Int, pageID: Option[String], playerID: Option[String]) {

    val uploadedPackages = packages.map(p => valamispackage.PackageUploadModel(
      p.id, p.title, p.description, p.packageType, p.logo
    ))
    packageService.uploadPackages(uploadedPackages, ScopeType.withName(scope), courseId, pageID, playerID)
  }

  def updatePackage(passingLimit: Int, rerunInterval: Int, rerunIntervalType: PeriodType, scope: String, packageId: Int, visibility: Boolean, isDefault: Boolean, courseId: Int, title: String, description: String, packageType: String, pageID: Option[String], playerID: Option[String], user: User): PackageModel = {
    serialize(packageService.updatePackage(passingLimit, rerunInterval, rerunIntervalType, ScopeType.withName(scope), packageId, visibility, isDefault, courseId, title, description, PackageType.withName(packageType), pageID, playerID, user.getUserId.toInt), user)
  }
  def updatePackageLogo(packageId: Int, packageType: String, packageLogo: Option[String]) {
    packageService.updatePackageLogo(packageId, PackageType.withName(packageType), packageLogo)
  }

  def updatePackageScopeVisibility(id: Int, scope: String, courseID: Int, visibility: Boolean, isDefault: Boolean, pageID: Option[String], playerID: Option[String], user: User): PackageModel = {
    serialize(packageService.updatePackageScopeVisibility(id, ScopeType.withName(scope), courseID, visibility, isDefault, pageID, playerID, user.getUserId.toInt), user)
  }

  def addPackageToPlayer(playerID: String, packageID: Int) = {
    packageService.addPackageToPlayer(playerID, packageID)
  }

  def updatePlayerScope(scope: String, playerID: String) {
    packageService.updatePlayerScope(ScopeType.withName(scope), playerID)
  }

  def removePackage(packageId: Int, packageType: String): String = {

    packageService.removePackage(packageId, PackageType.withName(packageType))
    "ok"
  }

  def removePackages(packageIds: Seq[Int]): String = {
    packageService.removePackages(packageIds)
    "ok"
  }
}
