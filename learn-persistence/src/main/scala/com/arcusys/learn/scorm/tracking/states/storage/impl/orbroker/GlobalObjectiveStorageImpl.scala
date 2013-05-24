package com.arcusys.learn.scorm.tracking.states.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.GenericEntityStorageImpl
import org.orbroker.{RowExtractor, Row}
import com.arcusys.learn.scorm.tracking.model.GlobalObjectiveState
import com.arcusys.learn.scorm.tracking.states.storage.impl.GlobalObjectiveEntityStorage

class GlobalObjectiveStorageImpl extends GenericEntityStorageImpl[(String, GlobalObjectiveState)]("GlobalObjective") with GlobalObjectiveEntityStorage with GlobalObjectiveExtractor

trait GlobalObjectiveExtractor extends RowExtractor[(String, GlobalObjectiveState)] {
  def extract(row: Row) = {
    (row.string("mapKey").get, new GlobalObjectiveState(
      row.bit("satisfied"),
      row.decimal("normalizedMeasure").map(BigDecimal(_)),
      row.bit("attemptCompleted")
    ))
  }
}
