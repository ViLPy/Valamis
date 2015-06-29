package com.arcusys.learn.view

import javax.portlet._

import com.arcusys.learn.view.extensions.BaseView
import com.arcusys.learn.view.liferay.LiferayHelpers

class CourseEventReportView extends GenericPortlet with BaseView {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    val language = LiferayHelpers.getLanguage(request)
    val out = response.getWriter
    val contextPath = request.getContextPath
    out.println(generateResponse(contextPath, "course_event_report.html", language))

  }

  def generateResponse(contextPath: String, templateName: String, language: String, resURL: String = "") = {
    val translations = getTranslation("courseEventReport", language)
    val data = Map("contextPath" -> contextPath, "language" -> language, "resourceURL" -> resURL) ++ translations
    mustache(data, templateName)
  }
}
