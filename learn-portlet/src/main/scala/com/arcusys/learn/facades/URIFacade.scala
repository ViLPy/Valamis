package com.arcusys.learn.facades

import com.arcusys.learn.bl.services.URIServiceContract
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.tincan.model.{ TincanURIType, TincanURI }
import com.arcusys.learn.tincan.model.TincanURIType.TincanURIType
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class URIFacade(configuration: BindingModule) extends URIFacadeContract with Injectable {
  def this() = this(Configuration)

  implicit val bindingModule = configuration

  val uriService = inject[URIServiceContract]

  override def getByURI(uri: String): Option[TincanURI] = {
    uriService.getByURI(uri)
  }

  override def getOrCreateURI(prefix: String, id: String, uriType: String, content: Option[String]): TincanURI = {
    uriService.getOrCreateURI(prefix, id, TincanURIType.withName(uriType), content)
  }

  override def getURI(objId: String, objType: TincanURIType): Option[TincanURI] = {
    uriService.getURI(objId, objType)
  }
}
