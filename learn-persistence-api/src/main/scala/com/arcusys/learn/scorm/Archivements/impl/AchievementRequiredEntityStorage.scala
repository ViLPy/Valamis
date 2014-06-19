package com.arcusys.learn.scorm.Archivements.impl

import com.arcusys.learn.scorm.tracking.model.achivements.RequiredActivity
import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.scorm.Archivements.AchievementRequiredStorage

trait AchievementRequiredEntityStorage extends AchievementRequiredStorage with KeyedEntityStorage[RequiredActivity] {
  def getRequiredAchievementActivities(achievementId: Int) = getAll(("achievementId", achievementId))
  def deleteRequiredActivity(id: Int) = delete(("id", id))
  def deleteRequiredActivitiesByAchievementId(achievementId: Int) {
    val requiredActivitiesToBeDeleted = getRequiredAchievementActivities(achievementId)
    requiredActivitiesToBeDeleted.foreach(requiredActivity => deleteRequiredActivity(requiredActivity.id))
  }
  def addRequiredActivity(entity: RequiredActivity): Int = createAndGetID(entity)
  def updateRequiredActivity(entity: RequiredActivity) = modify(entity, Nil: _*)
}
