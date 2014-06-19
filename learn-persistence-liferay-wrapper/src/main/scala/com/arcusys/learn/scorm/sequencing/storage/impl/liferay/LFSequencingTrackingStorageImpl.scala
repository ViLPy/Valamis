package com.arcusys.learn.scorm.sequencing.storage.impl.liferay

import com.arcusys.learn.scorm.manifest.model.SequencingTracking
import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.persistence.liferay.service.LFSequencingTrackingLocalServiceUtil
import com.arcusys.learn.persistence.liferay.model.LFSequencingTracking
import scala.collection.JavaConverters._

/**
 * User: Yulia.Glushonkova
 * Date: 28.03.13
 */
trait LFSequencingTrackingStorageImpl extends EntityStorage[SequencingTracking] {
  protected def doRenew() { LFSequencingTrackingLocalServiceUtil.removeAll() }

  def getOne(parameters: (String, Any)*) = {
    parameters match {
      case Seq(("sequencingID", value: Int)) => {
        val lf = LFSequencingTrackingLocalServiceUtil.findBySequencingID(value).asScala.headOption
        Option(extract(lf))
      }
    }
  }

  def extract(lfEntity: Option[LFSequencingTracking]) =
    if (lfEntity.isEmpty) null
    else new SequencingTracking(lfEntity.get.getCompletionSetByContent, lfEntity.get.getObjectiveSetByContent)

  def getAll(parameters: (String, Any)*) = { throw new UnsupportedOperationException("Not implemented") }
  def create(parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }
  def create(entity: SequencingTracking, parameters: (String, Any)*) {
    val sequencingID = if (parameters.isEmpty) None
    else parameters match { case Seq(("sequencingID", value: Int)) => Some(value) }
    doUpdate(entity, sequencingID, LFSequencingTrackingLocalServiceUtil.createLFSequencingTracking(), LFSequencingTrackingLocalServiceUtil.addLFSequencingTracking(_))
  }
  def delete(parameters: (String, Any)*) {
    parameters match {
      case Seq(("sequencingID", value: Int)) => { LFSequencingTrackingLocalServiceUtil.removeBySequencingID(value) }
    }
  }
  def modify(parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }
  def modify(entity: SequencingTracking, parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }

  def doUpdate(entity: SequencingTracking, sequencingId: Option[Int], newEntity: LFSequencingTracking, updateFunction: (LFSequencingTracking) => LFSequencingTracking): LFSequencingTracking = {
    if (!sequencingId.isEmpty) newEntity.setSequencingID(sequencingId.get)
    newEntity.setCompletionSetByContent(entity.completionSetByContent)
    newEntity.setObjectiveSetByContent(entity.objectiveSetByContent)
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
