package com.arcusys.learn.settings.model

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.persistence.liferay.service.LFLRSToActivitySettingLocalServiceUtil
import scala.collection.JavaConverters._
import com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting
import scala.util.Try

trait LFLRSToActivitySettingStorageImpl extends KeyedEntityStorage[LRSToActivitySetting] {
  protected def doRenew() {
    LFLRSToActivitySettingLocalServiceUtil.removeAll()
  }

  def extract(entity: LFLRSToActivitySetting) = LRSToActivitySetting(
    entity.getId.toInt,
    entity.getCourseID,
    entity.getTitle,
    Option(entity.getActivityFilter),
    Option(entity.getVerbFilter))

  def getOne(parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getAll(parameters: (String, Any)*) = parameters match {
    case Seq(("courseID", courseID: Int)) =>
      LFLRSToActivitySettingLocalServiceUtil.findByCourseID(courseID).asScala.map(extract)
    case _ =>
      LFLRSToActivitySettingLocalServiceUtil.getLFLRSToActivitySettings(-1, -1).asScala.map(extract)
  }

  def create(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def create(entity: LRSToActivitySetting, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def delete(parameters: (String, Any)*) {
    parameters match {
      case Seq(("id", id: Int)) =>
        LFLRSToActivitySettingLocalServiceUtil.deleteLFLRSToActivitySetting(id)
    }
  }

  def modify(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def modify(entity: LRSToActivitySetting, parameters: (String, Any)*) {
    val lfEntity = LFLRSToActivitySettingLocalServiceUtil.getLFLRSToActivitySetting(entity.id)
    lfEntity.setCourseID(entity.courseID)
    lfEntity.setTitle(entity.title)
    if (entity.mappedActivity.isDefined && entity.mappedActivity.get.nonEmpty)
      entity.mappedActivity.foreach(lfEntity.setActivityFilter)
    else lfEntity.setActivityFilter(null)

    if (entity.mappedVerb.isDefined && entity.mappedVerb.get.nonEmpty)
      entity.mappedVerb.foreach(lfEntity.setVerbFilter)
    else lfEntity.setVerbFilter(null)

    LFLRSToActivitySettingLocalServiceUtil.updateLFLRSToActivitySetting(lfEntity)
  }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getByID(id: Int, parameters: (String, Any)*) = {
    Try(LFLRSToActivitySettingLocalServiceUtil.getLFLRSToActivitySetting(id)).toOption.map(extract)
  }

  def createAndGetID(entity: LRSToActivitySetting, parameters: (String, Any)*) = {
    val lfEntity = LFLRSToActivitySettingLocalServiceUtil.createLFLRSToActivitySetting()
    lfEntity.setCourseID(entity.courseID)
    lfEntity.setTitle(entity.title)

    if (entity.mappedActivity.isDefined && entity.mappedActivity.get.nonEmpty)
      entity.mappedActivity.foreach(lfEntity.setActivityFilter)
    else lfEntity.setActivityFilter(null)

    if (entity.mappedVerb.isDefined && entity.mappedVerb.get.nonEmpty)
      entity.mappedVerb.foreach(lfEntity.setVerbFilter)
    else lfEntity.setVerbFilter(null)

    LFLRSToActivitySettingLocalServiceUtil.addLFLRSToActivitySetting(lfEntity).getId.toInt
  }

  def createAndGetID(parameters: (String, Any)*) = {
    throw new UnsupportedOperationException
  }
}
