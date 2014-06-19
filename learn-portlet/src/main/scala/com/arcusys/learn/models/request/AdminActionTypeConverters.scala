package com.arcusys.learn.models.request

import com.arcusys.learn.models.request.AdminActionType._

/**
 * Created by Iliya Tryapitsin on 04.03.14.
 */
object AdminActionTypeConverters {
  implicit def fromString(actionType: String): AdminActionType = {
    return AdminActionType.withName(actionType.toUpperCase)
  }
}