package com.arcusys.learn.bl.services

import java.io.InputStream
import java.util.Date

import com.arcusys.learn.bl.models.RangeResult
import com.arcusys.learn.bl.models.valamispackage.{ PackageUploadModel, PackageSortBy, ValamisPackage }
import com.arcusys.learn.scorm.manifest.model.PackageType.PackageType
import com.arcusys.learn.scorm.manifest.model.PeriodType._
import com.arcusys.learn.scorm.manifest.model.ScopeType.ScopeType
import com.arcusys.learn.scorm.manifest.model.{ BaseManifest, PackageGrade }
import com.arcusys.learn.tincan.manifest.model.ManifestActivity
import com.arcusys.learn.tincan.model.Statement
import com.liferay.portal.model.User

abstract trait ValamisPackageServiceContract {

  def updatePackageGrade(valamisUserId: Int, packageId: Int, grade: String, comment: String)

  def getPackage(packageId: Int): BaseManifest

  def getPackageType(packageId: Int): PackageType

  def getPackageGrade(valamisUserId: Int, packageId: Int): Option[PackageGrade]

  def getManifestActivities(packageId: Int): Seq[ManifestActivity]

  def getPackagesCount(courseId: Int): Int

  def getCompletedPackagesCount(courseId: Int, userId: Int): Int

  def getPackagesByCourse(courseId: Int): Seq[BaseManifest]

  def getTincanPackagesByCourse(courseId: Int): Seq[BaseManifest]

  def getStatementGrades(packageId: Int, valamisUserId: Int): Seq[Statement]

  def getStatements(packageId: Int, valamisUserId: Int): Seq[Statement]

  def getStatements(packageObj: BaseManifest, valamisUserId: Int, dateSince: Option[Date] = None): Seq[Statement]

  def exportAllPackages(courseID: Int): InputStream

  def exportPackages(packagesIds: Seq[Int]): InputStream

  def exportPackagesForMobile(packagesIds: Seq[Int]): InputStream

  def importPackages(raw: String, courseID: Int): Unit

  def getForPlayer(playerID: String, companyID: Long, groupId: Long, userId: Int): Seq[ValamisPackage]

  def getAllPackages(packageType: PackageType, courseID: Option[Int], scope: ScopeType, filter: String, isSortDirectionAsc: Boolean, skip: Int, count: Int, page: Int, companyID: Long, userId: Int): RangeResult[ValamisPackage]

  def getVisiblePackages(companyID: Long, courseID: Option[Int], pageID: String, filter: String, playerID: String, user: User, isSortDirectionAsc: Boolean, sortBy: PackageSortBy.PackageSortBy): Seq[ValamisPackage]

  def getVisiblePackagesByPage(companyID: Long, courseID: Option[Int], pageID: String, filter: String, playerID: String, user: User, isSortDirectionAsc: Boolean, sortBy: PackageSortBy.PackageSortBy, page: Int, count: Int): Seq[ValamisPackage]

  def getVisiblePackagesAmount(companyID: Long, courseID: Option[Int], pageID: String, filter: String, playerID: String, user: User): Int

  def getByScopeType(courseID: Int, scope: ScopeType, pageID: Option[String], playerID: Option[String], companyID: Long, courseIds: List[Int], userId: Int): Seq[ValamisPackage]

  def updatePackage(passingLimit: Int, rerunInterval: Int, rerunIntervalType: PeriodType, scope: ScopeType, packageId: Int, visibility: Boolean, isDefault: Boolean, courseId: Int, title: String, description: String, packageType: PackageType, pageID: Option[String], playerID: Option[String], userId: Int): ValamisPackage
  def updatePackageLogo(packageId: Int, packageType: PackageType, packageLogo: Option[String])

  def uploadPackages(packages: Seq[PackageUploadModel], scope: ScopeType, courseId: Int, pageID: Option[String], playerID: Option[String])

  def updatePackageScopeVisibility(id: Int, scope: ScopeType, courseID: Int, visibility: Boolean, isDefault: Boolean, pageID: Option[String], playerID: Option[String], userId: Int): ValamisPackage

  def addPackageToPlayer(playerID: String, packageID: Int)

  def updatePlayerScope(scope: ScopeType, playerID: String)

  def removePackage(packageId: Int, packageType: PackageType)

  def removePackages(packageIds: Seq[Int])
}
