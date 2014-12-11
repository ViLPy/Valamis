package com.arcusys.learn.scorm.manifest.storage.impl

import com.arcusys.learn.scorm.manifest.model.ActivityDataMap
import com.arcusys.learn.storage.impl.{ EntityStorageExt, EntityStorage }
import com.arcusys.learn.scorm.manifest.storage.ActivityDataStorage

@deprecated
trait ActivityDataEntityStorage extends ActivityDataStorage with EntityStorageExt[ActivityDataMap] {
  def create(packageID: Int, activityID: String, entity: ActivityDataMap) {
    create(entity, "packageID" -> packageID, "activityID" -> activityID)
  }

  def getForActivity(packageID: Int, activityID: String) = {
    getAll("packageID" -> packageID, "activityID" -> activityID)
  }

  def delete(packageID: Int, activityID: String) {
    delete("packageID" -> packageID, "activityID" -> activityID)
  }
}
