package com.arcusys.learn.scorm.tracking.model.certificating

import com.arcusys.learn.scorm.manifest.model.PeriodType
import org.joda.time.DateTime
import PeriodType.PeriodType

/**
 * Certificate to be passed by user. Contains list of sites.
 *
 * @param id                  Unique internal ID
 * @param title               Short title
 * @param description         More detailed description
 */
case class Certificate(id: Int,
    title: String,
    description: String,
    logo: String = "",
    isPermanent: Boolean = true,
    isPublishBadge: Boolean = false,
    shortDescription: String = "",
    companyId: Int,
    validPeriodType: PeriodType = PeriodType.UNLIMITED,
    validPeriod: Int = 0,
    createdAt: DateTime,
    isPublished: Boolean = false,
    scope: Option[Long] = None) {
}

object CertificateActionType extends Enumeration {
  type CertificateActionType = Value
  val NEW = Value(2)
  val PASSED = Value(1)
}

object CertificateValidStatus extends Enumeration {
  type CertificateValidStatus = Value
  val Valid = Value(0)
  val Expired = Value(1)
  val Invalid = Value(3)
}

case class CertificateValidation(status: CertificateValidStatus.Value = CertificateValidStatus.Invalid,
  expireDate: Option[DateTime] = None)

case class CertificatePage(
  certificates: Seq[Certificate],
  total: Int)

