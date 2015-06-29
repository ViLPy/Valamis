package com.arcusys.valamis.certificate.service.export

import java.io.File

import com.arcusys.valamis.certificate.model.Certificate
import com.arcusys.valamis.certificate.model.goal.{ ActivityGoal, CourseGoal, PackageGoal, StatementGoal }
import com.arcusys.valamis.certificate.storage._
import com.arcusys.valamis.export.ImportProcessor
import com.arcusys.valamis.file.service.FileService
import com.arcusys.valamis.gradebook.service.CourseGradeService
import com.arcusys.valamis.model.PeriodTypes
import com.arcusys.valamis.util.FileSystemUtil
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import org.joda.time.DateTime

/**
 * Created by mminin on 08.09.14.
 */
class CertificateImportProcessor(implicit val bindingModule: BindingModule) extends ImportProcessor[CertificateExportModel] with Injectable {

  private lazy val fileFacade = inject[FileService]
  private lazy val courseFacade = inject[CourseGradeService]

  private lazy val certificateStorage = inject[CertificateRepository]
  private lazy val courseGoalStorage = inject[CourseGoalStorage]
  private lazy val activityGoalStorage = inject[ActivityGoalStorage]
  private lazy val statementGoalStorage = inject[StatementGoalStorage]
  private lazy val packageGoalStorage = inject[PackageGoalStorage]

  override protected def importItems(certificates: List[CertificateExportModel], companyId: Long, tempDirectory: File, userId: Long): Unit = {
    certificates.foreach(c => {

      val importedCertificate = importCertificate(c, companyId, logo = "")

      c.courses.foreach(importCourseGoal(_, importedCertificate, companyId))
      c.statements.foreach(importStatementGoal(_, importedCertificate))
      c.packages.foreach(importPackageGoal(_, importedCertificate))
      c.activities.foreach(importActivityGoal(_, importedCertificate))

      for (importedLogo <- importLogo(c, importedCertificate, tempDirectory)) {
        certificateStorage.update(importedCertificate.copy(logo = importedLogo))
      }
    })
  }

  private def importLogo(certificateInfo: CertificateExportModel, certificate: Certificate, tempDirectory: File): Option[String] = {
    if (certificateInfo.logo == null || certificateInfo.logo.isEmpty)
      None
    else {
      val separatorPosition = certificateInfo.logo.indexOf("_")

      val logoName = if (separatorPosition > 0) certificateInfo.logo.substring(separatorPosition + 1)
      else certificateInfo.logo

      val content = FileSystemUtil.getFileContent(new File(tempDirectory, certificateInfo.logo))

      fileFacade.setFileContent(certificate.id.toString, logoName, content)

      Some(logoName)
    }
  }

  private def importCertificate(certificateInfo: CertificateExportModel, companyId: Long, logo: String): Certificate = {
    certificateStorage.create(Certificate(-1,
      certificateInfo.title,
      certificateInfo.description,
      logo,
      certificateInfo.isPermanent,
      certificateInfo.isOpenBadgesIntegration,
      certificateInfo.shortDescription,
      companyId.toInt,
      PeriodTypes.parse(certificateInfo.validPeriodType),
      certificateInfo.validPeriod,
      DateTime.now()
    ))
  }

  private def importCourseGoal(goalInfo: CourseGoalExport, certificate: Certificate, companyId: Long): Option[CourseGoal] = {
    val courseOption = courseFacade.getAllCourses(companyId)
      .find(c => c.getDescriptiveName == goalInfo.title && c.getFriendlyURL == goalInfo.url)

    courseOption.map(course => courseGoalStorage.create(
      certificate.id,
      course.getGroupId.toInt,
      goalInfo.arrangementIndex,
      goalInfo.value,
      PeriodTypes(goalInfo.period)
    ))
  }

  private def importStatementGoal(goalInfo: StatementGoalExport, certificate: Certificate): StatementGoal = {
    statementGoalStorage.create(
      certificate.id,
      goalInfo.tincanStmntVerb,
      goalInfo.tincanStmntObj,
      goalInfo.value,
      PeriodTypes.parse(goalInfo.period)
    )
  }

  private def importPackageGoal(goalInfo: PackageGoalExport, certificate: Certificate): PackageGoal = {
    packageGoalStorage.create(
      certificate.id,
      goalInfo.packageId,
      goalInfo.value,
      PeriodTypes.parse(goalInfo.period)
    )
  }

  private def importActivityGoal(goalInfo: ActivityGoalExport, certificate: Certificate): ActivityGoal = {
    activityGoalStorage.create(
      certificate.id,
      goalInfo.name,
      goalInfo.activityCount,
      goalInfo.value,
      PeriodTypes.parse(goalInfo.period)
    )
  }
}
