package com.arcusys.learn.view

import javax.portlet._
import org.scalatra.ScalatraFilter
import com.arcusys.learn.view.liferay.LiferayHelpers
import com.arcusys.learn.scorm.tracking.model.User
import java.io.FileNotFoundException
import com.arcusys.learn.scorm.manifest.model.ScopeType
import com.arcusys.learn.service.util.SessionHandler
import javax.servlet.http.Cookie
import com.arcusys.learn.liferay.util.PortalUtilHelper
import com.arcusys.learn.tincan.model.Agent
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer
import com.arcusys.learn.util.MustacheSupport

class UserView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport with ConfigurableView with TemplateCoupler {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    val userUID = if (request.getRemoteUser != null) request.getRemoteUser.toInt else -1
    if (userUID != -1 && userStorage.getByID(userUID).isEmpty) {
      userStorage.createAndGetID(User(userUID, LiferayHelpers.getUserName(request)))
    }
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val courseID = themeDisplay.getLayout.getGroupId

    val sessionID = SessionHandler.getSessionID(request.getRemoteUser)
    val cookie = new Cookie("valamisSessionID", sessionID)
    cookie.setMaxAge(-1)
    cookie.setPath("/")
    response.addProperty(cookie)
    SessionHandler.setAttribute(sessionID, "userID", request.getRemoteUser)
    SessionHandler.setAttribute(sessionID, "isAdmin", userManagement.isAdmin(userUID, courseID))
    SessionHandler.setAttribute(sessionID, "hasTeacherPermissions", userManagement.hasTeacherPermissions(userUID, courseID))

    val httpServletRequest = PortalUtilHelper.getHttpServletRequest(request)
    httpServletRequest.getSession.setAttribute("userID", userUID)

    val out = response.getWriter
    val language = LiferayHelpers.getLanguage(request)

    var sessionPackageId = if (httpServletRequest.getSession.getAttribute("playerID") == request.getWindowID)
      httpServletRequest.getSession.getAttribute("packageId")
    else null
    var isComplete = false

    if (sessionPackageId != null && !packageService.IsPackageExists(sessionPackageId match {
      case e: Object => e.toString.toInt
      case _         => 0
    })) {
      sessionPackageId = null
      httpServletRequest.getSession.removeAttribute("packageId")
    }
    //storageFactory.packageStorage.getByID()

    val packageToStart = if (sessionPackageId != null) {
      sessionPackageId match {
        case e: Object => Option(e.toString.toInt)
        case _         => None
      }
    } else {
      val packID = packageService.getDefaultPackageID(themeDisplay.getLayout.getGroupId.toString, themeDisplay.getLayout.getPrimaryKey.toString, request.getWindowID)
      if (!packID.isDefined || !packageService.IsPackageExists(packID.get)) None
      else {
        isComplete = packageService.checkIfCompleteByUser(packID, userUID)
        if (!isComplete) packID else None
      }
    }

    var defaultPackageID = if (sessionPackageId != null) None else packageToStart

    val sessionPackageTitle = httpServletRequest.getSession.getAttribute("packageTitle")
    val sessionPackageType = httpServletRequest.getSession.getAttribute("packageType")

    val packageType = if (sessionPackageType != null) sessionPackageType.toString
    else packageService.getPackageType(packageToStart.getOrElse(0))

    val packageTitle = if (sessionPackageId != null) sessionPackageTitle
    else packageService.getPackageTitle(packageToStart.getOrElse(0), packageType)

    var user = LiferayHelpers.getUser(request)

    def StringToNone(str: String): Option[String] = {
      if (str == null || str.isEmpty)
        None
      else
        Some(str)
    }
    if (user != null) {
      val tincanActor = JsonDeserializer.serializeActor(Agent("Agent", StringToNone(user.getFullName), StringToNone(user.getEmailAddress), None, StringToNone(user.getOpenId), None))

      val data = Map("contextPath" -> request.getContextPath,
        "entryID" -> request.getParameter("entryID"),
        "userID" -> userUID,
        "userName" -> LiferayHelpers.getUserName(request),
        "userEmail" -> LiferayHelpers.getUserEmail(request),
        "tincanActor" -> tincanActor,
        "isAdmin" -> request.isUserInRole("administrator"),
        "language" -> language,
        "packageId" -> packageToStart,
        "packageTitle" -> packageTitle,
        "packageType" -> packageType,
        "isCompleteByUser" -> isComplete,
        "defaultPackageID" -> defaultPackageID,
        "isPortlet" -> true,
        "courseID" -> themeDisplay.getLayout.getGroupId,
        "pageID" -> themeDisplay.getLayout.getPrimaryKey,
        "playerID" -> request.getWindowID
      ) ++ getPlayerTranslations(language)
      out.println(getTemplate("/templates/2.0/player_templates.html") + mustache(data, "valamis_player.html"))
    } else {
      val language = LiferayHelpers.getLanguage(request)
      val translations = getTranslation("error", language)
      out.println(mustache(translations, "scorm_nopermissions.html"))
    }
  }

  def getPlayerTranslations(language: String) = {
    try {
      getTranslation("/i18n/player_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/player_en")
      case _: Throwable             => Map[String, String]()
    }
  }

  override def doEdit(request: RenderRequest, response: RenderResponse) {
    val out = response.getWriter
    val language = LiferayHelpers.getLanguage(request)
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val rule = storageFactory.playerScopeRuleStorage.get(request.getWindowID)
    val scope = if (rule == None) ScopeType.Site else rule.get.scope

    val data = Map("contextPath" -> request.getContextPath,
      "courseID" -> themeDisplay.getLayout.getGroupId,
      "pageID" -> themeDisplay.getLayout.getPrimaryKey,
      "language" -> language,
      "selectedScope" -> scope,
      "playerID" -> request.getWindowID) ++ getPlayerTranslations(language)
    out.println(getTemplate("/templates/2.0/player_settings_templates.html") +
      mustache(data, "valamis_player_settings.html"))
  }

  private def getTranslation(view: String, language: String): Map[String, String] = {
    try {
      getTranslation("/i18n/" + view + "_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/" + view + "_en")
      case _: Throwable             => Map[String, String]()
    }
  }
}