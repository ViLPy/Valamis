package com.arcusys.learn.models.request

/**
 * Created by Iliya Tryapitsin on 12.03.14.
 */

trait BaseRequest {
  final val Action = "action"

  final val CourseId = "courseId"
  //For security
  final val PortletId = "portletId"
  final val PrimaryKey = "primaryKey"
}

