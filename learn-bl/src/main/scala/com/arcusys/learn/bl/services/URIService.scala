package com.arcusys.learn.bl.services

import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.tincan.model.TincanURI
import com.arcusys.learn.tincan.model.TincanURIType.TincanURIType
import com.arcusys.learn.tincan.storage.TincanURIStorage
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class URIService(configuration: BindingModule) extends URIServiceContract with Injectable {
  def this() = this(DomainConfiguration)

  implicit val bindingModule = configuration

  val uriStorage = inject[TincanURIStorage]

  override def getByURI(uri: String): Option[TincanURI] = {
    uriStorage.get(uri)
  }

  override def getOrCreateURI(prefix: String, id: String, uriType: TincanURIType, content: Option[String]): TincanURI = {
    var result = uriStorage.getURI(id, uriType)
    if (result.isDefined)
      result.get
    else {
      val uri = createUri(prefix, id, uriType)
      uriStorage.create(uri, id, uriType, content.getOrElse(""))
      result = uriStorage.getURI(id, uriType)
      if (result.isDefined)
        result.get
      else
        throw new RuntimeException(s"Cannot create URI for ${uriType}")
    }
  }

  override def getURI(id: String, uriType: TincanURIType): Option[TincanURI] = {
    uriStorage.getURI(id, uriType)
  }

  def createUri(prefix: String, id: String, uriType: TincanURIType) = {
    s"${prefix}${uriType}/${uriType}_${id}"
  }

}
