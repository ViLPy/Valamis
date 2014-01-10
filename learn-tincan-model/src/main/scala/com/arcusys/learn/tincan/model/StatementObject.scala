package com.arcusys.learn.tincan.model

/**
 * The Object of a Statement can be an Activity, Agent/Group, Sub-Statement, or Statement Reference.
 * It is the "this" part of the Statement, i.e. "I did this".
 */
trait StatementObject {
  def objectType: String
}

object StatementObjectType extends Enumeration {
  val Activity = Value("Activity")
  val Agent = Value("Agent")
  val Group = Value("Group")
  val Person = Value("Person")
  val SubStatement = Value("SubStatement")
  val StatementReference = Value("StatementRef")

  type StatementObjectType = Value
}