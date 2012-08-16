package com.arcusys.learn.scorm.tracking.model

case class Attempt
(
  id: Int,
  user: User,
  packageID: Int,
  organizationID: String,
  isComplete: Boolean)
