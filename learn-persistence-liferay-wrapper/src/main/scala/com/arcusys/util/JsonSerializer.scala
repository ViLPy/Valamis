package com.arcusys.util

import com.arcusys.learn.util.JsonSupport
import com.arcusys.learn.tincan.model._

import org.json4s._

import java.util.UUID

object JsonSerializer extends JsonSupport {

  def serializeStringSeq(s: Seq[String]) = json(s).getOrElse("")
  def deserializeStringSeq(raw: String): Seq[String] = parseJson[Seq[String]](raw).getOrElse(Seq())

  def serializeStringSet(s: Set[String]) = json(s).getOrElse("")
  def deserializeStringSet(raw: String): Set[String] = parseJson[Set[String]](raw).getOrElse(Set())

  def serializeLanguageMap(map: LanguageMap) = json(map).getOrElse("")
  def deserializeLanguageMap(raw: String): LanguageMap = parseJson[LanguageMap](raw).getOrElse(Map.empty[String, String])

  def serializeInteractionComponents(interactionComponents: Seq[InteractionComponent]) =
    json(interactionComponents).get
  def deserializeInteractionComponents(raw: String): Seq[InteractionComponent] =
    parseJson[Seq[InteractionComponent]](raw).get

  def serializeExtensions(extensions: Seq[Extension]) = json(extensions).get
  def deserializeExtensions(raw: String): Seq[Extension] = parseJson[Seq[Extension]](raw).get

  def serializeAccounts(accounts: Seq[Account]) = json(accounts).get

  def deserializeAccounts(raw: String): Seq[Account] = parseJson[Seq[Account]](raw).get

  import JsonSupport._

  def serializeAccount(account: Account) = account.toJson.get
  def deserializeAccount(raw: String): Account = raw.parseTo[Account].get

  def serializeUUID(uuid: UUID) = {
    implicit val fs: Formats = DefaultFormats + extFormats.uuid
    uuid.toJson.get
  }

  def deserializeUUID(raw: String): UUID = {
    implicit val fs: Formats = DefaultFormats + extFormats.uuid
    raw.parseTo[UUID].get
  }

  def serializeScore(score: Score): String = score.toJson.get

  def deserializeScore(raw: String): Score = {
    implicit val jsonFormats: Formats = DefaultFormats.withBigDecimal
    raw.parseTo[Score].get
  }

  def serializeActivityReference(refs: Seq[ActivityReference]): String = refs.toJson.get
  def deserializeActivityReference(raw: String): Seq[ActivityReference] = raw.parseTo[Seq[ActivityReference]].get

  def serializeStatementReference(refs: StatementReference): String = {
    implicit val fs: Formats = DefaultFormats + extFormats.uuid
    refs.toJson.get
  }

  def deserializeStatementReference(raw: String): StatementReference = {
    implicit val fs: Formats = DefaultFormats + extFormats.uuid
    raw.parseTo[StatementReference].get
  }
}
