package com.arcusys.learn.controllers.auth

import javax.servlet.http.{ HttpServletResponse, HttpServletRequest }

import com.arcusys.learn.liferay.services.UserLocalServiceHelper
import com.liferay.portal.model.User
import com.liferay.portal.util.PortalUtil
import org.scalatra.ScalatraBase
import org.scalatra.auth.strategy.BasicAuthStrategy

import scala.util.Try

/**
 * Created by igorborisov on 31.10.14.
 */
class LiferayCheckerBasicAuthStrategy(protected override val app: ScalatraBase, realm: String)(implicit request: HttpServletRequest, response: HttpServletResponse) extends LiferayBasicAuthStrategy[LiferayAuthUser](app, realm) {

  override protected def getUserId(user: LiferayAuthUser)(implicit request: HttpServletRequest, response: HttpServletResponse): String = user.id.toString

  override protected def validate(userName: String, password: String)(implicit request: HttpServletRequest, response: HttpServletResponse): Option[LiferayAuthUser] = {

    //todo check by login/pass
    val userId = Try(PortalUtil.getBasicAuthUserId(request)).toOption
    if (userId.isDefined) {
      val userService = UserLocalServiceHelper()
      val user = userService.getUser(userId.get)

      if (user != null) Option(LiferayAuthUser(userId.get, user))
      else None
    } else None

  }
}
