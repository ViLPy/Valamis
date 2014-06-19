package com.arcusys.learn.view

import javax.portlet.{ GenericPortlet, RenderResponse, RenderRequest }
import com.arcusys.learn.view.liferay.LiferayHelpers
import com.arcusys.learn.settings.model.{ SettingType, Setting }
import org.scalatra.ScalatraFilter
import java.io.FileNotFoundException
import com.arcusys.learn.liferay.util.PortalUtilHelper
import com.arcusys.learn.tincan.model.lrsClient.{ CommonBasicAuthorization, LrsEndpointSettings, OAuthAuthorization, UserBasicAuthorization }
import com.arcusys.learn.util.MustacheSupport

class AdminView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport with ConfigurableView with SessionSupport with TemplateCoupler {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    setupSession(request: RenderRequest, response: RenderResponse)
    val out = response.getWriter

    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val userId = themeDisplay.getUser.getUserId
    val courseId = themeDisplay.getScopeGroupId
    val language = LiferayHelpers.getLanguage(request)

    val hasPermissions = userManagement.isAdmin(userId, courseId)
    if (!hasPermissions) {
      val translations = getTranslation("error", language)
      out.println(mustache(translations, "scorm_nopermissions.html"))
    } else {

      val userUID = request.getRemoteUser

      val httpServletRequest = PortalUtilHelper.getHttpServletRequest(request)
      httpServletRequest.getSession.setAttribute("userID", userUID)

      val groupID = themeDisplay.getScopeGroupId
      val translations = getTranslation("admin", language)
      val companyId = PortalUtilHelper.getCompanyId(request)

      val allSettings = storageFactory.settingStorage.getAll
      val emptySetting = new Setting(0, SettingType.IssuerName, "")

      val issuerName = allSettings.find(i => i.key == SettingType.IssuerName).getOrElse(emptySetting).value
      val issuerOrganization = allSettings.find(i => i.key == SettingType.IssuerOrganization).getOrElse(emptySetting).value
      val issuerURL = allSettings.find(i => i.key == SettingType.IssuerURL).getOrElse(emptySetting).value

      val data = Map("contextPath" -> request.getContextPath, "userID" -> userUID, "groupID" -> groupID, "isAdmin" -> true,
        "language" -> language, "courseID" -> courseId, "isPortlet" -> true, "companyID" -> companyId, "issuerName" -> issuerName,
        "issuerURL" -> issuerURL, "issuerOrganization" -> issuerOrganization) ++ translations

      val tincanEndpointData = storageFactory.tincanLrsEndpointStorage.get match {
        case Some(LrsEndpointSettings(endpoint, CommonBasicAuthorization(loginName, password))) => Map(
          "tincanExternalLrs" -> true,
          "tincanLrsEndpoint" -> endpoint,
          "tincanLrsIsBasicAuth" -> true,
          "tincanLrsIsOAuth" -> false,
          "commonCredentials" -> true,
          "tincanLrsLoginName" -> loginName,
          "tincanLrsPassword" -> password
        )
        case Some(LrsEndpointSettings(endpoint, UserBasicAuthorization)) => Map(
          "tincanExternalLrs" -> true,
          "tincanLrsEndpoint" -> endpoint,
          "tincanLrsIsBasicAuth" -> true,
          "tincanLrsIsOAuth" -> false,
          "commonCredentials" -> false,
          "tincanLrsLoginName" -> "",
          "tincanLrsPassword" -> ""
        )
        case Some(LrsEndpointSettings(endpoint, OAuthAuthorization(key, secret))) => Map(
          "tincanExternalLrs" -> true,
          "tincanLrsEndpoint" -> endpoint,
          "tincanLrsIsBasicAuth" -> false,
          "tincanLrsIsOAuth" -> true,
          "commonCredentials" -> false,
          "tincanLrsLoginName" -> key,
          "tincanLrsPassword" -> secret
        )
        case _ => Map(
          "tincanExternalLrs" -> false,
          "tincanLrsEndpoint" -> "",
          "tincanLrsIsBasicAuth" -> true,
          "tincanLrsIsOAuth" -> false,
          "commonCredentials" -> true,
          "tincanLrsLoginName" -> "",
          "tincanLrsPassword" -> ""
        )
      }

      out.println(getTemplate("/templates/2.0/admin_templates.html") +
        mustache(data ++ tincanEndpointData, "valamis_admin.html"))
    }
  }

  private def getTranslation(view: String, language: String): Map[String, String] = {
    try {
      getTranslation("/i18n/" + view + "_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/" + view + "_en")
      case _                        => Map[String, String]()
    }
  }
}
