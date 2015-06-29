package com.arcusys.valamis.util.serialization

import org.json4s._
import org.json4s.jackson.JsonMethods._

import scala.util.{Failure, Success, Try}

object JsonHelper {

  def parseFromJson[T](raw: String)(implicit man: Manifest[T], formats: Formats = DefaultFormats): T = parse(raw, useBigDecimalForDouble = true).extract[T]

  def fromJson[T](raw: String, serializers: Serializer[_]*)(implicit man: Manifest[T]): T = {
    implicit val jsonFormats = DefaultFormats ++ serializers
    parseFromJson(raw)
  }

  def writeToJson[T](obj: T)(implicit man: Manifest[T], formats: Formats = DefaultFormats): String = compact(render(Extraction.decompose(obj)))

  def toJson[T](obj: T, serializers: Serializer[_]*)(implicit man: Manifest[T]): String = {
    implicit val jsonFormats = DefaultFormats ++ serializers
    writeToJson(obj)
  }

  def combine(target: String, toBeMerged: String): String = {
    try{
      implicit val format = DefaultFormats
      val parsedA = parse(target)
      val parsedB = parse(toBeMerged)
      compact(parsedA.removeField(jField => parsedB.findField(_._1 == jField._1).isDefined) merge parse(toBeMerged))
    }
    catch {
      case _:Throwable => toBeMerged
    }
  }
}

