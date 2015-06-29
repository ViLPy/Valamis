package com.arcusys.learn.facades

import java.io.{ File, InputStream }

import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.model.Activity
import com.arcusys.valamis.gradebook.model.PackageGrade
import com.arcusys.valamis.lesson.tincan.model.ManifestActivity
import com.arcusys.valamis.lrs.api.StatementApi
import com.arcusys.valamis.model.PeriodTypes
import PeriodTypes.PeriodType
import com.arcusys.learn.models.response.CollectionResponse
import com.arcusys.learn.models.valamispackage.{ PackageResponse, PackageSortBy, PackageUploadModel, PlayerPackageResponse }
import com.arcusys.valamis.lesson.model.{ BaseManifest, LessonType }
import LessonType.LessonType
import org.joda.time.DateTime

trait PackageFacadeContract {

  def getPackageGrade(valamisUserId: Int, packageId: Long): Option[PackageGrade]

  private[facades] def getPackageType(packageId: Int): LessonType

  private[facades] def updatePackageGrade(valamisUserId: Int, packageId: Int, grade: String, comment: String)

  def getManifestActivities(packageId: Long): Seq[ManifestActivity]

  def getPackagesCount(courseId: Int): Int

  def getCompletedPackagesCount(courseId: Int, userId: Int): Int

  def getPackage(packageId: Long): BaseManifest

  def getPackagesByCourse(courseId: Int): Seq[BaseManifest]

  def getTincanPackagesByCourse(courseId: Int, onlyVisible: Boolean = false): Seq[BaseManifest]

  def exportAllPackages(courseID: Int): InputStream

  def exportPackages(packagesIds: Seq[Long]): InputStream

  def exportPackagesForMobile(packagesIds: Seq[Long]): InputStream

  def importPackages(file: File, courseID: Int, userId: Long): Unit

  def getForPlayerConfig(playerID: String, companyID: Long, groupId: Long, user: LUser): Seq[PackageResponse]

  def getAllPackages(packageType: Option[String], courseID: Option[Int], scope: String, filter: String, tagId: Option[Long],
    isSortDirectionAsc: Boolean, skip: Int, count: Int, page: Int,
    companyID: Long, user: LUser): CollectionResponse[PackageResponse]

  def getForPlayer(statementApi: StatementApi, companyID: Long, courseID: Int, pageID: String, filter: String, tagId: Option[Long],
    playerID: String, user: LUser, isSortDirectionAsc: Boolean, sortBy: PackageSortBy.PackageSortBy,
    page: Int, count: Int): CollectionResponse[PlayerPackageResponse]

  def getByScopeType(courseID: Int, scope: String, pageID: Option[String], playerID: Option[String],
    companyID: Long, courseIds: List[Int], user: LUser): Seq[PackageResponse]

  def updatePackage(packageId: Long, tags: Seq[String], passingLimit: Int, rerunInterval: Int, rerunIntervalType: PeriodType,
    beginDate: Option[DateTime], endDate: Option[DateTime], scope: String, visibility: Boolean, isDefault: Boolean,
    companyId: Long, courseId: Int, title: String, description: String, packageType: String, pageID: Option[String],
    playerID: Option[String], user: LUser): PackageResponse

  def updatePackageLogo(packageId: Long, packageType: String, packageLogo: Option[String])

  def uploadPackages(packages: Seq[PackageUploadModel], scope: String, courseId: Int, pageID: Option[String], playerID: Option[String])

  def updatePackageScopeVisibility(id: Long, scope: String, courseID: Int, visibility: Boolean, isDefault: Boolean, pageID: Option[String], playerID: Option[String], user: LUser): Unit

  def addPackageToPlayer(playerID: String, packageID: Long)

  def updatePlayerScope(scope: String, playerID: String)

  def removePackage(packageId: Long, packageType: String): String

  def removePackages(packageIds: Seq[Long]): String
}
