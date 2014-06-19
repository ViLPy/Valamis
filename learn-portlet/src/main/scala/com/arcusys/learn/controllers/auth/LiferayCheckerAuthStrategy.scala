package com.arcusys.learn.controllers.auth

import org.scalatra.ScalatraBase
import com.liferay.portal.security.auth.{ CompanyThreadLocal, PrincipalThreadLocal }
import scala.util.Try
import com.liferay.portal.security.permission.{ PermissionCheckerFactoryUtil, PermissionThreadLocal }
import com.liferay.portal.util.PortalUtil
import javax.servlet.http.{ HttpServletRequest, HttpServletResponse }
import com.arcusys.learn.view.liferay.LiferayHelpers

/**
 * Created by Iliya Tryapitsin on 04.04.2014.
 */
class LiferayCheckerAuthStrategy(protected val app: ScalatraBase) extends LiferayAuthStrategy {

  def authenticate()(implicit request: HttpServletRequest, response: HttpServletResponse) = {
    def findUserAndSetupPermissions = {
      val cookies = request.getCookies()

      cookies.foreach(cookie => request.setAttribute(cookie.getName, cookie.getValue))

      val user = PortalUtil.getUser(request)

      val permissionChecker = PermissionCheckerFactoryUtil.create(user)

      PermissionThreadLocal.setPermissionChecker(permissionChecker)
      PrincipalThreadLocal.setName(user.getUserId)
      CompanyThreadLocal.setCompanyId(user.getCompanyId)

      LiferayAuthUser(user.getEmailAddress)
    }

    Try(findUserAndSetupPermissions).toOption
  }
}

