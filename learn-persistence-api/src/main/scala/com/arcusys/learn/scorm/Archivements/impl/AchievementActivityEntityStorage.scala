package com.arcusys.learn.scorm.Archivements.impl

import com.arcusys.learn.scorm.tracking.model.achivements.{Achievement, AchievementActivity}
import com.arcusys.learn.scorm.Archivements.{AchievementActivityStorage, AchievementStorage}
import com.arcusys.learn.storage.impl.KeyedEntityStorage

trait AchievementActivityEntityStorage extends AchievementActivityStorage with KeyedEntityStorage[AchievementActivity] {
  def getByID(id: Int): Option[AchievementActivity] = getByID(id, Nil: _*)
  def getByAchievementId(achievementId: Int): Seq[AchievementActivity] = getAll("achievementId" -> achievementId)
  def getByUserId(userId: Int): Seq[AchievementActivity] = getAll("userId" -> userId)
  def getByAchievementAndUserIds(achievementId: Int, userId: Int) = getAll("userId" -> userId, "achievementId" -> achievementId)

  def createAndGetID(entity: AchievementActivity): Int = createAndGetID(entity, Nil: _*)
  def deleteById(id: Int) = delete("id" -> id)
  def deleteByUserId(userId: Long) = delete("userId" -> userId)
  def getAchievementActivityById(id: Int): Option[AchievementActivity] = getByID(id, Nil: _*)
  def modify(entity: AchievementActivity) = modify(entity, Nil: _*)
}
