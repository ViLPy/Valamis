package com.arcusys.learn.models.response.certificates

import com.arcusys.learn.models.CourseResponse

case class PackageGoalResponse(
  certificateId: Long,
  packageId: Long,
  title: String,
  value: Int,
  period: String,
  course: CourseResponse)

case class StatementGoalResponse(
  certificateId: Long,
  tincanStmntObj: String,
  tincanStmntVerb: String,
  value: Int,
  period: String)

case class ActivityGoalResponse(
  certificateId: Int,
  activityCount: Int,
  title: String,
  value: Int,
  period: String)

case class CourseGoalResponse(id: Long,
  certificateId: Long,
  title: String,
  url: String,
  value: Int,
  period: String,
  arrangementIndex: Int,
  lessonsAmount: Int)