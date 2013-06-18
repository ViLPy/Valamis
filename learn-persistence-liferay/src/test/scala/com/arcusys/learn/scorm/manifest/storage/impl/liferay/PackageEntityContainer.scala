package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFPackage
import com.arcusys.learn.persistence.liferay.service.LFPackageLocalService
import com.arcusys.learn.storage.impl.liferay.MockEntityContainer

import scala.collection.JavaConverters._
import java.lang.{Long => JavaLong}
import java.lang.{Integer => JavaInt}

/**
 * User: Yulia.Glushonkova
 * Date: 12.04.13
 */

object PackageEntityContainer extends MockEntityContainer[LFPackageLocalService, LFPackage] {
  lazy val mockServiceBeanName = classOf[LFPackageLocalService].getName
  lazy val mockLocalService = mock[LFPackageLocalService]

  mockLocalService.findByRefID(any) answers { id =>
    val result = internalStorage.values.filter(entity => entity.getAssetRefID == id).headOption
    if (result.isEmpty) null else result.get
  }

  mockLocalService.getLFPackage(any) answers { ids =>
    val id = ids match {
      case x => x
    }
    val result = internalStorage.values.filter(_.getId == id).headOption
    if (result.isEmpty) null else result.get
  }

  mockLocalService.findByPackageID(any) answers { ids =>
    val id: Array[JavaLong] = ids match {
      case x: Array[JavaLong] => x
    }
    internalStorage.values.filter(entity => id.contains(entity.getId)).toList.sortBy(_.getId).asJava
  }

  mockLocalService.findByCourseID(any) answers { id =>
    internalStorage.values.filter(entity => entity.getCourseID == id).toList.sortBy(_.getId).asJava
  }

  // service related mocks
  def createFunction = _.createLFPackage()
  def addFunction = _.addLFPackage(_)
  def deleteFunction = _.deleteLFPackage(_)
  def updateFunction = _.updateLFPackage(_)
  def orNull = _.orNull
  def getAllFunction = _.getLFPackages(_, _)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFPackage]

  def mockEntityProperties(mockEntity: LFPackage) {
    mockStringProperty(mockEntity.setDefaultOrganizationID(_), _.getDefaultOrganizationID)
    mockStringProperty(mockEntity.setTitle(_), _.getTitle)
    mockStringProperty(mockEntity.setBase(_), _.getBase)
    mockStringProperty(mockEntity.setResourcesBase(_), _.getResourcesBase)
    mockStringProperty(mockEntity.setSummary(_), _.getSummary)
    mockLongProperty(mockEntity.setAssetRefID(_), _.getAssetRefID)
    mockIntegerProperty(mockEntity.setCourseID(_), _.getCourseID)
  }

  def getIdFunction = _.getId


/*
  mockLocalService.findByPackageIDAndCourseID(any, any) answers {
    (paramsRaw, mockService) =>
      val paramsTuple: (Any, Any) = paramsRaw match {
        case Array(a, b) => (a, b)
      }
      val packageID = paramsTuple._1.asInstanceOf[Long]
      val courseID = paramsTuple._2.asInstanceOf[Int]
      val result = internalStorage.values.filter(entity => entity.getId == packageID && entity.getCourseID == courseID).headOption
      if (result.isEmpty) null else result.get
  }
*/

  mockLocalService.findByInstance(any) answers { ids =>
    val id: Array[JavaInt] = ids match {
      case x: Array[JavaInt] => x
    }
    internalStorage.values.filter(entity => id.contains(entity.getCourseID)).toList.sortBy(_.getId).asJava
  }
}
