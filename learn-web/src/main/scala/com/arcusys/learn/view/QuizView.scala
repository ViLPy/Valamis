package com.arcusys.learn.view

import com.arcusys.scala.scalatra.mustache.MustacheSupport
import javax.portlet._
import liferay.LiferayHelpers
import org.scalatra.ScalatraFilter
import java.io.FileNotFoundException
import com.liferay.portal.kernel.util.WebKeys
import com.liferay.portal.theme.ThemeDisplay
import com.arcusys.scorm.lms.UserManagement

class QuizView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) = {
    val language = LiferayHelpers.getLanguage(request)
    val userUID = request.getRemoteUser
    val out = response.getWriter
    val path = request.getContextPath
    val theme = LiferayHelpers.getThemeDisplay(request)
    val courseID = theme.getLayout.getGroupId

    val hasPermissions = UserManagement.hasTeacherPermissions(userUID.toInt, courseID)
    if (hasPermissions)  {
      val groupID = theme.getScopeGroupId
      val translations = getTranslation("quiz", language)
      val map = Map("contextPath" -> path, "isAdmin" -> hasPermissions, "isPortlet" -> true, "language" -> language, "courseID"->courseID) ++ Map("userID" -> userUID, "groupID" -> groupID.toString) ++ translations
      val data = mustache(map, "scorm_quiz.html")
      out.println(data)
    }
    else
    {
      val translations = getTranslation("error", language)
      val data = mustache(Map("contextPath" -> path, "language" -> language) ++ translations, "scorm_nopermissions.html")
      out.println(data)
    }
  }

  private def getTranslation(view: String, language: String): Map[String, String] ={
    try {
      getTranslation("/i18n/"+ view + "_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/"+view+"_en")
      case _ => Map[String, String]()
    }
  }
}