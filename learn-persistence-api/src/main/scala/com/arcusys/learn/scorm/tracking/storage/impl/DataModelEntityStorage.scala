package com.arcusys.learn.scorm.tracking.storage.impl

import com.arcusys.learn.storage.impl.{ EntityStorageExt, EntityStorage }
import com.arcusys.learn.scorm.tracking.storage.DataModelStorage
import com.arcusys.learn.scorm.tracking.model.AttemptData

@deprecated
trait DataModelEntityStorage extends DataModelStorage with EntityStorageExt[AttemptData] {
  def getKeyedValues(attemptID: Int, activityID: String): Map[String, Option[String]] =
    getAll("attemptID" -> attemptID, "activityID" -> activityID).map(data => (data.dataKey -> data.dataValue)).toMap

  def getValuesByKey(attemptID: Int, key: String): Map[String, Option[String]] =
    getAll("attemptID" -> attemptID, "dataKey" -> key).map(data => (data.activityID -> data.dataValue)).toMap

  def getValue(attemptID: Int, activityID: String, key: String): Option[String] =
    getOne("attemptID" -> attemptID, "activityID" -> activityID, "dataKey" -> key) match {
      case Some(e) => e.dataValue
      case _       => None
    }

  def setValue(attemptID: Int, activityID: String, key: String, value: String) {
    getValue(attemptID, activityID, key) match {
      case None    => create("attemptID" -> attemptID, "activityID" -> activityID, "dataKey" -> key, "dataValue" -> value)
      case Some(_) => modify("attemptID" -> attemptID, "activityID" -> activityID, "dataKey" -> key, "dataValue" -> value)
    }
  }

  def getCollectionValues(attemptID: Int, activityID: String, key: String): Map[String, Option[String]] = {
    // add matcher sign "%"
    val flatData = getAll("attemptID" -> attemptID, "activityID" -> activityID, "dataKey" -> (key + "%")).map {
      data =>
        data.dataKey -> data.dataValue
    }
    Map(flatData: _*)
  }
}
