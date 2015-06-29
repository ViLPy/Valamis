package com.arcusys.learn.scorm.tracking.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFAttempt
import com.arcusys.learn.persistence.liferay.service.LFAttemptLocalServiceUtil
import com.arcusys.learn.scorm.tracking.storage.impl.AttemptFieldsMapper
import com.arcusys.valamis.lesson.scorm.model.tracking.Attempt
import com.arcusys.valamis.lesson.scorm.storage.ScormPackagesStorage
import com.arcusys.valamis.lesson.scorm.storage.tracking.AttemptStorage
import com.arcusys.valamis.user.storage.UserStorage
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

  override def getByID(id: Long): Option[Attempt] = {
    Option(LFAttemptLocalServiceUtil.getLFAttempt(id)).map(extract)
  }

  override def getActive(userID: Int, packageId: Long) = {
    LFAttemptLocalServiceUtil.findByUserIDPackageIDIsComplete(userID, packageId.toInt, false).asScala
      .headOption.map(extract)
  }

  override def getAllComplete(userID: Int, packageId: Long) = {
    LFAttemptLocalServiceUtil.findByUserIDPackageIDIsComplete(userID, packageId.toInt, true).asScala
      .map(extract)
  }

  override def getLast(userID: Int, packageId: Long, complete: Boolean = false) = {
    LFAttemptLocalServiceUtil.findByUserIDPackageIDIsComplete(userID, packageId.toInt, complete).asScala
      .sortWith(_.getId > _.getId).headOption.map(extract)
  }

  override def createAndGetID(userID: Int, packageId: Long, organizationID: String) = {
    val newEntity = LFAttemptLocalServiceUtil.createLFAttempt()
    newEntity.setUserID(userID)
    newEntity.setPackageID(packageId.toInt)
    newEntity.setOrganizationID(organizationID)
    newEntity.setIsComplete(false)

    LFAttemptLocalServiceUtil.addLFAttempt(newEntity).getId
  }

  override def markAsComplete(id: Long) {
    val isComplete = true
    val found = LFAttemptLocalServiceUtil.getLFAttempt(id)
    if (found != null) {
      found.setIsComplete(isComplete)
      LFAttemptLocalServiceUtil.updateLFAttempt(found)
    }
  }

  override def checkIfComplete(userID: Int, packageId: Long) = {
    val attempt = LFAttemptLocalServiceUtil.findByUserIDPackageIDIsComplete(userID, packageId.toInt, true).asScala
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
