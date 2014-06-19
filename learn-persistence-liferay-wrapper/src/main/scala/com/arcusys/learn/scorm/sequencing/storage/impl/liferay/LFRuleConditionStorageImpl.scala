package com.arcusys.learn.scorm.sequencing.storage.impl.liferay

import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.scorm.manifest.model.{ ConditionType, RuleCondition }
import com.arcusys.learn.persistence.liferay.service.LFRuleConditionLocalServiceUtil
import scala.collection.JavaConverters._
import com.arcusys.learn.persistence.liferay.model.LFRuleCondition
import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

/**
 * User: Yulia.Glushonkova
 * Date: 29.03.13
 */
trait LFRuleConditionStorageImpl extends EntityStorage[RuleCondition] {
  protected def doRenew() { LFRuleConditionLocalServiceUtil.removeAll() }

  def getOne(parameters: (String, Any)*) = throw new UnsupportedOperationException("Not implemented")
  def getAll(parameters: (String, Any)*) = {
    parameters match {
      case Seq(("rollupRuleID", value: Int)) => {
        LFRuleConditionLocalServiceUtil.findByRollup(value).asScala.map { extract }
      }
      case Seq(("conditionRuleID", value: Int)) => {
        LFRuleConditionLocalServiceUtil.findByCondition(value).asScala.map { extract }
      }
    }
  }
  def extract(lfentity: LFRuleCondition) = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

    val threshold = if (lfentity.getMeasureThreshold == null) None
    else Option(BigDecimal(lfentity.getMeasureThreshold))

    val objectiveId = lfentity.getObjectiveId.toOption
    new RuleCondition(ConditionType.withName(lfentity.getConditionType), objectiveId, threshold, lfentity.getInverse)
  }

  def create(parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }

  def create(entity: RuleCondition, parameters: (String, Any)*) {
    val newEntity = LFRuleConditionLocalServiceUtil.createLFRuleCondition()

    newEntity.setConditionType(entity.conditionType.toString)
    newEntity.setObjectiveId(entity.objectiveId.getOrElse(""))

    newEntity.setMeasureThreshold(if (entity.measureThreshold.isEmpty) null
    else entity.measureThreshold.getOrElse(null))

    newEntity.setInverse(entity.inverse)
    if (!parameters.isEmpty)
      parameters match {
        case Seq(("rollupRuleID", value: Int))    => newEntity.setRollupRuleID(value)
        case Seq(("conditionRuleID", value: Int)) => newEntity.setConditionRuleID(value)
      }
    LFRuleConditionLocalServiceUtil.addLFRuleCondition(newEntity)
  }
  def delete(parameters: (String, Any)*) {
    parameters match {
      case Seq(("rollupRuleID", value: Int))    => { LFRuleConditionLocalServiceUtil.removeByRollup(value) }
      case Seq(("conditionRuleID", value: Int)) => { LFRuleConditionLocalServiceUtil.removeByCondition(value) }
    }
  }
  def modify(parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }
  def modify(entity: RuleCondition, parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }
}
