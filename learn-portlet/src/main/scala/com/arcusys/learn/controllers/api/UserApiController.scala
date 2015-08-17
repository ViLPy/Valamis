package com.arcusys.learn.controllers.api

import com.arcusys.learn.facades.{ CertificateFacadeContract, CourseFacadeContract, UserFacadeContract }
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.permission.{ PortletName, ModifyPermission, ViewPermission, PermissionUtil }
import com.arcusys.learn.models.request.UserRequest
import com.arcusys.learn.models.response.CollectionResponse
import com.arcusys.valamis.lrs.service.LrsClientManager
import com.escalatesoft.subcut.inject.BindingModule
import PermissionUtil._

// Documentation: https://confluence.intra.arcusys.fi/display/VAL/Web+API+Specification:+User

class UserApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  val certificateFacade = inject[CertificateFacadeContract]
  val userFacade = inject[UserFacadeContract]
  val courseFacade = inject[CourseFacadeContract]
  val lrsReader = inject[LrsClientManager]

  def this() = this(Configuration)

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  get("/users(/)(:userID)")(jsonAction {
    val userRequest = UserRequest(this)
    if (!PermissionUtil.hasPermissionApi(ModifyPermission, PortletName.CertificateManager)) {
      PermissionUtil.requirePermissionApi(ViewPermission, PortletName.LearningTranscript, PortletName.UserPortfolio, PortletName.ValamisActivities)
    }

    if (userRequest.isUserIdRequest) {
      lrsReader.statementApi(
        userFacade.byId(_,
          userRequest.requestedUserId,
          userRequest.isShortResult,
          userRequest.withOpenBadges),
        userRequest.lrsAuth)

    } else {
      val skipTake = userRequest.skipTake
      val users = userFacade.all(
        getCompanyId.toInt,
        userRequest.orgId,
        skipTake,
        userRequest.filter,
        userRequest.isSortDirectionAsc)

      val page = skipTake.map(x => userRequest.page).getOrElse(0)
      CollectionResponse(page, users.items, users.total)
    }
  })

  get("/users/orgs")(jsonAction {
    userFacade.orgs()
  })

  get("/users/:userID/certificates(/)")(jsonAction {

    val userRequest = UserRequest(this)
    // only teachers and admins can see result of other people
    lrsReader.statementApi(statementApi =>{
      if (userRequest.requestedUserId != getUserId) {
        PermissionUtil.requirePermissionApi(ViewPermission, PortletName.CertificateManager, PortletName.LearningTranscript)
      }

      if (userRequest.available) {
        val certificates = certificateFacade.getAvailableForUser(
          getCompanyId.toInt,
          userRequest.skip,
          userRequest.count,
          userRequest.filter,
          userRequest.isSortDirectionAsc,
          userRequest.requestedUserId,
          userRequest.isShortResult,
          userRequest.isOnlyPublished,
          userRequest.scope)

        val total = certificateFacade.availableForUserCount(
          getCompanyId.toInt,
          userRequest.requestedUserId,
          userRequest.filter,
          userRequest.isOnlyPublished,
          userRequest.scope)

        CollectionResponse(
          userRequest.page,
          certificates,
          total)

      } else {

        val certificates = if (userRequest.withOpenBadges)
          certificateFacade.getCertificatesByUserWithOpenBadges(
            statementApi,
            getCompanyId.toInt,
            userRequest.skip,
            userRequest.count,
            userRequest.filter,
            userRequest.isSortDirectionAsc,
            userRequest.requestedUserId,
            userRequest.isOnlyPublished)
        else
          certificateFacade.getForUserWithStatus(
            statementApi,
            getCompanyId.toInt,
            userRequest.skip,
            userRequest.count,
            userRequest.filter,
            userRequest.isSortDirectionAsc,
            userRequest.requestedUserId,
            userRequest.isShortResult,
            userRequest.isOnlyPublished)

        val total = if (userRequest.withOpenBadges)
          lrsReader.statementApi(
            certificateFacade.getCertificatesCountByUserWithOpenBadges(_,
              getCompanyId.toInt,
              userRequest.filter,
              userRequest.requestedUserId,
              userRequest.isOnlyPublished),
          userRequest.lrsAuth)
        else
          certificateFacade.forUserCount(
            getCompanyId.toInt,
            userRequest.filter,
            userRequest.requestedUserId,
            userRequest.isOnlyPublished)

        CollectionResponse(
          userRequest.page,
          certificates,
          total)
      }
    }, userRequest.lrsAuth)
  })

  get("/users/:userID/certificates/:certificateId/goals(/)")(jsonAction {
    val userRequest = UserRequest(this)
    lrsReader.statementApi(
      certificateFacade.getGoalsStatuses(_, userRequest.certificateId, userRequest.requestedUserId),
      userRequest.lrsAuth)
  })

  get("/users/:userID/courses")(jsonAction {
    val userRequest = UserRequest(this)
    courseFacade.getByUserId(userRequest.requestedUserId)
  })
}
