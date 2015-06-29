package com.arcusys.learn.view

import javax.portlet.{GenericPortlet, RenderRequest, RenderResponse}

import com.arcusys.learn.liferay.permission._
import com.arcusys.learn.liferay.util.PortalUtilHelper
import com.arcusys.learn.view.extensions.BaseView
import com.arcusys.learn.view.liferay.LiferayHelpers

class LessonManagerView extends GenericPortlet with BaseView {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    val out = response.getWriter

    val language = LiferayHelpers.getLanguage(request)
    val securityScope = getSecurityData(request)

    val translations = getTranslation("lessonManager", language)
    val httpServletRequest = PortalUtilHelper.getHttpServletRequest(request)
    httpServletRequest.getSession.setAttribute("userID", securityScope.userId)

    val data = Map(
      "isAdmin" -> true,
      "language" -> language,
      "permissionSetDefault" -> PermissionUtil.hasPermission(securityScope.courseId, securityScope.portletId, securityScope.primaryKey, SetDefaultPermission),
      "permissionExport" -> PermissionUtil.hasPermission(securityScope.courseId, securityScope.portletId, securityScope.primaryKey, ExportPermission),
      "permissionUpload" -> PermissionUtil.hasPermission(securityScope.courseId, securityScope.portletId, securityScope.primaryKey, UploadPermission),
      "permissionSetVisible" -> PermissionUtil.hasPermission(securityScope.courseId, securityScope.portletId, securityScope.primaryKey, SetVisiblePermission)
    ) ++ translations ++ securityScope.data

    out.println(getTemplate("/templates/2.0/lesson_manager_templates.html") +
      getTemplate("/templates/2.0/file_uploader.html") +
      getTemplate("templates/2.0/paginator.html") +
      getTemplate("/templates/2.0/common_templates.html") +
      getTemplate("/templates/2.0/image_gallery_templates.html") +
      mustache(data, "lesson_manager.html"))

  }

  override def doEdit(request: RenderRequest, response: RenderResponse) {
    val out = response.getWriter
    val language = LiferayHelpers.getLanguage(request)
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)

    val data = Map("contextPath" -> request.getContextPath,
      "pageID" -> themeDisplay.getLayout.getPrimaryKey,
      "language" -> language) ++ getTranslation("lessonManager", language)
    out.println(getTemplate("/templates/2.0/file_uploader.html") +
      mustache(data ++ getSecurityData(request).data, "lesson_manager_settings.html"))

  }
}