package com.arcusys.learn.service.util

import javax.servlet.http.HttpServletResponse
import java.util.Date
import org.joda.time.DateTime
import org.scalatra.ScalatraServlet

/**
 * Created by Iliya Tryapitsin on 10.04.2014.
 */
@deprecated
class OldParameterBase(name: String, scalatra: ScalatraServlet) {

  implicit val req = scalatra.request
  implicit val resp = scalatra.response

  def required = scalatra.params.getOrElse(name, scalatra.halt(HttpServletResponse.SC_BAD_REQUEST, "Required parameter '" + name + "' is not specified"))

  def withDefault(default: String) = scalatra.params.getOrElse(name, default)

  def longRequired = try {
    required.toLong
  } catch {
    case _: Throwable => scalatra.halt(HttpServletResponse.SC_BAD_REQUEST, "Long parameter '" + name + "' could not be parsed")
  }

  def intRequired = try {
    required.toInt
  } catch {
    case _: Throwable => scalatra.halt(HttpServletResponse.SC_BAD_REQUEST, "Integer parameter '" + name + "' could not be parsed")
  }

  def option: Option[String] = scalatra.params.get(name)

  def intOption(none: String): Option[Int] = {
    val value = scalatra.params.getOrElse(name, none)
    if (value == none) None
    else Some(try {
      value.toInt
    } catch {
      case _: Throwable => scalatra.halt(HttpServletResponse.SC_BAD_REQUEST, "Integer parameter '" + name + "' could not be parsed")
    })
  }

  def intOption(none: Int): Option[Int] = intOption(none.toString)

  def bigDecimalOption(none: String): Option[BigDecimal] = {
    val value = scalatra.params.getOrElse(name, none)
    if (value == none) None
    else Some(try {
      BigDecimal(value.toDouble)
    } catch {
      case _: Throwable => scalatra.halt(HttpServletResponse.SC_BAD_REQUEST, "BigDecimal parameter '" + name + "' could not be parsed")
    })
  }

  def booleanRequired = try {
    required.toBoolean
  } catch {
    case _: Throwable => scalatra.halt(HttpServletResponse.SC_BAD_REQUEST, "Boolean parameter '" + name + "' could not be parsed")
  }

  def booleanOption(none: String): Option[Boolean] = {
    val value = scalatra.params.getOrElse(name, none)
    if (value == none) None
    else Some(try {
      value.toBoolean
    } catch {
      case _: Throwable => scalatra.halt(HttpServletResponse.SC_BAD_REQUEST, "Integer parameter '" + name + "' could not be parsed")
    })
  }

  def dateOption(none: String): Option[Date] = {
    val value = scalatra.params.getOrElse(name, none)
    if (value == none) None
    else Some(try {
      new DateTime(value).toDate
    } catch {
      case _: Throwable => scalatra.halt(HttpServletResponse.SC_BAD_REQUEST, "Integer parameter '" + name + "' could not be parsed")
    })
  }

  def multiRequired() = {
    scalatra.multiParams.get(name)
  }

  def contains() = scalatra.params.contains(name)
}
