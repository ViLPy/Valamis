package com.arcusys.learn.liferay.services

import com.liferay.portal.kernel.dao.orm._
import com.liferay.portal.kernel.workflow.WorkflowConstants
import com.liferay.portal.model.User
import com.liferay.portal.service.{ ServiceContext, UserLocalServiceUtil }
import java.util.Locale
import com.liferay.portal.webserver.WebServerServletTokenUtil
import com.liferay.portal.kernel.util.DigesterUtil
import com.liferay.portal.kernel.util.HttpUtil

import scala.collection.JavaConverters._

object UserLocalServiceHelper {
  def apply() = new UserLocalServiceHelper {}
}

trait UserLocalServiceHelper {
  def getCompanyUsers(companyId: Long, start: Int, end: Int): java.util.List[User] =
    UserLocalServiceUtil.getCompanyUsers(companyId, start, end)

  def getOrganizationUsers(organizationId: Long): java.util.List[User] =
    UserLocalServiceUtil.getOrganizationUsers(organizationId)

  def getUsers(start: Int, end: Int): java.util.List[User] = UserLocalServiceUtil.getUsers(start, end)

  def getUser(userId: Long): User = UserLocalServiceUtil.getUser(userId)

  def getUserById(companyId: Long, userId: Long): User = UserLocalServiceUtil.getUserById(companyId, userId)

  def getRoleUsersCount(roleId: Long): Int = UserLocalServiceUtil.getRoleUsersCount(roleId)

  def getUsersByRoleId(liferayRoleId: Long): java.util.List[User] = UserLocalServiceUtil.getRoleUsers(liferayRoleId)

  def addGroupUsers(groupId: Long, userIds: Array[Long]) {
    UserLocalServiceUtil.addGroupUsers(groupId, userIds)
  }

  def getGroupUsers(groupId: Long): java.util.List[User] =
    UserLocalServiceUtil.getGroupUsers(groupId)

  def getGroupUserIds(groupId: Long): Seq[Long] = {

    val userIdsInGroup = UserLocalServiceUtil.getGroupUserIds(groupId).toSeq.asJavaCollection

    if (userIdsInGroup.isEmpty) Seq()
    else {
      val userQuery = UserLocalServiceUtil.dynamicQuery()
      userQuery
        .add(RestrictionsFactoryUtil.in("userId", userIdsInGroup))
        .add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED))
        .add(RestrictionsFactoryUtil
          .or(RestrictionsFactoryUtil.ne("firstName", ""),
            RestrictionsFactoryUtil.ne("lastName", "")))
        .addOrder(OrderFactoryUtil.asc("lastName"))
        .addOrder(OrderFactoryUtil.asc("firstName"))

      userQuery.setProjection(ProjectionFactoryUtil.projectionList()
        .add(ProjectionFactoryUtil.property("userId")))

      UserLocalServiceUtil.dynamicQuery(userQuery).asScala.map(_.asInstanceOf[Long])
    }
  }

  def getDefaultUserId(companyId: Long): Long = UserLocalServiceUtil.getDefaultUserId(companyId)

  def unsetOrganizationUsers(organizationId: Long, userIds: Array[Long]) {
    UserLocalServiceUtil.unsetOrganizationUsers(organizationId, userIds)
  }

  def addUser(creatorUserId: Long, companyId: Long, autoPassword: Boolean,
    password1: String, password2: String,
    autoScreenName: Boolean, screenName: String, emailAddress: String,
    facebookId: Long, openId: String, locale: Locale,
    firstName: String, middleName: String, lastName: String,
    prefixId: Int, suffixId: Int, male: Boolean,
    birthdayMonth: Int, birthdayDay: Int, birthdayYear: Int,
    jobTitle: String, groupIds: Array[Long], organizationIds: Array[Long],
    roleIds: Array[Long], userGroupIds: Array[Long], sendEmail: Boolean,
    serviceContext: ServiceContext): User =
    UserLocalServiceUtil.addUser(creatorUserId, companyId, autoPassword, password1, password2,
      autoScreenName, screenName, emailAddress, facebookId, openId, locale,
      firstName, middleName, lastName, prefixId, suffixId, male,
      birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds,
      roleIds, userGroupIds, sendEmail, serviceContext)

  def updatePortrait(userId: Long, bytes: Array[Byte]): User = UserLocalServiceUtil.updatePortrait(userId, bytes)

  def updateReminderQuery(userId: Long, question: String, answer: String): User =
    UserLocalServiceUtil.updateReminderQuery(userId, question, answer)

  def getPortraitTime(portraitId: Long) = {
    WebServerServletTokenUtil.getToken(portraitId)
  }
  def getPortraitToken(user: User) = {
    HttpUtil.encodeURL(DigesterUtil.digest(user.getUserUuid))
  }
}
