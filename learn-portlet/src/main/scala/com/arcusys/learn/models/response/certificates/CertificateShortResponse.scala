package com.arcusys.learn.models.response.certificates

import com.arcusys.learn.models.CourseResponse

case class CertificateShortResponse(
  id: Int,
  title: String,
  shortDescription: String,
  description: String,
  logo: String,
  isPublished: Boolean,
  courseCount: Int,
  statementCount: Int,
  activityCount: Int,
  userCount: Int,
  scope: Option[CourseResponse]) extends CertificateResponseContract
