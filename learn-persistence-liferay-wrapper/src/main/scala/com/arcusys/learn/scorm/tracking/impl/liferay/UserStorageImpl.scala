package com.arcusys.learn.scorm.tracking.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFUser
import com.arcusys.learn.persistence.liferay.service.{ LFAttemptLocalServiceUtil, LFUserLocalServiceUtil }
import com.arcusys.learn.scorm.tracking.model.User
import com.arcusys.learn.scorm.tracking.storage.UserStorage
import scala.collection.JavaConverters._
import scala.util.Try

/**
 * Created by mminin on 16.10.14.
 */
class UserStorageImpl extends UserStorage {

  override def renew(): Unit = {
    LFUserLocalServiceUtil.removeAll()
    createAndGetID(new User(-1, "Guest", 0, "en", 0, 0))
  }

  override def getAll: Seq[User] = {
    LFUserLocalServiceUtil.getLFUsers(-1, -1).asScala.map(extract)
  }

  override def modify(user: User): Unit = {
    val lfEntity = LFUserLocalServiceUtil.findByUserId(user.id)

    lfEntity.setId(user.id)
    lfEntity.setName(user.name)
    lfEntity.setPreferredAudioLevel(user.preferredAudioLevel.toDouble)
    lfEntity.setPreferredLanguage(user.preferredLanguage)
    lfEntity.setPreferredAudioCaptioning(user.preferredAudioCaptioning)
    lfEntity.setPreferredDeliverySpeed(user.preferredDeliverySpeed.toDouble)

    LFUserLocalServiceUtil.addLFUser(lfEntity)
  }

  override def getUsersWithAttempts: Seq[User] = {
    val userIDs = LFAttemptLocalServiceUtil.getLFAttempts(-1, -1).asScala.map(_.getUserID).toArray
    if (userIDs.length == 0) Nil else
      LFUserLocalServiceUtil.findByUserIds(userIDs).asScala.map(extract)
  }

  override def getByID(userID: Int): Option[User] = {
    Try(LFUserLocalServiceUtil.findByUserId(userID)).toOption.map(extract)
  }

  override def getUsersWithAttemptsInPackage(packageID: Int): Seq[User] = {
    val userIDs = LFAttemptLocalServiceUtil.findByPackageID(packageID).asScala.map(_.getUserID).toArray
    LFUserLocalServiceUtil.findByUserIds(userIDs).asScala.map(extract)
  }

  override def delete(userID: Int): Unit = {
    LFUserLocalServiceUtil.removeByUserId(userID)
  }

  override def createAndGetID(user: User): Int = {
    val lfEntity = LFUserLocalServiceUtil.createLFUser()

    lfEntity.setId(user.id)
    lfEntity.setName(user.name)
    lfEntity.setPreferredAudioLevel(user.preferredAudioLevel.toDouble)
    lfEntity.setPreferredLanguage(user.preferredLanguage)
    lfEntity.setPreferredAudioCaptioning(user.preferredAudioCaptioning)
    lfEntity.setPreferredDeliverySpeed(user.preferredDeliverySpeed.toDouble)

    LFUserLocalServiceUtil.updateLFUser(lfEntity)
    lfEntity.getId
  }

  def extract(lfEntity: LFUser) =
    if (lfEntity == null) null
    else User(lfEntity.getId, lfEntity.getName)
}
