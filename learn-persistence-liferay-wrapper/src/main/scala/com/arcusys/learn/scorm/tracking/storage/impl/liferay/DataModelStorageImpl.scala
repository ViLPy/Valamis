package com.arcusys.learn.scorm.tracking.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFAttemptData
import com.arcusys.learn.persistence.liferay.service.LFAttemptDataLocalServiceUtil
import com.arcusys.valamis.lesson.scorm.model.tracking.AttemptData
import com.arcusys.valamis.lesson.scorm.storage.tracking.DataModelStorage
import scala.collection.JavaConverters._

/**
 * Created by mminin on 16.10.14.
 */
class DataModelStorageImpl extends DataModelStorage {

  override def renew(): Unit = {
    LFAttemptDataLocalServiceUtil.removeAll()
  }

  override def getKeyedValues(attemptID: Int, activityID: String): Map[String, Option[String]] = {
    LFAttemptDataLocalServiceUtil.findByAttemptIDWithActivityID(attemptID, activityID).asScala
      .map(extract)
      .map(data => (data.dataKey -> data.dataValue)).toMap
  }

  override def getValuesByKey(attemptID: Int, key: String): Map[String, Option[String]] = {
    LFAttemptDataLocalServiceUtil.findByAttemptIDWithDataKey(attemptID, key).asScala
      .map(extract)
      .map(data => (data.activityID -> data.dataValue)).toMap
  }

  override def getValue(attemptID: Int, activityID: String, key: String): Option[String] = {
    LFAttemptDataLocalServiceUtil.findBySingleKey(attemptID, activityID, key, 0, 1).asScala.headOption
      .map(extract)
      .flatMap(_.dataValue)
  }

  override def setValue(attemptID: Int, activityID: String, key: String, value: String) {
    getValue(attemptID, activityID, key) match {
      case None =>
        val newEntity: LFAttemptData = LFAttemptDataLocalServiceUtil.createLFAttemptData()
        newEntity.setAttemptID(attemptID)
        newEntity.setActivityID(activityID)
        newEntity.setDataKey(key)
        newEntity.setDataValue(value)
        LFAttemptDataLocalServiceUtil.addLFAttemptData(newEntity)
      case Some(_) =>
        val found = LFAttemptDataLocalServiceUtil.findBySingleKey(attemptID, activityID, key, 0, 1)
        if (!found.isEmpty) {
          val entity = found.get(0)
          entity.setDataValue(value)
          LFAttemptDataLocalServiceUtil.updateLFAttemptData(entity)
        }
    }
  }

  override def getCollectionValues(attemptID: Int, activityID: String, key: String): Map[String, Option[String]] = {
    // add matcher sign "%"
    val flatData = LFAttemptDataLocalServiceUtil.findByCollectionValues(attemptID, activityID, key + "%").asScala
      .map(extract)
      .map(data => data.dataKey -> data.dataValue)
    Map(flatData: _*)
  }

  private def extract(entity: LFAttemptData) = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    new AttemptData(entity.getDataKey, entity.getDataValue.toOption, entity.getAttemptID, entity.getActivityID)
  }
}
