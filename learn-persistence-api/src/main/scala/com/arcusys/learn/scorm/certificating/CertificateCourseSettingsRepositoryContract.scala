package com.arcusys.learn.scorm.certificating

import com.arcusys.learn.repositories.{ MutableEntityRepository, SelectEntityRepository }
import com.arcusys.learn.scorm.tracking.model.certificating.models.CertificateCourseSettings

trait CertificateCourseSettingsRepositoryContract extends MutableEntityRepository[CertificateCourseSettings] with SelectEntityRepository[CertificateCourseSettings] {
  def getByCertificateId(certificateId: Int): Seq[CertificateCourseSettings]
  def getByCertificateIdCount(certificateId: Int): Int
}
