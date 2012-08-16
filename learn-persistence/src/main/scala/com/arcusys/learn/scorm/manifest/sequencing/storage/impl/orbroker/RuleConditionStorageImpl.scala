package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.orbroker

import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.storage.impl.orbroker.GenericEntityStorageImpl
import com.arcusys.learn.scorm.manifest.sequencing.storage._
import org.orbroker.Row

class RuleConditionStorageImpl extends GenericEntityStorageImpl[RuleCondition]("RollupRuleCondition") with RuleConditionStorage {
  def createRollup(ruleID: Int, entity: RuleCondition) {
    create(entity, "rollupRuleID" -> ruleID)
  }

  def createCondition(ruleID: Int, entity: RuleCondition) {
    create(entity, "conditionRuleID" -> ruleID)
  }

  def getRollup(ruleID: Int): Seq[RuleCondition] = getAll("rollupRuleID" -> ruleID)
  def getCondition(ruleID: Int): Seq[RuleCondition] = getAll("conditionRuleID" -> ruleID)

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
