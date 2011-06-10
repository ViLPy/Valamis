package com.arcusys.scorm.model
import scala.collection.mutable.Buffer

class Organization(
  val identifier: String,
  val structure: String,
  val objectivesGlobalToSystem: Boolean,
  val sharedDataGlobalToSystem: Boolean,
  val title: String,
  val metadata: Option[Metadata],
  val completionThreshold: Option[CompletionThreshold],
  val sequencing: Option[Sequencing]) {
  val activities = Buffer[Activity]()
}