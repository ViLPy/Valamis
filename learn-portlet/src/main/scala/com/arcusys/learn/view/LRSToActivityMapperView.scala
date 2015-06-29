package com.arcusys.learn.view

import javax.portlet.{GenericPortlet, RenderRequest, RenderResponse}

import com.arcusys.learn.view.extensions.BaseView
import com.arcusys.learn.view.liferay.LiferayHelpers

class LRSToActivityMapperView extends GenericPortlet with BaseView {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    val out = response.getWriter
    val language = LiferayHelpers.getLanguage(request)

    val translations = getTranslation("lrsToActivitiesMapper", language)
    val data = Map("language" -> language) ++ translations ++ getSecurityData(request).data

    out.println(getTemplate("/templates/2.0/lrs_to_activities_mapper_templates.html") +
      mustache(data, "lrs_to_activities_mapper.html"))
  }
}

