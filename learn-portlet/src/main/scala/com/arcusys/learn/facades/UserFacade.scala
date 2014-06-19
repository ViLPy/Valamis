package com.arcusys.learn.facades

import com.arcusys.learn.liferay.services.{ OrganizationLocalServiceHelper, UserLocalServiceHelper }
import com.arcusys.learn.liferay.constants.QueryUtilHelper
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.models.OrgResponse
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import scala.collection.JavaConverters._
import com.arcusys.learn.scorm.tracking.storage.UserStorage
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.response.certificates.CertificateShortResponse
import com.arcusys.learn.models.response.users.{ UserResponseUtils, UserShortResponse, UserResponse }
import com.arcusys.learn.scorm.tracking.model.PermissionType._
import com.arcusys.learn.models.response.users.UserShortResponse
import com.arcusys.learn.models.OrgResponse
import com.arcusys.learn.models.response.certificates.CertificateShortResponse
import com.arcusys.learn.models.response.users.UserResponse

/**
 * Created by Iliya Tryapitsin on 19.03.14.
 */
class UserFacade(config: BindingModule) extends UserFacadeContract with Injectable with Paginator {
  def this() = this(Configuration)
  implicit val bindingModule = config

  val userStorage = inject[UserStorage]
  lazy val roleFacade = inject[RoleFacadeContract]

  def all(courseId: Long,
    skip: Int,
    take: Int,
    filter: String,
    sortAZ: Boolean): Seq[LUser] = {
    val users = UserLocalServiceHelper()
      .getGroupUsers(courseId)
      .asScala
      .filter(u => u.isActive && u.getFullName != "")
      .sortBy(x => x.getFullName)

    val nameFiltered = users.filter(x => if (filter != "") x.getFullName.toLowerCase.contains(filter.toLowerCase) else true)

    return takeForPage(nameFiltered, skip, take, sortAZ)
  }

  def all(companyID: Long,
    orgID: Long,
    skip: Int,
    take: Int,
    filter: String,
    sortAZ: Boolean): Seq[UserShortResponse] = {

    val allUsers = UserLocalServiceHelper()
      .getCompanyUsers(companyID, QueryUtilHelper.ALL_POS, QueryUtilHelper.ALL_POS)
      .asScala
      .filter(u => u.isActive && u.getFullName != "")
      .sortBy(x => x.getFullName)

    val nameFiltered = allUsers.filter(x => x.getFullName.toLowerCase.contains(filter.toLowerCase))
    val orgFiltered = if (orgID != -1) nameFiltered.filter(u => {
      u.getOrganizations.asScala.map(_.getOrganizationId).contains(orgID)
    })
    else nameFiltered
    val result = takeForPage(orgFiltered, skip, take, sortAZ)

    result.map(x => UserShortResponse(x.getUserId, x.getFullName, UserResponseUtils.getPortraitUrl(x), UserResponseUtils.getPublicUrl(x)))
  }

  def byId(id: Int): LUser = UserLocalServiceHelper().getUser(id)

  def byId(id: Int, isShortResult: Boolean, withOpenBadges: Boolean): AnyRef = {
    val lUser = UserLocalServiceHelper().getUser(id)
    val certificateFacade = inject[CertificateFacadeContract]

    if (isShortResult)
      UserShortResponse(id, lUser.getFullName, UserResponseUtils.getPortraitUrl(lUser), UserResponseUtils.getPublicUrl(lUser))
    else {
      val certificates = if (withOpenBadges) {
        certificateFacade.getCertificatesByUserWithOpenBadges(lUser.getCompanyId.toInt, id, true)
      } else
        certificateFacade.getForUser(lUser.getCompanyId.toInt, id, true)

      UserResponse(id, lUser.getFullName, UserResponseUtils.getPortraitUrl(lUser), UserResponseUtils.getPublicUrl(lUser), certificates)
    }
  }

  def byPermission(permissionType: PermissionType): Seq[UserShortResponse] = {
    val liferayRoles = roleFacade.getForPermission(permissionType)

    liferayRoles flatMap { role =>
      val users = UserLocalServiceHelper().getUsersByRoleId(role.liferayRoleId).asScala
      users map { u => UserShortResponse(u.getUserId, u.getFullName, email = Option(u.getEmailAddress)) }
    }
  }

  def count(companyId: Long,
    orgID: Long,
    filter: String): Int = {
    val users = UserLocalServiceHelper()
      .getCompanyUsers(companyId, QueryUtilHelper.ALL_POS, QueryUtilHelper.ALL_POS)
      .asScala
      .filter(u => u.isActive && u.getFullName != "")
      .filter(x => x.getFullName.toLowerCase.contains(filter.toLowerCase))
    val orgFiltered = if (orgID != -1) users.filter(u => {
      u.getOrganizations.asScala.map(_.getOrganizationId).contains(orgID)
    })
    else users

    orgFiltered.length
  }

  def orgs(): Seq[OrgResponse] = {
    OrganizationLocalServiceHelper
      .getOrganizations(QueryUtilHelper.ALL_POS, QueryUtilHelper.ALL_POS)
      .asScala
      .map(x => OrgResponse(x.getOrganizationId, x.getName))
  }

  override private[facades] def all(companyId: Int): Seq[LUser] = UserLocalServiceHelper()
    .getCompanyUsers(companyId, QueryUtilHelper.ALL_POS, QueryUtilHelper.ALL_POS)
    .asScala
}
