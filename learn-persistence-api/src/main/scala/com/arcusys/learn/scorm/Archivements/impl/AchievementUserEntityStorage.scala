package com.arcusys.learn.scorm.Archivements.impl

import com.arcusys.learn.scorm.Archivements.AchievementUserStorage
import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.scorm.tracking.model.achivements.AchievementUser

trait AchievementUserEntityStorage extends AchievementUserStorage with KeyedEntityStorage[AchievementUser] {
  def createAndGetIDAchievementUser(entity: AchievementUser): Int = createAndGetID(entity, Nil: _*)
  def getUserSubscribedAchievements(userId: Int): Seq[AchievementUser] = getAll(("userId", userId))
  def getByAchievementId(achievementId: Int): Seq[AchievementUser] = getAll(("achievementId", achievementId))
  def update(entity: AchievementUser) = modify(entity, Nil: _*)
  def deleteById(id: Int) = delete(("id", id))
  def deleteByAchievementId(achievementId: Int){
    val achievementUsersToBeDeleted = getByAchievementId(achievementId)
    achievementUsersToBeDeleted.foreach(achievementUser => deleteById(achievementUser.id))
  }
}
