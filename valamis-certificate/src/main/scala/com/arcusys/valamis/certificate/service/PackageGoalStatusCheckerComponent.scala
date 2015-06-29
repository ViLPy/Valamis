package com.arcusys.valamis.certificate.service

import com.arcusys.learn.liferay.services.PermissionHelper
import com.arcusys.valamis.certificate.model.goal.{GoalStatuses, GoalDeadline, PackageGoal, GoalStatus}
import com.arcusys.valamis.certificate.storage.PackageGoalStorage
import com.arcusys.valamis.lesson.tincan.model.ManifestActivity
import com.arcusys.valamis.lesson.tincan.storage.TincanManifestActivityStorage
import com.arcusys.valamis.lrs.api.StatementApi
import com.arcusys.valamis.lrs.model.StatementFilter
import com.arcusys.valamis.lrs.tincan.{Agent, Statement}
import com.arcusys.valamis.lrs.util.{TinCanVerbs, TinCanActivityType, TincanHelper}
import com.arcusys.valamis.model.PeriodTypes
import com.liferay.portal.service.UserLocalServiceUtil
import org.joda.time.DateTime
import com.arcusys.valamis.lrs.util.StatementApiHelpers._
import com.arcusys.valamis.util.Joda._

trait PackageGoalStatusCheckerComponent extends PackageGoalStatusChecker {
  protected def tincanManifestStorage: TincanManifestActivityStorage
  protected def certificateStateService: CertificateStateService
  protected def packageGoalStorage: PackageGoalStorage

  override def getPackageGoalsStatus(statementApi: StatementApi, certificateId: Int, userId: Int): Seq[GoalStatus[PackageGoal]] = {
    PermissionHelper.preparePermissionChecker(userId)

    val certificateState = certificateStateService.getBy(userId, certificateId).get
    val goals = packageGoalStorage.getByCertificateId(certificateId)

    goals.map { goal =>
      val status = checkPackageGoal(userId, certificateState.userJoinedDate, statementApi)(goal)
      val finishDate =
        if (status == GoalStatuses.Success)
          Some(getPackageCompleteStatements(goal, userId, certificateState.userJoinedDate, statementApi).map(_.stored.get).min)
        else None

      GoalStatus(goal, status, finishDate)
    }
  }

  override def getPackageGoalsDeadline(certificateId: Int, userId: Int): Seq[GoalDeadline[PackageGoal]] = {
    val startDate = certificateStateService.getBy(userId, certificateId).get.userJoinedDate
    val goals = packageGoalStorage.getByCertificateId(certificateId)

    goals map { goal =>
      GoalDeadline(goal, PeriodTypes.getEndDateOption(goal.periodType, goal.periodValue, startDate))
    }
  }

  protected def checkPackageGoal(userId: Long, userJoinedDate: DateTime, statementApi: StatementApi)
                                (packageGoal: PackageGoal): GoalStatuses.Value = {
    val statements = getPackageCompleteStatements(packageGoal, userId, userJoinedDate, statementApi)
    val firstStatementOrNow = statements match {
      case Nil => DateTime.now
      case v => v.map(_.stored.get).min
    }

    val isTimeOut = PeriodTypes
      .getEndDate(packageGoal.periodType, packageGoal.periodValue, userJoinedDate)
      .isBefore(firstStatementOrNow)
    lazy val isGoalCompleted = statements.nonEmpty

    if (isTimeOut) GoalStatuses.Failed
    else if (isGoalCompleted) GoalStatuses.Success
    else GoalStatuses.InProgress
  }

  private def getPackageCompleteStatements(certificatePackageGoal: PackageGoal, userId: Long, userJoinedDate: DateTime,
                                           statementApi: StatementApi): Seq[Statement] = {
    val agent = TincanHelper.getAgentByEmail(UserLocalServiceUtil.getUser(userId).getEmailAddress)

    getPackageCompleteStatements(certificatePackageGoal, agent, statementApi)
      .filter(_.stored.get.isAfter(userJoinedDate))
  }

  private def getTincanPackageManifest(certificatePackageGoal: PackageGoal): Option[ManifestActivity] = {
    tincanManifestStorage.getByPackageId(certificatePackageGoal.packageId)
      .find(_.activityType == TinCanActivityType.getURI(TinCanActivityType.course))
  }

  private def getPackageCompleteStatements(certificatePackageGoal: PackageGoal, agent: Agent,
                                           statementApi: StatementApi): Seq[Statement] = {
    getTincanPackageManifest(certificatePackageGoal) match {
      case Some(manifest: ManifestActivity) =>
        val activityId = manifest.tincanId
        val filter = StatementFilter(
          agent = Option(agent),
          activity = Option(activityId),
          verb = Option(TinCanVerbs.getVerbURI(TinCanVerbs.Completed)),
          relatedActivities = Option(true))

        statementApi.getByFilter(filter)
          .filter(s => s.timestamp.isDefined && s.result.isDefined)
          .filter(s => s.result.get.success.getOrElse(false))
      case _ => Seq()
    }
  }
}