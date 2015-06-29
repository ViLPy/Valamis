package com.arcusys.valamis.certificate.service

import com.arcusys.valamis.certificate.model.{CertificateStateFilter, CertificateStatus, CertificateState}
import com.arcusys.valamis.certificate.storage.CertificateStateRepository
import com.escalatesoft.subcut.inject.{Injectable, BindingModule}

trait CertificateStateService {
  def create(certificateState: CertificateState): CertificateState
  def getBy(userId: Long, certificateId: Long): Option[CertificateState]
  def getBy(filter: CertificateStateFilter): Seq[CertificateState]
  def update(certificateState: CertificateState): CertificateState
  def delete(userId: Long, certificateId: Long)
  def delete(certificateAccomplishmentEntities: Seq[CertificateState])
}


class CertificateStateServiceImpl(implicit val bindingModule: BindingModule) extends Injectable with CertificateStateService {
  lazy val certificateStatusRepository = inject[CertificateStateRepository]
  lazy val certificateCompletionChecker = inject[CertificateCompletionChecker]

  def create(certificateState: CertificateState) = certificateStatusRepository.create(certificateState)
  def getBy(userId: Long, certificateId: Long) = certificateStatusRepository.getBy(userId, certificateId)
  def getBy(filter: CertificateStateFilter) = {
    certificateCompletionChecker.toggleRequestedCertificatesStatus(userId = filter.userId)
    certificateStatusRepository.getBy(CertificateStateFilter(filter.userId, filter.certificateId, filter.statuses))
  }
  def update(certificateState: CertificateState) = certificateStatusRepository.update(certificateState)
  def delete(userId: Long, certificateId: Long) = certificateStatusRepository.delete(userId, certificateId)
  def delete(certificateStatusEntities: Seq[CertificateState]) = certificateStatusRepository.delete(certificateStatusEntities)
}