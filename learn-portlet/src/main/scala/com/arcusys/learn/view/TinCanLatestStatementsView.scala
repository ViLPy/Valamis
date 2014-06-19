package com.arcusys.learn.view

import javax.portlet._
import org.scalatra.ScalatraFilter
import java.io.FileNotFoundException
import com.arcusys.learn.view.liferay.LiferayHelpers
import com.arcusys.learn.util.MustacheSupport

class TinCanLatestStatementsView
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

    val language = LiferayHelpers.getLanguage(request)
    val out = response.getWriter
    val contextPath = request.getContextPath
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)

    if (!themeDisplay.isSignedIn) {
      val translations = getTranslation("error", language)
      out.println(mustache(translations, "scorm_nopermissions.html"))
    } else {
      out.println(getTemplate("/templates/2.0/latest_statements_templates.html") + generateResponse(contextPath, "latest_statements.html", language))
    }
  }

  def generateResponse(contextPath: String, templateName: String, language: String, resURL: String = "") = {
    val translations = try {
      getTranslation("/i18n/statementReporting_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/statementReporting_en")
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
