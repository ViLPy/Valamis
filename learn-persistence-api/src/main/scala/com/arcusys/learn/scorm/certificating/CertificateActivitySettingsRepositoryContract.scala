package com.arcusys.learn.scorm.certificating

import com.arcusys.learn.repositories.{ MutableEntityRepository, SelectEntityRepository }
import com.arcusys.learn.scorm.tracking.model.certificating.models.CertificateActivitySettings

trait CertificateActivitySettingsRepositoryContract extends MutableEntityRepository[CertificateActivitySettings] with SelectEntityRepository[CertificateActivitySettings] {
  def getByCertificateId(certificateId: Int): Seq[CertificateActivitySettings]
  def getByCertificateIdCount(certificateId: Int): Int
}
