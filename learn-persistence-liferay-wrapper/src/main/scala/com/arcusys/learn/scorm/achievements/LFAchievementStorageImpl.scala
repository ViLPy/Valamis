package com.arcusys.learn.scorm.achievements

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.scorm.tracking.model.achivements.Achievement

import com.arcusys.learn.persistence.liferay.model.LFAchievement
import scala.collection.JavaConverters._
import com.arcusys.learn.persistence.liferay.service.LFAchievementLocalServiceUtil

trait LFAchievementStorageImpl extends KeyedEntityStorage[Achievement]{
  def renew{
    LFAchievementLocalServiceUtil.removeAll
  }

  private def convert(lfAchievement : LFAchievement) : Achievement = Achievement(
    lfAchievement.getId.toInt,
    lfAchievement.getTitle,
    lfAchievement.getDescription,
    lfAchievement.getLogo,
    lfAchievement.getCreationDate
  )

  def getByID(id: Int, parameters: (String, Any)*): Option[Achievement] = Option(LFAchievementLocalServiceUtil.getLFAchievement(id)) map convert

  def getAll(parameters: (String, Any)*): Seq[Achievement] = LFAchievementLocalServiceUtil.findAll().asScala.map(convert).toSeq

  def delete(parameters: (String, Any)*) { parameters match {
      case Seq(("id", (id : Int))
      ) => LFAchievementLocalServiceUtil.deleteLFAchievement(id.toLong)
    }
  }

  def createAndGetID(entity: Achievement, parameters: (String, Any)*): Int = LFAchievementLocalServiceUtil.createLFAchievement(entity.title, entity.description, entity.logo, entity.startDate).getId.toInt

  def modify(entity: Achievement, parameters: (String, Any)*) {
        val lfEntity = LFAchievementLocalServiceUtil.getLFAchievement(entity.id.toLong)
        lfEntity.setTitle(entity.title)
        lfEntity.setDescription(entity.description)
        lfEntity.setLogo(entity.logo)
        lfEntity.setCreationDate(entity.startDate)
        LFAchievementLocalServiceUtil.updateLFAchievement(lfEntity)
  }

  def getOne(parameters: (String, Any)*): Option[Achievement] = throw new UnsupportedOperationException
  def getOne(sqlKey: String, parameters: (String, Any)*): Option[Achievement]= throw new UnsupportedOperationException()

  def createAndGetID(parameters: (String, Any)*): Int = throw new UnsupportedOperationException()
  def create(parameters: (String, Any)*) = throw new UnsupportedOperationException()
  def create(entity: Achievement, parameters: (String, Any)*) = throw new UnsupportedOperationException()

  def modify(parameters: (String, Any)*)= throw new UnsupportedOperationException()
  def modify(sqlKey: String, parameters: (String, Any)*)= throw new UnsupportedOperationException()

  def execute(sqlKey: String, parameters: (String, Any)*)= throw new UnsupportedOperationException()
  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[Achievement]= throw new UnsupportedOperationException()
}
