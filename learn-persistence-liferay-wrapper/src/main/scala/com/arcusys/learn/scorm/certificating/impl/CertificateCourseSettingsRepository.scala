package com.arcusys.learn.scorm.certificating.impl

import com.arcusys.learn.scorm.tracking.model.certificating.PeriodType
import com.arcusys.learn.persistence.liferay.service.LFCertificateCourseLocalServiceUtil
import java.security.InvalidParameterException
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateCoursePK
import scala.collection.JavaConverters._
import com.arcusys.learn.scorm.certificating.models.CertificateCourseSettings
import com.arcusys.learn.scorm.certificating.CertificateCourseSettingsRepositoryContract

/**
 * Created by Iliya Tryapitsin on 14.05.2014.
 */
class CertificateCourseSettingsRepository extends CertificateCourseSettingsRepositoryContract {

  override def get(keys: (String, Any)*): CertificateCourseSettings = keys match {
    case Seq(("certificateId", certificateId: Int), ("courseId", courseId: Int)) => {
      val storageEntity = LFCertificateCourseLocalServiceUtil
        .findByCertificateIDAndSiteID(certificateId, courseId)

      CertificateCourseSettings(
        storageEntity.getCertificateID.toInt,
        storageEntity.getCourseID.toInt,
        Some(storageEntity.getPeriod),
        Some(PeriodType(storageEntity.getPeriodType)))
    }

    case _ => throw new InvalidParameterException()
  }

  override def delete(parameters: (String, Any)*) = parameters match {
    case Seq(("certificateId", certificateId: Int), ("courseId", courseId: Int)) => {
      val storageEntity = LFCertificateCourseLocalServiceUtil
        .findByCertificateIDAndSiteID(certificateId, courseId)

      LFCertificateCourseLocalServiceUtil.deleteLFCertificateCourse(storageEntity)
    }

    case _ => throw new InvalidParameterException()
  }

  override def modify(entity: CertificateCourseSettings): CertificateCourseSettings = {
    val storageEntity = LFCertificateCourseLocalServiceUtil.findByCertificateIDAndSiteID(entity.certificateId, entity.courseId)

    storageEntity.setPeriod(entity.value.get)
    storageEntity.setPeriodType(entity.periodType.getOrElse(PeriodType.UNLIMITED).toString)

    LFCertificateCourseLocalServiceUtil.updateLFCertificateCourse(storageEntity)
    entity.copy()
  }

  override def create(entity: CertificateCourseSettings): CertificateCourseSettings = {
    val storageEntity = LFCertificateCourseLocalServiceUtil.createLFCertificateCourse(
      new LFCertificateCoursePK(entity.certificateId, entity.courseId))

    if (entity.value.isDefined)
      storageEntity.setPeriod(entity.value.get)
    else
      storageEntity.setPeriod(0)

    if (entity.periodType.isDefined)
      storageEntity.setPeriodType(entity.periodType.get.toString)
    else
      storageEntity.setPeriodType(PeriodType.UNLIMITED.toString)

    LFCertificateCourseLocalServiceUtil.addLFCertificateCourse(storageEntity)

    entity.copy()
  }

  override def select(keys: (String, Any)*): Seq[CertificateCourseSettings] = keys match {
    case Seq(("certificateId", certificateId: Int)) => {
      LFCertificateCourseLocalServiceUtil
        .findByCertificateID(certificateId)
        .asScala
        .map(c => CertificateCourseSettings(
          c.getCertificateID.toInt,
          c.getCourseID.toInt,
          Some(c.getPeriod),
          Some(PeriodType(c.getPeriodType))))
    }

    case Seq(("courseId", courseId: Int)) => {
      LFCertificateCourseLocalServiceUtil
        .findByCourseID(courseId)
        .asScala
        .map(c => CertificateCourseSettings(
          c.getCertificateID.toInt,
          c.getCourseID.toInt,
          Some(c.getPeriod),
          Some(PeriodType(c.getPeriodType))))
    }

    case _ => throw new InvalidParameterException()
  }
}
