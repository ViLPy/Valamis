package com.arcusys.learn.scorm.certificating.models

import com.arcusys.learn.persistence.liferay.model.LFCertificate
import com.arcusys.learn.scorm.manifest.model.PeriodType
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate
import org.joda.time.DateTime

import scala.util.{ Failure, Success, Try }

/**
 * Created by Iliya Tryapitsin on 15.05.2014.
 */
object CertificateEntityFactory {
  def apply(lfCertificate: LFCertificate) = {
    val scope = Try(lfCertificate.getScope.toLong) match {
      case Success(value) => Some(value)
      case Failure(_)     => None
    }

    Certificate(
      lfCertificate.getId.toInt,
      lfCertificate.getTitle,
      lfCertificate.getDescription,
      lfCertificate.getLogo,
      lfCertificate.getIsPermanent,
      lfCertificate.getPublishBadge,
      lfCertificate.getShortDescription,
      lfCertificate.getCompanyID,
      PeriodType(Option(lfCertificate.getValidPeriodType)),
      lfCertificate.getValidPeriod,
      new DateTime(lfCertificate.getCreatedDate),
      lfCertificate.getIsPublished,
      scope)
  }

  def toLFCertificate(certificate: Certificate, lFCertificate: LFCertificate): LFCertificate = {
    lFCertificate.setTitle(certificate.title)
    lFCertificate.setDescription(certificate.description)
    lFCertificate.setLogo(certificate.logo)
    lFCertificate.setIsPermanent(certificate.isPermanent)
    lFCertificate.setPublishBadge(certificate.isPublishBadge)
    lFCertificate.setShortDescription(certificate.shortDescription)
    lFCertificate.setCompanyID(certificate.companyId)
    lFCertificate.setValidPeriod(certificate.validPeriod)
    lFCertificate.setValidPeriodType(certificate.validPeriodType.toString)
    lFCertificate.setIsPublished(certificate.isPublished)
    lFCertificate.setScope(Try(certificate.scope.get) match {
      case Success(value) => value
      case Failure(_)     => null
    })
    lFCertificate.setCreatedDate(certificate.createdAt.toDate)

    lFCertificate
  }
}
