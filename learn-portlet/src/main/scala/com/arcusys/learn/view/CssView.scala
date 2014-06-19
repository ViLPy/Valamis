package com.arcusys.learn.view

import javax.portlet.{ RenderResponse, RenderRequest, GenericPortlet }
import liferay.LiferayHelpers
import org.scalatra.ScalatraFilter
import java.io.FileNotFoundException
import com.arcusys.learn.liferay.services.GroupLocalServiceHelper
import com.arcusys.learn.util.MustacheSupport

class CssView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport with ConfigurableView {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val language = LiferayHelpers.getLanguage(request)
    val path = request.getContextPath

    val courseID = themeDisplay.getScopeGroupId
    val translations = getTranslation("curriculum", language)

    val group = GroupLocalServiceHelper.getGroup(courseID)

    val data = Map("contextPath" -> path, "userID" -> group.getClassPK,
      "language" -> language, "openBadgesUserID" -> 1) ++ translations

    val curUrl = themeDisplay.getURLCurrent

    val ind = curUrl.lastIndexOf("=")
    val act = if (ind == -1) "test_html" else curUrl.substring(ind + 1)

    response.getWriter.println(generateResponse(data, act + ".html"))

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
