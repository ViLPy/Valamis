package com.arcusys.learn.view

import javax.portlet.{ RenderResponse, RenderRequest, GenericPortlet }
import liferay.LiferayHelpers
import org.scalatra.ScalatraFilter
import java.io.FileNotFoundException
import com.arcusys.learn.liferay.services.GroupLocalServiceHelper
import com.arcusys.learn.util.MustacheSupport

class MyAccountView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport with ConfigurableView with TemplateCoupler {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val language = LiferayHelpers.getLanguage(request)
    val path = request.getContextPath

    val courseID = themeDisplay.getScopeGroupId
    val translations = getTranslation("curriculum", language)

    val group = GroupLocalServiceHelper.getGroup(courseID)
    if (group.isUser) {
      val data = Map("contextPath" -> path, "userID" -> group.getClassPK,
        "language" -> language) ++ translations

      response.getWriter.println(generateResponse(data, "valamis_myAccount.html") + getTemplate("/templates/2.0/myAccount_templates.html"))
    } else {
      val translations = getTranslation("error", language)
      val data = mustache(Map("contextPath" -> path, "language" -> language) ++ translations, "scorm_nopermissions.html")
      response.getWriter.println(data)
    }
  }

  def generateResponse(data: Map[String, Any], templateName: String) = {
    mustache(data, templateName)
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
