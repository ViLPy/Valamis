package com.arcusys.learn.facades

import com.arcusys.learn.facades.certificate.CertificateResponseFactory
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.LiferayClasses.LUser
import com.arcusys.learn.liferay.permission.{ PortletName, PermissionUtil, ViewAllPermission, ViewPermission }
import com.arcusys.learn.liferay.services.UserLocalServiceHelper
import com.arcusys.learn.models.OrgResponse
import com.arcusys.learn.models.response.users.{ UserWithCertificatesResponse, UserResponseUtils, UserShortResponse }
import com.arcusys.valamis.certificate.service.CertificateService
import com.arcusys.valamis.lrs.api.StatementApi
import com.arcusys.valamis.model.{RangeResult, SkipTake}
import com.arcusys.valamis.user.service.UserService
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import scala.collection.JavaConverters._

/**
 * Created by Iliya Tryapitsin on 19.03.14.
 */
class UserFacade(config: BindingModule) extends UserFacadeContract with Injectable {
  def this() = this(Configuration)
  implicit val bindingModule = config

  val userService = inject[UserService]
  val certificateService = inject[CertificateService]

  def all(courseId: Long, skip: Int, take: Int, filter: String, sortAZ: Boolean): Seq[LUser] = {
    userService.all(courseId, skip, take, filter, sortAZ)
  }

  def all(companyId: Long, orgId: Option[Long], skipTake: Option[SkipTake], filter: String, sortAZ: Boolean): RangeResult[UserShortResponse] = {
    val result = userService.all(companyId, orgId, skipTake, filter, sortAZ)

    result.copy(
      items = result.items.map(x => UserShortResponse(
        x.getUserId,
        x.getFullName,
        UserResponseUtils.getPortraitUrl(x),
        UserResponseUtils.getPublicUrl(x))
      )
    )
  }

  def byId(id: Long): LUser = userService.byId(id)

  def byId(statementApi: StatementApi, id: Long, isShortResult: Boolean, withOpenBadges: Boolean): AnyRef = {
    val lUser = byId(id)
    if (isShortResult)
      UserShortResponse(id, lUser.getFullName, UserResponseUtils.getPortraitUrl(lUser), UserResponseUtils.getPublicUrl(lUser))
    else {
      val certificateResponseFactory = new CertificateResponseFactory() {
        override implicit def bindingModule: BindingModule = config
      }

      val certificates = certificateService.getUserCertificates(statementApi, id.toInt, lUser, withOpenBadges)
        .map(certificateResponseFactory.toCertificateResponse)

      UserWithCertificatesResponse(id, lUser.getFullName, UserResponseUtils.getPortraitUrl(lUser), UserResponseUtils.getPublicUrl(lUser), certificates)
    }
  }

  def orgs(): Seq[OrgResponse] = {
    userService.orgs
      .map(x => OrgResponse(x.getOrganizationId, x.getName))
  }

  // def byPermission(permissionType: PermissionType): Seq[UserShortResponse]
  override def allCanView(viewAll: Boolean): Seq[UserShortResponse] = {
    val result = UserLocalServiceHelper()
      .getUsers(-1, -1)
      .asScala
      .filter(u => u.isActive && u.getFullName != "")
      .filter(user => canView(user, viewAll))
      .sortBy(x => x.getFullName)
      .toSeq
    result.map(x => UserShortResponse(x.getUserId, x.getFullName, UserResponseUtils.getPortraitUrl(x), UserResponseUtils.getPublicUrl(x)))
  }

  override def canView(liferayUser: LUser, viewAll: Boolean): Boolean = if (viewAll) {
    PermissionUtil.hasPermissionApi(liferayUser, ViewAllPermission, PortletName.GradeBook, PortletName.LearningTranscript)
  } else {
    PermissionUtil.hasPermissionApi(liferayUser, ViewPermission, PortletName.GradeBook, PortletName.LearningTranscript)
  }

  override def canView(liferayUserId: Long, viewAll: Boolean): Boolean = {
    canView(userService.byId(liferayUserId), viewAll)
  }

  override def getUserShortInfo(id:Long): UserShortResponse ={
    val lUser = byId(id)
    UserShortResponse(id, lUser.getFullName, UserResponseUtils.getPortraitUrl(lUser), UserResponseUtils.getPublicUrl(lUser))
  }
}
