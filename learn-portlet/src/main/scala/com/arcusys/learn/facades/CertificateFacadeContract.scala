package com.arcusys.learn.facades

import java.io.InputStream

import com.arcusys.learn.bl.models.BadgeResponse
import com.arcusys.learn.bl.models.certificates.CertificateSortBy.CertificateSortBy
import com.arcusys.learn.models.response.CollectionResponse
import com.arcusys.learn.scorm.manifest.model.PeriodType
import PeriodType._
import com.arcusys.learn.models._
import com.arcusys.learn.models.response.certificates._
import com.arcusys.learn.models.response.users.UserResponseWithCertificateStatus
import com.arcusys.learn.models.response.users.UserShortResponse

trait CertificateFacadeContract {
  def getAll(companyID: Int, skip: Int, take: Int, filter: String,
    sortBy: CertificateSortBy, isSortDirectionAsc: Boolean, isShortResult: Boolean): Seq[Any]

  def getGoalsStatuses(certificateId: Int, userId: Int): GoalsStatusResponse

  def getGoalsDeadlines(certificateId: Int, userId: Int): GoalsDeadlineResponse

  def getCertificatesByUserWithOpenBadges(companyID: Int,
    skip: Int,
    take: Int,
    filter: String,
    sortAZ: Boolean,
    userId: Int,
    isOnlyPublished: Boolean): Seq[CertificateResponseContract]

  def getCertificatesByUserWithOpenBadges(companyID: Int,
    userId: Int,
    isOnlyPublished: Boolean): Seq[CertificateResponseContract]

  def getCertificatesCountByUserWithOpenBadges(companyID: Int,
    filter: String,
    userId: Int,
    isOnlyPublished: Boolean): Int
  def allCount(companyID: Int, filter: String): Int

  def getStatements(certificateId: Int): Iterable[StatementResponse]

  def getActivities(certificateId: Int): Iterable[ActivityResponse]

  def getById(certificateId: Int): CertificateResponseContract

  def getJoinedUsers(certificateId: Int,
    filterName: String,
    orgId: Int,
    sortBy: CertificateSortBy,
    sortAscDirection: Boolean,
    skip: Int,
    take: Int): Iterable[(String, UserResponseWithCertificateStatus)]

  def getJoinedUsersCount(certificateId: Int,
    filterName: String,
    orgId: Int): Int

  def getFreeStudents(certificateId: Int,
    filterName: String,
    orgId: Int,
    sortBy: CertificateSortBy,
    sortAscDirection: Boolean,
    skip: Int,
    take: Int): Iterable[UserShortResponse]

  def getFreeStudentsCount(certificateId: Int,
    orgId: Int,
    filter: String): Int

  def create(companyId: Int,
    title: String,
    description: String): Any

  def addCourse(certificateId: Int, courseId: Int)

  def addUser(certificateId: Int, userId: Int)

  def addActivity(certificateId: Int, activityName: String, count: Int)

  def addStatementObj(certificateId: Int, verb: String, obj: String)

  def deleteCourse(certificateId: Int, courseId: Int)

  def deleteUser(certificateId: Int, userId: Int)

  def deleteActivity(certificateId: Int, activityName: String)

  def deleteStatementObj(certificateId: Int, verb: String, obj: String)

  def change(id: Int,
    title: String,
    description: String,
    validPeriodType: String,
    validPeriodValue: Option[Int],
    isOpenBadgesIntegration: Boolean,
    shortDescription: String = "",
    companyId: Int,
    scope: Option[Long]): CertificateResponseContract

  def changeLogo(id: Int, logo: String = "")

  def changeCourse(certificateId: Int, courseId: Int, v: Int, pT: PeriodType)

  def changeActivity(certificateId: Int, activityName: String, count: Int, v: Int, pT: PeriodType)

  def changeStatementObjPeriod(certificateId: Int, verb: String, obj: String, value: Int, period: PeriodType)

  def delete(id: Int)

  def getForUser(companyID: Int,
    skip: Int,
    take: Int,
    filter: String,
    sortAZ: Boolean,
    userId: Int,
    isShortResult: Boolean,
    isOnlyPublished: Boolean): Seq[CertificateResponseContract]

  def getForUserWithStatus(companyID: Int,
    skip: Int,
    take: Int,
    filter: String,
    sortAZ: Boolean,
    userId: Int,
    isShortResult: Boolean,
    isOnlyPublished: Boolean): Seq[CertificateResponseContract]

  def getForUser(companyID: Int,
    userId: Int,
    isShortResult: Boolean): Seq[CertificateResponseContract]

  def getAvailableForUser(companyID: Int,
    skip: Int,
    take: Int,
    filter: String,
    sortAZ: Boolean,
    userId: Int,
    isShortResult: Boolean,
    isOnlyPublished: Boolean,
    scope: Option[Long]): Seq[CertificateResponseContract]

  def forUserCount(
    companyID: Int,
    filter: String,
    userId: Int,
    isOnlyPublished: Boolean): Int

  def availableForUserCount(companyID: Int,
    userId: Int,
    filter: String,
    isOnlyPublished: Boolean,
    scope: Option[Long]): Int

  def getIssuerBadge(certificateId: Int,
    liferayUserId: Int,
    rootUrl: String): BadgeResponse

  def clone(certificateId: Int): CertificateResponseContract

  def publish(certificateId: Int): CertificateResponseContract

  def unpublish(certificateId: Int): CertificateResponseContract

  def moveCourse(certificateId: Int, courseIDs: Seq[Int])

  def exportCertificate(companyId: Int, certificateId: Int): InputStream

  def exportCertificates(companyId: Int): InputStream

  def importCertificates(filename: String, companyID: Int): Unit

  def getAvailableStatements(page: Int, skip: Int, take: Int, filter: String,
    isSortDirectionAsc: Boolean): CollectionResponse[AvailableStatementResponse]
}
