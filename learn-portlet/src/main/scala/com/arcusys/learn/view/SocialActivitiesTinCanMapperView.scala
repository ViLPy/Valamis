package com.arcusys.learn.view

import javax.portlet.{GenericPortlet, RenderRequest, RenderResponse}

import com.arcusys.learn.view.extensions.BaseView
import com.arcusys.learn.view.liferay.LiferayHelpers
import com.arcusys.valamis.settings.service.SiteDependentSettingServiceImpl

class SocialActivitiesTinCanMapperView extends GenericPortlet with BaseView {
  lazy val siteSettingsManager = inject[SiteDependentSettingServiceImpl]

  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {

    val out = response.getWriter

    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val language = LiferayHelpers.getLanguage(request)
    val siteID = themeDisplay.getLayout.getGroupId

    val settings = Seq(
      "com.liferay.portlet.blogs.model.BlogsEntry",
      "com.liferay.portlet.documentlibrary.model.DLFileEntry",
      "com.liferay.portlet.wiki.model.WikiPage",
      "com.liferay.portlet.messageboards.model.MBMessage",
      "com.liferay.calendar.model.CalendarBooking",
      "com.liferay.portlet.bookmarks.model.BookmarksEntry"
    ).map(id => {
        Map("activityID" -> id,
          "value" -> siteSettingsManager.getSetting(siteID.toInt, id))
      })

    val translations = getTranslation("socialActivitiesMapper", language)
    val data = Map("contextPath" -> request.getContextPath,
      "language" -> language,
      "siteID" -> siteID,
      "settings" -> settings) ++ translations

    out.println(getTemplate("/templates/2.0/social_activities_mapper_templates.html") +
      mustache(data, "social_activities_mapper.html"))
  }
}

