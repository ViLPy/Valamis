package com.arcusys.learn.models

import com.arcusys.scorm.lms.models.AchievementModel

/**
 * Created by iliya.tryapitsin on 14.01.14.
 */
case class GetAchievementResponseModel(
  page: Int,
  records: List[AchievementModel],
  total: Int)
