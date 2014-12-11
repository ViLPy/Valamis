package com.arcusys.learn.view

import javax.portlet.{ GenericPortlet, RenderResponse, RenderRequest }
import com.arcusys.learn.bl.services.lesson.PackageServiceContract
import com.arcusys.learn.bl.services.settings.SettingServiceContract
import com.arcusys.learn.view.liferay.LiferayHelpers
import org.scalatra.ScalatraFilter
import java.io.FileNotFoundException
import com.arcusys.learn.liferay.util.PortalUtilHelper
import com.arcusys.learn.tincan.model.lrsClient.{ CommonBasicAuthorization, LrsEndpointSettings, OAuthAuthorization, UserBasicAuthorization }
import com.arcusys.learn.util.MustacheSupport
import com.arcusys.learn.view.extensions.{ ConfigurableView, i18nSupport, SessionSupport, TemplateCoupler }

class AdminView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport with ConfigurableView with SessionSupport with TemplateCoupler {
  private lazy val settingManager = inject[SettingServiceContract]
  private lazy val packageManager = inject[PackageServiceContract]

  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    setupSession(request: RenderRequest, response: RenderResponse)
    val out = response.getWriter

    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val userId = themeDisplay.getUser.getUserId
    val courseId = themeDisplay.getScopeGroupId
    val language = LiferayHelpers.getLanguage(request)

    val hasPermissions = userRoleService.isAdmin(userId, courseId)
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

      val issuerName = settingManager.getIssuerName()
      val issuerOrganization = settingManager.getIssuerOrganization()
      val issuerURL = settingManager.getIssuerURL()
      val sendMessages = settingManager.getSendMessages()

      val data = Map("contextPath" -> request.getContextPath, "userID" -> userUID, "groupID" -> groupID, "isAdmin" -> true,
        "language" -> language, "courseID" -> courseId, "isPortlet" -> true, "companyID" -> companyId, "issuerName" -> issuerName,
        "issuerURL" -> issuerURL, "sendMessages" -> sendMessages, "issuerOrganization" -> issuerOrganization) ++ translations

      val tincanEndpointData = packageManager.getTincanEndpoint() match {
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
        mustache(data ++ tincanEndpointData, "admin.html"))
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
