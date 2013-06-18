package com.arcusys.learn.scorm.manifest.storage

import com.arcusys.learn.scorm.manifest.model.ActivityDataMap

trait ActivityDataStorage {
  def create(packageID: Int, activityID: String, entity: ActivityDataMap)
  def getForActivity(packageID: Int, activityID: String): Seq[ActivityDataMap]
  def delete(packageID: Int, activityID: String)
  def renew()
}
