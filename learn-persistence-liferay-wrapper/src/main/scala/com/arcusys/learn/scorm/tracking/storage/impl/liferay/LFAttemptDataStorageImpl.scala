package com.arcusys.learn.scorm.tracking.storage.impl.liferay

import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.scorm.tracking.model.AttemptData
import com.arcusys.learn.persistence.liferay.service.LFAttemptDataLocalServiceUtil
import scala.collection.JavaConverters._
import com.arcusys.learn.persistence.liferay.model.LFAttemptData

@deprecated
trait LFAttemptDataStorageImpl extends EntityStorage[AttemptData] {
  protected def doRenew() { LFAttemptDataLocalServiceUtil.removeAll() }

  def extract(entity: LFAttemptData) = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    new AttemptData(entity.getDataKey, entity.getDataValue.toOption, entity.getAttemptID, entity.getActivityID)
  }

  def getOne(parameters: (String, Any)*) = {
    parameters match {
      case Seq(("attemptID", attemptID: Int), ("activityID", activityID: String), ("dataKey", dataKey: String)) =>
        LFAttemptDataLocalServiceUtil.findBySingleKey(attemptID, activityID, dataKey, 0, 1).asScala.headOption map {
          extract
        }
      case _ => None
    }
  }

  def getAll(parameters: (String, Any)*) = {
    parameters match {
      case Seq(("attemptID", attemptID: Int), ("activityID", activityID: String), ("dataKey", dataKey: String)) =>
        LFAttemptDataLocalServiceUtil.findByCollectionValues(attemptID, activityID, dataKey).asScala map {
          extract
        }
      case Seq(("attemptID", attemptID: Int), ("activityID", activityID: String)) =>
        LFAttemptDataLocalServiceUtil.findByAttemptIDWithActivityID(attemptID, activityID).asScala map {
          extract
        }
      case Seq(("attemptID", attemptID: Int), ("dataKey", dataKey: String)) =>
        LFAttemptDataLocalServiceUtil.findByAttemptIDWithDataKey(attemptID, dataKey).asScala map {
          extract
        }
      case _ => Seq()
    }
  }

  def create(parameters: (String, Any)*) {
    val newEntity: LFAttemptData = LFAttemptDataLocalServiceUtil.createLFAttemptData()
    parameters.foreach {
      param =>
        param match {
          case ("attemptID", value: Int)     => newEntity.setAttemptID(value)
          case ("activityID", value: String) => newEntity.setActivityID(value)
          case ("dataKey", value: String)    => newEntity.setDataKey(value)
          case ("dataValue", value: String)  => newEntity.setDataValue(value)
        }
    }
    LFAttemptDataLocalServiceUtil.addLFAttemptData(newEntity)
  }

  def modify(parameters: (String, Any)*) {
    parameters match {
      case Seq(("attemptID", attemptID: Int),
        ("activityID", activityID: String),
        ("dataKey", dataKey: String),
        ("dataValue", dataValue: String)) => {
        val found = LFAttemptDataLocalServiceUtil.findBySingleKey(attemptID, activityID, dataKey, 0, 1)
        if (!found.isEmpty) {
          val entity = found.get(0)
          entity.setDataValue(dataValue)
          LFAttemptDataLocalServiceUtil.updateLFAttemptData(entity)
        }
      }
    }
  }

  def create(entity: AttemptData, parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def delete(parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def modify(entity: AttemptData, parameters: (String, Any)*) {
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
