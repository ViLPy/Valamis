package com.arcusys.learn.facades.certificate

import com.arcusys.learn.facades.CertificateFacadeContract
import com.arcusys.learn.models.response.certificates._
import com.arcusys.valamis.certificate.service.CertificateService
import com.arcusys.valamis.lrs.api.StatementApi
import com.arcusys.valamis.model.PeriodTypes.PeriodType
import com.escalatesoft.subcut.inject.Injectable
import com.liferay.portal.service.UserLocalServiceUtil
import org.joda.time.format.DateTimeFormat
import org.joda.time.{DateTime, DateTimeZone}

trait CertificateGoals extends Injectable with CertificateFacadeContract with CertificateResponseFactory {

  private lazy val certificateService = inject[CertificateService]

  def addCourse(certificateId: Int, courseId: Int) {
    certificateService.addCourseGoal(certificateId, courseId)
  }

  def deleteCourse(certificateId: Int, courseId: Int) = {
    certificateService.deleteCourseGoal(certificateId, courseId)
  }

  def changeCourse(certificateId: Int, courseId: Int, value: Int, period: PeriodType) = {
    certificateService.changeCourseGoalPeriod(certificateId, courseId, value, period)
  }

  def moveCourse(certificateId: Int, courseIDs: Seq[Int]) {
    certificateService.moveCourseGoals(certificateId, courseIDs)
  }

  def addActivity(certificateId: Int, activityName: String, count: Int = 1) = {
    certificateService.addActivityGoal(certificateId, activityName, count)
  }

  def getActivities(certificateId: Int): Seq[ActivityGoalResponse] = {
    certificateService.getActivityGoals(certificateId).map(toActivityResponse).toSeq
  }

  def deleteActivity(certificateId: Int, activityName: String) = {
    certificateService.deleteActivityGoal(certificateId, activityName)
  }

  def changeActivity(certificateId: Int, activityName: String, count: Int, value: Int, period: PeriodType) = {
    certificateService.changeActivityGoalPeriod(certificateId, activityName, count, value, period)
  }

  def getStatements(certificateId: Int): List[StatementGoalResponse] =
    certificateService.getStatementGoals(certificateId).map(toStatementResponse).toList

  def addStatementObj(certificateId: Int, verb: String, obj: String): Unit = {
    certificateService.addStatementGoal(certificateId, verb, obj)
  }

  def addPackageGoal(certificateId: Long, packageId: Long): Unit = {
    certificateService.addPackageGoal(certificateId, packageId)
  }

  def deleteStatementObj(certificateId: Int, verb: String, obj: String): Unit = {
    certificateService.deleteStatementGoal(certificateId, verb, obj)
  }

  def deletePackageGoal(certificateId: Long, packageId: Long): Unit = {
    certificateService.deletePackageGoal(certificateId, packageId)
  }

  def changeStatementObjPeriod(certificateId: Int, verb: String, obj: String, value: Int, period: PeriodType) = {
    certificateService.changeStatementGoalPeriod(certificateId, verb, obj, value, period)
  }

  def changePackagePeriod(certificateId: Long, packageId: Long, value: Int, period: PeriodType) = {
    certificateService.changePackageGoal(certificateId, packageId, value, period)
  }

  def getGoalsStatuses(statementApi: StatementApi, certificateId: Int, userId: Int): GoalsStatusResponse = {
    val user = UserLocalServiceUtil.getUserById(userId)
    val format = DateTimeFormat.forPattern(DateTimeFormat.patternForStyle("SS", user.getLocale))
      .withZone(DateTimeZone.forTimeZone(user.getTimeZone))

    val courses = certificateService.getCourseGoalsStatus(certificateId, userId)
    val activities = certificateService.getActivityGoalsStatus(certificateId, userId)
    val statements = certificateService.getStatementGoalsStatus(statementApi, certificateId, userId)
    val packagesGoalsStatus = certificateService.getPackageGoalsStatus(statementApi, certificateId, userId)

    def dateToString(date: Option[DateTime]) = date.map(d => format.print(d)).getOrElse("")

    GoalsStatusResponse(
      courses.map(x => CourseStatusResponse(x.goal.courseId, x.status.toString, dateToString(x.finishDate))),
      activities.map(x => ActivityStatusResponse(x.goal.activityName, x.status.toString, dateToString(x.finishDate))),
      statements.map(x => StatementStatusResponse(x.goal.obj, x.goal.verb, x.status.toString, dateToString(x.finishDate))),
      packagesGoalsStatus.map(x => PackageStatusResponse(x.goal.packageId, x.status.toString, dateToString(x.finishDate)))
    )
  }

  def getGoalsDeadlines(certificateId: Int, userId: Int) = GoalsDeadlineResponse(
    certificateService.getCourseGoalsDeadline(certificateId, userId)
      .map(d => CourseGoalDeadlineResponse(d.goal.courseId, d.deadline)),
    certificateService.getActivityGoalsDeadline(certificateId, userId)
      .map(d => ActivityGoalDeadlineResponse(d.goal.activityName, d.deadline)),
    certificateService.getStatementGoalsDeadline(certificateId, userId)
      .map(d => StatementGoalDeadlineResponse(d.goal.obj, d.goal.verb, d.deadline)),
    certificateService.getPackageGoalsDeadline(certificateId, userId)
      .map(d => PackageGoalDeadlineResponse(d.goal.packageId, d.deadline))
  )
}
