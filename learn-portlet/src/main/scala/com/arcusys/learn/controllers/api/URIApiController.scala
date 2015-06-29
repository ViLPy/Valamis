package com.arcusys.learn.controllers.api

import com.arcusys.learn.exceptions.BadRequestException
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.request.{URIActionType, URIRequest}
import com.arcusys.valamis.exception.EntityNotFoundException
import com.arcusys.valamis.slide.service.SlideServiceContract
import com.arcusys.valamis.uri.model.ValamisURIType
import com.arcusys.valamis.uri.service.URIServiceContract
import com.escalatesoft.subcut.inject.BindingModule

/**
 * Create and provide URI for TinCan Objects
 */
class URIApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  def this() = this(Configuration)

  val uriService = inject[URIServiceContract]
  val slideService = inject[SlideServiceContract]

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  get("/uri(/)")(jsonAction {
    val uriRequest = URIRequest(this)
    uriRequest.action match {
      case None => {
        val result = uriService.getOrCreate(
          uriRequest.prefix,
          uriRequest.id,
          ValamisURIType.withName(uriRequest.objectType.toLowerCase),
          uriRequest.content)

        result
      }
      case Some(URIActionType.GetAll) => {
        uriService.getById(
          uriRequest.start.getOrElse(-1),
          uriRequest.end.getOrElse(-1),
          uriRequest.filter)
      }
      case _ => throw new BadRequestException
    }
  })

  get("/uri/verbs(/)")(jsonAction {
    slideService.getTinCanVerbs
  })

  get("/uri/:objType/:objName")(action {
    val uri = request.getRequestURL.toString
    val result = uriService.getByURI(uri)
    if (result.isDefined)
      halt(200, result.get.content)
    else
      throw new EntityNotFoundException("Object not found")
  })

}
