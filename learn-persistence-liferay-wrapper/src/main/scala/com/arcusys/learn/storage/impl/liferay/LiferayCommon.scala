package com.arcusys.learn.storage.impl.liferay

import java.lang.{ Integer => JavaInteger }
import java.lang.{ Long => JavaLong }
import java.lang.{ Double => JavaDouble }
import java.math

/**
 * User: dkudinov
 * Date: 22.3.2013
 */
object LiferayCommon {
  //  val nullInteger: JavaInteger = new JavaInteger(0)
  val nullInteger: JavaInteger = null
  val nullDouble: JavaDouble = null
  val nullLong: JavaLong = null

  implicit def optionToNullableInteger(value: Option[Int]): JavaInteger = value.map(new JavaInteger(_)).getOrElse(nullInteger)
  implicit def optionToNullableLong(value: Option[Long]): JavaLong = value.map(new JavaLong(_)).getOrElse(nullLong)
  implicit def toBigDecimal(value: scala.BigDecimal): java.math.BigDecimal = {
    if (value == null) null else new math.BigDecimal(value.toString())
  }

  implicit def javaLongToOption(value: java.lang.Long) = new {
    def toOption: Option[Long] = if (value == null) None else Some(value.longValue())
  }

  implicit def javaIntegerToOption(value: java.lang.Integer) = new {
    def toOption: Option[Int] = if (value == null) None else Some(value.intValue())
  }

  implicit def stringToOption(value: String) = new {
    def toOption: Option[String] = if (isNullOrEmpty(value)) None else Some(value)
  }

  def getArrayForIsNullSearch(courseId: Int): Array[JavaInteger] = {
    if (courseId == -1) Array(nullInteger) else Array(courseId, nullInteger)
  }

  def idParam(parameters: (String, Any)*): Option[Int] = {
    parameters find {
      _._1 == "id"
    } map {
      _._2.asInstanceOf[Int]
    }
  }

  def getParameter[T](name: String, parameters: (String, Any)*): Option[T] = {
    parameters find { _._1 == name } map (_._2.asInstanceOf[T])
  }
  def getNullableParameter[T](name: String, parameters: (String, Any)*): T = {
    val value = parameters.find(_._1 == name).map(_._2).getOrElse(null)
    value match {
      case None         => null.asInstanceOf[T]
      case x: Option[T] => x.get
      case x: T         => x
    }
  }

  def isNullOrEmpty(value: String) = {
    (value == "" || value == null)
  }

}
