package com.arcusys.learn.tincan.model

import java.util.{UUID, Date}

/**
 * The Experience API provides a facility for Activity Providers to save arbitrary data in the form of documents,
 * which may be related to an Activity, Agent, or combination of both.
 * @param id Set by AP, unique within the scope of the agent or activity.
 * @param updated When the document was most recently modified.
 * @param contents The contents of the document (arbitrary binary data)
 */
case class Document(id: String, updated: Date, contents: String, cType: ContentType)

object Document {
  def apply(contents: String, cType: ContentType) = new Document(UUID.randomUUID().toString, new Date(), contents, cType)
}

sealed trait ContentType {
  val name: String
}
object JSONContent extends ContentType {
  val name = "JSONContent"
}
object OtherContent extends ContentType {
  val name = "OtherContent"
}

