package com.arcusys.learn.controllers.api

import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.permission.{PermissionUtil, PortletName, ViewPermission}
import com.arcusys.learn.models.request.{AdminActionType, AdminRequest}
import com.arcusys.learn.web.ServletBase
import com.arcusys.valamis.lrs.service.LrsClientManager
import com.arcusys.valamis.lrs.tincan.AuthorizationScope
import com.arcusys.valamis.lrsEndpoint.model._
import com.arcusys.valamis.lrsEndpoint.service.LrsEndpointService
import com.arcusys.valamis.settings.service.SettingService
import com.escalatesoft.subcut.inject.BindingModule

class AdminApiController(configuration: BindingModule) extends BaseApiController(configuration) with ServletBase {
  def this() = this(Configuration)

  lazy val endpointService = inject[LrsEndpointService]
  lazy val settingsManager = inject[SettingService]
  private val lrsClientManager = inject[LrsClientManager]

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  get("/administering/TincanLrsSettings") {
    jsonAction(lrsClientManager.getLrsEndpointInfo(AuthorizationScope.All, Some(request)))
  }

  post("/administering/TincanLrsSettings")(jsonAction {
    PermissionUtil.requirePermissionApi(ViewPermission, PortletName.AdminView)

    val adminRequest = AdminRequest(this)
    if (!adminRequest.isExternalLrs) {
      endpointService.removeTincanEndpoint()
    } else {
      val settings = adminRequest.authType match {

        case AuthorizationType.BASIC => BasicAuthorization(
          adminRequest.login,
          adminRequest.password)

        case AuthorizationType.OAUTH => OAuthAuthorization(
          adminRequest.clientId,
          adminRequest.clientSecret)
      }

      endpointService.setTincanEndpoint(
        LrsEndpointSettings(adminRequest.endPoint, settings)
      )
      true
    }
  })

  post("/administering(/)")(action {
    PermissionUtil.requirePermissionApi(ViewPermission, PortletName.AdminView)

    val adminRequest = AdminRequest(this)
    adminRequest.actionType match {
      case AdminActionType.UpdateIssuerSettings    => updateIssuerSettings(adminRequest)
      case AdminActionType.UpdateEmailSettings     => updateEmailSettings(adminRequest)
      case AdminActionType.UpdateGoogleAPISettings => updateGoogleAPISettings(adminRequest)
    }
  })

  private def updateIssuerSettings(adminRequest: AdminRequest.Model) = {
    settingsManager.setIssuerName(adminRequest.issuerName)
    settingsManager.setIssuerURL(adminRequest.issuerUrl)
    settingsManager.setIssuerEmail(adminRequest.issuerEmail)
  }

  private def updateEmailSettings(adminRequest: AdminRequest.Model) = {
    settingsManager.setSendMessages(adminRequest.sendMessages.toBoolean)
  }

  private def updateGoogleAPISettings(adminRequest: AdminRequest.Model) = {
    settingsManager.setGoogleClientId(adminRequest.googleClientId)
    settingsManager.setGoogleAppId(adminRequest.googleAppId)
    settingsManager.setGoogleApiKey(adminRequest.googleApiKey)
  }
}
