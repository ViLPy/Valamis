package com.arcusys.learn.setting.storage

import com.arcusys.learn.settings.model.{SettingType, Setting}

/**
 * User: Yulia.Glushonkova
 * Date: 02.10.13
 */
trait SettingStorage {
  def getAll: Seq[Setting]
  def getByKey(key: SettingType.Value): Option[Setting]
  def createAndGetID(entity: Setting): Int
  def modify(key: SettingType.Value, value: String)
  def renew()
}
