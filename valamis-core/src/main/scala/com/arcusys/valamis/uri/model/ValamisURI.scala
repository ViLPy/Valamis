package com.arcusys.valamis.uri.model

import com.arcusys.valamis.uri.model.ValamisURIType.ValamisURIType

object ValamisURIType extends Enumeration {
  type ValamisURIType = Value

  val Activity = Value("activity")
  val Package = Value("package")
  val Course = Value("course")
  val Category = Value("category")
  val Verb = Value("verb")
}

case class ValamisURI(
  uri: String,
  objId: String,
  objType: ValamisURIType,
  content: String)