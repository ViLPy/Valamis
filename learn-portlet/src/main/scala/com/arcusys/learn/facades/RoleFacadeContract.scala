package com.arcusys.learn.facades

import com.arcusys.learn.scorm.tracking.model.PermissionType._
import com.arcusys.learn.models.response.RoleResponse

/**
 * Created by Iliya Tryapitsin on 09.04.2014.
 */
trait RoleFacadeContract {
  def getForPermission(permissionType: PermissionType): Seq[RoleResponse]
  def create(liferayId: Int,
    permissionType: PermissionType): RoleResponse

  def update(id: Int,
    permissionType: PermissionType,
    isDefault: Boolean): RoleResponse

  def delete(id: Int,
    permissionType: PermissionType)
}
