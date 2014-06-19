package com.arcusys.learn.scorm.manifest.sequencing.storage.impl

import com.arcusys.learn.scorm.manifest.sequencing.storage.{ RuleConditionStorage, RollupRuleStorage }
import com.arcusys.learn.storage.impl.{ KeyedEntityStorageExt, EntityStorageExt }
import com.arcusys.learn.scorm.manifest.model._
import scala.Some

/**
 * User: Yulia.Glushonkova
 * Date: 08.04.13
 */
trait RollupRuleCreator {
  def ruleConditionStorage: RuleConditionStorage

  def createRollupRule(combination: String, id: Int, childActivitySet: String, minimumCount: Option[Int], minimumPercent: Option[String], action: String): RollupRule = {
    val combinationType = ConditionCombination.withName(combination)
    val conditionSet = new RuleConditionSet(ruleConditionStorage.getRollup(id), combinationType)
    val percent = minimumPercent.map(BigDecimal(_))
    new RollupRule(
      ChildActivitySet.parse(childActivitySet, minimumCount, percent), conditionSet, RollupAction.withName(action)
    )
  }
}

trait RollupRuleEntityStorage extends RollupRuleStorage with KeyedEntityStorageExt[RollupRule] with EntityStorageExt[RollupRule] {
  def ruleConditionStorage: RuleConditionStorage
  def create(sequencingID: Int, entity: RollupRule) {
    val (childActivitySet, minimumCount, minimumPercent) = entity.childActivitySet match {
      case ChildActivitySetAll                     => ("all", None, None)
      case ChildActivitySetAny                     => ("any", None, None)
      case ChildActivitySetNone                    => ("none", None, None)
      case ChildActivitySetAtLeastCount(count)     => ("atLeastCount", Some(count), None)
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
  def deleteBySequencing(sequencingID: Int) { delete("sequencingID" -> sequencingID) }
}
