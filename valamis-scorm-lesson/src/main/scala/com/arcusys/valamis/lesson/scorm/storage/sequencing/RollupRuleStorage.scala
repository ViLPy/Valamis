package com.arcusys.valamis.lesson.scorm.storage.sequencing

import com.arcusys.valamis.lesson.scorm.model.manifest.RollupRule

trait RollupRuleStorage {
  def create(sequencingID: Int, entity: RollupRule)
  def get(sequencingID: Int): Seq[RollupRule]
  def deleteBySequencing(sequencingID: Int)
  def renew()
}
