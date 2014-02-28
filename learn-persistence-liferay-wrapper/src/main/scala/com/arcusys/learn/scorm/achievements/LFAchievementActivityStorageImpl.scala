package com.arcusys.learn.scorm.achievements

import com.arcusys.learn.scorm.tracking.model.achivements.AchievementActivity
import com.arcusys.learn.persistence.liferay.model.LFAchievementActivity
import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.persistence.liferay.service.LFAchievementActivityLocalServiceUtil
import scala.collection.JavaConverters._

trait LFAchievementActivityStorageImpl extends KeyedEntityStorage[AchievementActivity]{
  def renew{
    LFAchievementActivityLocalServiceUtil.removeAll
  }
  private def convert(lfAchievementActivity : LFAchievementActivity) : AchievementActivity = AchievementActivity(
    lfAchievementActivity.getId.toInt,
    lfAchievementActivity.getUserId.toInt,
    lfAchievementActivity.getAchievementId.toInt
  )

  def getAll(parameters: (String, Any)*): Seq[AchievementActivity] = (parameters match{
    case Seq(("achievementId", achievementId: Int)) => LFAchievementActivityLocalServiceUtil.findByAchievementId(achievementId)
    case Seq(("userId", userId: Int)) => LFAchievementActivityLocalServiceUtil.findByUserId(userId)
    case Seq(("userId", userId: Int),("achievementId", achievementId: Int)) => LFAchievementActivityLocalServiceUtil.findAllByAchievementAndUserId(achievementId, userId)
    case _ => LFAchievementActivityLocalServiceUtil.findAll()
  }).asScala.map(convert).toSeq

  def createAndGetID(entity: AchievementActivity, parameters: (String, Any)*): Int =
    LFAchievementActivityLocalServiceUtil.createLFAchievementActivity(entity.userId.toInt, entity.achievementId).getId.toInt

  def modify(entity: AchievementActivity, parameters: (String, Any)*) {
    val lfEntity = LFAchievementActivityLocalServiceUtil.getLFAchievementActivity(entity.id.toLong)
    lfEntity.setUserId(entity.userId.toInt)
    lfEntity.setAchievementId(entity.achievementId)
    LFAchievementActivityLocalServiceUtil.updateLFAchievementActivity(lfEntity)
  }

  def delete(parameters: (String, Any)*) {
    parameters match {
      case Seq(("id", id:Int)) => LFAchievementActivityLocalServiceUtil.deleteLFAchievementActivity(id)
      case Seq(("userId", userId: Int)) => LFAchievementActivityLocalServiceUtil.findByUserId(userId).asScala.foreach(achievementActivity => LFAchievementActivityLocalServiceUtil.deleteLFAchievementActivity(achievementActivity.getId))
    }
  }

  def getByID(id: Int, parameters: (String, Any)*) = Option(LFAchievementActivityLocalServiceUtil.getLFAchievementActivity(id)) map convert

  def getOne(parameters: (String, Any)*): Option[AchievementActivity] = throw new UnsupportedOperationException
  def getOne(sqlKey: String, parameters: (String, Any)*): Option[AchievementActivity]= throw new UnsupportedOperationException()

  def createAndGetID(parameters: (String, Any)*): Int = throw new UnsupportedOperationException()
  def create(parameters: (String, Any)*) = throw new UnsupportedOperationException()
  def create(entity: AchievementActivity, parameters: (String, Any)*) = throw new UnsupportedOperationException()

  def modify(parameters: (String, Any)*)= throw new UnsupportedOperationException()
  def modify(sqlKey: String, parameters: (String, Any)*)= throw new UnsupportedOperationException()

  def execute(sqlKey: String, parameters: (String, Any)*)= throw new UnsupportedOperationException()
  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[AchievementActivity]= throw new UnsupportedOperationException()
}
