package com.arcusys.learn.models

/**
 * Created by Iliya Tryapitsin on 12.03.14.
 */
case class ActivityResponse(
  certificateId: Int,
  activityCount: Int,
  title: String,
  value: Option[Int],
  period: String)
