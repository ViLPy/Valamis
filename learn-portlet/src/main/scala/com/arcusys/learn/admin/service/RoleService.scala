package com.arcusys.learn.admin.service

import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.liferay.portal.service.RoleLocalServiceUtil
import com.arcusys.learn.scorm.tracking.model.{PermissionType, Role}
import com.arcusys.learn.service.util.SessionHandler


class RoleService (configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)
  before() {
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
  }

  val jsonModel = new JsonModelBuilder[Role](role =>{
    val liferayRole = RoleLocalServiceUtil.getRole(role.liferayRoleID)
    Map(
      "id" -> role.id,
      "roleName" -> liferayRole.getName,
      "roleDescription" -> liferayRole.getDescription,
      "roleID" -> liferayRole.getRoleId,
      "permission" -> parameter("permission").required,
      "isDefault" -> role.isDefault
    )
  })

  get("/:permission"){
    val permission = parameter("permission").required
    val roles = storageFactory.roleStorage.getForPermission(PermissionType.withName(permission))
    jsonModel(roles)
  }

  post("/add/:roleID/:permission"){
    requireTeacherPermissions()

    val roleID = parameter("roleID").intRequired
    val id = storageFactory.roleStorage.createAndGetID(new Role(0, roleID, PermissionType.withName(parameter("permission").required), false))
    jsonModel(storageFactory.roleStorage.getByID(id).get)
  }

  post("/delete/:roleID/:permission"){
    requireTeacherPermissions()

    val roleID = parameter("roleID").intRequired
    storageFactory.roleStorage.delete(roleID, PermissionType.withName(parameter("permission").required))
  }

  post("/update/:id/:permission/:isDefault") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    val isDefault = parameter("isDefault").booleanRequired
    val permission = parameter("permission").required
    storageFactory.roleStorage.update(id, PermissionType.withName(permission), isDefault)
  }

}
