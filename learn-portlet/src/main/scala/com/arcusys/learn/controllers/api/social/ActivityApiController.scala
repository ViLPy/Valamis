package com.arcusys.learn.controllers.api.social

import com.arcusys.learn.controllers.api.BaseApiController
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.request.{ActivityActions, ActivityRequest}
import com.arcusys.learn.models.response.social._
import com.arcusys.valamis.social.service.{LikeService, CommentService, ActivityService}
import com.arcusys.valamis.user.service.UserService
import com.escalatesoft.subcut.inject.BindingModule

class ActivityApiController(configuration: BindingModule) extends BaseApiController(configuration) with ActivityConverter {
  def this() = this(Configuration)

  implicit val serializationFormats = ActivityRequest.serializationFormats

  protected lazy val socialActivityService = inject[ActivityService]
  protected lazy val userService = inject[UserService]
  protected lazy val commentService = inject[CommentService]
  protected lazy val likeService = inject[LikeService]
  protected lazy val activityInterpreter = inject[ActivityInterpreter]

  post("/activity(/)")(jsonAction {
    val activityRequest = ActivityRequest(this)

    activityRequest.action match {
      case ActivityActions.CreateUserStatus =>
        val activity = socialActivityService.create(
          activityRequest.companyIdServer,
          activityRequest.userIdServer,
          activityRequest.content)
        toResponse(activity)

      case ActivityActions.ShareLesson =>
        val companyId = activityRequest.companyIdServer
        val userId = activityRequest.userIdServer
        val packageId = activityRequest.packageId
        val comment = activityRequest.comment

        val activity = socialActivityService.share(companyId, userId, packageId, comment)

        toResponse(activity)
    }
  })

  get("/activity(/)")(jsonAction {
    val activityRequest = ActivityRequest(this)

    socialActivityService.getBy(activityRequest.companyIdServer).map(toResponse)
  })
}
