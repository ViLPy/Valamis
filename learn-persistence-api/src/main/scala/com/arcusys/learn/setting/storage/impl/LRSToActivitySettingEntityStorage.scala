package com.arcusys.learn.setting.storage.impl

import com.arcusys.learn.storage.impl.{ EntityStorageExt, KeyedEntityStorageExt }
import com.arcusys.learn.setting.storage.LRSToActivitySettingStorage
import com.arcusys.learn.settings.model.LRSToActivitySetting

trait LRSToActivitySettingEntityStorage extends LRSToActivitySettingStorage
    with KeyedEntityStorageExt[LRSToActivitySetting] with EntityStorageExt[LRSToActivitySetting] {
  def getByCourseID(courseID: Int): Seq[LRSToActivitySetting] = {
    getAll("courseID" -> courseID)
  }
}