package com.arcusys.learn.scorm.Archivements

import com.arcusys.learn.scorm.tracking.model.achivements.RequiredActivity

trait AchievementRequiredStorage {
    def getRequiredAchievementActivities(achievementId: Int): Seq[RequiredActivity]
    def deleteRequiredActivity(id: Int)
    def deleteRequiredActivitiesByAchievementId(achievementId: Int)
    def addRequiredActivity(entity: RequiredActivity): Int
    def updateRequiredActivity(entity: RequiredActivity)
    def renew()
}
