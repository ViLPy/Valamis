package com.arcusys.learn.view

import javax.portlet.{ RenderResponse, RenderRequest, GenericPortlet }
import liferay.LiferayHelpers
import org.scalatra.ScalatraFilter
import java.io.FileNotFoundException
import com.arcusys.learn.service.util.SessionHandler
import javax.servlet.http.Cookie

import org.json4s.jackson.JsonMethods
import org.json4s.JsonDSL._
import com.arcusys.learn.liferay.services._
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.constants.QueryUtilHelper
import com.arcusys.learn.liferay.util.{ PortalUtilHelper, PortletURLUtilHelper }
import com.arcusys.learn.util.MustacheSupport

/**
 * User: Yulia.Glushonkova
 * Date: 07.06.13
 */
abstract class CurriculumAbstract extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport with ConfigurableView with TemplateCoupler {
  implicit val formats = org.json4s.DefaultFormats

  override def destroy() {}

  protected def doViewHelper(request: RenderRequest, response: RenderResponse): Map[String, Any] = {
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val userID = if (request.getRemoteUser != null) request.getRemoteUser.toInt else null.asInstanceOf[Int]
    val language = LiferayHelpers.getLanguage(request)
    val path = request.getContextPath

    val courseID = themeDisplay.getScopeGroupId
    val httpServletRequest = PortalUtilHelper.getHttpServletRequest(request)
    val url = getRootUrl(request, response)

    // Session management
    val sessionID = SessionHandler.getSessionID(request.getRemoteUser)
    val cookie = new Cookie("valamisSessionID", sessionID)
    cookie.setMaxAge(-1)
    cookie.setPath("/")
    response.addProperty(cookie)
    SessionHandler.setAttribute(sessionID, "userID", request.getRemoteUser)
    SessionHandler.setAttribute(sessionID, "hasTeacherPermissions", userManagement.hasTeacherPermissions(userID, courseID))
    SessionHandler.setAttribute(sessionID, "isAdmin", userManagement.isAdmin(userID, courseID))

    httpServletRequest.getSession.setAttribute("userID", userID)

    val translations = getTranslation("curriculum", language)
    val companyId = PortalUtilHelper.getCompanyId(request)

    val data = Map("root" -> url, "contextPath" -> path, "userID" -> userID, "isAdmin" -> userManagement.isAdmin(userID, courseID),
      "language" -> language, "courseID" -> courseID, "companyID" -> companyId, "translations_" -> JsonMethods.compact(JsonMethods.render(translations))
    ) ++ translations
    data
  }

  private def getRootUrl(request: RenderRequest, response: RenderResponse) = {
    val url = PortletURLUtilHelper.getCurrent(request, response)
    val parts = url.toString.split("/")
    if (parts.length > 2) parts.tail.tail.head else ""
  }

  def generateResponse(data: Map[String, Any], templateName: String) = {
    getTemplate("/templates/2.0/curriculum_templates.html") +
      getTemplate("/templates/2.0/paginator.html") +
      getTemplate("/templates/2.0/file-uploader.html") +
      mustache(data, templateName)
  }

  protected def getTranslation(view: String, language: String): Map[String, String] = {
    try {
      getTranslation("/i18n/" + view + "_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/" + view + "_en")
      case _                        => Map[String, String]()
    }
  }
}

class CurriculumAdmin extends CurriculumAbstract {
  override def doView(request: RenderRequest, response: RenderResponse) {
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val userID = if (request.getRemoteUser != null) request.getRemoteUser.toInt else null.asInstanceOf[Int]
    val courseID = themeDisplay.getScopeGroupId
    val (html, data) = if (userManagement.hasTeacherPermissions(userID, courseID)) {
      ("curriculum_admin.html", super.doViewHelper(request: RenderRequest, response: RenderResponse))
    } else {
      val path = request.getContextPath
      val language = LiferayHelpers.getLanguage(request)
      val translations = getTranslation("error", language)
      val data = Map("contextPath" -> path, "language" -> language) ++ translations
      ("scorm_nopermissions.html", data)
    }
    response.getWriter.println(generateResponse(data, html))
  }

}

class CurriculumUser extends CurriculumAbstract {
  override def doView(request: RenderRequest, response: RenderResponse) {
    val html = "curriculum_user.html"
    val data = super.doViewHelper(request: RenderRequest, response: RenderResponse)
    response.getWriter.println(generateResponse(data, html))
  }
}