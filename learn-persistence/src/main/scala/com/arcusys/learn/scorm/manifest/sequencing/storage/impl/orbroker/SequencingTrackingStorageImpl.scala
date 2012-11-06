package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.GenericEntityStorageImpl
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.sequencing.storage._
import org.orbroker.Row

class SequencingTrackingStorageImpl extends GenericEntityStorageImpl[SequencingTracking]("SequencingTracking") with SequencingTrackingStorage {
  def create(sequencingID: Int, entity: SequencingTracking) {
    create(entity, "sequencingID"->sequencingID)
  }

  def get(sequencingID: Int): Option[SequencingTracking] = getOne("sequencingID"->sequencingID)

  def extract(row: Row) = {
    new SequencingTracking(
      row.bit("completionSetByContent").get,
      row.bit("objectiveSetByContent").get
    )
  }
}
