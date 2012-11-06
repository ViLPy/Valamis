package com.arcusys.learn.web

import org.scalatra.ScalatraServlet
import com.arcusys.scala.scalatra.json.JsonSupport
import org.scala_tools.subcut.inject.{Injectable, BindingModule}
import org.slf4j.LoggerFactory
import com.arcusys.learn.storage.StorageFactoryContract

abstract class ServletBase(configuration: BindingModule) extends ScalatraServlet with JsonSupport with Injectable {

  class JsonModelBuilder[T](transform: T => Map[String, Any]) {
    def apply(entity: T): String = json(transform(entity))

    def apply(entities: Seq[T]): String = json(entities.map(transform(_)))

    def apply(entityOption: Option[T]): String = entityOption match {
      case Some(entity) => json(transform(entity))
      case None => halt(404, "Entity not found for given parameters")
    }

    def map(entity: T): Map[String, Any] = transform(entity)

    def map(entities: Seq[T]): Seq[Map[String, Any]] = entities.map(transform(_))
  }

  implicit val bindingModule = configuration
  val log = LoggerFactory.getLogger(this.getClass)
  val storageFactory = inject[StorageFactoryContract]

  class ParameterBase(name: String) {
    def required = params.getOrElse(name, halt(405, "Required parameter '" + name + "' is not specified"))

    def withDefault(default: String) = params.getOrElse(name, default)

    def intRequired = try {
      required.toInt
    } catch {
      case _ => halt(405, "Integer parameter '" + name + "' could not be parsed")
    }

    def intOption(none: String): Option[Int] = {
      val value = params.getOrElse(name, none)
      if (value == none) None
      else Some(try {
        value.toInt
      } catch {
        case _ => halt(405, "Integer parameter '" + name + "' could not be parsed")
      })
    }

    def intOption(none: Int): Option[Int] = intOption(none.toString)

    def bigDecimalOption(none: String): Option[BigDecimal] = {
      val value = params.getOrElse(name, none)
      if (value == none) None
      else Some(try {
        BigDecimal(value.toDouble)
      } catch {
        case _ => halt(405, "BigDecimal parameter '" + name + "' could not be parsed")
      })
    }

    def booleanRequired = try {
      required.toBoolean
    } catch {
      case _ => halt(405, "Boolean parameter '" + name + "' could not be parsed")
    }

    def booleanOption(none: String): Option[Boolean] = {
      val value = params.getOrElse(name, none)
      if (value == none) None
      else Some(try {
        value.toBoolean
      } catch {
        case _ => halt(405, "Integer parameter '" + name + "' could not be parsed")
      })
    }
  }

  def parameter(name: String) = new ParameterBase(name)

  //def requiredParam(name: String, errorMessage: String) = params.getOrElse(name, halt(405, errorMessage))
}
