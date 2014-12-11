package com.arcusys.learn.controllers.api

import com.arcusys.learn.bl.services.settings.SiteDependentSettingManager
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.request.SettingsRequest
import com.arcusys.learn.web.ServletBase

class SettingsApiController(configuration: BindingModule) extends BaseApiController(configuration) with ServletBase {
  def this() = this(Configuration)

  val settingsManager = inject[SiteDependentSettingManager]

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  post("/settings-api-controller/:siteID") {
    requireAdmin()
    val request = SettingsRequest(this)
    settingsManager.setSetting(request.siteID, request.keyID, request.value)
  }
}
