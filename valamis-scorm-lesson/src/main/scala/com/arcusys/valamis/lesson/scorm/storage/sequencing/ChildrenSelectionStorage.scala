package com.arcusys.valamis.lesson.scorm.storage.sequencing

import com.arcusys.valamis.lesson.scorm.model.manifest.ChildrenSelection

trait ChildrenSelectionStorage {
  def create(sequencingID: Int, entity: ChildrenSelection)
  def get(sequencingID: Int): Option[ChildrenSelection]
  def delete(sequencingID: Int)
  def renew()
}
