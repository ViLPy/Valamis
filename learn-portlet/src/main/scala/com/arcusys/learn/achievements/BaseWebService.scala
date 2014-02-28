package com.arcusys.learn.achievements

import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.scala.json.Json
import com.arcusys.learn.exceptions.{BadRequestException, AccessDeniedException}
import com.arcusys.learn.view.i18nSupport
import javax.servlet.http.{HttpServletResponse}

abstract class BaseWebService (configuration: BindingModule) extends ServletBase(configuration) with i18nSupport {

  def action(action: => scala.Any): scala.Any = {
    try {
      val result = action

      if (result != null)
        Json.toJson(result)
    } catch {

      case e: AccessDeniedException => halt(HttpServletResponse.SC_UNAUTHORIZED)

      case e: BadRequestException => halt(HttpServletResponse.SC_BAD_REQUEST)

      case e: Exception => {
        log(e.getMessage, e)
        halt(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
      }
    }
  }

  protected def getTranslation() = {
    val lang = sessionHandler.getAttribute(super.request.getCookies, "language")
    super.getTranslation("/i18n/curriculum_" + lang)
  }
}
