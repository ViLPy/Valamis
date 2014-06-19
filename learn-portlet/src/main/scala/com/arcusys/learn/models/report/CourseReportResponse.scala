package com.arcusys.learn.models.report

case class CourseReportResponse(id: Long,
  name: String,
  coursesCount: Int,
  var studentsCount: Int,
  var studentsStartedCount: Int,
  var studentsCompletedCount: Int,
  var studentsIncompletedCount: Int,
  var studentsUnknownCount: Int,
  var studentsPassedCount: Int,
  var studentsFailedCount: Int)
