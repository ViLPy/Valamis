package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.GenericEntityStorageImpl
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.sequencing.storage._
import org.orbroker.Row

class RollupContributionStorageImpl extends GenericEntityStorageImpl[RollupContribution]("RollupContribution") with RollupContributionStorage {
  def create(sequencingID: Int, entity: RollupContribution) {
    create(entity, "sequencingID" -> sequencingID, "satisfaction"->entity.satisfaction, "completion"->entity.completion)
  }

  def get(sequencingID: Int): Option[RollupContribution] = getOne("sequencingID" -> sequencingID)

  def extract(row: Row) = {
    val contributeToSatisfied = row.string("contributeToSatisfied")
    val contributeToNotSatisfied = row.string("contributeToNotSatisfied")
    val contributeToCompleted = row.string("contributeToCompleted")
    val contributeToIncomplete = row.string("contributeToIncomplete")

    val satisfaction = if (contributeToSatisfied.isDefined && contributeToNotSatisfied.isDefined) {
      Some(new SatisfactionRollupContribution(RollupConsiderationType.withName(contributeToSatisfied.get), RollupConsiderationType.withName(contributeToNotSatisfied.get)))
    } else None

    val completion = if (contributeToCompleted.isDefined && contributeToIncomplete.isDefined) {
      Some(new CompletionRollupContribution(RollupConsiderationType.withName(contributeToCompleted.get), RollupConsiderationType.withName(contributeToIncomplete.get)))
    } else None

    new RollupContribution(
      satisfaction,
      completion,
      row.decimal("objectiveMeasureWeight").get,
      row.bit("measureSatisfactionIfActive").get
    )
  }
}
