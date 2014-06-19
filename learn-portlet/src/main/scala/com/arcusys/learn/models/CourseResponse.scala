package com.arcusys.learn.models

/**
 * Created by Iliya Tryapitsin on 12.03.14.
 */
case class CourseResponse(id: Long,
  title: String,
  url: String,
  description: String)

case class CertificateCourseResponse(id: Long,
  certificateId: Int,
  title: String,
  value: Option[Int],
  period: String)