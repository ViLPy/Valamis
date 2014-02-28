package com.arcusys.learn.scorm.sequencing.storage.impl.liferay

import com.arcusys.learn.scorm.manifest.model.Sequencing
import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.storage.impl.liferay.LiferayCommon
import com.arcusys.learn.persistence.liferay.service.LFSequencingLocalServiceUtil
import com.arcusys.learn.persistence.liferay.model.LFSequencing
import com.arcusys.learn.scorm.manifest.sequencing.storage.impl.SequencingFieldsMapper

/**
 * User: Yulia.Glushonkova
 * Date: 09.04.13
 */
trait LFSequencingStorageImpl extends KeyedEntityStorage[Sequencing] {
  protected def doRenew() {
    LFSequencingLocalServiceUtil.removeAll()
  }

  def getOne(parameters: (String, Any)*) = {
    val lfSequencing = LFSequencingLocalServiceUtil.findByActivityIDAndPackageID(
      LiferayCommon.getParameter("packageID", parameters: _*).get,
      LiferayCommon.getParameter("activityID", parameters: _*).get)
    extract(lfSequencing)
  }

  private def extract(lfentity: LFSequencing): Option[Sequencing] = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

    if (lfentity == null) None
    else {
      val mapper = new SequencingFieldsMapper {
        def id = lfentity.getId.toInt
        def sharedId = lfentity.getSharedId.toOption
        def sharedSequencingIdReference = lfentity.getSharedSequencingIdReference.toOption
        def onlyCurrentAttemptObjectiveProgressForChildren = lfentity.getCAttemptAttemptProgressChild
        def onlyCurrentAttemptAttemptProgressForChildren = lfentity.getCAttemptObjectiveProgressChild
        def attemptLimit = lfentity.getAttemptLimit.toOption
        def durationLimitInMilliseconds = lfentity.getDurationLimitInMilliseconds.toOption
        def preventChildrenActivation = lfentity.getPreventChildrenActivation
        def constrainChoice = lfentity.getConstrainChoice
      }
      Option(createSequencing(mapper))
    }
  }

  def createSequencing(mapper: SequencingFieldsMapper): Sequencing

  def getAll(parameters: (String, Any)*) = throw new UnsupportedOperationException("Not implemented")

  def create(parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def create(entity: Sequencing, parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def delete(parameters: (String, Any)*) {
    LFSequencingLocalServiceUtil.removeByActivityIDAndPackageID(
      LiferayCommon.getParameter("packageID", parameters: _*).get,
      LiferayCommon.getParameter("activityID", parameters: _*).get)
  }

  def modify(parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def modify(entity: Sequencing, parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def getByID(id: Int, parameters: (String, Any)*) = throw new UnsupportedOperationException("Not implemented")

  def createAndGetID(entity: Sequencing, parameters: (String, Any)*) = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

    val newEntity = LFSequencingLocalServiceUtil.createLFSequencing()
    newEntity.setPackageID(LiferayCommon.getParameter("packageID", parameters: _*).get)
    newEntity.setActivityID(LiferayCommon.getParameter("activityID", parameters: _*).get)
    newEntity.setSharedId(entity.sharedId.getOrElse(""))
    newEntity.setSharedSequencingIdReference(entity.sharedSequencingIdReference.getOrElse(""))
    newEntity.setCAttemptAttemptProgressChild(entity.onlyCurrentAttemptAttemptProgressForChildren)
    newEntity.setCAttemptObjectiveProgressChild(entity.onlyCurrentAttemptObjectiveProgressForChildren)
    newEntity.setAttemptLimit(entity.attemptLimit)
    newEntity.setDurationLimitInMilliseconds(entity.durationLimitInMilliseconds)
    newEntity.setPreventChildrenActivation(entity.preventChildrenActivation)
    newEntity.setConstrainChoice(entity.constrainChoice)
    LFSequencingLocalServiceUtil.addLFSequencing(newEntity).getId.toInt
  }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def createAndGetID(parameters: (String, Any)*) = throw new UnsupportedOperationException("Not implemented")
}
