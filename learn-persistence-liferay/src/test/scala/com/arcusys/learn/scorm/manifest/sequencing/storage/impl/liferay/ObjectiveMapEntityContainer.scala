package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFObjectiveMapLocalService
import com.arcusys.learn.persistence.liferay.model.LFObjectiveMap
import com.arcusys.learn.storage.impl.liferay.MockEntityContainer

import scala.collection.JavaConverters._

/**
 * User: Yulia.Glushonkova
 * Date: 29.03.13
 */

object ObjectiveMapEntityContainer extends MockEntityContainer[LFObjectiveMapLocalService, LFObjectiveMap] {
  lazy val mockServiceBeanName = classOf[LFObjectiveMapLocalService].getName
  lazy val mockLocalService = mock[LFObjectiveMapLocalService]

  // service related mocks
  def createFunction = _.createLFObjectiveMap()
  def addFunction = _.addLFObjectiveMap(_)
  def deleteFunction = _.deleteLFObjectiveMap(_)
  def updateFunction = _.updateLFObjectiveMap(_)
  def orNull = _.orNull
  def getAllFunction = _.getLFObjectiveMaps(_,_)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFObjectiveMap]

  def mockEntityProperties(mockEntity: LFObjectiveMap) {
    mockIntegerProperty(mockEntity.setObjectiveID(_), _.getObjectiveID)
    mockStringProperty(mockEntity.setReadSatisfiedStatusFrom(_), _.getReadSatisfiedStatusFrom)
    mockStringProperty(mockEntity.setReadNormalizedMeasureFrom(_), _.getReadNormalizedMeasureFrom)
    mockStringProperty(mockEntity.setWriteSatisfiedStatusTo(_), _.getWriteSatisfiedStatusTo)
    mockStringProperty(mockEntity.setWriteNormalizedMeasureTo(_), _.getWriteNormalizedMeasureTo)
    mockStringProperty(mockEntity.setReadRawScoreFrom(_), _.getReadRawScoreFrom)
    mockStringProperty(mockEntity.setReadMinScoreFrom(_), _.getReadMinScoreFrom)
    mockStringProperty(mockEntity.setReadMaxScoreFrom(_), _.getReadMaxScoreFrom)
    mockStringProperty(mockEntity.setReadCompletionStatusFrom(_), _.getReadCompletionStatusFrom)
    mockStringProperty(mockEntity.setReadProgressMeasureFrom(_), _.getReadProgressMeasureFrom)
    mockStringProperty(mockEntity.setWriteRawScoreTo(_), _.getWriteRawScoreTo)
    mockStringProperty(mockEntity.setWriteMinScoreTo(_), _.getWriteMinScoreTo)
    mockStringProperty(mockEntity.setWriteMaxScoreTo(_), _.getWriteMaxScoreTo)
    mockStringProperty(mockEntity.setWriteCompletionStatusTo(_), _.getWriteCompletionStatusTo)
    mockStringProperty(mockEntity.setWriteProgressMeasureTo(_), _.getWriteProgressMeasureTo)
  }

  def getIdFunction = _.getId

  mockLocalService.findByObjectiveID(anyInt) answers { id =>
    filterByObjectiveID(id).asJava
  }
  mockLocalService.removeByObjectiveID(anyInt) answers { id =>
    internalStorage --= filterByObjectiveID(id).map(_.getId)
    ()
  }

  private def filterByObjectiveID(idRaw: Any): Seq[LFObjectiveMap] ={
    internalStorage.values.filter(obj => obj.getObjectiveID == unwrapId(idRaw)).toSeq
  }
  private def unwrapId(idRaw: Any) = idRaw match {
    case x: Int => x
    case Array(x: Int, Int, Int) => x
  }
}
