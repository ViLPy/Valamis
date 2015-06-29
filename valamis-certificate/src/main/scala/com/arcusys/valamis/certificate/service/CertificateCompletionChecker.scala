package com.arcusys.valamis.certificate.service

import com.arcusys.valamis.certificate.model.CertificateStatus._
import com.arcusys.valamis.certificate.model.{CertificateStateFilter, CertificateStatus}
import com.arcusys.valamis.certificate.storage.CertificateStateRepository
import com.arcusys.valamis.lrs.service.LrsClientManager
import com.arcusys.valamis.lrs.tincan.AuthorizationScope
import com.escalatesoft.subcut.inject.{BindingModule, Injectable}

trait CertificateCompletionChecker {
  def toggleRequestedCertificatesStatus(statuses: Set[CertificateStatus.Value] = all, userId: Option[Long] = None): Unit
}

class CertificateCompletionCheckerImpl(
    implicit val bindingModule: BindingModule)
  extends CertificateCompletionChecker
  with Injectable {
  val certificateStateRepository = inject[CertificateStateRepository]
  val lrsReader = inject[LrsClientManager]
  val certificateStatusChecker = inject[CertificateStatusChecker]

  def toggleRequestedCertificatesStatus(statuses: Set[CertificateStatus.Value] = CertificateStatus.all,
                                        userId: Option[Long] = None): Unit = {
    val certificateStates = certificateStateRepository.getBy(CertificateStateFilter(userId = userId, statuses = statuses))

    certificateStates.foreach(certificateState =>
      lrsReader.statementApi(statementApi =>
        certificateStatusChecker.getStatus(statementApi, certificateState.certificateId.toInt, certificateState.userId.toInt),
        lrsReader.getLrsEndpointInfo(AuthorizationScope.AllRead).auth))
  }
}