package com.arcusys.learn.service.util

import scala._
import java.util.Date
import org.joda.time.DateTime
import javax.servlet.http.HttpServletRequest
import com.thoughtworks.paranamer.ParameterNamesNotFoundException
import scala.tools.cmd.Parser.ParseException
import scala.collection.JavaConverters._
import scala.Some

class ParameterBase(name: String, r: HttpServletRequest) {

  def required = {
    val param = r.getParameter(name)
    param match {
      case "" => throw new ParameterNamesNotFoundException("Required parameter '" + name + "' is not specified")
      case _ => param
    }
  }

  def withDefault(default: String): String = {
    val param = r.getParameter(name)
    param match {
      case "" => default
      case _ => param
    }
  }

  def longRequired = try {
    required.toLong
  } catch {
    case _ => throw new ParseException("Long parameter '" + name + "' could not be parsed")
  }

  def intRequired = try {
    required.toInt
  } catch {
    case _ =>  throw new ParseException("Integer parameter '" + name + "' could not be parsed")
  }

  def option: Option[String] = {
    val param = r.getParameter(name)
    param match {
      case "" => None
      case _ => Option(param)
    }
  }

  def intOption(none: String): Option[Int] = {
    val value = r.getParameter(name)
    if (value == none || value == "")
      None
    else Some(try {
      value.toInt
    } catch {
      case _ =>  throw new ParseException("Integer parameter '" + name + "' could not be parsed")
    })
  }

  def intOption(none: Int): Option[Int] = intOption(none.toString)

  def bigDecimalOption(none: String): Option[BigDecimal] = {
    val value = r.getParameter(name)
    if (value == none || value == "")
      None
    else Some(try {
      BigDecimal(value.toDouble)
    } catch {
      case _ =>  throw new ParseException("BigDecimal parameter '" + name + "' could not be parsed")
    })
  }

  def booleanRequired = try {
    required match {
      case "1" | "on" | "true" => true
      case "0" | "off" | "false" => false
      case _ => false
    }
  } catch {
    case _ =>  throw new ParseException("Boolean parameter '" + name + "' could not be parsed")
  }

  def booleanOption(none: String): Option[Boolean] = {
    val value = r.getParameter(name)
    if (value == none || value == "")
      None
    else Some(try {
      value match {
        case "1" | "on" | "true" => true
        case "0" | "off" | "false" => false
        case _ => false
      }
    } catch {
      case _ =>  throw new ParseException("Boolean parameter '" + name + "' could not be parsed")
    })
  }

  def dateOption(none: String): Option[Date] = {
    val value = r.getParameter(name)
    if (value == none || value == "")
      None
    else Some(try {
      new DateTime(value).toDate
    } catch {
      case _ =>  throw new ParseException("DateTime parameter '" + name + "' could not be parsed")
    })
  }

  def multiRequired = r.getParameter(name)

  def contains = r.getParameterNames()
    .asScala
    .contains(name)
}
