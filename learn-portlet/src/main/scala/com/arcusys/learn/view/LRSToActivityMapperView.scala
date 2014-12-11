package com.arcusys.learn.view

import javax.portlet.{ RenderResponse, RenderRequest, GenericPortlet }
import org.scalatra.ScalatraFilter
import com.arcusys.learn.util.MustacheSupport
import com.arcusys.learn.view.extensions.{ TemplateCoupler, SessionSupport, ConfigurableView, i18nSupport }
import com.arcusys.learn.view.liferay.LiferayHelpers
import com.arcusys.learn.settings.model.Setting
import com.arcusys.learn.tincan.model.lrsClient.UserBasicAuthorization
import java.io.FileNotFoundException

class LRSToActivityMapperView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport with ConfigurableView with SessionSupport with TemplateCoupler {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    setupSession(request, response)
    val out = response.getWriter

    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val userId = themeDisplay.getUser.getUserId
    val courseId = themeDisplay.getCompanyId
    val language = LiferayHelpers.getLanguage(request)
    val courseID = themeDisplay.getLayout.getGroupId

    val hasPermissions = userRoleService.isAdmin(userId, courseId)
    if (!hasPermissions) {
      val translations = getTranslation("error", language)
      out.println(mustache(translations, "scorm_nopermissions.html"))
    } else {
      val translations = getTranslation("lrsToActivitiesMapper", language)
      val data = Map("contextPath" -> request.getContextPath,
        "language" -> language,
        "courseID" -> courseID) ++ translations

      out.println(getTemplate("/templates/2.0/lrs_to_activities_mapper_templates.html") +
        mustache(data, "lrs_to_activities_mapper.html"))
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

