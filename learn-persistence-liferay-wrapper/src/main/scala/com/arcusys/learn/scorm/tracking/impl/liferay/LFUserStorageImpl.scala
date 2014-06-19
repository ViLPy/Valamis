package com.arcusys.learn.scorm.tracking.impl.liferay

import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.scorm.tracking.model.User
import com.arcusys.learn.persistence.liferay.service.{ LFAttemptLocalServiceUtil, LFUserLocalServiceUtil }
import com.arcusys.learn.persistence.liferay.model.LFUser
import scala.collection.JavaConverters._

/**
 * User: Yulia.Glushonkova
 * Date: 28.03.13
 */
trait LFUserStorageImpl extends EntityStorage[User] {
  protected def doRenew() {
    LFUserLocalServiceUtil.removeAll()
    create(new User(-1, "Guest", 0, "en", 0, 0))
  }

  def getOne(parameters: (String, Any)*) = {
    parameters match {
      case Seq(("id", value: Int)) => {
        try {
          val lf = LFUserLocalServiceUtil.findByUserId(value)
          Option(lf).map(extract)
        } catch {
          case _ => None
        }
      }
    }
  }

  def extract(lfEntity: LFUser) =
    if (lfEntity == null) null
    else User(lfEntity.getId, lfEntity.getName)

  def getAll(parameters: (String, Any)*) = {
    LFUserLocalServiceUtil.getLFUsers(-1, -1).asScala.map(extract)
  }
  def create(parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }
  def create(entity: User, parameters: (String, Any)*) {
    doUpdate(entity, LFUserLocalServiceUtil.createLFUser(), LFUserLocalServiceUtil.addLFUser(_))
  }
  def delete(parameters: (String, Any)*) {
    parameters match {
      case Seq(("id", value: Int)) => { LFUserLocalServiceUtil.removeByUserId(value) }
    }
  }
  def modify(parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }
  def modify(entity: User, parameters: (String, Any)*) {
    doUpdate(entity, LFUserLocalServiceUtil.findByUserId(entity.id), LFUserLocalServiceUtil.updateLFUser(_))
  }

  def doUpdate(entity: User, newEntity: LFUser, updateFunction: (LFUser) => LFUser): LFUser = {
    newEntity.setId(entity.id)
    newEntity.setName(entity.name)
    newEntity.setPreferredAudioLevel(entity.preferredAudioLevel)
    newEntity.setPreferredLanguage(entity.preferredLanguage)
    newEntity.setPreferredAudioCaptioning(entity.preferredAudioCaptioning)
    newEntity.setPreferredDeliverySpeed(entity.preferredDeliverySpeed)

    updateFunction(newEntity)
  }

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[User] = {
    if (sqlKey.equalsIgnoreCase("_users")) {
      parameters match {
        case Seq(("packageID", packageID: Int)) => {
          val userIDs = LFAttemptLocalServiceUtil.findByPackageID(packageID).asScala.map(_.getUserID).toArray
          LFUserLocalServiceUtil.findByUserIds(userIDs).asScala.map(extract)
        }
        case _ => {
          val userIDs = LFAttemptLocalServiceUtil.getLFAttempts(-1, -1).asScala.map(_.getUserID).toArray
          if (userIDs.length == 0) Nil else
            LFUserLocalServiceUtil.findByUserIds(userIDs).asScala.map(extract)
        }
      }
    } else {
      Nil
    }
  }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }
}
