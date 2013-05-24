package com.arcusys.learn.scorm.manifest.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.GenericEntityStorageImpl
import com.arcusys.learn.scorm.manifest.model.ActivityDataMap
import org.orbroker.{RowExtractor, Row}
import com.arcusys.learn.scorm.manifest.storage.impl.ActivityDataEntityStorage

class ActivityDataStorageImpl extends GenericEntityStorageImpl[ActivityDataMap]("ActivityData") with ActivityDataEntityStorage with ActivityDataExtractor

trait ActivityDataExtractor extends RowExtractor[ActivityDataMap] {
  def extract(row: Row) = {
    new ActivityDataMap(
      row.string("targetId").get,
      row.bit("readSharedData").get,
      row.bit("writeSharedData").get
    )
  }
}
