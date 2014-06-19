package com.arcusys.scorm.lms.models

/**
 * Created by iliya.tryapitsin on 14.01.14.
 */
case class AchievementRequiredActivityModel(
  id: Int,
  name: String,
  requiredCount: Int) extends Activity
