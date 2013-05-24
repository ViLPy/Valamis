package com.arcusys.learn.scorm.manifest.sequencing.storage.impl

import com.arcusys.learn.scorm.manifest.model.RuleCondition
import com.arcusys.learn.storage.impl.EntityStorageExt
import com.arcusys.learn.scorm.manifest.sequencing.storage.RuleConditionStorage

/**
 * User: Yulia.Glushonkova
 * Date: 29.03.13
 */
trait RuleConditionEntityStorage extends RuleConditionStorage with EntityStorageExt[RuleCondition] {
   def createRollup(ruleID: Int, entity: RuleCondition) {
      create(entity, "rollupRuleID" -> ruleID)
    }

    def createCondition(ruleID: Int, entity: RuleCondition) {
      create(entity, "conditionRuleID" -> ruleID)
    }

    def getRollup(ruleID: Int): Seq[RuleCondition] = getAll("rollupRuleID" -> ruleID)
    def getCondition(ruleID: Int): Seq[RuleCondition] = getAll("conditionRuleID" -> ruleID)

    def deleteByRollup(ruleID: Int) { delete("rollupRuleID" -> ruleID) }
    def deleteByCondition(ruleID: Int) { delete("conditionRuleID" -> ruleID) }
}
