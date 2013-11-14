package com.arcusys.learn.scorm.tracking.model.certificating

import org.joda.time.DateTime

/**
 * Certificate to be passed by user. Contains list of sites.
 *
 * @param id                  Unique internal ID
 * @param title               Short title
 * @param description         More detailed description
 */
case class Certificate
(
  id: Int,
  title: String,
  description: String,
  logo: String = "",
  isPermanent: Boolean = true,
  publishBadge: Boolean = false,
  shortDescription: String = "",
  companyId: Int
  )


object CertificateActionType extends Enumeration {
  type CertificateActionType = Value
  val NewCertificate = Value(2)
  val PassedCertificate = Value(1)
}

object CertificateValidStatus extends Enumeration {
  type CertificateValidStatus = Value
  val Valid = Value(0)
  val Expired = Value(1)
  val Invalid = Value(3)
}

case class CertificateValidation(
                                  status: CertificateValidStatus.Value = CertificateValidStatus.Invalid,
                                  expireDate: Option[DateTime] = None
                                  )

case class CertificatePage(
  certificates: Seq[Certificate],
  total: Int
)