package com.arcusys.learn.util

import org.json4s.{Extraction, CustomSerializer, DefaultFormats, Formats}
import org.json4s.jackson.JsonMethods._
import com.arcusys.learn.tincan.model._
import org.json4s.JsonAST.{JString, JValue}
import com.arcusys.learn.tincan.model.InteractionComponent
import java.util.UUID

object JsonSerializer {
  import org.json4s.JsonDSL._

  def serializeStringSeq(s: Seq[String]) = {
    compact(render(s))
  }

  def deserializeStringSeq(raw: String): Seq[String] = {
    implicit val jsonFormats: Formats = DefaultFormats
    parse(raw).extract[Seq[String]]
  }

  def serializeStringSet(s: Set[String]) = {
    serializeStringSeq(s.toSeq)
  }

  def deserializeStringSet(raw: String): Set[String] = {
    deserializeStringSeq(raw).toSet[String]
  }

  def serializeLanguageMap(map: LanguageMap) = {
    compact(render(map))
  }

  def deserializeLanguageMap(raw: String): LanguageMap = {
    implicit val jsonFormats: Formats = DefaultFormats
    parse(raw).extract[LanguageMap]
  }

  class InteractionComponentSerializer extends CustomSerializer[InteractionComponent](format => ({
    case jValue: JValue =>
      implicit val jsonFormats: Formats = DefaultFormats
      InteractionComponent(
        jValue.\("id").extract[String],
        jValue.\("description").extract[LanguageMap]
      )
  },{
    case interactionComponent: InteractionComponent => {
      implicit val jsonFormats: Formats = DefaultFormats
      Extraction.decompose(interactionComponent)(DefaultFormats)
    }
  }))

  def serializeInteractionComponents(interactionComponents: Seq[InteractionComponent]) = {
    implicit val jsonFormats: Formats = DefaultFormats + new InteractionComponentSerializer
    compact(render(Extraction.decompose(interactionComponents)))
  }

  def deserializeInteractionComponents(raw: String): Seq[InteractionComponent] = {
    implicit val jsonFormats: Formats = DefaultFormats + new InteractionComponentSerializer
    parse(raw).extract[Seq[InteractionComponent]]
  }

  class ExtensionSerializer extends CustomSerializer[Extension](format => ({
    case jValue: JValue =>
      implicit val jsonFormats: Formats = DefaultFormats
      Extension(
        jValue.\("key").extract[String],
        jValue.\("value").extract[String]
      )
  },{
    case extension: Extension => {
      implicit val jsonFormats: Formats = DefaultFormats
      Extraction.decompose(extension)(DefaultFormats)
    }
  }))

  def serializeExtensions(extensions: Seq[Extension]) = {
    implicit val jsonFormats: Formats = DefaultFormats + new ExtensionSerializer
    compact(render(Extraction.decompose(extensions)))
  }

  def deserializeExtensions(raw: String): Seq[Extension] = {
    implicit val jsonFormats: Formats = DefaultFormats + new ExtensionSerializer
    parse(raw).extract[Seq[Extension]]
  }

  class AccountSerializer extends CustomSerializer[Account](format => ({
    case jValue: JValue =>
      implicit val jsonFormats: Formats = DefaultFormats
      Account(
        jValue.\("homePage").extract[String],
        jValue.\("name").extract[String]
      )
  },{
    case account: Account => {
      implicit val jsonFormats: Formats = DefaultFormats
      Extraction.decompose(account)(DefaultFormats)
    }
  }))

  def serializeAccounts(accounts: Seq[Account]) = {
    implicit val jsonFormats: Formats = DefaultFormats + new AccountSerializer
    compact(render(Extraction.decompose(accounts)))
  }

  def deserializeAccounts(raw: String): Seq[Account] = {
    implicit val jsonFormats: Formats = DefaultFormats + new AccountSerializer
    parse(raw).extract[Seq[Account]]
  }

  def serializeAccount(account: Account) = {
    implicit val jsonFormats: Formats = DefaultFormats + new AccountSerializer
    compact(render(Extraction.decompose(account)))
  }

  def deserializeAccount(raw: String): Account = {
    implicit val jsonFormats: Formats = DefaultFormats + new AccountSerializer
    parse(raw).extract[Account]
  }

  class UUIDSerializer extends CustomSerializer[UUID](format => ( {
    case JString(uuidString: String) => UUID.fromString(uuidString)
  }, {
    case uuid: UUID => JString(uuid.toString)
  }))

  def serializeUUID(uuid: UUID) = {
    implicit val jsonFormats: Formats = DefaultFormats + new UUIDSerializer
    compact(render(Extraction.decompose(uuid)))
  }

  def deserializeUUID(raw: String): UUID = {
    implicit val jsonFormats: Formats = DefaultFormats + new UUIDSerializer
    parse(raw).extract[UUID]
  }

  def serializeScore(score: Score): String = {
    implicit val jsonFormats: Formats = DefaultFormats
    compact(render(Extraction.decompose(score)))
  }

  def deserializeScore(raw: String):Score = {
    implicit val jsonFormats: Formats = DefaultFormats
    parse(raw, useBigDecimalForDouble = true).extract[Score]
  }

  def serializeActivityReference(refs: Seq[ActivityReference]): String = {
    implicit val jsonFormats: Formats = DefaultFormats
    compact(render(Extraction.decompose(refs)))
  }

  def deserializeActivityReference(raw: String):Seq[ActivityReference] = {
    implicit val jsonFormats: Formats = DefaultFormats
    parse(raw).extract[Seq[ActivityReference]]
  }

  def serializeStatementReference(refs: StatementReference): String = {
    implicit val jsonFormats: Formats = DefaultFormats + new UUIDSerializer
    compact(render(Extraction.decompose(refs)))
  }

  def deserializeStatementReference(raw: String):StatementReference = {
    implicit val jsonFormats: Formats = DefaultFormats + new UUIDSerializer
    parse(raw).extract[StatementReference]
  }
}
