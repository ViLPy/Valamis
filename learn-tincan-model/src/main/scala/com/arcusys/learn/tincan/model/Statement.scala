package com.arcusys.learn.tincan.model

import java.util.{ UUID, Date }

/**
 * The Statement is the core of the xAPI.
 * All learning events are stored as Statements.
 * A Statement is akin to a sentence of the form "I did this".
 * @param id UUID assigned by LRS if not set by the Activity Provider.
 * @param actor Who the Statement is about, as an Agent or Group Object. Represents the "I" in "I Did This".
 * @param verb Action of the Learner or Team Object. Represents the "Did" in "I Did This".
 * @param obj Activity, Agent, or another Statement that is the Object of the Statement. Represents the "This" in "I Did This".
 * @param result Result Object, further details representing a measured outcome relevant to the specified Verb.
 * @param context Context that gives the Statement more meaning.
 * @param timestamp Timestamp of when the events described within this Statement occurred. If not provided, LRS should set this to the value of "stored" time.
 * @param stored Timestamp of when this Statement was recorded. Set by LRS.
 * @param authority Agent who is asserting this Statement is true. Verified by the LRS based on authentication, and set by LRS if left blank.
 * @param version The Statement’s associated xAPI version
 * @param attachments Headers for attachments to the Statement
 */
case class Statement(
    id: UUID,
    actor: Actor,
    verb: Verb,
    obj: StatementObject,
    result: Option[Result],
    context: Option[Context],
    timestamp: Option[Date],
    stored: Option[Date],
    authority: Option[Actor],
    version: Option[String],
    attachments: Seq[Attachment]) {

  def equalsWith(statement: Statement) = {
    var attachmentsCheck = true
    attachments.foreach(a => if (!a.isSignature) attachmentsCheck &= statement.attachments.contains(a))
    statement.attachments.foreach(a => if (!a.isSignature) attachmentsCheck &= attachments.contains(a))

    actor.equals(statement.actor) &&
      verb.equals(statement.verb) &&
      obj.equals(statement.obj) &&
      result.equals(statement.result) &&
      context.equals(statement.context) &&
      attachmentsCheck
  }
}

/**
 * A Sub-Statement is a new Statement included as part of a parent Statement.
 * @param actor Who the Statement is about, as an Agent or Group Object. Represents the "I" in "I Did This".
 * @param verb Action of the Learner or Team Object. Represents the "Did" in "I Did This".
 * @param obj Activity, Agent, or another Statement that is the Object of the Statement. Represents the "This" in "I Did This".
 * @param objectType MUST NOT BE Statement
 */
case class SubStatement(
  actor: Actor,
  verb: Verb,
  obj: StatementObject,
  objectType: String,
  storedId: Option[Int] = None) extends StatementObject

/**
 * An optional field that provides a place to add contextual information to a Statement. All properties are optional.
 * @param registration The registration that the Statement is associated with.
 * @param instructor Agent (may be a Group)
 *                   Instructor that the Statement relates to, if not included as the Actor of the Statement.
 * @param team Team that this Statement relates to, if not included as the Actor of the Statement.
 * @param contextActivities A map of the types of learning activity context that this Statement is related to.
 *                          Valid context types are: "parent", "grouping", "category" and "other".
 * @param revision Revision of the learning activity associated with this Statement. Format is free.
 * @param platform Platform used in the experience of this learning activity.
 * @param language Code representing the language in which the experience being recorded in this Statement
 *                 (mainly) occurred in, if applicable and known.
 * @param statement Another Statement, which should be considered as context for this Statement.
 * @param extensions A map of any other domain-specific context relevant to this Statement.
 */
case class Context(
  registration: Option[UUID],
  instructor: Option[Actor],
  team: Option[Group],
  contextActivities: Option[ContextActivities],
  revision: Option[String],
  platform: Option[String],
  language: Option[String],
  statement: Option[StatementReference],
  extensions: Option[Map[String, String]])

/**
 * A Statement Reference is a pointer to another pre-existing Statement.
 * @param id The UUID of a Statement.
 * @param objectType In this case, MUST be "StatementRef".
 */
case class StatementReference(id: UUID, objectType: String, storedId: Option[Int] = None) extends StatementObject

/**
 * An optional field that represents a measured outcome related to the Statement in which it is included.
 * @param score The score of the Agent in relation to the success or quality of the experience
 * @param success Indicates whether or not the attempt on the Activity was successful.
 * @param completion Indicates whether or not the Activity was completed.
 * @param response A response appropriately formatted for the given Activity.
 * @param duration Period of time over which the Statement occurred. Formatted according to ISO 8601 with a precision of 0.01 seconds
 * @param extensions A map of other properties as needed.
 */
case class Result(
  score: Option[Score],
  success: Option[Boolean],
  completion: Option[Boolean],
  response: Option[String],
  duration: Option[String],
  extensions: Option[Map[String, String]])

/**
 *  An optional field that represents the outcome of a graded Activity achieved by an Agent.
 * @param scaled Cf. 'cmi.score.scaled' in SCORM 2004 4th Edition
 * @param raw Cf. 'cmi.score.raw'
 * @param min Cf. 'cmi.score.min'
 * @param max Cf. 'cmi.score.max'
 */
case class Score(
  scaled: BigDecimal,
  raw: Option[BigDecimal],
  min: Option[BigDecimal],
  max: Option[BigDecimal])

/**
 * Extensions are available as part of Activity Definitions, as part of Statement context, or as part of a Statement result.
 * @param key
 * @param value
 */
case class Extension(key: String, value: String)

/**
 * A digital artifact providing evidence of a learning experience.
 * @param usageType Identifies the usage of this attachment.
 * @param display Display name (title) of this attachment.
 * @param description A description of the attachment
 * @param contentType The content type of the attachment.
 * @param length The length of the attachment data in octets
 * @param sha2 The SHA-2 (SHA-256, SHA-384, SHA-512) hash of the attachment data.
 *             SHA-224 SHOULD not be used: a minimum key size of 256 bits is recommended.
 * @param fileUrl an IRL at which the attachment data may be retrieved, or from which it used to be retrievable.
 */
case class Attachment(
    usageType: String,
    display: LanguageMap,
    description: Option[LanguageMap],
    contentType: String,
    length: Int,
    sha2: String,
    fileUrl: Option[String]) {

  def isSignature = usageType.equalsIgnoreCase("http://adlnet.gov/expapi/attachments/signature")
}