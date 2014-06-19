package com.arcusys.learn.controllers.views

import javax.portlet._
import java.io.FileNotFoundException
import com.arcusys.learn.models.view.BaseViewModel

class GradebookViewController extends BaseController {
  override def doView(request: RenderRequest, response: RenderResponse) {
    //    val userUID = if (request.getRemoteUser != null) request.getRemoteUser.toInt else null.asInstanceOf[Int]

    //    val httpServletRequest = PortalUtilHelper.getHttpServletRequest(request)
    //    httpServletRequest.getSession.setAttribute("userID", userUID)

    //    val userName = LiferayHelpers.getUserName(request)
    //    val lang = LiferayHelpers.getLanguage(request)
    //    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    //    val courseID = themeDisplay.getLayout.getGroupId
    //    val contextPath = request.getContextPath
    //
    //    val sessionID = SessionHandler.getSessionID(request.getRemoteUser)
    //    val cookie = new Cookie("valamisSessionID", sessionID)
    //    cookie.setMaxAge(-1)
    //    cookie.setPath("/")
    //    response.addProperty(cookie)
    //    SessionHandler.setAttribute(sessionID, "userID", request.getRemoteUser)
    //    SessionHandler.setAttribute(sessionID, "isAdmin", userManagement.isAdmin(userUID, courseID))
    //    SessionHandler.setAttribute(sessionID, "hasTeacherPermissions", userManagement.hasTeacherPermissions(userUID, courseID))

    //    val company = themeDisplay.getCompany();
    //    val encryptedUserId = com.liferay.util.Encryptor.encrypt(company.getKeyObj(), userUID.toString);
    //
    //    if (userManagement.isLearnUser(userUID, courseID)) {
    //      response.getWriter.println(generateResponse(userUID, encryptedUserId, themeDisplay.getPortletDisplay.getRootPortletId, userName, lang, request.getContextPath, isPortlet = true,
    //        isAdmin = userManagement.hasTeacherPermissions(userUID, courseID), courseID = courseID))
    //    } else {
    //      response.getWriter.println(generateErrorResponse(contextPath, "scorm_nopermissions.html", lang))
    //    }

    renderView(request, response, "gradebook.html", new BaseViewModel.Model(request, response))
  }

  def generateResponse(userID: Int, encryptuserID: String, portletID: String, userName: String, language: String, contextPath: String, isPortlet: Boolean, isAdmin: Boolean, courseID: Long) = {
    val translations = try {
      getTranslation("/i18n/gradebook_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/gradebook_en")
      case _                        => Map[String, String]()
    }

    val users = userManagement.getStudentsWithAttemptsByCourseID(courseID)
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
      case _                        => Map[String, String]()
    }
    val data = Map("contextPath" -> contextPath, "language" -> language) ++ translations
    mustache(data, templateName)
  }
}