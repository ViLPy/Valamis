package com.arcusys.learn.controllers.api

import com.arcusys.learn.exceptions.BadRequestException
import com.arcusys.learn.facades.GradebookFacadeContract
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.permission.{ PortletName, PermissionUtil, ViewAllPermission, ViewPermission }
import com.arcusys.learn.models.request.{ GradebookActionType, GradebookRequest }
import com.arcusys.learn.models.response.CollectionResponse
import com.arcusys.valamis.lrs.service.LrsClientManager
import com.escalatesoft.subcut.inject.BindingModule
import com.liferay.portal.kernel.json.JSONFactoryUtil
import com.liferay.portal.kernel.poller.{ PollerProcessor, PollerRequest, PollerResponse }

// Documentation: https://confluence.intra.arcusys.fi/display/VAL/Web+API+specification%3A+Gradebook

class GradebookApiController(configuration: BindingModule) extends BaseApiController(configuration) with PollerProcessor {
  val gradebookFacade = inject[GradebookFacadeContract]
  val lrsReader = inject[LrsClientManager]
  var hashCollection = 0

  def this() = this(Configuration)

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  get("/gradebooks(/)")(jsonAction {
    val gradebookRequest = GradebookRequest(this)
    lrsReader.statementApi(statementApi => {
      gradebookRequest.actionType match {
        case GradebookActionType.All =>
          PermissionUtil.requirePermissionApi(ViewAllPermission, PortletName.GradeBook)

          val detailed = !gradebookRequest.isShortResult
          val students = gradebookFacade.getStudents(
            statementApi,
            gradebookRequest.courseId,
            gradebookRequest.skip,
            gradebookRequest.count,
            gradebookRequest.studentName,
            gradebookRequest.organizationName,
            gradebookRequest.sortBy,
            gradebookRequest.isSortDirectionAsc,
            detailed,
            if (detailed) gradebookRequest.selectedPackages else Seq())

          val studentsCount = gradebookFacade.getStudentsCount(
            gradebookRequest.courseId,
            gradebookRequest.studentName,
            gradebookRequest.organizationName)

          CollectionResponse(gradebookRequest.page, students, studentsCount)

        case GradebookActionType.Grades =>
          PermissionUtil.requirePermissionApi(ViewPermission, PortletName.GradeBook, PortletName.LearningTranscript)
            gradebookFacade.getGradesForStudent(
              statementApi,
              gradebookRequest.studentId,
              gradebookRequest.studyCourseId,
              gradebookRequest.skip,
              gradebookRequest.count,
              gradebookRequest.isSortDirectionAsc,
              gradebookRequest.withStatements
            )
        case GradebookActionType.GradedPackage =>
          gradebookFacade.getUnfinishedPackages(
            statementApi,
            gradebookRequest.userIdServer
          )
        case GradebookActionType.TotalGrade =>
          PermissionUtil.requirePermissionApi(ViewPermission, PortletName.GradeBook)
          gradebookFacade.getTotalGradeForStudent(
            gradebookRequest.studentId,
            gradebookRequest.courseId)

        case GradebookActionType.LastModified =>
          PermissionUtil.requirePermissionApi(ViewPermission, PortletName.GradeBook)
          gradebookFacade.getLastModified(
            statementApi,
            gradebookRequest.courseId,
            gradebookRequest.studentId)

        case GradebookActionType.Statements =>
          PermissionUtil.requirePermissionApi(ViewPermission, PortletName.GradeBook)
          gradebookFacade.getPackageGradeWithStatements(
            statementApi,
            gradebookRequest.studentId,
            gradebookRequest.packageId)

        case _ => throw new BadRequestException()
      }
    }, gradebookRequest.lrsAuth)
  })

  post("/gradebooks(/)")(jsonAction {
    val gradebookRequest = GradebookRequest(this)
    gradebookRequest.actionType match {
      case GradebookActionType.TotalGrade =>
        PermissionUtil.requirePermissionApi(ViewAllPermission, PortletName.GradeBook)
        gradebookFacade.changeTotalGrade(
          gradebookRequest.studentId,
          gradebookRequest.courseId,
          gradebookRequest.grade,
          gradebookRequest.gradeComment)

      case GradebookActionType.Grades =>
        PermissionUtil.requirePermissionApi(ViewAllPermission, PortletName.GradeBook)
        gradebookFacade.changePackageGrade(
          gradebookRequest.studentId,
          gradebookRequest.packageId,
          gradebookRequest.grade,
          gradebookRequest.gradeComment)

      case _ => throw new BadRequestException()
    }
  })

  override def receive(pollerRequest: PollerRequest, pollerResponse: PollerResponse) {

    val responseJSON = JSONFactoryUtil.createJSONObject()
    responseJSON.put("update", "0")

    pollerResponse.setParameter("content", responseJSON)

  }

  override def send(pollerRequest: PollerRequest) {}
}
