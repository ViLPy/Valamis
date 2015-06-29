package com.arcusys.learn.models.response.social

import com.arcusys.learn.models.CourseResponse

object Activities extends Enumeration{
  val Lesson, Course, Certificate, UserStatus = Value
}

sealed trait ActivityObjectResponse{
  def tpe: Activities.Value
}

case class ActivityPackageResponse(
  id: Long,
  title: String,
  logo: Option[String],
  course: CourseResponse,
  comment: Option[String],
  tpe: Activities.Value = Activities.Lesson
) extends ActivityObjectResponse

case class ActivityCourseResponse(
  id: Long,
  title: String,
  tpe: Activities.Value = Activities.Course
) extends ActivityObjectResponse

case class ActivityCertificateResponse(
  id: Long,
  title: String,
  logo: Option[String],
  tpe: Activities.Value = Activities.Certificate
) extends ActivityObjectResponse

case class ActivityUserStatusResponse(
  comment: String,
  tpe: Activities.Value = Activities.UserStatus
) extends ActivityObjectResponse