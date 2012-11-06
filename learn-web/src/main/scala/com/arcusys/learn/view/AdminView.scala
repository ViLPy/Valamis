package com.arcusys.learn.view

import com.arcusys.scala.scalatra.mustache.MustacheSupport
import javax.portlet._
import org.scalatra.ScalatraFilter
import com.arcusys.learn.view.liferay.LiferayHelpers
import com.arcusys.learn.storage.impl.orbroker.StorageFactory
import com.arcusys.learn.scorm.tracking.model.User
import java.io.FileNotFoundException

class AdminView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport {
  override def destroy() {}

  val userStorage = StorageFactory.userStorage

  override def doView(request: RenderRequest, response: RenderResponse) {
    val userUID = request.getRemoteUser
    val groupID = LiferayHelpers.getThemeDisplay(request).getScopeGroupId

    val out = response.getWriter
    val language = LiferayHelpers.getLanguage(request)
    val translations = try {
      getTranslation("/i18n/admin_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/admin_en")
      case _ => Map[String, String]()
    }
    val data = Map("contextPath" -> request.getContextPath,
      "userID" -> userUID,
      "groupID" -> groupID,
      "isAdmin" -> request.isUserInRole("administrator"),
      "language" -> language,
      "isPortlet" -> true) ++ translations
    out.println(generateResponse(data, "scorm_admin.html"))
  }

  get("/ScormAdmin") {
    val lang = "en"
    val translations = try {
      getTranslation("/i18n/admin_" + lang)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/admin_en")
      case _ => Map[String, String]()
    }
    val data = Map("contextPath" -> servletContext.getContextPath,
      "isAdmin" -> true,
      "userID" -> -1,
      "groupID" -> -1,
      "language" -> lang,
      "isPortlet" -> false) ++ translations
    "<div class='portlet-learn-scorm'>" + generateResponse(data, "scorm_admin.html") + "</div>"
  }

  def generateResponse(data: Map[String, Any], templateName: String) = {
    mustache(data, templateName)
  }
}