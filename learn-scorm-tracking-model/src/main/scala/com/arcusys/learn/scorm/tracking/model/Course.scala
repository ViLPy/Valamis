package com.arcusys.learn.scorm.tracking.model

import org.joda.time._

@deprecated // Rename to user grade
case class Course(
  courseID: Int,
  userID: Int,
  grade: String,
  comment: String,
  date: Option[DateTime] = None)
