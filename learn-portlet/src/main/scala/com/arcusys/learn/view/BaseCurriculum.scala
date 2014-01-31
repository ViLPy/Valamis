package com.arcusys.learn.view

import javax.portlet.{RenderResponse, RenderRequest, GenericPortlet}
import liferay.LiferayHelpers
import org.scalatra.ScalatraFilter
import com.arcusys.scala.scalatra.mustache.MustacheSupport
import java.io.FileNotFoundException
import com.liferay.portal.util.{LayoutTypePortletFactoryUtil, PortalUtil}
import com.liferay.portal.service.{UserLocalServiceUtil, GroupLocalServiceUtil, LayoutLocalServiceUtil}
import com.liferay.portlet.PortletURLUtil
import com.arcusys.learn.service.util.SessionHandler
import javax.servlet.http.Cookie

import org.json4s.jackson.JsonMethods
import org.json4s.JsonDSL._
import com.liferay.portal.kernel.dao.orm.QueryUtil
import com.liferay.portal.model.User

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
    dataMap: Map[String,Any]): Map[String,Any] =  {

    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val userID = getUserId(request)
    val language = LiferayHelpers.getLanguage(request)
    val path = request.getContextPath
    val courseID = themeDisplay.getScopeGroupId
    val httpServletRequest = PortalUtil.getHttpServletRequest(request)
    val url = getRootUrl(request, response)
    val translations = getTranslation("curriculum", language)
    val companyId = PortalUtil.getCompanyId(request)
    val courses = getSites(companyId)
    val users = getUsers(companyId)
    val sessionID = SessionHandler.getSessionID(request.getRemoteUser)
    val cookie = new Cookie("valamisSessionID", sessionID)

    cookie.setMaxAge(-1)
    cookie.setPath("/")
    response.addProperty(cookie)
    SessionHandler.setAttribute(sessionID, "userID", request.getRemoteUser)
    SessionHandler.setAttribute(sessionID, "hasTeacherPermissions", userManagement.hasTeacherPermissions(userID, courseID))
    SessionHandler.setAttribute(sessionID, "isAdmin", userManagement.isAdmin(userID, courseID))
    SessionHandler.setAttribute(sessionID, "language", language)

    httpServletRequest.getSession.setAttribute("userID", userID)

    val data = Map(
      "root" -> url,
      "contextPath" -> path,
      "userID" -> userID,
      "isAdmin" -> userManagement.isAdmin(userID, courseID),
      "language" -> language,
      "courseID" -> courseID,
      "companyID" -> companyId,
      "translations" -> JsonMethods.compact(JsonMethods.render(translations)),
      "courses" -> JsonMethods.compact(JsonMethods.render(courses)),
      "users" -> JsonMethods.compact(JsonMethods.render(users))) ++ translations ++ dataMap
    data
  }

  protected def getSites(companyId: Long) = {
    def createMap(site: com.liferay.portal.model.Group): Map[String, String] = Map(
      "siteID" -> site.getGroupId.toString,
      "title" -> site.getDescriptiveName,
      "url" -> site.getFriendlyURL,
      "description" -> site.getDescription.replace("\n", " ")
    )
    GroupLocalServiceUtil.getCompanyGroups(companyId, QueryUtil.ALL_POS,  QueryUtil.ALL_POS).toArray.filter(x => {
      val site = x.asInstanceOf[com.liferay.portal.model.Group]
      val url = site.getFriendlyURL
      site.isSite && site.isActive &&
        //remove control panel
        url != "/control_panel"
    }).map(i => i.asInstanceOf[com.liferay.portal.model.Group]).map(createMap).toList
  }

  protected def getUsers(companyID: Long) = {
    def convert(user: User): Map[String, String] = Map(
      "userID" -> user.getUserId.toString,
      "userUID" -> user.getUserUuid.toString,
      "name" -> user.getFullName,
      "email" -> user.getEmailAddress,
      "portrait" -> getPortrait(user),
      "userPublicPageUrl" -> getPublicUrl(user)
    )

    UserLocalServiceUtil
      .getCompanyUsers(companyID, QueryUtil.ALL_POS, QueryUtil.ALL_POS)
      .toArray
      .map(x => x.asInstanceOf[com.liferay.portal.model.User])
      .sortBy(x => x.getFullName)
      .filter(x => x.getFullName != "")
      .map(convert)
      .toList
  }

  def getPortrait(user: User) = {
    "/image/user_male_portrait?img_id=" + user.getPortraitId
  }

  def getPublicUrl(user: User) = {
    if (user.getGroup().getPublicLayoutsPageCount() > 0)
      "/web/" + user.getScreenName
    else
      ""
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
        case _ => Map[String, String]()
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
      dataMap: Map[String, Any]) = {

    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val userID = getUserId(request)
    val courseID = themeDisplay.getScopeGroupId

    val (html, data) = if (userManagement.hasTeacherPermissions(userID, courseID)) {
      (viewTemplateName,
        doViewHelper(
          request: RenderRequest,
          response: RenderResponse,
          dataMap))
    }
    else {
      val path = request.getContextPath
      val language = LiferayHelpers.getLanguage(request)
      val translations = getTranslation("error", language)
      val data = Map(
        "contextPath" -> path,
        "language" -> language) ++ translations ++ dataMap

      ("scorm_nopermissions.html",data)
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
