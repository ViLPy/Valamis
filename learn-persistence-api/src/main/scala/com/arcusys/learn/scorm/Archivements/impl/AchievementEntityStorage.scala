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

//trait AchievementEntityStorage extends AchievementStorage{
//  val STARTS_FROM = 1
//  var internalAchievement = List(
//    Achievement(id = 1,
//      title = "Achievement1",
//      description = "Description1",
//      logo = "/learn-portlet/img/certificate-default.png",
//      activitiesRequired = List(RequiredActivity(1,"com.liferay.portlet.blogs.model.BlogsEntry", 2),RequiredActivity(2,"com.arcusys.learn.scorm.tracking.model.certificating.Certificate", 2))
//    ),
//    Achievement(id = 2,
//      title = "Achievement2",
//      description = "Description2",
//      logo = "/learn-portlet/img/certificate-default.png",
//      activitiesRequired = List(RequiredActivity(3,"com.liferay.portlet.blogs.model.BlogsEntry", 3),RequiredActivity(4,"com.arcusys.learn.scorm.tracking.model.certificating.Certificate", 2))
//    ),
//    Achievement(id = 3,
//      title = "Achievement3",
//      description = "Description3",
//      logo = "/learn-portlet/img/certificate-default.png",
//      activitiesRequired = List(RequiredActivity(5,"com.liferay.portlet.blogs.model.BlogsEntry", 4),RequiredActivity(6,"com.arcusys.learn.scorm.tracking.model.certificating.Certificate", 2))
//    ),
//    Achievement(id = 4,
//      title = "Achievement4",
//      description = "Description4",
//      logo = "/learn-portlet/img/certificate-default.png",
//      activitiesRequired = List(RequiredActivity(7,"com.liferay.portlet.blogs.model.BlogsEntry", 5),RequiredActivity(8,"com.arcusys.learn.scorm.tracking.model.certificating.Certificate", 2))
//    )
//  )
//
//  var achievementActivities = List[AchievementActivity]()
//
//  def getAll: Seq[Achievement] = {
//    internalAchievement
//  }
//
//  def createAndGetID(entity: Achievement): Int = {
//    val maxId = if(internalAchievement.isEmpty) STARTS_FROM
//    else internalAchievement.map(_.id).max + 1
//    val entityWithId = entity.copy(id = maxId)
//    internalAchievement = entityWithId :: internalAchievement
//    maxId
//  }
//
//  def deleteById(id: Int) = {
//    internalAchievement = internalAchievement.filterNot(achievementType => achievementType.id == id)
//  }
//
//  def modify(entity: Achievement) {
//    deleteById(entity.id)
//    internalAchievement = entity :: internalAchievement
//  }
//
//  def getByID(id: Long): Option[Achievement] = {
//    val t = internalAchievement.filter(achievementType => achievementType.id == id)
//    if(t.isEmpty) None else Some(t(0))
//  }
//
//  def getAchievementActivitiesByUserId(userId: Long) = {
//    achievementActivities.filter(_.userId == userId)
//  }
//
//  def createAndGetIDAchievementActivity(entity: AchievementActivity) = {
//    val maxId = if(achievementActivities.isEmpty) STARTS_FROM
//    else achievementActivities.map(_.id).max + 1
//    val entityWithId = entity.copy(id = maxId)
//    achievementActivities = entityWithId :: achievementActivities
//    maxId
//  }
//
//  def deleteAchievementActivityById(id: Int){
//    achievementActivities = achievementActivities.filterNot(achievementActivity => achievementActivity.id == id)
//  }
//
//  def deleteUserAchievementActivities(userId: Long){
//    achievementActivities = achievementActivities.filterNot(achievementActivity => achievementActivity.userId == userId)
//  }
//
//  def getAchievementActivityById(id: Long) = {
//    val filteredResult = achievementActivities.filter(_.id == id.toInt)
//    if(filteredResult.isEmpty) None
//    else Some(filteredResult(0))
//  }
//
//  def updateRequiredActivity(entity: RequiredActivity){
//    val achievementWithRequiredActivity = internalAchievement.filter(_.activitiesRequired.map(_.id).contains(entity.id))(0)
//
//    val activitiesRequired = entity :: achievementWithRequiredActivity.activitiesRequired.filterNot(_.id == entity.id).toList
//    val result = achievementWithRequiredActivity.copy(activitiesRequired = activitiesRequired)
//
//    internalAchievement = result :: internalAchievement.filterNot(_ == achievementWithRequiredActivity)
//  }
//
//  def addRequiredActivity(achievement: Achievement, entity: RequiredActivity) = {
//    val temp = internalAchievement.flatMap(_.activitiesRequired.map(_.id)).max + 1
//    val achievement_internal = internalAchievement.filter(_.id == achievement.id)(0)
//    val result = achievement_internal.copy(activitiesRequired = entity.copy(id = temp) :: achievement_internal.activitiesRequired.toList)
//    internalAchievement = result :: internalAchievement.filterNot(_ == achievement_internal)
//    result.id
//  }
//
//  def deleteRequiredActivity(id: Int){
//    val achievementWithRequiredActivity = internalAchievement.filter(_.activitiesRequired.map(_.id).contains(id))(0)
//    val activitiesRequired = achievementWithRequiredActivity.activitiesRequired.filterNot(_.id == id)
//    val result = achievementWithRequiredActivity.copy(activitiesRequired = activitiesRequired)
//
//    internalAchievement = result :: internalAchievement.filterNot(_ == achievementWithRequiredActivity)
//  }
//}