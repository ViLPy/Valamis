package com.arcusys.learn.scorm.certificating.impl

import java.security.InvalidParameterException

import com.arcusys.learn.persistence.liferay.model.LFCertificateCourse
import com.arcusys.learn.persistence.liferay.service.LFCertificateCourseLocalServiceUtil
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateCoursePK
import com.arcusys.learn.scorm.certificating.CertificateCourseSettingsRepositoryContract
import com.arcusys.learn.scorm.tracking.model.certificating.models.CertificateCourseSettings

import com.arcusys.learn.scorm.manifest.model.PeriodType
import scala.collection.JavaConverters._

/**
 * Created by Iliya Tryapitsin on 14.05.2014.
 */
class CertificateCourseSettingsRepository extends CertificateCourseSettingsRepositoryContract {

  private def toCertificateCourseSettings(storageEntity: LFCertificateCourse) = {
    CertificateCourseSettings(
      storageEntity.getCertificateID.toInt,
      storageEntity.getCourseID.toInt,
      Some(storageEntity.getPeriod),
      Some(PeriodType(storageEntity.getPeriodType)),
      if (storageEntity.getArrangementIndex == null) 0 else storageEntity.getArrangementIndex)
  }

  override def get(keys: (String, Any)*): CertificateCourseSettings = keys match {
    case Seq(("certificateId", certificateId: Int), ("courseId", courseId: Int)) => {
      val storageEntity = LFCertificateCourseLocalServiceUtil
        .findByCertificateIDAndSiteID(certificateId, courseId)
      toCertificateCourseSettings(storageEntity)
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
    storageEntity.setArrangementIndex(entity.arrangementIndex)

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
    case Seq(("certificateId", certificateId: Int)) => getByCertificateId(certificateId)

    case Seq(("courseId", courseId: Int)) => {
      LFCertificateCourseLocalServiceUtil
        .findByCourseID(courseId)
        .asScala
        .map(c => toCertificateCourseSettings(c))
        .sortBy(_.arrangementIndex)
    }

    case _ => throw new InvalidParameterException()
  }

  def getByCertificateId(certificateId: Int): Seq[CertificateCourseSettings] = {
    LFCertificateCourseLocalServiceUtil
      .findByCertificateID(certificateId.toLong)
      .asScala
      .map(c => toCertificateCourseSettings(c))
      .sortBy(_.arrangementIndex)
  }

  def getByCertificateIdCount(certificateId: Int): Int = {
    LFCertificateCourseLocalServiceUtil.findByCertificateID(certificateId.toLong).size()
  }
}
