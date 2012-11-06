package com.arcusys.learn.scorm.tracking.storage.impl.orbroker

import com.arcusys.learn.scorm.tracking.storage._
import com.arcusys.learn.storage.impl.orbroker._
import org.orbroker.Row
import com.arcusys.learn.scorm.tracking.model.AttemptData

class DataModelStorageImpl extends GenericEntityStorageImpl[AttemptData]("DataModel") with DataModelStorage {
  def getKeyedValues(attemptID: Int, activityID: String): Map[String, Option[String]] =
    getAll("attemptID" -> attemptID, "activityID" -> activityID).map(data => (data.dataKey -> data.dataValue)).toMap

  def getValuesByKey(attemptID: Int, key: String): Map[String, Option[String]] =
    getAll("attemptID" -> attemptID, "dataKey" -> key).map(data => (data.activityID -> data.dataValue)).toMap

  def getValue(attemptID: Int, activityID: String, key: String): Option[String] =
    getOne("attemptID" -> attemptID, "activityID" -> activityID, "dataKey" -> key) match {
      case Some(e) => e.dataValue
      case _ => None
    }

  def setValue(attemptID: Int, activityID: String, key: String, value: String) {
    val action = getValue(attemptID, activityID, key) match {
      case None => "_insert"
      case Some(_) => "_update"
    }
    execute(action, "attemptID" -> attemptID, "activityID" -> activityID, "dataKey" -> key, "dataValue" -> value)
  }

  def getCollectionValues(attemptID: Int, activityID: String, key: String): Map[String, Option[String]] = {
    // add matcher sign "%"
    val flatData = getAll("attemptID" -> attemptID, "activityID" -> activityID, "dataKey" -> (key + "%")).map {
      data =>
        data.dataKey -> data.dataValue
    }
    Map(flatData: _*)
  }

  def extract(row: Row) = new AttemptData(
    row.string("dataKey").get,
    row.string("dataValue"),
    row.integer("attemptID").get,
    row.string("activityID").get
  )

}
