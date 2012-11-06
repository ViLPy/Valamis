package com.arcusys.learn.scorm.manifest.sequencing.storage

import com.arcusys.learn.scorm.manifest.model._

trait RollupContributionStorage {
  def create(sequencingID: Int, entity: RollupContribution)

  def get(sequencingID: Int): Option[RollupContribution]
}
