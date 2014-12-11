package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.scorm.manifest.model.ActivityDataMap
import com.arcusys.learn.persistence.liferay.service.LFActivityDataMapLocalServiceUtil
import com.arcusys.learn.persistence.liferay.model.LFActivityDataMap
import scala.collection.JavaConverters._

@deprecated
trait LFActivityDataMapStorageImpl extends EntityStorage[ActivityDataMap] {
  protected def doRenew() { LFActivityDataMapLocalServiceUtil.removeAll() }

  def extract(entity: LFActivityDataMap) =
    new ActivityDataMap(entity.getTargetId, entity.getReadSharedData, entity.getWriteSharedData)

  def getAll(parameters: (String, Any)*) = {
    parameters match {
      case Seq(("packageID", packageID: Int), ("activityID", activityID: String)) =>
        LFActivityDataMapLocalServiceUtil.findByPackageIDAndActivityID(packageID, activityID).asScala map {
          extract
        }
    }
  }

  def create(entity: ActivityDataMap, parameters: (String, Any)*) {
    val newEntity: LFActivityDataMap = LFActivityDataMapLocalServiceUtil.createLFAttemptData()
    newEntity.setTargetId(entity.targetId)
    newEntity.setReadSharedData(entity.readSharedData)
    newEntity.setWriteSharedData(entity.writeSharedData)

    parameters.foreach {
      param =>
        param match {
          case ("packageID", value: Int)     => newEntity.setPackageID(value)
          case ("activityID", value: String) => newEntity.setActivityID(value)
        }
    }
    LFActivityDataMapLocalServiceUtil.addLFActivityDataMap(newEntity)
  }

  def delete(parameters: (String, Any)*) {
    parameters match {
      case Seq(("packageID", packageID: Int), ("activityID", activityID: String)) =>
        LFActivityDataMapLocalServiceUtil.removeByPackageIDAndActivityID(packageID, activityID)
    }
  }

  // Unsupported
  def create(parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def getOne(parameters: (String, Any)*) = throw new UnsupportedOperationException("Not implemented")

  def modify(parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def modify(entity: ActivityDataMap, parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }
}
