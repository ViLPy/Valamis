package com.arcusys.learn.scorm.sequencing.storage.impl.liferay

import com.arcusys.learn.scorm.manifest.model.SequencingPermissions
import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.persistence.liferay.service.LFSequencingPermissionsLocalServiceUtil
import com.arcusys.learn.persistence.liferay.model.LFSequencingPermissions
import scala.collection.JavaConverters._

/**
 * User: Yulia.Glushonkova
 * Date: 29.03.13
 */
trait LFSequencingPermissionsStorageImpl extends EntityStorage[SequencingPermissions] {
  protected def doRenew() { LFSequencingPermissionsLocalServiceUtil.removeAll()}

  def getOne(parameters: (String, Any)*) = {
    parameters match {
      case Seq(("sequencingID", value: Int)) => {
        val lf = LFSequencingPermissionsLocalServiceUtil.findBySequencingID(value).asScala.headOption
        Option(extract(lf))
      }
    }
  }
  def extract(lfEntity: Option[LFSequencingPermissions]) =
    if (lfEntity.isEmpty) null
    else new SequencingPermissions(
      lfEntity.get.getChoiceForChildren,
      lfEntity.get.getChoiceForNonDescendants,
      lfEntity.get.getFlowForChildren,
      lfEntity.get.getForwardOnlyForChildren)

  def getAll(parameters: (String, Any)*) = throw new UnsupportedOperationException("Not implemented")
  def create(parameters: (String, Any)*) {throw new UnsupportedOperationException("Not implemented")}
  def create(entity: SequencingPermissions, parameters: (String, Any)*) {
    val sequencingID = if (parameters.isEmpty) None
    else parameters match { case Seq(("sequencingID", value: Int)) => Some(value) }
    doUpdate(entity, sequencingID, LFSequencingPermissionsLocalServiceUtil.createLFSequencingPermissions(), LFSequencingPermissionsLocalServiceUtil.addLFSequencingPermissions(_))
  }

  def delete(parameters: (String, Any)*) {parameters match {
    case Seq(("sequencingID", value: Int)) => { LFSequencingPermissionsLocalServiceUtil.removeBySequencingID(value) }}
  }
  def modify(parameters: (String, Any)*) {throw new UnsupportedOperationException("Not implemented")}
  def modify(entity: SequencingPermissions, parameters: (String, Any)*) {throw new UnsupportedOperationException("Not implemented")}

  def doUpdate(entity: SequencingPermissions, sequencingId: Option[Int], newEntity: LFSequencingPermissions, updateFunction: (LFSequencingPermissions) => LFSequencingPermissions): LFSequencingPermissions= {
      if (!sequencingId.isEmpty) newEntity.setSequencingID(sequencingId.get)
      newEntity.setChoiceForChildren(entity.choiceForChildren)
      newEntity.setChoiceForNonDescendants(entity.choiceForNonDescendants)
      newEntity.setFlowForChildren(entity.flowForChildren)
      newEntity.setForwardOnlyForChildren(entity.forwardOnlyForChildren)
      updateFunction(newEntity)
    }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }
}
