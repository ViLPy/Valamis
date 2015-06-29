package com.arcusys.learn.view

import javax.portlet.{GenericPortlet, RenderRequest, RenderResponse}

import com.arcusys.learn.liferay.services.GroupLocalServiceHelper
import com.arcusys.learn.view.extensions.BaseView
import com.arcusys.learn.view.liferay.LiferayHelpers

class UserPortfolioView extends GenericPortlet with BaseView {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val language = LiferayHelpers.getLanguage(request)
    val path = request.getContextPath

    val courseId = themeDisplay.getScopeGroupId
    val translations = getTranslation("curriculum", language)

    val group = GroupLocalServiceHelper.getGroup(courseId)
    if (group.isUser) {
      val data = Map("contextPath" -> path, "userID" -> group.getClassPK,
        "language" -> language) ++ translations

      response.getWriter.println(getTemplate("/templates/2.0/user_portfolio_templates.html") + generateResponse(data, "user_portfolio.html"))
    } else {
      val translations = getTranslation("error", language)
      val data = mustache(Map("contextPath" -> path, "language" -> language) ++ translations, "scorm_nopermissions.html")
      response.getWriter.println(data)
    }
  }

  def generateResponse(data: Map[String, Any], templateName: String) = {
    mustache(data, templateName)
  }
}
