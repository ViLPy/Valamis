package com.arcusys.learn.bl.services

import com.arcusys.learn.scorm.tracking.model.PermissionType._
import com.arcusys.learn.scorm.tracking.model.Role

/**
 * User: Yulia.Glushonkova
 * Date: 14.10.2014
 */
trait RoleServiceContract {
  def getForPermission(permissionType: PermissionType): Seq[Role]
  def create(liferayId: Int,
    permissionType: PermissionType): Role

  def update(id: Int,
    permissionType: PermissionType,
    isDefault: Boolean): Role

  def delete(id: Int, permissionType: PermissionType)

  def getLFRole(id: Int): com.liferay.portal.model.Role
}
