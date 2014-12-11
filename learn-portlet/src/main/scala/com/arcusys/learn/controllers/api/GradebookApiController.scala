package com.arcusys.learn.controllers.api

import com.arcusys.learn.exceptions.{ AccessDeniedException, BadRequestException }
import com.arcusys.learn.facades.GradebookFacadeContract
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.request.{ GradebookActionType, GradebookRequest }
import com.arcusys.learn.models.response.CollectionResponse
import com.escalatesoft.subcut.inject.BindingModule
import com.liferay.portal.kernel.json.JSONFactoryUtil
import com.liferay.portal.kernel.poller.{ PollerProcessor, PollerRequest, PollerResponse }

// Documentation: https://confluence.intra.arcusys.fi/display/VAL/Web+API+specification%3A+Gradebook

class GradebookApiController(configuration: BindingModule) extends BaseApiController(configuration) with PollerProcessor {
  def this() = this(Configuration)

  val gradebookFacade = inject[GradebookFacadeContract]

  var hashCollection = 0

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  get("/gradebooks(/)")(jsonAction {
    val gradebookRequest = GradebookRequest(this)
    gradebookRequest.actionType match {
      case GradebookActionType.ALL => {
        requireTeacherPermissions()

        val students = if (gradebookRequest.isShortResult)
          gradebookFacade.getStudents(
            gradebookRequest.courseId,
            gradebookRequest.skip,
            gradebookRequest.count,
            gradebookRequest.studentName,
            gradebookRequest.organizationName,
            gradebookRequest.sortBy)
        else
          gradebookFacade.getExtStudents(
            gradebookRequest.courseId,
            gradebookRequest.skip,
            gradebookRequest.count,
            gradebookRequest.studentName,
            gradebookRequest.organizationName,
            gradebookRequest.selectedPackages,
            gradebookRequest.sortBy)

        val studentsCount = gradebookFacade.getStudentsCount(
          gradebookRequest.courseId,
          gradebookRequest.studentName,
          gradebookRequest.organizationName)

        CollectionResponse(gradebookRequest.page, students, studentsCount)
      }

      case GradebookActionType.GRADES => gradebookFacade.getGradesForStudent(
        gradebookRequest.studentId,
        gradebookRequest.courseId,
        gradebookRequest.skip,
        gradebookRequest.count,
        gradebookRequest.isSortDirectionAsc)

      case GradebookActionType.TOTAL_GRADE => gradebookFacade.getTotalGradeForStudent(
        gradebookRequest.studentId,
        gradebookRequest.courseId)

      case _ => throw new BadRequestException()
    }
  })

  post("/gradebooks(/)")(jsonAction {
    val gradebookRequest = GradebookRequest(this)
    gradebookRequest.actionType match {
      case GradebookActionType.TOTAL_GRADE => {
        requireTeacherPermissions()
        gradebookFacade.changeTotalGrade(
          gradebookRequest.studentId,
          gradebookRequest.courseId,
          gradebookRequest.grade,
          gradebookRequest.gradeComment)
      }

      case GradebookActionType.GRADES => {
        requireTeacherPermissions()
        gradebookFacade.changePackageGrade(
          gradebookRequest.studentId,
          gradebookRequest.packageId,
          gradebookRequest.grade,
          gradebookRequest.gradeComment)
      }

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
