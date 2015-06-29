package com.arcusys.learn.controllers.api.social

import com.arcusys.learn.controllers.api.BaseApiController
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.request.{LikeActionType, LikeRequest}
import com.arcusys.valamis.social.service.LikeService
import com.escalatesoft.subcut.inject.BindingModule

class LikeApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  def this() = this(Configuration)

  val likeService = inject[LikeService]

  implicit val serializationFormats = LikeRequest.serializationFormats

  get("/activity-like(/)")(jsonAction {
    val likeRequest = LikeRequest(this)

    likeService.getBy(likeRequest.likeRequest)
  })

  post("/activity-like(/)")(jsonAction {
    val likeRequest = LikeRequest(this)

    likeRequest.action match {
      case LikeActionType.Create => likeService.create(likeRequest.like)
      case LikeActionType.Delete => likeService.delete(likeRequest.userId, likeRequest.activityId)
    }
  })
}
