package com.arcusys.learn.view

import javax.portlet.{ RenderResponse, RenderRequest, GenericPortlet }
import org.scalatra.ScalatraFilter
import java.io.FileNotFoundException
import com.arcusys.learn.view.liferay.LiferayHelpers
import com.arcusys.learn.util.MustacheSupport
import com.arcusys.learn.view.extensions.{ ConfigurableView, i18nSupport, SessionSupport }

class TinCanStatementViewerView
    extends GenericPortlet
    with ScalatraFilter
    with MustacheSupport
    with i18nSupport
    with ConfigurableView
    with SessionSupport {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    setupSession(request, response)

    val language = LiferayHelpers.getLanguage(request)
    val out = response.getWriter
    val contextPath = request.getContextPath
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val courseID = themeDisplay.getLayout.getGroupId
    val userID = themeDisplay.getUser.getUserId
    val hasTeacherPermissions = userRoleService.hasTeacherPermissions(userID, courseID)

    if (hasTeacherPermissions)
      out.println(generateResponse(contextPath, "statement_viewer.html", language, courseID))
    else
      out.println(generateErrorResponse(contextPath, "scorm_nopermissions.html", language))
  }

  def generateErrorResponse(contextPath: String, templateName: String, language: String) = {
    val translations = try {
      getTranslation("/i18n/error_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/error_en")
      case _                        => Map[String, String]()
    }
    val data = Map("contextPath" -> contextPath, "language" -> language) ++ translations
    mustache(data, templateName)
  }

  def generateResponse(contextPath: String, templateName: String, language: String, courseID: Long) = {
    val translations = try {
      getTranslation("/i18n/statementViewer_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/statementViewer_en")
      case _                        => Map[String, String]()
    }
    val data = Map("contextPath" -> contextPath, "language" -> language, "courseID" -> courseID) ++ translations
    mustache(data, templateName)
  }
}
