package com.arcusys.valamis.certificate.service

import com.arcusys.valamis.certificate.model.CertificateStatus.CertificateStatus
import com.arcusys.valamis.certificate.model.goal._
import com.arcusys.valamis.lrs.api.StatementApi

trait CertificateStatusChecker
  extends CourseGoalStatusChecker
  with ActivityGoalStatusChecker
  with StatementGoalStatusChecker
  with PackageGoalStatusChecker {
  def getStatus(statementApi: StatementApi, certificateId: Int, userId: Int): CertificateStatus
}

protected[service] trait CourseGoalStatusChecker{
  def getCourseGoalsStatus(certificateId: Int, userId: Int): Seq[GoalStatus[CourseGoal]]
  def getCourseGoalsDeadline(certificateId: Int, userId: Int): Seq[GoalDeadline[CourseGoal]]
}

protected[service] trait ActivityGoalStatusChecker{
  def getActivityGoalsStatus(certificateId: Int, userId: Int): Seq[GoalStatus[ActivityGoal]]
  def getActivityGoalsDeadline(certificateId: Int, userId: Int): Seq[GoalDeadline[ActivityGoal]]
}

protected[service] trait StatementGoalStatusChecker{
  def getStatementGoalsStatus(statementApi: StatementApi, certificateId: Int, userId: Int): Seq[GoalStatus[StatementGoal]]
  def getStatementGoalsDeadline(certificateId: Int, userId: Int): Seq[GoalDeadline[StatementGoal]]
}

protected[service] trait PackageGoalStatusChecker{
  def getPackageGoalsStatus(statementApi: StatementApi, certificateId: Int, userId: Int): Seq[GoalStatus[PackageGoal]]
  def getPackageGoalsDeadline(certificateId: Int, userId: Int): Seq[GoalDeadline[PackageGoal]]
}