package com.arcusys.valamis.settings.storage

import com.arcusys.valamis.settings.model.LRSToActivitySetting

trait LRSToActivitySettingStorage {
  def getAll: Seq[LRSToActivitySetting]
  def getByID(id: Int): Option[LRSToActivitySetting]
  def getByCourseID(courseID: Int): Seq[LRSToActivitySetting]
  def createAndGetID(entity: LRSToActivitySetting): Int
  def modify(entity: LRSToActivitySetting)
  def delete(id: Int)
  def renew()
}
