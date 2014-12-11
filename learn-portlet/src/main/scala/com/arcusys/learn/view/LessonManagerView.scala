package com.arcusys.learn.view

import java.io.FileNotFoundException
import javax.portlet.{ GenericPortlet, RenderRequest, RenderResponse }

import com.arcusys.learn.liferay.util.PortalUtilHelper
import com.arcusys.learn.util.MustacheSupport
import com.arcusys.learn.view.extensions.{ ConfigurableView, SessionSupport, TemplateCoupler, i18nSupport }
import com.arcusys.learn.view.liferay.LiferayHelpers
import org.scalatra.ScalatraFilter

class LessonManagerView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport with ConfigurableView with SessionSupport with TemplateCoupler {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    setupSession(request: RenderRequest, response: RenderResponse)
    val out = response.getWriter

    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val userId = themeDisplay.getUser.getUserId
    val courseId = themeDisplay.getScopeGroupId
    val language = LiferayHelpers.getLanguage(request)

    val hasPermissions = userRoleService.hasTeacherPermissions(userId, courseId)
    if (!hasPermissions) {
      val translations = getTranslation("error", language)
      out.println(mustache(translations, "scorm_nopermissions.html"))
    } else {

      val userUID = request.getRemoteUser
      val themeDisplay = LiferayHelpers.getThemeDisplay(request)

      val httpServletRequest = PortalUtilHelper.getHttpServletRequest(request)
      httpServletRequest.getSession.setAttribute("userID", userUID)

      val language = LiferayHelpers.getLanguage(request)
      val groupID = themeDisplay.getScopeGroupId
      val translations = getTranslation("lessonManager", language)
      val companyId = PortalUtilHelper.getCompanyId(request)

      val data = Map("contextPath" -> request.getContextPath, "userID" -> userUID, "groupID" -> groupID, "isAdmin" -> true,
        "language" -> language, "courseID" -> courseId, "isPortlet" -> true, "companyID" -> companyId) ++ translations

      out.println(getTemplate("/templates/2.0/lesson_manager_templates.html") +
        getTemplate("/templates/2.0/file_uploader.html") +
        getTemplate("templates/2.0/paginator.html") +
        getTemplate("/templates/2.0/image_gallery_templates.html") +
        mustache(data, "lesson_manager.html"))
    }
  }

  override def doEdit(request: RenderRequest, response: RenderResponse) {
    val out = response.getWriter
    val language = LiferayHelpers.getLanguage(request)
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)

    val data = Map("contextPath" -> request.getContextPath,
      "courseID" -> themeDisplay.getLayout.getGroupId,
      "pageID" -> themeDisplay.getLayout.getPrimaryKey,
      "language" -> language) ++ getTranslation("lessonManager", language)
    out.println(getTemplate("/templates/2.0/file_uploader.html") +
      mustache(data, "lesson_manager_settings.html"))

  }

  private def getTranslation(view: String, language: String): Map[String, String] = {
    try {
      getTranslation("/i18n/" + view + "_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/" + view + "_en")
      case _                        => Map[String, String]()
    }
  }
}