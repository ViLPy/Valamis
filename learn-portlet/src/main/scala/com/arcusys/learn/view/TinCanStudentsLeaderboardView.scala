package com.arcusys.learn.view

import javax.portlet._

import com.arcusys.learn.view.extensions._
import com.arcusys.learn.view.liferay.LiferayHelpers

class TinCanStudentsLeaderboardView extends OAuthPortlet with BaseView {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    val language = LiferayHelpers.getLanguage(request)
    val out = response.getWriter
    val contextPath = request.getContextPath

    out.println(getTemplate("/templates/2.0/students_leaderboard_templates.html") + generateResponse(contextPath, "students_leaderboard.html", language))
  }

  def generateResponse(contextPath: String, templateName: String, language: String, resURL: String = "") = {
    val translations = getTranslation("statementReport", language)

    val data = Map("contextPath" -> contextPath, "language" -> language, "resourceURL" -> resURL) ++ translations

    mustache(data, templateName)
  }
}
