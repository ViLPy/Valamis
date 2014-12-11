package com.arcusys.learn.facades

import com.arcusys.learn.tincan.model.TincanURI
import com.arcusys.learn.tincan.model.TincanURIType._

trait URIFacadeContract {
  def getByURI(uri: String): Option[TincanURI]

  def getOrCreateURI(prefix: String, id: String, uriType: String, content: Option[String]): TincanURI

  def getURI(id: String, uriType: TincanURIType): Option[TincanURI]
}
