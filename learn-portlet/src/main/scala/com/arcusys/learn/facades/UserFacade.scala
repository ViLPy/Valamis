package com.arcusys.learn.facades

import com.arcusys.learn.bl.services.UserServiceContract
import com.arcusys.learn.facades.certificate.CertificateResponseFactory
import com.arcusys.learn.liferay.LiferayClasses.LUser
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.response.users.{ UserResponseUtils }
import com.arcusys.learn.scorm.tracking.model.PermissionType._
import com.arcusys.learn.models.response.users.UserShortResponse
import com.arcusys.learn.models.OrgResponse
import com.arcusys.learn.models.response.users.UserResponse

/**
 * Created by Iliya Tryapitsin on 19.03.14.
 */
class UserFacade(config: BindingModule) extends UserFacadeContract with Injectable {
  def this() = this(Configuration)
  implicit val bindingModule = config

  val userService = inject[UserServiceContract]

  def all(courseId: Long, skip: Int, take: Int, filter: String, sortAZ: Boolean): Seq[LUser] = {
    userService.all(courseId, skip, take, filter, sortAZ)
  }

  def all(companyID: Long, orgID: Long, skip: Int, take: Int, filter: String, sortAZ: Boolean): Seq[UserShortResponse] = {
    val result = userService.all(companyID, orgID, skip, take, filter, sortAZ)
    result.map(x => UserShortResponse(x.getUserId, x.getFullName, UserResponseUtils.getPortraitUrl(x), UserResponseUtils.getPublicUrl(x)))
  }

  def byId(id: Int): LUser = userService.byId(id)

  def byId(id: Int, isShortResult: Boolean, withOpenBadges: Boolean): AnyRef = {
    val lUser = byId(id)
    if (isShortResult)
      UserShortResponse(id, lUser.getFullName, UserResponseUtils.getPortraitUrl(lUser), UserResponseUtils.getPublicUrl(lUser))
    else {
      val certificateResponseFactory = new CertificateResponseFactory() {
        override implicit def bindingModule: BindingModule = config
      }

      val certificates = userService.getUserCertificates(id, lUser, withOpenBadges)
        .map(certificateResponseFactory.toCertificateResponse)

      UserResponse(id, lUser.getFullName, UserResponseUtils.getPortraitUrl(lUser), UserResponseUtils.getPublicUrl(lUser), certificates)
    }
  }

  def byPermission(permissionType: PermissionType): Seq[UserShortResponse] = {
    val users = userService.byPermission(permissionType)
    users map { u => UserShortResponse(u.getUserId, u.getFullName, email = Option(u.getEmailAddress)) }
  }

  def count(companyId: Long, orgID: Long, filter: String): Int = {
    userService.count(companyId, orgID, filter)
  }

  def orgs(): Seq[OrgResponse] = {
    userService.orgs
      .map(x => OrgResponse(x.getOrganizationId, x.getName))
  }
}
