package com.arcusys.learn.scorm.manifest.sequencing.storage.impl

import com.arcusys.learn.storage.impl.EntityStorageExt
import com.arcusys.valamis.lesson.scorm.model.manifest.SequencingPermissions
import com.arcusys.valamis.lesson.scorm.storage.sequencing.SequencingPermissionsStorage

/**
 * User: Yulia.Glushonkova
 * Date: 29.03.13
 */
trait SequencingPermissionsEntityStorage extends SequencingPermissionsStorage with EntityStorageExt[SequencingPermissions] {
  def create(sequencingID: Int, entity: SequencingPermissions) {
    create(entity, "sequencingID" -> sequencingID)
  }
  def get(sequencingID: Int): Option[SequencingPermissions] = {
    getOne("sequencingID" -> sequencingID)
  }
  def delete(sequencingID: Int) { delete("sequencingID" -> sequencingID) }
}
