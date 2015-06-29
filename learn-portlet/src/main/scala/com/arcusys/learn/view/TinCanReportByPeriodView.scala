package com.arcusys.learn.view

import javax.portlet._

import com.arcusys.learn.view.extensions._
import com.arcusys.learn.view.liferay.LiferayHelpers

class TinCanReportByPeriodView extends OAuthPortlet with BaseView {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    val language = LiferayHelpers.getLanguage(request)
    val out = response.getWriter
    val contextPath = request.getContextPath

    out.println(generateResponse(contextPath, "reporting_by_period_line.html", language))
  }

  def generateResponse(contextPath: String, templateName: String, language: String, resURL: String = "") = {
    val translations = getTranslation("statementReport", language)

    val data = Map("contextPath" -> contextPath, "language" -> language, "resourceURL" -> resURL) ++ translations

    mustache(data, templateName)
  }
}
