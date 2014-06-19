package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFRollupRuleLocalService
import com.arcusys.learn.persistence.liferay.model.LFRollupRule
import com.arcusys.learn.storage.impl.liferay.MockEntityContainer

import scala.collection.JavaConverters._

/**
 * User: Yulia.Glushonkova
 * Date: 08.04.13
 */

object RollupRuleEntityContainer extends MockEntityContainer[LFRollupRuleLocalService, LFRollupRule] {
  lazy val mockServiceBeanName = classOf[LFRollupRuleLocalService].getName
  lazy val mockLocalService = mock[LFRollupRuleLocalService]

  // service related mocks
  def createFunction = _.createLFRollupRule()
  def addFunction = _.addLFRollupRule(_)
  def deleteFunction = _.deleteLFRollupRule(_)
  def updateFunction = _.updateLFRollupRule(_)
  def orNull = _.orNull
  def getAllFunction = _.getLFRollupRules(_, _)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFRollupRule]
  def mockEntityProperties(mockEntity: LFRollupRule) {
    mockIntegerProperty(mockEntity.setSequencingID(_), _.getSequencingID)
    mockStringProperty(mockEntity.setCombination(_), _.getCombination)
    mockStringProperty(mockEntity.setChildActivitySet(_), _.getChildActivitySet)
    mockIntegerProperty(mockEntity.setMinimumCount(_), _.getMinimumCount)
    mockDecimalProperty(mockEntity.setMinimumPercent(_), _.getMinimumPercent)
    mockStringProperty(mockEntity.setAction(_), _.getAction)
  }
  def getIdFunction = _.getId

  mockLocalService.findBySequencingID(anyInt) answers { (param) =>
    filterBySequencingID(param).asJava
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
}
