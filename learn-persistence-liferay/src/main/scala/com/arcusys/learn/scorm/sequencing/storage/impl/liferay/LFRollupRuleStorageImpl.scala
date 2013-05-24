package com.arcusys.learn.scorm.sequencing.storage.impl.liferay

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.scorm.manifest.model.{ConditionCombination, RollupRule}
import com.arcusys.learn.persistence.liferay.service.LFRollupRuleLocalServiceUtil
import com.arcusys.learn.storage.impl.liferay.LiferayCommon
import com.arcusys.learn.persistence.liferay.model.LFRollupRule
import scala.collection.JavaConverters._

/**
 * User: Yulia.Glushonkova
 * Date: 08.04.13
 */
trait LFRollupRuleStorageImpl extends KeyedEntityStorage[RollupRule] {
  protected def doRenew() { LFRollupRuleLocalServiceUtil.removeAll()}

  def getOne(parameters: (String, Any)*) = throw new UnsupportedOperationException("Not implemented")

  def getAll(parameters: (String, Any)*) = {
    val sequencingID = LiferayCommon.getParameter("sequencingID", parameters: _*)
    LFRollupRuleLocalServiceUtil.findBySequencingID(sequencingID.get).asScala.map { extract }
  }
  private def extract(lfentity: LFRollupRule): RollupRule = {
    val percent = if (lfentity.getMinimumPercent == null) None
                  else Some(lfentity.getMinimumPercent.toString)
    val min = if (lfentity.getMinimumCount == null) null
              else Some(lfentity.getMinimumCount.toInt)
    createRollupRule(lfentity.getCombination, lfentity.getId.toInt, lfentity.getChildActivitySet, min, percent, lfentity.getAction)
  }
  def createRollupRule(combination: String, id: Int, childActivitySet: String, minimumCount: Option[Int], minimumPercent: Option[String], action:String): RollupRule


  def create(parameters: (String, Any)*) {throw new UnsupportedOperationException("Not implemented")}
  def create(entity: RollupRule, parameters: (String, Any)*) {throw new UnsupportedOperationException("Not implemented")}

  def delete(parameters: (String, Any)*) {
    LFRollupRuleLocalServiceUtil.removeBySequencingID(LiferayCommon.getParameter("sequencingID", parameters: _*).get)
  }

  def modify(parameters: (String, Any)*) {throw new UnsupportedOperationException("Not implemented")}
  def modify(entity: RollupRule, parameters: (String, Any)*) {throw new UnsupportedOperationException("Not implemented")}
  def getByID(id: Int, parameters: (String, Any)*) = throw new UnsupportedOperationException("Not implemented")

  def createAndGetID(entity: RollupRule, parameters: (String, Any)*) = {
    val newEntity = LFRollupRuleLocalServiceUtil.createLFRollupRule()
    newEntity.setSequencingID(LiferayCommon.getParameter("sequencingID", parameters: _*).get)

    val combination = parameters find { _._1 == "combination" } map(_._2.toString)
    if (combination!= null) newEntity.setCombination(ConditionCombination.withName(combination.get).toString)

    newEntity.setChildActivitySet(LiferayCommon.getParameter("childActivitySet", parameters: _*).get)
    newEntity.setMinimumCount(LiferayCommon.getNullableParameter("minimumCount", parameters: _*))
    newEntity.setMinimumPercent(LiferayCommon.getNullableParameter("minimumPercent", parameters: _*))

    newEntity.setAction(entity.action.toString)

    LFRollupRuleLocalServiceUtil.addLFRollupRule(newEntity).getId.toInt

  }
  def createAndGetID(parameters: (String, Any)*) = throw new UnsupportedOperationException("Not implemented")

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }
}
