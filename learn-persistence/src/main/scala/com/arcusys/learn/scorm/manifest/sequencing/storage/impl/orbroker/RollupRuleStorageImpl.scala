package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.KeyedEntityStorageBaseImpl
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.sequencing.storage._
import impl.{RollupRuleCreator, RollupRuleEntityStorage}
import org.orbroker.{RowExtractor, Row}

class RollupRuleStorageImpl extends KeyedEntityStorageBaseImpl[RollupRule]("RollupRule", "id") with RollupRuleEntityStorage with RollupRuleExtractor with RollupRuleCreator {
  val ruleConditionStorage = new RuleConditionStorageImpl
}

trait RollupRuleExtractor extends RowExtractor[RollupRule] {
  def ruleConditionStorage: RuleConditionStorage
  def extract(row: Row) = {
    createRollupRule(row.string("combination").get, row.integer("id").get, row.string("childActivitySet").get,
      row.integer("minimumCount"), row.string("minimumPercent"), row.string("action").get)
  }
  def createRollupRule(combination: String, id: Int, childActivitySet: String, minimumCount: Option[Int], minimumPercent: Option[String], action:String): RollupRule
}
