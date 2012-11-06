package com.arcusys.learn.scorm.manifest.model

/** A type of action which may be performed by a postcondition sequencing rule */
object PostConditionAction extends Enumeration {
  type PostConditionAction = Value
  /** Exit the current aggregation and execute post-condition rules of the parent */
  val ExitParent = Value("exitParent")
  /** Terminate this attempt on the course */
  val ExitAll = Value("exitAll")
  /** Retry the current activity. Note: All prior attempt data for this activity will be erased and a new attempt generated. */
  val Retry = Value("retry")
  /** Retry the entire activity tree */
  val RetryAll = Value("retryAll")
  /** Sequence to the next available activity in the tree */
  val Continue = Value("continue")
  /** Sequence to the prior activity as available */
  val Previous = Value("previous")
}