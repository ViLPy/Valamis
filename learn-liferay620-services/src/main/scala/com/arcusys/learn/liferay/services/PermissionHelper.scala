package com.arcusys.learn.liferay.services

import com.arcusys.learn.liferay.LiferayClasses.LUser
import com.liferay.portal.security.auth.PrincipalThreadLocal
import com.liferay.portal.security.permission.{ PermissionCheckerFactoryUtil, PermissionThreadLocal, PermissionChecker }
import com.liferay.portal.service.UserLocalServiceUtil

/**
 * Created by asemenov on 22.01.15.
 */
object PermissionHelper {

  def getPermissionChecker(): PermissionChecker = {
    PermissionThreadLocal.getPermissionChecker
  }

  def getPermissionChecker(user: LUser): PermissionChecker = {
    PermissionCheckerFactoryUtil.create(user)
  }

  def preparePermissionChecker(userId: Long): Unit = {
    val user = UserLocalServiceUtil.getUserById(userId)
    preparePermissionChecker(user)
  }
  
  def preparePermissionChecker(user: LUser): Unit = {
    val permissionChecker = PermissionCheckerFactoryUtil.create(user)

    PermissionThreadLocal.setPermissionChecker(permissionChecker)
    PrincipalThreadLocal.setName(user.getUserId)
  }
}
