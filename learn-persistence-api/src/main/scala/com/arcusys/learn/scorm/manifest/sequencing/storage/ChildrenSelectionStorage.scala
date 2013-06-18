package com.arcusys.learn.scorm.manifest.sequencing.storage

import com.arcusys.learn.scorm.manifest.model.ChildrenSelection

trait ChildrenSelectionStorage {
  def create(sequencingID: Int, entity: ChildrenSelection)
  def get(sequencingID: Int): Option[ChildrenSelection]
  def delete(sequencingID: Int)
  def renew()
}
