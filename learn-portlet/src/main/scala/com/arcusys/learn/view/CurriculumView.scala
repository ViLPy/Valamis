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

/**
 * User: Yulia.Glushonkova
 * Date: 07.06.13
 */
abstract class CurriculumAbstract extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport with ConfigurableView {
  implicit val formats = org.json4s.DefaultFormats
  override def destroy() {}

  protected def doViewHelper(request: RenderRequest, response: RenderResponse): Map[String,Any] =  {
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val userID = if (request.getRemoteUser != null) request.getRemoteUser.toInt else null.asInstanceOf[Int]
    val language = LiferayHelpers.getLanguage(request)
    val path = request.getContextPath

    val courseID = themeDisplay.getScopeGroupId
    val httpServletRequest = PortalUtil.getHttpServletRequest(request)
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
    val companyId = PortalUtil.getCompanyId(request)

    val courses_ = getSites(companyId)

    val users_ = getUsers(companyId)

    val data = Map("root" -> url, "contextPath" -> path, "userID" -> userID, "isAdmin" -> userManagement.isAdmin(userID, courseID),
      "language" -> language, "courseID" -> courseID, "companyID" -> companyId, "translations_" -> JsonMethods.compact(JsonMethods.render(translations)),
      "courses_" -> JsonMethods.compact(JsonMethods.render(courses_)), "users_" -> JsonMethods.compact(JsonMethods.render(users_))) ++ translations
    data
  }

  private def getSites(companyId: Long) = {
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

  private def getUsers(companyID: Long) = {
    def convert(user: User): Map[String, String] = Map(
      "userID" -> user.getUserId.toString,
      "name" -> user.getFullName,
      "email" -> user.getEmailAddress,
      "portrait" -> getPortrait(user),
      "userPublicPageUrl" -> getPublicUrl(user)
    )
    UserLocalServiceUtil.getCompanyUsers(companyID, QueryUtil.ALL_POS, QueryUtil.ALL_POS).toArray
      .map(x => x.asInstanceOf[com.liferay.portal.model.User])
      .sortBy(x => x.getFullName).filter(x => x.getFullName != "").map(convert).toList
  }

  def getPortrait(user: User) = {
    "/image/user_male_portrait?img_id=" + user.getPortraitId
  }

  def getPublicUrl(user: User) = {
    if (user.getGroup().getPublicLayoutsPageCount() > 0) "/web/" + user.getScreenName else ""
  }

  private def getRootUrl(request: RenderRequest, response: RenderResponse) = {
    val url = PortletURLUtil.getCurrent(request, response)
    val parts = url.toString.split("/")
    if (parts.length > 2) parts.tail.tail.head else ""
  }

  def generateResponse(data: Map[String, Any], templateName: String) = {
    mustache(data, templateName)
  }

  protected def getTranslation(view: String, language: String): Map[String, String] = {
    try {
      getTranslation("/i18n/" + view + "_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/" + view + "_en")
      case _ => Map[String, String]()
    }
  }
}

class CurriculumAdmin extends CurriculumAbstract {
  override def doView(request: RenderRequest, response: RenderResponse) {
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val userID = if (request.getRemoteUser != null) request.getRemoteUser.toInt else null.asInstanceOf[Int]
    val courseID = themeDisplay.getScopeGroupId
    val (html, data) = if (userManagement.hasTeacherPermissions(userID, courseID)){
      ("curriculum_admin.html" , super.doViewHelper(request: RenderRequest, response: RenderResponse))
    }
    else{
      val path = request.getContextPath
      val language = LiferayHelpers.getLanguage(request)
      val translations = getTranslation("error", language)
      val data = Map("contextPath" -> path, "language" -> language) ++ translations
      ("scorm_nopermissions.html",data)
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