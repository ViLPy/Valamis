package com.arcusys.learn.scorm.certificating

import java.security.InvalidParameterException

import com.arcusys.learn.persistence.liferay.service.LFCertificateUserLocalServiceUtil
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateUserPK
import com.arcusys.learn.scorm.tracking.model.certificating.models.CertificateUserSettings
import com.liferay.portlet.dynamicdatalists.RecordSetDuplicateRecordSetKeyException
import org.joda.time.DateTime

import scala.collection.JavaConverters._
import scala.util.Try

/**
 * Created by Iliya Tryapitsin on 14.05.2014.
 */
class CertificateUserSettingsRepository extends CertificateUserSettingsRepositoryContract {

  override def get(keys: (String, Any)*): CertificateUserSettings = keys match {
    case Seq(("certificateId", certificateId: Int), ("userId", userId: Int)) => {
      val storageEntity = LFCertificateUserLocalServiceUtil.findByUserIDAndCertificateID(userId, certificateId)

      CertificateUserSettings(
        userId,
        certificateId,
        new DateTime(storageEntity.getAttachedDate))
    }

    case _ => throw new InvalidParameterException()
  }

  override def delete(parameters: (String, Any)*) = parameters match {
    case Seq(("certificateId", certificateId: Int), ("userId", userId: Int)) => {
      val storageEntity = LFCertificateUserLocalServiceUtil.findByUserIDAndCertificateID(userId, certificateId)
      LFCertificateUserLocalServiceUtil.deleteLFCertificateUser(storageEntity)
    }

    case _ => throw new InvalidParameterException()
  }

  override def create(entity: CertificateUserSettings): CertificateUserSettings = {
    validateDuplicate(entity.certificateId, entity.userId)

    val storageEntity = LFCertificateUserLocalServiceUtil.createLFCertificateUser(
      new LFCertificateUserPK(entity.certificateId, entity.userId))

    storageEntity.setAttachedDate(DateTime.now.toDate)

    LFCertificateUserLocalServiceUtil.addLFCertificateUser(storageEntity)

    entity.copy()
  }

  override def select(keys: (String, Any)*): Seq[CertificateUserSettings] = keys match {
    case Seq(("certificateId", certificateId: Int)) => {
      LFCertificateUserLocalServiceUtil
        .findByCertificateID(certificateId)
        .asScala
        .map(c => CertificateUserSettings(
          c.getCertificateID.toInt,
          c.getUserID.toInt,
          new DateTime(c.getAttachedDate)))
    }

    case Seq(("userId", userId: Int)) => {
      LFCertificateUserLocalServiceUtil
        .findByUserID(userId)
        .asScala
        .map(c => CertificateUserSettings(
          c.getCertificateID.toInt,
          c.getUserID.toInt,
          new DateTime(c.getAttachedDate)))

    }

    case _ => throw new InvalidParameterException()
  }

  private def validateDuplicate(certificateId: Int, userId: Int) = {
    val result = Try(LFCertificateUserLocalServiceUtil.findByUserIDAndCertificateID(certificateId, userId))
      .isSuccess

    if (result)
      throw new RecordSetDuplicateRecordSetKeyException()
  }
}
