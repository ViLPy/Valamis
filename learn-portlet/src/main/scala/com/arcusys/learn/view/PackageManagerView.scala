package com.arcusys.learn.view

import javax.portlet.{ GenericPortlet, RenderResponse, RenderRequest }
import com.arcusys.learn.view.liferay.LiferayHelpers
import org.scalatra.ScalatraFilter
import java.io.FileNotFoundException
import com.arcusys.learn.liferay.util.PortalUtilHelper
import com.arcusys.learn.util.MustacheSupport

class PackageManagerView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport with ConfigurableView with SessionSupport with TemplateCoupler {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    setupSession(request: RenderRequest, response: RenderResponse)
    val out = response.getWriter

    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val userId = themeDisplay.getUser.getUserId
    val courseId = themeDisplay.getScopeGroupId
    val language = LiferayHelpers.getLanguage(request)

    val hasPermissions = userManagement.hasTeacherPermissions(userId, courseId)
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
      val translations = getTranslation("admin", language)
      val companyId = PortalUtilHelper.getCompanyId(request)

      val data = Map("contextPath" -> request.getContextPath, "userID" -> userUID, "groupID" -> groupID, "isAdmin" -> true,
        "language" -> language, "courseID" -> courseId, "isPortlet" -> true, "companyID" -> companyId) ++ translations

      out.println(getTemplate("/templates/2.0/package-manager.html") +
        getTemplate("/templates/2.0/file-uploader.html") +
        getTemplate("templates/2.0/paginator.html") +
        mustache(data, "package_manager.html"))
    }
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