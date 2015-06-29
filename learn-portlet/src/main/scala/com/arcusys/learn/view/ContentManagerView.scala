package com.arcusys.learn.view

import javax.portlet._

import com.arcusys.learn.liferay.permission.{ModifyPermission, PermissionUtil}
import com.arcusys.learn.liferay.util.PortletPreferencesFactoryUtilHelper
import com.arcusys.learn.view.extensions.BaseView
import com.arcusys.learn.view.liferay.LiferayHelpers
import scala.util.Try

class ContentManagerView extends GenericPortlet with BaseView {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    val language = LiferayHelpers.getLanguage(request)
    val out = response.getWriter
    val preferences = PortletPreferencesFactoryUtilHelper.getPortletSetup(request)
    val showGlobalBase = Try(preferences.getValue("showGlobalBase", "false")).getOrElse(false)

    val translations = getTranslation("questionManager", language)

    val data = Map(
      "language" -> language,
      "courseId" -> LiferayHelpers.getThemeDisplay(request).getScopeGroupId,
      "showGlobalBase" -> showGlobalBase
    ) ++ translations ++ getSecurityData(request).data

    out.println(getTemplate("/templates/2.0/content_manager_templates.html") +
      getTemplate("/templates/2.0/question_tree_templates.html") +
      getTemplate("/templates/2.0/paginator.html") +
      getTemplate("/templates/2.0/file_uploader.html") +
      getTemplate("/templates/2.0/common_templates.html") +
      mustache(data, "content_manager.html"))
  }

  override def doEdit(request: RenderRequest, response: RenderResponse) {
    val showGlobalBase = request.getParameter("showGlobalBase")

    if (showGlobalBase != null && !showGlobalBase.isEmpty) {
      val preferences = PortletPreferencesFactoryUtilHelper.getPortletSetup(request)
      preferences.setValue("showGlobalBase", showGlobalBase)
      preferences.store()
    } else {
      val out = response.getWriter
      val language = LiferayHelpers.getLanguage(request)
      val preferences = PortletPreferencesFactoryUtilHelper.getPortletSetup(request)
      val showGlobalBase = preferences.getValue("showGlobalBase", "false")
      val securityScope = getSecurityData(request)

      val translations = getTranslation("questionManager", language) // TODO: rename it

      val data = Map(
        "language" -> language,
        "showGlobalBase" -> showGlobalBase,
        "actionURL" -> response.createResourceURL(),
        "permissionToModify" -> PermissionUtil.hasPermission(securityScope.courseId, securityScope.portletId, securityScope.primaryKey, ModifyPermission)
      ) ++ translations ++ getSecurityData(request).data

      out.println(getTemplate("/templates/2.0/file_uploader.html") +
        mustache(data, "content_manager_settings.html"))

    }
  }

}