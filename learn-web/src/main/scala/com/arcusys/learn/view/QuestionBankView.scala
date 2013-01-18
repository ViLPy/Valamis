package com.arcusys.learn.view

import com.arcusys.scala.scalatra.mustache.MustacheSupport
import javax.portlet._
import liferay.LiferayHelpers
import org.scalatra.ScalatraFilter
import java.io.FileNotFoundException
import com.liferay.portal.theme.ThemeDisplay
import com.liferay.portal.kernel.util.WebKeys
import com.arcusys.scorm.lms.UserManagement

class QuestionBankView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) = {
    val language = LiferayHelpers.getLanguage(request)
    val out = response.getWriter
    val contextPath = request.getContextPath
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val courseID = themeDisplay.getLayout.getGroupId
    val userID = themeDisplay.getUser.getUserId
    val isAdmin = UserManagement.hasTeacherPermissions(userID, courseID)
    if (isAdmin)
      out.println(generateResponse(contextPath, "scorm_questionbank.html", language, true, courseID))
    else
      out.println(generateResponse(contextPath, "scorm_nopermissions.html", language))
  }

  before() {
    contentType = "text/html"
  }

  def generateResponse(contextPath: String, templateName: String, language: String) = {
    val translations = try {
      getTranslation("/i18n/error_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/error_en")
      case _ => Map[String, String]()
    }
    val data = Map("contextPath" -> contextPath, "language" -> language) ++ translations
    mustache(data, templateName)
  }

  def generateResponse(contextPath: String, templateName: String, language: String, isPortlet: Boolean, courseID: Long) = {
    val translations = try {
      getTranslation("/i18n/questionbank_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/questionbank_en")
      case _ => Map[String, String]()
    }
    val data = Map("contextPath" -> contextPath, "isPortlet" -> isPortlet, "language" -> language, "courseID"->courseID) ++ translations
    mustache(data, templateName)
  }
}