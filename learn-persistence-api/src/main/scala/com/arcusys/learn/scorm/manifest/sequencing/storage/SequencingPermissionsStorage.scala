package com.arcusys.learn.scorm.manifest.sequencing.storage

import com.arcusys.learn.scorm.manifest.model.SequencingPermissions

trait SequencingPermissionsStorage {
  def create(sequencingID: Int, entity: SequencingPermissions)
  def get(sequencingID: Int): Option[SequencingPermissions]
  def delete(sequencingID: Int)
  def renew()
}
