package com.arcusys.learn.bl.services

import com.arcusys.learn.bl.exceptions.{ DuplicateEntityException, EntityNotFoundException }
import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.services.RoleLocalServiceHelper
import com.arcusys.learn.scorm.tracking.model.PermissionType._
import com.arcusys.learn.scorm.tracking.model.Role
import com.arcusys.learn.scorm.tracking.storage.RoleStorage
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }

class RoleService(config: BindingModule) extends RoleServiceContract with Injectable {
  def this() = this(DomainConfiguration)
  implicit val bindingModule = config

  val roleStorage = inject[RoleStorage]

  def create(liferayRoleId: Int, permissionType: PermissionType): Role = {
    doIfNotExist(liferayRoleId, permissionType, () => {
      val role = new Role(0, liferayRoleId, permissionType, false)
      val id = roleStorage.createAndGetID(role)
      role.copy(id = id)
    })
  }

  def update(roleId: Int, permissionType: PermissionType, isDefault: Boolean): Role = {
    doIfExist(
      roleId,
      (role: Role) => {
        roleStorage.update(role.id, permissionType, isDefault)
        role
      }
    )
  }

  def delete(roleId: Int, permissionType: PermissionType) = {
    doIfExist(
      roleId,
      (role: Role) => roleStorage.delete(role.liferayRoleID, role.permission))
  }

  def getLFRole(lfRoleId: Int): com.liferay.portal.model.Role =
    RoleLocalServiceHelper.getRole(lfRoleId)

  def isExist(liferayRoleId: Int, permissionType: PermissionType): Boolean = {
    roleStorage.getDefault(liferayRoleId, permissionType) match {
      case Some(value) => true
      case None        => false
    }
  }

  def getForPermission(permissionType: PermissionType): Seq[Role] = {
    val roles = roleStorage.getForPermission(permissionType)

    //Filter if an error occurs => role was removed from liferay database => remove from valamis database.
    roles
      .filter(role =>
        try {
          RoleLocalServiceHelper.getRole(role.liferayRoleID)
          true
        } catch {
          case e: LNoSuchRoleException => {
            roleStorage.delete(role.liferayRoleID, permissionType)
            false
          }
        })
  }

  private def doIfNotExist(liferayRoleId: Int, permissionType: PermissionType, action: () => Role): Role = {
    isExist(liferayRoleId, permissionType) match {
      case true  => throw new DuplicateEntityException
      case false => action()
    }
  }

  private def doIfExist(roleId: Int, action: Role => Role): Role = {
    roleStorage.getByID(roleId) match {
      case Some(value) => action(value)
      case None        => throw new EntityNotFoundException
    }
  }

  private def doIfExist(roleId: Int, action: Role => Unit): Unit = {
    roleStorage.getByID(roleId) match {
      case Some(value) => action(value)
      case None        => throw new EntityNotFoundException
    }
  }
}
