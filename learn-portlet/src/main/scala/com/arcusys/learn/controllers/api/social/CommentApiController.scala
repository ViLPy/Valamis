package com.arcusys.learn.controllers.api.social

import com.arcusys.learn.controllers.api.BaseApiController
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.request.{CommentActionType, CommentRequest}
import com.arcusys.learn.models.response.social.CommentConverter
import com.arcusys.learn.models.response.users.UserConverter
import com.arcusys.valamis.social.service.CommentService
import com.arcusys.valamis.user.service.UserService
import com.escalatesoft.subcut.inject.BindingModule

class CommentApiController(configuration: BindingModule) extends BaseApiController(configuration) with CommentConverter with UserConverter {
  def this() = this(Configuration)

  protected lazy val commentService = inject[CommentService]
  protected lazy val userService = inject[UserService]

  implicit val serializationFormats = CommentRequest.serializationFormats

  get("/activity-comment(/)")(jsonAction {
    val commentRequest = CommentRequest(this)

    commentService.getBy(commentRequest.commentRequest).map(toResponse)
  })

  post("/activity-comment(/)")(jsonAction {
    val commentRequest = CommentRequest(this)

    commentRequest.action match {
      case CommentActionType.Create => toResponse(commentService.create(commentRequest.comment))
      case CommentActionType.UpdateContent => toResponse(commentService.updateContent(commentRequest.id, commentRequest.content))
      case CommentActionType.Delete => commentService.delete(commentRequest.id)
    }
  })
}
