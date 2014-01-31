package com.arcusys.learn.scorm.Archivements

import com.arcusys.learn.scorm.tracking.model.achivements.AchievementActivity

trait AchievementActivityStorage {
  def getByID(id: Int): Option[AchievementActivity]
  def getByUserId(userId: Long): Seq[AchievementActivity]
  def getByAchievementId(achievementId: Int): Seq[AchievementActivity]
  def getByAchievementAndUserIds(achievementId: Int, userId: Int): Seq[AchievementActivity]
  def createAndGetID(entity: AchievementActivity): Int
  def deleteById(id: Int)
  def modify(entity: AchievementActivity)
}
