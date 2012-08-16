package com.arcusys.learn.view

import com.arcusys.scala.scalatra.mustache.MustacheSupport
import javax.portlet._
import liferay.LiferayHelpers
import org.scalatra.ScalatraFilter
import java.io.FileNotFoundException

class QuestionBankView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport {
  override def destroy {}

  override def doView(request: RenderRequest, response: RenderResponse) = {
    val language = LiferayHelpers.getLanguage(request)
    val out = response.getWriter
    val contextPath = request.getContextPath
    out.println(generateResponse(contextPath, "scorm_questionbank.html", language, isPortlet = true))
  }

  before() {
    contentType = "text/html"
  }

  get("/QuestionBank") {
    val contextPath = servletContext.getContextPath
    "<div class='portlet-learn-scorm'>" + generateResponse(contextPath, "scorm_questionbank.html", "en", isPortlet = false) + "</div>"
  }

  def generateResponse(contextPath: String, templateName: String, language: String, isPortlet: Boolean) = {
    val translations = try {
      getTranslation("/i18n/questionbank_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/questionbank_en")
      case _ => Map[String, String]()
    }
    val data = Map("contextPath" -> contextPath, "isPortlet" -> isPortlet, "language" -> language) ++ translations
    mustache(data, templateName)
  }
}