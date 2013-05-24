package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.GenericEntityStorageImpl
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.sequencing.storage._
import impl.RollupContributionEntityStorage
import org.orbroker.{RowExtractor, Row}

class RollupContributionStorageImpl extends GenericEntityStorageImpl[RollupContribution]("RollupContribution") with RollupContributionEntityStorage with RollupContributionExtractor

trait RollupContributionExtractor extends RowExtractor[RollupContribution] {
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
