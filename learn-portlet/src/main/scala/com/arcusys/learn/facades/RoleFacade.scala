package com.arcusys.learn.facades

import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }
import com.arcusys.learn.scorm.tracking.storage.RoleStorage
import com.arcusys.learn.scorm.tracking.model.PermissionType.PermissionType
import com.arcusys.learn.liferay.services.RoleLocalServiceHelper
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.models.response.RoleResponse
import com.arcusys.learn.scorm.tracking.model.Role
import com.arcusys.learn.exceptions.{ DuplicateEntityException, EntityNotFoundException }
import com.arcusys.learn.ioc.Configuration
import scala.xml.XML
import scala.util.{ Try }
import com.liferay.portal.kernel.util.LocaleUtil

/**
 * Created by Iliya Tryapitsin on 09.04.2014.
 */
class RoleFacade(config: BindingModule) extends RoleFacadeContract with Injectable {
  def this() = this(Configuration)
  implicit val bindingModule = config

  val roleStorage = inject[RoleStorage]

  def create(liferayId: Int, permissionType: PermissionType): RoleResponse = {
    doIfNotExist(liferayId, permissionType, () => {
      val role = new Role(0, liferayId, permissionType, false)
      val id = roleStorage.createAndGetID(role)
      val liferayRole = RoleLocalServiceHelper.getRole(role.liferayRoleID)
      convertToRoleResponse(role.copy(id = id), liferayRole)
    })
  }

  def update(id: Int, permissionType: PermissionType, isDefault: Boolean): RoleResponse = {
    doIfExist(
      id,
      (role: Role) => {
        roleStorage.update(role.id, permissionType, isDefault)
        val liferayRole = RoleLocalServiceHelper.getRole(role.liferayRoleID)
        convertToRoleResponse(role, liferayRole)
      }
    )
  }

  def delete(id: Int, permissionType: PermissionType) = {
    doIfExist(
      id,
      (role: Role) => roleStorage.delete(role.liferayRoleID, role.permission))
  }

  def isExist(liferayId: Int, permissionType: PermissionType): Boolean = {
    roleStorage.getDefault(liferayId, permissionType) match {
      case Some(value) => true
      case None        => false
    }
  }

  def getForPermission(permissionType: PermissionType): Seq[RoleResponse] = {
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
      .map(x => {
        val liferayRole = RoleLocalServiceHelper.getRole(x.liferayRoleID)
        convertToRoleResponse(x, liferayRole)
      })
  }

  private def convertToRoleResponse(valamisRole: Role, liferayRole: com.liferay.portal.model.Role): RoleResponse = {
    //val description = XML.loadString(liferayRole.getDescription(LocaleUtil.getDefault))
    RoleResponse(
      valamisRole.id,
      liferayRole.getName,
      liferayRole.getDescription(LocaleUtil.getDefault),
      //(description \\ "Description").text,
      liferayRole.getRoleId,
      valamisRole.permission.toString,
      valamisRole.isDefault)
  }

  private def doIfNotExist(liferayId: Int, permissionType: PermissionType, action: () => RoleResponse): RoleResponse = {
    isExist(liferayId, permissionType) match {
      case true  => throw new DuplicateEntityException
      case false => action()
    }
  }

  private def doIfExist(id: Int, action: Role => RoleResponse): RoleResponse = {
    roleStorage.getByID(id) match {
      case Some(value) => action(value)
      case None        => throw new EntityNotFoundException
    }
  }

  private def doIfExist(id: Int, action: Role => Unit): Unit = {
    roleStorage.getByID(id) match {
      case Some(value) => action(value)
      case None        => throw new EntityNotFoundException
    }
  }
}
