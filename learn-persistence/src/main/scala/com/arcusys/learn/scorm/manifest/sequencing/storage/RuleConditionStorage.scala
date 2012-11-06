package com.arcusys.learn.scorm.manifest.sequencing.storage

import com.arcusys.learn.scorm.manifest.model.RuleCondition

trait RuleConditionStorage {
  def createRollup(ruleID: Int, entity: RuleCondition)
  def createCondition(ruleID: Int, entity: RuleCondition)

  def getRollup(ruleID: Int):Seq[RuleCondition]
  def getCondition(ruleID: Int):Seq[RuleCondition]
}
