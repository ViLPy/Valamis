package com.arcusys.learn.scorm.certificating.impl

import com.arcusys.learn.MutableEntityRepository
import com.arcusys.learn.scorm.tracking.model.certificating.{ PeriodType }
import com.arcusys.learn.persistence.liferay.service.{ LFCertificateTincanStatementLocalServiceUtil }
import java.security.InvalidParameterException
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateTincanStatementPK
import scala.collection.JavaConverters._
import com.arcusys.learn.scorm.certificating.models.CertificateStatementObjSettings
import com.arcusys.learn.scorm.certificating.CertificateStatementObjSettingsRepositoryContract

/**
 * Created by Iliya Tryapitsin on 14.05.2014.
 */
class CertificateStatementObjSettingsRepository extends CertificateStatementObjSettingsRepositoryContract {

  override def get(keys: (String, Any)*): CertificateStatementObjSettings = keys match {
    case Seq(("certificateId", certificateId: Int), ("verb", verb: String), ("obj", obj: String)) => {
      val storageEntity = LFCertificateTincanStatementLocalServiceUtil
        .findByCertificateIDAndVerbAndObject(certificateId, verb, obj)

      CertificateStatementObjSettings(
        storageEntity.getCertificateID.toInt,
        storageEntity.getVerb,
        storageEntity.getObject,
        Some(storageEntity.getPeriod),
        Some(PeriodType(storageEntity.getPeriodType)))
    }

    case _ => throw new InvalidParameterException()
  }

  override def delete(parameters: (String, Any)*) = parameters match {
    case Seq(("certificateId", certificateId: Int), ("verb", verb: String), ("obj", obj: String)) => {
      val storageEntity = LFCertificateTincanStatementLocalServiceUtil
        .findByCertificateIDAndVerbAndObject(certificateId, verb, obj)

      LFCertificateTincanStatementLocalServiceUtil.deleteLFCertificateTincanStatement(storageEntity)
    }

    case _ => throw new InvalidParameterException()
  }

  override def modify(entity: CertificateStatementObjSettings): CertificateStatementObjSettings = {
    val storageEntity = LFCertificateTincanStatementLocalServiceUtil.findByCertificateIDAndVerbAndObject(entity.certificateId, entity.verb, entity.obj)

    storageEntity.setPeriod(entity.value.get)
    storageEntity.setPeriodType(entity.period.getOrElse(PeriodType.UNLIMITED).toString)

    LFCertificateTincanStatementLocalServiceUtil.updateLFCertificateTincanStatement(storageEntity)
    entity.copy()
  }

  override def create(entity: CertificateStatementObjSettings): CertificateStatementObjSettings = {
    val storageEntity = LFCertificateTincanStatementLocalServiceUtil.createLFCertificateTincanStatement(
      new LFCertificateTincanStatementPK(entity.certificateId, entity.verb, entity.obj))

    storageEntity.setPeriod(entity.value.getOrElse(0).toInt)
    storageEntity.setPeriodType(entity.period.getOrElse(PeriodType.UNLIMITED).toString)

    LFCertificateTincanStatementLocalServiceUtil.addLFCertificateTincanStatement(storageEntity)

    entity.copy()
  }

  override def select(keys: (String, Any)*): Seq[CertificateStatementObjSettings] = keys match {
    case Seq(("certificateId", certificateId: Int)) => {
      LFCertificateTincanStatementLocalServiceUtil
        .findByCertificateID(certificateId)
        .asScala
        .map(c => CertificateStatementObjSettings(
          c.getCertificateID.toInt,
          c.getVerb,
          c.getObject,
          Some(c.getPeriod),
          Some(PeriodType(c.getPeriodType))))
    }

    case Seq(("verb", verb: String), ("obj", obj: String)) => {
      LFCertificateTincanStatementLocalServiceUtil
        .findByVerbAndObject(verb, obj)
        .asScala
        .map(c => CertificateStatementObjSettings(
          c.getCertificateID.toInt,
          c.getVerb,
          c.getObject,
          Some(c.getPeriod),
          Some(PeriodType(c.getPeriodType))))
    }

    case _ => throw new InvalidParameterException()
  }
}
