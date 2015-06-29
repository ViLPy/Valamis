package com.arcusys.valamis.certificate.service

import com.arcusys.learn.liferay.services.PermissionHelper
import com.arcusys.valamis.certificate.model.goal.{GoalStatuses, GoalDeadline, StatementGoal, GoalStatus}
import com.arcusys.valamis.certificate.storage.StatementGoalStorage
import com.arcusys.valamis.lrs.api.StatementApi
import com.arcusys.valamis.lrs.model.StatementFilter
import com.arcusys.valamis.lrs.tincan.Statement
import com.arcusys.valamis.lrs.util.TincanHelper
import com.arcusys.valamis.model.PeriodTypes
import com.liferay.portal.service.UserLocalServiceUtil
import org.joda.time.DateTime
import com.arcusys.valamis.lrs.util.StatementApiHelpers._
import com.arcusys.valamis.util.Joda._

trait StatementGoalStatusCheckerComponent extends StatementGoalStatusChecker {
  protected def certificateStateService: CertificateStateService
  protected def statementGoalStorage: StatementGoalStorage

  override def getStatementGoalsStatus(statementApi: StatementApi, certificateId: Int, userId: Int): Seq[GoalStatus[StatementGoal]] = {
    PermissionHelper.preparePermissionChecker(userId)

    val certificateState = certificateStateService.getBy(userId, certificateId).get
    val goals = statementGoalStorage.getByCertificateId(certificateId)

    goals.map { goal =>
      val status = checkStatementGoal(userId, statementApi, certificateState.userJoinedDate)(goal)
      val finishDate =
        if (status == GoalStatuses.Success) Some(getMaxStatementDate(goal, userId, certificateState.userJoinedDate, statementApi))
        else None

      GoalStatus(goal, status, finishDate)
    }
  }

  override def getStatementGoalsDeadline(certificateId: Int, userId: Int): Seq[GoalDeadline[StatementGoal]] = {
    PermissionHelper.preparePermissionChecker(userId)

    val startDate = certificateStateService.getBy(userId, certificateId).get.userJoinedDate
    statementGoalStorage.getByCertificateId(certificateId)
      .map { goal =>
      GoalDeadline(goal, PeriodTypes.getEndDateOption(goal.periodType, goal.periodValue, startDate))
    }
  }

  protected def checkStatementGoal(userId: Long, statementApi: StatementApi, userJoinedDate: DateTime)
                                  (statementGoal: StatementGoal): GoalStatuses.Value = {
    val statements = getStatements(statementGoal, userId, userJoinedDate, statementApi)
    val firstStatementOrNow = statements match {
      case Nil => DateTime.now
      case v => v.map(_.stored.get).min
    }

    val isTimeOut = PeriodTypes
      .getEndDate(statementGoal.periodType, statementGoal.periodValue, userJoinedDate)
      .isBefore(firstStatementOrNow)
    lazy val isGoalCompleted = statements.nonEmpty

    if (isTimeOut) GoalStatuses.Failed
    else if (isGoalCompleted) GoalStatuses.Success
    else GoalStatuses.InProgress
  }

  private def getStatements(certificateStatementGoal: StatementGoal, userId: Long, afterDate: DateTime,
                            statementApi: StatementApi): Seq[Statement] = {
    val agent = TincanHelper.getAgentByEmail(UserLocalServiceUtil.getUser(userId).getEmailAddress)
    val filter = StatementFilter(
      agent = Option(agent),
      activity = Option(certificateStatementGoal.obj),
      verb = Option(certificateStatementGoal.verb),
      relatedActivities = Option(true))

    statementApi.getByFilter(filter)
      .filter(_.stored.get.isAfter(afterDate))
  }

  private def getMaxStatementDate(certificateStatementGoal: StatementGoal, userId: Int, afterDate: DateTime,
                                  statementApi: StatementApi): DateTime = {
    val statements = getStatements(certificateStatementGoal, userId, afterDate, statementApi)
    if (statements.isEmpty) throw new IllegalStateException("Required statement doesn't exist, but goal is completed")
    else statements.map(_.stored.get).min
  }
}