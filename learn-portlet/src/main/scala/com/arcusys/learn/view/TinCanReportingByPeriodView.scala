package com.arcusys.learn.view

import javax.portlet._
import org.scalatra.ScalatraFilter
import com.arcusys.scala.scalatra.mustache.MustacheSupport
import java.io.FileNotFoundException
import com.arcusys.learn.view.liferay.LiferayHelpers

class TinCanReportingByPeriodView
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

    out.println(generateResponse(contextPath, "statement_stat_line.html", language))
  }

  def generateResponse(contextPath: String, templateName: String, language: String, resURL: String = "") = {
    val translations = try {
      getTranslation("/i18n/statementReporting_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/statementReporting_en")
      case _ => Map[String, String]()
    }
    val data = Map("contextPath" -> contextPath, "language" -> language, "resourceURL" -> resURL) ++ translations
    mustache(data, templateName)
  }

}
