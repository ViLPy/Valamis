package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFConditionRuleLocalService
import com.arcusys.learn.persistence.liferay.model.LFConditionRule
import com.arcusys.learn.storage.impl.liferay.MockEntityContainer

import scala.collection.JavaConverters._

/**
 * User: Yulia.Glushonkova
 * Date: 03.04.13
 */

object ConditionRuleEntityContainer extends MockEntityContainer[LFConditionRuleLocalService, LFConditionRule] {
  lazy val mockServiceBeanName = classOf[LFConditionRuleLocalService].getName
  lazy val mockLocalService = mock[LFConditionRuleLocalService]

  // service related mocks
  def createFunction = _.createLFConditionRule()
  def addFunction = _.addLFConditionRule(_)
  def deleteFunction = _.deleteLFConditionRule(_)
  def updateFunction = _.updateLFConditionRule(_)
  def orNull = _.orNull
  def getAllFunction = _.getLFConditionRules(_, _)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFConditionRule]
  def mockEntityProperties(mockEntity: LFConditionRule) {
    mockIntegerProperty(mockEntity.setSequencingID(_), _.getSequencingID)
    mockStringProperty(mockEntity.setCombination(_), _.getCombination)
    mockStringProperty(mockEntity.setRuleType(_), _.getRuleType)
    mockStringProperty(mockEntity.setAction(_), _.getAction)
  }
  def getIdFunction = _.getId

  mockLocalService.findBySequencingIDAndRuleType(anyInt, anyString) answers { (param, data) =>
    filterBySequencingIDAndRuleType(param, data).asJava
  }
  mockLocalService.removeBySequencingID(anyInt) answers { id =>
    internalStorage --= filterBySequencingID(id).map(_.getId)
    ()
  }
  private def filterBySequencingID(idRaw: Any) = {
    internalStorage.values.filter(obj => obj.getSequencingID == unwrapId(idRaw)).toSeq
  }
  private def unwrapId(idRaw: Any) = idRaw match {
    case x: Int                  => x
    case Array(x: Int, Int, Int) => x
  }

  private def filterBySequencingIDAndRuleType(param: Any, data: Any): Seq[LFConditionRule] = {
    val paramsTuple: (Any, Any) = param match {
      case Array(a, b) => (a, b)
    }
    val sequencingID = paramsTuple._1.asInstanceOf[Int]
    val ruleType = paramsTuple._2.asInstanceOf[String]
    internalStorage.values.filter(obj => obj.getSequencingID == sequencingID && obj.getRuleType == ruleType).toSeq
  }
}
