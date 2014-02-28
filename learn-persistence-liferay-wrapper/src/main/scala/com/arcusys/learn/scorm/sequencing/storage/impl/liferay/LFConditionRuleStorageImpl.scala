package com.arcusys.learn.scorm.sequencing.storage.impl.liferay

import com.arcusys.learn.storage.impl.{KeyedEntityStorage, EntityStorage}
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.persistence.liferay.service.LFConditionRuleLocalServiceUtil
import com.arcusys.learn.storage.impl.liferay.LiferayCommon
import com.arcusys.learn.persistence.liferay.model.LFConditionRule
import scala.collection.JavaConverters._

/**
 * User: Yulia.Glushonkova
 * Date: 03.04.13
 */
trait LFExitConditionRuleStorageImpl extends KeyedEntityStorage[ExitConditionRule] {
  protected def doRenew() { LFConditionRuleLocalServiceUtil.removeAll()}

  def getOne(parameters: (String, Any)*) = throw new UnsupportedOperationException("Not implemented")
  def getAll(parameters: (String, Any)*) = {
    val sequencingID = LiferayCommon.getParameter("sequencingID", parameters: _*)
    val ruleType = LiferayCommon.getParameter("ruleType", parameters: _*)
    LFConditionRuleLocalServiceUtil.findBySequencingIDAndRuleType(sequencingID.get, ruleType.get).asScala.map { extract }
  }
  private def extract(lfentity: LFConditionRule): ExitConditionRule = {
   createConditionRule(lfentity.getCombination, lfentity.getId.toInt)
  }
  def createConditionRule(combination: String, ruleID: Int): ExitConditionRule

  def delete(parameters: (String, Any)*) {throw new UnsupportedOperationException("Not implemented")}
  def modify(parameters: (String, Any)*) {throw new UnsupportedOperationException("Not implemented")}
  def modify(entity: ExitConditionRule, parameters: (String, Any)*) {throw new UnsupportedOperationException("Not implemented")}
  def getByID(id: Int, parameters: (String, Any)*) = throw new UnsupportedOperationException("Not implemented")
  def createAndGetID(entity: ExitConditionRule, parameters: (String, Any)*) = {
    val newEntity = LFConditionRuleLocalServiceUtil.createLFConditionRule()
    newEntity.setSequencingID(LiferayCommon.getParameter("sequencingID", parameters: _*).get)
    val combination = parameters find { _._1 == "combination" } map(_._2.toString)
    if (combination!= null) newEntity.setCombination(ConditionCombination.withName(combination.get).toString)
    newEntity.setRuleType(LiferayCommon.getParameter("ruleType", parameters: _*).get)
    LFConditionRuleLocalServiceUtil.addLFConditionRule(newEntity).getId.toInt
  }
  def createAndGetID(parameters: (String, Any)*) = throw new UnsupportedOperationException("Not implemented")
  def create(parameters: (String, Any)*) {throw new UnsupportedOperationException("Not implemented")}
  def create(entity: ExitConditionRule, parameters: (String, Any)*) {throw new UnsupportedOperationException("Not implemented")}

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }
}

trait LFPreConditionRuleStorageImpl extends KeyedEntityStorage[PreConditionRule] {
  protected def doRenew() { LFConditionRuleLocalServiceUtil.removeAll()}

  def getOne(parameters: (String, Any)*) = throw new UnsupportedOperationException("Not implemented")
  def getAll(parameters: (String, Any)*) = {
    val sequencingID = LiferayCommon.getParameter("sequencingID", parameters: _*)
    val ruleType = LiferayCommon.getParameter("ruleType", parameters: _*)
    LFConditionRuleLocalServiceUtil.findBySequencingIDAndRuleType(sequencingID.get, ruleType.get).asScala.map { extract }
  }
  private def extract(lfentity: LFConditionRule): PreConditionRule = {
    createConditionRule(lfentity.getCombination, lfentity.getId.toInt, lfentity.getAction)
  }
  def createConditionRule(combination: String, ruleID: Int, action: String): PreConditionRule

  def create(parameters: (String, Any)*) {throw new UnsupportedOperationException("Not implemented")}
  def create(entity: PreConditionRule, parameters: (String, Any)*) {throw new UnsupportedOperationException("Not implemented")}
  def delete(parameters: (String, Any)*) {throw new UnsupportedOperationException("Not implemented")}
  def modify(parameters: (String, Any)*) {throw new UnsupportedOperationException("Not implemented")}
  def modify(entity: PreConditionRule, parameters: (String, Any)*) {throw new UnsupportedOperationException("Not implemented")}

  def createAndGetID(entity: PreConditionRule, parameters: (String, Any)*) = {
    val newEntity = LFConditionRuleLocalServiceUtil.createLFConditionRule()
    newEntity.setSequencingID(LiferayCommon.getParameter("sequencingID", parameters: _*).get)
    val combination = parameters find { _._1 == "combination" } map(_._2.toString)
    if (combination!= null) newEntity.setCombination(ConditionCombination.withName(combination.get).toString)
    newEntity.setRuleType(LiferayCommon.getParameter("ruleType", parameters: _*).get)
    newEntity.setAction(entity.action.toString)
    LFConditionRuleLocalServiceUtil.addLFConditionRule(newEntity).getId.toInt
  }

  def createAndGetID(parameters: (String, Any)*) = throw new UnsupportedOperationException("Not implemented")
  def getByID(id: Int, parameters: (String, Any)*) = throw new UnsupportedOperationException("Not implemented")

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }
}

trait LFPostConditionRuleStorageImpl extends KeyedEntityStorage[PostConditionRule] {
  protected def doRenew() { LFConditionRuleLocalServiceUtil.removeAll()}

  def getOne(parameters: (String, Any)*) = throw new UnsupportedOperationException("Not implemented")
  def getAll(parameters: (String, Any)*) ={
    val sequencingID = LiferayCommon.getParameter("sequencingID", parameters: _*)
    val ruleType = LiferayCommon.getParameter("ruleType", parameters: _*)
    LFConditionRuleLocalServiceUtil.findBySequencingIDAndRuleType(sequencingID.get, ruleType.get).asScala.map { extract }
  }
  private def extract(lfentity: LFConditionRule): PostConditionRule = {
    createConditionRule(lfentity.getCombination, lfentity.getId.toInt, lfentity.getAction)
  }

  def create(parameters: (String, Any)*) {throw new UnsupportedOperationException("Not implemented")}
  def create(entity: ExitConditionRule, parameters: (String, Any)*) {throw new UnsupportedOperationException("Not implemented")}
  def delete(parameters: (String, Any)*) {throw new UnsupportedOperationException("Not implemented")}
  def modify(parameters: (String, Any)*) {throw new UnsupportedOperationException("Not implemented")}
  def modify(entity: ExitConditionRule, parameters: (String, Any)*) {throw new UnsupportedOperationException("Not implemented")}
  def createConditionRule(combination: String, ruleID: Int, action: String): PostConditionRule
  def create(entity: PostConditionRule, parameters: (String, Any)*) {throw new UnsupportedOperationException("Not implemented")}
  def modify(entity: PostConditionRule, parameters: (String, Any)*) {throw new UnsupportedOperationException("Not implemented")}
  def getByID(id: Int, parameters: (String, Any)*) = throw new UnsupportedOperationException("Not implemented")

  def createAndGetID(entity: PostConditionRule, parameters: (String, Any)*) = {
    val newEntity = LFConditionRuleLocalServiceUtil.createLFConditionRule()
    newEntity.setSequencingID(LiferayCommon.getParameter("sequencingID", parameters: _*).get)
    val combination = parameters find { _._1 == "combination" } map(_._2.toString)
    if (combination!= null) newEntity.setCombination(ConditionCombination.withName(combination.get).toString)
    newEntity.setRuleType(LiferayCommon.getParameter("ruleType", parameters: _*).get)
    newEntity.setAction(entity.action.toString)
    LFConditionRuleLocalServiceUtil.addLFConditionRule(newEntity).getId.toInt
  }

  def createAndGetID(parameters: (String, Any)*) = 0

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }
}
