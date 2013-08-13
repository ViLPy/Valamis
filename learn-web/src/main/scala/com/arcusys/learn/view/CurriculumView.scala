package com.arcusys.learn.view

import javax.portlet.{RenderResponse, RenderRequest, GenericPortlet}
import liferay.LiferayHelpers
import org.scalatra.ScalatraFilter
import com.arcusys.scala.scalatra.mustache.MustacheSupport
import java.io.FileNotFoundException
import com.liferay.portal.util.{LayoutTypePortletFactoryUtil, PortalUtil}
import com.liferay.portal.service.LayoutLocalServiceUtil
import com.liferay.portlet.PortletURLUtil

/**
 * User: Yulia.Glushonkova
 * Date: 07.06.13
 */
class CurriculumView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport with ConfigurableView {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val userID = if (request.getRemoteUser != null) request.getRemoteUser.toInt else null.asInstanceOf[Int]
    val language = LiferayHelpers.getLanguage(request)
    val path = request.getContextPath


    if (userID == 0){
      val translations = getTranslation("error", language)
      val data = mustache(Map("contextPath" -> path, "language" -> language) ++ translations, "scorm_nopermissions.html")
      response.getWriter.println(data)
    }
    else{
    val courseID = themeDisplay.getScopeGroupId
    val httpServletRequest = PortalUtil.getHttpServletRequest(request)
    val url = getRootUrl(request, response)

    httpServletRequest.getSession.setAttribute("userID", userID)

    val translations = getTranslation("curriculum", language)
    val companyId = PortalUtil.getCompanyId(request)

    val data = Map("root"-> url, "contextPath" -> path, "userID" -> userID, "isAdmin" -> userManagement.isAdmin(userID, courseID),
      "language" -> language, "courseID" -> courseID, "companyID" -> companyId) ++ translations

    val html = if (userManagement.hasTeacherPermissions(userID, courseID)) "curriculum_admin.html"
                else "curriculum_user.html"

    response.getWriter.println(generateResponse(data, html))
    }
  }

  private def getRootUrl(request: RenderRequest, response: RenderResponse)={
    val url = PortletURLUtil.getCurrent(request, response)
    val parts = url.toString.split("/")
    if (parts.length > 2) parts.tail.tail.head else ""
  }

  def generateResponse(data: Map[String, Any], templateName: String) = {
    mustache(data, templateName)
  }

  private def getTranslation(view: String, language: String): Map[String, String] = {
    try {
      getTranslation("/i18n/" + view + "_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/" + view + "_en")
      case _ => Map[String, String]()
    }
  }

}
