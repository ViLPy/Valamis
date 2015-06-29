package com.arcusys.learn.models.response.certificates

/**
 * Created by Iliya Tryapitsin on 02.06.2014.
 */
case class CertificateWithUserStatusResponse(id: Int,
  title: String,
  shortDescription: String,
  description: String,
  logo: String,
  isPublished: Boolean,
  courseCount: Int,
  statementCount: Int,
  activityCount: Int,
  packageCount: Int,
  userCount: Int,
  status: String) extends CertificateResponseContract
