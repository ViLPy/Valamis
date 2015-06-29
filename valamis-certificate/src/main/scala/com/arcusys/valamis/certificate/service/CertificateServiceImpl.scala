package com.arcusys.valamis.certificate.service

import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.services.SocialActivityLocalServiceHelper
import com.arcusys.valamis.certificate.model._
import com.arcusys.valamis.certificate.model.CertificateSortBy.CertificateSortBy
import com.arcusys.valamis.certificate.storage._
import com.arcusys.valamis.file.service.FileService
import com.arcusys.valamis.lrs.api.StatementApi
import com.arcusys.valamis.lrs.api.valamis.VerbApi
import com.arcusys.valamis.lrs.service.LrsClientManager
import com.arcusys.valamis.lrs.tincan._
import com.arcusys.valamis.lrs.util.StatementApiHelpers._
import com.arcusys.valamis.model.{SkipTake, Order, PeriodTypes, RangeResult}
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import org.joda.time.DateTime
import scala.util._
import com.arcusys.valamis.certificate.{CertificateSortBy => StorageCertificateSortBy, CertificateSortCriteria}

class CertificateServiceImpl(
    implicit val bindingModule: BindingModule)
  extends Injectable
  with CertificateService
  with CertificateGoalServiceImpl
  with CertificateUserServiceImpl {

  private lazy val certificateRepository = inject[CertificateRepository]
  private lazy val certificateStateService = inject[CertificateStateService]
  private lazy val courseGoalRepository = inject[CourseGoalStorage]
  private lazy val activityGoalRepository = inject[ActivityGoalStorage]
  private lazy val statementGoalRepository = inject[StatementGoalStorage]
  private lazy val packageGoalRepository = inject[PackageGoalStorage]
  private lazy val lrsReader = inject[LrsClientManager]
  private lazy val fileService = inject[FileService]

  def create(companyId: Int, title: String, description: String): Certificate = {
    val certificate = new Certificate(0, title, description, companyId = companyId, createdAt = new DateTime)
    getById(certificateRepository.create(certificate).id)
  }

  def getById(certificateId: Int) = certificateRepository.getById(certificateId)

  def getByCompany(companyId: Int): Seq[Certificate] = certificateRepository.getBy(companyId = companyId)

  def getByIds(ids: Set[Long]): Seq[Certificate] = certificateRepository.getByIds(ids)

  def getBy(companyId: Long, titlePattern: Option[String] = None) =
    certificateRepository.getBy(companyId = companyId, titlePattern = titlePattern)

  def getAll(
    companyId: Int,
    scope: Option[Long],
    skip: Int,
    take: Int,
    titleFilter: String,
    sortBy: CertificateSortBy,
    isSortDirectionAsc: Boolean) = {
      val sortCriteria = sortBy match {
        case CertificateSortBy.CreationDate => CertificateSortCriteria.CreatedDate
        case CertificateSortBy.Name         => CertificateSortCriteria.Title
        case _ => throw new UnsupportedOperationException("Supported sort criterias: creationdate and name")
      }

      certificateRepository.getBy(
        companyId = companyId,
        titlePattern = Some(titleFilter),
        scope = Some(scope),
        sortBy = Some(StorageCertificateSortBy(sortCriteria, Order(isSortDirectionAsc))),
        skipTake = Some(SkipTake(skip, take)))
    }

  def allCount(companyId: Int, titleFilter: String, scope: Option[Long]): Int =
    certificateRepository.getCountBy(companyId = companyId, titlePattern = Some(titleFilter), scope = Some(scope))

  def update(
    id: Int,
    title: String,
    description: String,
    validPeriodType: String,
    validPeriodValue: Option[Int],
    isOpenBadgesIntegration: Boolean,
    shortDescription: String = "",
    companyId: Int,
    scope: Option[Long]): Certificate = {

    val certificate = certificateRepository.getById(id)

    val c = if (validPeriodValue.isEmpty || validPeriodValue.get < 1)
      new Certificate(id, title, description, certificate.logo, true, isOpenBadgesIntegration, shortDescription,
        companyId, PeriodTypes.UNLIMITED, 0, certificate.createdAt, certificate.isPublished, scope)
    else
      new Certificate(id, title, description, certificate.logo, true, isOpenBadgesIntegration, shortDescription, companyId,
        PeriodTypes(validPeriodType), validPeriodValue.getOrElse(0), certificate.createdAt, certificate.isPublished, scope)

    certificateRepository.update(c)
    getById(id)
  }

  def changeLogo(id: Int, newLogo: String = "") {
    val certificate = certificateRepository.getById(id)
    certificateRepository.update(certificate.copy(logo = newLogo))
  }

  def delete(id: Int) = {
    certificateRepository.delete(id)

    SocialActivityLocalServiceHelper.deleteActivities(classOf[Certificate].getName, id)
  }

  def clone(certificateId: Int): Certificate = {
    def getTitle(title: String, certificate: Certificate) = {
      val certificates = certificateRepository.getBy(certificate.companyId, titlePattern = Some(title + " copy")) ++ Seq(certificate)

      val maxIndex = certificates
        .map(c => c.title)
        .maxBy(c => getCertificateIndexInTitle(c))

      title + " copy " + (getCertificateIndexInTitle(maxIndex) + 1)
    }

    val certificate = certificateRepository.getById(certificateId)

    // holly cow
    val newTitle = "copy \\d+".r.findFirstIn(certificate.title) match {
      case Some(value) => getTitle(getCertificateRawTitle(certificate, value), certificate)
      case None => getTitle(certificate.title, certificate)
    }

    val newCertificate =
      certificateRepository.create(certificate.copy(title = newTitle,isPublished = false))

    // copy relationships
    courseGoalRepository
      .getByCertificateId(certificate.id)
      .foreach(c =>
        courseGoalRepository.create(
          newCertificate.id,
          c.courseId,
          c.arrangementIndex,
          c.periodValue,
          c.periodType))

    certificateStateService
      .getBy(CertificateStateFilter(certificateId = Some(certificate.id)))
      .foreach(certState =>
        certificateStateService.create(
          CertificateState(
            certState.userId,
            CertificateStatus.InProgress,
            certState.statusAcquiredDate,
            certState.userJoinedDate,
            newCertificate.id)))

    activityGoalRepository
      .getByCertificateId(certificate.id)
      .foreach(activity =>
        activityGoalRepository.create(
          newCertificate.id,
          activity.activityName,
          1,
          activity.periodValue,
          activity.periodType))

    statementGoalRepository
      .getByCertificateId(certificate.id)
      .foreach(st =>
        statementGoalRepository.create(
          newCertificate.id,
          st.verb,
          st.obj,
          st.periodValue,
          st.periodType))

    packageGoalRepository
      .getByCertificateId(certificate.id)
      .foreach(g =>
        packageGoalRepository.create(
          newCertificate.id,
          g.packageId,
          g.periodValue,
          g.periodType))

    if (certificate.logo.nonEmpty) {
      val img = fileService.getFileContent(certificate.id.toString, certificate.logo)
      fileService.setFileContent(newCertificate.id.toString, certificate.logo, img)
    }
    getById(newCertificate.id)
  }

  def publish(certificateId: Int): Certificate = {
    val certificate = certificateRepository.getById(certificateId)

    certificateRepository.update(certificate.copy(isPublished = true))

    certificateStateService
      .getBy(CertificateStateFilter(certificateId = Some(certificateId)))
      .map(_.copy(status = CertificateStatus.InProgress, userJoinedDate = DateTime.now, statusAcquiredDate = DateTime.now))
      .foreach(certificateStateService.update)

    getById(certificate.id)
  }

  def unpublish(certificateId: Int): Certificate = {
    val certificate = certificateRepository.getById(certificateId)

    certificateRepository.update(certificate.copy(isPublished = false))
    getById(certificate.id)
  }

  private val copyRegex = "copy (\\d+)".r
  private def getCertificateIndexInTitle(title: String): Int = {
    copyRegex.findFirstMatchIn(title)
      .map(str => Try(str.group(1).toInt).getOrElse(0))
      .getOrElse(0)
  }

  private def getCertificateRawTitle(c: Certificate, pattern: String): String = {
    val t = c.title
      .replace(pattern, "")
    if (t.lastIndexOf(" ") == -1)
      t
    else
      t.dropRight(1)
  }

  def getUserCertificates(statementApi: StatementApi, id: Int, lUser: LUser, withOpenBadges: Boolean) = {
    val certificateFacade = inject[CertificateService]
    if (withOpenBadges) {
      certificateFacade.getCertificatesByUserWithOpenBadges(statementApi, lUser.getCompanyId.toInt, id, true)
    } else
      certificateFacade.getForUser(id)
  }
}
