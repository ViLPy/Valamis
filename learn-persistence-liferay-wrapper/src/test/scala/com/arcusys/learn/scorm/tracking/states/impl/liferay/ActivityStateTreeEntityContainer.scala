package com.arcusys.learn.scorm.tracking.states.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFActivityStateTreeLocalService
import com.arcusys.learn.persistence.liferay.model.LFActivityStateTree
import com.arcusys.learn.storage.impl.liferay.MockKeyedEntityContainer


object ActivityStateTreeEntityContainer extends MockKeyedEntityContainer[LFActivityStateTreeLocalService, LFActivityStateTree] {
  lazy val mockLocalService = mock[LFActivityStateTreeLocalService]
  lazy val mockServiceBeanName = classOf[LFActivityStateTreeLocalService].getName

  // service related mocks
  def createFunction = _.createLFActivityStateTree()
  def addFunction = _.addLFActivityStateTree(_)
  def deleteFunction = _.deleteLFActivityStateTree(_)
  def updateFunction = _.updateLFActivityStateTree(_)
  def orNull = _.orNull
  def getAllFunction = _.getLFActivityStateTrees(_,_)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFActivityStateTree]
  def getIdFunction = _.getId
  def mockEntityProperties(mockEntity: LFActivityStateTree) {
    mockStringProperty(mockEntity.setCurrentActivityID(_), _.getCurrentActivityID)
    mockStringProperty(mockEntity.setSuspendedActivityID(_), _.getSuspendedActivityID)
    mockIntegerProperty(mockEntity.setAttemptID(_), _.getAttemptID)
  }

  def getByIdFunction = _.getLFActivityStateTree(_)

  mockLocalService.findByAttemptID(any) answers { id =>
    internalStorage.values.find(e => e.getAttemptID == id).getOrElse(null)
  }
}
