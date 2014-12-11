package com.arcusys.learn.facades.certificate

import com.arcusys.learn.bl.services.CertificateServiceContract
import com.arcusys.learn.facades.CertificateFacadeContract
import com.arcusys.learn.models._
import com.arcusys.learn.models.response.certificates.{ ActivityStatusResponse, CourseStatusResponse, StatementStatusResponse }
import com.arcusys.learn.scorm.manifest.model.PeriodType.PeriodType
import com.escalatesoft.subcut.inject.Injectable
import com.liferay.portal.service.UserLocalServiceUtil
import org.joda.time.DateTimeZone
import org.joda.time.format.DateTimeFormat

trait CertificateGoals extends Injectable with CertificateFacadeContract with CertificateResponseFactory {

  private lazy val certificateService = inject[CertificateServiceContract]

  def addCourse(certificateId: Int, courseId: Int) {
    certificateService.addCourse(certificateId, courseId)
  }

  def deleteCourse(certificateId: Int, courseId: Int) = {
    certificateService.deleteCourse(certificateId, courseId)
  }

  def changeCourse(certificateId: Int, courseId: Int, value: Int, period: PeriodType) = {
    certificateService.changeCourse(certificateId, courseId, value, period)
  }

  def moveCourse(certificateId: Int, courseIDs: Seq[Int]) {
    certificateService.moveCourse(certificateId, courseIDs)
  }

  def addActivity(certificateId: Int, activityName: String, count: Int = 1) = {
    certificateService.addActivity(certificateId, activityName, count)
  }

  def getActivities(certificateId: Int): Seq[ActivityResponse] = {
    certificateService.getActivities(certificateId).map(toActivityResponse).toSeq
  }

  def deleteActivity(certificateId: Int, activityName: String) = {
    certificateService.deleteActivity(certificateId, activityName)
  }

  def changeActivity(certificateId: Int, activityName: String, count: Int, value: Int, period: PeriodType) = {
    certificateService.changeActivity(certificateId, activityName, count, value, period)
  }

  def getStatements(certificateId: Int): List[StatementResponse] =
    certificateService.getStatements(certificateId).map(toStatementResponse).toList

  def addStatementObj(certificateId: Int, verb: String, obj: String): Unit = {
    certificateService.addStatementObj(certificateId, verb, obj)
  }

  def deleteStatementObj(certificateId: Int, verb: String, obj: String): Unit = {
    certificateService.deleteStatementObj(certificateId, verb, obj)
  }

  def changeStatementObjPeriod(certificateId: Int, verb: String, obj: String, value: Int, period: PeriodType) = {
    certificateService.changeStatementObjPeriod(certificateId, verb, obj, value, period)
  }

  def getGoalsStatuses(certificateId: Int, userId: Int): GoalsStatusResponse = {
    val user = UserLocalServiceUtil.getUserById(userId)
    val format = DateTimeFormat.forPattern(DateTimeFormat.patternForStyle("SS", user.getLocale))
      .withZone(DateTimeZone.forTimeZone(user.getTimeZone))

    val courses = certificateService.getCoursesStatuses(certificateId, userId)
    val activities = certificateService.getActivitiesStatuses(certificateId, userId)
    val statements = certificateService.getStatementsStatuses(certificateId, userId)

    GoalsStatusResponse(
      courses = courses.map(x => CourseStatusResponse(x._1, x._2.toString, format.print(x._3))),
      activities = activities.map(x => ActivityStatusResponse(x._1, x._2.toString, x._3.map(d => format.print(d)).getOrElse(""))),
      statements = statements.map(x => StatementStatusResponse(x._1, x._2, x._3.toString, format.print(x._4))))
  }

  def getGoalsDeadlines(certificateId: Int, userId: Int) = GoalsDeadlineResponse(
    activities = certificateService.getActivitiesDeadlines(certificateId, userId).map(d => ActivityDeadlineResponse(d._1, d._2)),
    courses = certificateService.getCoursesDeadlines(certificateId, userId).map(d => CourseDeadlineResponse(d._1, d._2)),
    statements = certificateService.getStatementsDeadlines(certificateId, userId).map(d => StatementDeadlineResponse(d._1, d._2, d._3))
  )
}
