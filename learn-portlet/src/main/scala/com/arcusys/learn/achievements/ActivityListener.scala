package com.arcusys.learn.achievements

import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.scorm.tracking.model.achivements.{RequiredActivity, AchievementActivity}
import com.arcusys.learn.liferay.constants.QueryUtilHelper._
import scala.collection.JavaConverters._
import com.arcusys.scorm.lms.{AchievementActivityServiceBL, AchievementServiceBL}
import com.escalatesoft.subcut.inject.Injectable
import com.arcusys.learn.liferay.services.{ClassNameLocalServiceHelper, SocialActivityLocalServiceHelper}
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.constants.StringPoolHelper

object ActivityListener {
  // Needed to getLog
  def containsAllRequiredActivities(activitiesRequired: Seq[RequiredActivity], userActivities: Seq[LSocialActivity]) = {
    if (activitiesRequired.isEmpty) false
    else activitiesRequired.find(requirement => requirement.numberActivitiesRequired > userActivities.count(_.getClassName == requirement.activityClassName)).isEmpty
  }
}

//TODO move to BL Layer
class ActivityListener extends LBaseModelListener[LSocialActivity] with Injectable {

  import ActivityListener.containsAllRequiredActivities

  implicit val bindingModule = Configuration

  val achievementServiceBL = new AchievementServiceBL
  val achievementActivityServiceBL = new AchievementActivityServiceBL

  ClassNameLocalServiceHelper.getClassNameId(classOf[AchievementActivity].getName)

  override def onAfterCreate(socialActivity: LSocialActivity) {
    if (socialActivity.getClassName == classOf[AchievementActivity].getName)
      return
    val userId = socialActivity.getUserId
    val allUserActivities = SocialActivityLocalServiceHelper.getUserActivities(userId, ALL_POS, ALL_POS).asScala

    val userSubscribedAchievements = achievementServiceBL.getUserSubscribedAchievements(userId.toInt)

    val currentUserAchievements = userSubscribedAchievements.filter(achievement => {
      val requiredActivities = achievementServiceBL.getRequiredAchievementActivities(achievement.id)
      val userActivitiesAfterStartTime = allUserActivities.filter(_.getCreateDate > achievement.startDate.getTime)
      containsAllRequiredActivities(requiredActivities, userActivitiesAfterStartTime)
    })
    val currentUserAchievementIds = currentUserAchievements.map(_.id)

    val previousUserAchievements = achievementServiceBL.getCompletedByUserId(userId.toInt)

    val previousUserAchievementIds = previousUserAchievements.map(_.achievementId)

    currentUserAchievementIds.foreach(achievementId => if (!previousUserAchievementIds.contains(achievementId)) {
      val newActivityAchievementId = achievementActivityServiceBL.createAndGetId(AchievementActivity(-1, userId.toInt, achievementId))
      SocialActivityLocalServiceHelper.addActivity(userId, socialActivity.getGroupId, classOf[AchievementActivity].getName, newActivityAchievementId, AchievementActivity.PassedAchievement.id, StringPoolHelper.BLANK, 0)
    })
  }
}
