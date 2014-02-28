package com.arcusys.learn.scorm.achievements

import com.arcusys.learn.scorm.tracking.model.achivements.AchievementUser
import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.persistence.liferay.service.LFAchievementUserLocalServiceUtil
import com.arcusys.learn.persistence.liferay.model.LFAchievementUser
import scala.collection.JavaConverters._

trait LFAchievementUserStorageImpl extends KeyedEntityStorage[AchievementUser]{
  def renew{
    LFAchievementUserLocalServiceUtil.removeAll
  }
  private def convert(lfAchievementUser: LFAchievementUser) : AchievementUser = AchievementUser(
    lfAchievementUser.getId.toInt,
    lfAchievementUser.getUserId.toInt,
    lfAchievementUser.getAchievementId.toInt
  )

  def getAll(parameters: (String, Any)*): Seq[AchievementUser] = (parameters match{
    case Seq(("userId", userId: Int)) => LFAchievementUserLocalServiceUtil.findByUserId(userId)
    case Seq(("achievementId", id: Int)) => LFAchievementUserLocalServiceUtil.findByAchievementId(id)
  }).asScala.map(convert).toSeq

  def createAndGetID(entity: AchievementUser, parameters: (String, Any)*): Int =
    LFAchievementUserLocalServiceUtil.createLFAchievementUser(entity.userId, entity.achievementId).getId.toInt

  def modify(entity: AchievementUser, parameters: (String, Any)*) {
    val lfEntity = LFAchievementUserLocalServiceUtil.getLFAchievementUser(entity.id.toLong)
    lfEntity.setAchievementId(entity.achievementId)
    lfEntity.setUserId(entity.userId)
    LFAchievementUserLocalServiceUtil.updateLFAchievementUser(lfEntity)
  }

  def delete(parameters: (String, Any)*) {
    parameters match {
      case Seq(("id", id:Int)) => LFAchievementUserLocalServiceUtil.deleteLFAchievementUser(id)
    }
  }

  def getByID(id: Int, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(parameters: (String, Any)*): Option[AchievementUser] = throw new UnsupportedOperationException
  def getOne(sqlKey: String, parameters: (String, Any)*): Option[AchievementUser]= throw new UnsupportedOperationException()

  def createAndGetID(parameters: (String, Any)*): Int = throw new UnsupportedOperationException()
  def create(parameters: (String, Any)*) = throw new UnsupportedOperationException()
  def create(entity: AchievementUser, parameters: (String, Any)*) = throw new UnsupportedOperationException()

  def modify(parameters: (String, Any)*)= throw new UnsupportedOperationException()
  def modify(sqlKey: String, parameters: (String, Any)*)= throw new UnsupportedOperationException()

  def execute(sqlKey: String, parameters: (String, Any)*)= throw new UnsupportedOperationException()
  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[AchievementUser]= throw new UnsupportedOperationException()
}
