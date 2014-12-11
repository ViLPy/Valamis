package com.arcusys.learn.view

import javax.portlet._
import liferay.LiferayHelpers
import org.scalatra.ScalatraFilter
import java.io.FileNotFoundException
import com.arcusys.learn.service.util.SessionHandler
import javax.servlet.http.Cookie
import com.arcusys.learn.liferay.services.JournalArticleLocalServiceHelper
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.constants.WebKeysHelper
import com.arcusys.learn.liferay.util.PortalUtilHelper
import com.arcusys.learn.util.{ JsonSupport, MustacheSupport }
import com.arcusys.learn.view.extensions.{ ConfigurableView, i18nSupport, TemplateCoupler }
import java.net.URLEncoder

class LessonDesignerView extends GenericPortlet with ScalatraFilter with MustacheSupport with JsonSupport with i18nSupport with ConfigurableView with TemplateCoupler {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) = {
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)

    val language = LiferayHelpers.getLanguage(request)
    val userUID = request.getRemoteUser
    val userID = themeDisplay.getUser.getUserId
    val courseID = themeDisplay.getLayout.getGroupId
    val companyId = PortalUtilHelper.getCompanyId(request)

    val sessionID = SessionHandler.getSessionID(request.getRemoteUser)
    val cookie = new Cookie("valamisSessionID", sessionID)
    cookie.setMaxAge(-1)
    cookie.setPath("/")
    response.addProperty(cookie)
    SessionHandler.setAttribute(sessionID, "userID", request.getRemoteUser)
    SessionHandler.setAttribute(sessionID, "isAdmin", userRoleService.isAdmin(userID, courseID))
    SessionHandler.setAttribute(sessionID, "hasTeacherPermissions", userRoleService.hasTeacherPermissions(userID, courseID))

    val httpServletRequest = PortalUtilHelper.getHttpServletRequest(request)
    httpServletRequest.getSession.setAttribute("userID", userUID)

    val out = response.getWriter
    val path = request.getContextPath

    val hasPermissions = userRoleService.hasTeacherPermissions(userID, courseID)
    if (hasPermissions) {
      val groupID = themeDisplay.getScopeGroupId
      val translations = getTranslation("lessonDesigner", language)
      val map = Map(
        "contextPath" -> path,
        "isAdmin" -> hasPermissions,
        "isPortlet" -> true,
        "language" -> language,
        "courseID" -> courseID,
        "actionURL" -> response.createResourceURL(),
        "companyID" -> companyId) ++ Map(
          "userID" -> userUID,
          "groupID" -> groupID.toString) ++
          translations ++ Map(
            "translations" -> JsonSupport.json(translations).get
          )

      out.println(mustache(map, "/js2.0/lesson-designer/globalVariables.html") +
        getTemplate("/templates/2.0/question_tree_templates.html") +
        getTemplate("/templates/2.0/lesson_designer_templates.html") +
        getTemplate("/templates/2.0/file_uploader.html") +
        getTemplate("/templates/2.0/paginator.html") +
        getTemplate("/templates/2.0/image_gallery_templates.html") +
        mustache(map, "lesson_designer.html")
      )
    } else {
      val translations = getTranslation("error", language)
      val data = mustache(Map("contextPath" -> path, "language" -> language) ++ translations, "scorm_nopermissions.html")
      out.println(data)
    }
  }

  override def doEdit(request: RenderRequest, response: RenderResponse) {
    val out = response.getWriter
    val language = LiferayHelpers.getLanguage(request)
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)

    val data = Map("contextPath" -> request.getContextPath,
      "courseID" -> themeDisplay.getLayout.getGroupId,
      "pageID" -> themeDisplay.getLayout.getPrimaryKey,
      "language" -> language) ++ getTranslation("lessonDesigner", language)
    out.println(getTemplate("/templates/2.0/file_uploader.html") +
      mustache(data, "lesson_designer_settings.html"))

  }

  private def getTranslation(view: String, language: String): Map[String, String] = {
    try {
      getTranslation("/i18n/" + view + "_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/" + view + "_en")
      case _                        => Map[String, String]()
    }
  }

  override def serveResource(request: ResourceRequest, response: ResourceResponse) {
    val groupID = request.getParameter("groupID").toLong
    val articleID = request.getParameter("articleID")
    val articleLanguage = request.getParameter("language")
    val td = request.getAttribute(WebKeysHelper.THEME_DISPLAY).asInstanceOf[LThemeDisplay]
    val text = JournalArticleLocalServiceHelper.getArticleContent(groupID, articleID, "view", articleLanguage, td)

    response.getWriter.println(json(Map("text" -> URLEncoder.encode(text, "UTF-8"))).get)
  }
}