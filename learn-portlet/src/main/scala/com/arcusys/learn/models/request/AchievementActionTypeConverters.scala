package com.arcusys.learn.models.request

import com.arcusys.learn.models.request.AchievementActionType._

/**
 * Created by Iliya Tryapitsin on 04.03.14.
 */
object AchievementActionTypeConverters {
  implicit def fromString(actionType: String): AchievementActionType = {
    return AchievementActionType.withName(actionType.toUpperCase)
  }
}