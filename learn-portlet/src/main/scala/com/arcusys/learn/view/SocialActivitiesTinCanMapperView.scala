package com.arcusys.learn.view

import javax.portlet.{ RenderResponse, RenderRequest, GenericPortlet }
import com.arcusys.learn.setting.storage.SiteDependentSettingStorage
import org.scalatra.ScalatraFilter
import com.arcusys.learn.util.MustacheSupport
import com.arcusys.learn.view.extensions.{ TemplateCoupler, SessionSupport, ConfigurableView, i18nSupport }
import com.arcusys.learn.view.liferay.LiferayHelpers
import java.io.FileNotFoundException

class SocialActivitiesTinCanMapperView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport with ConfigurableView with SessionSupport with TemplateCoupler {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    setupSession(request, response)
    val out = response.getWriter

    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val userId = themeDisplay.getUser.getUserId
    val courseId = themeDisplay.getCompanyId
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

    val hasPermissions = userRoleService.isAdmin(userId, courseId)
    if (!hasPermissions) {
      val translations = getTranslation("error", language)
      out.println(mustache(translations, "scorm_nopermissions.html"))
    } else {
      val translations = getTranslation("socialActivitiesMapper", language)
      val data = Map("contextPath" -> request.getContextPath,
        "language" -> language,
        "siteID" -> siteID,
        "settings" -> settings) ++ translations

      out.println(getTemplate("/templates/2.0/social_activities_mapper_templates.html") +
        mustache(data, "social_activities_mapper.html"))
    }
  }

  private def getTranslation(view: String, language: String): Map[String, String] = {
    try {
      getTranslation("/i18n/" + view + "_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/" + view + "_en")
      case _                        => Map[String, String]()
    }
  }
}

