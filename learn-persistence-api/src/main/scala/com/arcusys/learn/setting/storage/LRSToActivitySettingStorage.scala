package com.arcusys.learn.setting.storage

import com.arcusys.learn.settings.model.LRSToActivitySetting

trait LRSToActivitySettingStorage {
  def getAll: Seq[LRSToActivitySetting]
  def getByID(id: Int): Option[LRSToActivitySetting]
  def getByCourseID(courseID: Int): Seq[LRSToActivitySetting]
  def createAndGetID(entity: LRSToActivitySetting): Int
  def modify(entity: LRSToActivitySetting)
  def delete(id: Int)
  def renew()
}
