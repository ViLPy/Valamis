package com.arcusys.learn.view

import javax.portlet._

import com.arcusys.learn.liferay.permission.{PermissionUtil, PublishPermission}
import com.arcusys.learn.liferay.util.{PortalUtilHelper, PortletURLUtilHelper}
import com.arcusys.learn.view.extensions._
import com.arcusys.learn.view.liferay.LiferayHelpers

/**
 * User: Yulia.Glushonkova
 * Date: 07.06.13
 */
abstract class CurriculumAbstract extends OAuthPortlet with BaseView {

  override def destroy() {}

  def generateResponse(data: Map[String, Any], templateName: String) = {
    getTemplate("/templates/2.0/curriculum_templates.html") +
      getTemplate("/templates/2.0/paginator.html") +
      getTemplate("/templates/2.0/site_select_templates.html") +
      getTemplate("/templates/2.0/image_gallery_templates.html") +
      getTemplate("/templates/2.0/user_select_templates.html") +
      getTemplate("/templates/2.0/file_uploader.html") +
      mustache(data, templateName)
  }

  def doEditViewHelper(request: RenderRequest, response: RenderResponse) {
    val out = response.getWriter
    val language = LiferayHelpers.getLanguage(request)

    val data = Map(
      "language" -> language,
      "certificateActionURL" -> response.createResourceURL(),
      "companyID" -> PortalUtilHelper.getCompanyId(request),
      "portletID" -> request.getAttribute("PORTLET_ID"),
      "contextPath" -> request.getContextPath
    ) ++ getTranslation("curriculum", language)
    out.println(
      getTemplate("/templates/2.0/curriculum_templates.html") +
        getTemplate("/templates/2.0/file_uploader.html") +
        mustache(data, "curriculum_settings.html")
    )
  }

  protected def doViewHelper(request: RenderRequest, response: RenderResponse): SecurityData = {

    val language = LiferayHelpers.getLanguage(request)

    val httpServletRequest = PortalUtilHelper.getHttpServletRequest(request)
    val url = getRootUrl(request, response)

    val translations = getTranslation("curriculum", language)

    val securityScope = getSecurityData(request)
    httpServletRequest.getSession.setAttribute("userID", securityScope.userId)
    val publishPermission = PermissionUtil.hasPermission(securityScope.courseId, securityScope.portletId, securityScope.primaryKey, PublishPermission)

    securityScope.data = securityScope.data ++
      Map(
        "root" -> url,
        "isAdmin" -> securityScope.permissionToModify,
        "permissionToPublish" -> publishPermission,
        "language" -> language
      ) ++ translations

    securityScope
  }

  private def getRootUrl(request: RenderRequest, response: RenderResponse) = {
    val url = PortletURLUtilHelper.getCurrent(request, response)
    val parts = url.toString.split("/")
    if (parts.length > 2) parts.tail.tail.head else ""
  }
}

class CurriculumAdmin extends CurriculumAbstract {
  override def doView(request: RenderRequest, response: RenderResponse) {
    val scope = super.doViewHelper(request: RenderRequest, response: RenderResponse)
    response.getWriter.println(generateResponse(scope.data, "curriculum_admin.html"))
  }

  override def doEdit(request: RenderRequest, response: RenderResponse) {
    doEditViewHelper(request, response)
  }

}

class CurriculumUser extends CurriculumAbstract {
  override def doView(request: RenderRequest, response: RenderResponse) {
    val html = "curriculum_user.html"
    val scope = super.doViewHelper(request: RenderRequest, response: RenderResponse)
    response.getWriter.println(generateResponse(scope.data, html))
  }

  override def doEdit(request: RenderRequest, response: RenderResponse) {
    doEditViewHelper(request, response)
  }

}