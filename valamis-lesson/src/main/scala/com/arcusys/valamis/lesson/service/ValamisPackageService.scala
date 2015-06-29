package com.arcusys.valamis.lesson.service

import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.model.Activity
import com.arcusys.valamis.lesson.tincan.model.ManifestActivity
import com.arcusys.valamis.lesson.scorm.model.manifest.Manifest
import com.arcusys.valamis.model.{ ScopeType, PeriodTypes, RangeResult }
import PeriodTypes._
import com.arcusys.valamis.lesson.model._
import LessonType.LessonType
import ScopeType.ScopeType
import com.arcusys.valamis.lrs.api.StatementApi
import com.arcusys.valamis.lrs.tincan.Statement
import org.joda.time.DateTime

trait ValamisPackageService {

  def getPackage(packageId: Long): BaseManifest

  def getPackageType(packageId: Long): LessonType

  def getManifestActivities(packageId: Long): Seq[ManifestActivity]

  def getRootManifestActivities(packageId: Long): Seq[ManifestActivity]

  def getPackagesCount(courseId: Int): Int

  def getPackagesByCourse(courseId: Int): Seq[BaseManifest]

  def getTincanPackagesByCourse(courseId: Int, onlyVisible: Boolean = false): Seq[BaseManifest]

  def getStatements(packageId: Long, valamisUserId: Int, statementApi: StatementApi): Seq[Statement]

  def getLastPaskages(valamisUserId: Long, statementApi: StatementApi, Count:Int, companyID:Long): Seq[RecentLesson]

  def getPersonalForPlayer(playerId: String, companyId: Long, groupId: Long, userId: Int): Seq[BaseManifest]

  def getAllPackages(packageType: Option[LessonType], courseId: Option[Int], scope: ScopeType, filter: String,
    tagId: Option[Long], isSortDirectionAsc: Boolean, skip: Int, count: Int, page: Int,
    companyId: Long, userId: Long): RangeResult[BaseManifest]

  def getVisibleForPlayer(statementApi: StatementApi, companyId: Long, courseId: Int, pageId: String, filter: String, tagId: Option[Long],
    playerId: String, user: LUser, isSortDirectionAsc: Boolean, sortBy: PackageSortBy.PackageSortBy,
    skip: Int, count: Int): RangeResult[ValamisPackage]

  def getByScopeType(courseId: Int, scope: ScopeType, pageId: Option[String], playerId: Option[String],
    companyId: Long, courseIds: List[Int], userId: Int): Seq[BaseManifest]

  def updatePackage(tags: Seq[Long], passingLimit: Int, rerunInterval: Int, rerunIntervalType: PeriodType,
    beginDate: Option[DateTime], endDate: Option[DateTime], scope: ScopeType, packageId: Long,
    visibility: Boolean, isDefault: Boolean, courseId: Int, title: String, description: String,
    packageType: LessonType, pageId: Option[String], playerId: Option[String], userId: Int): BaseManifest

  def updatePackageLogo(packageId: Long, packageType: LessonType, packageLogo: Option[String])

  def uploadPackages(packages: Seq[PackageUploadModel], scope: ScopeType, courseId: Int, pageId: Option[String], playerId: Option[String])

  def updatePackageScopeVisibility(id: Long, scope: ScopeType, courseId: Int, visibility: Boolean, isDefault: Boolean,
    pageId: Option[String], playerId: Option[String], userId: Int): Unit

  def addPackageToPlayer(playerId: String, packageId: Long)

  def updatePlayerScope(scope: ScopeType, playerId: String)

  def removePackage(packageId: Long, packageType: LessonType)

  def removePackages(packageIds: Seq[Long])

  def getRootActivityIds(packageId: Long): Seq[String]

  def getScormManifest(packageId: Int): Manifest

  def getTincanLaunchWithLimitTest(packageId: Int, user: LUser, statementApi: StatementApi): String
}
