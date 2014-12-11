package com.arcusys.learn.bl.services

import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.constants.QueryUtilHelper
import com.arcusys.learn.liferay.services.{ OrganizationLocalServiceHelper, UserLocalServiceHelper }
import com.arcusys.learn.scorm.tracking.model.PermissionType._
import com.arcusys.learn.scorm.tracking.storage.UserStorage
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }
import com.liferay.portal.model.Organization
import scala.collection.JavaConverters._
import com.arcusys.learn.scorm.tracking.model.User

// TODO: refactor (get by id)
class UserService(config: BindingModule) extends UserServiceContract with Injectable {
  def this() = this(DomainConfiguration)
  implicit val bindingModule = config

  val userStorage = inject[UserStorage]
  lazy val roleFacade = inject[RoleServiceContract]

  def all(courseId: Long, skip: Int, take: Int, filter: String, sortAZ: Boolean): Seq[LUser] = {
    var users = UserLocalServiceHelper()
      .getGroupUsers(courseId)
      .asScala
      .filter(u => u.isActive && u.getFullName != "")
      .sortBy(x => x.getFullName)

    users = users.filter(x => if (filter != "") x.getFullName.toLowerCase.contains(filter.toLowerCase) else true)

    if (!sortAZ) users = users.reverse

    users.drop(skip).take(take)
  }

  def all(companyID: Long,
    orgID: Long,
    skip: Int,
    take: Int,
    filter: String,
    sortAZ: Boolean): Seq[LUser] = {

    var users = UserLocalServiceHelper()
      .getCompanyUsers(companyID, QueryUtilHelper.ALL_POS, QueryUtilHelper.ALL_POS)
      .asScala
      .filter(u => u.isActive && u.getFullName != "")
      .sortBy(x => x.getFullName)

    users = users.filter(x => x.getFullName.toLowerCase.contains(filter.toLowerCase))

    if (orgID != -1)
      users = users.filter(u => {
        u.getOrganizations.asScala.map(_.getOrganizationId).contains(orgID)
      })

    if (!sortAZ)
      users = users.reverse

    if (skip < 0)
      users
    else
      users.drop(skip).take(take)
  }

  def byId(id: Int): LUser = UserLocalServiceHelper().getUser(id)

  def byPermission(permissionType: PermissionType): Seq[LUser] = {
    val liferayRoles = roleFacade.getForPermission(permissionType)

    liferayRoles flatMap { role =>
      UserLocalServiceHelper().getUsersByRoleId(role.liferayRoleID).asScala
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

  def orgs(): Seq[Organization] = {
    OrganizationLocalServiceHelper
      .getOrganizations(QueryUtilHelper.ALL_POS, QueryUtilHelper.ALL_POS)
      .asScala
  }

  def getUserCertificates(id: Int, lUser: LUser, withOpenBadges: Boolean) = {
    val certificateFacade = inject[CertificateServiceContract]
    if (withOpenBadges) {
      certificateFacade.getCertificatesByUserWithOpenBadges(lUser.getCompanyId.toInt, id, true)
    } else
      certificateFacade.getForUser(lUser.getCompanyId.toInt, id)
    //certificateFacade.getForUser(lUser.getCompanyId.toInt, id, true)
  }

  override private[services] def all(companyId: Int): Seq[LUser] = UserLocalServiceHelper()
    .getCompanyUsers(companyId, QueryUtilHelper.ALL_POS, QueryUtilHelper.ALL_POS)
    .asScala

  def getUserOption(userId: Int): Option[User] = {
    userStorage.getByID(userId)
  }

  // TODO rename
  def createAndGetId(userId: Int, name: String): Unit = {
    userStorage.createAndGetID(new User(userId, name))
  }
}
