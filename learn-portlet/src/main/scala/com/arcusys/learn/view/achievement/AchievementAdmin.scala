package com.arcusys.learn.view.achievement

import javax.portlet.{RenderResponse, RenderRequest}
import com.arcusys.learn.view.{BaseCurriculum}
import com.arcusys.scorm.lms.{ActivityRepository}
import com.arcusys.learn.service.util.SessionHandler
import javax.servlet.http.Cookie
import com.arcusys.learn.view.liferay.LiferayHelpers

/**
 * Created with IntelliJ IDEA.
 * User: iliya.tryapitsin
 * Date: 08.01.14
 * Time: 15:17
 * To change this template use File | Settings | File Templates.
 */
class AchievementAdmin extends BaseCurriculum {

    val activityDataSource = new ActivityRepository()

    override def doView(
      request: RenderRequest,
      response: RenderResponse) {

        val userId = Option(request.getRemoteUser).map(_.toInt).getOrElse(0)
        val language = LiferayHelpers.getLanguage(request)
        val courseId = LiferayHelpers.getThemeDisplay(request).getScopeGroupId

        val sessionID = SessionHandler.getSessionID(request.getRemoteUser)
        val cookie = new Cookie("valamisSessionID", sessionID)
        cookie.setMaxAge(-1)
        cookie.setPath("/")
        response.addProperty(cookie)
        SessionHandler.setAttribute(sessionID, "userID", request.getRemoteUser)
        SessionHandler.setAttribute(sessionID, "isAdmin", userManagement.isAdmin(userId, courseId))
        SessionHandler.setAttribute(sessionID, "hasTeacherPermissions", userManagement.hasTeacherPermissions(userId, courseId))
        SessionHandler.setAttribute(sessionID, "language", language)

        super.renderAdminView(
          request,
          response,
          "achievement_admin.html")
    }
}
