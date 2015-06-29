package com.arcusys.valamis.util

import java.util.UUID

import com.arcusys.valamis.util.serialization.JsonHelper
import org.json4s.jackson.Serialization
import org.json4s.{CustomSerializer, DefaultFormats, Formats, JString, NoTypeHints}

import scala.util.Try

trait JsonSupport {

  // serializers for non-supported types
  object extFormats {
    val uuid = new CustomSerializer[UUID](format => (
      { case JString(p) => UUID.fromString(p) },
      { case uuid: UUID => JString(uuid.toString) }
    ))
  }

  def json(input: Any)(implicit formats: Formats = Serialization.formats(NoTypeHints)): Try[String] = Try {
    JsonHelper.writeToJson(input)
  }

  def parseJson[A](json: String)(implicit ev: Manifest[A], fs: Formats = DefaultFormats): Try[A] = Try {
    JsonHelper.parseFromJson(json)
  }
}

object JsonSupport extends JsonSupport {

  implicit class StringOpts(val json: String) extends AnyVal {
    def parseTo[A](implicit ev: Manifest[A], fs: Formats = DefaultFormats): Try[A] = parseJson(json)
  }

  implicit class AnyOpts(val any: Any) extends AnyVal {
    def toJson(implicit fs: Formats = Serialization.formats(NoTypeHints)): Try[String] = json(any)
  }

}
