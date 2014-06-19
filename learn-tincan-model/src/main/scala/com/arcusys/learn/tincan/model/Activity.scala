package com.arcusys.learn.tincan.model

/**
 * A Statement may represent an Activity as the Object of the Statement.
 * The following table lists the Object properties in this case
 * @param objectType MUST be "Activity" when present. Optional in all cases.
 * @param id An identifier for a single unique Activity. Required.
 * @param name The human readable/visual name of the Activity
 * @param description  A description of the Activity
 * @param theType The type of Activity.
 * @param moreInfo SHOULD resolve to a document human-readable information about the Activity,
 *                 which MAY include a way to 'launch' the Activity.
 * @param interactionType As in "cmi.interactions.n.type" as defined in the SCORM 2004 4th Edition Run-Time Environment.
 * @param correctResponsesPattern Corresponds to "cmi.interactions.n.correct_responses.n.pattern"
 *                                as defined in the SCORM 2004 4th Edition Run-Time Environment,
 *                                where the final n is the index of the array.
 * @param choices Specific to the given interactionType
 * @param scale Specific to the given interactionType
 * @param source Specific to the given interactionType
 * @param target Specific to the given interactionType
 * @param steps Specific to the given interactionType
 * @param extensions A map of other properties as needed
 */
case class Activity(
  objectType: String,
  id: String,
  name: Option[LanguageMap],
  description: Option[LanguageMap],
  theType: Option[String],
  moreInfo: Option[String],
  interactionType: Option[InteractionType.Value],
  correctResponsesPattern: Set[String],
  choices: Seq[InteractionComponent],
  scale: Seq[InteractionComponent],
  source: Seq[InteractionComponent],
  target: Seq[InteractionComponent],
  steps: Seq[InteractionComponent],
  extensions: Seq[Extension],
  storedId: Option[Int] = None) extends StatementObject

/**
 *
 * @param id A value such as used in practice for "cmi.interactions.n.id"
 *           as defined in the SCORM 2004 4th Edition Run-Time Environment
 * @param description A description of the interaction component
 *                    (for example, the text for a given choice in a multiple-choice interaction)
 */
case class InteractionComponent(id: String, description: LanguageMap)

case class ActivityReference(id: String, objectType: Option[String])

/**
 * Traditional e-learning has included structures for interactions or assessments.
 * As a way to allow these practices and structures to extend Experience API's utility,
 * this specification includes built-in definitions for interactions, which borrows from the SCORM 2004 4th Edition Data Model.
 * @param parent
 * @param grouping
 * @param category
 * @param other
 */
case class ContextActivities(
  parent: Set[ActivityReference],
  grouping: Set[ActivityReference],
  category: Set[ActivityReference],
  other: Set[ActivityReference],
  id: Option[Int] = None)

object InteractionType extends Enumeration {
  val Choice = Value("choice")
  val Sequencing = Value("sequencing")
  val Likert = Value("likert")
  val Matching = Value("matching")
  val Performance = Value("performance")
  val TrueFalse = Value("true-false")
  val FillIn = Value("fill-in")
  val LongFillIn = Value("long_fill_in")
  val Numeric = Value("numeric")
  val Other = Value("other")

  type InteractionTypes = Value
}

case class ActivityProfile(activityId: String, profileId: String, document: Document)

