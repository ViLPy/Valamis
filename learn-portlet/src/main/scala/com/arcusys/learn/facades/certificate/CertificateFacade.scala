package com.arcusys.learn.facades.certificate

import java.io.InputStream
import com.arcusys.learn.bl.services.CertificateServiceContract
import com.arcusys.learn.facades.CertificateFacadeContract
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models._
import com.arcusys.learn.models.response.CollectionResponse
import com.arcusys.learn.models.response.certificates.{ CertificateResponse, _ }
import com.arcusys.learn.tincan.model._
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import com.arcusys.learn.bl.models.certificates.CertificateSortBy.CertificateSortBy
import com.arcusys.learn.scorm.manifest.model.PeriodType

class CertificateFacade(configuration: BindingModule) extends Injectable with CertificateFacadeContract
    with CertificateResponseFactory with CertificateGoals with CertificateUsers {

  def this() = this(Configuration)
  implicit val bindingModule = configuration

  private lazy val certificateService = inject[CertificateServiceContract]

  def getAll(companyID: Int, skip: Int, take: Int, titleFilter: String, sortBy: CertificateSortBy,
    isSortDirectionAsc: Boolean, isShortResult: Boolean): Seq[CertificateResponseContract] = {
    certificateService.getAll(companyID, skip, take, titleFilter, sortBy, isSortDirectionAsc)
      .map(toCertificateResponse(isShortResult)).toSeq
  }

  def allCount(companyID: Int, titleFilter: String): Int = {
    certificateService.allCount(companyID, titleFilter)
  }

  def create(companyId: Int, title: String, description: String): CertificateResponseContract = {
    val c = certificateService.create(companyId, title, description)
    toCertificateResponse(c)
  }

  def getById(certificateId: Int): CertificateResponse = {
    val c = certificateService.getById(certificateId)
    toCertificateResponse(c)
  }

  def change(id: Int, title: String, description: String, validPeriodType: String, validPeriodValue: Option[Int], isOpenBadgesIntegration: Boolean,
    shortDescription: String = "", companyId: Int, scope: Option[Long]): CertificateResponseContract = {
    val c = certificateService.change(id, title, description, validPeriodType, validPeriodValue, isOpenBadgesIntegration, shortDescription, companyId, scope)
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
    certificateService.exportCertificate(companyId, certificateId)
  }

  def exportCertificates(companyId: Int): InputStream = {
    certificateService.exportCertificates(companyId)
  }

  def importCertificates(filename: String, companyID: Int): Unit = {
    certificateService.importCertificates(filename, companyID)
  }

  def getAvailableStatements(page: Int, skip: Int, take: Int, filter: String, isSortDirectionAsc: Boolean): CollectionResponse[AvailableStatementResponse] = {
    val resp = certificateService.getAvailableStatements(page, skip, take, filter, isSortDirectionAsc)
    val inPage = resp.items.map(s =>
      AvailableStatementResponse(s.verb.id, s.verb.display, s.obj.asInstanceOf[Activity].id, s.obj.asInstanceOf[Activity].name.getOrElse(Map[String, String]())))

    CollectionResponse(page, inPage, resp.total)
  }
}
