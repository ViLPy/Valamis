package com.arcusys.learn.models

import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.scorm.lms.models
import com.arcusys.scorm.lms.models.{ AchievementRequiredActivityModel, ActivityModelBL }

object Lms2PortletConverters {
  implicit def toUserModel(user: LUser): UserModel = {
    UserModel(
      user.getUserId,
      user.getFullName,
      "/image/user_male_portrait?img_id=%s".format(user.getUserId),
      user.getEmailAddress
    )
  }

  implicit def toUserModels(users: List[LUser]): List[UserModel] =
    for (user <- users)
      yield user: UserModel

  implicit def toAchievementModels(achievements: List[models.AchievementModelBL]): List[AchievementModel] =
    for (achievement <- achievements)
      yield achievement: AchievementModel

  implicit def toAchievementModel(achievement: models.AchievementModelBL): AchievementModel =
    AchievementModel(
      achievement.id,
      achievement.title,
      achievement.description.replaceAll("\n", " "),
      achievement.logo,
      achievement.startDate,
      achievement.completed,
      achievement.activities.map(a => a: AchievementActivityModel),
      achievement.users
    )

  implicit def toActivityModel(activity: ActivityModelBL): ActivityModel =
    ActivityModel(activity.name, "")

  implicit def toAchievementActivityModel(achActivity: AchievementRequiredActivityModel): AchievementActivityModel =
    AchievementActivityModel(
      achActivity.id,
      achActivity.name,
      "",
      achActivity.requiredCount)

  implicit def toAchievementActivityModels(achActivities: List[AchievementRequiredActivityModel]): List[AchievementActivityModel] =
    for (achievementRequiredActivity <- achActivities)
      yield achievementRequiredActivity: AchievementActivityModel
}
