package com.arcusys.learn.view.liferay

import javax.portlet.RenderRequest
import com.liferay.portal.model.User
import com.liferay.portal.kernel.util.WebKeys
import com.liferay.portal.theme.ThemeDisplay

object LiferayHelpers {
  def getUserName(request: RenderRequest) = {
    val user = (request.getAttribute(WebKeys.USER)).asInstanceOf[User]
    if(user != null) user.getFullName
    else ""
  }

  def getLanguage(request: RenderRequest) = {
    val theme = (request.getAttribute(WebKeys.THEME_DISPLAY)).asInstanceOf[ThemeDisplay]
    if(theme != null) theme.getLocale.getLanguage
    else "en"
  }
}
