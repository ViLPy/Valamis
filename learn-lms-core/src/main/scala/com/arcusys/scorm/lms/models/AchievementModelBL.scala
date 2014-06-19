package com.arcusys.scorm.lms.models

import com.arcusys.learn.liferay.LiferayClasses._

/**
 * Created by iliya.tryapitsin on 14.01.14.
 */
case class AchievementModelBL(
  id: Int,
  title: String,
  description: String,
  logo: String,
  startDate: Long,
  completed: Boolean,
  activities: List[AchievementRequiredActivityModel],
  users: List[LUser])