package com.arcusys.scorm.lms.models

/**
 * Created by iliya.tryapitsin on 14.01.14.
 */
case class AchievementModel (
  id: Int,
  title: String,
  description: String,
  logo: String,
  startDate: Long,
  completed: Boolean,
  activities: List[AchievementRequiredActivityModel],
  users: List[UserModel]
)