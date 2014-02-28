package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFObjectiveLocalService
import com.arcusys.learn.persistence.liferay.model.LFObjective
import com.arcusys.learn.storage.impl.liferay.MockEntityContainer

import scala.collection.JavaConverters._

/**
 * User: Yulia.Glushonkova
 * Date: 01.04.13
 */

object ObjectiveEntityContainer extends MockEntityContainer[LFObjectiveLocalService, LFObjective] {
  lazy val mockServiceBeanName = classOf[LFObjectiveLocalService].getName
  lazy val mockLocalService = mock[LFObjectiveLocalService]

  // service related mocks
  def createFunction = _.createLFObjective()
  def addFunction = _.addLFObjective(_)
  def deleteFunction = _.deleteLFObjective(_)
  def updateFunction = _.updateLFObjective(_)
  def orNull = _.orNull
  def getAllFunction = _.getLFObjectives(_,_)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFObjective]
  def mockEntityProperties(mockEntity: LFObjective) {
    mockStringProperty(mockEntity.setIdentifier(_), _.getIdentifier)
    mockBooleanProperty(mockEntity.setSatisfiedByMeasure(_), _.getSatisfiedByMeasure)
    mockDecimalProperty(mockEntity.setMinNormalizedMeasure(_), _.getMinNormalizedMeasure)
    mockBooleanProperty(mockEntity.setIsPrimary(_), _.getIsPrimary)
    mockIntegerProperty(mockEntity.setSequencingID(_), _.getSequencingID)
  }
  def getIdFunction = _.getLfId

  mockLocalService.findBySequencingIDAndIsPrimary(anyInt, any[Boolean]) answers { (param, data) =>
    filterBySequencingIDAndIsPrimary(param, data).asJava
  }

  mockLocalService.findBySequencingIDAndIsPrimaryAndIdentifier(any, any, any) answers {
    (paramsRaw, mockService) => {
      val paramsTuple: (Any, Any, Any) = paramsRaw match {
        case Array(a, b, c) => (a, b, c)
      }

      val seqID = paramsTuple._1.asInstanceOf[Int]
      val isPrimary = paramsTuple._2.asInstanceOf[Boolean]
      val identifier = paramsTuple._3.asInstanceOf[String]

      internalStorage.values.filter(entity => {
        entity.getSequencingID == seqID && entity.getIsPrimary == isPrimary && entity.getIdentifier == identifier
      }).toList.asJava
    }
  }

  private def filterBySequencingIDAndIsPrimary(param: Any, data: Any): Seq[LFObjective] ={
    val paramsTuple: (Any, Any) = param match {
      case Array(a, b) => (a, b)
    }
    val sequencingID = paramsTuple._1.asInstanceOf[Int]
    val isPrimary = paramsTuple._2.asInstanceOf[Boolean]
    internalStorage.values.filter(obj => obj.getSequencingID == sequencingID && obj.getIsPrimary == isPrimary).toList
  }

}
