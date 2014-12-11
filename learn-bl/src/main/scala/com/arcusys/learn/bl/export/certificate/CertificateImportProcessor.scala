package com.arcusys.learn.bl.export.certificate

import java.io.FileInputStream

import com.arcusys.learn.bl.export.ImportProcessor
import com.arcusys.learn.bl.services.{ CourseServiceContract, FileServiceContract }
import com.arcusys.learn.scorm.certificating.{ CertificateActivitySettingsRepositoryContract, CertificateCourseSettingsRepositoryContract, CertificateRepositoryContract, CertificateStatementObjSettingsRepositoryContract }
import com.arcusys.learn.scorm.manifest.model.PeriodType
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate
import com.arcusys.learn.scorm.tracking.model.certificating.models.{ CertificateActivitySettings, CertificateCourseSettings, CertificateStatementObjSettings }
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import org.joda.time.DateTime

/**
 * Created by mminin on 08.09.14.
 */
class CertificateImportProcessor(implicit configuration: BindingModule) extends ImportProcessor[Certificate] with Injectable {

  override implicit def bindingModule: BindingModule = configuration

  private lazy val fileFacade = inject[FileServiceContract]
  private lazy val courseFacade = inject[CourseServiceContract]

  private lazy val certificateRepository = inject[CertificateRepositoryContract]
  private lazy val certificateToCourseRepository = inject[CertificateCourseSettingsRepositoryContract]
  private lazy val certificateToActivityRepository = inject[CertificateActivitySettingsRepositoryContract]
  private lazy val certificateToTincanStatementRepository = inject[CertificateStatementObjSettingsRepositoryContract]

  override protected def importItemsImpl(jsonRaw: String, companyId: Int, tempDirectory: String): Unit = {
    val certificates = parseJson[List[CertificateExportModel]](jsonRaw).get
    certificates.foreach(c => {

      val importedCertificate = importCertificate(c, companyId, logo = "")

      c.courses.foreach(importCourseGoal(_, importedCertificate, companyId))
      c.statements.foreach(importStatementGoal(_, importedCertificate))
      c.activities.foreach(importActivityGoal(_, importedCertificate))

      for (importedLogo <- importLogo(c, importedCertificate, tempDirectory)) {
        certificateRepository.modify(importedCertificate.copy(logo = importedLogo))
      }
    })
  }

  private def importLogo(certificateInfo: CertificateExportModel, certificate: Certificate, tempDirectory: String): Option[String] = {
    if (certificateInfo.logo == null || certificateInfo.logo.isEmpty)
      None
    else {
      val separatorPosition = certificateInfo.logo.indexOf("_")

      val logoName = if (separatorPosition > 0) certificateInfo.logo.substring(separatorPosition + 1)
      else certificateInfo.logo

      val contentSource = scala.io.Source.fromInputStream(new FileInputStream(tempDirectory + certificateInfo.logo))(scala.io.Codec.ISO8859)
      val content = contentSource.map(_.toByte).toArray
      contentSource.close()

      fileFacade.setFileContent(certificate.id.toString, logoName, content)

      Some(logoName)
    }
  }

  private def importCertificate(certificateInfo: CertificateExportModel, companyId: Int, logo: String): Certificate = {
    certificateRepository.create(Certificate(-1,
      certificateInfo.title,
      certificateInfo.description,
      logo,
      certificateInfo.isPermanent,
      certificateInfo.isOpenBadgesIntegration,
      certificateInfo.shortDescription,
      companyId,
      PeriodType.parse(certificateInfo.validPeriodType),
      certificateInfo.validPeriod,
      DateTime.now()
    ))
  }

  private def importCourseGoal(goalInfo: CourseGoal, certificate: Certificate, companyId: Int): Option[CertificateCourseSettings] = {
    val courseOption = courseFacade.getAllCourses(companyId)
      .find(c => c.getDescriptiveName == goalInfo.title && c.getFriendlyURL == goalInfo.url)

    courseOption.map(course => certificateToCourseRepository.create(CertificateCourseSettings(
      certificate.id,
      course.getGroupId.toInt,
      goalInfo.value,
      goalInfo.period.map(PeriodType.parse),
      goalInfo.arrangementIndex
    )))
  }

  private def importStatementGoal(goalInfo: StatementGoal, certificate: Certificate): CertificateStatementObjSettings = {
    certificateToTincanStatementRepository.create(CertificateStatementObjSettings(
      certificate.id,
      goalInfo.tincanStmntVerb,
      goalInfo.tincanStmntObj,
      goalInfo.value,
      goalInfo.period.map(PeriodType.parse)
    ))
  }

  private def importActivityGoal(goalInfo: ActivityGoal, certificate: Certificate): CertificateActivitySettings = {
    certificateToActivityRepository.create(CertificateActivitySettings(
      certificate.id,
      goalInfo.name,
      goalInfo.activityCount,
      goalInfo.value,
      PeriodType.parse(goalInfo.period)
    ))
  }
}
