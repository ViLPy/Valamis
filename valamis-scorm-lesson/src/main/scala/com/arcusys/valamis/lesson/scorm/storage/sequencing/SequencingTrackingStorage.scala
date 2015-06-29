package com.arcusys.valamis.lesson.scorm.storage.sequencing

import com.arcusys.valamis.lesson.scorm.model.manifest.SequencingTracking

trait SequencingTrackingStorage {
  def create(sequencingID: Int, entity: SequencingTracking)
  def get(sequencingID: Int): Option[SequencingTracking]
  def delete(sequencingID: Int)
  def renew()
}
