package com.arcusys.learn.controllers.api

import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.permission.{ PortletName, PermissionUtil, ViewPermission }
import com.arcusys.learn.models.request.SettingsRequest
import com.arcusys.learn.web.ServletBase
import com.arcusys.valamis.settings.service.SiteDependentSettingServiceImpl
import com.escalatesoft.subcut.inject.BindingModule
import PermissionUtil._

class SettingsApiController(configuration: BindingModule) extends BaseApiController(configuration) with ServletBase {
  def this() = this(Configuration)

  val settingsManager = inject[SiteDependentSettingServiceImpl]

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  post("/settings-api-controller(/)") {
    requirePermissionApi(ViewPermission, PortletName.ActivityToLRSMapper)
    val request = SettingsRequest(this)
    settingsManager.setSetting(request.courseId, request.keyId, request.value)
  }
}
