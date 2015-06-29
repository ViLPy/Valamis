package com.arcusys.valamis.uri.service

import com.arcusys.valamis.uri.model.ValamisURI
import com.arcusys.valamis.uri.model.ValamisURIType._

trait URIServiceContract {
  def getByURI(uri: String): Option[ValamisURI]

  def getOrCreate(prefix: String, objId: String, objType: ValamisURIType, content: Option[String]): ValamisURI

  def createLocal(objType: ValamisURIType, content: Option[String]): ValamisURI

  def getById(objId: String, objType: ValamisURIType): Option[ValamisURI]

  def getById(start: Int, end: Int, filter: String): Seq[ValamisURI]

  def getLocalURL(suffix: String = "delegate/"): String
}
