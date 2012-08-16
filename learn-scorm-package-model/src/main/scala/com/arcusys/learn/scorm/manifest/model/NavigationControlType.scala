package com.arcusys.learn.scorm.manifest.model

/** A navigation control which may be included in the to-hide list*/
object NavigationControlType extends Enumeration {
  type NavigationControlType = Value
  val Previous = Value("previous")
  val Continue = Value("continue")
  val Exit = Value("exit")
  val ExitAll = Value("exitAll")
  val Abandon = Value("abandon")
  val AbandonAll = Value("abandonAll")
  val SuspendAll = Value("suspendAll")
}