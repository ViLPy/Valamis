package com.arcusys.valamis.lesson.scorm.storage.sequencing

import com.arcusys.valamis.lesson.scorm.model.manifest.RuleCondition

trait RuleConditionStorage {
  def createRollup(ruleID: Int, entity: RuleCondition)
  def createCondition(ruleID: Int, entity: RuleCondition)

  def getRollup(ruleID: Int): Seq[RuleCondition]
  def getCondition(ruleID: Int): Seq[RuleCondition]

  def deleteByRollup(ruleID: Int)
  def deleteByCondition(ruleID: Int)
  def renew()
}
