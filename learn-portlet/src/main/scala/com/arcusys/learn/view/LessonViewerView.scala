package com.arcusys.learn.view

import javax.portlet._

import com.arcusys.learn.facades.PackageFacadeContract
import com.arcusys.learn.liferay.util.PortalUtilHelper
import com.arcusys.learn.view.extensions._
import com.arcusys.learn.view.liferay.LiferayHelpers
import com.arcusys.valamis.lesson.model.LessonType
import com.arcusys.valamis.lesson.service.{PackageService, PlayerScopeRuleManager}
import com.arcusys.valamis.lrs.serializer.AgentSerializer
import com.arcusys.valamis.lrs.tincan.Agent
import com.arcusys.valamis.lrs.util.TincanHelper
import com.arcusys.valamis.model.ScopeType
import com.arcusys.valamis.user.service.UserService
import com.arcusys.valamis.utils.serialization.JsonHelper
import com.arcusys.learn.liferay.permission._

class LessonViewerView extends OAuthPortlet with BaseView {
  lazy val userService = inject[UserService]
  lazy val packageService = inject[PackageService]
  lazy val packageFacade = inject[PackageFacadeContract]

  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    val scope = getSecurityData(request)
    val userUID = if (request.getRemoteUser != null) request.getRemoteUser.toInt
    else -1

    if (userUID != -1 && userService.getUserOption(userUID).isEmpty) {
      userService.createAndGetId(userUID, LiferayHelpers.getUserName(request))
    }

    val themeDisplay = LiferayHelpers.getThemeDisplay(request)

    val httpServletRequest = PortalUtilHelper.getHttpServletRequest(request)
    httpServletRequest.getSession.setAttribute("userID", userUID)

    val out = response.getWriter
    val language = LiferayHelpers.getLanguage(request)

    var sessionPackageId = if (httpServletRequest.getSession.getAttribute("playerID") == request.getWindowID)
      httpServletRequest.getSession.getAttribute("packageId")
    else null

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

    val packageId = packageToStart.getOrElse(0).toLong

    val packageType = if (sessionPackageType != null) sessionPackageType.toString
    else if (packageId != 0) packageService.getPackageType(packageId) match {
      case LessonType.Scorm  => "scorm"
      case LessonType.Tincan => "tincan"
    }
    else null

    val packageTitle = if (sessionPackageId != null) sessionPackageTitle
    else if (packageId != 0) packageService.getPackageTitle(packageId, packageType)
    else null

    val user = LiferayHelpers.getUser(request)

    def StringToNone(str: String): Option[String] = {
      if (str == null || str.isEmpty)
        None
      else
        Some(str)
    }

    val tincanActor = if (user != null)
      JsonHelper.toJson(TincanHelper.getAgent(user.getFullName, user.getEmailAddress), new AgentSerializer)
    else
      JsonHelper.toJson(Agent(name = StringToNone("Anonymous"), mBox = StringToNone("mailto:anonymous@liferay.com")), new AgentSerializer)

    val endpoint = JsonHelper.toJson(getEndpointInfo(request))
    val securityScope = getSecurityData(request)

    val data = Map(
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
      "pageID" -> themeDisplay.getLayout.getPrimaryKey,
      "playerID" -> request.getWindowID,
      "permissionSharePackage" -> PermissionUtil.hasPermission(securityScope.courseId, securityScope.portletId, securityScope.primaryKey, SharePermission)
    ) ++ getTranslation("lessonViewer", language) ++ scope.data ++
      Map("endpointData" -> endpoint)
    out.println(getTemplate("/templates/2.0/lesson_viewer_templates.html") +
      getTemplate("/templates/2.0/paginator.html") +
      mustache(data, "lesson_viewer.html"))
  }


  override def doEdit(request: RenderRequest, response: RenderResponse) {
    val out = response.getWriter
    val language = LiferayHelpers.getLanguage(request)
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val rule = inject[PlayerScopeRuleManager].get(request.getWindowID)
    val scope = if (rule == None) ScopeType.Site else rule.get.scope

    val data = Map("contextPath" -> request.getContextPath,
      "pageID" -> themeDisplay.getLayout.getPrimaryKey,
      "language" -> language,
      "selectedScope" -> scope,
      "playerID" -> request.getWindowID,
      "portletSettingsActionURL" -> response.createResourceURL()
    ) ++ getTranslation("lessonViewer", language)
    out.println(
      getTemplate("/templates/2.0/player_settings_templates.html") +
        getTemplate("/templates/2.0/file_uploader.html") +
        mustache(data, "lesson_viewer_settings.html"))
  }
}