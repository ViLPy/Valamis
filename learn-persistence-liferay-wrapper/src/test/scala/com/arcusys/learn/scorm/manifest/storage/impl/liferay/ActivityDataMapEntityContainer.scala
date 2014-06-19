package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFActivityDataMapLocalService
import com.arcusys.learn.storage.impl.liferay.MockEntityContainer
import com.arcusys.learn.persistence.liferay.model.LFActivityDataMap
import scala.collection.JavaConverters._

object ActivityDataMapEntityContainer extends MockEntityContainer[LFActivityDataMapLocalService, LFActivityDataMap] {
  lazy val mockServiceBeanName = classOf[LFActivityDataMapLocalService].getName
  lazy val mockLocalService = mock[LFActivityDataMapLocalService]

  // service related mocks
  def createFunction = _.createLFAttemptData()

  def addFunction = _.addLFActivityDataMap(_)

  def deleteFunction = _.deleteLFActivityDataMap(_)

  def updateFunction = _.updateLFActivityDataMap(_)

  def orNull = _.orNull

  def getAllFunction = _.getLFActivityDataMaps(_, _)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFActivityDataMap]

  def mockEntityProperties(mockEntity: LFActivityDataMap) {
    mockIntegerProperty(mockEntity.setPackageID(_), _.getPackageID)
    mockStringProperty(mockEntity.setActivityID(_), _.getActivityID)
    mockStringProperty(mockEntity.setTargetId(_), _.getTargetId)
    mockBooleanProperty(mockEntity.setReadSharedData(_), _.getReadSharedData)
    mockBooleanProperty(mockEntity.setWriteSharedData(_), _.getWriteSharedData)
  }

  def getIdFunction = _.getId

  mockLocalService.findByPackageIDAndActivityID(anyInt, anyString) answers {
    (paramsRaw, mockService) =>
      {
        val paramsTuple: (Any, Any) = paramsRaw match {
          case Array(a, b) => (a, b)
        }

        val packageID = paramsTuple._1.asInstanceOf[Int]
        val activityID = paramsTuple._2.asInstanceOf[String]

        internalStorage.values.filter(entity => {
          entity.getPackageID == packageID && entity.getActivityID == activityID
        }).toList.asJava
      }
  }

  mockLocalService.removeByPackageIDAndActivityID(anyInt, anyString) answers {
    (paramsRaw, mockService) =>
      {
        val paramsTuple: (Any, Any) = paramsRaw match {
          case Array(a, b) => (a, b)
        }

        val packageID = paramsTuple._1.asInstanceOf[Int]
        val activityID = paramsTuple._2.asInstanceOf[String]

        internalStorage --= internalStorage.values.filter(entity => {
          entity.getPackageID == packageID && entity.getActivityID == activityID
        }).map(_.getId)
        ()
      }
  }
}
