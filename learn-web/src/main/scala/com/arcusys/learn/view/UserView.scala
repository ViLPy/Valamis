package com.arcusys.learn.view

import com.arcusys.scala.scalatra.mustache.MustacheSupport
import javax.portlet._
import org.scalatra.ScalatraFilter
import com.arcusys.learn.view.liferay.LiferayHelpers
import com.arcusys.learn.storage.impl.orbroker.StorageFactory
import com.arcusys.learn.scorm.tracking.model.User
import java.io.FileNotFoundException
import com.arcusys.learn.liferay.service.PackageIndexer
import com.liferay.portlet.PortletURLUtil
import com.liferay.portal.util.PortalUtil
import com.liferay.portal.kernel.util.WebKeys
import com.liferay.portal.theme.ThemeDisplay
import com.arcusys.learn.scorm.manifest.model.ScopeType
import com.liferay.portal.service.LayoutLocalServiceUtil

class UserView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport {
  override def destroy() {}

  val userStorage = StorageFactory.userStorage

  override def doView(request: RenderRequest, response: RenderResponse) {
    val userUID = request.getRemoteUser
    if (userUID != null && userStorage.getByID(userUID.toInt).isEmpty) {
      userStorage.createAndGetID(User(userUID.toInt, LiferayHelpers.getUserName(request)))
    }
    val out = response.getWriter
    val language = LiferayHelpers.getLanguage(request)
    val httpServletRequest = PortalUtil.getHttpServletRequest(request)
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val data = Map("contextPath" -> request.getContextPath,
      "entryID" -> request.getParameter("entryID"),
      "userID" -> userUID,
      "userName" -> LiferayHelpers.getUserName(request),
      "isAdmin" -> request.isUserInRole("administrator"),
      "language" -> language,
      "packageId"->  httpServletRequest.getSession.getAttribute("packageId"),
      "packageTitle"->  httpServletRequest.getSession.getAttribute("packageTitle"),
      "isPortlet" -> true,
      "courseID" -> themeDisplay.getLayout.getGroupId,
      "pageID" -> themeDisplay.getLayout.getPrimaryKey,
      "playerID"-> request.getWindowID) ++ getPlayerTranslations(language)
    out.println(mustache(data, "player.html"))
  }

  def getPlayerTranslations(language: String) ={
    try {
      getTranslation("/i18n/player_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/player_en")
      case _ => Map[String, String]()
    }
  }

  override def doEdit(request: RenderRequest, response: RenderResponse){
    val out = response.getWriter
    val language = LiferayHelpers.getLanguage(request)
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val rule = StorageFactory.playerScopeRuleStorage.get(request.getWindowID)
    val scope = if (rule == None) ScopeType.Site else rule.get.scope

    val data = Map("contextPath" -> request.getContextPath,
      "courseID" -> themeDisplay.getLayout.getGroupId,
      "pageID"-> themeDisplay.getLayout.getPrimaryKey,
      "language" -> language,
      "selectedScope"-> scope,
      "playerID"-> request.getWindowID) ++ getPlayerTranslations(language)
    out.println(mustache(data, "player_settings.html"))
  }

  post("/setSession"){
    val id = params("id")
    val title = params("title")
    request.getSession.setAttribute("packageId",id)
    request.getSession.setAttribute("packageTitle",title)
  }
  get("/clearSession"){
    request.getSession.removeAttribute("packageId")
    request.getSession.removeAttribute("packageTitle")
  }
}