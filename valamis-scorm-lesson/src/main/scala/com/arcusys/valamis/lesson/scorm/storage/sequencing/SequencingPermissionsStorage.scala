package com.arcusys.valamis.lesson.scorm.storage.sequencing

import com.arcusys.valamis.lesson.scorm.model.manifest.SequencingPermissions

trait SequencingPermissionsStorage {
  def create(sequencingID: Int, entity: SequencingPermissions)
  def get(sequencingID: Int): Option[SequencingPermissions]
  def delete(sequencingID: Int)
  def renew()
}
