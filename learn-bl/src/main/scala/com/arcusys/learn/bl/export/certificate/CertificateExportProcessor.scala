package com.arcusys.learn.bl.export.certificate

import com.arcusys.learn.bl.exceptions.EntityNotFoundException
import com.arcusys.learn.bl.export.ExportProcessor
import com.arcusys.learn.bl.services.{ CourseServiceContract, FileServiceContract }
import com.arcusys.learn.scorm.tracking.model.certificating.models.{ CertificateActivitySettings, CertificateCourseSettings, CertificateStatementObjSettings }
import com.arcusys.learn.scorm.certificating.{ CertificateActivitySettingsRepositoryContract, CertificateCourseSettingsRepositoryContract, CertificateStatementObjSettingsRepositoryContract }
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate
import com.arcusys.scorm.generator.file.ZipFile
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

/**
 * Created by mminin on 12.09.14.
 */
class CertificateExportProcessor(implicit configuration: BindingModule) extends ExportProcessor[Certificate] with Injectable {

  override implicit def bindingModule: BindingModule = configuration

  private lazy val fileFacade = inject[FileServiceContract]
  private lazy val courseFacade = inject[CourseServiceContract]

  private lazy val certificateToCourseRepository = inject[CertificateCourseSettingsRepositoryContract]
  private lazy val certificateToActivityRepository = inject[CertificateActivitySettingsRepositoryContract]
  private lazy val certificateToTincanStatementRepository = inject[CertificateStatementObjSettingsRepositoryContract]

  override protected def exportItemsImpl(zip: ZipFile, items: Seq[Certificate]): Seq[Any] = {
    items.map(c => {
      val logo = exportLogo(zip, c)
      toExportModel(c, logo)
    })
  }

  private def exportLogo(zip: ZipFile, c: Certificate): String = {
    if (c.logo == null && c.logo.isEmpty) {
      c.logo
    } else {
      val logo = c.id.toString + "_" + c.logo
      try {
        zip.addFile(logo, fileFacade.getFileContent(c.id.toString, c.logo))
        logo
      } catch {
        case _ => null
      }
    }
  }

  private def toExportModel(certificate: Certificate, newLogo: String): CertificateExportModel = {
    val courses = certificateToCourseRepository.getByCertificateId(certificate.id).map(toExportModel)
    val statements = certificateToTincanStatementRepository.getByCertificateId(certificate.id).map(toExportModel)
    val activities = certificateToActivityRepository.getByCertificateId(certificate.id).map(toExportModel)

    CertificateExportModel(
      certificate.title,
      certificate.shortDescription,
      certificate.description,
      newLogo, //certificate.logo,
      certificate.isPermanent,
      certificate.isPublishBadge,
      certificate.validPeriodType.toString,
      certificate.validPeriod,
      courses,
      statements,
      activities
    )
  }

  private def toExportModel(courseSettings: CertificateCourseSettings): CourseGoal = {
    val course = courseFacade.getCourse(courseSettings.courseId)
    CourseGoal(course.getDescriptiveName, course.getFriendlyURL, courseSettings.value, courseSettings.periodType.map(_.toString), courseSettings.arrangementIndex)
  }

  private def toExportModel(statement: CertificateStatementObjSettings): StatementGoal = {
    StatementGoal(statement.obj, statement.verb, statement.value, statement.period.map(_.toString))
  }

  private def toExportModel(activity: CertificateActivitySettings): ActivityGoal = {
    ActivityGoal(activity.count, activity.activityName, activity.value, activity.periodType.toString)
  }
}
