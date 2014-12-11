package com.arcusys.learn.models.request

object ReportActionType extends Enumeration {
  type ReportActionType = Value

  val STATEMENT_VERBS = Value("STATEMENT_VERBS")
  val MOST_ACTIVE_USERS = Value("MOST_ACTIVE_USERS")
  val USER_LATEST_STATEMENTS = Value("USER_LATEST_STATEMENTS")
  val USER_ALL_STATEMENTS = Value("USER_ALL_STATEMENTS")
  val STUDENTS_LATEST_STATEMENTS = Value("STUDENTS_LATEST_STATEMENTS")
  val OVERALL_BY_TIME = Value("OVERALL_BY_TIME")
  val OVERALL_BY_PERIOD = Value("OVERALL_BY_PERIOD")
  val LEADERBOARD = Value("LEADERBOARD")
  val COURSE = Value("COURSE")
  val COURSE_EVENT = Value("COURSE_EVENT")
  val PARTICIPANTS = Value("PARTICIPANTS")
}
