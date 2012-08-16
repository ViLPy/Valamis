package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.KeyedEntityStorageImpl
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.sequencing.storage._
import org.orbroker.Row

class RollupRuleStorageImpl extends KeyedEntityStorageImpl[RollupRule]("RollupRule", "id") with RollupRuleStorage {
  private val ruleConditionStorage = new RuleConditionStorageImpl

  def create(sequencingID: Int, entity: RollupRule) {
    val (childActivitySet, minimumCount, minimumPercent) = entity.childActivitySet match {
      case ChildActivitySetAll => ("all", None, None)
      case ChildActivitySetAny => ("any", None, None)
      case ChildActivitySetNone => ("none", None, None)
      case ChildActivitySetAtLeastCount(count) => ("atLeastCount", Some(count), None)
      case ChildActivitySetAtLeastPercent(percent) => ("atLeastPercent", None, Some(percent.bigDecimal))
    }
    val ruleID = createAndGetID(entity,
      "sequencingID" -> sequencingID,
      "childActivitySet" -> childActivitySet,
      "minimumCount" -> minimumCount,
      "minimumPercent" -> minimumPercent,
      "combination" -> entity.conditions.combination
    )
    entity.conditions.conditions.foreach(ruleConditionStorage.createRollup(ruleID, _))
  }

  def get(sequencingID: Int): Seq[RollupRule] = getAll("sequencingID" -> sequencingID)

  def extract(row: Row) = {
    val combination = ConditionCombination.withName(row.string("combination").get)
    val conditionSet = new RuleConditionSet(ruleConditionStorage.getRollup(row.integer("id").get), combination)

    new RollupRule(
      ChildActivitySet.parse(row.string("childActivitySet").get, row.integer("minimumCount"), row.string("minimumPercent").map(BigDecimal(_))),
      conditionSet,
      RollupAction.withName(row.string("action").get)
    )
  }
}
