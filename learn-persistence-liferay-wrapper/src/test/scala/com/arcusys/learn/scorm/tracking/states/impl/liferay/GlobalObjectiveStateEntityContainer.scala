package com.arcusys.learn.scorm.tracking.states.impl.liferay

import com.arcusys.learn.storage.impl.liferay.MockEntityContainer
import com.arcusys.learn.persistence.liferay.service.LFGlblObjectiveStateLocalService
import com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState
import scala.collection.JavaConverters._

object GlobalObjectiveStateEntityContainer extends MockEntityContainer[LFGlblObjectiveStateLocalService, LFGlblObjectiveState] {
  lazy val mockLocalService = mock[LFGlblObjectiveStateLocalService]
  lazy val mockServiceBeanName = classOf[LFGlblObjectiveStateLocalService].getName

  // service related mocks
  def createFunction = _.createLFGlobalObjectiveState()
  def addFunction = _.addLFGlblObjectiveState(_)
  def deleteFunction = _.deleteLFGlblObjectiveState(_)
  def updateFunction = _.updateLFGlblObjectiveState(_)
  def orNull = _.orNull
  def getAllFunction = _.getLFGlblObjectiveStates(_, _)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFGlblObjectiveState]
  def mockEntityProperties(mockEntity: LFGlblObjectiveState) {
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
