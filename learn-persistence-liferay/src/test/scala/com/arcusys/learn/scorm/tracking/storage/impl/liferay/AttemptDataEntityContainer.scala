package com.arcusys.learn.scorm.tracking.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFAttemptDataLocalService
import com.arcusys.learn.persistence.liferay.model.LFAttemptData
import com.arcusys.learn.storage.impl.liferay.MockEntityContainer

import org.mockito.Matchers.{eq => eqMatcher}

import scala.collection.JavaConverters._


object AttemptDataEntityContainer extends MockEntityContainer[LFAttemptDataLocalService, LFAttemptData] {
  lazy val mockServiceBeanName = classOf[LFAttemptDataLocalService].getName
  lazy val mockLocalService = mock[LFAttemptDataLocalService]

  // service related mocks
  def createFunction = _.createLFAttemptData()

  def addFunction = _.addLFAttemptData(_)

  def deleteFunction = _.deleteLFAttemptData(_)

  def updateFunction = _.updateLFAttemptData(_)

  def orNull = _.orNull

  def getAllFunction = _.getLFAttemptDatas(_, _)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFAttemptData]

  def mockEntityProperties(mockEntity: LFAttemptData) {
    mockIntegerProperty(mockEntity.setAttemptID(_), _.getAttemptID)
    mockStringProperty(mockEntity.setActivityID(_), _.getActivityID)
    mockStringProperty(mockEntity.setDataKey(_), _.getDataKey)
    mockStringProperty(mockEntity.setDataValue(_), _.getDataValue)
  }

  def getIdFunction = _.getId

  mockLocalService.findByAttemptIDWithActivityID(anyInt, anyString) answers {
    (paramsRaw, mockService) => {
      val paramsTuple: (Any, Any) = paramsRaw match {
        case Array(a, b) => (a, b)
      }

      val attemptID = paramsTuple._1.asInstanceOf[Int]
      val activityID = paramsTuple._2.asInstanceOf[String]

      internalStorage.values.filter(entity => {
        entity.getAttemptID == attemptID && entity.getActivityID == activityID
      }).toList.asJava
    }
  }

  mockLocalService.findByAttemptIDWithDataKey(anyInt, anyString) answers {
    (paramsRaw, mockService) => {
      val paramsTuple: (Any, Any) = paramsRaw match {
        case Array(a, b) => (a, b)
      }

      val attemptID = paramsTuple._1.asInstanceOf[Int]
      val dataKey = paramsTuple._2.asInstanceOf[String]

      internalStorage.values.filter(entity => {
        entity.getAttemptID == attemptID && entity.getDataKey == dataKey
      }).toList.asJava
    }
  }

  mockLocalService.findBySingleKey(anyInt, anyString, anyString, eqMatcher(0), eqMatcher(1)) answers {
    (paramsRaw, mockService) => {
      val paramsTuple: (Any, Any, Any) = paramsRaw match {
        case Array(a, b, c, d, e) => (a, b, c)
      }

      val attemptID = paramsTuple._1.asInstanceOf[Int]
      val activityID = paramsTuple._2.asInstanceOf[String]
      val dataKey = paramsTuple._3.asInstanceOf[String]

      internalStorage.values.find(entity => {
        entity.getAttemptID == attemptID && entity.getActivityID == activityID && entity.getDataKey == dataKey
      }).toList.asJava
    }
  }

  mockLocalService.findByCollectionValues(anyInt, anyString, anyString) answers {
    (paramsRaw, mockService) => {
      val paramsTuple: (Any, Any, Any) = paramsRaw match {
        case Array(a, b, c) => (a, b, c)
      }

      val attemptID = paramsTuple._1.asInstanceOf[Int]
      val activityID = paramsTuple._2.asInstanceOf[String]
      val dataKey = paramsTuple._3.asInstanceOf[String].replaceFirst("%","")

      internalStorage.values.filter(entity => {
        entity.getAttemptID == attemptID && entity.getActivityID == activityID && entity.getDataKey.startsWith(dataKey)
      }).toList.asJava
    }
  }
}
