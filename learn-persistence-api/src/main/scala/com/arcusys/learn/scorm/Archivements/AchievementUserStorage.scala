package com.arcusys.learn.scorm.Archivements

import com.arcusys.learn.scorm.tracking.model.achivements.AchievementUser

trait AchievementUserStorage {
  def createAndGetIDAchievementUser(entity: AchievementUser): Int
  def getUserSubscribedAchievements(userId: Int): Seq[AchievementUser]
  def getByAchievementId(achievementId: Int): Seq[AchievementUser]
  def update(entity: AchievementUser)
  def deleteById(id: Int)
  def deleteByAchievementId(id: Int)
  def renew()
}
