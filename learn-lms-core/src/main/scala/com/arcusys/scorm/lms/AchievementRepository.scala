package com.arcusys.scorm.lms

import com.arcusys.learn.scorm.tracking.model.achivements.{AchievementActivity, Achievement}
import com.arcusys.scorm.lms.models.{UserModel, AchievementRequiredActivityModel, AchievementModel}
import com.liferay.portal.service.UserLocalServiceUtil
import com.liferay.portal.kernel.dao.orm.QueryUtil
import com.arcusys.learn.scorm.Archivements.{AchievementUserStorage, AchievementActivityStorage, AchievementRequiredStorage, AchievementStorage}
import com.arcusys.scorm.lms.exceptions.AchievementNotFoundException
import java.util.Date
import com.liferay.portlet.social.service.SocialActivityLocalServiceUtil
import com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS
import scala.collection.JavaConverters._
import com.escalatesoft.subcut.inject.{Injectable, BindingModule}

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

  def create(): AchievementModel = {
    val achievement = Achievement()
    val id = achievementStorage.createAndGetID(achievement)
    achievement.copy(id = id)

    AchievementModel(
      id,
      achievement.title,
      achievement.description,
      achievement.logo,
      achievement.startDate.getTime,
      false,
      List.empty[AchievementRequiredActivityModel],
      List.empty[UserModel])
  }

  def get(page: Int,
          filter: Option[String],
          sortDirection: Boolean,
          countOnPage: Int,
          companyId: Int): List[AchievementModel] = {


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
      .map(a => AchievementModel(
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
      var newAchievement = achievement.get.copy(
        title = title,
        description = description,
        logo = logo,
        startDate = startDate
      )

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
      val activities = SocialActivityLocalServiceUtil.getSocialActivities(ALL_POS,ALL_POS).asScala
        .filter(x => (x.getClassName == classOf[AchievementActivity].getCanonicalName) && (x.getClassPK == achievementActivity.id))
      activities.foreach(activity => SocialActivityLocalServiceUtil.deleteActivity(activity.getActivityId))

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
                 companyId: Int): List[AchievementModel] = {
    achievementUserStorage
      .getUserSubscribedAchievements(userId)
      .map(achievementUser => achievementStorage.getByID(achievementUser.achievementId)
      .getOrElse(throw new IllegalStateException("InconsistentDB")))
      .map(a => AchievementModel(
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

  def getIfCompleted(achievementId: Int, userId: Int): Boolean = achievementActivityStorage.getByAchievementAndUserIds(achievementId, userId).size == 1

  def getUsers(achievementId: Int,
               companyId: Int):
  List[UserModel] = {
    achievementUserStorage
      .getByAchievementId(achievementId)
      .map(u => u.userId)
      .distinct
      .map(userId =>
        UserLocalServiceUtil
          .getCompanyUsers(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS)
          .toArray()
          .map(x => x.asInstanceOf[com.liferay.portal.model.User])
          .find(x => x.getUserId == userId))
      .map(user => user match {
        case Some(value) => UserModel(
          value.getUserId,
          value.getFullName,
          value.getPortraitId)
      })
      .toList
  }
}
