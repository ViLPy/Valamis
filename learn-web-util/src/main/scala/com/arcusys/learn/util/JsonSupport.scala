package com.arcusys.learn.util

import org.json4s.{ JString, JInt, JBool, JDouble, JDecimal, JNull }
import org.json4s.{ CustomSerializer, Formats, DefaultFormats, NoTypeHints }
import org.json4s.jackson.Serialization
import org.json4s.jackson.Serialization.write
import org.json4s.jackson.JsonMethods.parse

import scala.util.Try
import java.util.UUID

trait JsonSupport {

  // serializers for non-supported types
  object extFormats {
    val uuid = new CustomSerializer[UUID](format => (
      { case JString(p) => UUID.fromString(p) },
      { case uuid: UUID => JString(uuid.toString) }
    ))
  }

  def json(input: Any)(implicit formats: Formats = Serialization.formats(NoTypeHints)): Try[String] = Try {
    input match {
      case i: Int         => write(JInt(i))
      case bi: BigInt     => write(JInt(bi))
      case s: String      => write(JString(s))
      case b: Boolean     => write(JBool(b))
      case d: Double      => write(JDouble(d))
      case f: Float       => write(JDouble(f))
      case bd: BigDecimal => write(JDecimal(bd))
      case n if n == null => write(JNull)
      case any: AnyRef    => write(any)
    }
  }

  def parseJson[A](json: String)(implicit ev: Manifest[A], fs: Formats = DefaultFormats): Try[A] = Try {
    parse(json, useBigDecimalForDouble = true).extract[A]
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
