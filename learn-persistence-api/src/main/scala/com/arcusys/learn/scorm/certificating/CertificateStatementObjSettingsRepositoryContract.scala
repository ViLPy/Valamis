package com.arcusys.learn.scorm.certificating

import com.arcusys.learn.repositories.{ MutableEntityRepository, SelectEntityRepository }
import com.arcusys.learn.scorm.tracking.model.certificating.models.CertificateStatementObjSettings

trait CertificateStatementObjSettingsRepositoryContract extends MutableEntityRepository[CertificateStatementObjSettings] with SelectEntityRepository[CertificateStatementObjSettings] {
  def getByCertificateId(certificateId: Int): Seq[CertificateStatementObjSettings]
  def getByCertificateIdCount(certificateId: Int): Int
}
