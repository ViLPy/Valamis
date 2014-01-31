package com.arcusys.learn.achievements

import com.liferay.portal.model.BaseModelListener
import com.liferay.portlet.social.model.SocialActivity
import com.arcusys.learn.ioc.Configuration
import com.liferay.portal.service.ClassNameLocalServiceUtil
import com.arcusys.learn.scorm.tracking.model.achivements.{RequiredActivity, Achievement, AchievementActivity}
import com.liferay.portlet.social.service.SocialActivityLocalServiceUtil
import com.liferay.portal.kernel.dao.orm.QueryUtil._
import com.liferay.portal.kernel.util.StringPool
import scala.collection.JavaConverters._
import com.arcusys.scorm.lms.{AchievementActivityServiceBL, AchievementServiceBL}
import com.escalatesoft.subcut.inject.Injectable

object ActivityListener{ // Needed to getLog
  def containsAllRequiredActivities(activitiesRequired: Seq[RequiredActivity], userActivities: Seq[SocialActivity]) = {
    if(activitiesRequired.isEmpty) false
    else activitiesRequired.find(requirement => requirement.numberActivitiesRequired > userActivities.count(_.getClassName == requirement.activityClassName)).isEmpty
  }
}

//TODO move to BL Layer
class ActivityListener extends BaseModelListener[SocialActivity] with Injectable{
  import ActivityListener.containsAllRequiredActivities
  implicit val bindingModule = Configuration

  val achievementServiceBL = new AchievementServiceBL
  val achievementActivityServiceBL = new AchievementActivityServiceBL

  ClassNameLocalServiceUtil.getClassNameId(classOf[AchievementActivity].getName)

  override def onAfterCreate(socialActivity: SocialActivity){
    if(socialActivity.getClassName == classOf[AchievementActivity].getName)
      return
    val userId = socialActivity.getUserId
    val allUserActivities = SocialActivityLocalServiceUtil.getUserActivities(userId,ALL_POS, ALL_POS).asScala

    val userSubscribedAchievements = achievementServiceBL.getUserSubscribedAchievements(userId.toInt)

    val currentUserAchievements = userSubscribedAchievements.filter(achievement => {
      val requiredActivities = achievementServiceBL.getRequiredAchievementActivities(achievement.id)
      val userActivitiesAfterStartTime = allUserActivities.filter(_.getCreateDate > achievement.startDate.getTime)
      containsAllRequiredActivities(requiredActivities, userActivitiesAfterStartTime)
    })
    val currentUserAchievementIds = currentUserAchievements.map(_.id)

    val previousUserAchievements = achievementServiceBL.getCompletedByUserId(userId.toInt)

    val previousUserAchievementIds = previousUserAchievements.map(_.achievementId)

    currentUserAchievementIds.foreach(achievementId => if(!previousUserAchievementIds.contains(achievementId)){
      val newActivityAchievementId = achievementActivityServiceBL.createAndGetId(AchievementActivity(-1, userId.toInt, achievementId))
      SocialActivityLocalServiceUtil.addActivity(userId, socialActivity.getGroupId, classOf[AchievementActivity].getName, newActivityAchievementId, AchievementActivity.PassedAchievement.id, StringPool.BLANK, 0)
    })
  }
}
