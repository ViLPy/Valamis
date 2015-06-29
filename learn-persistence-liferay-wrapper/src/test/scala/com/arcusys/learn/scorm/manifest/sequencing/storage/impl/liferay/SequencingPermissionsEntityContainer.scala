package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFSeqPermissionsLocalService
import com.arcusys.learn.persistence.liferay.model.LFSeqPermissions
import com.arcusys.learn.storage.impl.liferay.MockEntityContainer

import scala.collection.JavaConverters._

/**
 * User: Yulia.Glushonkova
 * Date: 29.03.13
 */

object SequencingPermissionsEntityContainer extends MockEntityContainer[LFSeqPermissionsLocalService, LFSeqPermissions] {
  lazy val mockServiceBeanName = classOf[LFSeqPermissionsLocalService].getName
  lazy val mockLocalService = mock[LFSeqPermissionsLocalService]

  // service related mocks
  def createFunction = _.createLFSequencingPermissions()
  def addFunction = _.addLFSeqPermissions(_)
  def deleteFunction = _.deleteLFSeqPermissions(_)
  def updateFunction = _.updateLFSeqPermissions(_)
  def orNull = _.orNull
  def getAllFunction = _.getLFSeqPermissionses(_, _)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFSeqPermissions]
  def mockEntityProperties(mockEntity: LFSeqPermissions) {
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

  private def filterBySequencingID(idRaw: Any): Seq[LFSeqPermissions] = {
    internalStorage.values.filter(sequencing => sequencing.getSequencingID == unwrapId(idRaw)).toSeq
  }
  private def unwrapId(idRaw: Any) = idRaw match {
    case x: Int                  => x
    case Array(x: Int, Int, Int) => x
  }
}
