package com.arcusys.learn.models.request

object ReportActionType extends Enumeration {
  type ReportActionType = Value

  val StatementVerbs = Value("STATEMENT_VERBS")
  val MostActiveUsers = Value("MOST_ACTIVE_USERS")
  val UserLatestStatements = Value("USER_LATEST_STATEMENTS")
  val UserAllStatements = Value("USER_ALL_STATEMENTS")
  val StudentsLatestStatements = Value("STUDENTS_LATEST_STATEMENTS")
  val OverallByTime = Value("OVERALL_BY_TIME")
  val OverallByPeriod = Value("OVERALL_BY_PERIOD")
  val Leaderboard = Value("LEADERBOARD")
  val Course = Value("COURSE")
  val CourseEvent = Value("COURSE_EVENT")
  val Participants = Value("PARTICIPANTS")
}
