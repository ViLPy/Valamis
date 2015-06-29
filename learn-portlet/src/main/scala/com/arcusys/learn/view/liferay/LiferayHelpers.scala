package com.arcusys.learn.view.liferay

import javax.portlet.RenderRequest
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.constants.WebKeysHelper

object LiferayHelpers {
  def getUser(request: RenderRequest) = {
    request.getAttribute(WebKeysHelper.USER).asInstanceOf[LUser]
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
    val theme = request.getAttribute(WebKeysHelper.THEME_DISPLAY).asInstanceOf[LThemeDisplay]
    if (theme != null) theme.getLayout.getCompanyId
    else 0L
  }

  def getThemeDisplay(request: RenderRequest) = {
    request.getAttribute(WebKeysHelper.THEME_DISPLAY).asInstanceOf[LThemeDisplay]
  }

  def getLanguage(request: RenderRequest) = {
    val theme = request.getAttribute(WebKeysHelper.THEME_DISPLAY).asInstanceOf[LThemeDisplay]
    if (theme != null) theme.getLocale.getLanguage
    else "en"
  }

  def getPortletID(request: RenderRequest) = {
    request.getAttribute(WebKeysHelper.PORTLET_ID).asInstanceOf[String]
  }

}
