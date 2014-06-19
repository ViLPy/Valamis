package com.arcusys.learn.models.view

import javax.portlet.{ RenderResponse, RenderRequest }
import com.arcusys.learn.view.liferay.LiferayHelpers
import com.arcusys.learn.liferay.util.PortalUtilHelper
import com.liferay.portlet.PortletURLUtil

/**
 * Created by Iliya Tryapitsin on 19.03.14.
 */

object BaseViewModel {
  val USER_ID = "userId"
  val ROOT_URL = "rootUrl"
  val CONTEXT_PATH = "contextPath"
  val COMPANY_ID = "companyID"

  def apply(request: RenderRequest,
    response: RenderResponse) = new Model(request, response)

  class Model(request: RenderRequest,
      response: RenderResponse) {

    def getUserId =
      if (request.getRemoteUser != null)
        request.getRemoteUser.toInt
      else
        null.asInstanceOf[Int]

    def getLanguage = LiferayHelpers.getLanguage(request)
    def getCompanyId = PortalUtilHelper.getCompanyId(request)
    def getCourseId = LiferayHelpers
      .getThemeDisplay(request)
      .getScopeGroupId()

    def getRootUrl = {
      val url = PortletURLUtil.getCurrent(request, response)
      val parts = url.toString.split("/")
      if (parts.length > 2)
        parts.tail.tail.head
      else
        ""
    }

    def toMap: Map[String, Any] = Map(
      USER_ID -> getUserId,
      ROOT_URL -> getRootUrl,
      CONTEXT_PATH -> request.getContextPath,
      COMPANY_ID -> getCompanyId
    )
  }
}