package com.arcusys.valamis.certificate.service

import com.arcusys.learn.liferay.services.{SocialActivityCounterLocalServiceHelper, SocialActivityLocalServiceHelper, PermissionHelper}
import com.arcusys.valamis.certificate.model.goal.{GoalStatuses, GoalDeadline, ActivityGoal, GoalStatus}
import com.arcusys.valamis.certificate.storage.ActivityGoalStorage
import com.arcusys.valamis.model.PeriodTypes
import com.liferay.portlet.social.model.SocialActivity
import org.joda.time.DateTime

trait ActivityGoalStatusCheckerComponent extends ActivityGoalStatusChecker {
  protected def certificateStateService: CertificateStateService
  protected def activityGoalStorage: ActivityGoalStorage

  override def getActivityGoalsStatus(certificateId: Int, userId: Int): Seq[GoalStatus[ActivityGoal]] = {
    PermissionHelper.preparePermissionChecker(userId)

    val certificateState = certificateStateService.getBy(userId, certificateId).get
    val goals = activityGoalStorage.getByCertificateId(certificateId)
    val socialActivities = SocialActivityLocalServiceHelper.getActivities(userId, certificateState.userJoinedDate)

    goals.map { goal =>
      val status = checkActivityGoal(userId, socialActivities, certificateState.userJoinedDate)(goal)
      val finishDate =
        if (isCounterActivity(goal) || status != GoalStatuses.Success) None
        else Some(new DateTime(
          SocialActivityLocalServiceHelper.getActivities(userId, certificateState.userJoinedDate)
            .sortBy(_.getCreateDate)
            .take(goal.count)
            .last
            .getCreateDate))

      GoalStatus(goal, status, finishDate)
    }
  }

  override def getActivityGoalsDeadline(certificateId: Int, userId: Int): Seq[GoalDeadline[ActivityGoal]] = {
    PermissionHelper.preparePermissionChecker(userId)

    val startDate = certificateStateService.getBy(userId, certificateId).get.userJoinedDate
    activityGoalStorage.getByCertificateId(certificateId)
      //.filterNot(isCounterActivity) They have unlimited period type, shouldn't check
      .map { goal =>
      GoalDeadline(goal, PeriodTypes.getEndDateOption(goal.periodType, goal.periodValue, startDate))
    }
  }

  protected def checkActivityGoal(userId: Long, activities: Seq[SocialActivity], userJoinedDate: DateTime)
                                 (activityGoal: ActivityGoal): GoalStatuses.Value = {
    val lastCountedActivityDateOrNow = activities match {
      case Nil => DateTime.now
      case v =>
        if (v.length < activityGoal.count) DateTime.now
        else new DateTime(v.take(activityGoal.count).last.getCreateDate)
    }

    val isTimeOut =
      PeriodTypes
        .getEndDate(activityGoal.periodType, activityGoal.periodValue, userJoinedDate)
        .isBefore(lastCountedActivityDateOrNow)

    lazy val activitiesCount = if (isCounterActivity(activityGoal))
      SocialActivityCounterLocalServiceHelper
        .getUserValue(userId, activityGoal.activityName)
        .getOrElse(0)
    else activities.count(_.getClassName == activityGoal.activityName)

    if (isTimeOut) GoalStatuses.Failed
    else if (activityGoal.count <= activitiesCount) GoalStatuses.Success
    else GoalStatuses.InProgress
  }

  private def isCounterActivity(activity: ActivityGoal) =
    activity.activityName == "participation" || activity.activityName == "contribution"
}