package com.arcusys.learn.scorm.tracking.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFAttempt
import com.arcusys.learn.persistence.liferay.service.LFAttemptLocalServiceUtil
import com.arcusys.learn.scorm.manifest.storage.ScormPackagesStorage
import com.arcusys.learn.scorm.tracking.model.Attempt
import com.arcusys.learn.scorm.tracking.storage.impl.AttemptFieldsMapper
import com.arcusys.learn.scorm.tracking.storage.{ UserStorage, AttemptStorage }
import scala.collection.JavaConverters._
/**
 * Created by mminin on 16.10.14.
 */
trait AttemptStorageImpl extends AttemptStorage {

  def userStorage: UserStorage
  def packageStorage: ScormPackagesStorage
  def createAttempt(mapper: AttemptFieldsMapper): Attempt

  override def renew(): Unit = {
    LFAttemptLocalServiceUtil.removeAll()
  }

  override def getByID(id: Int): Option[Attempt] = {
    Option(LFAttemptLocalServiceUtil.getLFAttempt(id)).map(extract)
  }

  override def getActive(userID: Int, packageID: Int) = {
    LFAttemptLocalServiceUtil.findByUserIDPackageIDIsComplete(userID, packageID, false).asScala
      .headOption.map(extract)
  }

  override def getAllComplete(userID: Int, packageID: Int) = {
    LFAttemptLocalServiceUtil.findByUserIDPackageIDIsComplete(userID, packageID, true).asScala
      .map(extract)
  }

  override def getLast(userID: Int, packageID: Int, complete: Boolean = false) = {
    LFAttemptLocalServiceUtil.findByUserIDPackageIDIsComplete(userID, packageID, complete).asScala
      .sortWith(_.getId > _.getId).headOption.map(extract)
  }

  override def createAndGetID(userID: Int, packageID: Int, organizationID: String) = {
    val newEntity = LFAttemptLocalServiceUtil.createLFAttempt()
    newEntity.setUserID(userID)
    newEntity.setPackageID(packageID)
    newEntity.setOrganizationID(organizationID)
    newEntity.setIsComplete(false)

    LFAttemptLocalServiceUtil.addLFAttempt(newEntity).getId.toInt
  }

  override def markAsComplete(id: Int) {
    val isComplete = true
    val found = LFAttemptLocalServiceUtil.getLFAttempt(id)
    if (found != null) {
      found.setIsComplete(isComplete)
      LFAttemptLocalServiceUtil.updateLFAttempt(found)
    }
  }

  override def checkIfComplete(userID: Int, packageID: Int) = {
    val attempt = LFAttemptLocalServiceUtil.findByUserIDPackageIDIsComplete(userID, packageID, true).asScala
      .map(extract)
    !attempt.isEmpty
  }

  def extract(entity: LFAttempt) = {
    val mapper = new AttemptFieldsMapper {
      def id: Int = entity.getId.toInt

      def userID: Int = entity.getUserID

      def packageID: Int = entity.getPackageID

      def organizationID: String = entity.getOrganizationID

      def isComplete: Boolean = entity.getIsComplete
    }
    createAttempt(mapper)
  }
}
