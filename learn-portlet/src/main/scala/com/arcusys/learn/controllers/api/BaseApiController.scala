package com.arcusys.learn.controllers.api

import javax.servlet.http.HttpServletResponse

import com.arcusys.learn.exceptions.{ AccessDeniedException, BadRequestException, DuplicateEntityException, EntityNotFoundException }
import com.arcusys.learn.tincan.lrs.statement.StatementLRSArgumentException
import com.arcusys.learn.view.i18nSupport
import com.arcusys.learn.web.ServletBase
import com.escalatesoft.subcut.inject.BindingModule
import com.liferay.portal.NoSuchUserException
import org.json4s.jackson.Serialization
import org.json4s.{ Formats, NoTypeHints }
import org.scalatra.RailsPathPatternParser

abstract class BaseApiController(configuration: BindingModule) extends ServletBase(configuration) with i18nSupport {

  implicit override def string2RouteMatcher(path: String) = RailsPathPatternParser(path)

  def jsonAction(a: => Any)(implicit formats: Formats = Serialization.formats(NoTypeHints)): Any = {
    response.setHeader("Content-Type", "application/json; charset=UTF-8")
    //implicit val formats: Formats = DefaultFormats + new StatementSerializer
    action {
      val result = a

      if (result != null && !result.isInstanceOf[Unit])
        return json(result).get
      else
        halt(HttpServletResponse.SC_NO_CONTENT)
    }
  }

  def action(action: => Any): Any = {
    try {
      action
    } catch {

      case e: AccessDeniedException         => halt(HttpServletResponse.SC_FORBIDDEN)
      case e: BadRequestException           => halt(HttpServletResponse.SC_BAD_REQUEST)
      case e: StatementLRSArgumentException => halt(HttpServletResponse.SC_BAD_REQUEST)
      case e: EntityNotFoundException       => halt(HttpServletResponse.SC_NOT_FOUND)
      case e: NoSuchElementException        => halt(HttpServletResponse.SC_NOT_FOUND)
      case e: DuplicateEntityException      => halt(HttpServletResponse.SC_CONFLICT)
      case e: NoSuchUserException           => halt(HttpServletResponse.SC_NOT_FOUND, reason = "No user exists")
      case e: Exception => {
        log(e.getMessage, e)
        halt(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
      }
    }
  }

  after() {
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
  }

  protected def getTranslation() = {
    val lang = sessionHandler.getAttribute(super.request.getCookies, "language")
    super.getTranslation("/i18n/curriculum_" + lang)
  }
}
