package com.arcusys.learn.view

import javax.portlet.{ RenderResponse, RenderRequest }
import com.arcusys.learn.view.liferay.LiferayHelpers
import com.arcusys.learn.service.util.SessionHandler
import javax.servlet.http.Cookie
import com.arcusys.scorm.lms.UserManagement

trait SessionSupport {
  val userManagement: UserManagement

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
    SessionHandler.setAttribute(sessionID, "isAdmin", userManagement.isAdmin(userID, courseID))
    SessionHandler.setAttribute(sessionID, "hasTeacherPermissions", userManagement.hasTeacherPermissions(userID, courseID))
    SessionHandler.setAttribute(sessionID, "language", language) // TODO: Get language from HTTP header?
  }
}
