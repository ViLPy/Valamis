package com.arcusys.learn.facades

import java.io.{ File, InputStream }
import com.arcusys.valamis.certificate.model.{CertificateStatus, CertificateSortBy}
import CertificateSortBy.CertificateSortBy
import com.arcusys.valamis.certificate.model.badge.BadgeResponse
import com.arcusys.valamis.lrs.api.StatementApi
import com.arcusys.valamis.model.PeriodTypes
import PeriodTypes._
import com.arcusys.learn.models.response.CollectionResponse
import com.arcusys.learn.models.response.certificates._
import com.arcusys.learn.models.response.users.{ UserResponseWithCertificateStatus, UserShortResponse }

trait CertificateFacadeContract {
  def getAll(companyId: Int, scope: Option[Long], page: Int, pageSize: Int, filter: String,
    sortBy: CertificateSortBy, isSortDirectionAsc: Boolean, isShortResult: Boolean): CollectionResponse[CertificateResponseContract]

  def getGoalsStatuses(statementApi: StatementApi, certificateId: Int, userId: Int): GoalsStatusResponse

  def getGoalsDeadlines(certificateId: Int, userId: Int): GoalsDeadlineResponse

  def getCertificatesByUserWithOpenBadges(statementApi: StatementApi,
                                          companyId: Int,
                                          skip: Int,
                                          take: Int,
                                          filter: String,
                                          sortAZ: Boolean,
                                          userId: Int,
                                          isOnlyPublished: Boolean): Seq[CertificateResponseContract]

  def getCertificatesByUserWithOpenBadges(statementApi: StatementApi,
                                          companyId: Int,
                                          userId: Int,
                                          isOnlyPublished: Boolean): Seq[CertificateResponseContract]

  def getCertificatesCountByUserWithOpenBadges(statementApi: StatementApi,
                                               companyId: Int,
                                               filter: String,
                                               userId: Int,
                                               isOnlyPublished: Boolean): Int

  def getStatements(certificateId: Int): Iterable[StatementGoalResponse]

  def getActivities(certificateId: Int): Iterable[ActivityGoalResponse]

  def getById(certificateId: Int): CertificateResponseContract

  def getByCompanyAndTitleWithSucceedUsers(companyId: Long, title: String): Seq[CertificateSuccessUsersResponse]

  def getJoinedUsers( statementApi: StatementApi,
                      certificateId: Int,
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

  def addPackageGoal(certificateId: Long, packageId: Long)

  def deleteCourse(certificateId: Int, courseId: Int)

  def deleteUser(certificateId: Int, userId: Int)

  def deleteActivity(certificateId: Int, activityName: String)

  def deleteStatementObj(certificateId: Int, verb: String, obj: String)

  def deletePackageGoal(certificateId: Long, packageId: Long): Unit

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

  def changePackagePeriod(certificateId: Long, packageId: Long, value: Int, period: PeriodType)

  def delete(id: Int)

  def getForUser(companyId: Int,
    skip: Int,
    take: Int,
    filter: String,
    sortAZ: Boolean,
    userId: Int,
    isShortResult: Boolean,
    isOnlyPublished: Boolean): Seq[CertificateResponseContract]

  def getForUserWithStatus( statementApi: StatementApi,
                            companyId: Int,
                            skip: Int,
                            take: Int,
                            filter: String,
                            sortAZ: Boolean,
                            userId: Int,
                            isShortResult: Boolean,
                            isOnlyPublished: Boolean): Seq[CertificateResponseContract]

  def getForUser(companyId: Int,
    userId: Int,
    isShortResult: Boolean): Seq[CertificateResponseContract]

  def getAvailableForUser(companyId: Int,
    skip: Int,
    take: Int,
    filter: String,
    sortAZ: Boolean,
    userId: Int,
    isShortResult: Boolean,
    isOnlyPublished: Boolean,
    scope: Option[Long]): Seq[CertificateResponseContract]

  def forUserCount(
    companyId: Int,
    filter: String,
    userId: Int,
    isOnlyPublished: Boolean): Int

  def availableForUserCount(companyId: Int,
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

  def moveCourse(certificateId: Int, courseIds: Seq[Int])

  def exportCertificate(companyId: Int, certificateId: Int): InputStream

  def exportCertificates(companyId: Int): InputStream

  def importCertificates(file: File, companyId: Int): Unit

//  def getAvailableStatements(statementApi: StatementApi, page: Int, skip: Int, take: Int, filter: String,
//    isSortDirectionAsc: Boolean): CollectionResponse[AvailableStatementResponse]

  def getStatesBy(
    userId: Long,
    statuses: Set[CertificateStatus.Value]): Seq[AchievedCertificateStateResponse]
}
