package com.arcusys.learn.web

import org.scalatra.{ ScalatraServlet }
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }
import com.arcusys.learn.service.util.{ OldParameterBase, Parameter, SessionHandlerContract }
import com.arcusys.learn.util.JsonSupport
import com.arcusys.learn.controllers.auth.{ LiferayAuthSupport }

trait ServletBase extends ScalatraServlet with JsonSupport with Injectable {

  implicit val sessionHandler = inject[SessionHandlerContract]

  @deprecated
  class JsonModelBuilder[T](transform: T => Map[String, Any]) {
    def apply(entity: T): String = json(transform(entity)).get

    def apply(entities: Seq[T]): String = json(entities.map(transform)).get

    def apply(entityOption: Option[T]): String = entityOption match {
      case Some(entity) => json(transform(entity)).get
      case None         => halt(404, "Entity not found for given parameters")
    }

    def map(entity: T): Map[String, Any] = transform(entity)

    def map(entities: Seq[T]): Seq[Map[String, Any]] = entities.map(transform)
  }

  def parameter(name: String, scalatra: ScalatraServlet) = {
    implicit val _scalatra = scalatra
    Parameter(name)
  }

  @deprecated
  def parameter(name: String) = new OldParameterBase(name, this)

  //  def isAdmin = try {
  //    sessionHandler.getAttribute(request.getCookies, "isAdmin").asInstanceOf[Boolean]
  //  } catch {
  //    case e: Exception => false
  //  }

  //  def hasTeacherPermissions = try {
  //    sessionHandler.getAttribute(request.getCookies, "hasTeacherPermissions").asInstanceOf[Boolean]
  //  } catch {
  //    case e: Exception => false
  //  }

  //  def getCompanyId = {
  //    val company = request.cookies.get("COMPANY_ID")
  //    company.getOrElse("-1").toInt
  //  }

  def getSessionUserID = try {
    sessionHandler.getAttribute(request.getCookies, "userID").asInstanceOf[String].toInt
  } catch {
    case e: Exception => -1 // guest
  }

  //  def requireAdmin() {
  //    if (!isAdmin) halt(401)
  //  }

  //  def requireTeacherPermissions() {
  //    if (!hasTeacherPermissions) halt(401)
  //  }
}
