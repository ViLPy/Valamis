package com.arcusys.learn.liferay.util

import com.liferay.portal.security.permission.{PermissionCheckerFactoryUtil, PermissionChecker}
import com.liferay.portal.model.User

object PermissionCheckerFactoryUtilHelper {
  def create(user: User): PermissionChecker =
    PermissionCheckerFactoryUtil.create(user)
}
