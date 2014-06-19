package com.arcusys.learn.scorm.Archivements

import com.arcusys.learn.scorm.tracking.model.achivements.Achievement

trait AchievementStorage {
  def getAllAchievements: Seq[Achievement]
  def getByID(id: Int): Option[Achievement]

  def createAndGetID(entity: Achievement): Int
  def deleteById(id: Int)
  def saveLogo(id: Int, logo: String)
  def modify(entity: Achievement)
  def renew()
}
