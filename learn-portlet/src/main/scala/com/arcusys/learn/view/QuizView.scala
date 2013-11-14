package com.arcusys.learn.view

import com.arcusys.scala.scalatra.mustache.MustacheSupport
import javax.portlet._
import liferay.LiferayHelpers
import org.scalatra.ScalatraFilter
import java.io.FileNotFoundException
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil
import com.liferay.portal.kernel.util.WebKeys
import com.liferay.portal.theme.ThemeDisplay
import com.liferay.portal.util.PortalUtil
import com.arcusys.learn.service.util.SessionHandler
import javax.servlet.http.Cookie

class QuizView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport with ConfigurableView {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) = {
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)

    val language = LiferayHelpers.getLanguage(request)
    val userUID = request.getRemoteUser
    val userID = themeDisplay.getUser.getUserId
    val courseID = themeDisplay.getLayout.getGroupId
    val companyId = PortalUtil.getCompanyId(request)

    val sessionID = SessionHandler.getSessionID(request.getRemoteUser)
    val cookie = new Cookie("valamisSessionID", sessionID)
    cookie.setMaxAge(-1)
    cookie.setPath("/")
    response.addProperty(cookie)
    SessionHandler.setAttribute(sessionID, "userID", request.getRemoteUser)
    SessionHandler.setAttribute(sessionID, "isAdmin", userManagement.isAdmin(userID, courseID))
    SessionHandler.setAttribute(sessionID, "hasTeacherPermissions", userManagement.hasTeacherPermissions(userID, courseID))

    val httpServletRequest = PortalUtil.getHttpServletRequest(request)
    httpServletRequest.getSession.setAttribute("userID", userUID)

    val out = response.getWriter
    val path = request.getContextPath

    val hasPermissions = userManagement.hasTeacherPermissions(userID, courseID)
    if (hasPermissions) {
      val groupID = themeDisplay.getScopeGroupId
      val translations = getTranslation("quiz", language)
      val map = Map("contextPath" -> path, "isAdmin" -> hasPermissions, "isPortlet" -> true, "language" -> language,
        "courseID" -> courseID, "actionURL" -> response.createResourceURL(), "companyID" -> companyId) ++ Map("userID" -> userUID, "groupID" -> groupID.toString) ++ translations
      val data = mustache(map, "scorm_quiz.html")
      out.println(data)
    }
    else {
      val translations = getTranslation("error", language)
      val data = mustache(Map("contextPath" -> path, "language" -> language) ++ translations, "scorm_nopermissions.html")
      out.println(data)
    }
  }

  private def getTranslation(view: String, language: String): Map[String, String] = {
    try {
      getTranslation("/i18n/" + view + "_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/" + view + "_en")
      case _ => Map[String, String]()
    }
  }

  override def serveResource(request: ResourceRequest, response: ResourceResponse) {
    val groupID = request.getParameter("groupID").toLong
    val articleID = request.getParameter("articleID")
    val articleLanguage = request.getParameter("language")
    val td = request.getAttribute(WebKeys.THEME_DISPLAY).asInstanceOf[ThemeDisplay]
    val text = JournalArticleLocalServiceUtil.getArticleContent(groupID, articleID, "view", articleLanguage, td)
    response.getWriter.println(text)
  }
}