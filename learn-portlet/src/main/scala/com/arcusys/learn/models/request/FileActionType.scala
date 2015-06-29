package com.arcusys.learn.models.request

/**
 * Created by Iliya Tryapitsin on 04.03.14.
 */
object FileActionType extends Enumeration {
  type FileActionType = Value

  val All = Value("ALL")
  val Scorm = Value("SCORM")
  val Tincan = Value("TINCAN")
  val Add = Value("ADD")
  val Update = Value("UPDATE")
  val Delete = Value("DELETE")
}