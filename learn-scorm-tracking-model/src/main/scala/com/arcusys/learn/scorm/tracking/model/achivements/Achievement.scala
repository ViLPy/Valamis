package com.arcusys.learn.scorm.tracking.model.achivements

import org.joda.time.DateTime

object AchievementActivity extends Enumeration {
  type CertificateActionType = Value
  val PassedAchievement = Value(1)
  val NewAchievement = Value(2)
}
/**
 * Archivements to be accomplished by user:
 *
 * @param id                  Unique internal ID
 * @param title               Short title
 * @param logo                Archivements picture
 * @param description         More detailed description
 */

// Achievement
case class Achievement(
  id: Int = -1,
  title: String = "New achievement",
  description: String = "Achievement info",
  logo: String = "/learn-portlet/img/certificate-default.png",
  startDate: DateTime = new DateTime)

// Activities required to complete achievement
case class RequiredActivity(
  id: Int = -1,
  achievementId: Int,
  activityClassName: String = "",
  numberActivitiesRequired: Int = 0)

// Achievement completed
case class AchievementActivity(
  id: Int,
  userId: Int,
  achievementId: Int)

// Class for users, who want to participate in Achievement
case class AchievementUser(
  id: Int = -1,
  userId: Int,
  achievementId: Int)
