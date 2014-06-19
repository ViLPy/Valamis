package com.arcusys.learn.scorm.achievements

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.scorm.tracking.model.achivements.RequiredActivity
import com.arcusys.learn.persistence.liferay.model.{ LFRequiredActivity, LFAchievementActivity }
import com.arcusys.learn.persistence.liferay.service.LFRequiredActivityLocalServiceUtil
import scala.collection.JavaConverters._

trait LFAchievementRequiredStorageImpl extends KeyedEntityStorage[RequiredActivity] {
  def renew {
    LFRequiredActivityLocalServiceUtil.removeAll
  }
  private def convert(lfRequiredActivity: LFRequiredActivity): RequiredActivity = RequiredActivity(
    lfRequiredActivity.getId.toInt,
    lfRequiredActivity.getAchievementId.toInt,
    lfRequiredActivity.getActivityClassName,
    lfRequiredActivity.getNumberActivitiesRequired
  )

  def getAll(parameters: (String, Any)*): Seq[RequiredActivity] = (parameters match {
    case Seq(("achievementId", achievementId: Int)) => LFRequiredActivityLocalServiceUtil.findByAchievementId(achievementId)
    //case _ => LFRequiredActivityLocalServiceUtil.findAll()
  }).asScala.map(convert).toSeq

  def createAndGetID(entity: RequiredActivity, parameters: (String, Any)*): Int =
    LFRequiredActivityLocalServiceUtil.createLFRequiredActivity(entity.achievementId.toInt, entity.activityClassName, entity.numberActivitiesRequired).getId.toInt

  def modify(entity: RequiredActivity, parameters: (String, Any)*) {
    val lfEntity = LFRequiredActivityLocalServiceUtil.getLFRequiredActivity(entity.id.toLong)
    lfEntity.setAchievementId(entity.achievementId)
    lfEntity.setActivityClassName(entity.activityClassName)
    lfEntity.setNumberActivitiesRequired(entity.numberActivitiesRequired)
    LFRequiredActivityLocalServiceUtil.updateLFRequiredActivity(lfEntity)
  }

  def delete(parameters: (String, Any)*) {
    parameters match {
      case Seq(("id", id: Int)) => LFRequiredActivityLocalServiceUtil.deleteLFRequiredActivity(id)
    }
  }

  def getByID(id: Int, parameters: (String, Any)*) = Option(LFRequiredActivityLocalServiceUtil.getLFRequiredActivity(id)) map convert

  def getOne(parameters: (String, Any)*): Option[RequiredActivity] = throw new UnsupportedOperationException
  def getOne(sqlKey: String, parameters: (String, Any)*): Option[RequiredActivity] = throw new UnsupportedOperationException()

  def createAndGetID(parameters: (String, Any)*): Int = throw new UnsupportedOperationException()
  def create(parameters: (String, Any)*) = throw new UnsupportedOperationException()
  def create(entity: RequiredActivity, parameters: (String, Any)*) = throw new UnsupportedOperationException()

  def modify(parameters: (String, Any)*) = throw new UnsupportedOperationException()
  def modify(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException()

  def execute(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException()
  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[RequiredActivity] = throw new UnsupportedOperationException()

}
