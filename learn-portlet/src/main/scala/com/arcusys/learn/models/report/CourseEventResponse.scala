package com.arcusys.learn.models.report

case class CourseEventResponse(
  var enrollmentsCount: Int,
  var completionsCount: Int,
  groupName: String)
