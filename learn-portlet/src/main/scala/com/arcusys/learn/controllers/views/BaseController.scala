package com.arcusys.learn.controllers.views

import javax.portlet.{ RenderResponse, RenderRequest, GenericPortlet }
import org.scalatra.ScalatraFilter
import com.escalatesoft.subcut.inject.Injectable
import com.arcusys.learn.liferay.util.PortalUtilHelper
import com.arcusys.learn.service.util.SessionHandler
import javax.servlet.http.Cookie
import com.arcusys.learn.models.view.BaseViewModel
import com.arcusys.learn.util.MustacheSupport
import com.arcusys.learn.view.liferay.LiferayHelpers

/**
 * Created by Iliya Tryapitsin on 19.03.14.
 */
abstract class BaseController extends GenericPortlet
    with ScalatraFilter
    with MustacheSupport
    with i18nSupport
    with ConfigurableView
    with Injectable {

  implicit val formats = org.json4s.DefaultFormats

  override def destroy() {}

  protected def renderView(request: RenderRequest,
    response: RenderResponse,
    viewTemplateName: String,
    baseViewModel: BaseViewModel.Model) = {

    //    val templateName = if (userManagement.hasTeacherPermissions(baseViewModel.getUserId, baseViewModel.getCourseId)) {
    //      setSessionData(request, response, baseViewModel)
    //      viewTemplateName
    //    } else "scorm_nopermissions.html"
    val result = mustache(Seq(), viewTemplateName)
    response.getWriter.println(result)
  }

  protected def setSessionData(request: RenderRequest,
    response: RenderResponse,
    baseViewModel: BaseViewModel.Model) = {
    val sessionId = SessionHandler.getSessionID(request.getRemoteUser)
    val cookie = new Cookie("valamisSessionID", sessionId)
    cookie.setMaxAge(-1)
    cookie.setPath("/")
    response.addProperty(cookie)

    SessionHandler.setAttribute(
      sessionId,
      "userID",
      request.getRemoteUser)

    SessionHandler.setAttribute(
      sessionId,
      "hasTeacherPermissions",
      userManagement.hasTeacherPermissions(
        baseViewModel.getUserId,
        baseViewModel.getCourseId))

    SessionHandler.setAttribute(
      sessionId,
      "isAdmin",
      userManagement.isAdmin(
        baseViewModel.getUserId,
        baseViewModel.getCourseId))

    SessionHandler.setAttribute(
      sessionId,
      "language",
      baseViewModel.getLanguage)

    val httpServletRequest = PortalUtilHelper.getHttpServletRequest(request)
    httpServletRequest.getSession.setAttribute("userID", baseViewModel.getUserId)
  }

  protected def getUser(implicit req: RenderRequest) = LiferayHelpers.getUser(req)
  protected def getLanguage(implicit req: RenderRequest) = LiferayHelpers.getLanguage(req)
  protected def getThemeDisplay(implicit req: RenderRequest) = LiferayHelpers.getThemeDisplay(req)
  protected def getCourseId(implicit req: RenderRequest) = LiferayHelpers.getThemeDisplay(req).getLayout.getGroupId
  protected def getUserUID(implicit req: RenderRequest) =
    if (request.getRemoteUser != null) request.getRemoteUser.toInt
    else null.asInstanceOf[Int]

}
