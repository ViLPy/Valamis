package com.arcusys.learn.bl.services

import java.io.InputStream

import com.arcusys.learn.bl.models.{ BadgeResponse, RangeResult }
import com.arcusys.learn.bl.models.certificates.CertificateSortBy.CertificateSortBy
import com.arcusys.learn.liferay.LiferayClasses.LUser
import com.arcusys.learn.scorm.manifest.model.PeriodType.PeriodType
import com.arcusys.learn.scorm.tracking.model.certificating.models.{ CertificateCourseSettings, CertificateActivitySettings, CertificateStatementObjSettings }
import com.arcusys.learn.scorm.tracking.model.certificating.CertificateStatus._
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate
import com.arcusys.learn.tincan.model.Statement
import com.liferay.portal.model.User
import org.joda.time.DateTime

trait CertificateServiceContract {
  def getAll(companyID: Int, skip: Int, take: Int, filter: String, sortBy: CertificateSortBy, isSortDirectionAsc: Boolean): Iterable[Certificate]

  def allCount(companyID: Int, filter: String): Int

  def create(companyId: Int, title: String, description: String): Certificate

  def getById(certificateId: Int): Certificate

  def getByCompany(companyID: Int): Seq[Certificate]

  def change(id: Int,
    title: String,
    description: String,
    validPeriodType: String,
    validPeriodValue: Option[Int],
    isOpenBadgesIntegration: Boolean,
    shortDescription: String = "",
    companyId: Int,
    scope: Option[Long]): Certificate

  def getCoursesStatuses(certificateId: Int, userId: Int): Iterable[(Int, CertificateStatus, DateTime)]
  def getActivitiesStatuses(certificateId: Int, userId: Int): Iterable[(String, CertificateStatus, Option[DateTime])]
  def getStatementsStatuses(certificateId: Int, userId: Int): Iterable[(String, String, CertificateStatus, DateTime)]

  def getActivitiesDeadlines(certificateId: Int, userId: Int): Seq[(String, Option[DateTime])]
  def getCoursesDeadlines(certificateId: Int, userId: Int): Seq[(Int, Option[DateTime])]
  def getStatementsDeadlines(certificateId: Int, userId: Int): Seq[(String, String, Option[DateTime])]

  def getCourses(certificateId: Int): Seq[CertificateCourseSettings]
  def getCoursesCount(certificateId: Int): Int
  def getStatementsCount(certificateId: Int): Int
  def getActivitiesCount(certificateId: Int): Int

  def getCertificatesByUserWithOpenBadges(companyID: Int,
    skip: Int,
    take: Int,
    filter: String,
    sortAZ: Boolean,
    userId: Int,
    isOnlyPublished: Boolean): Seq[Certificate]

  def getCertificatesByUserWithOpenBadges(companyID: Int, userId: Int, isOnlyPublished: Boolean): Seq[Certificate]

  def getCertificatesCountByUserWithOpenBadges(companyID: Int, filter: String, userId: Int, isOnlyPublished: Boolean): Int

  def getStatements(certificateId: Int): Iterable[CertificateStatementObjSettings]

  def getActivities(certificateId: Int): Iterable[CertificateActivitySettings]

  def getJoinedUsers(certificateId: Int,
    filterName: String,
    orgId: Int,
    sortBy: CertificateSortBy,
    sortAscDirection: Boolean,
    skip: Int,
    take: Int): Iterable[(String, User)]

  def getJoinedUsersCount(certificateId: Int, filterName: String, orgId: Int): Int

  def getFreeStudents(certificateId: Int,
    filterName: String,
    orgId: Int,
    sortBy: CertificateSortBy,
    sortAscDirection: Boolean,
    skip: Int,
    take: Int): Iterable[User]

  def getFreeStudentsCount(certificateId: Int, orgId: Int, filter: String): Int

  def addCourse(certificateId: Int, courseId: Int)

  def addUser(certificateId: Int, userId: Int)

  def addActivity(certificateId: Int, activityName: String, count: Int)

  def addStatementObj(certificateId: Int, verb: String, obj: String)

  def deleteCourse(certificateId: Int, courseId: Int)

  def deleteUser(certificateId: Int, userId: Int)

  def deleteActivity(certificateId: Int, activityName: String)

  def deleteStatementObj(certificateId: Int, verb: String, obj: String)

  def changeLogo(id: Int, logo: String = "")

  def changeCourse(certificateId: Int, courseId: Int, v: Int, pT: PeriodType)

  def changeActivity(certificateId: Int, activityName: String, count: Int, v: Int, pT: PeriodType)

  def changeStatementObjPeriod(certificateId: Int, verb: String, obj: String, value: Int, period: PeriodType)

  def delete(id: Int)

  def getForUser(companyID: Int, skip: Int, take: Int, filter: String, sortAZ: Boolean, userId: Int, isOnlyPublished: Boolean): Seq[Certificate]

  def getForUserWithStatus(companyID: Int, skip: Int, take: Int, filter: String, sortAZ: Boolean, userId: Int, isOnlyPublished: Boolean): Seq[Certificate]

  def getForUser(companyID: Int, userId: Int): Seq[Certificate]

  def getAvailableForUser(companyID: Int, skip: Int, take: Int, filter: String, sortAZ: Boolean, userId: Int, isOnlyPublished: Boolean, scope: Option[Long]): Seq[Certificate]

  def forUserCount(companyID: Int, filter: String, userId: Int, isOnlyPublished: Boolean): Int

  def availableForUserCount(companyID: Int, userId: Int, filter: String, isOnlyPublished: Boolean, scope: Option[Long]): Int

  def getIssuerBadge(certificateId: Int, liferayUserId: Int, rootUrl: String): BadgeResponse

  def getUsers(c: Certificate): Seq[(DateTime, LUser)]
  def getUsersCount(c: Certificate): Int

  def clone(certificateId: Int): Certificate

  def publish(certificateId: Int): Certificate

  def unpublish(certificateId: Int): Certificate

  def moveCourse(certificateId: Int, courseIDs: Seq[Int])

  def exportCertificate(companyId: Int, certificateId: Int): InputStream

  def exportCertificates(companyId: Int): InputStream

  def importCertificates(filename: String, companyID: Int): Unit

  def getAvailableStatements(page: Int, skip: Int, take: Int, filter: String, isSortDirectionAsc: Boolean): RangeResult[Statement]
}
