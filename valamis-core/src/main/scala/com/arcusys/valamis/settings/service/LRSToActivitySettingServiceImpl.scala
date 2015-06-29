package com.arcusys.valamis.settings.service

import com.arcusys.valamis.exception.EntityNotFoundException
import com.arcusys.valamis.settings.model.LRSToActivitySetting
import com.arcusys.valamis.settings.storage.LRSToActivitySettingStorage
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class LRSToActivitySettingServiceImpl(implicit val bindingModule: BindingModule) extends LRSToActivitySettingService with Injectable {

  val lrsToActivitySettingStorage = inject[LRSToActivitySettingStorage]

  def getAll = lrsToActivitySettingStorage.getAll

  def getByCourseId(courseId: Int): Seq[LRSToActivitySetting] = {
    lrsToActivitySettingStorage.getByCourseID(courseId)
  }

  def create(courseId: Int, title: String, mappedActivity: Option[String], mappedVerb: Option[String]): LRSToActivitySetting = {
    val entity = LRSToActivitySetting(0, courseId, title, mappedActivity, mappedVerb)
    val storedId = lrsToActivitySettingStorage.createAndGetID(entity)
    lrsToActivitySettingStorage.getByID(storedId).getOrElse(throw new EntityNotFoundException)
  }

  def modify(id: Int, courseId: Int, title: String, mappedActivity: Option[String], mappedVerb: Option[String]): LRSToActivitySetting = {
    val storedEntity = lrsToActivitySettingStorage.getByID(id).getOrElse(throw new EntityNotFoundException)
    lrsToActivitySettingStorage.modify(
      storedEntity.copy(courseId = courseId, title = title, mappedActivity = mappedActivity, mappedVerb = mappedVerb)
    )
    lrsToActivitySettingStorage.getByID(storedEntity.id).getOrElse(throw new EntityNotFoundException)
  }

  def delete(id: Int) {
    lrsToActivitySettingStorage.delete(id)
  }
}
