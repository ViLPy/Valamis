package com.arcusys.learn.view

import javax.portlet.{RenderRequest, RenderResponse}

import com.arcusys.learn.view.extensions.{OAuthPortlet, BaseView}
import com.arcusys.learn.view.liferay.LiferayHelpers

class RecentLessonsView extends OAuthPortlet with BaseView {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    val out = response.getWriter

    val language = LiferayHelpers.getLanguage(request)
    val securityScope = getSecurityData(request)
    val translations = getTranslation("dashboard", language)

    val data = translations ++ securityScope.data + ("language" -> language)

    out.println(getTemplate("/templates/2.0/recent_lessons_templates.html") +
      getTemplate("/templates/2.0/common_templates.html") +
      mustache(data, "recent_lessons.html"))
  }
}
