package com.arcusys.valamis.certificate.service

import com.arcusys.learn.liferay.services.PermissionHelper
import com.arcusys.valamis.certificate.model.goal.{GoalStatuses, GoalDeadline, CourseGoal, GoalStatus}
import com.arcusys.valamis.certificate.storage.CourseGoalStorage
import com.arcusys.valamis.gradebook.storage.CourseGradeStorage
import com.arcusys.valamis.model.PeriodTypes
import org.joda.time.DateTime

trait CourseGoalStatusCheckerComponent extends CourseGoalStatusChecker {
  protected def courseGoalStorage: CourseGoalStorage
  protected def courseGradeStorage: CourseGradeStorage
  protected def certificateStateService: CertificateStateService

  override def getCourseGoalsStatus(certificateId: Int, userId: Int): Seq[GoalStatus[CourseGoal]] = {
    PermissionHelper.preparePermissionChecker(userId)

    val certificateState = certificateStateService.getBy(userId, certificateId).get
    val goals = courseGoalStorage.getByCertificateId(certificateId).sortBy(_.arrangementIndex)

    goals.map { goal =>
      val status = checkCourseGoal(userId, certificateState.userJoinedDate)(goal)
      val finishDate =
        if (status == GoalStatuses.Success) Some(courseGradeStorage.get(goal.courseId.toInt, userId).get.date.get)
        else None

      GoalStatus(goal, status, finishDate)
    }
  }

  override def getCourseGoalsDeadline(certificateId: Int, userId: Int): Seq[GoalDeadline[CourseGoal]] = {
    PermissionHelper.preparePermissionChecker(userId)

    val startDate = certificateStateService.getBy(userId, certificateId).get.userJoinedDate
    courseGoalStorage.getByCertificateId(certificateId).sortBy(_.arrangementIndex)
      .map { goal =>
      GoalDeadline(goal, PeriodTypes.getEndDateOption(goal.periodType, goal.periodValue, startDate))
    }
  }

  protected def checkCourseGoal(userId: Int, userJoinedDate: DateTime)(courseGoal: CourseGoal) = {
    val course = courseGradeStorage.get(courseGoal.courseId.toInt, userId)

    val isTimeOut =
      PeriodTypes
        .getEndDate(courseGoal.periodType, courseGoal.periodValue, userJoinedDate)
        .isBefore(course.flatMap(_.date).getOrElse(DateTime.now))
    lazy val isGoalCompleted = course.map(_.grade.nonEmpty).getOrElse(false)

    if (isTimeOut) GoalStatuses.Failed
    else if (isGoalCompleted) GoalStatuses.Success
    else GoalStatuses.InProgress
  }
}