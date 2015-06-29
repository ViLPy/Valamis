package com.arcusys.learn.models.response.certificates

import com.arcusys.valamis.user.model.User

case class CertificateSuccessUsersResponse(
  id: Int,
  title: String,
  shortDescription: String,
  description: String,
  logo: String,
  succeedUsers: Seq[User])

