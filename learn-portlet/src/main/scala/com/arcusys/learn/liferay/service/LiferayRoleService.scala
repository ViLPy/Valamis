package com.arcusys.learn.liferay.service

import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.services.{RoleLocalServiceHelper, UserLocalServiceHelper}
import com.arcusys.learn.liferay.LiferayClasses._

/**
 * User: Yulia.Glushonkova
 * Date: 09.08.13
 */
class LiferayRoleService (configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  val jsonModel = new JsonModelBuilder[LRole](role =>
    Map(
      "roleID" -> role.getRoleId,
      "roleName" -> role.getName,
      "roleDescription" -> role.getDescription,
      "usersCount" -> UserLocalServiceHelper.getRoleUsersCount(role.getRoleId)
    ))

  get("/") {
    val companyId = parameter("companyID").longRequired
    jsonModel(RoleLocalServiceHelper.getRoles(companyId).toArray.map(i => i.asInstanceOf[LRole]))
  }

}
