package com.arcusys.learn.controllers.api

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

  get("/lrs2activity-filter-api-controller/:courseID")(jsonAction {
    requireTeacherPermissions()
    val settingRequest = LRSToActivitySettingsRequest(this)
    facade.getByCourseID(settingRequest.courseID)
  })

  post("/lrs2activity-filter-api-controller/")(jsonAction {
    requireTeacherPermissions()
    val settingRequest = LRSToActivitySettingsRequest(this)

    settingRequest.action match {
      case LRSToActivitySettingActionType.ADD =>
        facade.create(settingRequest.courseID, settingRequest.title, settingRequest.mappedActivity, settingRequest.mappedVerb)
      case LRSToActivitySettingActionType.DELETE =>
        facade.delete(settingRequest.id)
      case LRSToActivitySettingActionType.UPDATE =>
        facade.modify(settingRequest.id, settingRequest.courseID, settingRequest.title, settingRequest.mappedActivity, settingRequest.mappedVerb)
    }
  })
}
