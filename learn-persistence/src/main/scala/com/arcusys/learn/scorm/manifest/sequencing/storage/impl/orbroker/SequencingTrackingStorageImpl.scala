package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.GenericEntityStorageImpl
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.sequencing.storage._
import impl.SequencingTrackingEntityStorage
import org.orbroker.{RowExtractor, Row}

class SequencingTrackingStorageImpl extends GenericEntityStorageImpl[SequencingTracking]("SequencingTracking") with SequencingTrackingEntityStorage with SequencingTrackingExtractor

trait SequencingTrackingExtractor extends RowExtractor[SequencingTracking] {
  def extract(row: Row) = {
    new SequencingTracking(
      row.bit("completionSetByContent").get,
      row.bit("objectiveSetByContent").get
    )
  }
}
