package com.arcusys.learn.liferay.services

import com.liferay.portal.model.UserGroupRole
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil

object UserGroupRoleLocalServiceHelper {
  def addUserGroupRoles(userId: Long, groupId: Long, roleIds: Array[Long]): java.util.List[UserGroupRole] =
    UserGroupRoleLocalServiceUtil.addUserGroupRoles(userId, groupId, roleIds)
}
