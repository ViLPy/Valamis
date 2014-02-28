package com.arcusys.learn.scorm.Archivements.impl

import com.arcusys.learn.scorm.Archivements.AchievementStorage
import com.arcusys.learn.scorm.tracking.model.achivements.{Achievement, AchievementActivity, RequiredActivity}
import com.arcusys.learn.scorm.tracking.model.achivements.Achievement
import com.arcusys.learn.storage.impl.{EntityStorageExt, KeyedEntityStorage, EntityStorage}

trait AchievementEntityStorage extends AchievementStorage with KeyedEntityStorage[Achievement] {//with EntityStorageExt[Achievement]{
  def getAllAchievements: Seq[Achievement] = getAll()
  def getByID(id: Int): Option[Achievement] = getByID(id, Nil: _*)

  def createAndGetID(entity: Achievement): Int = createAndGetID(entity, Nil: _*)

  def deleteById(id: Int) = delete("id"-> id)

  def modify(entity: Achievement) = modify(entity, Nil: _*)

  def saveLogo(id: Int, logo: String) {
    modify("id" -> id, "logo" -> logo)
  }
}