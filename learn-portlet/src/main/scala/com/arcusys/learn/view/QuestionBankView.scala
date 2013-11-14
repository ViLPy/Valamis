package com.arcusys.learn.view

import com.arcusys.scala.scalatra.mustache.MustacheSupport
import javax.portlet._
import liferay.LiferayHelpers
import org.scalatra.ScalatraFilter
import java.io.FileNotFoundException
import com.liferay.portal.util.PortalUtil
import com.arcusys.learn.service.util.SessionHandler
import javax.servlet.http.Cookie

class QuestionBankView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport with ConfigurableView {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    val language = LiferayHelpers.getLanguage(request)
    val out = response.getWriter
    val contextPath = request.getContextPath
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val courseID = themeDisplay.getLayout.getGroupId
    val userID = themeDisplay.getUser.getUserId
    val hasTeacherPermissions = userManagement.hasTeacherPermissions(userID, courseID)

    val sessionID = SessionHandler.getSessionID(request.getRemoteUser)
    val cookie = new Cookie("valamisSessionID", sessionID)
    cookie.setMaxAge(-1)
    cookie.setPath("/")
    response.addProperty(cookie)
    SessionHandler.setAttribute(sessionID, "userID", request.getRemoteUser)
    SessionHandler.setAttribute(sessionID, "isAdmin", userManagement.isAdmin(userID, courseID))
    SessionHandler.setAttribute(sessionID, "hasTeacherPermissions", userManagement.hasTeacherPermissions(userID, courseID))

    val httpServletRequest = PortalUtil.getHttpServletRequest(request)
    httpServletRequest.getSession.setAttribute("userID", userID)
    httpServletRequest.getSession.setAttribute("teacherPermissions", hasTeacherPermissions)

    if (hasTeacherPermissions)
      out.println(generateResponse(contextPath, "scorm_questionbank.html", language, true, courseID))
    else
      out.println(generateResponse(contextPath, "scorm_nopermissions.html", language))
  }

  def generateResponse(contextPath: String, templateName: String, language: String) = {
    val translations = try {
      getTranslation("/i18n/error_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/error_en")
      case _ => Map[String, String]()
    }
    val data = Map("contextPath" -> contextPath, "language" -> language) ++ translations
    mustache(data, templateName)
  }

  def generateResponse(contextPath: String, templateName: String, language: String, isPortlet: Boolean, courseID: Long) = {
    val translations = try {
      getTranslation("/i18n/questionbank_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/questionbank_en")
      case _ => Map[String, String]()
    }
    val data = Map("contextPath" -> contextPath, "isPortlet" -> isPortlet, "language" -> language, "courseID" -> courseID) ++ translations
    mustache(data, templateName)
  }
}