package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFRollupContribution
import com.arcusys.learn.persistence.liferay.service.LFRollupContributionLocalService
import com.arcusys.learn.storage.impl.liferay.MockEntityContainer

/**
 * User: Yulia.Glushonkova
 * Date: 02.04.13
 */

object RollupContributionEntityContainer  extends MockEntityContainer[LFRollupContributionLocalService, LFRollupContribution] {
  lazy val mockServiceBeanName = classOf[LFRollupContributionLocalService].getName
  lazy val mockLocalService = mock[LFRollupContributionLocalService]

  // service related mocks
  def createFunction = _.createLFRollupContribution()
  def addFunction = _.addLFRollupContribution(_)
  def deleteFunction = _.deleteLFRollupContribution(_)
  def updateFunction = _.updateLFRollupContribution(_)
  def orNull = _.orNull
  def getAllFunction = _.getLFRollupContributions(_,_)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFRollupContribution]
  def mockEntityProperties(mockEntity: LFRollupContribution) {
    mockIntegerProperty(mockEntity.setSequencingID(_), _.getSequencingID)
    mockStringProperty(mockEntity.setContributeToSatisfied(_), _.getContributeToSatisfied)
    mockStringProperty(mockEntity.setContributeToNotSatisfied(_), _.getContributeToNotSatisfied)
    mockStringProperty(mockEntity.setContributeToCompleted(_), _.getContributeToCompleted)
    mockStringProperty(mockEntity.setContributeToIncomplete(_), _.getContributeToIncomplete)
    mockDecimalProperty(mockEntity.setObjectiveMeasureWeight(_), _.getObjectiveMeasureWeight)
    mockBooleanProperty(mockEntity.setMeasureSatisfactionIfActive(_), _.getMeasureSatisfactionIfActive)
  }
  def getIdFunction = _.getId

  mockLocalService.findBySequencingID(anyInt) answers { id =>
    val entity = internalStorage.values.filter(obj => obj.getSequencingID == id).headOption
    if (entity.isEmpty) null
    else entity.get
  }
  mockLocalService.removeBySequencingID(anyInt) answers { id =>
    internalStorage --= filterBySequencingID(id).map(_.getId)
    ()
  }
  private def filterBySequencingID(idRaw: Any): Seq[LFRollupContribution] ={
    internalStorage.values.filter(obj => obj.getSequencingID == unwrapId(idRaw)).toSeq
  }
  private def unwrapId(idRaw: Any) = idRaw match {
    case x: Int => x
    case Array(x: Int, Int, Int) => x
  }
}
