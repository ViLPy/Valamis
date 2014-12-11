package com.arcusys.learn.controllers.api

import com.arcusys.learn.bl.exceptions.EntityNotFoundException
import com.arcusys.learn.facades.URIFacadeContract
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.request.URIRequest
import com.escalatesoft.subcut.inject.BindingModule

/**
 * Create and provide URI for TinCan Objects
 */
class URIApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  def this() = this(Configuration)

  val uriFacade = inject[URIFacadeContract]

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  get("/uri(/)")(action {
    val uriRequest = URIRequest(this)
    val result = uriFacade.getOrCreateURI(
      uriRequest.prefix,
      uriRequest.id,
      uriRequest.objectType.toLowerCase,
      uriRequest.content)

    result.uri
  })

  get("/uri/:objType/:objName")(action {
    val uri = request.getRequestURL.toString
    val result = uriFacade.getByURI(uri)
    if (result.isDefined)
      halt(200, result.get.content)
    else
      throw new EntityNotFoundException("Object not found")
  })

}
