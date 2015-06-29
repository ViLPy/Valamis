package com.arcusys.learn.scorm.manifest.sequencing.storage.impl

import com.arcusys.learn.storage.impl.{ KeyedEntityStorageExt, EntityStorageExt }
import com.arcusys.valamis.lesson.scorm.model.manifest._
import com.arcusys.valamis.lesson.scorm.storage.sequencing.{ RuleConditionStorage, ConditionRuleStorage }

/**
 * User: Yulia.Glushonkova
 * Date: 03.04.13
 */

trait ExitConditionRuleCreator {
  def ruleConditionStorage: RuleConditionStorage

  def createConditionRule(combination: String, ruleID: Int): ExitConditionRule = {
    val combinationType = ConditionCombination.withName(combination)
    val conditionSet = new RuleConditionSet(ruleConditionStorage.getCondition(ruleID), combinationType)
    new ExitConditionRule(conditionSet)
  }
}

trait ExitConditionRuleEntityStorage extends ConditionRuleStorage[ExitConditionRule] with KeyedEntityStorageExt[ExitConditionRule] with EntityStorageExt[ExitConditionRule] {

  def ruleConditionStorage: RuleConditionStorage

  def create(sequencingID: Int, entity: ExitConditionRule) {
    val id = createAndGetID(entity, "sequencingID" -> sequencingID, "combination" -> entity.conditions.combination, "ruleType" -> "exit")
    entity.conditions.conditions.foreach(ruleConditionStorage.createCondition(id, _))
  }

  def getRules(sequencingID: Int) = getAll("sequencingID" -> sequencingID, "ruleType" -> "exit")

}

trait PreConditionRuleCreator {
  def ruleConditionStorage: RuleConditionStorage

  def createConditionRule(combination: String, ruleID: Int, action: String): PreConditionRule = {
    val combinationType = ConditionCombination.withName(combination)
    val conditionSet = new RuleConditionSet(ruleConditionStorage.getCondition(ruleID), combinationType)
    new PreConditionRule(conditionSet, PreConditionAction.withName(action))
  }
}

trait PreConditionRuleEntityStorage extends ConditionRuleStorage[PreConditionRule] with KeyedEntityStorageExt[PreConditionRule] with EntityStorageExt[PreConditionRule] {

  def ruleConditionStorage: RuleConditionStorage

  def create(sequencingID: Int, entity: PreConditionRule) {
    val id = createAndGetID(entity, "sequencingID" -> sequencingID, "combination" -> entity.conditions.combination, "ruleType" -> "pre")
    entity.conditions.conditions.foreach(ruleConditionStorage.createCondition(id, _))
  }

  def getRules(sequencingID: Int) = getAll("sequencingID" -> sequencingID, "ruleType" -> "pre")

}

trait PostConditionRuleCreator {
  def ruleConditionStorage: RuleConditionStorage

  def createConditionRule(combination: String, ruleID: Int, action: String): PostConditionRule = {
    val combinationType = ConditionCombination.withName(combination)
    val conditionSet = new RuleConditionSet(ruleConditionStorage.getCondition(ruleID), combinationType)
    new PostConditionRule(conditionSet, PostConditionAction.withName(action))
  }
}

trait PostConditionRuleEntityStorage extends ConditionRuleStorage[PostConditionRule] with KeyedEntityStorageExt[PostConditionRule] with EntityStorageExt[PostConditionRule] {

  def ruleConditionStorage: RuleConditionStorage

  def create(sequencingID: Int, entity: PostConditionRule) {
    val id = createAndGetID(entity, "sequencingID" -> sequencingID, "combination" -> entity.conditions.combination, "ruleType" -> "post")
    entity.conditions.conditions.foreach(ruleConditionStorage.createCondition(id, _))
  }

  def getRules(sequencingID: Int) = getAll("sequencingID" -> sequencingID, "ruleType" -> "post")
}

