package com.arcusys.learn.scorm.manifest.sequencing.storage.impl

import com.arcusys.learn.scorm.manifest.sequencing.storage.RollupContributionStorage
import com.arcusys.learn.storage.impl.EntityStorageExt
import com.arcusys.learn.scorm.manifest.model.RollupContribution

/**
 * User: Yulia.Glushonkova
 * Date: 02.04.13
 */
trait RollupContributionEntityStorage extends RollupContributionStorage with EntityStorageExt[RollupContribution]  {
    def create(sequencingID: Int, entity: RollupContribution) {
      create(entity, "sequencingID" -> sequencingID, "satisfaction"->entity.satisfaction, "completion"->entity.completion)
    }
    def get(sequencingID: Int): Option[RollupContribution] = getOne("sequencingID" -> sequencingID)
    def delete(sequencingID: Int){ delete("sequencingID" -> sequencingID) }
}
