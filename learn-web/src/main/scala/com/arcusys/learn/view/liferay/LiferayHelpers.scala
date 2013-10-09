package com.arcusys.learn.view.liferay

import javax.portlet.RenderRequest
import com.liferay.portal.model.User
import com.liferay.portal.kernel.util.WebKeys
import com.liferay.portal.theme.ThemeDisplay

object LiferayHelpers {
  def getUser(request: RenderRequest) = {
    (request.getAttribute(WebKeys.USER)).asInstanceOf[User]
  }

  def getUserName(request: RenderRequest) = {
    val user = getUser(request)
    if (user != null) user.getFullName
    else ""
  }

  def getUserEmail(request: RenderRequest) = {
    val user = getUser(request)
    if (user != null) user.getEmailAddress
    else ""
  }

  def getCompanyID(request: RenderRequest) = {
    val theme = (request.getAttribute(WebKeys.THEME_DISPLAY)).asInstanceOf[ThemeDisplay]
    if (theme != null) theme.getLayout.getCompanyId
    else 0L
  }

  def getThemeDisplay(request: RenderRequest) = {
    (request.getAttribute(WebKeys.THEME_DISPLAY)).asInstanceOf[ThemeDisplay]
  }

  def getLanguage(request: RenderRequest) = {
    val theme = (request.getAttribute(WebKeys.THEME_DISPLAY)).asInstanceOf[ThemeDisplay]
    if (theme != null) theme.getLocale.getLanguage
    else "en"
  }

  def getPortletID(request: RenderRequest) = {
    (request.getAttribute(WebKeys.PORTLET_ID)).asInstanceOf[String]
  }

}
