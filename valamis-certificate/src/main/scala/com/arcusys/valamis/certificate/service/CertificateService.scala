package com.arcusys.valamis.certificate.service

import com.arcusys.learn.liferay.LiferayClasses.LUser
import com.arcusys.valamis.certificate.model.Certificate
import com.arcusys.valamis.certificate.model.CertificateSortBy.CertificateSortBy
import com.arcusys.valamis.certificate.model.CertificateStatus.CertificateStatus
import com.arcusys.valamis.certificate.model.badge.BadgeResponse
import com.arcusys.valamis.certificate.model.goal._
import com.arcusys.valamis.lrs.api.StatementApi
import com.arcusys.valamis.lrs.tincan._
import com.arcusys.valamis.model.PeriodTypes.PeriodType
import com.arcusys.valamis.model.RangeResult
import org.joda.time.DateTime

trait CertificateService {
  def getAll(companyID: Int,
             scope: Option[Long],
             skip: Int,
             take: Int,
             filter: String,
             sortBy: CertificateSortBy,
             isSortDirectionAsc: Boolean): Iterable[Certificate]

  def allCount(companyID: Int, filter: String, scope: Option[Long]): Int

  def create(companyId: Int, title: String, description: String): Certificate

  def getById(certificateId: Int): Certificate

  def getByIds(ids: Set[Long]): Seq[Certificate]

  def getByCompany(companyID: Int): Seq[Certificate]

  def getBy(companyId: Long, title: Option[String] = None): Seq[Certificate]

  def update(id: Int,
    title: String,
    description: String,
    validPeriodType: String,
    validPeriodValue: Option[Int],
    isOpenBadgesIntegration: Boolean,
    shortDescription: String = "",
    companyId: Int,
    scope: Option[Long]): Certificate

  def getCourseGoalsStatus(certificateId: Int, userId: Int): Seq[GoalStatus[CourseGoal]]
  def getActivityGoalsStatus(certificateId: Int, userId: Int): Seq[GoalStatus[ActivityGoal]]
  def getStatementGoalsStatus(statementApi: StatementApi, certificateId: Int, userId: Int): Seq[GoalStatus[StatementGoal]]
  def getPackageGoalsStatus(statementApi: StatementApi, certificateId: Int, userId: Int): Seq[GoalStatus[PackageGoal]]

  def getActivityGoalsDeadline(certificateId: Int, userId: Int): Seq[GoalDeadline[ActivityGoal]]
  def getCourseGoalsDeadline(certificateId: Int, userId: Int): Seq[GoalDeadline[CourseGoal]]
  def getStatementGoalsDeadline(certificateId: Int, userId: Int): Seq[GoalDeadline[StatementGoal]]
  def getPackageGoalsDeadline(certificateId: Int, userId: Int): Seq[GoalDeadline[PackageGoal]]

  def getCourseGoalsCount(certificateId: Int): Int
  def getStatementGoalsCount(certificateId: Int): Int
  def getActivityGoalsCount(certificateId: Int): Int
  def getPackageGoalsCount(certificateId: Int): Int

  def getCertificatesByUserWithOpenBadges(
    statementApi: StatementApi,
    companyID: Int,
    skip: Int,
    take: Int,
    filter: String,
    sortAZ: Boolean,
    userId: Int,
    isOnlyPublished: Boolean): Seq[Certificate]

  def getCertificatesByUserWithOpenBadges(
    statementApi: StatementApi,
    companyID: Int,
    userId: Int,
    isOnlyPublished: Boolean): Seq[Certificate]

  def getCertificatesCountByUserWithOpenBadges(
    statementApi: StatementApi,
    companyID: Int,
    filter: String,
    userId: Int,
    isOnlyPublished: Boolean): Int

  def getPackageGoals(certificateId: Int): Seq[PackageGoal]
  def addPackageGoal(certificateId: Long, packageId: Long): Option[PackageGoal]
  def deletePackageGoal(certificateId: Long, packageId: Long): Unit
  def changePackageGoal(certificateId: Long, packageId: Long, periodValue: Int, periodType: PeriodType): PackageGoal

  def getCourseGoals(certificateId: Int): Seq[CourseGoal]

  def getStatementGoals(certificateId: Int): Iterable[StatementGoal]

  def getActivityGoals(certificateId: Int): Iterable[ActivityGoal]

  def getJoinedUsers(certificateId: Int,
    filterName: String,
    orgId: Int,
    sortBy: CertificateSortBy,
    sortAscDirection: Boolean,
    skip: Int,
    take: Int): Iterable[(String, LUser)]

  def getJoinedUsersCount(certificateId: Int, filterName: String, orgId: Int): Int

  def getFreeStudents(certificateId: Int,
    filterName: String,
    orgId: Int,
    sortBy: CertificateSortBy,
    sortAscDirection: Boolean,
    skip: Int,
    take: Int): Iterable[LUser]

  def getFreeStudentsCount(certificateId: Int, orgId: Int, filter: String): Int

  def addCourseGoal(certificateId: Int, courseId: Int)

  def addUser(certificateId: Int, userId: Int)

  def addActivityGoal(certificateId: Int, activityName: String, count: Int)

  def addStatementGoal(certificateId: Int, verb: String, obj: String)

  def deleteCourseGoal(certificateId: Int, courseId: Int)

  def deleteUser(certificateId: Int, userId: Int)

  def deleteActivityGoal(certificateId: Int, activityName: String)

  def deleteStatementGoal(certificateId: Int, verb: String, obj: String)

  def changeLogo(id: Int, logo: String = "")

  def changeCourseGoalPeriod(certificateId: Int, courseId: Int, v: Int, pT: PeriodType)

  def changeActivityGoalPeriod(certificateId: Int, activityName: String, count: Int, v: Int, pT: PeriodType)

  def changeStatementGoalPeriod(certificateId: Int, verb: String, obj: String, value: Int, period: PeriodType)

  def delete(id: Int)

  def getForUser(
    companyId: Int,
    skip: Int,
    take: Int,
    filter: String,
    sortAZ: Boolean,
    userId: Int,
    isOnlyPublished: Boolean): Seq[Certificate]

  def getForUserWithStatus(
    companyId: Int,
    skip: Int,
    take: Int,
    filter: String,
    sortAZ: Boolean,
    userId: Int,
    isOnlyPublished: Boolean): Seq[Certificate]

  def getForUser(userId: Int): Seq[Certificate]

  def getAvailableForUser(
    companyId: Int,
    skip: Int,
    take: Int,
    filter: String,
    sortAZ: Boolean,
    userId: Int,
    isOnlyPublished: Boolean,
    scope: Option[Long]): Seq[Certificate]

  def forUserCount(companyId: Int, filter: String, userId: Int, isOnlyPublished: Boolean): Int

  def availableForUserCount(
    companyId: Int,
    userId: Int,
    filter: String,
    isOnlyPublished: Boolean,
    scope: Option[Long]): Int

  def getIssuerBadge(certificateId: Int, liferayUserId: Int, rootUrl: String): BadgeResponse

  def getUsers(c: Certificate): Seq[(DateTime, LUser)]
  def getUsersCount(c: Certificate): Int

  def clone(certificateId: Int): Certificate

  def publish(certificateId: Int): Certificate

  def unpublish(certificateId: Int): Certificate

  def moveCourseGoals(certificateId: Int, courseIds: Seq[Int])

//  def getAvailableStatements(
//    statementApi: StatementApi,
//    page: Int,
//    skip: Int,
//    take: Int,
//    filter: String,
//    isSortDirectionAsc: Boolean): RangeResult[(Verb, (String, LanguageMap))]

  def getUserCertificates(statementApi: StatementApi, id: Int, lUser: LUser, withOpenBadges: Boolean): Seq[Certificate]
}
