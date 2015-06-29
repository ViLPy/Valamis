package com.arcusys.valamis.lrs.util

case class TinCanVerb(uri: String, title: String)

object TinCanVerbs {
  val Answered = "answered"
  val Asked = "asked"
  val Attempted = "attempted"
  val Attended = "attended"
  val Commented = "commented"
  val Completed = "completed"
  val Exited = "exited"
  val Experienced = "experienced"
  val Failed = "failed"
  val Imported = "imported"
  val Initialized = "initialized"
  val Interacted = "interacted"
  val Launched = "launched"
  val Mastered = "mastered"
  val Passed = "passed"
  val Preferred = "preferred"
  val Progressed = "progressed"
  val Registered = "registered"
  val Responded = "responded"
  val Resumed = "resumed"
  val Scored = "scored"
  val Shared = "shared"
  val Suspended = "suspended"
  val Terminated = "terminated"
  val Voided = "voided"

  val all =
    Answered ::
      Asked ::
      Attempted ::
      Attended ::
      Commented ::
      Completed ::
      Exited ::
      Experienced ::
      Failed ::
      Imported ::
      Initialized ::
      Interacted ::
      Launched ::
      Mastered ::
      Passed ::
      Preferred ::
      Progressed ::
      Registered ::
      Responded ::
      Resumed ::
      Scored ::
      Shared ::
      Suspended ::
      Terminated ::
      Voided ::
      Nil

  def getVerbURI(verb: String) = {
    "http://adlnet.gov/expapi/verbs/" + verb
  }

}
