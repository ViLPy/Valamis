package com.arcusys.learn.models.response.social

import com.arcusys.learn.models.response.users.{UserConverter, UserResponse}
import com.arcusys.valamis.social.model.Comment
import com.arcusys.valamis.user.service.UserService
import org.ocpsoft.prettytime.PrettyTime

case class CommentResponse(
  id: Long,
  user: UserResponse,
  content: String,
  creationDate: String,
  lastUpdateDate: Option[String]
)

trait CommentConverter { self: UserConverter =>
  protected def userService: UserService

  private val prettyTime = new PrettyTime

  protected def toResponse(from: Comment): CommentResponse =
    CommentResponse(
      id = from.id.get,
      user = toResponse(userService.byId(from.userId.toInt)),
      content = from.content,
      creationDate = prettyTime.format(from.creationDate.toDate),
      lastUpdateDate = from.lastUpdateDate.map(date => prettyTime.format(date.toDate))
    )
}