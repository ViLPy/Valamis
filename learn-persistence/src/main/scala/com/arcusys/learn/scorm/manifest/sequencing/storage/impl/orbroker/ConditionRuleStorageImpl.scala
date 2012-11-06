package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.orbroker

import com.arcusys.learn.scorm.manifest.sequencing.storage.ConditionRuleStorage
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.storage.impl.orbroker.KeyedEntityStorageImpl
import org.orbroker.Row

class ExitConditionRuleStorageImpl extends KeyedEntityStorageImpl[ExitConditionRule]("ConditionRule","id") with ConditionRuleStorage[ExitConditionRule] {
  private val ruleConditionStorage = new RuleConditionStorageImpl

  override def create(sequencingID: Int, entity: ExitConditionRule) {
    val id = createAndGetID(entity, "sequencingID" -> sequencingID, "combination" -> entity.conditions.combination, "ruleType"->"exit")
    entity.conditions.conditions.foreach(ruleConditionStorage.createCondition(id, _))
  }

  def getRules(sequencingID: Int) = getAll("sequencingID"->sequencingID, "ruleType"->"exit")

  def extract(row: Row) = {
    val combination = ConditionCombination.withName(row.string("combination").get)
    val conditionSet = new RuleConditionSet(ruleConditionStorage.getCondition(row.integer("id").get), combination)

    new ExitConditionRule(conditionSet)
  }
}

class PreConditionRuleStorageImpl extends KeyedEntityStorageImpl[PreConditionRule]("ConditionRule","id") with ConditionRuleStorage[PreConditionRule] {
  private val ruleConditionStorage = new RuleConditionStorageImpl

  override def create(sequencingID: Int, entity: PreConditionRule) {
    val id = createAndGetID(entity, "sequencingID" -> sequencingID, "combination" -> entity.conditions.combination, "ruleType"->"pre")
    entity.conditions.conditions.foreach(ruleConditionStorage.createCondition(id, _))
  }

  def getRules(sequencingID: Int) = getAll("sequencingID"->sequencingID, "ruleType"->"pre")

  def extract(row: Row) = {
    val combination = ConditionCombination.withName(row.string("combination").get)
    val conditionSet = new RuleConditionSet(ruleConditionStorage.getCondition(row.integer("id").get), combination)

    new PreConditionRule(conditionSet, PreConditionAction.withName(row.string("action").get))
  }
}

class PostConditionRuleStorageImpl extends KeyedEntityStorageImpl[PostConditionRule]("ConditionRule","id") with ConditionRuleStorage[PostConditionRule] {
  private val ruleConditionStorage = new RuleConditionStorageImpl

  override def create(sequencingID: Int, entity: PostConditionRule) {
    val id = createAndGetID(entity, "sequencingID" -> sequencingID, "combination" -> entity.conditions.combination, "ruleType"->"post")
    entity.conditions.conditions.foreach(ruleConditionStorage.createCondition(id, _))
  }

  def getRules(sequencingID: Int) = getAll("sequencingID"->sequencingID, "ruleType"->"post")

  def extract(row: Row) = {
    val combination = ConditionCombination.withName(row.string("combination").get)
    val conditionSet = new RuleConditionSet(ruleConditionStorage.getCondition(row.integer("id").get), combination)

    new PostConditionRule(conditionSet, PostConditionAction.withName(row.string("action").get))
  }
}
