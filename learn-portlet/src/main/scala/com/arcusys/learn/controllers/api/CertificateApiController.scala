package com.arcusys.learn.controllers.api

import com.arcusys.learn.exceptions.BadRequestException
import com.arcusys.learn.facades.CertificateFacadeContract
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.permission.{ModifyPermission, PermissionUtil, PortletName, ViewPermission}
import com.arcusys.learn.models.CertificateStatementGoalRequest
import com.arcusys.learn.models.request.{CertificateActionType, CertificateRequest}
import com.arcusys.learn.models.response.CollectionResponse
import com.arcusys.learn.models.response.certificates.AvailableStatementResponse
import com.arcusys.valamis.certificate.model.CertificateSortBy
import com.arcusys.valamis.lrs.service.LrsClientManager
import com.arcusys.valamis.model.RangeResult
import com.escalatesoft.subcut.inject.BindingModule

import scala.util.{Failure, Success}

class CertificateApiController(
    configuration: BindingModule)
  extends BaseApiController(configuration) {

  val certificateFacade = inject[CertificateFacadeContract]
  private val lrsReader = inject[LrsClientManager]

  def this() = this(Configuration)

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  implicit val serializationFormats = CertificateRequest.serializationFormats

  get("/certificates(/)(:id)")(jsonAction {

    val parameters = CertificateRequest(this)

    //OpenBadges do not need permission check
    if(parameters.action(this) != CertificateActionType.GetIssuerBadge)
      PermissionUtil.requirePermissionApi(ViewPermission,
        PortletName.CertificateManager,
        PortletName.CertificateViewer,
        PortletName.LearningTranscript,
        PortletName.AchievedCertificates,
        PortletName.LearningPaths
      )

    parameters.action(this) match {
      case CertificateActionType.GetAll =>
        certificateFacade.getAll(
          PermissionUtil.getCompanyId.toInt,
          parameters.scope,
          parameters.page,
          parameters.count,
          parameters.filter,
          parameters.sortBy,
          parameters.isSortDirectionAsc,
          parameters.isShortResult)

      case CertificateActionType.GetById => certificateFacade.getById(parameters.id)

      case CertificateActionType.GetIssuerBadge => certificateFacade.getIssuerBadge(
        parameters.id,
        parameters.userId,
        parameters.rootUrl)

      case CertificateActionType.GetStatements =>
        lrsReader.verbApi(
          api => {
            api.getWithActivities(
              Some(parameters.filter),
              parameters.count,
              parameters.page * parameters.skip,
              parameters.isSortDirectionAsc)
            match {
              case Success(v) =>
                val stmntResp = v.seq map { case ((verb, (id, disp))) =>
                  AvailableStatementResponse(verb.id, verb.display, id, disp)
                }
                CollectionResponse(parameters.page, stmntResp, v.count)

              case Failure(e) => throw e
            }
          },
        parameters.lrsAuth)

      case CertificateActionType.GetCertificateStates =>
        val userId = parameters.userIdOpt.getOrElse(parameters.userIdServer)
        val statuses = parameters.statuses

        certificateFacade.getStatesBy(userId, statuses)

      case _ => throw new BadRequestException
    }
  })

  get("/certificates(/):id/users(/)")(jsonAction {

    val certificateRequest = CertificateRequest(this)
    PermissionUtil.requirePermissionApi(ViewPermission, PortletName.CertificateManager, PortletName.CertificateViewer)
    lrsReader.statementApi(statementApi => {
      certificateRequest.action(this) match {
        case CertificateActionType.GetStudents =>
          val result = certificateFacade.getJoinedUsers(
            statementApi,
            certificateRequest.id,
            certificateRequest.filter,
            certificateRequest.orgId, /// ???
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

        case CertificateActionType.GetNotContainedStudents =>
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
        case _ => throw new BadRequestException
      }
    }, certificateRequest.lrsAuth)
  })

  get("/certificates/activities(/)(:name)")(action {
    response.setHeader("Content-Type", "application/json; charset=UTF-8")
    val parameters = CertificateRequest(this)
    PermissionUtil.requirePermissionApi(ViewPermission, PortletName.CertificateManager, PortletName.CertificateViewer, PortletName.LearningTranscript)
    lrsReader.activityProfileApi(_.getActivities(parameters.activityName), parameters.lrsAuth) match {
      case Success(value) => value
      case Failure(value) =>
        println("Fail:" + value)
        ""
    }
  })

  post("/certificates(/)(:id)(/)")(jsonAction {
    val certificateRequest = CertificateRequest(this)
    val action = certificateRequest.action(this)
    if (action == CertificateActionType.AddUser ||
      action == CertificateActionType.DeleteUser) {
      PermissionUtil.requireCurrentLoggedInUser(certificateRequest.userId)
    } else {
      PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.CertificateManager, PortletName.CertificateViewer)
    }

    certificateRequest.action(this) match {
      case CertificateActionType.Add => certificateFacade.create(
        PermissionUtil.getCompanyId.toInt,
        CertificateRequest.DefaultTitle,
        CertificateRequest.DefaultDescription)

      case CertificateActionType.AddCourses => certificateRequest.courseGoalIds
        .foreach(courseId => certificateFacade.addCourse(certificateRequest.id, courseId))

      case CertificateActionType.AddUser => certificateFacade.addUser(
        certificateRequest.id,
        certificateRequest.userId)

      case CertificateActionType.AddUsers => certificateRequest.userIds
        .foreach(userId => certificateFacade.addUser(certificateRequest.id, userId))

      case CertificateActionType.AddActivity => certificateFacade.addActivity(certificateRequest.id, certificateRequest.activityId, 1)

      case CertificateActionType.AddActivities => certificateRequest.activityNames
        .foreach(activity => certificateFacade.addActivity(certificateRequest.id, activity, 1))

      case CertificateActionType.AddTincanStmnt => certificateFacade.addStatementObj(
        certificateRequest.id,
        certificateRequest.tincanStatement._1,
        certificateRequest.tincanStatement._2)

      case CertificateActionType.AddTincanStmnts =>
        val items = parseJson[Seq[CertificateStatementGoalRequest]](certificateRequest.tincanStatements).get
        items.foreach(st => certificateFacade.addStatementObj(certificateRequest.id, st.verb, st.obj))

      case CertificateActionType.AddPackage => certificateFacade.addPackageGoal(
        certificateRequest.id,
        certificateRequest.packageId
      )

      case CertificateActionType.AddPackages =>
        val certificateId = certificateRequest.id
        certificateRequest.packageIds.foreach(certificateFacade.addPackageGoal(certificateId, _))

      case CertificateActionType.Update => certificateFacade.change(
        certificateRequest.id,
        certificateRequest.title,
        certificateRequest.description,
        certificateRequest.validPeriod.valueType,
        certificateRequest.validPeriod.value,
        certificateRequest.isPublishBadge,
        certificateRequest.shortDescription,
        PermissionUtil.getCompanyId.toInt,
        certificateRequest.scope)

      case CertificateActionType.UpdateLogo => certificateFacade.changeLogo(
        certificateRequest.id,
        certificateRequest.logo)

      case CertificateActionType.UpdateCourse => certificateFacade.changeCourse(
        certificateRequest.id,
        certificateRequest.course._1,
        certificateRequest.course._2,
        certificateRequest.course._3)

      case CertificateActionType.UpdateActivity => certificateFacade.changeActivity(
        certificateRequest.id,
        certificateRequest.activity._1,
        certificateRequest.activity._2,
        certificateRequest.activity._3,
        certificateRequest.activity._4)

      case CertificateActionType.UpdateStmnt => certificateFacade.changeStatementObjPeriod(
        certificateRequest.id,
        certificateRequest.tincanStatement._1,
        certificateRequest.tincanStatement._2,
        certificateRequest.tincanStatement._3,
        certificateRequest.tincanStatement._4)

      case CertificateActionType.UpdatePackage => certificateFacade.changePackagePeriod(
        certificateRequest.id,
        certificateRequest.packageId,
        certificateRequest.periodValue,
        certificateRequest.periodType
      )

      case CertificateActionType.Delete => certificateFacade.delete(certificateRequest.id)

      case CertificateActionType.DeleteCourse => certificateFacade.deleteCourse(
        certificateRequest.id,
        certificateRequest.courseGoalId)

      case CertificateActionType.DeleteUser => certificateFacade.deleteUser(
        certificateRequest.id,
        certificateRequest.userId)

      case CertificateActionType.DeleteUsers => certificateRequest.userIds
        .foreach(userId => certificateFacade.deleteUser(certificateRequest.id, userId))

      case CertificateActionType.DeleteActivity => certificateFacade.deleteActivity(certificateRequest.id, certificateRequest.activityId)

      case CertificateActionType.DeleteActivities => certificateRequest.activityNames
        .foreach(activity => certificateFacade.deleteActivity(certificateRequest.id, activity))

      case CertificateActionType.DeleteTincanStmnt => certificateFacade.deleteStatementObj(
        certificateRequest.id,
        certificateRequest.tincanStatement._1,
        certificateRequest.tincanStatement._2)

      case CertificateActionType.DeletePackage => certificateFacade.deletePackageGoal(
        certificateRequest.id,
        certificateRequest.packageId
      )

      case CertificateActionType.Clone       => certificateFacade.clone(certificateRequest.id)

      case CertificateActionType.Publish     => certificateFacade.publish(certificateRequest.id)

      case CertificateActionType.Unpublish   => certificateFacade.unpublish(certificateRequest.id)

      case CertificateActionType.MoveCourse => certificateFacade.moveCourse(certificateRequest.id, certificateRequest.courseGoalIds)
    }
  })
}