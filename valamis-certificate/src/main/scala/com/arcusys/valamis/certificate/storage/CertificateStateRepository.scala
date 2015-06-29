package com.arcusys.valamis.certificate.storage

import com.arcusys.valamis.certificate.model.{CertificateStateFilter, CertificateStatus, Certificate, CertificateState}
import org.joda.time.DateTime

trait CertificateStateRepository {
  def create(state: CertificateState): CertificateState
  def getBy(userId: Long, certificateId: Long): Option[CertificateState]
  def getBy(certificateStateFilter: CertificateStateFilter): Seq[CertificateState]
  def update(certificateStatusEntity: CertificateState): CertificateState
  def delete(userId: Long, certificateId: Long)
  def delete(certificateStatusEntities: Seq[CertificateState])
}
