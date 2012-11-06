package com.arcusys.learn.scorm.manifest.sequencing.storage

import com.arcusys.learn.scorm.manifest.model.SequencingTracking

trait SequencingTrackingStorage {
  def create(sequencingID: Int, entity: SequencingTracking)

  def get(sequencingID: Int): Option[SequencingTracking]
}
