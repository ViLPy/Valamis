package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFSequencingPermissionsLocalService
import com.arcusys.learn.persistence.liferay.model.LFSequencingPermissions
import com.arcusys.learn.storage.impl.liferay.MockEntityContainer

import scala.collection.JavaConverters._

/**
 * User: Yulia.Glushonkova
 * Date: 29.03.13
 */

object SequencingPermissionsEntityContainer extends MockEntityContainer[LFSequencingPermissionsLocalService, LFSequencingPermissions] {
  lazy val mockServiceBeanName = classOf[LFSequencingPermissionsLocalService].getName
  lazy val mockLocalService = mock[LFSequencingPermissionsLocalService]

  // service related mocks
  def createFunction = _.createLFSequencingPermissions()
  def addFunction = _.addLFSequencingPermissions(_)
  def deleteFunction = _.deleteLFSequencingPermissions(_)
  def updateFunction = _.updateLFSequencingPermissions(_)
  def orNull = _.orNull
  def getAllFunction = _.getLFSequencingPermissionses(_,_)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFSequencingPermissions]
  def mockEntityProperties(mockEntity: LFSequencingPermissions) {
    mockIntegerProperty(mockEntity.setSequencingID(_), _.getSequencingID)
    mockBooleanProperty(mockEntity.setChoiceForChildren(_), _.getChoiceForChildren)
    mockBooleanProperty(mockEntity.setChoiceForNonDescendants(_), _.getChoiceForNonDescendants)
    mockBooleanProperty(mockEntity.setFlowForChildren(_), _.getFlowForChildren)
    mockBooleanProperty(mockEntity.setForwardOnlyForChildren(_), _.getForwardOnlyForChildren)
  }
  def getIdFunction = _.getId

  mockLocalService.findBySequencingID(anyInt) answers { id =>
    filterBySequencingID(id).asJava
  }
  mockLocalService.removeBySequencingID(anyInt) answers { id =>
    internalStorage --= filterBySequencingID(id).map(_.getId)
    ()
  }

  private def filterBySequencingID(idRaw: Any): Seq[LFSequencingPermissions] ={
    internalStorage.values.filter(sequencing => sequencing.getSequencingID == unwrapId(idRaw)).toSeq
  }
  private def unwrapId(idRaw: Any) = idRaw match {
    case x: Int => x
    case Array(x: Int, Int, Int) => x
  }
}
