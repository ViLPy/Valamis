package com.arcusys.learn.facades.certificate

import com.arcusys.learn.bl.services.CertificateServiceContract
import com.arcusys.learn.bl.services.certificates.CertificateStatusCheckerContract
import com.arcusys.learn.facades.CourseFacadeContract
import com.arcusys.learn.models._
import com.arcusys.learn.models.response.certificates._
import com.arcusys.learn.models.response.users.UserShortResponse
import com.arcusys.learn.scorm.manifest.model.PeriodType
import com.arcusys.learn.scorm.tracking.model.certificating.models.{ CertificateActivitySettings, CertificateStatementObjSettings, CertificateCourseSettings }
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate
import com.escalatesoft.subcut.inject.Injectable
import org.joda.time.format.ISODateTimeFormat

import scala.util.Try

trait CertificateResponseFactory extends Injectable {

  private lazy val courseFacade = inject[CourseFacadeContract]
  private lazy val checker = inject[CertificateStatusCheckerContract]
  private lazy val certificateService = inject[CertificateServiceContract]

  protected def toCertificateResponse(isShortResult: Boolean)(c: Certificate): CertificateResponseContract = {
    if (isShortResult)
      toShortCertificateResponse(c)
    else
      toCertificateResponse(c)
  }

  def toCertificateResponse(c: Certificate): CertificateResponse = {
    val users = getUsers(c)
    val courses = certificateService.getCourses(c.id).map(toCertificateCourseResponse)
    val statements = certificateService.getStatements(c.id).map(toStatementResponse)
    val activities = certificateService.getActivities(c.id).map(toActivityResponse)
    val scope = c.scope.map(v => courseFacade.getCourse(v.toInt))
    CertificateResponse(c.id, c.title, c.shortDescription, c.description, c.logo, c.isPublished,
      new ValidPeriod(Some(c.validPeriod), c.validPeriodType.toString), c.createdAt, c.isPublishBadge,
      courses, statements, activities, users, scope)
  }

  def toShortCertificateResponse(c: Certificate): CertificateShortResponse = {
    val usersCount = certificateService.getUsersCount(c)
    val coursesCount = certificateService.getCoursesCount(c.id)
    val statementsCount = certificateService.getStatementsCount(c.id)
    val activitiesCount = certificateService.getActivitiesCount(c.id)
    val scope = c.scope.map(v => courseFacade.getCourse(v.toInt))
    CertificateShortResponse(c.id, c.title, c.shortDescription, c.description, c.logo, c.isPublished,
      coursesCount, statementsCount, activitiesCount, usersCount, scope)
  }

  def toCertificateWithUserStatusResponse(userId: Int)(c: Certificate): CertificateWithUserStatusResponse = {
    val usersCount = certificateService.getUsersCount(c)
    val coursesCount = certificateService.getCoursesCount(c.id)
    val statementsCount = certificateService.getStatementsCount(c.id)
    val activitiesCount = certificateService.getActivitiesCount(c.id)
    val status = checker.getStatus(c.id, userId)
    CertificateWithUserStatusResponse(c.id, c.title, c.shortDescription, c.description, c.logo, c.isPublished,
      coursesCount, statementsCount, activitiesCount, usersCount, status.toString)
  }

  def toCertificateCourseResponse(courseSettings: CertificateCourseSettings) = {
    val course = courseFacade.getCourse(courseSettings.courseId)
    new CertificateCourseResponse(courseSettings.courseId, courseSettings.certificateId, course.title, course.url, courseSettings.value,
      courseSettings.periodType.getOrElse(PeriodType.UNLIMITED).toString, courseSettings.arrangementIndex)
  }

  protected def toStatementResponse(s: CertificateStatementObjSettings) = {
    StatementResponse(s.certificateId, s.obj, s.verb, s.value, s.period.getOrElse(PeriodType.UNLIMITED).toString)
  }

  protected def toActivityResponse(a: CertificateActivitySettings) = {
    ActivityResponse(a.certificateId, a.count, a.activityName, a.value, a.periodType.toString)
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
