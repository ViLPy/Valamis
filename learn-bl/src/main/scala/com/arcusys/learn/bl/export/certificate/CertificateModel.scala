package com.arcusys.learn.bl.export.certificate

/**
 * Created by mminin on 08.09.14.
 */
case class CertificateExportModel(
  title: String,
  shortDescription: String,
  description: String,
  logo: String,
  isPermanent: Boolean,
  isOpenBadgesIntegration: Boolean,
  validPeriodType: String,
  validPeriod: Int = 0,
  courses: Seq[CourseGoal],
  statements: Seq[StatementGoal],
  activities: Seq[ActivityGoal])

case class CourseGoal(
  title: String,
  url: String,
  value: Option[Int],
  period: Option[String],
  arrangementIndex: Int)

case class StatementGoal(
  tincanStmntObj: String,
  tincanStmntVerb: String,
  value: Option[Int],
  period: Option[String])

case class ActivityGoal(
  activityCount: Int,
  name: String,
  value: Option[Int],
  period: String)
