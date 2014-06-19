package com.arcusys.learn.scorm.tracking.states.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFAttemptLocalService
import com.arcusys.learn.persistence.liferay.model.LFAttempt
import com.arcusys.learn.storage.impl.liferay.MockKeyedEntityContainer
import scala.collection.JavaConverters._

object AttemptEntityContainer extends MockKeyedEntityContainer[LFAttemptLocalService, LFAttempt] {
  lazy val mockLocalService = mock[LFAttemptLocalService]
  lazy val mockServiceBeanName = classOf[LFAttemptLocalService].getName

  // service related mocks
  def createFunction = _.createLFAttempt()
  def addFunction = _.addLFAttempt(_)
  def deleteFunction = _.deleteLFAttempt(_)
  def updateFunction = _.updateLFAttempt(_)
  def orNull = _.orNull
  def getAllFunction = _.getLFAttempts(_, _)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFAttempt]
  def mockEntityProperties(mockEntity: LFAttempt) {
    mockIntegerProperty(mockEntity.setUserID(_), _.getUserID)
    mockIntegerProperty(mockEntity.setPackageID(_), _.getPackageID)
    mockStringProperty(mockEntity.setOrganizationID(_), _.getOrganizationID)
    mockBooleanProperty(mockEntity.setIsComplete(_), _.getIsComplete)
  }

  def getIdFunction = _.getId

  // keyed entity - service related mocks
  def getByIdFunction = _.getLFAttempt(_)

  mockLocalService.findByUserIDPackageIDIsComplete(any, any, any) answers { (paramsRaw, mockService) =>
    val paramsTuple: (Any, Any, Any) = paramsRaw match {
      case Array(a, b, c) if a.isInstanceOf[Int] && b.isInstanceOf[Int] && c.isInstanceOf[Boolean] => (a, b, c)
    }

    val userID = unwrapNullableInteger(paramsTuple._1)
    val packageID = unwrapNullableInteger(paramsTuple._2)
    val isComplete = unwrapBoolean(paramsTuple._3)

    internalStorage.values.filter(entity => {
      entity.getUserID == userID && entity.getPackageID == packageID && entity.getIsComplete == isComplete
    }).toList.asJava
  }

  mockLocalService.findByUserID(any) answers { paramsRaw =>
    val userID: Int = paramsRaw match {
      case Array(a) if a.isInstanceOf[Int] => a.asInstanceOf[Int]
      case a: Int                          => a
    }
    internalStorage.values.filter(entity => {
      entity.getUserID == userID
    }).toList.asJava
  }

  mockLocalService.findByPackageID(any) answers { paramsRaw =>
    val pkgID: Int = paramsRaw match {
      case Array(a) if a.isInstanceOf[Int] => a.asInstanceOf[Int]
      case a: Int                          => a
    }
    internalStorage.values.filter(entity => {
      entity.getPackageID == pkgID
    }).toList.asJava
  }
}
