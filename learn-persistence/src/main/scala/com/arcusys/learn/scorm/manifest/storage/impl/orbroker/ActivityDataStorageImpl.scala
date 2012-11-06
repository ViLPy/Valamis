package com.arcusys.learn.scorm.manifest.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.GenericEntityStorageImpl
import com.arcusys.learn.scorm.manifest.model.ActivityDataMap
import org.orbroker.Row

class ActivityDataStorageImpl extends GenericEntityStorageImpl[ActivityDataMap]("ActivityData") {

  def create(packageID: Int, activityID: String, entity: ActivityDataMap) {
    create(entity, "packageID" -> packageID, "activityID" -> activityID)
  }

  def getForActivity(packageID: Int, activityID: String) = {
    getAll("packageID" -> packageID, "activityID" -> activityID)
  }

  def extract(row: Row) = {
    new ActivityDataMap(
      row.string("targetId").get,
      row.bit("readSharedData").get,
      row.bit("writeSharedData").get
    )
  }
}
