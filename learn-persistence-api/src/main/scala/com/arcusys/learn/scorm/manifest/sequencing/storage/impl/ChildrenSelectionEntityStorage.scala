package com.arcusys.learn.scorm.manifest.sequencing.storage.impl

import com.arcusys.learn.storage.impl.{ EntityStorageExt, KeyedEntityStorageExt }
import com.arcusys.valamis.lesson.scorm.model.manifest.ChildrenSelection
import com.arcusys.valamis.lesson.scorm.storage.sequencing.ChildrenSelectionStorage

/**
 * User: Yulia.Glushonkova
 * Date: 02.04.13
 */
trait ChildrenSelectionEntityStorage extends ChildrenSelectionStorage with EntityStorageExt[ChildrenSelection] {
  def create(sequencingID: Int, entity: ChildrenSelection) {
    create(entity, "sequencingID" -> sequencingID)
  }
  def get(sequencingID: Int): Option[ChildrenSelection] = getOne("sequencingID" -> sequencingID)
  def delete(sequencingID: Int) { delete("sequencingID" -> sequencingID) }
}
