package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.GenericEntityStorageImpl
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.sequencing.storage._
import impl.{ObjectiveMapEntityStorage, SequencingPermissionsEntityStorage}
import org.orbroker.{RowExtractor, Row}

class ObjectiveMapStorageImpl extends GenericEntityStorageImpl[ObjectiveMap]("ObjectiveMap") with ObjectiveMapEntityStorage with ObjectiveMapExtractor

trait ObjectiveMapExtractor extends RowExtractor[ObjectiveMap] {
  def extract(row: Row) = {
    new ObjectiveMap(
      row.string("readSatisfiedStatusFrom"),
      row.string("readNormalizedMeasureFrom"),
      row.string("writeSatisfiedStatusTo"),
      row.string("writeNormalizedMeasureTo"),
      row.string("readRawScoreFrom"),
      row.string("readMinScoreFrom"),
      row.string("readMaxScoreFrom"),
      row.string("readCompletionStatusFrom"),
      row.string("readProgressMeasureFrom"),
      row.string("writeRawScoreTo"),
      row.string("writeMinScoreTo"),
      row.string("writeMaxScoreTo"),
      row.string("writeCompletionStatusTo"),
      row.string("writeProgressMeasureTo")
    )
  }
}
