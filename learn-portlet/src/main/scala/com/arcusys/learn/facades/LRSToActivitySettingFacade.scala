package com.arcusys.learn.facades

import com.arcusys.learn.bl.services.LRSToActivitySettingServiceContract
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.settings.model.LRSToActivitySetting

class LRSToActivitySettingFacade(configuration: BindingModule) extends LRSToActivitySettingFacadeContract with Injectable {
  def this() = this(Configuration)
  implicit val bindingModule = configuration

  val lrsToActivitySettingService = inject[LRSToActivitySettingServiceContract]

  def getByCourseID(courseID: Int): Seq[LRSToActivitySetting] = {
    lrsToActivitySettingService.getByCourseID(courseID)
  }

  def create(courseID: Int, title: String, mappedActivity: Option[String], mappedVerb: Option[String]): LRSToActivitySetting = {
    lrsToActivitySettingService.create(courseID, title, mappedActivity, mappedVerb)
  }

  def modify(id: Int, courseID: Int, title: String, mappedActivity: Option[String], mappedVerb: Option[String]): LRSToActivitySetting = {
    lrsToActivitySettingService.modify(id, courseID, title, mappedActivity, mappedVerb)
  }

  def delete(id: Int) {
    lrsToActivitySettingService.delete(id)
  }
}
