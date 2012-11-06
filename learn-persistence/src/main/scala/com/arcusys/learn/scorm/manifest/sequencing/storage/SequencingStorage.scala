package com.arcusys.learn.scorm.manifest.sequencing.storage

import com.arcusys.learn.scorm.manifest.model.Sequencing

trait SequencingStorage {
  def create(packageID: Int, activityID: String, sequencing: Sequencing)

  def get(packageID: Int, activityID: String): Option[Sequencing]
}
