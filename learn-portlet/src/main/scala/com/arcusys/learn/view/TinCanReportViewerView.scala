package com.arcusys.learn.view

import java.io.FileNotFoundException
import javax.portlet._

import com.arcusys.learn.util.MustacheSupport
import com.arcusys.learn.view.liferay.LiferayHelpers
import org.scalatra.ScalatraFilter
import com.arcusys.learn.view.extensions.{ ConfigurableView, i18nSupport, SessionSupport, TemplateCoupler }

class TinCanReportViewerView
    extends GenericPortlet
    with ScalatraFilter
    with MustacheSupport
    with i18nSupport
    with ConfigurableView
    with SessionSupport
    with TemplateCoupler {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    setupSession(request, response)
    val userUID = if (request.getRemoteUser != null) request.getRemoteUser.toInt else null.asInstanceOf[Int]

    val language = LiferayHelpers.getLanguage(request)
    val out = response.getWriter
    val contextPath = request.getContextPath
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val courseID = themeDisplay.getLayout.getGroupId

    if (!themeDisplay.isSignedIn || !userRoleService.hasTeacherPermissions(userUID, courseID)) {
      val translations = getTranslation("error", language)
      out.println(mustache(translations, "scorm_nopermissions.html"))
    } else {
      out.println(getTemplate("/templates/2.0/reporting_viewer_templates.html") + generateResponse(contextPath, "reporting_viewer.html", language))
    }
  }

  def generateResponse(contextPath: String, templateName: String, language: String, resURL: String = "") = {
    val translations = try {
      getTranslation("/i18n/statementReport_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/statementReport_en")
      case _                        => Map[String, String]()
    }
    val data = Map("contextPath" -> contextPath, "language" -> language, "resourceURL" -> resURL) ++ translations
    mustache(data, templateName)
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
