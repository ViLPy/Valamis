package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.orbroker

import com.arcusys.learn.scorm.manifest.sequencing.storage.RuleConditionStorage
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.storage.impl.orbroker.KeyedEntityStorageBaseImpl
import org.orbroker.{RowExtractor, Row}
import com.arcusys.learn.scorm.manifest.sequencing.storage.impl._

class ExitConditionRuleStorageImpl extends KeyedEntityStorageBaseImpl[ExitConditionRule]("ConditionRule", "id") with ExitConditionRuleEntityStorage with ExitConditionRuleExtractor with ExitConditionRuleCreator {
  val ruleConditionStorage: RuleConditionStorage = new RuleConditionStorageImpl
}

trait ExitConditionRuleExtractor extends RowExtractor[ExitConditionRule] {
  def ruleConditionStorage: RuleConditionStorage
  def extract(row: Row) = {
    val combination = row.string("combination").get
    val ruleID = row.integer("id").get
    createConditionRule(combination, ruleID)
  }
  def createConditionRule(combination: String, ruleID: Int): ExitConditionRule
}

class PreConditionRuleStorageImpl extends KeyedEntityStorageBaseImpl[PreConditionRule]("ConditionRule", "id") with PreConditionRuleEntityStorage with PreConditionRuleExtractor with PreConditionRuleCreator {
  val ruleConditionStorage: RuleConditionStorage = new RuleConditionStorageImpl
}

trait PreConditionRuleExtractor extends RowExtractor[PreConditionRule] {
  def ruleConditionStorage: RuleConditionStorage
  def extract(row: Row) = {
    val combination = row.string("combination").get
    val ruleID = row.integer("id").get
    val action = row.string("action").get
    createConditionRule(combination, ruleID, action)
  }
  def createConditionRule(combination: String, ruleID: Int, action: String): PreConditionRule
}
class PostConditionRuleStorageImpl extends KeyedEntityStorageBaseImpl[PostConditionRule]("ConditionRule", "id") with PostConditionRuleEntityStorage with PostConditionRuleExtractor with PostConditionRuleCreator{
  val ruleConditionStorage: RuleConditionStorage = new RuleConditionStorageImpl
}

 trait PostConditionRuleExtractor extends RowExtractor[PostConditionRule] {
  def ruleConditionStorage: RuleConditionStorage
  def extract(row: Row) = {
    val combination = row.string("combination").get
    val ruleID = row.integer("id").get
    val action = row.string("action").get
    createConditionRule(combination, ruleID, action)
  }
   def createConditionRule(combination: String, ruleID: Int, action: String): PostConditionRule
}
