package com.arcusys.learn.scorm.tracking.storage.impl.orbroker

import com.arcusys.learn.scorm.tracking.storage._
import com.arcusys.learn.storage.impl.orbroker._
import impl.DataModelEntityStorage
import org.orbroker.{RowExtractor, Row}
import com.arcusys.learn.scorm.tracking.model.AttemptData

class DataModelStorageImpl extends GenericEntityStorageImpl[AttemptData]("DataModel") with DataModelEntityStorage with DataModelExtractor

trait DataModelExtractor extends RowExtractor[AttemptData] {

  def extract(row: Row) = new AttemptData(
    row.string("dataKey").get,
    row.string("dataValue"),
    row.integer("attemptID").get,
    row.string("activityID").get
  )

}
