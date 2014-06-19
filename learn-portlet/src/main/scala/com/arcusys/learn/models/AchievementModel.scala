package com.arcusys.learn.models

@deprecated
case class AchievementModel(
  id: Int,
  title: String,
  description: String,
  logo: String,
  startDate: Long,
  completed: Boolean,
  activities: List[AchievementActivityModel],
  users: List[UserModel])