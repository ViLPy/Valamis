package com.arcusys.learn.controllers.api

import javax.servlet.http.HttpServletResponse

import com.arcusys.learn.bl.exceptions.{ PassingLimitExceededException, DuplicateEntityException, EntityNotFoundException }
import com.arcusys.learn.controllers.auth.LiferayBasicAuthSupport
import com.arcusys.learn.exceptions.{ BadRequestException, AccessDeniedException, NotAuthorizedException }
import com.arcusys.learn.tincan.lrs.statement.StatementLRSArgumentException
import com.arcusys.learn.util.JsonSupport
import com.arcusys.learn.view.extensions.i18nSupport
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import com.liferay.portal.NoSuchUserException
import com.thoughtworks.paranamer.ParameterNamesNotFoundException
import org.json4s.jackson.Serialization
import org.json4s.{ Formats, NoTypeHints }
import org.scalatra.{ RailsPathPatternParser, ScalatraServlet }

abstract class BaseMobileApiController(configuration: BindingModule) extends ScalatraServlet with JsonSupport with Injectable with i18nSupport with LiferayBasicAuthSupport {

  implicit override def string2RouteMatcher(path: String) = RailsPathPatternParser(path)
  implicit val bindingModule = configuration

  def jsonAction(a: => Any)(implicit formats: Formats = Serialization.formats(NoTypeHints)): Any = {
    response.setHeader("Content-Type", "application/json; charset=UTF-8")
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

      case e: NotAuthorizedException          => halt(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage)
      case e: AccessDeniedException           => halt(HttpServletResponse.SC_FORBIDDEN, e.getMessage)
      case e: BadRequestException             => halt(HttpServletResponse.SC_BAD_REQUEST, e.getMessage)
      case e: StatementLRSArgumentException   => halt(HttpServletResponse.SC_BAD_REQUEST, e.getMessage)
      case e: EntityNotFoundException         => halt(HttpServletResponse.SC_NOT_FOUND, e.getMessage)
      case e: NoSuchElementException          => halt(HttpServletResponse.SC_NOT_FOUND, e.getMessage)
      case e: DuplicateEntityException        => halt(HttpServletResponse.SC_CONFLICT, e.getMessage)
      case e: NoSuchUserException             => halt(HttpServletResponse.SC_NOT_FOUND, e.getMessage, reason = "No user exists")
      case e: PassingLimitExceededException   => halt(HttpServletResponse.SC_FORBIDDEN)
      case e: ParameterNamesNotFoundException => halt(HttpServletResponse.SC_BAD_REQUEST, e.getMessage)
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
}
