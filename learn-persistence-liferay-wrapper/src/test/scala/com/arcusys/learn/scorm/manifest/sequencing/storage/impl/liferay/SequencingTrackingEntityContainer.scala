package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFSequencingTrackingLocalService
import com.arcusys.learn.persistence.liferay.model.LFSequencingTracking
import com.arcusys.learn.storage.impl.liferay.MockEntityContainer


import scala.collection.JavaConverters._

/**
 * User: Yulia.Glushonkova
 * Date: 28.03.13
 */

object SequencingTrackingEntityContainer extends MockEntityContainer[LFSequencingTrackingLocalService, LFSequencingTracking] {
  lazy val mockServiceBeanName = classOf[LFSequencingTrackingLocalService].getName
  lazy val mockLocalService = mock[LFSequencingTrackingLocalService]

  // service related mocks
  def createFunction = _.createLFSequencingTracking()
  def addFunction = _.addLFSequencingTracking(_)
  def deleteFunction = _.deleteLFSequencingTracking(_)
  def updateFunction = _.updateLFSequencingTracking(_)
  def orNull = _.orNull
  def getAllFunction = _.getLFSequencingTrackings(_,_)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFSequencingTracking]
  def mockEntityProperties(mockEntity: LFSequencingTracking) {
    mockBooleanProperty(mockEntity.setCompletionSetByContent(_), _.getCompletionSetByContent)
    mockBooleanProperty(mockEntity.setObjectiveSetByContent(_), _.getObjectiveSetByContent)
    mockIntegerProperty(mockEntity.setSequencingID(_), _.getSequencingID)
  }
  def getIdFunction = _.getId

  mockLocalService.findBySequencingID(anyInt) answers { id =>
    filterBySequencingID(id).asJava
  }
  mockLocalService.removeBySequencingID(anyInt) answers { id =>
    internalStorage --= filterBySequencingID(id).map(_.getId)
    ()
  }

  private def filterBySequencingID(idRaw: Any): Seq[LFSequencingTracking] ={
    internalStorage.values.filter(sequencing => sequencing.getSequencingID == unwrapId(idRaw)).toSeq
  }
  private def unwrapId(idRaw: Any) = idRaw match {
    case x: Int => x
    case Array(x: Int, Int, Int) => x
  }
}


