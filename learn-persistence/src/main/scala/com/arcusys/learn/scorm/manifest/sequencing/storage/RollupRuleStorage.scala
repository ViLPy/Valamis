package com.arcusys.learn.scorm.manifest.sequencing.storage

import com.arcusys.learn.scorm.manifest.model.RollupRule

trait RollupRuleStorage {
  def create(sequencingID: Int, entity: RollupRule)

  def get(sequencingID: Int): Seq[RollupRule]
}
