package com.arcusys.learn.controllers.api

import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.request.UserRequest
import com.arcusys.learn.exceptions.AccessDeniedException
import com.arcusys.learn.models.response.CollectionResponse
import com.arcusys.learn.facades.{ CourseFacadeContract, CertificateFacadeContract, UserFacadeContract }

/**
 * Created by Iliya Tryapitsin on 12.03.14.
 */

// Documentation: https://confluence.intra.arcusys.fi/display/VAL/Web+API+Specification:+User

class UserApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  def this() = this(Configuration)

  val certificateFacade = inject[CertificateFacadeContract]
  val userFacade = inject[UserFacadeContract]
  val courseFacade = inject[CourseFacadeContract]

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  get("/users(/)(:userID)")(jsonAction {
    val userRequest = UserRequest(this)
    if (userRequest.isUserIdRequest) {
      if (userRequest.isShortResult && !isTeacher)
        throw new AccessDeniedException

      userFacade.byId(
        userRequest.requestedUserId,
        userRequest.isShortResult,
        userRequest.withOpenBadges)

    } else {
      val users = userFacade.all(
        getCompanyId.toInt,
        userRequest.orgId,
        userRequest.skip,
        userRequest.count,
        userRequest.filter,
        userRequest.isSortDirectionAsc)

      val total = userFacade.count(
        getCompanyId.toInt,
        userRequest.orgId,
        userRequest.filter)

      CollectionResponse(userRequest.page, users, total)
    }
  })

  get("/users/orgs")(jsonAction {
    userFacade.orgs()
  })

  get("/users/:userID/certificates(/)")(jsonAction {

    val userRequest = UserRequest(this)
    //    val permissionChecker = PermissionCheckerFactoryUtil.create(getLiferayUser)
    //
    //    PermissionThreadLocal.setPermissionChecker(permissionChecker)
    //    PrincipalThreadLocal.setName(getUserId)

    // only teachers and admins can see result of other people
    if (!isTeacher && userRequest.requestedUserId != getUserId)
      throw new AccessDeniedException

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
          getCompanyId.toInt,
          userRequest.skip,
          userRequest.count,
          userRequest.filter,
          userRequest.isSortDirectionAsc,
          userRequest.requestedUserId,
          userRequest.isOnlyPublished)
      else
        certificateFacade.getForUserWithStatus(
          getCompanyId.toInt,
          userRequest.skip,
          userRequest.count,
          userRequest.filter,
          userRequest.isSortDirectionAsc,
          userRequest.requestedUserId,
          userRequest.isShortResult,
          userRequest.isOnlyPublished)

      val total = if (userRequest.withOpenBadges)
        certificateFacade.getCertificatesCountByUserWithOpenBadges(
          getCompanyId.toInt,
          userRequest.filter,
          userRequest.requestedUserId,
          userRequest.isOnlyPublished)
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
  })

  get("/users/:userID/certificates/:certificateId/goals(/)")(jsonAction {
    val userRequest = UserRequest(this)
    certificateFacade.getGoalsStatuses(userRequest.certificateId, userRequest.requestedUserId)
  })

  get("/users/:userID/courses")(jsonAction {
    val userRequest = UserRequest(this)
    courseFacade.getByUserId(userRequest.requestedUserId);
  })
}
