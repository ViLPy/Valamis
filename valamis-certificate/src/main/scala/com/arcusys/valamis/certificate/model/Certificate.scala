package com.arcusys.valamis.certificate.model

import com.arcusys.valamis.model.PeriodTypes
import com.arcusys.valamis.model.PeriodTypes.PeriodType
import org.joda.time.DateTime

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
    validPeriodType: PeriodType = PeriodTypes.UNLIMITED,
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