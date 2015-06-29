package com.arcusys.learn.models.response.users

import com.arcusys.learn.models.response.certificates.{ CertificateResponseContract }

case class UserWithCertificatesResponse(id: Long,
  name: String,
  picture: String = "",
  pageUrl: String = "",
  certificates: Seq[CertificateResponseContract])
