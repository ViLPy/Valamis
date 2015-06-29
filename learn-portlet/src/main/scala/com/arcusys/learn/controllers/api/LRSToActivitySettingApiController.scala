package com.arcusys.learn.controllers.api

import com.arcusys.learn.liferay.permission.{ PortletName, PermissionUtil, ViewPermission }
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.facades.LRSToActivitySettingFacade
import com.arcusys.learn.models.request.{ LRSToActivitySettingActionType, LRSToActivitySettingsRequest }

class LRSToActivitySettingApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  def this() = this(Configuration)

  val facade = new LRSToActivitySettingFacade

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  get("/lrs2activity-filter-api-controller(/)")(jsonAction {
    PermissionUtil.requirePermissionApi(ViewPermission, PortletName.LRSToActivityMapper)
    val settingRequest = LRSToActivitySettingsRequest(this)
    facade.getByCourseId(settingRequest.courseId)
  })

  post("/lrs2activity-filter-api-controller(/)")(jsonAction {
    PermissionUtil.requirePermissionApi(ViewPermission, PortletName.LRSToActivityMapper)
    val settingRequest = LRSToActivitySettingsRequest(this)

    settingRequest.action match {
      case LRSToActivitySettingActionType.Add =>
        facade.create(settingRequest.courseId, settingRequest.title, settingRequest.mappedActivity, settingRequest.mappedVerb)
      case LRSToActivitySettingActionType.Delete =>
        facade.delete(settingRequest.id)
      case LRSToActivitySettingActionType.Update =>
        facade.modify(settingRequest.id, settingRequest.courseId, settingRequest.title, settingRequest.mappedActivity, settingRequest.mappedVerb)
    }
  })
}
