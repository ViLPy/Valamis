package com.arcusys.learn.scorm.manifest.model

/** A type of restrictive action which may be performed by a precondition sequencing rule */
object PreConditionAction extends Enumeration {
  type PreConditionAction = Value
  /** Skip over activity and select the next available during the flow sequencing process */
  val Skip = Value("skip")
  /** Disallow activity for delivery of any kind. Typically seen as grayed out in table of contents */
  val Disabled = Value("disabled")
  /** Disallow activity as target of choice request. Typically grayed out or completely hidden in table of contents */
  val HiddenFromChoice = Value("hiddenFromChoice")
  /** Stop at the activity while processing a sequencing request to walk the activity tree in forward direction */
  val StopForwardTraversal = Value("stopForwardTraversal")
}