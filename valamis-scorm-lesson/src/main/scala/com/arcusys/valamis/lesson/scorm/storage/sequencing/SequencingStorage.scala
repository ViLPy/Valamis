package com.arcusys.valamis.lesson.scorm.storage.sequencing

import com.arcusys.valamis.lesson.scorm.model.manifest.Sequencing

trait SequencingStorage {
  def create(packageID: Int, activityID: String, sequencing: Sequencing)
  def get(packageID: Int, activityID: String): Option[Sequencing]
  def delete(packageID: Int, activityID: String)
  def renew()
}
