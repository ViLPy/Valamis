package com.arcusys.learn.tincan.api.serializer

import org.json4s.{Extraction, CustomSerializer, DefaultFormats, Formats}
import org.json4s.jackson.JsonMethods._
import java.util.UUID
import org.joda.time.DateTime
import com.arcusys.learn.tincan.model._
import org.json4s.JsonAST._
import scala.Some
import com.arcusys.learn.tincan.model.Activity
import org.json4s.jackson.Serialization._
import com.liferay.portal.kernel.language.Language
import com.arcusys.learn.tincan.model.LanguageMap
import com.arcusys.learn.util.JsonSerializer.UUIDSerializer

object JsonDeserializer {

  class InteractionTypeSerializer extends CustomSerializer[InteractionType.Value](format => ( {
    case JString("choice") => InteractionType.Choice
    case JString("sequencing") => InteractionType.Sequencing
    case JString("likert") => InteractionType.Likert
    case JString("matching") => InteractionType.Matching
    case JString("performance") => InteractionType.Performance
    case JString("true-false") => InteractionType.TrueFalse
    case JString("fill-in") => InteractionType.FillIn
    case JString("numeric") => InteractionType.Numeric
    case JString("other") => InteractionType.Other
  }, {
    case InteractionType.Choice => JString("choice")
    case InteractionType.Sequencing => JString("sequencing")
    case InteractionType.Likert => JString("likert")
    case InteractionType.Matching => JString("matching")
    case InteractionType.Performance => JString("performance")
    case InteractionType.TrueFalse => JString("true-false")
    case InteractionType.FillIn => JString("fill-in")
    case InteractionType.Numeric => JString("numeric")
    case InteractionType.Other => JString("other")
  }
    ))

  class ActorSerializer extends CustomSerializer[Actor](implicit format => ( {
    case jObject: JObject => //jObject.extract[Agent]
      jObject.\("objectType").extractOpt[String] match {
        case Some("Agent") => jObject.extract[Agent]
        case Some("Group") => jObject.extract[Group]
      }
  }, {
    case agent : Agent => render(Extraction.decompose(agent)(DefaultFormats))
    case group : Group => render(Extraction.decompose(group)(DefaultFormats))
  }))

  class StatementObjectSerializer extends CustomSerializer[StatementObject](implicit format => ( {
    case jObject: JObject =>
      jObject.\("objectType").extractOpt[String] match {
        case Some("Agent") => jObject.extract[Agent]
        case Some("Group") => jObject.extract[Group]
        case Some("StatementRef") => jObject.extract[StatementReference]
        case Some("SubStatement") => jObject.extract[SubStatement]
        case Some("Activity") =>
          (jObject.\("definition").transformField({
            case JField("type", fields) => JField("theType", fields)
          }) ++ new JObject(List("objectType" -> jObject.\("objectType"), "id" -> jObject.\("id")))).extract[Activity]
        case e => {throw new IllegalArgumentException("Illegal object type " + e)}
      }
  }, {
    case agent : Agent => render(Extraction.decompose(agent)(DefaultFormats))
    case group : Group => render(Extraction.decompose(group)(DefaultFormats))
    case activity : Activity => JObject(
      JField("objectType", JString("Activity")),
      JField("id", JString(activity.id)),
      JField("definition", JObject(
        JField("name", Extraction.decompose(activity.name.getOrElse(Map()))),
        JField("description", Extraction.decompose(activity.description.getOrElse(Map()))),
        JField("type", JString(activity.theType.getOrElse(""))),
        JField("moreInfo", JString(activity.moreInfo.getOrElse(null)))
      ))
    )
  }))

  class StatementSerializer extends CustomSerializer[Statement](format => ({
    case jValue: JValue =>
      implicit val jsonFormats: Formats = DefaultFormats + new UUIDSerializer + new ActorSerializer + new StatementObjectSerializer + new InteractionTypeSerializer
      Statement(
      jValue.\("id").extract[UUID],
      jValue.\("actor").extract[Actor],
      jValue.\("verb").extract[Verb],
      jValue.\("object").extract[StatementObject],
      jValue.\("result") match {
        case JNothing => None
        case value: JValue => value.extractOpt[Result]
      },
      jValue.\("context") match {
        case JNothing => None
        case value : JValue => jValue.\("context").extractOpt[Context]
      },
      new DateTime(jValue.\("timestamp").extract[String]).toDate, //jValue.\("timestamp").extract[Date],
      jValue.\("stored").extractOpt[String].map(new DateTime(_).toDate),
      jValue.\("authority").extractOpt[Actor],
      jValue.\("version").extractOpt[String], // version: Option[String],
      jValue.\("attachments").extract[Seq[Attachment]]
      )
  },{
    case statement: Statement => {
      implicit val jsonFormats: Formats = DefaultFormats + new ActorSerializer + new StatementObjectSerializer + new InteractionTypeSerializer + new UUIDSerializer
      Extraction.decompose(statement).transformField({
        case JField("obj", jValue: JValue) => JField("object", jValue)
      })
    }
  }))


  def deserializeStatement(raw: String): Statement = {
    implicit val jsonFormats: Formats = DefaultFormats + new StatementSerializer
    parse(raw).extract[Statement]
  }

  def deserializeStatements(raw: String): Seq[Statement] = {
    implicit val jsonFormats: Formats = DefaultFormats + new StatementSerializer
    parse(raw).extract[Seq[Statement]]
  }

  def serializeStatementResult(statementResult: StatementResult) = {
    implicit val jsonFormats: Formats = DefaultFormats + new StatementSerializer
    compact(render(Extraction.decompose(statementResult)))
  }

  def serializeStatement(statement: Statement) = {
    implicit val jsonFormats: Formats = DefaultFormats + new StatementSerializer
    compact(render(Extraction.decompose(statement)))
  }

  def serializeIds(ids: Seq[String]) = {
    implicit val jsonFormats: Formats = DefaultFormats
    compact(render(Extraction.decompose(ids)))
  }

  def deserializeAgent(raw: String): Agent = {
    implicit val jsonFormats: Formats = DefaultFormats
    parse(raw).extract[Agent]
  }

  def deserializeActor(raw: String): Actor = {
    implicit val jsonFormats: Formats = DefaultFormats + new ActorSerializer
    parse(raw).extract[Actor]
  }

  def serializeActor(actor: Actor): String = {
    implicit val jsonFormats: Formats = DefaultFormats + new ActorSerializer
    compact(render(Extraction.decompose(actor)))
  }
}
