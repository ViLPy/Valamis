package com.arcusys.learn.web

import org.scalatra.ScalatraServlet
import com.escalatesoft.subcut.inject.Injectable
import com.arcusys.learn.service.util.{ OldParameterBase, Parameter}
import com.arcusys.valamis.utils.JsonSupport

trait ServletBase extends ScalatraServlet with JsonSupport with Injectable {

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
}
