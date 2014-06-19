package com.arcusys.learn.models.request

import com.arcusys.learn.scorm.tracking.model.PermissionType
import com.arcusys.learn.scorm.tracking.model.PermissionType.PermissionType
import com.arcusys.learn.service.util.Parameter
import org.scalatra.ScalatraBase

/**
 * Created by Iliya Tryapitsin on 04.03.14.
 */
object RoleRequest {
  val PERMISSION = "permission"
  val ROLE_ID = "roleID"
  val LIFERAY_ROLE_ID = "liferayRoleID"
  val ACTION = "action"
  val IS_Default = "isDefault"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) {
    implicit val _scalatra = scalatra

    def permissionType: PermissionType = PermissionType.withName(
      Parameter(PERMISSION).required.toLowerCase)

    def id = Parameter(ROLE_ID).intRequired

    def liferayId = Parameter(LIFERAY_ROLE_ID).intRequired

    def actionType = CrudActionType.withName(
      Parameter(ACTION).required)

    def isDefault = Parameter(IS_Default).booleanRequired
  }
}
