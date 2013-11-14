package com.arcusys.learn.liferay.service

import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.liferay.portal.service.{UserLocalServiceUtil, RoleLocalServiceUtil}

/**
 * User: Yulia.Glushonkova
 * Date: 09.08.13
 */
class LiferayRoleService (configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  val jsonModel = new JsonModelBuilder[com.liferay.portal.model.Role](role =>
    Map(
      "roleID" -> role.getRoleId,
      "roleName" -> role.getName,
      "roleDescription" -> role.getDescription,
      "usersCount" -> UserLocalServiceUtil.getRoleUsersCount(role.getRoleId)
    ))

  get("/") {
    val companyId = parameter("companyID").longRequired
    jsonModel(RoleLocalServiceUtil.getRoles(companyId).toArray.map(i => i.asInstanceOf[com.liferay.portal.model.Role]))
  }

}
