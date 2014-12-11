package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFActivityDataMap
import com.arcusys.learn.persistence.liferay.service.LFActivityDataMapLocalServiceUtil
import com.arcusys.learn.scorm.manifest.model.ActivityDataMap
import com.arcusys.learn.scorm.manifest.storage.{ ActivityDataStorage }
import scala.collection.JavaConverters._

/**
 * Created by mminin on 16.10.14.
 */
class ActivityDataRepositoryImpl extends ActivityDataStorage {
  def renew() = {
    LFActivityDataMapLocalServiceUtil.removeAll()
  }

  def create(packageID: Int, activityID: String, entity: ActivityDataMap) {
    val newEntity: LFActivityDataMap = LFActivityDataMapLocalServiceUtil.createLFAttemptData()
    newEntity.setTargetId(entity.targetId)
    newEntity.setReadSharedData(entity.readSharedData)
    newEntity.setWriteSharedData(entity.writeSharedData)

    newEntity.setPackageID(packageID)
    newEntity.setActivityID(activityID)

    LFActivityDataMapLocalServiceUtil.addLFActivityDataMap(newEntity)
  }

  def getForActivity(packageID: Int, activityID: String) = {
    LFActivityDataMapLocalServiceUtil.findByPackageIDAndActivityID(packageID, activityID).asScala map extract
  }

  def delete(packageID: Int, activityID: String) {
    LFActivityDataMapLocalServiceUtil.removeByPackageIDAndActivityID(packageID, activityID)
  }

  private def extract(entity: LFActivityDataMap) =
    new ActivityDataMap(entity.getTargetId, entity.getReadSharedData, entity.getWriteSharedData)
}
