package com.arcusys.learn.bl.services

import com.arcusys.learn.bl.exceptions.EntityNotFoundException
import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.setting.storage.LRSToActivitySettingStorage
import com.arcusys.learn.settings.model.LRSToActivitySetting
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class LRSToActivitySettingService(configuration: BindingModule) extends LRSToActivitySettingServiceContract with Injectable {
  def this() = this(DomainConfiguration)
  implicit val bindingModule = configuration

  val lrsToActivitySettingStorage = inject[LRSToActivitySettingStorage]

  def getByCourseID(courseID: Int): Seq[LRSToActivitySetting] = {
    lrsToActivitySettingStorage.getByCourseID(courseID)
  }

  def create(courseID: Int, title: String, mappedActivity: Option[String], mappedVerb: Option[String]): LRSToActivitySetting = {
    val entity = LRSToActivitySetting(0, courseID, title, mappedActivity, mappedVerb)
    val storedID = lrsToActivitySettingStorage.createAndGetID(entity)
    lrsToActivitySettingStorage.getByID(storedID).getOrElse(throw new EntityNotFoundException)
  }

  def modify(id: Int, courseID: Int, title: String, mappedActivity: Option[String], mappedVerb: Option[String]): LRSToActivitySetting = {
    val storedEntity = lrsToActivitySettingStorage.getByID(id).getOrElse(throw new EntityNotFoundException)
    lrsToActivitySettingStorage.modify(
      storedEntity.copy(courseID = courseID, title = title, mappedActivity = mappedActivity, mappedVerb = mappedVerb)
    )
    lrsToActivitySettingStorage.getByID(storedEntity.id).getOrElse(throw new EntityNotFoundException)
  }

  def delete(id: Int) {
    lrsToActivitySettingStorage.delete(id)
  }
}
