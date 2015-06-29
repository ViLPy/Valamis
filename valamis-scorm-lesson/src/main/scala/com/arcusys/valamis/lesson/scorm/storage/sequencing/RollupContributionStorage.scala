package com.arcusys.valamis.lesson.scorm.storage.sequencing

import com.arcusys.valamis.lesson.scorm.model.manifest.RollupContribution

trait RollupContributionStorage {
  def create(sequencingID: Int, entity: RollupContribution)
  def get(sequencingID: Int): Option[RollupContribution]
  def delete(sequencingID: Int)
  def renew()
}
