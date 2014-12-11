package com.arcusys.learn.bl.services.certificates

import java.io.InputStream

import com.arcusys.learn.bl.export.certificate.{ CertificateImportProcessor, CertificateExportProcessor }
import com.arcusys.learn.bl.services.{ FileServiceContract, CertificateServiceContract }
import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.bl.models.RangeResult
import com.arcusys.learn.bl.models.certificates.CertificateSortBy
import com.arcusys.learn.bl.models.certificates.CertificateSortBy.CertificateSortBy
import com.arcusys.learn.liferay.services.SocialActivityLocalServiceHelper
import com.arcusys.learn.scorm.certificating._
import com.arcusys.learn.scorm.manifest.model.PeriodType
import com.arcusys.learn.scorm.tracking.model.certificating.models.{ CertificateActivitySettings, CertificateCourseSettings, CertificateStatementObjSettings }
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate
import com.arcusys.learn.tincan.lrs.statement.{ StatementFilter, StatementLRS }
import com.arcusys.learn.tincan.model._
import com.arcusys.learn.tincan.storage.StatementStorage
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import org.joda.time.DateTime

import scala.util.{ Failure, Success, Try }

class CertificateService(configuration: BindingModule) extends Injectable with CertificateServiceContract
    with CertificateGoalService with CertificateUserService {

  def this() = this(DomainConfiguration)

  implicit val bindingModule = configuration

  private lazy val certificateRepository = inject[CertificateRepositoryContract]
  private lazy val certificateUserRepository = inject[CertificateUserRepositoryContract]
  private lazy val certificateCourseRepository = inject[CertificateCourseSettingsRepositoryContract]
  private lazy val certificateActivityRepository = inject[CertificateActivitySettingsRepositoryContract]
  private lazy val certificateTincanStatementRepository = inject[CertificateStatementObjSettingsRepositoryContract]

  def create(companyId: Int, title: String, description: String): Certificate = {
    val certificate = new Certificate(0, title, description, companyId = companyId, createdAt = new DateTime)
    getById(certificateRepository.create(certificate).id)
  }

  def getById(certificateId: Int) = {
    certificateRepository.getById(certificateId)
  }

  def getByCompany(companyID: Int): Seq[Certificate] = {
    certificateRepository.getByCompany(companyID).toSeq
  }

  def getAll(companyID: Int, skip: Int, take: Int, titleFilter: String, sortBy: CertificateSortBy, isSortDirectionAsc: Boolean) = {
    val sortByName = sortBy match {
      case CertificateSortBy.CreationDate => "createdDate"
      case _                              => "title"
    }
    certificateRepository.getByCompanyAndTitle(companyID, titleFilter, sortByName, isSortDirectionAsc, skip, take)
  }

  def allCount(companyID: Int, titleFilter: String): Int = {
    certificateRepository.getCountByCompanyAndTitle(companyID, titleFilter)
  }

  def change(id: Int, title: String, description: String, validPeriodType: String, validPeriodValue: Option[Int], isOpenBadgesIntegration: Boolean,
    shortDescription: String = "", companyId: Int, scope: Option[Long]): Certificate = {
    val certificate = certificateRepository.getById(id)

    val c = if (validPeriodValue.isEmpty || validPeriodValue.get < 1)
      new Certificate(id, title, description, certificate.logo, true, isOpenBadgesIntegration, shortDescription, companyId, PeriodType.UNLIMITED, 0, certificate.createdAt, certificate.isPublished, scope)
    else
      new Certificate(id, title, description, certificate.logo, true, isOpenBadgesIntegration, shortDescription, companyId, PeriodType(validPeriodType), validPeriodValue.getOrElse(0), certificate.createdAt, certificate.isPublished, scope)

    certificateRepository.modify(c)
    getById(id)
  }

  def changeLogo(id: Int, newLogo: String = "") {
    val certificate = certificateRepository.getById(id)
    certificateRepository.modify(certificate.copy(logo = newLogo))
  }

  def delete(id: Int) = {
    certificateRepository.delete("id" -> id)

    SocialActivityLocalServiceHelper.deleteActivities(classOf[Certificate].getName, id)
  }

  def clone(certificateId: Int): Certificate = {
    val certificate = certificateRepository.getById(certificateId)

    // holly cow
    val newTitle = "copy \\d+".r.findFirstIn(certificate.title) match {
      case Some(value) => {
        val rawTitle = getCertificateRawTitle(certificate, value)
        val certificates = certificateRepository.getByTitle(rawTitle + " copy %") ++ Seq(certificate)

        val maxIndex = certificates
          .map(c => c.title)
          .maxBy(c => getCertificateIndexInTitle(c))

        rawTitle + " copy " + (getCertificateIndexInTitle(maxIndex) + 1)
      }
      case None => {
        val certificates = certificateRepository.getByTitle(certificate.title + " copy %") ++ Seq(certificate)
        val maxIndex = certificates
          .map(c => c.title)
          .maxBy(c => getCertificateIndexInTitle(c))

        certificate.title + " copy " + (getCertificateIndexInTitle(maxIndex) + 1)
      }
    }

    val newCertificate = certificateRepository.create(
      certificate.copy(
        title = newTitle,
        isPublished = false))

    // copy relationships
    certificateCourseRepository.getByCertificateId(certificate.id)
      .foreach(c => certificateCourseRepository.create(CertificateCourseSettings(newCertificate.id, c.courseId, c.value, c.periodType, c.arrangementIndex)))

    certificateUserRepository
      .getLeft(certificate)
      .foreach(user => certificateUserRepository.create(newCertificate, user))

    certificateActivityRepository.getByCertificateId(certificate.id)
      .foreach(activity => certificateActivityRepository.create(CertificateActivitySettings(newCertificate.id, activity.activityName, 1, activity.value, activity.periodType)))

    certificateTincanStatementRepository.getByCertificateId(certificate.id)
      .foreach(st => certificateTincanStatementRepository.create(CertificateStatementObjSettings(newCertificate.id, st.verb, st.obj, st.value, st.period)))

    if (!certificate.logo.isEmpty) {
      val fileService = inject[FileServiceContract]
      val img = fileService.getFileContent(certificate.id.toString, certificate.logo)
      fileService.setFileContent(newCertificate.id.toString, certificate.logo, img)
    }
    getById(newCertificate.id)
  }

  def publish(certificateId: Int): Certificate = {
    val certificate = certificateRepository.getById(certificateId)

    certificateRepository.modify(certificate.copy(isPublished = true))
    getById(certificate.id)
  }

  def unpublish(certificateId: Int): Certificate = {
    val certificate = certificateRepository.getById(certificateId)

    certificateRepository.modify(certificate.copy(isPublished = false))
    getById(certificate.id)
  }

  private def getCertificateIndexInTitle(title: String): Int = {
    "copy \\d+".r.findFirstIn(title) match {
      case Some(str) => {
        val index = str.replace("copy ", "")
        Try(index.toInt) match {
          case Success(value) => value
          case Failure(value) => 0
        }
      }
      case None => 0
    }
  }

  private def getCertificateRawTitle(c: Certificate, pattern: String): String = {
    val t = c.title
      .replace(pattern, "")
    if (t.lastIndexOf(" ") == -1)
      t
    else
      t.dropRight(1)
  }

  def exportCertificate(companyId: Int, certificateId: Int): InputStream = {
    new CertificateExportProcessor().exportItems(Seq(certificateRepository.getById(certificateId)))
  }

  def exportCertificates(companyId: Int): InputStream = {
    new CertificateExportProcessor().exportItems(certificateRepository.getByCompany(companyId).toSeq)
  }

  def importCertificates(filename: String, companyID: Int): Unit = {
    new CertificateImportProcessor().importItems(filename, companyID)
  }

  def getAvailableStatements(page: Int, skip: Int, take: Int, filter: String, isSortDirectionAsc: Boolean): RangeResult[Statement] = {
    val statementLRS = new StatementLRS() {
      val statementStorage = inject[StatementStorage]
    }
    var statements = statementLRS
      .getStatements(new StatementFilter)
      .statements
      .map(s => Statement(null, null, s.verb, s.obj, None, None, None, None, None, None, Seq()))
      .filter(_.obj.objectType.equalsIgnoreCase("Activity"))
      .distinct
      .filter(s => filter.isEmpty || s.verb.display.find(_._2.toLowerCase.contains(filter)).isDefined || s.obj.asInstanceOf[Activity].name.getOrElse(Map[String, String]()).find(_._2.toLowerCase.contains(filter)).isDefined)
      .sortBy(_.verb.id)

    if (!isSortDirectionAsc) statements = statements.reverse

    RangeResult(
      statements.size,
      (if (skip < 0)
        statements
      else
        statements.drop(skip).take(take)
      )
    )
  }
}
