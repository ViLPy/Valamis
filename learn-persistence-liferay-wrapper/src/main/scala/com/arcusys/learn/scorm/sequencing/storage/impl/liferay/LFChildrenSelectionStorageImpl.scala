package com.arcusys.learn.scorm.sequencing.storage.impl.liferay

import com.arcusys.learn.scorm.manifest.model.{ ChildrenSelectionTake, RandomizationTimingType, ChildrenSelection }
import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.persistence.liferay.service.LFChildrenSelectionLocalServiceUtil
import com.arcusys.learn.storage.impl.liferay.LiferayCommon
import scala.collection.JavaConverters._

/**
 * User: Yulia.Glushonkova
 * Date: 02.04.13
 */
trait LFChildrenSelectionStorageImpl extends EntityStorage[ChildrenSelection] {
  protected def doRenew() { LFChildrenSelectionLocalServiceUtil.removeAll() }

  def getOne(parameters: (String, Any)*) = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    val sequencingID = LiferayCommon.getParameter("sequencingID", parameters: _*)
    val lfEntity = LFChildrenSelectionLocalServiceUtil.findBySequencingID(sequencingID.get)

    val take = if (!isNullOrEmpty(lfEntity.getTakeTimingOnEachAttempt))
      Some(new ChildrenSelectionTake(lfEntity.getTakeCount, RandomizationTimingType.withName(lfEntity.getTakeTimingOnEachAttempt)))
    else None

    val reorder = if (!isNullOrEmpty(lfEntity.getReorderOnEachAttempt))
      Some(RandomizationTimingType.withName(lfEntity.getReorderOnEachAttempt))
    else None

    Option(new ChildrenSelection(take, reorder))
  }

  def getAll(parameters: (String, Any)*) = throw new UnsupportedOperationException("Not implemented")
  def create(parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }
  def create(entity: ChildrenSelection, parameters: (String, Any)*) {
    val sequencingID = LiferayCommon.getParameter("sequencingID", parameters: _*)
    val lfEntity = LFChildrenSelectionLocalServiceUtil.createLFChildrenSelection()
    lfEntity.setSequencingID(sequencingID.get)
    if (!entity.take.isEmpty) {
      lfEntity.setTakeCount(entity.take.get.count)
      lfEntity.setTakeTimingOnEachAttempt(entity.take.get.timing.toString)
    }
    if (!entity.reorder.isEmpty) lfEntity.setReorderOnEachAttempt(entity.reorder.get.toString)
    LFChildrenSelectionLocalServiceUtil.addLFChildrenSelection(lfEntity)
  }
  def delete(parameters: (String, Any)*) {
    val sequencingID = LiferayCommon.getParameter("sequencingID", parameters: _*)
    LFChildrenSelectionLocalServiceUtil.removeBySequencingID(sequencingID.get)
  }
  def modify(parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }
  def modify(entity: ChildrenSelection, parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }
}
