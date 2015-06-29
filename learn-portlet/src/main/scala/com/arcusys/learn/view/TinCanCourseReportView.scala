package com.arcusys.learn.view

import java.io.FileNotFoundException
import javax.portlet._

import com.arcusys.learn.view.extensions._
import com.arcusys.learn.view.liferay.LiferayHelpers

class TinCanCourseReportView extends OAuthPortlet with BaseView {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {

    val language = LiferayHelpers.getLanguage(request)
    val out = response.getWriter
    val contextPath = request.getContextPath
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)

    out.println(getTemplate("/templates/2.0/course_report_templates.html") + generateResponse(contextPath, "course_report.html", language))
  }

  def generateResponse(contextPath: String, templateName: String, language: String) = {
    val translations = getTranslation("statementReport", language)

    val data = Map("contextPath" -> contextPath, "language" -> language) ++ translations

    mustache(data, templateName)
  }
}
