package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFChildrenSelection
import com.arcusys.learn.persistence.liferay.service.LFChildrenSelectionLocalService
import com.arcusys.learn.storage.impl.liferay.MockEntityContainer

/**
 * User: Yulia.Glushonkova
 * Date: 02.04.13
 */

object ChildrenSelectionEntityContainer extends MockEntityContainer[LFChildrenSelectionLocalService, LFChildrenSelection] {
  lazy val mockServiceBeanName = classOf[LFChildrenSelectionLocalService].getName
  lazy val mockLocalService = mock[LFChildrenSelectionLocalService]

  // service related mocks
  def createFunction = _.createLFChildrenSelection()
  def addFunction = _.addLFChildrenSelection(_)
  def deleteFunction = _.deleteLFChildrenSelection(_)
  def updateFunction = _.updateLFChildrenSelection(_)
  def orNull = _.orNull
  def getAllFunction = _.getLFChildrenSelections(_, _)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFChildrenSelection]
  def mockEntityProperties(mockEntity: LFChildrenSelection) {
    mockIntegerProperty(mockEntity.setSequencingID(_), _.getSequencingID)
    mockIntegerProperty(mockEntity.setTakeCount(_), _.getTakeCount)
    mockStringProperty(mockEntity.setTakeTimingOnEachAttempt(_), _.getTakeTimingOnEachAttempt)
    mockStringProperty(mockEntity.setReorderOnEachAttempt(_), _.getReorderOnEachAttempt)
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
  private def filterBySequencingID(idRaw: Any): Seq[LFChildrenSelection] = {
    internalStorage.values.filter(obj => obj.getSequencingID == unwrapId(idRaw)).toSeq
  }
  private def unwrapId(idRaw: Any) = idRaw match {
    case x: Int                  => x
    case Array(x: Int, Int, Int) => x
  }
}
