package com.arcusys.learn.view

import javax.portlet.{GenericPortlet, RenderRequest, RenderResponse}

import com.arcusys.learn.view.extensions.BaseView
import com.arcusys.learn.view.liferay.LiferayHelpers
import com.arcusys.valamis.lrsEndpoint.model.{BasicAuthorization, LrsEndpointSettings, OAuthAuthorization}
import com.arcusys.valamis.lrsEndpoint.service.LrsEndpointService
import com.arcusys.valamis.settings.service.SettingService

class AdminView extends GenericPortlet with BaseView {
  private lazy val settingManager = inject[SettingService]
  private lazy val endpointService = inject[LrsEndpointService]

  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {

    val out = response.getWriter
    val language = LiferayHelpers.getLanguage(request)

    val translations = getTranslation("admin", language)

    val issuerName = settingManager.getIssuerName()
    val issuerOrganization = settingManager.getIssuerOrganization()
    val issuerURL = settingManager.getIssuerURL()
    val sendMessages = settingManager.getSendMessages()
    val googleClientId = settingManager.getGoogleClientId()
    val googleAppId = settingManager.getGoogleAppId()
    val googleApiKey = settingManager.getGoogleApiKey()

    val scope = getSecurityData(request)
    val data = Map(
      "isAdmin" -> true,
      "language" -> language,
      "isPortlet" -> true,
      "issuerName" -> issuerName,
      "issuerURL" -> issuerURL,
      "sendMessages" -> sendMessages,
      "issuerOrganization" -> issuerOrganization,
      "googleClientId" -> googleClientId,
      "googleAppId" -> googleAppId,
      "googleApiKey" -> googleApiKey) ++ translations ++ scope.data

    val tincanEndpointData = endpointService.getTincanEndpoint() match {
      case Some(LrsEndpointSettings(endpoint, BasicAuthorization(loginName, password))) => Map(
        "tincanExternalLrs" -> true,
        "tincanLrsEndpoint" -> endpoint,
        "tincanLrsIsBasicAuth" -> true,
        "tincanLrsIsOAuth" -> false,
        "commonCredentials" -> false,
        "tincanLrsLoginName" -> loginName,
        "tincanLrsPassword" -> password
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
