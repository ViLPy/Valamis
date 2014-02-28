package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFResourceLocalService
import com.arcusys.learn.persistence.liferay.model.LFResource
import com.arcusys.learn.storage.impl.liferay.MockEntityContainer

import scala.collection.JavaConverters._


object ResourceEntityContainer extends MockEntityContainer[LFResourceLocalService, LFResource] {
  lazy val mockServiceBeanName = classOf[LFResourceLocalService].getName
  lazy val mockLocalService = mock[LFResourceLocalService]

  // service related mocks
  def createFunction = _.createLFResource

  def addFunction = _.addLFResource(_)

  def deleteFunction = _.deleteLFResource(_)

  def updateFunction = _.updateLFResource(_)

  def orNull = _.orNull

  def getAllFunction = _.getLFResources(_, _)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFResource]

  def mockEntityProperties(mockEntity: LFResource) {
    mockIntegerProperty(mockEntity.setPackageID(_), _.getPackageID)
    mockStringProperty(mockEntity.setScormType(_), _.getScormType)
    mockStringProperty(mockEntity.setResourceID(_), _.getResourceID)
    mockStringProperty(mockEntity.setHref(_), _.getHref)
    mockStringProperty(mockEntity.setBase(_), _.getBase)
  }

  def getIdFunction = _.getId

  mockLocalService.findByPackageID(anyInt) answers {
    (paramsRaw, mockService) => {
      val packageID: Int = paramsRaw match {
        case Array(a) => a.asInstanceOf[Int]
      }

      internalStorage.values.filter(entity => {
        entity.getPackageID == packageID
      }).toList.asJava
    }
  }

  mockLocalService.findByPackageIDAndResourceID(anyInt, anyString, anyInt, anyInt) answers {
    (paramsRaw, mockService) => {
      val paramsTuple: (Any, Any) = paramsRaw match {
        case Array(a, b, c, d) => (a, b)
      }

      val packageID = paramsTuple._1.asInstanceOf[Int]
      val resourceID = paramsTuple._2.asInstanceOf[String]

      internalStorage.values.find(entity => {
        entity.getPackageID == packageID && entity.getResourceID == resourceID
      }).toList.asJava
    }
  }
}
