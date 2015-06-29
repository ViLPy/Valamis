package com.arcusys.valamis.lesson.scorm.model.tracking

import com.arcusys.valamis.user.model.User

case class Attempt(
  id: Int,
  user: User,
  packageID: Int,
  organizationID: String,
  isComplete: Boolean)
