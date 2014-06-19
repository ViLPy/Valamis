package com.arcusys.learn.models.response

import com.arcusys.learn.scorm.tracking.model.{ Role }

/**
 * Created by Iliya Tryapitsin on 04.03.14.
 */

case class RoleResponse(id: Int,
  name: String,
  description: String,
  liferayRoleId: Long,
  permission: String,
  isDefault: Boolean)