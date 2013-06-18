package com.arcusys.learn.scorm.tracking.states.impl.liferay

import com.arcusys.learn.storage.impl.liferay.MockEntityContainer
import com.arcusys.learn.persistence.liferay.service.LFGlobalObjectiveStateLocalService
import com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState
import scala.collection.JavaConverters._


object GlobalObjectiveStateEntityContainer extends MockEntityContainer[LFGlobalObjectiveStateLocalService, LFGlobalObjectiveState] {
  lazy val mockLocalService = mock[LFGlobalObjectiveStateLocalService]
  lazy val mockServiceBeanName = classOf[LFGlobalObjectiveStateLocalService].getName

  // service related mocks
  def createFunction = _.createLFGlobalObjectiveState()
  def addFunction = _.addLFGlobalObjectiveState(_)
  def deleteFunction = _.deleteLFGlobalObjectiveState(_)
  def updateFunction = _.updateLFGlobalObjectiveState(_)
  def orNull = _.orNull
  def getAllFunction = _.getLFGlobalObjectiveStates(_,_)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFGlobalObjectiveState]
  def mockEntityProperties(mockEntity: LFGlobalObjectiveState) {
    mockIntegerProperty(mockEntity.setTreeID(_), _.getTreeID)
    mockBooleanProperty(mockEntity.setAttemptCompleted(_), _.getAttemptCompleted)
    mockStringProperty(mockEntity.setMapKey(_), _.getMapKey)
    mockDecimalProperty(mockEntity.setNormalizedMeasure(_), _.getNormalizedMeasure)
    mockBooleanProperty(mockEntity.setSatisfied(_), _.getSatisfied)
  }
  def getIdFunction = _.getId

  mockLocalService.findByTreeID(any, any, any) answers {
    (paramsRaw, mockService) =>
      val paramsTuple: (Any, Any, Any) = paramsRaw match {
        case Array(a, b, c) if a.isInstanceOf[Int] && b.isInstanceOf[Int] && c.isInstanceOf[Int] => (a, b, c)
      }

      val treeID = unwrapNullableInteger(paramsTuple._1)

      internalStorage.values.filter(entity => {
        entity.getTreeID == treeID
      }).toList.asJava
  }

  mockLocalService.findByTreeIDAndMapKey(any, any) answers {
    (paramsRaw, mockService) =>
      val paramsTuple: (Any, Any) = paramsRaw match {
        case Array(a, b) if a.isInstanceOf[Int] && b.isInstanceOf[String] => (a, b)
      }

      val mapKey = unwrapString(paramsTuple._2)
      val treeID = unwrapNullableInteger(paramsTuple._1)

      internalStorage.values.find(entity => {
        entity.getMapKey == mapKey && entity.getTreeID == treeID
      }).getOrElse(null)
  }
}
