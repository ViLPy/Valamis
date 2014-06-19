package com.arcusys.learn.scorm.tracking.states.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFObjectiveState
import com.arcusys.learn.persistence.liferay.service.LFObjectiveStateLocalService
import com.arcusys.learn.storage.impl.liferay.MockEntityContainer
import scala.collection.JavaConverters._

object ObjectiveStateEntityContainer extends MockEntityContainer[LFObjectiveStateLocalService, LFObjectiveState] {
  lazy val mockLocalService = mock[LFObjectiveStateLocalService]
  lazy val mockServiceBeanName = classOf[LFObjectiveStateLocalService].getName

  // service related mocks
  def createFunction = _.createLFObjectiveState()

  def addFunction = _.addLFObjectiveState(_)

  def deleteFunction = _.deleteLFObjectiveState(_)

  def updateFunction = _.updateLFObjectiveState(_)

  def orNull = _.orNull

  def getAllFunction = _.getLFObjectiveStates(_, _)

  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFObjectiveState]

  def mockEntityProperties(mockEntity: LFObjectiveState) {
    mockIntegerProperty(mockEntity.setObjectiveID(_), _.getObjectiveID)
    mockIntegerProperty(mockEntity.setActivityStateID(_), _.getActivityStateID)
    mockStringProperty(mockEntity.setMapKey(_), _.getMapKey)
    mockDecimalProperty(mockEntity.setNormalizedMeasure(_), _.getNormalizedMeasure)
    mockBooleanProperty(mockEntity.setSatisfied(_), _.getSatisfied)
  }

  def getIdFunction = _.getId

  mockLocalService.findByMapKeyAndActivityStateID(any, any) answers {
    (paramsRaw, mockService) =>
      val paramsTuple: (Any, Any) = paramsRaw match {
        case Array(a, b) => (a, b)
      }

      val mapKey = unwrapString(paramsTuple._1)
      val stateID = unwrapNullableInteger(paramsTuple._2)

      internalStorage.values.find(entity => {
        entity.getMapKey == mapKey && entity.getActivityStateID == stateID
      }).getOrElse(null)
  }

  mockLocalService.findByActivityStateID(any, any, any) answers {
    (paramsRaw, mockService) =>
      val paramsTuple: (Any, Any, Any) = paramsRaw match {
        case Array(a, b, c) if a.isInstanceOf[Int] && b.isInstanceOf[Int] && c.isInstanceOf[Int] => (a, b, c)
      }

      val mapKey = unwrapNullableInteger(paramsTuple._1)

      internalStorage.values.filter(entity => {
        entity.getActivityStateID == mapKey
      }).toList.asJava
  }
}
