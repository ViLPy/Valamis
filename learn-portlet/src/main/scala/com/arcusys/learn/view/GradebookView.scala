package com.arcusys.learn.view

import java.io.FileNotFoundException
import javax.portlet._
import javax.servlet.http.Cookie

import com.arcusys.learn.liferay.util.PortalUtilHelper
import com.arcusys.learn.service.util.SessionHandler
import com.arcusys.learn.util.MustacheSupport
import com.arcusys.learn.view.liferay.LiferayHelpers
import org.scalatra.ScalatraFilter

class GradebookView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport with ConfigurableView {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    val userUID = if (request.getRemoteUser != null) request.getRemoteUser.toInt else null.asInstanceOf[Int]

    val httpServletRequest = PortalUtilHelper.getHttpServletRequest(request)
    httpServletRequest.getSession.setAttribute("userID", userUID)

    // get data from liferay
    val lang = LiferayHelpers.getLanguage(request)
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val courseID = themeDisplay.getLayout.getGroupId
    val contextPath = request.getContextPath

    // Cookies
    val sessionID = SessionHandler.getSessionID(request.getRemoteUser)
    val cookie = new Cookie("valamisSessionID", sessionID)
    cookie.setMaxAge(-1)
    cookie.setPath("/")
    response.addProperty(cookie)
    SessionHandler.setAttribute(sessionID, "userID", request.getRemoteUser)
    SessionHandler.setAttribute(sessionID, "isAdmin", userManagement.isAdmin(userUID, courseID))
    SessionHandler.setAttribute(sessionID, "hasTeacherPermissions", userManagement.hasTeacherPermissions(userUID, courseID))

    // for poller auth we encrypt company key + userID
    val company = themeDisplay.getCompany();
    val encryptedUserId = com.liferay.util.Encryptor.encrypt(company.getKeyObj(), "" + userUID);

    if (userManagement.isLearnUser(userUID, courseID)) {
      response.getWriter.println(generateResponse(userUID,
        encryptedUserId,
        themeDisplay.getPortletDisplay.getRootPortletId,
        lang,
        request.getContextPath,
        isAdmin = userManagement.hasTeacherPermissions(userUID, courseID), courseID = courseID)
      )
    } else {
      response.getWriter.println(generateErrorResponse(contextPath, "scorm_nopermissions.html", lang))
    }
  }

  def generateResponse(userID: Int,
    encryptUserID: String,
    portletID: String,
    language: String,
    contextPath: String,
    isAdmin: Boolean,
    courseID: Long) = {

    val translations = try {
      getTranslation("/i18n/gradebook_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/gradebook_en")
      case _: Throwable             => Map[String, String]()
    }

    val packages = packageFacade.getPackagesByCourse(courseID.toInt)
    //packageService.getPackagesWithAttemptsByCourseID(courseID, if (isAdmin) 0 else userID)

    val data = Map(
      "userID" -> userID,
      "encryptUserID" -> encryptUserID,
      "portletID" -> portletID,
      "contextPath" -> contextPath,
      "isAdmin" -> isAdmin,
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