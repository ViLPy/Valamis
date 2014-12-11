package com.arcusys.learn.view

import javax.portlet.{ RenderResponse, RenderRequest, GenericPortlet }
import liferay.LiferayHelpers
import org.scalatra.ScalatraFilter
import java.io.FileNotFoundException
import com.arcusys.learn.service.util.SessionHandler
import javax.servlet.http.Cookie
import scala.collection.JavaConverters._

import com.arcusys.learn.models.UserModel

import com.arcusys.learn.models.Lms2PortletConverters._
import com.arcusys.learn.liferay.services.UserLocalServiceHelper
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.constants.QueryUtilHelper
import com.arcusys.learn.liferay.util.PortalUtilHelper
import com.liferay.portlet.PortletURLUtil
import com.arcusys.learn.util.{ JsonSupport, MustacheSupport }
import com.arcusys.learn.view.extensions.{ ConfigurableView, i18nSupport }

class BaseCurriculum extends GenericPortlet
    with ScalatraFilter
    with MustacheSupport
    with i18nSupport
    with ConfigurableView {

  implicit val formats = org.json4s.DefaultFormats
  override def destroy() {}

  // TODO: Need refactoring
  protected def doViewHelper(
    request: RenderRequest,
    response: RenderResponse,
    dataMap: Map[String, Any]): Map[String, Any] = {

    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val userID = getUserId(request)
    val language = LiferayHelpers.getLanguage(request)
    val path = request.getContextPath
    val courseID = themeDisplay.getScopeGroupId
    val httpServletRequest = PortalUtilHelper.getHttpServletRequest(request)
    val translations = getTranslation("curriculum", language)
    val companyId = PortalUtilHelper.getCompanyId(request)
    val users = getUsers(companyId)
    val sessionID = SessionHandler.getSessionID(request.getRemoteUser)
    val cookie = new Cookie("valamisSessionID", sessionID)
    val url = getRootUrl(request, response)

    cookie.setMaxAge(-1)
    cookie.setPath("/")
    response.addProperty(cookie)

    SessionHandler.setAttribute(sessionID, "userID", request.getRemoteUser)
    SessionHandler.setAttribute(sessionID, "hasTeacherPermissions", userRoleService.hasTeacherPermissions(userID, courseID))
    SessionHandler.setAttribute(sessionID, "isAdmin", userRoleService.isAdmin(userID, courseID))
    SessionHandler.setAttribute(sessionID, "language", language)

    httpServletRequest.getSession.setAttribute("userID", userID)

    val data = Map(
      "rootUrl" -> url,
      "contextPath" -> path,
      "isAdmin" -> userRoleService.hasTeacherPermissions(userID, courseID), //isAdmin(userID, courseID), TODO: change isAdmin to hasTeacherPermissions in template
      "companyID" -> companyId,
      "translations" -> JsonSupport.json(translations).get,
      "users" -> JsonSupport.json(users).get
    ) ++ translations ++ dataMap
    data
  }

  protected def getUsers(companyID: Long): List[UserModel] = {
    UserLocalServiceHelper()
      .getCompanyUsers(companyID, QueryUtilHelper.ALL_POS, QueryUtilHelper.ALL_POS)
      .asScala
      .filter(x => x.getFullName != "")
      .toList
  }

  private def getRootUrl(
    request: RenderRequest,
    response: RenderResponse) = {
    val url = PortletURLUtil.getCurrent(request, response)
    val parts = url.toString.split("/")
    if (parts.length > 2)
      parts.tail.tail.head
    else
      ""
  }

  def getPublicUrl(user: LUser) = {
    if (user.getGroup.getPublicLayoutsPageCount > 0)
      "/web/" + user.getScreenName
    else
      ""
  }

  def generateResponse(
    data: Map[String, Any],
    templateName: String) = {
    mustache(data, templateName)
  }

  protected def getTranslation(
    view: String,
    language: String): Map[String, String] = {
    try {
      getTranslation("/i18n/" + view + "_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/" + view + "_en")
      case _                        => Map[String, String]()
    }
  }

  protected def getUserId(request: RenderRequest) =
    if (request.getRemoteUser != null)
      request.getRemoteUser.toInt
    else
      null.asInstanceOf[Int]

  protected def renderAdminView(
    request: RenderRequest,
    response: RenderResponse,
    viewTemplateName: String,
    dataMap: Map[String, Any],
    adminOnly: Boolean = false) = {

    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val userID = getUserId(request)
    val courseID = themeDisplay.getScopeGroupId

    val (html, data) = if ((!adminOnly && userRoleService.hasTeacherPermissions(userID, courseID)) || userRoleService.isAdmin(userID, courseID)) {
      (viewTemplateName,
        doViewHelper(
          request: RenderRequest,
          response: RenderResponse,
          dataMap))
    } else {
      val path = request.getContextPath
      val language = LiferayHelpers.getLanguage(request)
      val translations = getTranslation("error", language)
      val data = Map(
        "contextPath" -> path,
        "language" -> language) ++ translations ++ dataMap

      ("scorm_nopermissions.html", data)
    }
    response.getWriter.println(generateResponse(data, html))
  }

  protected def renderAdminView(
    request: RenderRequest,
    response: RenderResponse,
    viewTemplateName: String) {

    renderAdminView(
      request,
      response,
      viewTemplateName,
      Map[String, String]())
  }

  protected def renderUserView(
    request: RenderRequest,
    response: RenderResponse,
    viewTemplateName: String,
    dataMap: Map[String, Any]) {

    val data = doViewHelper(
      request: RenderRequest,
      response: RenderResponse,
      dataMap)

    response.getWriter.println(generateResponse(data, viewTemplateName))
  }

  protected def renderUserView(
    request: RenderRequest,
    response: RenderResponse,
    viewTemplateName: String) {

    renderUserView(
      request,
      response,
      viewTemplateName,
      Map[String, String]())
  }

}
