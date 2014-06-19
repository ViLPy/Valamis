package com.arcusys.learn.view

import javax.portlet._
import org.scalatra.ScalatraFilter
import com.arcusys.learn.util.MustacheSupport
import com.arcusys.learn.view.liferay.LiferayHelpers
import java.io.FileNotFoundException

class CourseEventReportView
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

    out.println(generateResponse(contextPath, "course_event_report.html", language))
  }

  def generateResponse(contextPath: String, templateName: String, language: String, resURL: String = "") = {
    val translations = try {
      getTranslation("/i18n/courseEventReport_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/courseEventReport_en")
      case _                        => Map[String, String]()
    }
    val data = Map("contextPath" -> contextPath, "language" -> language, "resourceURL" -> resURL) ++ translations
    mustache(data, templateName)
  }

}
