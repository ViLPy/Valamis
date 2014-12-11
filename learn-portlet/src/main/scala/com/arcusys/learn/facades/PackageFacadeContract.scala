package com.arcusys.learn.facades

import java.io.InputStream
import java.util.Date

import com.arcusys.learn.models.response.CollectionResponse
import com.arcusys.learn.models.valamispackage.{ PackageSortBy, PackageUploadModel, PackageModel }
import com.arcusys.learn.scorm.manifest.model.PackageType.PackageType
import com.arcusys.learn.scorm.manifest.model.PeriodType.PeriodType
import com.arcusys.learn.scorm.manifest.model.{ BaseManifest, PackageGrade }
import com.arcusys.learn.tincan.manifest.model.ManifestActivity
import com.arcusys.learn.tincan.model.Statement
import com.liferay.portal.model.User

/**
 * Created by Iliya Tryapitsin on 16.04.2014.
 */
abstract trait PackageFacadeContract {

  def getPackageGrade(valamisUserId: Int, packageId: Int): Option[PackageGrade]

  private[facades] def getPackageType(packageId: Int): PackageType

  private[facades] def updatePackageGrade(valamisUserId: Int, packageId: Int, grade: String, comment: String)

  def getManifestActivities(packageId: Int): Seq[ManifestActivity]

  def getPackagesCount(courseId: Int): Int

  def getCompletedPackagesCount(courseId: Int, userId: Int): Int

  def getPackage(packageId: Int): BaseManifest

  def getPackagesByCourse(courseId: Int): Seq[BaseManifest]

  def getTincanPackagesByCourse(courseId: Int): Seq[BaseManifest]

  def getStatementGrades(packageId: Int, valamisUserId: Int): Seq[Statement]

  def getStatements(packageId: Int, valamisUserId: Int): Seq[Statement]

  def getStatements(packageObj: BaseManifest, valamisUserId: Int, dateSince: Option[Date] = None): Seq[Statement]

  def exportAllPackages(courseID: Int): InputStream

  def exportPackages(packagesIds: Seq[Int]): InputStream

  def exportPackagesForMobile(packagesIds: Seq[Int]): InputStream

  def importPackages(raw: String, courseID: Int): Unit

  def getForPlayer(playerID: String, companyID: Long, groupId: Long, user: User): Seq[PackageModel]

  def getAllPackages(packageType: String, courseID: Option[Int], scope: String, filter: String, isSortDirectionAsc: Boolean, skip: Int, count: Int, page: Int, companyID: Long, user: User): CollectionResponse[PackageModel]

  def getVisiblePackages(companyID: Long, courseID: Option[Int], pageID: String, filter: String, playerID: String, user: User, isSortDirectionAsc: Boolean, sortBy: PackageSortBy.PackageSortBy): Seq[PackageModel]

  def getVisiblePackagesByPage(companyID: Long, courseID: Option[Int], pageID: String, filter: String, playerID: String, user: User, isSortDirectionAsc: Boolean, sortBy: PackageSortBy.PackageSortBy, page: Int, count: Int): Seq[PackageModel]

  def getVisiblePackagesAmount(companyID: Long, courseID: Option[Int], pageID: String, filter: String, playerID: String, user: User): Int

  def getByScopeType(courseID: Int, scope: String, pageID: Option[String], playerID: Option[String], companyID: Long, courseIds: List[Int], user: User): Seq[PackageModel]

  def updatePackage(passingLimit: Int, rerunInterval: Int, rerunIntervalType: PeriodType, scope: String, packageId: Int, visibility: Boolean, isDefault: Boolean, courseId: Int, title: String, description: String, packageType: String, pageID: Option[String], playerID: Option[String], user: User): PackageModel
  def updatePackageLogo(packageId: Int, packageType: String, packageLogo: Option[String])

  def uploadPackages(packages: Seq[PackageUploadModel], scope: String, courseId: Int, pageID: Option[String], playerID: Option[String])

  def updatePackageScopeVisibility(id: Int, scope: String, courseID: Int, visibility: Boolean, isDefault: Boolean, pageID: Option[String], playerID: Option[String], user: User): PackageModel

  def addPackageToPlayer(playerID: String, packageID: Int)

  def updatePlayerScope(scope: String, playerID: String)

  def removePackage(packageId: Int, packageType: String): String

  def removePackages(packageIds: Seq[Int]): String
}
