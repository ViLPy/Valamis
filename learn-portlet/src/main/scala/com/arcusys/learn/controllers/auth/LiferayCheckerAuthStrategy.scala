package com.arcusys.learn.controllers.auth

import javax.servlet.http.{ HttpServletRequest, HttpServletResponse }

import com.arcusys.learn.liferay.services.PermissionHelper
import com.liferay.portal.security.auth.CompanyThreadLocal
import com.liferay.portal.service.UserLocalServiceUtil
import com.liferay.portal.util.PortalUtil
import org.scalatra.ScalatraBase

import scala.util.Try

/**
 * Created by Iliya Tryapitsin on 04.04.2014.
 */
class LiferayCheckerAuthStrategy(protected val app: ScalatraBase)(implicit request: HttpServletRequest, response: HttpServletResponse) extends LiferayAuthStrategy {

  def authenticate()(implicit request: HttpServletRequest, response: HttpServletResponse) = {
    def findUserAndSetupPermissions = {
      val user = getUserByRequest()

      PermissionHelper.preparePermissionChecker(user)
      CompanyThreadLocal.setCompanyId(user.getCompanyId)

      AuthUser(user.getUserId, user)
    }

    Try(findUserAndSetupPermissions).toOption
  }

  def getUserByRequest()(implicit request: HttpServletRequest) = {

    val user = PortalUtil.getUser(request)
    if (user == null) {
      val defaultCompanyId = PortalUtil.getDefaultCompanyId()
      UserLocalServiceUtil.getDefaultUser(defaultCompanyId)
    } else user

  }
}

