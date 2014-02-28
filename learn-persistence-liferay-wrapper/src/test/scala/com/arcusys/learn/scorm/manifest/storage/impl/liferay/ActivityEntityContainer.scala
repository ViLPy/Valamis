package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFActivityLocalService
import com.arcusys.learn.persistence.liferay.model.LFActivity
import com.arcusys.learn.storage.impl.liferay.MockEntityContainer

import scala.collection.JavaConverters._

/**
 * User: Yulia.Glushonkova
 * Date: 10.04.13
 */

object ActivityEntityContainer extends MockEntityContainer[LFActivityLocalService, LFActivity] {
  lazy val mockServiceBeanName = classOf[LFActivityLocalService].getName
  lazy val mockLocalService = mock[LFActivityLocalService]

  // service related mocks
  def createFunction = _.createLFActivity()
  def addFunction = _.addLFActivity(_)
  def deleteFunction = _.deleteLFActivity(_)
  def updateFunction = _.updateLFActivity(_)
  def orNull = _.orNull
  def getAllFunction = _.getLFActivities(_,_)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFActivity]
  def mockEntityProperties(mockEntity: LFActivity) {
    mockStringProperty(mockEntity.setId(_), _.getId)
    mockIntegerProperty(mockEntity.setPackageID(_), _.getPackageID)
    mockStringProperty(mockEntity.setOrganizationID(_), _.getOrganizationID)
    mockStringProperty(mockEntity.setParentID(_), _.getParentID)
    mockStringProperty(mockEntity.setTitle(_), _.getTitle)
    mockStringProperty(mockEntity.setIdentifierRef(_), _.getIdentifierRef)
    mockStringProperty(mockEntity.setResourceParameters(_), _.getResourceParameters)
    mockStringProperty(mockEntity.setHideLMSUI(_), _.getHideLMSUI)
    mockBooleanProperty(mockEntity.setVisible(_), _.getVisible)
    mockBooleanProperty(mockEntity.setObjectivesGlobalToSystem(_), _.getObjectivesGlobalToSystem)
    mockBooleanProperty(mockEntity.setSharedDataGlobalToSystem(_), _.getSharedDataGlobalToSystem)
    mockStringProperty(mockEntity.setMasteryScore(_), _.getMasteryScore)
    mockStringProperty(mockEntity.setMaxTimeAllowed(_), _.getMaxTimeAllowed)
  }
  def getIdFunction = _.getIndexNumber

  mockLocalService.findByPackageAndID(any, any) answers { (paramsRaw, mockService) =>
    val paramsTuple: (Any, Any) = paramsRaw match {
      case Array(a, b) if a.isInstanceOf[Int] && b.isInstanceOf[String] => (a, b)
    }
    val packageID = paramsTuple._1 match { case x: Int => x }
    val id = paramsTuple._2 match { case x: String => x }

    val result = internalStorage.values.filter(entity => entity.getPackageID == packageID
      &&  entity.getId == id).headOption
    if (result.isEmpty) null else result.get
  }
  mockLocalService.findByPackageID(any) answers { id =>
    internalStorage.values.filter(entity => entity.getPackageID == id).toList.asJava
  }

  mockLocalService.findByPackageIDAndOrganizationID(any, any) answers { (paramsRaw, mockService) =>
    val paramsTuple: (Any, Any) = paramsRaw match {
      case Array(a, b) if a.isInstanceOf[Int] && b.isInstanceOf[String] => (a, b)
    }
    val packageID = paramsTuple._1 match { case x: Int => x }
    val orgId = paramsTuple._2 match { case x: String => x }

    internalStorage.values.filter(entity => entity.getPackageID == packageID
      && entity.getOrganizationID == orgId).toList.asJava
  }

  mockLocalService.findByPackageIDAndParentID(any, any) answers { (paramsRaw, mockService) =>
    val paramsTuple: (Any, Any) = paramsRaw match {
      case Array(a, b) if a.isInstanceOf[Int] && b.isInstanceOf[String] => (a, b)
      case Array(a, null) if a.isInstanceOf[Int] => (a, null)
    }
    val packageID = paramsTuple._1 match { case x: Int => x }
    val parentID = paramsTuple._2 match {
      case x: String => x
      case _ => null
    }

    internalStorage.values.filter(entity => entity.getPackageID == packageID
      && entity.getParentID == parentID).toList.asJava
  }
}
