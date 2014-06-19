package com.arcusys.learn.controllers.api

import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.request.{ RoleRequest, CrudActionType }
import com.arcusys.learn.facades.RoleFacadeContract
import com.arcusys.learn.liferay.services.{ RoleLocalServiceHelper, UserLocalServiceHelper }
import scala.collection.JavaConverters._
import com.arcusys.learn.models.RoleResponse
import com.liferay.portal.kernel.util.LocaleUtil

class RoleApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  def this() = this(Configuration)

  val roleFacade = inject[RoleFacadeContract]

  get("/")(jsonAction {
    val companyId = parameter("companyID").longRequired
    RoleLocalServiceHelper
      .getRoles(companyId)
      .asScala
      .map(role => RoleResponse(role.getRoleId.toInt, role.getName, role.getDescription(LocaleUtil.getDefault), UserLocalServiceHelper().getRoleUsersCount(role.getRoleId)))
      .toSeq
  })

  get("/:permission")(jsonAction {

    val roleRequest = RoleRequest(this)
    roleFacade.getForPermission(roleRequest.permissionType)
  })

  post("/(:roleID)")(jsonAction {
    requireTeacherPermissions()

    val roleRequest = RoleRequest(this)
    roleRequest.actionType match {
      case CrudActionType.ADD => roleFacade.create(
        roleRequest.liferayId,
        roleRequest.permissionType)

      case CrudActionType.UPDATE => roleFacade.update(
        roleRequest.id,
        roleRequest.permissionType,
        roleRequest.isDefault)

      case CrudActionType.DELETE => roleFacade.delete(
        roleRequest.id,
        roleRequest.permissionType)
    }
  })
}
