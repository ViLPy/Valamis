package com.arcusys.learn.scorm.manifest.sequencing.storage

import com.arcusys.learn.scorm.manifest.model._

trait SequencingPermissionsStorage {
  def create(sequencingID: Int, entity: SequencingPermissions)

  def get(sequencingID: Int): Option[SequencingPermissions]
}
