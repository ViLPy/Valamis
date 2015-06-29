package com.arcusys.valamis.uri.service

import com.arcusys.valamis.uri.model.{ValamisURIType, ValamisURI}
import com.arcusys.valamis.uri.model.ValamisURIType.ValamisURIType
import com.arcusys.valamis.uri.storage.TincanURIStorage
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import com.liferay.portal.security.auth.CompanyThreadLocal
import com.liferay.portal.service.{ CompanyLocalServiceUtil, ServiceContextThreadLocal }
import com.liferay.portal.util.PortalUtil
import java.util.UUID

import scala.util.Try

class URIService(implicit val bindingModule: BindingModule) extends URIServiceContract with Injectable {

  val uriStorage = inject[TincanURIStorage]

  override def getByURI(uri: String): Option[ValamisURI] = {
    uriStorage.get(uri)
  }

  override def getOrCreate(prefix: String, id: String, uriType: ValamisURIType, content: Option[String]): ValamisURI = {
    var result = uriStorage.getById(id, uriType)
    if (result.isDefined)
      result.get
    else {
      uriType match {
        case ValamisURIType.Package => {
          val uri = createUri(prefix, id, uriType)
          uriStorage.create(uri, id, uriType, content.getOrElse(""))
          result = uriStorage.getById(id, uriType)
          result.getOrElse(throw new RuntimeException(s"Cannot create URI for $uriType"))
        }
        case _ => {

          val uuid = Try(UUID.fromString(id)).getOrElse(UUID.randomUUID).toString
          val uri = createUri(prefix, uuid, uriType)
          uriStorage.create(uri, uuid, uriType, content.getOrElse(""))
          result = uriStorage.getById(uuid, uriType)
          result.getOrElse(throw new RuntimeException(s"Cannot create URI for $uriType"))
        }
      }
    }
  }

  override def createLocal(objType: ValamisURIType, content: Option[String]): ValamisURI = {
    getOrCreate(getLocalURL(), UUID.randomUUID.toString, objType, content)
  }

  override def getById(id: String, uriType: ValamisURIType): Option[ValamisURI] = {
    uriStorage.getById(id, uriType)
  }

  override def getById(start: Int, end: Int, filter: String): Seq[ValamisURI] = {
    uriStorage.getById(start, end, filter)
  }

  def createUri(prefix: String, id: String, uriType: ValamisURIType) = {
    s"$prefix$uriType/${uriType}_$id"
  }

  override def getLocalURL(suffix: String = "delegate/uri/"): String = {
    val companyId = CompanyThreadLocal.getCompanyId
    val company = CompanyLocalServiceUtil.getCompany(companyId)
    val isSecure = if (ServiceContextThreadLocal.getServiceContext != null)
      ServiceContextThreadLocal.getServiceContext.getRequest.isSecure
    else false //TODO: get somehow isSecure when ServiceContextThreadLocal.getServiceContext == null
    val rootUrl = PortalUtil.getPortalURL(company.getVirtualHostname, PortalUtil.getPortalPort(isSecure), isSecure) // http://localhost:8080
    rootUrl + "/" + suffix
  }
}
