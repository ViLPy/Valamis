package com.arcusys.learn.facades

import com.arcusys.learn.models.report._
import com.arcusys.learn.tincan.model.Statement
import com.arcusys.learn.models.report.OverallByPeriodResponse
import com.arcusys.learn.models.report.VerbResponse
import com.arcusys.learn.models.report.StudentMostActiveResponse
import com.arcusys.learn.models.report.OverallByTimeResponse
import com.arcusys.learn.models.response.CollectionResponse

abstract trait ReportFacadeContract {
  def getParticipantReport(groupBy: String): Seq[ParticipantResponse]

  def getStudentsLeaderboard(period: String, offset: Int, amount: Int): CollectionResponse[StudentMostActiveResponse]

  def getStatementVerbs(): VerbResponse

  def getOverallByTime(): OverallByTimeResponse

  def getOverallByPeriod(period: String, from: Long, to: Long): OverallByPeriodResponse

  def getCourseEvent(group: String, groupPeriod: Option[String], period: String, from: Long, to: Long): Seq[CourseEventResponse]

  def getUserLatestStatements(currentUserID: Int, offset: Int, amount: Int): CollectionResponse[Statement]

  def getStudentsLatestStatements(currentUserID: Int, offset: Int, amount: Int): CollectionResponse[Statement]

  def getMostActive(currentUserID: Int, offset: Int, amount: Int): CollectionResponse[StudentMostActiveResponse]

  def getCourseReport(isInstanceScope: Boolean, courseID: Option[Int]): CourseReportResponse

}
