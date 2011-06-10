package com.arcusys.scorm.model
import scala.collection.immutable.Set

class Activity(
  val identifier: String,
  val visible: Boolean,
  val title: String,
  val metadata: Option[Metadata],
  val completionThreshold: Option[CompletionThreshold],
  val sequencing: Option[Sequencing],
  val hiddenNavigationControls: Set[NavigationControlType.Value],
  val parentID: Option[String])