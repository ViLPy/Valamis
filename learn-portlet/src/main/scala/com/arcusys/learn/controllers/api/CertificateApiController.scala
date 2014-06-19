package com.arcusys.learn.controllers.api

import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.request.{ CertificateSortBy, CertificateActionType, CertificateRequest }
import com.arcusys.learn.models.response.CollectionResponse
import com.arcusys.learn.exceptions.BadRequestException
import com.arcusys.learn.facades.{ CertificateFacadeContract }

class CertificateApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  def this() = this(Configuration)

  val certificateFacade = inject[CertificateFacadeContract]

  get("/(:id)")(jsonAction {

    val certificateRequest = CertificateRequest(this)
    certificateRequest.action match {
      case CertificateActionType.GET_ALL => {
        requireTeacherPermissions()
        val certificates = certificateFacade.getAll(
          certificateRequest.companyId,
          certificateRequest.skip,
          certificateRequest.count,
          certificateRequest.filter,
          certificateRequest.sortBy,
          certificateRequest.isSortDirectionAsc,
          certificateRequest.isShortResult)

        val total = certificateFacade.allCount(
          certificateRequest.companyId,
          certificateRequest.filter)

        CollectionResponse(
          certificateRequest.page,
          certificates,
          total)
      }

      case CertificateActionType.GET_BY_ID => certificateFacade.getById(certificateRequest.id)

      case CertificateActionType.GET_ISSUE_BADGE => certificateFacade.getIssuerBadge(
        certificateRequest.id,
        certificateRequest.userId,
        certificateRequest.rootUrl)

      case _ => throw new BadRequestException
    }
  })

  get("/:id/users(/)")(jsonAction {
    requireTeacherPermissions()
    val certificateRequest = CertificateRequest(this)

    certificateRequest.action match {
      case CertificateActionType.GET_STUDENTS => {
        val result = certificateFacade.getJoinedUsers(certificateRequest.id,
          certificateRequest.filter,
          certificateRequest.orgId,
          certificateRequest.sortBy,
          certificateRequest.isSortDirectionAsc,
          certificateRequest.skip,
          certificateRequest.count)

        CollectionResponse(
          certificateRequest.page,
          result,
          certificateFacade.getJoinedUsersCount(
            certificateRequest.id,
            certificateRequest.filter,
            certificateRequest.orgId))
      }

      case CertificateActionType.GET_NOT_CONTAINED_STUDENTS => {
        val result = certificateFacade.getFreeStudents(
          certificateRequest.id,
          certificateRequest.filter,
          certificateRequest.orgId,
          CertificateSortBy.Name,
          certificateRequest.isSortDirectionAsc,
          certificateRequest.skip,
          certificateRequest.count)

        CollectionResponse(
          certificateRequest.page,
          result,
          certificateFacade.getFreeStudentsCount(
            certificateRequest.id,
            certificateRequest.orgId,
            certificateRequest.filter))
      }
      case _ => throw new BadRequestException
    }
  })

  post("/(:id)(/)")(jsonAction {
    val certificateRequest = CertificateRequest(this)
    certificateRequest.action match {
      case CertificateActionType.ADD => certificateFacade.create(
        certificateRequest.companyId,
        CertificateRequest.DEFAULT_TITLE,
        CertificateRequest.DEFAULT_DESCRIPTION)

      case CertificateActionType.ADD_COURSE => certificateFacade.addCourse(
        certificateRequest.id,
        certificateRequest.courseId)

      case CertificateActionType.ADD_COURSES => certificateRequest.courseIds
        .foreach(courseId => certificateFacade.addCourse(certificateRequest.id, courseId))

      case CertificateActionType.ADD_USER => certificateFacade.addUser(
        certificateRequest.id,
        certificateRequest.userId)

      case CertificateActionType.ADD_USERS => certificateRequest.userIds
        .foreach(userId => certificateFacade.addUser(certificateRequest.id, userId))

      case CertificateActionType.ADD_ACTIVITY => certificateFacade.addActivity(certificateRequest.id, certificateRequest.activityName, 1)

      case CertificateActionType.ADD_ACTIVITIES => certificateRequest.activityNames
        .foreach(activity => certificateFacade.addActivity(certificateRequest.id, activity, 1))

      case CertificateActionType.ADD_TINCANSTMNT => certificateFacade.addStatementObj(
        certificateRequest.id,
        certificateRequest.tincanStatement._1,
        certificateRequest.tincanStatement._2)

      case CertificateActionType.UPDATE => certificateFacade.change(
        certificateRequest.id,
        certificateRequest.title,
        certificateRequest.description,
        certificateRequest.validPeriod,
        certificateRequest.isPublishBadge,
        certificateRequest.shortDescription,
        certificateRequest.companyId,
        certificateRequest.scope)

      case CertificateActionType.UPDATE_LOGO => certificateFacade.changeLogo(
        certificateRequest.id,
        certificateRequest.logo)

      case CertificateActionType.UPDATE_COURSE => certificateFacade.changeCourse(
        certificateRequest.id,
        certificateRequest.course._1,
        certificateRequest.course._2,
        certificateRequest.course._3)

      case CertificateActionType.UPDATE_ACTIVITY => certificateFacade.changeActivity(
        certificateRequest.id,
        certificateRequest.activity._1,
        certificateRequest.activity._2,
        certificateRequest.activity._3,
        certificateRequest.activity._4)

      case CertificateActionType.UPDATE_STMNT => certificateFacade.changeStatementObjPeriod(
        certificateRequest.id,
        certificateRequest.tincanStatement._1,
        certificateRequest.tincanStatement._2,
        certificateRequest.tincanStatement._3,
        certificateRequest.tincanStatement._4)

      case CertificateActionType.DELETE => certificateFacade.delete(certificateRequest.id)

      case CertificateActionType.DELETE_COURSE => certificateFacade.deleteCourse(
        certificateRequest.id,
        certificateRequest.courseId)

      case CertificateActionType.DELETE_USER => certificateFacade.deleteUser(
        certificateRequest.id,
        certificateRequest.userId)

      case CertificateActionType.DELETE_USERS => certificateRequest.userIds
        .foreach(userId => certificateFacade.deleteUser(certificateRequest.id, userId))

      case CertificateActionType.DELETE_ACTIVITY => certificateFacade.deleteActivity(certificateRequest.id, certificateRequest.activityName)

      case CertificateActionType.DELETE_ACTIVITIES => certificateRequest.activityNames
        .foreach(activity => certificateFacade.deleteActivity(certificateRequest.id, activity))

      case CertificateActionType.DELETE_TINCANSTMNT => certificateFacade.deleteStatementObj(
        certificateRequest.id,
        certificateRequest.tincanStatement._1,
        certificateRequest.tincanStatement._2)

      case CertificateActionType.CLONE     => certificateFacade.clone(certificateRequest.id)

      case CertificateActionType.PUBLISH   => certificateFacade.publish(certificateRequest.id)

      case CertificateActionType.UNPUBLISH => certificateFacade.unpublish(certificateRequest.id)
    }
  })
}