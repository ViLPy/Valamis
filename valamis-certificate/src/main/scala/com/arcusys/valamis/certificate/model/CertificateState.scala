package com.arcusys.valamis.certificate.model

import org.joda.time.DateTime

case class CertificateState(
  userId: Long,
  status: CertificateStatus.Value,
  statusAcquiredDate: DateTime,
  userJoinedDate: DateTime,
  certificateId: Long
)