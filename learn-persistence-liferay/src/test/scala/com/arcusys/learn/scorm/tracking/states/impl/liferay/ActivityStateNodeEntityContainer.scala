package com.arcusys.learn.scorm.tracking.states.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFActivityStateNodeLocalService
import com.arcusys.learn.persistence.liferay.model.LFActivityStateNode
import com.arcusys.learn.storage.impl.liferay.MockKeyedEntityContainer
import scala.collection.JavaConverters._

object ActivityStateNodeEntityContainer extends MockKeyedEntityContainer[LFActivityStateNodeLocalService, LFActivityStateNode] {
  lazy val mockLocalService = mock[LFActivityStateNodeLocalService]
  lazy val mockServiceBeanName = classOf[LFActivityStateNodeLocalService].getName

  // service related mocks
  def createFunction = _.createLFActivityStateNode()

  def addFunction = _.addLFActivityStateNode(_)

  def deleteFunction = _.deleteLFActivityStateNode(_)

  def updateFunction = _.updateLFActivityStateNode(_)

  def orNull = _.orNull

  def getAllFunction = _.getLFActivityStateNodes(_, _)

  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFActivityStateNode]

  def mockEntityProperties(mockEntity: LFActivityStateNode) {
    mockIntegerProperty(mockEntity.setParentID(_), _.getParentID)
    mockIntegerProperty(mockEntity.setTreeID(_), _.getTreeID)
    mockStringProperty(mockEntity.setAvailableChildrenIDs(_), _.getAvailableChildrenIDs)
  }

  def getIdFunction = _.getId

  def getByIdFunction = _.getLFActivityStateNode(_)

  mockLocalService.findByTreeID(any) answers {
    id =>
      internalStorage.values.filter(e => e.getTreeID == id).toList.sortBy(_.getId).asJava
  }

  mockLocalService.findByTreeIDAndParentID(any, any) answers {
    (paramsRaw, mockService) =>
      val paramsTuple: (Any, Any) = paramsRaw match {
        case Array(a, b) if a.isInstanceOf[Int] && b.isInstanceOf[Int] => (a, b)
      }

      val treeID = unwrapNullableInteger(paramsTuple._1)
      val parentID = unwrapNullableInteger(paramsTuple._2)

      internalStorage.values.filter(entity => {
        entity.getTreeID == treeID && entity.getParentID == parentID
      }).toList.sortBy(_.getId).asJava
  }
}
