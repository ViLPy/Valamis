package com.arcusys.learn.settings.model

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.settings.model.Setting
import com.arcusys.learn.persistence.liferay.service.LFSettingLocalServiceUtil
import com.arcusys.learn.persistence.liferay.model.LFSetting
import scala.collection.JavaConverters._

/**
 * User: Yulia.Glushonkova
 * Date: 02.10.13
 */
trait LFSettingStorageImpl extends KeyedEntityStorage[Setting] {
  protected def doRenew() {
      LFSettingLocalServiceUtil.removeAll()
  }

  def extract(entity: LFSetting) = new Setting(
    entity.getId.toInt,
    SettingType.withName(entity.getKey),
    entity.getValue)


  def getOne(parameters: (String, Any)*) = {
    parameters match {
      case Seq(("key", key: String)) => {
        val lfEntity = LFSettingLocalServiceUtil.findByKey(key)
        if (lfEntity == null) None else Option(extract(lfEntity))
      }
    }
  }

  def getAll(parameters: (String, Any)*) = {
    LFSettingLocalServiceUtil.getLFSettings(-1,-1).asScala.map(extract)
  }

  def create(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def create(entity: Setting, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def delete(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def modify(parameters: (String, Any)*) {
    parameters match {
      case Seq(("key", key: String), ("value", value: String)) => {
        val lfentity = LFSettingLocalServiceUtil.findByKey(key)
        lfentity.setValue(value)
        LFSettingLocalServiceUtil.updateLFSetting(lfentity)
      }
    }

  }

  def modify(entity: Setting, parameters: (String, Any)*) {
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
        val lfEntity = LFSettingLocalServiceUtil.createLFSetting()
        lfEntity.setKey(key)
        lfEntity.setValue(value)
        LFSettingLocalServiceUtil.addLFSetting(lfEntity).getId.toInt
      }
    }
  }
}
