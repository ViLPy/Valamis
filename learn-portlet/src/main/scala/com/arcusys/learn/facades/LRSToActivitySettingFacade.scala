package com.arcusys.learn.facades

import com.arcusys.valamis.settings.model.LRSToActivitySetting
import com.arcusys.valamis.settings.service.LRSToActivitySettingService
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }
import com.arcusys.learn.ioc.Configuration

class LRSToActivitySettingFacade(configuration: BindingModule) extends LRSToActivitySettingFacadeContract with Injectable {
  def this() = this(Configuration)
  implicit val bindingModule = configuration

  val lrsToActivitySettingService = inject[LRSToActivitySettingService]

  def getByCourseId(courseId: Int): Seq[LRSToActivitySetting] = {
    lrsToActivitySettingService.getByCourseId(courseId)
  }

  def create(courseId: Int, title: String, mappedActivity: Option[String], mappedVerb: Option[String]): LRSToActivitySetting = {
    lrsToActivitySettingService.create(courseId, title, mappedActivity, mappedVerb)
  }

  def modify(id: Int, courseId: Int, title: String, mappedActivity: Option[String], mappedVerb: Option[String]): LRSToActivitySetting = {
    lrsToActivitySettingService.modify(id, courseId, title, mappedActivity, mappedVerb)
  }

  def delete(id: Int) {
    lrsToActivitySettingService.delete(id)
  }
}
