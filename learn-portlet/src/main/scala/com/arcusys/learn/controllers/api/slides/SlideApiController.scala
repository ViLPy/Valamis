package com.arcusys.learn.controllers.api.slides

import java.util.UUID

import com.arcusys.learn.controllers.api.BaseApiController
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.request.{ SlideActionType, SlideRequest }
import com.arcusys.valamis.lrs.util.TinCanVerbs
import com.arcusys.valamis.slide.model.SlideModel
import com.arcusys.valamis.slide.service.SlideServiceContract
import com.arcusys.valamis.uri.model.ValamisURIType
import com.arcusys.valamis.uri.service.URIServiceContract
import com.escalatesoft.subcut.inject.BindingModule

import scala.util.Try

class SlideApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  def this() = this(Configuration)

  private lazy val slideService = inject[SlideServiceContract]
  private lazy val uriService = inject[URIServiceContract]

  get("/slides(/)")(jsonAction {
    val slideRequest = SlideRequest(this)

    val slideSetId = slideRequest.slideSetId
    slideService.getBySlideSetId(slideSetId)
  })

  post("/slides(/)(:id)")(jsonAction {
    val slideRequest = SlideRequest(this)

    val verbUUID = slideRequest.statementVerb.map { verbId =>
      val verbName = verbId.substring(verbId.lastIndexOf("/") + 1)
      if (TinCanVerbs.all.contains(verbName))
        verbId
      else
        uriService.getOrCreate(uriService.getLocalURL(), verbId, ValamisURIType.Verb, Some(verbName)).objId
    }

    val categoryUUID = slideRequest.statementCategoryId.map { categoryId =>
      uriService.getOrCreate(uriService.getLocalURL(), categoryId, ValamisURIType.Category, Some(categoryId)).objId
    }

    slideRequest.action match {
      case SlideActionType.Delete => slideService.delete(slideRequest.id.get)
      case SlideActionType.Update => slideService.update(
        SlideModel(
          slideRequest.id,
          slideRequest.title,
          slideRequest.bgColor,
          slideRequest.bgImage,
          slideRequest.leftSlideId,
          slideRequest.topSlideId,
          List(),
          slideRequest.slideSetId,
          verbUUID,
          slideRequest.statementObject,
          categoryUUID
        )
      )
      case SlideActionType.Create => slideService.create(
        SlideModel(
          None,
          slideRequest.title,
          slideRequest.bgColor,
          slideRequest.bgImage,
          slideRequest.leftSlideId,
          slideRequest.topSlideId,
          List(),
          slideRequest.slideSetId,
          verbUUID,
          slideRequest.statementObject,
          categoryUUID
        )
      )
    }
  })
}
