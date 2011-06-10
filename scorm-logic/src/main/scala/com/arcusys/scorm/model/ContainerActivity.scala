package com.arcusys.scorm.model

import scala.collection.mutable.Buffer

class ContainerActivity(
  identifier: String,
  visible: Boolean,
  title: String,
  metadata: Option[Metadata],
  completionThreshold: Option[CompletionThreshold],
  sequencing: Option[Sequencing],
  hiddenNavigationControls: Set[NavigationControlType.Value],
  parentID: Option[String]
  )
  extends Activity(identifier, visible, title, metadata, completionThreshold, sequencing, hiddenNavigationControls, parentID) {  
  val childActivities = Buffer[Activity]()  
}