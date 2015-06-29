package com.arcusys.learn.facades.certificate

import com.arcusys.learn.facades.CourseFacadeContract
import com.arcusys.learn.models._
import com.arcusys.learn.models.response.certificates._
import com.arcusys.learn.models.response.users.UserShortResponse
import com.arcusys.valamis.certificate.model.{CertificateStateFilter, CertificateStatus, CertificateState, Certificate}
import com.arcusys.valamis.certificate.model.goal.{PackageGoal, CourseGoal, ActivityGoal, StatementGoal}
import com.arcusys.valamis.certificate.service.{CertificateStateService, CertificateStatusChecker, CertificateService}
import com.arcusys.valamis.lesson.model.LessonType
import com.arcusys.valamis.lesson.service.{ValamisPackageService, PackageService}
import com.arcusys.valamis.lrs.api.StatementApi
import com.arcusys.valamis.model.PeriodTypes
import com.arcusys.valamis.user.service.UserService
import com.escalatesoft.subcut.inject.Injectable
import org.joda.time.format.ISODateTimeFormat

import scala.util.Try

trait CertificateResponseFactory extends Injectable {

  private lazy val courseFacade = inject[CourseFacadeContract]
  private lazy val checker = inject[CertificateStatusChecker]
  private lazy val certificateService = inject[CertificateService]
  private lazy val packageService = inject[PackageService]
  private lazy val valamisPackageService = inject[ValamisPackageService]
  private lazy val certificateStateService = inject[CertificateStateService]
  private lazy val userService = inject[UserService]

  protected def toCertificateResponse(isShortResult: Boolean)(c: Certificate): CertificateResponseContract = {
    if (isShortResult)
      toShortCertificateResponse(c)
    else
      toCertificateResponse(c)
  }

  def toCertificateSuccessUsersResponse(c: Certificate): Option[CertificateSuccessUsersResponse] = {
    val successedCertificateUsers =
      certificateStateService
        .getBy(CertificateStateFilter(certificateId = Some(c.id)))
        .filter(_.status == CertificateStatus.Success)

    if(successedCertificateUsers.isEmpty) None
    else {
      val succeedUsers = userService.getByIds(c.companyId, successedCertificateUsers.map(_.userId).toSet)
      Some(CertificateSuccessUsersResponse(
        id = c.id,
        title = c.title,
        shortDescription = c.shortDescription,
        description = c.description,
        logo = c.logo,
        succeedUsers = succeedUsers
      ))
    }
  }

  def toCertificateResponse(c: Certificate): CertificateResponse = {
    val users = getUsers(c)
    val courses = certificateService.getCourseGoals(c.id).map(toCertificateCourseResponse)
    val statements = certificateService.getStatementGoals(c.id).map(toStatementResponse)
    val activities = certificateService.getActivityGoals(c.id).map(toActivityResponse)
    val packages = certificateService.getPackageGoals(c.id).map(toPackageResponse)

    val scope = c.scope.map(v => courseFacade.getCourse(v))
    CertificateResponse(c.id, c.title, c.shortDescription, c.description, c.logo, c.isPublished,
      new ValidPeriod(Some(c.validPeriod), c.validPeriodType.toString), c.createdAt, c.isPublishBadge,
      courses, statements, activities, packages, users, scope)
  }

  def toShortCertificateResponse(c: Certificate): CertificateShortResponse = {
    val usersCount = certificateService.getUsersCount(c)
    val coursesCount = certificateService.getCourseGoalsCount(c.id)
    val statementsCount = certificateService.getStatementGoalsCount(c.id)
    val activitiesCount = certificateService.getActivityGoalsCount(c.id)
    val packagesCount = certificateService.getPackageGoalsCount(c.id)
    val scope = c.scope.map(v => courseFacade.getCourse(v))
    CertificateShortResponse(c.id, c.title, c.shortDescription, c.description, c.logo, c.isPublished,
      coursesCount, statementsCount, activitiesCount, packagesCount, usersCount, scope)
  }

  def toCertificateWithUserStatusResponse(statementApi: StatementApi, userId: Int)
                                         (c: Certificate): CertificateWithUserStatusResponse = {
    val usersCount = certificateService.getUsersCount(c)
    val coursesCount = certificateService.getCourseGoalsCount(c.id)
    val statementsCount = certificateService.getStatementGoalsCount(c.id)
    val activitiesCount = certificateService.getActivityGoalsCount(c.id)
    val packagesCount = certificateService.getPackageGoalsCount(c.id)
    val status = checker.getStatus(statementApi, c.id, userId)
    CertificateWithUserStatusResponse(c.id, c.title, c.shortDescription, c.description, c.logo, c.isPublished,
      coursesCount, statementsCount, activitiesCount, packagesCount, usersCount, status.toString)
  }

  def toCertificateCourseResponse(courseSettings: CourseGoal) = {
    val course = courseFacade.getCourse(courseSettings.courseId)
    new CourseGoalResponse(
      courseSettings.courseId,
      courseSettings.certificateId,
      course.title,
      course.url,
      courseSettings.periodValue,
      courseSettings.periodType.toString,
      courseSettings.arrangementIndex,
      valamisPackageService.getPackagesCount(courseSettings.courseId.toInt))
  }

  protected def toStatementResponse(s: StatementGoal) =
    StatementGoalResponse(s.certificateId, s.obj, s.verb, s.periodValue, s.periodType.toString)

  protected def toPackageResponse(packageGoal: PackageGoal) = {
    val courseId = packageService.getPackageType(packageGoal.packageId) match {
      case LessonType.Scorm  => packageService.getScormPackageById(packageGoal.packageId).flatMap(_.courseID).get
      case LessonType.Tincan => packageService.getTincanPackageById(packageGoal.packageId).flatMap(_.courseID).get
    }

    PackageGoalResponse(
      packageGoal.certificateId,
      packageGoal.packageId,
      packageService.getPackageTitle(packageGoal.packageId),
      packageGoal.periodValue,
      packageGoal.periodType.toString,
      courseFacade.getCourse(courseId)
    )
  }

  protected def toActivityResponse(a: ActivityGoal) =
    ActivityGoalResponse(
      a.certificateId,
      a.count,
      a.activityName,
      a.periodValue,
      a.periodType.toString)

  protected def toStateResponse(certificates: Map[Long,Certificate])(certificateState: CertificateState) = {
    val certificate = certificates.get(certificateState.certificateId).get

    val endDate = PeriodTypes.getEndDateOption(certificate.validPeriodType, certificate.validPeriod, certificateState.statusAcquiredDate)
    AchievedCertificateStateResponse(
      certificate.id,
      certificate.title,
      certificate.description,
      certificate.logo,
      certificateState.status,
      endDate)
  }


  private def getUsers(certificate: Certificate): Map[String, UserShortResponse] = {
    val formatter = ISODateTimeFormat.dateTime()
    Try(certificateService.getUsers(certificate)
      .map(u => (formatter.print(u._1), UserShortResponse(u._2.getUserId, u._2.getFullName)))
      .toMap
    )
      .getOrElse(Map())
  }
}
