package com.arcusys.learn.view

import java.io.FileNotFoundException
import javax.portlet.{ RenderResponse, RenderRequest, GenericPortlet }

import com.arcusys.learn.util.MustacheSupport
import com.arcusys.learn.view.extensions.{ TemplateCoupler, SessionSupport, ConfigurableView, i18nSupport }
import com.arcusys.learn.view.liferay.LiferayHelpers
import org.scalatra.ScalatraFilter
import com.arcusys.util.JsonSerializer

class ValamisSlidesEditor extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport with ConfigurableView with SessionSupport with TemplateCoupler {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    setupSession(request, response)
    val out = response.getWriter

    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val userId = themeDisplay.getUser.getUserId
    val courseId = themeDisplay.getCompanyId
    val language = LiferayHelpers.getLanguage(request)
    val courseID = themeDisplay.getLayout.getGroupId

    val hasPermissions = userRoleService.isAdmin(userId, courseId)
    if (!hasPermissions) {
      val translations = getTranslation("error", language)
      out.println(mustache(translations, "scorm_nopermissions.html"))
    } else {
      val translations = getTranslation("valamisSlidesEditor", language)
      val data = Map(
        "contextPath" -> request.getContextPath,
        "language" -> language,
        "courseID" -> courseID,
        "translations" -> JsonSerializer.json(translations).get
      ) ++ translations

      out.println(getTemplate("/templates/2.0/valamis_slides_editor_templates.html") +
        mustache(data, "valamis_slides_editor.html"))
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
