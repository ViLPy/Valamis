package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.GenericEntityStorageImpl
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.sequencing.storage._
import org.orbroker.Row

class ObjectiveMapStorageImpl extends GenericEntityStorageImpl[ObjectiveMap]("ObjectiveMap") with ObjectiveMapStorage {
  def get(objectiveID: Int): Option[ObjectiveMap] = getOne("objectiveID" -> objectiveID)

  def create(objectiveID: Int, entity: ObjectiveMap) {
    create(entity, "objectiveID" -> objectiveID)
  }

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
