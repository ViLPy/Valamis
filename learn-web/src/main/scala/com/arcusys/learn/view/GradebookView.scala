package com.arcusys.learn.view

import com.arcusys.scala.scalatra.mustache.MustacheSupport
import javax.portlet._
import org.scalatra.ScalatraFilter
import com.arcusys.learn.storage.impl.orbroker.StorageFactory
import com.arcusys.learn.view.liferay.LiferayHelpers
import java.io.FileNotFoundException

class GradebookView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport {
  val attemptStorage = StorageFactory.attemptStorage

  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) = {
    val userUID = request.getRemoteUser.toInt
    val userName = LiferayHelpers.getUserName(request)
    val lang = LiferayHelpers.getLanguage(request)
    response.getWriter.println(generateResponse(userUID, userName, lang, request.getContextPath, isPortlet = true, isAdmin = request.isUserInRole("administrator")))
  }

  get("/Gradebook") {
    val lang = "en"
    "<div class='portlet-learn-scorm'>" + generateResponse(12345, "John Doe", lang, servletContext.getContextPath, isPortlet = false, isAdmin = true) + "</div>"
  }

  def generateResponse(userID: Int, userName: String, language: String, contextPath: String, isPortlet: Boolean, isAdmin: Boolean) = {
    val packages = if (isAdmin) attemptStorage.getPackagesWithAttempts.map(pack => Map("id" -> pack.id, "name" -> pack.title))
    else attemptStorage.getPackagesWithUserAttempts(userID).map(pack => Map("id" -> pack.id, "name" -> pack.title))

    val translations = try {
      getTranslation("/i18n/gradebook_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/gradebook_en")
      case _ => Map[String, String]()
    }

    val data = Map(
      "userID" -> userID,
      "userName" -> userName,
      "contextPath" -> contextPath,
      "isAdmin" -> isAdmin,
      "isPortlet" -> isPortlet,
      "users" -> attemptStorage.getUsersWithAttempts.map(user => Map("id" -> user.id, "name" -> user.name)),
      "packages" -> packages,
      "language" -> language
    ) ++ translations
    mustache(data, "gradebook.html")
  }
}