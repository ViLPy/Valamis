package com.arcusys.learn.view

import com.arcusys.scala.scalatra.mustache.MustacheSupport
import javax.portlet._
import org.scalatra.ScalatraFilter
import com.arcusys.learn.view.liferay.LiferayHelpers
import com.arcusys.learn.storage.impl.orbroker.StorageFactory
import com.arcusys.learn.scorm.tracking.model.User
import java.io.FileNotFoundException
import com.arcusys.learn.liferay.service.PackageIndexer
import com.liferay.portlet.PortletURLUtil

class UserView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport {
  override def destroy() {}

  val userStorage = StorageFactory.userStorage

  override def doView(request: RenderRequest, response: RenderResponse) {
    val userUID = request.getRemoteUser
    if (userUID != null && userStorage.getByID(userUID.toInt).isEmpty) {
      userStorage.createAndGetID(User(userUID.toInt, LiferayHelpers.getUserName(request)))
    }
    val out = response.getWriter
    val language = LiferayHelpers.getLanguage(request)
    val translations = try {
      getTranslation("/i18n/player_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/player_en")
      case _ => Map[String, String]()
    }
    val data = Map("contextPath" -> request.getContextPath,
      "entryID" -> request.getParameter("entryID"),
      "userID" -> userUID,
      "userName" -> LiferayHelpers.getUserName(request),
      "isAdmin" -> request.isUserInRole("administrator"),
      "language" -> language,
      "isPortlet" -> true) ++ translations
    out.println(generateResponse(data, "player.html"))
  }

  get("/") {
    val lang = "en"
    val userUID = "12345"
    userStorage.getByID(userUID.toInt).getOrElse(userStorage.createAndGetID(User(userUID.toInt, "John Doe")))
    val translations = try {
      getTranslation("/i18n/player_" + lang)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/player_en")
      case _ => Map[String, String]()
    }
    val data = Map("contextPath" -> servletContext.getContextPath,
      "userID" -> userUID,
      "isAdmin" -> false,
      "language" -> lang,
      "isPortlet" -> false) ++ translations
    "<div class='portlet-learn-scorm'>" + generateResponse(data, "player.html") + "</div>"
  }

  def generateResponse(data: Map[String, Any], templateName: String) = {
    mustache(data, templateName)
  }
}