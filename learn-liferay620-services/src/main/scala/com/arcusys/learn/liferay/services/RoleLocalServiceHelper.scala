package com.arcusys.learn.liferay.services

import com.liferay.portal.model.Role
import com.liferay.portal.service.RoleLocalServiceUtil
import java.util.Locale

object RoleLocalServiceHelper {
  def getRoles(companyId: Long): java.util.List[Role] = RoleLocalServiceUtil.getRoles(companyId)

  def getRole(roleId: Long): Role = RoleLocalServiceUtil.getRole(roleId)

  def getRole(companyId: Long, name: String): Role = RoleLocalServiceUtil.getRole(companyId, name)

  def addRole(userId: Long,
    companyId: Long,
    name: String,
    titleMap: java.util.Map[Locale, String],
    descriptionMap: java.util.Map[Locale, String],
    roleType: Int): Role =
    RoleLocalServiceUtil.addRole(userId, companyId, name, titleMap, descriptionMap, roleType)

  def getUserGroupRoles(userId: Long, groupId: Long): java.util.List[Role] =
    RoleLocalServiceUtil.getUserGroupRoles(userId, groupId)

  def getUserRoles(userId: Long): java.util.List[Role] =
    RoleLocalServiceUtil.getUserRoles(userId)
}
