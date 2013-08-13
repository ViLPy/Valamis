package com.arcusys.learn.view

import com.arcusys.scala.scalatra.mustache.MustacheSupport
import javax.portlet._
import org.scalatra.ScalatraFilter
import com.arcusys.learn.view.liferay.LiferayHelpers
import java.io.FileNotFoundException
import com.liferay.portal.util.PortalUtil


class GradebookView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport with ConfigurableView {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    val userUID = if (request.getRemoteUser != null) request.getRemoteUser.toInt else null.asInstanceOf[Int]

    val httpServletRequest = PortalUtil.getHttpServletRequest(request)
    httpServletRequest.getSession.setAttribute("userID", userUID)

    val userName = LiferayHelpers.getUserName(request)
    val lang = LiferayHelpers.getLanguage(request)
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val courseID = themeDisplay.getLayout.getGroupId
    val contextPath = request.getContextPath

    if (userManagement.isLearnUser(userUID, courseID)) {
      response.getWriter.println(generateResponse(userUID, userName, lang, request.getContextPath, isPortlet = true,
        //isAdmin = request.isUserInRole("administrator"),
        isAdmin = userManagement.hasTeacherPermissions(userUID, courseID), courseID = courseID))
    }
    else {
      response.getWriter.println(generateErrorResponse(contextPath, "scorm_nopermissions.html", lang))
    }
  }

  def generateResponse(userID: Int, userName: String, language: String, contextPath: String, isPortlet: Boolean, isAdmin: Boolean, courseID: Long) = {
    val translations = try {
      getTranslation("/i18n/gradebook_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/gradebook_en")
      case _ => Map[String, String]()
    }

    val users = userManagement.getStudentsWithAttemptsByCourseID(courseID)
    val packages = packageService.getPackagesWithAttemptsByCourseID(courseID, if (isAdmin) 0 else userID)

    val data = Map(
      "userID" -> userID,
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
      case _ => Map[String, String]()
    }
    val data = Map("contextPath" -> contextPath, "language" -> language) ++ translations
    mustache(data, templateName)
  }
}