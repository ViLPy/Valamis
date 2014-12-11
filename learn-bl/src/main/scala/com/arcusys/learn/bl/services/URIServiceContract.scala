package com.arcusys.learn.bl.services

import com.arcusys.learn.tincan.model.TincanURI
import com.arcusys.learn.tincan.model.TincanURIType._

trait URIServiceContract {
  def getByURI(uri: String): Option[TincanURI]

  def getOrCreateURI(prefix: String, objId: String, objType: TincanURIType, content: Option[String]): TincanURI

  def getURI(objId: String, objType: TincanURIType): Option[TincanURI]
}
