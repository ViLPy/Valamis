package com.arcusys.learn.bl.services.certificates

import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.liferay.services.{ SocialActivityCounterLocalServiceHelper, SocialActivityLocalServiceHelper }
import com.arcusys.learn.scorm.certificating._
import com.arcusys.learn.scorm.tracking.model.certificating.models._
import com.arcusys.learn.scorm.course.CourseStorage
import com.arcusys.learn.scorm.manifest.model.PeriodType
import com.arcusys.learn.scorm.tracking.model.certificating.CertificateStatus.CertificateStatus
import com.arcusys.learn.scorm.tracking.model.certificating.CertificateStatus
import com.arcusys.learn.tincan.lrs.statement.{ StatementFilter, StatementLRS }
import com.arcusys.learn.tincan.model.{ Agent, Statement }
import com.arcusys.learn.tincan.storage.StatementStorage
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import com.liferay.portal.security.auth.PrincipalThreadLocal
import com.liferay.portal.security.permission.{ PermissionCheckerFactoryUtil, PermissionThreadLocal }
import com.liferay.portal.service.UserLocalServiceUtil
import org.joda.time.DateTime

import scala.collection.JavaConverters._
import scala.util.Try

class CertificateStatusChecker(configuration: BindingModule) extends CertificateStatusCheckerContract with Injectable {
  def this() = this(DomainConfiguration)
  implicit val bindingModule = configuration

  private lazy val certificateRepository = inject[CertificateRepositoryContract]
  private lazy val certificateUserRepository = inject[CertificateUserRepositoryContract]
  private lazy val certificateCourseRepository = inject[CertificateCourseSettingsRepositoryContract]
  private lazy val certificateActivityRepository = inject[CertificateActivitySettingsRepositoryContract]
  private lazy val certificateTincanStatementRepository = inject[CertificateStatementObjSettingsRepositoryContract]
  private lazy val courseRepository = inject[CourseStorage]

  override def getStatus(certificateId: Int, userId: Int): CertificateStatus = {
    grandPermission(userId)

    val certificate = certificateRepository.getById(certificateId)
    val courses = certificateCourseRepository.getByCertificateId(certificateId)
    val activities = certificateActivityRepository.getByCertificateId(certificateId)
    val statements = certificateTincanStatementRepository.getByCertificateId(certificateId)

    val startDate = certificateUserRepository.getLeft(certificate).filter(x => x._2 == userId).head._1
    val endDate = PeriodType.getEndDate(certificate.validPeriodType, Some(certificate.validPeriod), startDate)

    var isStatementsPassed, isActivitiesPassed, isCoursesPassed = true

    val deadline = findDeadline(courses, activities, statements, startDate)

    statements.foreach(x => isStatementsPassed = isStatementsPassed && checkStatementsRequirements(x, userId, PeriodType.getEndDate(x.period, x.value, startDate)))
    activities.foreach(x => isActivitiesPassed = isActivitiesPassed
      && (if (isCounterActivity(x)) checkActivityCounterRequirements(x, userId)
      else checkActivitiesRequirements(x, userId, PeriodType.getEndDate(x.periodType, x.value, startDate))
      ))
    courses.foreach(x => isCoursesPassed = isCoursesPassed && checkCoursesRequirements(x, userId, PeriodType.getEndDate(x.periodType, x.value, startDate)))

    if (isFailed(isStatementsPassed, isActivitiesPassed, isCoursesPassed, deadline))
      CertificateStatus.Failed
    else if (isOverdue(isStatementsPassed, isActivitiesPassed, isCoursesPassed, endDate))
      CertificateStatus.Overdue
    else if (isSuccess(isStatementsPassed, isActivitiesPassed, isCoursesPassed, deadline))
      CertificateStatus.Success
    else
      CertificateStatus.InProgress
  }

  private def isFailed(isStatementsPassed: Boolean, isActivitiesPassed: Boolean,
    isCoursesPassed: Boolean, endDate: DateTime): Boolean =
    (!isStatementsPassed || !isActivitiesPassed || !isCoursesPassed) && endDate.isBefore(DateTime.now)

  private def isOverdue(isStatementsPassed: Boolean, isActivitiesPassed: Boolean,
    isCoursesPassed: Boolean, endDate: DateTime): Boolean =
    isStatementsPassed && isActivitiesPassed && isCoursesPassed && endDate.isBefore(DateTime.now)

  private def isSuccess(isStatementsPassed: Boolean, isActivitiesPassed: Boolean,
    isCoursesPassed: Boolean, endDate: DateTime): Boolean =
    isStatementsPassed && isActivitiesPassed && isCoursesPassed && endDate.isAfter(DateTime.now)

  private def checkStatementsRequirements(certificateStatementObjSettings: CertificateStatementObjSettings, userId: Int,
    endDate: DateTime): Boolean = {
    val all = getStatements(certificateStatementObjSettings, userId)
    val hasTimestamp = all.filter(x => x.timestamp.isDefined)
    hasTimestamp.count(x => x.timestamp.get.before(endDate.toDate)) > 0
  }

  private def getStatements(certificateStatementObjSettings: CertificateStatementObjSettings, userId: Int): Seq[Statement] = {
    val statementLRS = new StatementLRS() {
      val statementStorage = inject[StatementStorage]
    }

    val agent = new Agent("Agent", None, Some("mailto:" + UserLocalServiceUtil.getUser(userId).getEmailAddress), None, None, None, None)
    val filter = StatementFilter(
      agent = Option(agent),
      activity = Option(certificateStatementObjSettings.obj),
      verb = Option(certificateStatementObjSettings.verb),
      relatedActivities = Option(true))

    statementLRS.getStatements(filter).statements
  }

  private def checkCoursesRequirements(certificateCourseSettings: CertificateCourseSettings,
    userId: Int,
    endDate: DateTime): Boolean = courseRepository.get(certificateCourseSettings.courseId, userId) match {
    case Some(value) => value.date.get.isBefore(endDate) && !value.grade.isEmpty
    case None        => false
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
        .filterNot(isCounterActivity)
        .map(x => PeriodType.getEndDate(x.periodType, x.value, startDate))
        .minBy(x => x.toDate))
        .getOrElse(new DateTime(Long.MaxValue))

      val statementDeadline = Try(statements
        .map(x => PeriodType.getEndDate(x.period, x.value, startDate))
        .minBy(x => x.toDate))
        .getOrElse(new DateTime(Long.MaxValue))

      List(courseDeadline, activityDeadline, statementDeadline).minBy(_.toDate)
    } else
      DateTime.now.plusYears(9999)
  }

  override def getCoursesStatuses(certificateId: Int, userId: Int): Iterable[(Int, CertificateStatus, DateTime)] = {
    grandPermission(userId)
    val certificate = certificateRepository.getById(certificateId)
    val startDate = certificateUserRepository.getLeft(certificate).filter(x => x._2 == userId).head._1
    val courses = certificateCourseRepository.getByCertificateId(certificateId)

    courses
      .map(x => {
        val endDate = PeriodType.getEndDate(x.periodType, x.value, startDate)
        val requirements = checkCoursesRequirements(x, userId, endDate)
        val latestCourseDate = getMaxCourseDate(x, userId)

        val finishDate = if (requirements)
          getCoursesFinishDate(x, userId)
        else new DateTime(0)

        val status = if (requirements)
          CertificateStatus.Success

        else if (endDate.isAfter(latestCourseDate))
          CertificateStatus.InProgress
        else
          CertificateStatus.Failed

        (x.courseId, status, finishDate)
      })
  }

  private def getCoursesFinishDate(certificateCourseSettings: CertificateCourseSettings, userId: Int): DateTime =
    courseRepository.get(certificateCourseSettings.courseId, userId).map(_.date).get.get

  //
  private def getMaxCourseDate(certificateCourseSettings: CertificateCourseSettings, userId: Int): DateTime = {
    courseRepository.get(certificateCourseSettings.courseId, userId) match {
      case Some(value) => value.date.get
      case None        => DateTime.now
    }
  }

  override def getCoursesDeadlines(certificateId: Int, userId: Int): Seq[(Int, Option[DateTime])] = {
    grandPermission(userId)

    val certificate = certificateRepository.getById(certificateId)
    val startDate = certificateUserRepository.getLeft(certificate).filter(x => x._2 == userId).head._1
    val courses = certificateCourseRepository.getByCertificateId(certificateId)

    courses map { course =>
      (course.courseId, getEndDate(course.periodType, course.value, startDate))
    }
  }

  private def getEndDate(typ: Option[PeriodType.Value], value: Option[Int], startDate: DateTime) =
    typ.flatMap { period =>
      if (period == PeriodType.UNLIMITED) None
      else Option(PeriodType.getEndDate(typ, value, startDate))
    }

  override def getActivitiesStatuses(certificateId: Int, userId: Int): Iterable[(String, CertificateStatus, Option[DateTime])] = {
    grandPermission(userId)

    val certificate = certificateRepository.getById(certificateId)
    val startDate = certificateUserRepository.getLeft(certificate).filter(x => x._2 == userId).head._1
    val activities = certificateActivityRepository.getByCertificateId(certificateId)

    activities
      .map(x => {
        if (isCounterActivity(x)) {
          (
            x.activityName,
            if (checkActivityCounterRequirements(x, userId)) CertificateStatus.Success else CertificateStatus.InProgress,
            None
          )
        } else {
          val deadline = PeriodType.getEndDate(x.periodType, x.value, startDate)
          val requirements = checkActivitiesRequirements(x, userId, deadline)
          val latestActivityDate = getMaxActivityDate(x, userId, x.count)

          val finishDate = if (requirements)
            getActivitiesFinishDate(x, userId)
          else new DateTime(0)

          val status = if (requirements)
            CertificateStatus.Success

          else if (deadline.isAfter(latestActivityDate))
            CertificateStatus.InProgress
          else
            CertificateStatus.Failed

          (x.activityName, status, Some(finishDate))
        }
      })
  }

  private def isCounterActivity(activity: CertificateActivitySettings) = {
    activity.activityName == "participation" || activity.activityName == "contribution"
  }

  private def grandPermission(userId: Int) {
    val u = UserLocalServiceUtil.getUserById(userId)
    val permissionChecker = PermissionCheckerFactoryUtil.create(u)

    PermissionThreadLocal.setPermissionChecker(permissionChecker)
    PrincipalThreadLocal.setName(u.getUserId)
  }

  private def checkActivitiesRequirements(certificateActivitySettings: CertificateActivitySettings,
    userId: Int,
    endDate: DateTime): Boolean = {

    val activities = SocialActivityLocalServiceHelper
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

  private def checkActivityCounterRequirements(setting: CertificateActivitySettings, userId: Int): Boolean = {
    setting.count <= SocialActivityCounterLocalServiceHelper.getUserValue(userId, setting.activityName).getOrElse(Int.MinValue)
  }

  private def getActivitiesFinishDate(certificateActivitySettings: CertificateActivitySettings, userId: Int): DateTime = {
    val activity = SocialActivityLocalServiceHelper
      .getActivities(certificateActivitySettings.activityName, -1, -1)
      .asScala
      .filter(_.getUserId == userId).sortBy(_.getCreateDate).last

    new DateTime(activity.getCreateDate)
  }

  private def getMaxActivityDate(certificateActivitySettings: CertificateActivitySettings,
    userId: Int,
    count: Int): DateTime = {
    val result = Try(SocialActivityLocalServiceHelper
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

  override def getActivitiesDeadlines(certificateId: Int, userId: Int): Seq[(String, Option[DateTime])] = {
    grandPermission(userId)

    val certificate = certificateRepository.getById(certificateId)
    val startDate = certificateUserRepository.getLeft(certificate).filter(x => x._2 == userId).head._1
    val activities = certificateActivityRepository.getByCertificateId(certificateId)

    activities
      .filterNot(isCounterActivity)
      .map(a => (a.activityName, getEndDate(Option(a.periodType), a.value, startDate)))
  }

  override def getStatementsStatuses(certificateId: Int, userId: Int): Iterable[(String, String, CertificateStatus, DateTime)] = {
    val u = UserLocalServiceUtil.getUserById(userId)
    val permissionChecker = PermissionCheckerFactoryUtil.create(u)

    PermissionThreadLocal.setPermissionChecker(permissionChecker)
    PrincipalThreadLocal.setName(u.getUserId)

    val certificate = certificateRepository.getById(certificateId)
    val startDate = certificateUserRepository.getLeft(certificate).filter(x => x._2 == userId).head._1
    val statements = certificateTincanStatementRepository.getByCertificateId(certificateId)

    statements
      .map(x => {
        val deadline = PeriodType.getEndDate(x.period, x.value, startDate)
        val requirements = checkStatementsRequirements(x, userId, deadline)
        val latestStatementDate = getMaxStatementDate(x, userId)

        val finishDate = if (requirements)
          getStatementsFinishDate(x, userId)
        else new DateTime(0)

        val status = if (requirements)
          CertificateStatus.Success

        else if (deadline.isAfter(latestStatementDate))
          CertificateStatus.InProgress
        else
          CertificateStatus.Failed

        (x.obj, x.verb, status, finishDate)
      })
  }

  private def getStatementsFinishDate(certificateStatementObjSettings: CertificateStatementObjSettings, userId: Int): DateTime = {
    val all = getStatements(certificateStatementObjSettings, userId)
    val finishDate = all.filter(x => x.timestamp.isDefined).sortBy(_.timestamp).head.timestamp.get
    new DateTime(finishDate)
  }

  private def getMaxStatementDate(certificateStatementObjSettings: CertificateStatementObjSettings, userId: Int): DateTime = {

    val statements = getStatements(certificateStatementObjSettings, userId)
    if (statements.length == 0)
      return DateTime.now

    val timestamp = statements
      .maxBy(x => x.timestamp)
      .timestamp

    timestamp match {
      case Some(value) => new DateTime(value)
      case None        => DateTime.now
    }
  }

  override def getStatementsDeadlines(certificateId: Int, userId: Int): Seq[(String, String, Option[DateTime])] = {
    val u = UserLocalServiceUtil.getUserById(userId)
    val permissionChecker = PermissionCheckerFactoryUtil.create(u)

    PermissionThreadLocal.setPermissionChecker(permissionChecker)
    PrincipalThreadLocal.setName(u.getUserId)

    val certificate = certificateRepository.getById(certificateId)
    val startDate = certificateUserRepository.getLeft(certificate).filter(x => x._2 == userId).head._1
    val statements = certificateTincanStatementRepository.getByCertificateId(certificateId)

    statements map { statement =>
      (statement.obj, statement.verb, getEndDate(statement.period, statement.value, startDate))
    }
  }

}
