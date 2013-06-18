package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.orbroker

import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.storage.impl.orbroker.GenericEntityStorageImpl
import org.orbroker.{RowExtractor, Row}
import com.arcusys.learn.scorm.manifest.sequencing.storage.impl.RuleConditionEntityStorage

class RuleConditionStorageImpl extends GenericEntityStorageImpl[RuleCondition]("RollupRuleCondition") with RuleConditionEntityStorage with RuleConditionExtractor

 trait RuleConditionExtractor extends RowExtractor[RuleCondition] {
  def extract(row: Row) = {
    new RuleCondition(
      ConditionType.withName(row.string("conditionType").get),
      row.string("objectiveId"),
      row.decimal("measureThreshold") match {
        case Some(d) => Some(d)
        case _ => None
      },
      row.bit("inverseCondition").get)
  }
}
