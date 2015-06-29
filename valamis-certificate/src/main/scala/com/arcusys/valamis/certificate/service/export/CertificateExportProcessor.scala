package com.arcusys.valamis.certificate.service.export

import com.arcusys.valamis.certificate.model.Certificate
import com.arcusys.valamis.certificate.model.goal.{ ActivityGoal, CourseGoal, PackageGoal, StatementGoal }
import com.arcusys.valamis.certificate.storage.{ ActivityGoalStorage, CourseGoalStorage, PackageGoalStorage, StatementGoalStorage }
import com.arcusys.valamis.export.ExportProcessor
import com.arcusys.valamis.file.service.FileService
import com.arcusys.valamis.gradebook.service.CourseGradeService
import com.arcusys.valamis.util.ZipBuilder
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class CertificateExportProcessor(
    implicit val bindingModule: BindingModule)
  extends ExportProcessor[Certificate, CertificateExportModel]
  with Injectable {

  private lazy val fileFacade = inject[FileService]
  private lazy val courseFacade = inject[CourseGradeService]
  private lazy val courseGoalStorage = inject[CourseGoalStorage]
  private lazy val activityGoalStorage = inject[ActivityGoalStorage]
  private lazy val statementGoalStorage = inject[StatementGoalStorage]
  private lazy val packageGoalStorage = inject[PackageGoalStorage]

  override protected def exportItemsImpl(zip: ZipBuilder, items: Seq[Certificate]): Seq[CertificateExportModel] = {
    items.map(c => {
      val logo = exportLogo(zip, c)
      toExportModel(c, logo)
    })
  }

  private def exportLogo(zip: ZipBuilder, c: Certificate): String = {
    if (c.logo == null && c.logo.isEmpty) {
      c.logo
    } else {
      val logo = c.id.toString + "_" + c.logo
      try {
        zip.addFile(logo, fileFacade.getFileContent(c.id.toString, c.logo))
        logo
      } catch {
        case _: Throwable => null
      }
    }
  }

  private def toExportModel(certificate: Certificate, newLogo: String): CertificateExportModel = {
    val courseGoals = courseGoalStorage.getByCertificateId(certificate.id).sortBy(_.arrangementIndex).map(toExportModel)
    val statementGoals = statementGoalStorage.getByCertificateId(certificate.id).map(toExportModel)
    val packageGoals = packageGoalStorage.getByCertificateId(certificate.id).map(toExportModel)
    val activityGoals = activityGoalStorage.getByCertificateId(certificate.id).map(toExportModel)

    CertificateExportModel(
      certificate.title,
      certificate.shortDescription,
      certificate.description,
      newLogo, //certificate.logo,
      certificate.isPermanent,
      certificate.isPublishBadge,
      certificate.validPeriodType.toString,
      certificate.validPeriod,
      courseGoals,
      statementGoals,
      packageGoals,
      activityGoals
    )
  }

  private def toExportModel(goal: CourseGoal): CourseGoalExport = {
    val course = courseFacade.getCourse(goal.courseId)
    CourseGoalExport(
      course.getDescriptiveName,
      course.getFriendlyURL,
      goal.periodValue,
      goal.periodType.toString,
      goal.arrangementIndex)
  }

  private def toExportModel(goal: StatementGoal): StatementGoalExport =
    StatementGoalExport(goal.obj, goal.verb, goal.periodValue, goal.periodType.toString)

  private def toExportModel(goal: PackageGoal): PackageGoalExport =
    PackageGoalExport(goal.packageId, goal.periodValue, goal.periodType.toString)

  private def toExportModel(goal: ActivityGoal): ActivityGoalExport =
    ActivityGoalExport(goal.count, goal.activityName, goal.periodValue, goal.periodType.toString)
}
