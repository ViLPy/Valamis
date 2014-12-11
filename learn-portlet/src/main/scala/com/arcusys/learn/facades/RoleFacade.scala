package com.arcusys.learn.facades

import com.arcusys.learn.bl.services.RoleServiceContract
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }
import com.arcusys.learn.scorm.tracking.model.PermissionType.PermissionType
import com.arcusys.learn.models.response.RoleResponse
import com.arcusys.learn.scorm.tracking.model.Role
import com.arcusys.learn.ioc.Configuration
import com.liferay.portal.kernel.util.LocaleUtil

/**
 * Created by Iliya Tryapitsin on 09.04.2014.
 */
class RoleFacade(config: BindingModule) extends RoleFacadeContract with Injectable {
  def this() = this(Configuration)

  implicit val bindingModule = config

  val roleService = inject[RoleServiceContract]

  def create(liferayId: Int, permissionType: PermissionType): RoleResponse = {
    val role = roleService.create(liferayId, permissionType)
    convertToRoleResponse(role)
  }

  def update(id: Int, permissionType: PermissionType, isDefault: Boolean): RoleResponse = {
    val role = roleService.update(id, permissionType, isDefault)
    convertToRoleResponse(role)
  }

  def delete(id: Int, permissionType: PermissionType) = {
    roleService.delete(id, permissionType)
  }

  def getForPermission(permissionType: PermissionType): Seq[RoleResponse] = {
    roleService.getForPermission(permissionType).map(convertToRoleResponse)
  }

  private def convertToRoleResponse(valamisRole: Role): RoleResponse = {
    val liferayRole = roleService.getLFRole(valamisRole.liferayRoleID)
    RoleResponse(
      valamisRole.id,
      liferayRole.getName,
      liferayRole.getDescription(LocaleUtil.getDefault),
      liferayRole.getRoleId,
      valamisRole.permission.toString,
      valamisRole.isDefault)
  }

}
