package com.arcusys.valamis.certificate.service.export

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
  courses: Seq[CourseGoalExport],
  statements: Seq[StatementGoalExport],
  packages: Seq[PackageGoalExport],
  activities: Seq[ActivityGoalExport])

case class CourseGoalExport(
  title: String,
  url: String,
  value: Int,
  period: String,
  arrangementIndex: Int)

case class StatementGoalExport(
  tincanStmntObj: String,
  tincanStmntVerb: String,
  value: Int,
  period: String)

case class PackageGoalExport(
  packageId: Long,
  value: Int,
  period: String)

case class ActivityGoalExport(
  activityCount: Int,
  name: String,
  value: Int,
  period: String)
