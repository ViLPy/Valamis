package com.arcusys.learn.scorm.tracking.model

case class User(id: Int,
  name: String = "",
  preferredAudioLevel: Float = 1,
  preferredLanguage: String = "",
  preferredDeliverySpeed: Float = 1,
  preferredAudioCaptioning: Int = 0)
