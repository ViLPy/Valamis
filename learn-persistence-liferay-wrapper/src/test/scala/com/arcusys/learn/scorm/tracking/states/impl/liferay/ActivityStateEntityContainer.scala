package com.arcusys.learn.scorm.tracking.states.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFActivityStateLocalService
import com.arcusys.learn.persistence.liferay.model.LFActivityState
import com.arcusys.learn.storage.impl.liferay.MockKeyedEntityContainer
import scala.collection.JavaConverters._

object ActivityStateEntityContainer extends MockKeyedEntityContainer[LFActivityStateLocalService, LFActivityState] {
  lazy val mockLocalService = mock[LFActivityStateLocalService]
  lazy val mockServiceBeanName = classOf[LFActivityStateLocalService].getName

  // service related mocks
  def createFunction = _.createLFActivityState()

  def addFunction = _.addLFActivityState(_)

  def deleteFunction = _.deleteLFActivityState(_)

  def updateFunction = _.updateLFActivityState(_)

  def orNull = _.orNull

  def getAllFunction = _.getLFActivityStates(_, _)

  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFActivityState]

  def mockEntityProperties(mockEntity: LFActivityState) {
    mockIntegerProperty(mockEntity.setPackageID(_), _.getPackageID)
    mockStringProperty(mockEntity.setActivityID(_), _.getActivityID)
    mockBooleanProperty(mockEntity.setActive(_), _.getActive)
    mockBooleanProperty(mockEntity.setSuspended(_), _.getSuspended)
    mockBooleanProperty(mockEntity.setAttemptCompleted(_), _.getAttemptCompleted)
    mockDecimalProperty(mockEntity.setAttemptCompletionAmount(_), _.getAttemptCompletionAmount)
    mockDecimalProperty(mockEntity.setAttemptAbsoluteDuration(_), _.getAttemptAbsoluteDuration)
    mockDecimalProperty(mockEntity.setAttemptExperiencedDuration(_), _.getAttemptExperiencedDuration)
    mockDecimalProperty(mockEntity.setActivityAbsoluteDuration(_), _.getActivityAbsoluteDuration)
    mockDecimalProperty(mockEntity.setActivityExperiencedDuration(_), _.getActivityExperiencedDuration)
    mockIntegerProperty(mockEntity.setAttemptCount(_), _.getAttemptCount)
    mockIntegerProperty(mockEntity.setActivityStateNodeID(_), _.getActivityStateNodeID)
    mockIntegerProperty(mockEntity.setActivityStateTreeID(_), _.getActivityStateTreeID)
  }

  def getIdFunction = _.getId

  def getByIdFunction = _.getLFActivityState(_)

  mockLocalService.findByActivityStateNodeIDAndActivityID(any, any) answers {
    (paramsRaw, mockService) =>
      val paramsTuple: (Any, Any) = paramsRaw match {
        case Array(a, b) => (a, b)
      }

      val nodeIDs = unwrapArrayInteger(paramsTuple._1)
      val activityID = unwrapString(paramsTuple._2)

      internalStorage.values.filter(entity => {
        nodeIDs.contains(entity.getActivityStateNodeID) && entity.getActivityID == activityID
      }).toList.sortBy(_.getId).asJava
  }

  mockLocalService.findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(any, any, any) answers {
    (paramsRaw, mockService) =>
      val paramsTuple: (Any, Any, Any) = paramsRaw match {
        case Array(a, b, c) => (a, b, c)
      }

      val activityID = unwrapString(paramsTuple._1)
      val nodeIDs = unwrapArrayInteger(paramsTuple._2)
      val treeID = unwrapNullableInteger(paramsTuple._3)

      internalStorage.values.filter(entity => {
        (nodeIDs == null || nodeIDs.contains(entity.getActivityStateNodeID)) && entity.getActivityID == activityID && entity.getActivityStateTreeID == treeID
      }).toList.sortBy(_.getId).asJava
  }

  mockLocalService.findByActivityStateNodeID(any) answers {
    ids =>
      val nodeIDs = unwrapArrayInteger(ids)

      internalStorage.values.filter(entity => {
        nodeIDs.contains(entity.getActivityStateNodeID)
      }).toList.sortBy(_.getId).asJava
  }
}
