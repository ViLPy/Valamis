package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFRuleConditionLocalService
import com.arcusys.learn.persistence.liferay.model.LFRuleCondition
import com.arcusys.learn.storage.impl.liferay.MockEntityContainer

import scala.collection.JavaConverters._

/**
 * User: Yulia.Glushonkova
 * Date: 29.03.13
 */

object RuleConditionEntityContainer extends MockEntityContainer[LFRuleConditionLocalService, LFRuleCondition] {
  lazy val mockServiceBeanName = classOf[LFRuleConditionLocalService].getName
  lazy val mockLocalService = mock[LFRuleConditionLocalService]

  // service related mocks
  def createFunction = _.createLFRuleCondition()
  def addFunction = _.addLFRuleCondition(_)
  def deleteFunction = _.deleteLFRuleCondition(_)
  def updateFunction = _.updateLFRuleCondition(_)
  def orNull = _.orNull
  def getAllFunction = _.getLFRuleConditions(_, _)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFRuleCondition]

  def mockEntityProperties(mockEntity: LFRuleCondition) {
    mockStringProperty(mockEntity.setConditionType(_), _.getConditionType)
    mockStringProperty(mockEntity.setObjectiveId(_), _.getObjectiveId)
    mockDecimalProperty(mockEntity.setMeasureThreshold(_), _.getMeasureThreshold)
    mockBooleanProperty(mockEntity.setInverse(_), _.getInverse)
    mockIntegerProperty(mockEntity.setRollupRuleID(_), _.getRollupRuleID)
    mockIntegerProperty(mockEntity.setConditionRuleID(_), _.getConditionRuleID)
  }

  def getIdFunction = _.getId

  mockLocalService.findByRollup(anyInt) answers { id =>
    filterByRollup(id).asJava
  }
  mockLocalService.findByCondition(anyInt) answers { id =>
    filterByConditionRule(id).asJava
  }
  mockLocalService.removeByRollup(anyInt) answers { id =>
    internalStorage --= filterByRollup(id).map(_.getId)
    ()
  }
  mockLocalService.removeByCondition(anyInt) answers { id =>
    internalStorage --= filterByConditionRule(id).map(_.getId)
    ()
  }

  private def filterByRollup(idRaw: Any): Seq[LFRuleCondition] = {
    internalStorage.values.filter(obj => obj.getRollupRuleID == unwrapId(idRaw)).toSeq
  }
  private def filterByConditionRule(idRaw: Any): Seq[LFRuleCondition] = {
    internalStorage.values.filter(obj => obj.getConditionRuleID == unwrapId(idRaw)).toSeq
  }
  private def unwrapId(idRaw: Any) = idRaw match {
    case x: Int                  => x
    case Array(x: Int, Int, Int) => x
  }
}
