package com.arcusys.learn.controllers.api

import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.request.UserRequest
import com.arcusys.learn.exceptions.AccessDeniedException
import com.arcusys.learn.models.response.CollectionResponse
import com.arcusys.learn.facades.{ CertificateFacadeContract, UserFacadeContract }

/**
 * Created by Iliya Tryapitsin on 12.03.14.
 */

// Documentation: https://confluence.intra.arcusys.fi/display/VAL/Web+API+Specification:+User

class UserApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  def this() = this(Configuration)

  val certificateFacade = inject[CertificateFacadeContract]
  val userFacade = inject[UserFacadeContract]

  get("/(:userID)")(jsonAction {
    val userRequest = UserRequest(this)
    if (userRequest.hasId) {
      if (userRequest.isShortResult && !hasTeacherPermissions && userRequest.id != getSessionUserID)
        throw new AccessDeniedException

      userFacade.byId(
        userRequest.id,
        userRequest.isShortResult,
        userRequest.withOpenBadges)

    } else {
      val users = userFacade.all(
        userRequest.companyId,
        userRequest.orgId,
        userRequest.skip,
        userRequest.count,
        userRequest.filter,
        userRequest.isSortDirectionAsc)

      val total = userFacade.count(
        userRequest.companyId,
        userRequest.orgId,
        userRequest.filter)

      CollectionResponse(userRequest.page, users, total)
    }
  })

  get("/orgs")(jsonAction {
    userFacade.orgs()
  })

  get("/:userID/certificates(/)")(jsonAction {
    val userRequest = UserRequest(this)
    // only teachers and admins can see result of other people
    if (!hasTeacherPermissions && userRequest.id != getSessionUserID)
      throw new AccessDeniedException

    if (userRequest.available) {
      val certificates = certificateFacade.getAvailableForUser(
        userRequest.companyId.toInt,
        userRequest.skip,
        userRequest.count,
        userRequest.filter,
        userRequest.isSortDirectionAsc,
        userRequest.id,
        userRequest.isShortResult,
        userRequest.isOnlyPublished,
        userRequest.scope)

      val total = certificateFacade.availableForUserCount(
        userRequest.companyId.toInt,
        userRequest.id,
        userRequest.isOnlyPublished,
        userRequest.scope)

      CollectionResponse(
        userRequest.page,
        certificates,
        total)

    } else {

      val certificates = if (userRequest.withOpenBadges)
        certificateFacade.getCertificatesByUserWithOpenBadges(
          userRequest.companyId.toInt,
          userRequest.skip,
          userRequest.count,
          userRequest.filter,
          userRequest.isSortDirectionAsc,
          userRequest.id,
          userRequest.isOnlyPublished)
      else
        certificateFacade.getForUserWithStatus(
          userRequest.companyId.toInt,
          userRequest.skip,
          userRequest.count,
          userRequest.filter,
          userRequest.isSortDirectionAsc,
          userRequest.id,
          userRequest.isShortResult,
          userRequest.isOnlyPublished)

      val total = if (userRequest.withOpenBadges)
        certificateFacade.getCertificatesCountByUserWithOpenBadges(
          getCompanyId,
          userRequest.filter,
          userRequest.id,
          userRequest.isOnlyPublished)
      else
        certificateFacade.forUserCount(getCompanyId, userRequest.id)

      CollectionResponse(
        userRequest.page,
        certificates,
        total)
    }
  })

  get("/:userID/certificates/:certificateId/goals(/)")(jsonAction {
    val userRequest = UserRequest(this)
    certificateFacade.getGoalsStatuses(userRequest.certificateId, userRequest.id)
  })
}
