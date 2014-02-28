package com.arcusys.learn.liferay.util

import com.liferay.portal.security.permission.{PermissionThreadLocal, PermissionChecker}

object PermissionThreadLocalHelper {
  def setPermissionChecker(permissionChecker: PermissionChecker) {
    PermissionThreadLocal.setPermissionChecker(permissionChecker)
  }
}
