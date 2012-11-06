package com.arcusys.learn.view

import com.arcusys.scala.scalatra.mustache.MustacheSupport
import javax.portlet._
import liferay.LiferayHelpers
import org.scalatra.ScalatraFilter
import java.io.FileNotFoundException

class QuizView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) = {
    val language = LiferayHelpers.getLanguage(request)
    val userUID = request.getRemoteUser
    val groupID = LiferayHelpers.getThemeDisplay(request).getScopeGroupId
    val out = response.getWriter
    val path = request.getContextPath
    out.println(generateResponse(path, "scorm_quiz.html", language, true, request.isUserInRole("administrator"),
      Map("userID" -> userUID, "groupID" -> groupID.toString)))
  }

  get("/Quiz") {
    val path = servletContext.getContextPath
    "<div class='portlet-learn-scorm'>" + generateResponse(path, "scorm_quiz.html", "en", false, true,
      Map("userID" -> "-1", "groupID" -> "-1")) + "</div>"
  }

  def generateResponse(contextPath: String, templateName: String, language: String, isPortlet: Boolean, isAdmin: Boolean, subData: Map[String, String] = Map()) = {
    val translations = try {
      getTranslation("/i18n/quiz_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/quiz_en")
      case _ => Map[String, String]()
    }
    val data = Map("contextPath" -> contextPath, "isAdmin" -> isAdmin, "isPortlet" -> isPortlet, "language" -> language) ++ subData ++ translations
    mustache(data, templateName)
  }
}