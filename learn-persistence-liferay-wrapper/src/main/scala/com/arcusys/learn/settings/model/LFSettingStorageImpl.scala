package com.arcusys.learn.settings.model

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.persistence.liferay.service.LFConfigLocalServiceUtil
import com.arcusys.valamis.settings.model
import com.arcusys.valamis.settings.model.{ SettingType, Setting }
import scala.collection.JavaConverters._
import com.arcusys.learn.persistence.liferay.model.LFConfig

/**
 * User: Yulia.Glushonkova
 * Date: 02.10.13
 */
trait LFSettingStorageImpl extends KeyedEntityStorage[model.Setting] {
  protected def doRenew() {
    LFConfigLocalServiceUtil.removeAll()
  }

  def extract(entity: LFConfig) = new model.Setting(
    entity.getId.toInt,
    SettingType.withName(entity.getDataKey),
    entity.getDataValue)

  def getOne(parameters: (String, Any)*) = {
    parameters match {
      case Seq(("key", key: String)) => {
        val lfEntity = LFConfigLocalServiceUtil.findByKey(key)
        if (lfEntity == null) None else Option(extract(lfEntity))
      }
    }
  }

  def getAll(parameters: (String, Any)*) = {
    LFConfigLocalServiceUtil.getLFConfigs(-1, -1).asScala.map(extract)
  }

  def create(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def create(entity: model.Setting, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def delete(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def modify(parameters: (String, Any)*) {
    parameters match {
      case Seq(("key", key: String), ("value", value: String)) => {
        val lfentity = LFConfigLocalServiceUtil.findByKey(key)
        lfentity.setDataValue(value)
        LFConfigLocalServiceUtil.updateLFConfig(lfentity)
      }
    }

  }

  def modify(entity: model.Setting, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
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
    throw new UnsupportedOperationException
  }

  def createAndGetID(entity: Setting, parameters: (String, Any)*) = {
    throw new UnsupportedOperationException
  }

  def createAndGetID(parameters: (String, Any)*) = {
    parameters match {
      case Seq(("key", key: String), ("value", value: String)) => {
        val lfEntity = LFConfigLocalServiceUtil.createLFConfig()
        lfEntity.setDataKey(key)
        lfEntity.setDataValue(value)
        LFConfigLocalServiceUtil.addLFConfig(lfEntity).getId.toInt
      }
    }
  }
}
