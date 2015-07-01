package com.arcusys.learn.view

import javax.portlet.{RenderRequest, RenderResponse}

import com.arcusys.learn.liferay.LiferayClasses.LUser
import com.arcusys.learn.view.extensions._
import com.arcusys.learn.view.liferay.LiferayHelpers
import com.arcusys.valamis.util.serialization.JsonHelper

class TinCanStatementViewerView extends OAuthPortlet with BaseView {

  override def destroy(): Unit = {}

  override def doView(request: RenderRequest, response: RenderResponse) {

    val language = LiferayHelpers.getLanguage(request)
    val out = response.getWriter
    val contextPath = request.getContextPath
    val user = LiferayHelpers.getUser(request)

    out.println(generateResponse(request, response, user, contextPath, "statement_viewer.html", language))
  }

  def generateResponse(request: RenderRequest, response: RenderResponse, user: LUser, contextPath: String, templateName: String, language: String) = {
    val translations = getTranslation("statementViewer", language)

    val endpoint = JsonHelper.toJson(getEndpointInfo(request))

    val data = Map("contextPath" -> contextPath, "language" -> language) ++ translations ++
      Map("endpointData" -> endpoint)
    mustache(data, templateName)

  }

  def generateErrorResponse(contextPath: String, templateName: String, language: String) = {
    val translations = getTranslation("error", language)

    val data = Map("contextPath" -> contextPath, "language" -> language) ++ translations

    mustache(data, templateName)
  }
}
