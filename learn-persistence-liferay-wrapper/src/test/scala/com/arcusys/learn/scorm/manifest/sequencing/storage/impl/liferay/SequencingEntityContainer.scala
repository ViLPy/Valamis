package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFSequencingLocalService
import com.arcusys.learn.persistence.liferay.model.LFSequencing
import com.arcusys.learn.storage.impl.liferay.MockEntityContainer

/**
 * User: Yulia.Glushonkova
 * Date: 09.04.13
 */

object SequencingEntityContainer extends MockEntityContainer[LFSequencingLocalService, LFSequencing] {
  lazy val mockServiceBeanName = classOf[LFSequencingLocalService].getName
  lazy val mockLocalService = mock[LFSequencingLocalService]

  // service related mocks
  def createFunction = _.createLFSequencing()
  def addFunction = _.addLFSequencing(_)
  def deleteFunction = _.deleteLFSequencing(_)
  def updateFunction = _.updateLFSequencing(_)
  def orNull = _.orNull
  def getAllFunction = _.getLFSequencings(_, _)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFSequencing]
  def mockEntityProperties(mockEntity: LFSequencing) {
    mockIntegerProperty(mockEntity.setPackageID(_), _.getPackageID)
    mockStringProperty(mockEntity.setActivityID(_), _.getActivityID)
    mockStringProperty(mockEntity.setSharedId(_), _.getSharedId)
    mockStringProperty(mockEntity.setSharedSequencingIdReference(_), _.getSharedSequencingIdReference)
    mockBooleanProperty(mockEntity.setCAttemptAttemptProgressChild(_), _.getCAttemptAttemptProgressChild)
    mockBooleanProperty(mockEntity.setCAttemptObjectiveProgressChild(_), _.getCAttemptObjectiveProgressChild)
    mockIntegerProperty(mockEntity.setAttemptLimit(_), _.getAttemptLimit)
    mockLongProperty(mockEntity.setDurationLimitInMilliseconds(_), _.getDurationLimitInMilliseconds)
    mockIntegerProperty(mockEntity.setRollupContributionID(_), _.getRollupContributionID)
    mockBooleanProperty(mockEntity.setPreventChildrenActivation(_), _.getPreventChildrenActivation)
    mockBooleanProperty(mockEntity.setConstrainChoice(_), _.getConstrainChoice)
  }
  def getIdFunction = _.getId

  mockLocalService.findByActivityIDAndPackageID(any, any) answers { (paramsRaw, mockService) =>
    val paramsTuple: (Any, Any) = paramsRaw match {
      case Array(a, b) if a.isInstanceOf[Int] && b.isInstanceOf[String] => (a, b)
    }
    val packageID = paramsTuple._1 match { case x: Int => x }
    val activityID = paramsTuple._2 match { case x: String => x }

    val result = internalStorage.values.filter(entity => entity.getPackageID == packageID
      && entity.getActivityID == activityID).headOption
    if (result.isEmpty) null else result.get
  }

}
