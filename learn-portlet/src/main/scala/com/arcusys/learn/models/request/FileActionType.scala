package com.arcusys.learn.models.request

/**
 * Created by Iliya Tryapitsin on 04.03.14.
 */
object FileActionType extends Enumeration {
  type FileActionType = Value

  val ALL = Value("ALL")
  val SCORM = Value("SCORM")
  val TINCAN = Value("TINCAN")
  val ADD = Value("ADD")
  val UPDATE = Value("UPDATE")
  val DELETE = Value("DELETE")
}