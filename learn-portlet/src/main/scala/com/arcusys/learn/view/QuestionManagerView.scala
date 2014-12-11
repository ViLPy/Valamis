package com.arcusys.learn.view

import java.io.FileNotFoundException
import javax.portlet._
import javax.servlet.http.Cookie

import com.arcusys.learn.liferay.util.PortalUtilHelper
import com.arcusys.learn.service.util.SessionHandler
import com.arcusys.learn.util.MustacheSupport
import com.arcusys.learn.view.extensions.{ ConfigurableView, TemplateCoupler, i18nSupport }
import com.arcusys.learn.view.liferay.LiferayHelpers
import org.scalatra.ScalatraFilter

class QuestionManagerView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport with ConfigurableView with TemplateCoupler {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    val language = LiferayHelpers.getLanguage(request)
    val out = response.getWriter
    val contextPath = request.getContextPath
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val courseID = themeDisplay.getLayout.getGroupId
    val userID = if (request.getRemoteUser != null) request.getRemoteUser.toInt else null.asInstanceOf[Int]
    val hasTeacherPermissions = userRoleService.hasTeacherPermissions(userID, courseID)

    val sessionID = SessionHandler.getSessionID(request.getRemoteUser)
    val cookie = new Cookie("valamisSessionID", sessionID)
    cookie.setMaxAge(-1)
    cookie.setPath("/")
    response.addProperty(cookie)
    SessionHandler.setAttribute(sessionID, "userID", request.getRemoteUser)
    SessionHandler.setAttribute(sessionID, "isAdmin", userRoleService.isAdmin(userID, courseID))
    SessionHandler.setAttribute(sessionID, "hasTeacherPermissions", userRoleService.hasTeacherPermissions(userID, courseID))

    val httpServletRequest = PortalUtilHelper.getHttpServletRequest(request)
    httpServletRequest.getSession.setAttribute("userID", userID)
    httpServletRequest.getSession.setAttribute("teacherPermissions", hasTeacherPermissions)

    if (hasTeacherPermissions)
      out.println(getTemplate("/templates/2.0/question_manager_templates.html") +
        getTemplate("/templates/2.0/question_tree_templates.html") +
        getTemplate("/templates/2.0/paginator.html") +
        getTemplate("/templates/2.0/site_select_templates.html") +
        getTemplate("/templates/2.0/file_uploader.html") +
        generateResponse(contextPath, "question_manager.html", language, true, courseID))
    else
      out.println(generateResponse(contextPath, "scorm_nopermissions.html", language))
  }

  override def doEdit(request: RenderRequest, response: RenderResponse) {
    val out = response.getWriter
    val language = LiferayHelpers.getLanguage(request)
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)

    val translations = try {
      getTranslation("/i18n/questionManager_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/questionManager_en")
      case _                        => Map[String, String]()
    }

    val data = Map("contextPath" -> request.getContextPath,
      "courseID" -> themeDisplay.getLayout.getGroupId,
      "pageID" -> themeDisplay.getLayout.getPrimaryKey,
      "language" -> language) ++ translations
    out.println(getTemplate("/templates/2.0/file_uploader.html") +
      mustache(data, "question_manager_settings.html"))

  }

  def generateResponse(contextPath: String, templateName: String, language: String) = {
    val translations = try {
      getTranslation("/i18n/error_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/error_en")
      case _                        => Map[String, String]()
    }
    val data = Map("contextPath" -> contextPath, "language" -> language) ++ translations
    mustache(data, templateName)
  }

  def generateResponse(contextPath: String, templateName: String, language: String, isPortlet: Boolean, courseID: Long) = {
    val translations = try {
      getTranslation("/i18n/questionManager_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/questionManager_en")
      case _                        => Map[String, String]()
    }
    val data = Map("contextPath" -> contextPath, "isPortlet" -> isPortlet, "language" -> language, "courseID" -> courseID) ++ translations
    mustache(data, templateName)
  }
}