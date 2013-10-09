package com.arcusys.learn.scorm.tracking.storage

import com.arcusys.learn.scorm.tracking.model.{PermissionType, Role}

trait RoleStorage {
  def getAll:Seq[Role]
  def getByID(id: Int): Option[Role]
  def getForPermission(permission: PermissionType.Value): Seq[Role]
  def getDefault(permission: PermissionType.Value): Option[Role]
  def createAndGetID(role: Role): Int
  def update(id: Int, permission: PermissionType.Value, isDefault: Boolean)
  def delete(liferayRoleID: Int, permission: PermissionType.Value)
  def renew()
}
