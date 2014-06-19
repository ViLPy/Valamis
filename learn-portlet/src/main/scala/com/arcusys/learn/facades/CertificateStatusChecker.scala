package com.arcusys.learn.facades

import com.arcusys.learn.scorm.certificating._
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.scorm.certificating.models._
import com.arcusys.learn.tincan.lrs.statement.{ StatementLRS }
import com.arcusys.learn.tincan.storage.StatementStorage
import org.joda.time.DateTime
import com.liferay.portlet.social.service.SocialActivityServiceUtil
import com.arcusys.learn.scorm.tracking.model.certificating.{ CertificateStatus, PeriodType }
import scala.collection.JavaConverters._
import com.arcusys.learn.scorm.tracking.model.certificating.CertificateStatus.CertificateStatus
import com.arcusys.learn.tincan.lrs.statement.StatementFilter
import scala.Some
import com.arcusys.learn.scorm.certificating.models.CertificateActivitySettings
import com.arcusys.learn.scorm.certificating.models.CertificateStatementObjSettings
import com.arcusys.learn.tincan.model.Statement
import com.arcusys.learn.scorm.course.CourseStorage
import scala.util.Try

/**
 * Created by Iliya Tryapitsin on 03.06.2014.
 */
trait CertificateStatusChecker extends Injectable {

  private lazy val certificateRepository = inject[CertificateRepositoryContract]
  private lazy val certificateToUserRepository = inject[CertificateUserRepositoryContract]
  private lazy val certificateToCourseRepository = inject[CertificateCourseSettingsRepositoryContract]
  private lazy val certificateToActivityRepository = inject[CertificateActivitySettingsRepositoryContract]
  private lazy val certificateToTincanStatementRepository = inject[CertificateStatementObjSettingsRepositoryContract]
  private lazy val courseStorage = inject[CourseStorage]

  def getStatus(certificateId: Int, userId: Int): CertificateStatus = {
    val certificate = certificateRepository.get(("id" -> certificateId))
    val courses = certificateToCourseRepository.select(("certificateId" -> certificateId))
    val activities = certificateToActivityRepository.select(("certificateId" -> certificateId))
    val statements = certificateToTincanStatementRepository.select(("certificateId" -> certificateId))

    val startDate = certificateToUserRepository.getLeft(certificate).filter(x => x._2.getUserId == userId).head._1
    val endDate = PeriodType.getEndDate(certificate.validPeriodType, Some(certificate.validPeriod), startDate)

    var isStatementsPassed, isActivitiesPassed, isCoursesPassed = true

    val deadline = findDeadline(courses, activities, statements, startDate)

    statements.foreach(x => isStatementsPassed = isStatementsPassed && checkStatementsRequirements(x, PeriodType.getEndDate(x.period, x.value, startDate)))
    activities.foreach(x => isActivitiesPassed = isActivitiesPassed && checkActivitiesRequirements(x, userId, PeriodType.getEndDate(x.periodType, x.value, startDate)))
    courses.foreach(x => isCoursesPassed = isCoursesPassed && checkCoursesRequirements(x, userId, PeriodType.getEndDate(x.periodType, x.value, startDate)))

    if (isFailed(isStatementsPassed, isActivitiesPassed, isCoursesPassed, deadline))
      return CertificateStatus.Failed

    if (isOverdue(isStatementsPassed, isActivitiesPassed, isCoursesPassed, endDate))
      return CertificateStatus.Overdue

    if (isSuccess(isStatementsPassed, isActivitiesPassed, isCoursesPassed, deadline))
      return CertificateStatus.Success
    else
      return CertificateStatus.InProgress
  }

  def getCoursesStatuses(certificateId: Int, userId: Int): Iterable[(Int, CertificateStatus)] = {
    val certificate = certificateRepository.get(("id" -> certificateId))
    val startDate = certificateToUserRepository.getLeft(certificate).filter(x => x._2.getUserId == userId).head._1
    val courses = certificateToCourseRepository.select(("certificateId" -> certificateId))

    courses
      .map(x => {
        val endDate = PeriodType.getEndDate(x.periodType, x.value, startDate)
        val requirements = checkCoursesRequirements(x, userId, endDate)
        val latestCourseDate = getMaxCourseDate(x, userId)

        val status = if (requirements)
          CertificateStatus.Success

        else if (endDate.isAfter(latestCourseDate))
          CertificateStatus.InProgress
        else
          CertificateStatus.Failed

        (x.courseId, status)
      })
  }

  def getActivitiesStatuses(certificateId: Int, userId: Int): Iterable[(String, CertificateStatus)] = {
    val certificate = certificateRepository.get(("id" -> certificateId))
    val startDate = certificateToUserRepository.getLeft(certificate).filter(x => x._2.getUserId == userId).head._1
    val activities = certificateToActivityRepository.select(("certificateId" -> certificateId))

    activities
      .map(x => {
        val deadline = PeriodType.getEndDate(x.periodType, x.value, startDate)
        val requirements = checkActivitiesRequirements(x, userId, deadline)
        val latestActivityDate = getMaxActivityDate(x, userId, x.count)

        val status = if (requirements)
          CertificateStatus.Success

        else if (deadline.isAfter(latestActivityDate))
          CertificateStatus.InProgress
        else
          CertificateStatus.Failed

        (x.activityName, status)
      })
  }

  def getStatementsStatuses(certificateId: Int, userId: Int): Iterable[(String, String, CertificateStatus)] = {
    val certificate = certificateRepository.get(("id" -> certificateId))
    val startDate = certificateToUserRepository.getLeft(certificate).filter(x => x._2.getUserId == userId).head._1
    val statements = certificateToTincanStatementRepository.select(("certificateId" -> certificateId))

    statements
      .map(x => {
        val deadline = PeriodType.getEndDate(x.period, x.value, startDate)
        val requirements = checkStatementsRequirements(x, deadline)
        val latestStatementDate = getMaxStatementDate(x)

        val status = if (requirements)
          CertificateStatus.Success

        else if (deadline.isAfter(latestStatementDate))
          CertificateStatus.InProgress
        else
          CertificateStatus.Failed

        (x.obj, x.verb, status)
      })
  }

  private def isFailed(isStatementsPassed: Boolean,
    isActivitiesPassed: Boolean,
    isCoursesPassed: Boolean,
    endDate: DateTime): Boolean = (!isStatementsPassed || !isActivitiesPassed || !isCoursesPassed) && endDate.isBefore(DateTime.now)

  private def isOverdue(isStatementsPassed: Boolean,
    isActivitiesPassed: Boolean,
    isCoursesPassed: Boolean,
    endDate: DateTime): Boolean = isStatementsPassed && isActivitiesPassed && isCoursesPassed && endDate.isBefore(DateTime.now)

  private def isSuccess(isStatementsPassed: Boolean,
    isActivitiesPassed: Boolean,
    isCoursesPassed: Boolean,
    endDate: DateTime): Boolean = isStatementsPassed && isActivitiesPassed && isCoursesPassed && endDate.isAfter(DateTime.now)

  private def checkStatementsRequirements(certificateStatementObjSettings: CertificateStatementObjSettings,
    endDate: DateTime): Boolean =
    getStatements(certificateStatementObjSettings)
      .filter(x => x.timestamp.isDefined)
      .count(x => x.timestamp.get.after(endDate.toDate)) > 0

  private def checkActivitiesRequirements(certificateActivitySettings: CertificateActivitySettings,
    userId: Int,
    endDate: DateTime): Boolean = {

    val activities = SocialActivityServiceUtil
      .getActivities(certificateActivitySettings.activityName, -1, -1)
      .asScala
      .filter(x => x.getUserId == userId)

    val count = activities.count(activity => {
      val endDate = PeriodType.getEndDate(
        certificateActivitySettings.periodType,
        certificateActivitySettings.value,
        new DateTime(activity.getCreateDate))

      endDate.isAfter(new DateTime(activity.getCreateDate))
    })

    certificateActivitySettings.count <= count
  }

  private def checkCoursesRequirements(certificateCourseSettings: CertificateCourseSettings,
    userId: Int,
    endDate: DateTime): Boolean = courseStorage.get(certificateCourseSettings.courseId, userId) match {
    case Some(value) => value.date.get.isBefore(endDate) && !value.grade.isEmpty
    case None        => false
  }

  private def getStatements(certificateStatementObjSettings: CertificateStatementObjSettings): Seq[Statement] = {
    val statementLRS = new StatementLRS() {
      val statementStorage = inject[StatementStorage]
    }

    val filter = StatementFilter(
      activity = Option(certificateStatementObjSettings.obj),
      verb = Option(certificateStatementObjSettings.verb),
      relatedActivities = Option(true))

    statementLRS.getStatements(filter).statements
  }

  private def findDeadline(courses: Iterable[CertificateCourseSettings],
    activities: Iterable[CertificateActivitySettings],
    statements: Iterable[CertificateStatementObjSettings],
    startDate: DateTime): DateTime = {
    val hasStatementDeadline = statements.exists(statement => statement.period.getOrElse(PeriodType.UNLIMITED) != PeriodType.UNLIMITED)
    val hasCourseDeadline = courses.exists(course => course.periodType.getOrElse(PeriodType.UNLIMITED) != PeriodType.UNLIMITED)
    val hasActivityDeadline = activities.exists(activity => activity.periodType != PeriodType.UNLIMITED)

    if (hasStatementDeadline || hasCourseDeadline || hasActivityDeadline) {
      val courseDeadline = Try(courses
        .map(x => PeriodType.getEndDate(x.periodType, x.value, startDate))
        .minBy(x => x.toDate))
        .getOrElse(new DateTime(Long.MaxValue))

      val activityDeadline = Try(activities
        .map(x => PeriodType.getEndDate(x.periodType, x.value, startDate))
        .minBy(x => x.toDate))
        .getOrElse(new DateTime(Long.MaxValue))

      val statementDeadline = Try(statements
        .map(x => PeriodType.getEndDate(x.period, x.value, startDate))
        .minBy(x => x.toDate))
        .getOrElse(new DateTime(Long.MaxValue))

      List(courseDeadline, activityDeadline, statementDeadline).minBy(x => x.toDate)
    } else
      DateTime.now.plusYears(9999)
  }

  private def getMaxStatementDate(certificateStatementObjSettings: CertificateStatementObjSettings): DateTime = {

    val statements = getStatements(certificateStatementObjSettings)
    if (statements.length == 0)
      return DateTime.now

    val timestamp = statements
      .maxBy(x => x.timestamp)
      .timestamp

    new DateTime(timestamp)
  }

  private def getMaxActivityDate(certificateActivitySettings: CertificateActivitySettings,
    userId: Int,
    count: Int): DateTime = {
    val result = Try(SocialActivityServiceUtil
      .getActivities(certificateActivitySettings.activityName, -1, -1)
      .asScala
      .filter(x => x.getUserId == userId)
      .sortBy(x => x.getCreateDate)
      .take(count)
      .last
      .getCreateDate)
      .getOrElse(DateTime.now.toDate)

    new DateTime(result)
  }
  //
  private def getMaxCourseDate(certificateCourseSettings: CertificateCourseSettings, userId: Int): DateTime = {
    courseStorage.get(certificateCourseSettings.courseId, userId) match {
      case Some(value) => value.date.get
      case None        => DateTime.now
    }
  }

}
