package com.arcusys.learn.models.response.users

import com.arcusys.learn.models.response.certificates.{ CertificateResponseContract }

/**
 * Created by Iliya Tryapitsin on 12.03.14.
 */
case class UserResponse(id: Long,
  name: String,
  picture: String = "",
  pageUrl: String = "",
  certificates: Seq[CertificateResponseContract])
