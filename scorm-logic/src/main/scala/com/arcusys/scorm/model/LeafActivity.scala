package com.arcusys.scorm.model

import scala.collection.mutable.Buffer

class LeafActivity(
  identifier: String,
  visible: Boolean,
  title: String,
  metadata: Option[Metadata],
  completionThreshold: Option[CompletionThreshold],
  sequencing: Option[Sequencing],
  hiddenNavigationControls: Set[NavigationControlType.Value],
  val resourceIdentifier: String,
  val resourceParameters: Option[String],
  val timeLimitAction: TimeLimitAction.Value,
  val dataFromLMS: Option[String],
  parentID: Option[String]
  )
  extends Activity(identifier, visible, title, metadata, completionThreshold, sequencing, hiddenNavigationControls, parentID) {
  val data = Buffer[ActivityDataMap]()
}