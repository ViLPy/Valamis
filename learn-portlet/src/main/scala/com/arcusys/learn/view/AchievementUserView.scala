package com.arcusys.learn.view

import javax.portlet.{RenderResponse, RenderRequest, GenericPortlet}
import org.scalatra.ScalatraFilter
import com.arcusys.scala.scalatra.mustache.MustacheSupport
import com.arcusys.learn.view.liferay.LiferayHelpers
import org.json4s.jackson.JsonMethods
import org.json4s.JsonDSL._
import java.io.FileNotFoundException
import com.liferay.portal.util.PortalUtil
import com.arcusys.scorm.lms.AchievementUserServiceBL
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.service.util.SessionHandler
import javax.servlet.http.Cookie

class AchievementUserView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport with ConfigurableView {
  val configuration = Configuration
  override def destroy() {}

  protected def getTranslation(view: String, language: String): Map[String, String] = {
    try {
      getTranslation("/i18n/" + view + "_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/" + view + "_en")
      case _ => Map[String, String]()
    }
  }

  override def doView(request: RenderRequest, response: RenderResponse) {
    val userId = if (request.getRemoteUser != null) request.getRemoteUser.toInt else 0
    val language = LiferayHelpers.getLanguage(request)
    val translations = getTranslation("curriculum", language)
    val courseID = LiferayHelpers.getThemeDisplay(request).getScopeGroupId
    val companyId = PortalUtil.getCompanyId(request)

    val sessionID = SessionHandler.getSessionID(request.getRemoteUser)
    val cookie = new Cookie("valamisSessionID", sessionID)
    cookie.setMaxAge(-1)
    cookie.setPath("/")
    response.addProperty(cookie)
    SessionHandler.setAttribute(sessionID, "userID", request.getRemoteUser)
    SessionHandler.setAttribute(sessionID, "isAdmin", userManagement.isAdmin(userId, courseID))
    SessionHandler.setAttribute(sessionID, "hasTeacherPermissions", userManagement.hasTeacherPermissions(userId, courseID))
    SessionHandler.setAttribute(sessionID, "language", language)

    val templateName = "achievement_user.html"
    val curriculumTemplates = scala.io.Source.fromFile(getPortletContext.getRealPath("/templates/curriculum_templates.html")).mkString

    val data = Map("curriculumTemplates_" -> curriculumTemplates  ,"companyId_" -> companyId ,"userId" -> userId, "translations_" -> JsonMethods.compact(JsonMethods.render(translations))) ++ translations
    response.getWriter.println(mustache(data, templateName))

  }

}
