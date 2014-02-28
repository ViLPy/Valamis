package com.arcusys.scorm.lms

import com.arcusys.learn.scorm.tracking.model.achivements.{AchievementUser, RequiredActivity, AchievementActivity, Achievement}
import com.arcusys.scorm.lms.models.{AchievementRequiredActivityModel, AchievementModelBL}
import com.arcusys.learn.scorm.Archivements.{AchievementUserStorage, AchievementActivityStorage, AchievementRequiredStorage, AchievementStorage}
import com.arcusys.scorm.lms.exceptions.AchievementNotFoundException
import java.util.Date
import com.arcusys.learn.liferay.constants.QueryUtilHelper.ALL_POS
import scala.collection.JavaConverters._
import com.escalatesoft.subcut.inject.{Injectable, BindingModule}
import com.arcusys.learn.liferay.services.{UserLocalServiceHelper, SocialActivityLocalServiceHelper}
import com.arcusys.learn.liferay.LiferayClasses.LUser
import com.liferay.portal.model.User
import com.liferay.portal.NoSuchUserException

/**
 * Created with IntelliJ IDEA.
 * User: iliya.tryapitsin
 * Date: 09.01.14
 * Time: 17:30
 * To change this template use File | Settings | File Templates.
 */
class AchievementRepository(implicit val bindingModule: BindingModule) extends AchievementRepositoryContract with Injectable {

  val achievementStorage = inject[AchievementStorage]
  val achievementRequiredStorage = inject[AchievementRequiredStorage]
  val achievementActivityStorage = inject[AchievementActivityStorage]
  val achievementUserStorage = inject[AchievementUserStorage]

  def create(): AchievementModelBL = {
    val achievement = Achievement()
    val id = achievementStorage.createAndGetID(achievement)
    achievement.copy(id = id)

    AchievementModelBL(
      id,
      achievement.title,
      achievement.description,
      achievement.logo,
      achievement.startDate.getTime,
      false,
      List.empty[AchievementRequiredActivityModel],
      List.empty[LUser])
  }

  def get(page: Int,
          filter: Option[String],
          sortDirection: Boolean,
          countOnPage: Int,
          companyId: Int): List[AchievementModelBL] = {


    var achievements = achievementStorage.getAllAchievements

    achievements = achievements.filter(x => x.title.toLowerCase.contains(filter.getOrElse("").toLowerCase))

    achievements = if (sortDirection)
      achievements
        .sortBy(_.title.toLowerCase)
    else
      achievements
        .sortBy(_.title.toLowerCase)
        .reverse

    achievements
      .drop((page - 1) * countOnPage)
      .take(countOnPage)
      .map(a => AchievementModelBL(
        a.id,
        a.title,
        a.description,
        a.logo,
        a.startDate.getTime,
        false,
        this.getActivities(a.id),
        this.getUsers(a.id, companyId)))
      .toList
  }

  def get(id: Int) = achievementStorage
    .getByID(id)
    .getOrElse(throw new AchievementNotFoundException("Achievement id is " + id))

  def getCount = achievementStorage.getAllAchievements.size

  def modify(achievement: Achievement) {
    achievementStorage.modify(achievement)
  }

  def modify(id: Int,
             title: String,
             description: String,
             logo: String,
             startDate: Date): Boolean = {
    val achievement = achievementStorage.getByID(id)

    if (achievement.isDefined) {
      val newAchievement = achievement.get.copy(
        title = title,
        description = description,
        logo = logo,
        startDate = startDate)

      achievementStorage.modify(newAchievement)
    }

    achievement.isDefined
  }

  def delete(id: Int): Boolean = {
    achievementRequiredStorage.deleteRequiredActivitiesByAchievementId(id)
    achievementUserStorage.deleteByAchievementId(id)
    achievementStorage.deleteById(id)

    val achievementActivities = achievementActivityStorage.getByAchievementId(id)
    achievementActivities.foreach(achievementActivity => {
      // Remove activities
      val activities = SocialActivityLocalServiceHelper.getSocialActivities(ALL_POS,ALL_POS).asScala
        .filter(x => (x.getClassName == classOf[AchievementActivity].getCanonicalName) && (x.getClassPK == achievementActivity.id))
      activities.foreach(activity => SocialActivityLocalServiceHelper.deleteActivity(activity.getActivityId))

      // Remove AchievementActivity
      achievementActivityStorage.deleteById(achievementActivity.id)
    })

    true
  }

  def getActivities(achievementId: Int): List[AchievementRequiredActivityModel] = {
    achievementRequiredStorage
      .getRequiredAchievementActivities(achievementId)
      .map(a => AchievementRequiredActivityModel(
        a.id,
        a.activityClassName,
        a.numberActivitiesRequired))
      .toList
  }

  def getForUser(userId: Int,
                 companyId: Int): List[AchievementModelBL] = {
    achievementUserStorage
      .getUserSubscribedAchievements(userId)
      .map(achievementUser => achievementStorage.getByID(achievementUser.achievementId)
         .getOrElse(throw new IllegalStateException("InconsistentDB")))
      .map(a => AchievementModelBL(
        a.id,
        a.title,
        a.description,
        a.logo,
        a.startDate.getTime,
        this.getIfCompleted(a.id, userId),
        this.getActivities(a.id),
        this.getUsers(a.id, companyId)))
      .toList
  }

  def getIfCompleted(achievementId: Int,
                     userId: Int): Boolean =
    achievementActivityStorage
      .getByAchievementAndUserIds(achievementId, userId)
      .size == 1

  def addActivity(achievementId: Int,
                  className: String):AchievementRequiredActivityModel = {

    val activity: RequiredActivity = RequiredActivity(
      achievementId = achievementId,
      activityClassName = className,
      numberActivitiesRequired = 1)

    val id = achievementRequiredStorage.addRequiredActivity(activity)

    AchievementRequiredActivityModel(
      id,
      className,
      activity.numberActivitiesRequired)
  }

  def removeActivity(activityId: Int) =
    achievementRequiredStorage.deleteRequiredActivity(activityId)

  def updateActivity(activityId: Int,
                     achievementId: Int,
                     achievementCount: Int) = {
    val activity = achievementRequiredStorage
      .getRequiredAchievementActivities(achievementId)
      .filter(activity => activity.id == activityId)
      .head

    val changedActivity = activity.copy(numberActivitiesRequired = achievementCount)

    achievementRequiredStorage.updateRequiredActivity(changedActivity)
  }

  def getUsers(achievementId: Int,
               companyId: Int):
  List[LUser] = {
    achievementUserStorage
      .getByAchievementId(achievementId)

      //Filter if an error occurs => user was removed from liferay database => remove from valamis database.
      .filter(user => try {
      UserLocalServiceHelper.getUserById(companyId,user.userId)
        true
      } catch {
        case e:NoSuchUserException => {
          achievementUserStorage.deleteById(user.id)
          false
        }
      })
      .map(u => u.userId)
      .distinct
      .map(userId =>
        UserLocalServiceHelper
          .getUserById(companyId,userId)
      ).toList
  }

  def applyAchievementForUser(userId: Int, achievementId: Int) {
    val achievementUser = AchievementUser(
      id = -1,
      userId = userId,
      achievementId = achievementId)

    achievementUserStorage.createAndGetIDAchievementUser(achievementUser)
  }

  def removeAchievementForUser(userId: Int, achievementId: Int) {
    val achievementUsers = achievementUserStorage.getUserSubscribedAchievements(userId)

    achievementUsers.foreach(achievementUser => {
      if(achievementUser.achievementId == achievementId)
        achievementUserStorage.deleteById(achievementUser.id)
    })
  }
}
