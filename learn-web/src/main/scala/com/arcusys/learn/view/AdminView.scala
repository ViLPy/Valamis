package com.arcusys.learn.view

import com.arcusys.scala.scalatra.mustache.MustacheSupport
import javax.portlet._
import org.scalatra.ScalatraFilter
import com.arcusys.learn.view.liferay.LiferayHelpers
import java.io.FileNotFoundException
import com.liferay.portal.util.PortalUtil
import com.arcusys.learn.service.util.SessionHandler
import javax.servlet.http.Cookie
import com.arcusys.learn.settings.model.{Setting, SettingType}
import com.arcusys.learn.tincan.model.{OAuthAuthorization, CommonBasicAuthorization, UserBasicAuthorization, LrsEndpointSettings}
import javax.xml.bind.DatatypeConverter

class AdminView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport with ConfigurableView {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    val userUID = request.getRemoteUser
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val userID = themeDisplay.getUser.getUserId
    val courseID = themeDisplay.getScopeGroupId //theme.getLayout.getGroupId

    val httpServletRequest = PortalUtil.getHttpServletRequest(request)
    httpServletRequest.getSession.setAttribute("userID", userUID)

    // Session management
    val sessionID = SessionHandler.getSessionID(request.getRemoteUser)
    val cookie = new Cookie("valamisSessionID", sessionID)
    cookie.setMaxAge(-1)
    cookie.setPath("/")
    response.addProperty(cookie)
    SessionHandler.setAttribute(sessionID, "userID", request.getRemoteUser)
    SessionHandler.setAttribute(sessionID, "hasTeacherPermissions", userManagement.hasTeacherPermissions(userID, courseID))
    SessionHandler.setAttribute(sessionID, "isAdmin", userManagement.isAdmin(userID, courseID))

    val out = response.getWriter
    val language = LiferayHelpers.getLanguage(request)
    if (userManagement.isAdmin(userID, courseID)) {
      val groupID = themeDisplay.getScopeGroupId
      val translations = getTranslation("admin", language)
      val companyId = PortalUtil.getCompanyId(request)

      val allSettings = storageFactory.settingStorage.getAll
      val emptySetting = new Setting(0, SettingType.IssuerName, "")

      val issuerName = allSettings.find(i => i.key == SettingType.IssuerName).getOrElse(emptySetting).value
      val issuerOrganization = allSettings.find(i => i.key == SettingType.IssuerOrganization).getOrElse(emptySetting).value
      val issuerURL = allSettings.find(i => i.key == SettingType.IssuerURL).getOrElse(emptySetting).value


      val data = Map("contextPath" -> request.getContextPath, "userID" -> userUID, "groupID" -> groupID, "isAdmin" -> true,
        "language" -> language, "courseID" -> courseID, "isPortlet" -> true, "companyID" -> companyId, "issuerName" -> issuerName,
        "issuerURL"-> issuerURL, "issuerOrganization"-> issuerOrganization) ++ translations

      val tincanEndpointData = storageFactory.tincanLrsEndpointStorage.get match {
        case Some(LrsEndpointSettings(endpoint, CommonBasicAuthorization(loginName, password))) => Map(
            "tincanLrsEndpoint" -> endpoint,
            "tincanLrsIsBasicAuth" -> true,
            "tincanLrsIsOAuth" -> false,
            "commonCredentials" -> true,
            "tincanLrsLoginName" -> loginName,
            "tincanLrsPassword" -> password
          )
        case Some(LrsEndpointSettings(endpoint, UserBasicAuthorization)) => Map(
              "tincanLrsEndpoint" -> endpoint,
              "tincanLrsIsBasicAuth" -> true,
              "tincanLrsIsOAuth" -> false,
              "commonCredentials" -> false,
              "tincanLrsLoginName" -> "",
              "tincanLrsPassword" -> ""
            )
        case Some(LrsEndpointSettings(endpoint, OAuthAuthorization(key, secret))) => Map(
          "tincanLrsEndpoint" -> endpoint,
          "tincanLrsIsBasicAuth" -> false,
          "tincanLrsIsOAuth" -> true,
          "commonCredentials" -> true,
          "tincanLrsLoginName" -> key,
          "tincanLrsPassword" -> secret
        )
        case _ => Map(
          "tincanLrsEndpoint" -> "",
          "tincanLrsIsBasicAuth" -> true,
          "tincanLrsIsOAuth" -> false,
          "commonCredentials" -> true,
          "tincanLrsLoginName" -> "",
          "tincanLrsPassword" -> ""
        )
      }

      out.println(generateResponse(data ++ tincanEndpointData, "scorm_admin.html"))
    }
    else {
      val translations = getTranslation("error", language)
      val data = Map("contextPath" -> request.getContextPath, "language" -> language) ++ translations
      out.println(generateResponse(data, "scorm_nopermissions.html"))
    }
  }

  def generateResponse(data: Map[String, Any], templateName: String) = {
    mustache(data, templateName)
  }

  private def getTranslation(view: String, language: String): Map[String, String] = {
    try {
      getTranslation("/i18n/" + view + "_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/" + view + "_en")
      case _ => Map[String, String]()
    }
  }
}