package com.arcusys.learn.scorm.tracking.model

import org.joda.time._

case class CourseGrade(
  courseID: Int,
  userID: Int,
  grade: String,
  comment: String,
  date: Option[DateTime] = None)
