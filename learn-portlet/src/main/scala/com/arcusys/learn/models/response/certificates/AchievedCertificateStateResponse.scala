package com.arcusys.learn.models.response.certificates

import com.arcusys.valamis.certificate.model.CertificateStatus
import org.joda.time.DateTime

case class AchievedCertificateStateResponse(
  id: Int,
  title: String,
  description: String,
  logo: String = "",
  status: CertificateStatus.Value,
  endDate: Option[DateTime]
)
