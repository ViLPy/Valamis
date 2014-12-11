package com.arcusys.learn.tincan.model

import com.arcusys.learn.tincan.model.TincanURIType.TincanURIType

object TincanURIType extends Enumeration {
  type TincanURIType = Value

  val Activity = Value("activity")
  val Package = Value("package")
  val Course = Value("course")
}

case class TincanURI(
  uri: String,
  objId: String,
  objType: TincanURIType,
  content: String)