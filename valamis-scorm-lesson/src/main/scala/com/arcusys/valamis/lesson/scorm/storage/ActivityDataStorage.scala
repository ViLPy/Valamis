package com.arcusys.valamis.lesson.scorm.storage

import com.arcusys.valamis.lesson.scorm.model.manifest.ActivityDataMap

trait ActivityDataStorage {
  def create(packageID: Int, activityID: String, entity: ActivityDataMap)
  def getForActivity(packageID: Int, activityID: String): Seq[ActivityDataMap]
  def delete(packageID: Int, activityID: String)
  def renew()
}
