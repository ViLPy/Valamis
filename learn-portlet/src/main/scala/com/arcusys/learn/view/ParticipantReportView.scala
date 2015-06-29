package com.arcusys.learn.view

import java.io.FileNotFoundException
import javax.portlet._

import com.arcusys.learn.view.extensions.BaseView
import com.arcusys.learn.view.liferay.LiferayHelpers

class ParticipantReportView extends GenericPortlet with BaseView {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    val language = LiferayHelpers.getLanguage(request)
    val out = response.getWriter
    out.println(generateResponse(request.getContextPath, "participant_report.html", language))
  }

  def generateResponse(contextPath: String, templateName: String, language: String) = {
    val translations = try {
      getTranslation("/i18n/participantReport_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/participantReport_en")
      case _: Throwable             => Map[String, String]()
    }
    val data = Map("contextPath" -> contextPath, "language" -> language) ++ translations
    mustache(data, templateName)
  }
}
