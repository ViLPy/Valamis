package com.arcusys.learn.view

import javax.portlet._
import com.arcusys.learn.bl.services.lesson.PlayerScopeRuleManager
import org.scalatra.ScalatraFilter
import com.arcusys.learn.view.liferay.LiferayHelpers
import java.io.FileNotFoundException
import com.arcusys.learn.scorm.manifest.model.ScopeType
import com.arcusys.learn.service.util.SessionHandler
import javax.servlet.http.Cookie
import com.arcusys.learn.liferay.util.{ PortalUtilHelper, PortletPreferencesFactoryUtilHelper }
import com.arcusys.learn.tincan.model.Agent
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer
import com.arcusys.learn.util.MustacheSupport
import com.arcusys.learn.view.extensions.{ ConfigurableView, i18nSupport, TemplateCoupler }
import scala.util.Try

class LessonViewerView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport with ConfigurableView with TemplateCoupler {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    val userUID = if (request.getRemoteUser != null) request.getRemoteUser.toInt
    else -1

    if (userUID != -1 && userService.getUserOption(userUID).isEmpty) {
      userService.createAndGetId(userUID, LiferayHelpers.getUserName(request))
    }

    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val courseID = themeDisplay.getLayout.getGroupId

    val sessionID = SessionHandler.getSessionID(request.getRemoteUser)
    val cookie = new Cookie("valamisSessionID", sessionID)
    cookie.setMaxAge(-1)
    cookie.setPath("/")
    response.addProperty(cookie)
    SessionHandler.setAttribute(sessionID, "userID", request.getRemoteUser)
    SessionHandler.setAttribute(sessionID, "isAdmin", userRoleService.isAdmin(userUID, courseID))
    SessionHandler.setAttribute(sessionID, "hasTeacherPermissions", userRoleService.hasTeacherPermissions(userUID, courseID))

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
        packID
        // allow to rerun default package
        //isComplete = packageService.checkIfCompleteByUser(packID, userUID)
        //if (!isComplete) packID else None
      }
    }

    val defaultPackageID = if (sessionPackageId != null) None else packageToStart

    val sessionPackageTitle = httpServletRequest.getSession.getAttribute("packageTitle")
    val sessionPackageType = httpServletRequest.getSession.getAttribute("packageType")

    val packageType = if (sessionPackageType != null) sessionPackageType.toString
    else packageService.getPackageType(packageToStart.getOrElse(0))

    val packageTitle = if (sessionPackageId != null) sessionPackageTitle
    else packageService.getPackageTitle(packageToStart.getOrElse(0), packageType)

    val user = LiferayHelpers.getUser(request)

    def StringToNone(str: String): Option[String] = {
      if (str == null || str.isEmpty)
        None
      else
        Some(str)
    }

    val preferences = PortletPreferencesFactoryUtilHelper.getPortletSetup(request)
    val enableAnonymousUser = Try(preferences.getValue("enableAnonymousUser", "false").toBoolean).getOrElse(false)

    if (enableAnonymousUser || user != null) {
      val tincanActor = if (user != null) JsonDeserializer.serializeActor(Agent("Agent", StringToNone(user.getFullName), StringToNone(user.getEmailAddress), None, StringToNone(user.getOpenId), None))
      else JsonDeserializer.serializeActor(Agent("Agent", StringToNone("Anonymous"), StringToNone("anonymous@liferay.com"), None, StringToNone(""), None))

      val hidePanel = preferences.getValue("hideSearchPanel", "false")

      val data = Map(
        "forcedView" -> hidePanel,
        "contextPath" -> request.getContextPath,
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
        "isCompleteByUser" -> false,
        "defaultPackageID" -> defaultPackageID,
        "isPortlet" -> true,
        "courseID" -> themeDisplay.getLayout.getGroupId,
        "pageID" -> themeDisplay.getLayout.getPrimaryKey,
        "playerID" -> request.getWindowID
      ) ++ getPlayerTranslations(language)
      out.println(getTemplate("/templates/2.0/lesson_viewer_templates.html") +
        getTemplate("/templates/2.0/paginator.html") +
        mustache(data, "lesson_viewer.html"))
    } else {
      val language = LiferayHelpers.getLanguage(request)
      val translations = getTranslation("error", language)
      out.println(mustache(translations, "scorm_nopermissions.html"))
    }
  }

  def getPlayerTranslations(language: String) = {
    try {
      getTranslation("/i18n/lessonViewer_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/lessonViewer_en")
      case _: Throwable             => Map[String, String]()
    }
  }

  override def doEdit(request: RenderRequest, response: RenderResponse) {
    val hideSearch = request.getParameter("hideSearchPanel")
    val enableAnonymous = request.getParameter("enableAnonymousUser")
    if (hideSearch != null && !hideSearch.isEmpty) {
      val preferences = PortletPreferencesFactoryUtilHelper.getPortletSetup(request)
      preferences.setValue("hideSearchPanel", hideSearch)
      preferences.store()
    } else if (enableAnonymous != null && !enableAnonymous.isEmpty) {
      val preferences = PortletPreferencesFactoryUtilHelper.getPortletSetup(request)
      preferences.setValue("enableAnonymousUser", enableAnonymous)
      preferences.store()
    } else {
      val out = response.getWriter
      val language = LiferayHelpers.getLanguage(request)
      val themeDisplay = LiferayHelpers.getThemeDisplay(request)
      val rule = inject[PlayerScopeRuleManager].get(request.getWindowID)
      val scope = if (rule == None) ScopeType.Site else rule.get.scope

      val preferences = PortletPreferencesFactoryUtilHelper.getPortletSetup(request)
      val hidePanel = preferences.getValue("hideSearchPanel", "false")
      val enableAnonymousUser = Try(preferences.getValue("enableAnonymousUser", "false").toBoolean).getOrElse(false)

      val data = Map("contextPath" -> request.getContextPath,
        "courseID" -> themeDisplay.getLayout.getGroupId,
        "pageID" -> themeDisplay.getLayout.getPrimaryKey,
        "language" -> language,
        "selectedScope" -> scope,
        "playerID" -> request.getWindowID,
        "hideSearchPanel" -> hidePanel,
        "portletSettingsActionURL" -> response.createResourceURL(),
        "enableAnonymousUser" -> enableAnonymousUser) ++ getPlayerTranslations(language)
      out.println(getTemplate("/templates/2.0/player_settings_templates.html") +
        mustache(data, "lesson_viewer_settings.html"))
    }
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