package com.arcusys.learn.controllers.views

import javax.portlet._
import java.io.FileNotFoundException

import com.arcusys.valamis.lesson.service.PackageService
import com.arcusys.valamis.user.service.UserService

class GradebookViewController extends BaseController {
  lazy val userService = inject[UserService]
  lazy val packageService = new PackageService()

  override def doView(request: RenderRequest, response: RenderResponse) {
    val result = mustache(Seq(), "gradebook.html")
    response.getWriter.println(result)
  }

  def generateResponse(userID: Int, encryptuserID: String, portletID: String, userName: String, language: String, contextPath: String, isPortlet: Boolean, isAdmin: Boolean, courseID: Long) = {
    val translations = try {
      getTranslation("/i18n/gradebook_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/gradebook_en")
      case _: Throwable             => Map[String, String]()
    }

    val users = userService.getUsersWithAttemptsByCourseID(courseID)

    val packages = packageService.getPackagesWithAttemptsByCourseID(courseID, if (isAdmin) 0 else userID)

    val data = Map(
      "userID" -> encryptuserID,
      "portletID" -> portletID,
      "userName" -> userName,
      "contextPath" -> contextPath,
      "isAdmin" -> isAdmin,
      "isPortlet" -> isPortlet,
      "users" -> users,
      "packages" -> packages,
      "language" -> language,
      "courseID" -> courseID
    ) ++ translations
    mustache(data, "gradebook.html")
  }

  def generateErrorResponse(contextPath: String, templateName: String, language: String) = {
    val translations = try {
      getTranslation("/i18n/error_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/error_en")
      case _: Throwable             => Map[String, String]()
    }
    val data = Map("contextPath" -> contextPath, "language" -> language) ++ translations
    mustache(data, templateName)
  }
}