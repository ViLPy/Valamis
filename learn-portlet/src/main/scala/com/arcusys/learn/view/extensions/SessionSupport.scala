package com.arcusys.learn.view.extensions

import javax.portlet.{ RenderResponse, RenderRequest }
import com.arcusys.learn.bl.services.UserRoleServiceContract
import com.arcusys.learn.view.liferay.LiferayHelpers
import com.arcusys.learn.service.util.SessionHandler
import javax.servlet.http.Cookie

trait SessionSupport {
  val userRoleService: UserRoleServiceContract

  def setupSession(request: RenderRequest, response: RenderResponse) {
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val courseID = themeDisplay.getLayout.getGroupId
    val userID = themeDisplay.getUser.getUserId

    val language = LiferayHelpers.getLanguage(request)
    val sessionID = SessionHandler.getSessionID(request.getRemoteUser)
    val cookie = new Cookie("valamisSessionID", sessionID)
    cookie.setMaxAge(-1)
    cookie.setPath("/")
    response.addProperty(cookie)
    SessionHandler.setAttribute(sessionID, "userID", request.getRemoteUser)
    SessionHandler.setAttribute(sessionID, "isAdmin", userRoleService.isAdmin(userID, courseID))
    SessionHandler.setAttribute(sessionID, "hasTeacherPermissions", userRoleService.hasTeacherPermissions(userID, courseID))
    SessionHandler.setAttribute(sessionID, "language", language) // TODO: Get language from HTTP header?
  }
}
