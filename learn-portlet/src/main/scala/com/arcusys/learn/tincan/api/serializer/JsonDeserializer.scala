package com.arcusys.learn.tincan.api.serializer

import org.json4s._
import org.json4s.jackson.JsonMethods._
import java.util.UUID
import org.joda.time.DateTime
import com.arcusys.learn.tincan.model._
import org.json4s.JsonAST.JNothing
import org.json4s.JsonAST.JObject
import org.json4s.JsonAST.JField
import org.json4s.JsonAST.JValue
import com.arcusys.learn.tincan.model.Group
import com.arcusys.learn.tincan.model.SubStatement
import com.arcusys.learn.tincan.model.StatementReference
import com.arcusys.learn.tincan.model.StatementResult
import scala.Some
import com.arcusys.learn.tincan.model.Activity
import com.arcusys.learn.tincan.model.Statement
import com.arcusys.learn.tincan.model.Result
import com.arcusys.learn.tincan.model.Person
import org.json4s.JsonAST.JString
import com.arcusys.learn.tincan.model.Agent
import com.arcusys.learn.tincan.model.Context
import com.arcusys.learn.tincan.model.Attachment
import com.arcusys.learn.tincan.model.Verb
import com.arcusys.learn.util.JsonSupport

case class SerializeFormat(
  Type: String = "exact",
  Lang: String = "")

object JsonDeserializer {

  class InteractionTypeSerializer extends CustomSerializer[InteractionType.Value](format => ({
    case JString("choice")      => InteractionType.Choice
    case JString("sequencing")  => InteractionType.Sequencing
    case JString("likert")      => InteractionType.Likert
    case JString("matching")    => InteractionType.Matching
    case JString("performance") => InteractionType.Performance
    case JString("true-false")  => InteractionType.TrueFalse
    case JString("fill-in")     => InteractionType.FillIn
    case JString("numeric")     => InteractionType.Numeric
    case JString("other")       => InteractionType.Other
  }, {
    case InteractionType.Choice      => JString("choice")
    case InteractionType.Sequencing  => JString("sequencing")
    case InteractionType.Likert      => JString("likert")
    case InteractionType.Matching    => JString("matching")
    case InteractionType.Performance => JString("performance")
    case InteractionType.TrueFalse   => JString("true-false")
    case InteractionType.FillIn      => JString("fill-in")
    case InteractionType.Numeric     => JString("numeric")
    case InteractionType.Other       => JString("other")
  }
  ))

  class ActorSerializer(formatType: SerializeFormat = SerializeFormat()) extends CustomSerializer[Actor](implicit format => ({
    case jObject: JObject => //jObject.extract[Agent]
      jObject.\("objectType").extractOpt[String] match {
        case Some("Agent") | None => jObject.extract[Agent]
        case Some("Group")        => jObject.extract[Group]
      }
  }, {
    case agent: Agent => {
      if (formatType.Type == "ids") {
        val field: JField = (if (agent.mbox.isDefined)
          JField("mbox", JString(agent.mbox.get))
        else if (agent.mbox_sha1sum.isDefined)
          JField("mbox_sha1sum", JString(agent.mbox_sha1sum.get))
        else if (agent.openid.isDefined)
          JField("openid", JString(agent.openid.get))
        else if (agent.account.isDefined)
          JField("account", Extraction.decompose(agent.account.get))
        else
          JField("account", null)
        )

        JObject(JField("objectType", JString("Agent")), field)
      } else render((Extraction.decompose(agent)(DefaultFormats)).removeField(field => field._1.equalsIgnoreCase("storedId")))
    }
    case group: Group => {
      if (formatType.Type == "ids") {
        val field: JField = (if (group.mbox.isDefined)
          JField("mbox", JString(group.mbox.get))
        else if (group.mbox_sha1sum.isDefined)
          JField("mbox_sha1sum", JString(group.mbox_sha1sum.get))
        else if (group.openid.isDefined)
          JField("openid", JString(group.openid.get))
        else //if (agent.account.isDefined)
          JField("account", Extraction.decompose(group.account.get))
        )

        JObject(JField("objectType", JString("Agent")), field)
      } else render((Extraction.decompose(group)(DefaultFormats)).removeField(field => field._1.equalsIgnoreCase("storedId")))
    }
    case person: Person => render(Extraction.decompose(person)(DefaultFormats))

  }))

  class ResultSerializer() extends CustomSerializer[Result](implicit format => ({
    case jValue: JValue => //jObject.extract[Result]
      Result(
        jValue.\("score") match {
          case JNothing      => None
          case value: JValue => value.extractOpt[Score]
        },
        jValue.\("success").extractOpt[Boolean],
        jValue.\("completion").extractOpt[Boolean],
        jValue.\("response").extractOpt[String],
        jValue.\("duration").extractOpt[String],
        jValue.\("extensions").extract[Seq[Extension]]
      )
    //      jObject.\("objectType").extractOpt[String] match {
    //        case Some("Agent") | None => jObject.extract[Agent]
    //        case Some("Group") => jObject.extract[Group]
    //      }
  }, {
    case result: Result => render(Extraction.decompose(result)(DefaultFormats))

  }))

  class ScoreSerializer() extends CustomSerializer[Score](implicit format => ({
    case jValue: JValue => //jObject.extract[Result]
      Score(
        BigDecimal(jValue.\("scaled").extract[String]),
        jValue.\("raw").extractOpt[String].map(s => BigDecimal(s)),
        jValue.\("min").extractOpt[String].map(s => BigDecimal(s)),
        jValue.\("max").extractOpt[String].map(s => BigDecimal(s))
      )
    //      jObject.\("objectType").extractOpt[String] match {
    //        case Some("Agent") | None => jObject.extract[Agent]
    //        case Some("Group") => jObject.extract[Group]
    //      }
  }, {
    case score: Score => render(Extraction.decompose(score)(DefaultFormats))

  }))

  class StatementObjectSerializer(formatType: SerializeFormat = SerializeFormat()) extends CustomSerializer[StatementObject](implicit format => ({
    case jObject: JObject =>
      jObject.\("objectType").extractOpt[String] match {
        case Some("Agent")        => jObject.extract[Agent]
        case Some("Group")        => jObject.extract[Group]
        case Some("StatementRef") => jObject.extract[StatementReference]
        case Some("SubStatement") => jObject.transformField({
          case JField("object", jValue: JValue) => JField("obj", jValue)
        }).extract[SubStatement]
        case Some("Activity") | None =>
          (jObject.\("definition").transformField({
            case JField("type", fields) => JField("theType", fields)
          }) ++ new JObject(List("objectType" -> JString("Activity"), "id" -> jObject.\("id")))).extract[Activity]
        case e => {
          throw new IllegalArgumentException("Illegal object type " + e)
        }
      }
  }, {
    case agent: Agent => render(Extraction.decompose(agent)(DefaultFormats + new ActorSerializer(formatType)))
    case group: Group => render(Extraction.decompose(group)(DefaultFormats + new ActorSerializer(formatType)))
    //case subStatement: SubStatement => render(Extraction.decompose(subStatement)(DefaultFormats + new StatementObjectSerializer(formatType)))
    case subStatement: SubStatement =>
      JObject(
        JField("objectType", JString("SubStatement")),
        JField("actor", Extraction.decompose(subStatement.actor)),
        JField("verb", Extraction.decompose(subStatement.verb)),
        JField("object", Extraction.decompose(subStatement.obj))
      )
    case statementRef: StatementReference =>
      render((Extraction.decompose(statementRef)(DefaultFormats + JsonSupport.extFormats.uuid)).removeField(field => field._1.equalsIgnoreCase("storedId")))
    case activity: Activity =>
      if (formatType.Type == "ids") {
        JObject(
          JField("objectType", JString("Activity")),
          JField("id", JString(activity.id))
        )
      } else {
        var name = activity.name.getOrElse(Map())
        var description = activity.description.getOrElse(Map())

        if (formatType.Type == "canonical" && formatType.Lang != "") {
          // canonical format: Only one language should be returned in each of these maps.
          val langs = formatType.Lang.split(Array(',', ';'))
          name = name.filter(l1 => langs.find(l2 => l2.contains(l1._1)).isDefined).take(1)
          description = description.filter(l1 => langs.find(l2 => l2.contains(l1._1)).isDefined).take(1)

        }
        val definition = JObject(
          JField("name", Extraction.decompose(name)),
          JField("description", Extraction.decompose(description)),
          JField("type", JString(activity.theType.getOrElse(""))),
          JField("interactionType", JString(if (activity.interactionType.isDefined) activity.interactionType.get.toString else null)),
          JField("moreInfo", JString(activity.moreInfo.getOrElse(null))),
          JField("correctResponsesPattern", Extraction.decompose(activity.correctResponsesPattern)),
          JField("choices", Extraction.decompose(activity.choices)),
          JField("scale", Extraction.decompose(activity.scale)),
          JField("source", Extraction.decompose(activity.source)),
          JField("target", Extraction.decompose(activity.target)),
          JField("steps", Extraction.decompose(activity.steps)),
          JField("extensions", Extraction.decompose(activity.extensions))
        )

        JObject(
          JField("objectType", JString("Activity")),
          JField("id", JString(activity.id)),
          JField("definition", definition)
        )
      }
  }))

  class StatementSerializer(formatType: SerializeFormat = SerializeFormat()) extends CustomSerializer[Statement](format => ({
    case jValue: JValue =>
      implicit val jsonFormats: Formats = DefaultFormats + JsonSupport.extFormats.uuid + new ActorSerializer + new StatementObjectSerializer + new InteractionTypeSerializer + new ResultSerializer + new ScoreSerializer
      Statement(
        jValue.\("id").extractOpt[UUID].getOrElse(null),
        jValue.\("actor").extract[Actor],
        jValue.\("verb").extract[Verb],
        jValue.\("object").extract[StatementObject],
        jValue.\("result") match {
          case JNothing      => None
          case value: JValue => value.extractOpt[Result]
        },
        jValue.\("context") match {
          case JNothing      => None
          case value: JValue => jValue.\("context").extractOpt[Context]
        },
        jValue.\("timestamp").extractOpt[String].map(new DateTime(_).toDate), //jValue.\("timestamp").extract[Date],
        jValue.\("stored").extractOpt[String].map(new DateTime(_).toDate),
        jValue.\("authority").extractOpt[Actor],
        jValue.\("version").extractOpt[String], // version: Option[String],
        jValue.\("attachments").extract[Seq[Attachment]]
      )
  }, {
    case statement: Statement => {
      implicit val jsonFormats: Formats = DefaultFormats + new ActorSerializer(formatType) + new StatementObjectSerializer(formatType) + new InteractionTypeSerializer + JsonSupport.extFormats.uuid + new ResultSerializer
      Extraction.decompose(statement).transformField({
        case JField("obj", jValue: JValue) => JField("object", jValue)
      })
    }
  }))

  def deserializeStatement(raw: String): Statement = {
    implicit val jsonFormats: Formats = DefaultFormats + new StatementSerializer

    try {
      parse(raw).extract[Statement]
    } catch {
      case _ => throw new JSONDeserializerException("Object with name 'Statement' could not be created from the provided JSON.")
    }
  }

  def deserializeStatements(raw: String): Seq[Statement] = {
    implicit val jsonFormats: Formats = DefaultFormats + new StatementSerializer
    try {
      parse(raw).extract[Seq[Statement]]
    } catch {
      case _ => throw new JSONDeserializerException("List of statements could not be created from the provided JSON.")
    }
  }

  def deserializeStatementResult(raw: String): StatementResult = {
    implicit val jsonFormats: Formats = DefaultFormats + new StatementSerializer

    try {
      parse(raw).extract[StatementResult]
    } catch {
      case _ => throw new JSONDeserializerException("Object with name 'StatementResult' could not be created from the provided JSON.")
    }
  }

  def serializeStatementResult(statementResult: StatementResult, formatType: SerializeFormat = SerializeFormat()) = {
    assert(formatType.Type == "exact" || formatType.Type == "ids" || formatType.Type == "canonical",
      "Format type must be 'exact', 'ids', 'canonical'")
    implicit val jsonFormats: Formats = DefaultFormats + new StatementSerializer(formatType)
    try {
      compact(render(Extraction.decompose(statementResult)))
    } catch {
      case _ => throw new JSONSerializerException("JSON raw could not be created from object with name 'StatementResult'.")
    }
  }

  def serializeStatement(statement: Statement, formatType: SerializeFormat = SerializeFormat()): String = {
    assert(formatType.Type == "exact" || formatType.Type == "ids" || formatType.Type == "canonical",
      "Format type must be 'exact', 'ids', 'canonical'")
    implicit val jsonFormats: Formats = DefaultFormats + new StatementSerializer(formatType)

    try {
      compact(render(Extraction.decompose(statement)))
    } catch {
      case _ => throw new JSONSerializerException("JSON raw could not be created from object with name 'Statement'.")
    }
  }

  def serializeStatements(statements: Seq[Statement], formatType: SerializeFormat = SerializeFormat()): String = {
    assert(formatType.Type == "exact" || formatType.Type == "ids" || formatType.Type == "canonical",
      "Format type must be 'exact', 'ids', 'canonical'")
    implicit val jsonFormats: Formats = DefaultFormats + new StatementSerializer(formatType)

    try {
      compact(render(Extraction.decompose(statements)))
    } catch {
      case _ => throw new JSONSerializerException("JSON raw could not be created from object with name 'Statement'.")
    }
  }

  def serializeIds(ids: Seq[String]) = {
    implicit val jsonFormats: Formats = DefaultFormats

    try {
      compact(render(Extraction.decompose(ids)))
    } catch {
      case _ => throw new JSONSerializerException("JSON raw could not be created from list of string.")
    }
  }

  def deserializeIds(raw: String): Seq[String] = {
    implicit val jsonFormats: Formats = DefaultFormats

    try {
      parse(raw).extract[Seq[String]]
    } catch {
      case _ => throw new JSONDeserializerException("List of string could not be created from the provided JSON.")
    }
  }

  def deserializeAgent(raw: String): Agent = {
    implicit val jsonFormats: Formats = DefaultFormats

    try {
      parse(raw).extract[Agent]
    } catch {
      case _ => throw new JSONDeserializerException("Object with name 'Agent' could not be created from the provided JSON.")
    }
  }

  def deserializeActivity(raw: String): Activity = {
    implicit val jsonFormats: Formats = DefaultFormats

    try {
      parse(raw).extract[Activity]
    } catch {
      case _ => throw new JSONDeserializerException("Object with name 'Activity' could not be created from the provided JSON.")
    }
  }

  def serializeActivity(activity: Activity): String = {
    implicit val jsonFormats: Formats = DefaultFormats + new ActorSerializer

    try {
      compact(render(Extraction.decompose(activity)))
    } catch {
      case _ => throw new JSONSerializerException("JSON raw could not be created from object with name 'Activity'.")
    }
  }

  def deserializeActor(raw: String): Actor = {
    implicit val jsonFormats: Formats = DefaultFormats + new ActorSerializer

    try {
      parse(raw).extract[Actor]
    } catch {
      case _ => throw new JSONDeserializerException("Object with name 'Actor' could not be created from the provided JSON.")
    }
  }

  def serializeActor(actor: Actor): String = {
    implicit val jsonFormats: Formats = DefaultFormats + new ActorSerializer

    try {
      compact(render(Extraction.decompose(actor)))
    } catch {
      case _ => throw new JSONSerializerException("JSON raw could not be created from object with name 'Actor'.")
    }
  }

  def serializePerson(person: Person): String = {
    implicit val jsonFormats: Formats = DefaultFormats + new ActorSerializer

    try {
      compact(render(Extraction.decompose(person)))
    } catch {
      case _ => throw new JSONSerializerException("JSON raw could not be created from object with name 'Person'.")
    }
  }

  def deserializePerson(raw: String): Person = {
    implicit val jsonFormats: Formats = DefaultFormats + new ActorSerializer

    try {
      parse(raw).extract[Person]
    } catch {
      case _ => throw new JSONDeserializerException("Object with name 'Person' could not be created from the provided JSON.")
    }
  }

  case class JSONDeserializerException(message: String) extends Exception(message)

  case class JSONSerializerException(message: String) extends Exception(message)

  def serializeListAsObject(obj: Map[String, Any], formatType: SerializeFormat = SerializeFormat()): String = {
    assert(formatType.Type == "exact" || formatType.Type == "ids" || formatType.Type == "canonical",
      "Format type must be 'exact', 'ids', 'canonical'")
    implicit val jsonFormats: Formats = DefaultFormats + new StatementSerializer(formatType)

    try {
      compact(render(Extraction.decompose(obj)))
    } catch {
      case _ => throw new JSONSerializerException("JSON raw could not be created from object with name 'Statement'.")
    }
  }
}
