package com.arcusys.learn.facades.certificate

import java.io.{ File, InputStream }

import com.arcusys.valamis.certificate.model.{CertificateStateFilter, CertificateStatus, CertificateSortBy}
import CertificateSortBy.CertificateSortBy
import com.arcusys.learn.facades.CertificateFacadeContract
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.response.CollectionResponse
import com.arcusys.learn.models.response.certificates.{ CertificateResponse, _ }
import com.arcusys.valamis.certificate.service.{CertificateStateService, CertificateService}
import com.arcusys.valamis.certificate.service.export.{ CertificateImportProcessor, CertificateExportProcessor }
import com.arcusys.valamis.certificate.storage.CertificateRepository
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class CertificateFacade(
    configuration: BindingModule)
  extends Injectable
  with CertificateFacadeContract
  with CertificateResponseFactory
  with CertificateGoals
  with CertificateUsers {

  def this() = this(Configuration)
  implicit val bindingModule = configuration

  // TODO remove primary storage usnig
  private lazy val certificateRepository = inject[CertificateRepository]
  private lazy val certificateService = inject[CertificateService]
  private lazy val certificateStateService = inject[CertificateStateService]

  def getAll(companyId: Int, scope: Option[Long], page: Int, pageSize: Int, titleFilter: String, sortBy: CertificateSortBy,
    isSortDirectionAsc: Boolean, isShortResult: Boolean): CollectionResponse[CertificateResponseContract] = {
    val skip = (page - 1) * pageSize
    val certificates = certificateService.getAll(companyId, scope, skip, pageSize, titleFilter, sortBy, isSortDirectionAsc)
      .map(toCertificateResponse(isShortResult)).toSeq
    val certificatesCount = certificateService.allCount(companyId, titleFilter, scope)

    CollectionResponse(page, certificates, certificatesCount)
  }

  def create(companyId: Int, title: String, description: String): CertificateResponseContract = {
    val c = certificateService.create(companyId, title, description)
    toCertificateResponse(c)
  }

  def getById(certificateId: Int): CertificateResponse = {
    val c = certificateService.getById(certificateId)
    toCertificateResponse(c)
  }

  def getByCompanyAndTitleWithSucceedUsers(companyId: Long, title: String) = {
    val certificates = certificateService.getBy(companyId = companyId, title = Some(title))

    certificates
      .map(toCertificateSuccessUsersResponse)
      .flatten
  }

  def change(id: Int, title: String, description: String, validPeriodType: String, validPeriodValue: Option[Int], isOpenBadgesIntegration: Boolean,
    shortDescription: String = "", companyId: Int, scope: Option[Long]): CertificateResponseContract = {
    val c = certificateService.update(id, title, description, validPeriodType, validPeriodValue, isOpenBadgesIntegration, shortDescription, companyId, scope)
    toCertificateResponse(c)
  }

  def changeLogo(id: Int, newLogo: String = "") {
    certificateService.changeLogo(id, newLogo)
  }

  def delete(id: Int) = {
    certificateService.delete(id)
  }

  def clone(certificateId: Int): CertificateResponse = {
    val c = certificateService.clone(certificateId)
    toCertificateResponse(c)
  }

  def publish(certificateId: Int): CertificateResponse = {
    val certificate = certificateService.publish(certificateId)
    toCertificateResponse(certificate)
  }

  def unpublish(certificateId: Int): CertificateResponse = {
    val certificate = certificateService.unpublish(certificateId)
    toCertificateResponse(certificate)
  }

  def exportCertificate(companyId: Int, certificateId: Int): InputStream = {
    new CertificateExportProcessor().exportItems(Seq(certificateRepository.getById(certificateId)))
  }

  def exportCertificates(companyId: Int): InputStream = {
    new CertificateExportProcessor().exportItems(certificateRepository.getBy(companyId = companyId))
  }

  def importCertificates(file: File, companyId: Int): Unit = {
    new CertificateImportProcessor().importItems(file, companyId)
  }

//  def getAvailableStatements(statementApi: StatementApi, page: Int, skip: Int, take: Int, filter: String, isSortDirectionAsc: Boolean): CollectionResponse[AvailableStatementResponse] = {
//    val resp = certificateService.getAvailableStatements(statementApi ,page, skip, take, filter, isSortDirectionAsc)
//    val inPage = resp.items
//      .map { s =>
//        AvailableStatementResponse(s._1.id, s._1.display, s._2._1, s._2._2)
//      }
//
//    CollectionResponse(page, inPage, resp.total)
//  }

  def getStatesBy(userId: Long,
                  statuses: Set[CertificateStatus.Value]) = {
    val certificateStates = certificateStateService.getBy(CertificateStateFilter(userId = Some(userId), statuses = statuses))
    val certificates = certificateService.getByIds(certificateStates.map(_.certificateId).toSet).map(c => c.id.toLong -> c).toMap

    certificateStates.map(toStateResponse(certificates))
  }
}
