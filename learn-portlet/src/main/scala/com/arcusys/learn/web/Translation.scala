package com.arcusys.learn.web

import com.arcusys.learn.service.util.SessionHandler
import javax.portlet.RenderRequest
import com.arcusys.learn.view.i18nSupport
import javax.servlet.http.HttpServletRequest

trait Translation extends ServletBase with i18nSupport{
  def getTranslation() = {
    val lang = SessionHandler.getAttribute(super.request.getCookies, "language")
    super.getTranslation("/i18n/curriculum_" + lang)
  }
}
