package com.arcusys.learn.facades

import com.arcusys.learn.models.report._
import com.arcusys.learn.models.report.OverallByPeriodResponse
import com.arcusys.learn.models.report.VerbResponse
import com.arcusys.learn.models.report.StudentMostActiveResponse
import com.arcusys.learn.models.report.OverallByTimeResponse
import com.arcusys.learn.models.response.CollectionResponse
import com.arcusys.valamis.lrs.api.StatementApi
import com.arcusys.valamis.lrs.api.valamis.VerbApi
import com.arcusys.valamis.lrs.tincan.Statement

trait ReportFacadeContract {
  def getParticipantReport(groupBy: String): Seq[ParticipantResponse]

  def getStudentsLeaderboard(statementApi: StatementApi, period: String, offset: Int, amount: Int): CollectionResponse[StudentMostActiveResponse]

  def getStatementVerbs(statementApi: StatementApi): VerbResponse

  def getOverallByTime(verbApi: VerbApi): OverallByTimeResponse

  def getOverallByPeriod(statementApi: StatementApi, period: String, from: Long, to: Long): OverallByPeriodResponse

  def getCourseEvent(group: String, groupPeriod: Option[String], period: String, from: Long, to: Long): Seq[CourseEventResponse]

  def getUserLatestStatements(statementApi: StatementApi, currentUserID: Int, offset: Int, amount: Int): CollectionResponse[Statement]

  def getStudentsLatestStatements(statementApi: StatementApi, currentUserID: Int, offset: Int, amount: Int): CollectionResponse[Statement]

  def getMostActive(statementApi: StatementApi, currentUserID: Int, offset: Int, amount: Int): CollectionResponse[StudentMostActiveResponse]

  def getCourseReport(statementApi: StatementApi, isInstanceScope: Boolean, courseID: Option[Int]): CourseReportResponse

}
