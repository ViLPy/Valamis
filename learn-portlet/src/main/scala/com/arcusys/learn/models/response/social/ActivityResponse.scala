package com.arcusys.learn.models.response.social

import com.arcusys.learn.controllers.api.social.{ActivityInterpreter, ActivityInterpreterImpl}
import com.arcusys.learn.liferay.model.Activity
import com.arcusys.learn.models.response.users.{UserConverter, UserResponse}
import com.arcusys.valamis.model.{SkipTake, Order}
import com.arcusys.valamis.social.model._
import com.arcusys.valamis.social.service.{LikeService, CommentService}
import com.arcusys.valamis.user.service.UserService
import com.escalatesoft.subcut.inject.BindingModule
import org.ocpsoft.prettytime.PrettyTime

case class ActivityResponse(
  id: Long,
  user: UserResponse,
  verb: String,
  date: String,
  obj: ActivityObjectResponse,
  comments: Seq[CommentResponse],
  userLiked: Set[UserResponse]
)

trait ActivityConverter extends UserConverter with CommentConverter {
  implicit protected val bindingModule: BindingModule
  protected def userService: UserService
  protected def commentService: CommentService
  protected def likeService: LikeService
  protected def activityInterpreter: ActivityInterpreter

  val prettyTime = new PrettyTime()

  def toResponse(activity: Activity): ActivityResponse = {
    val comments =
      commentService.getBy(
        CommentFilter(
          activity.companyId,
          activityId = Some(activity.id),
          sortBy = Some(CommentSortBy(CommentSortByCriteria.CreationDate, Order.Desc)),
          skipTake = Some(SkipTake(0, 5))
        ))
        .reverse

    val userLikedIds =
      likeService
        .getBy(
          LikeFilter(
            activity.companyId,
            activityId = Some(activity.id)
          ))
        .map(_.userId)

    val userLiked = userService.byIds(activity.companyId, userLikedIds.toSet)

    ActivityResponse(
      activity.id,
      user = toResponse(userService.byId(activity.userId.toInt)),
      verb = activityInterpreter.getVerb(activity.className, activity.activityType),
      date = prettyTime.format(activity.createDate.toDate),
      obj = activityInterpreter.getObj(activity.className, activity.classPK, activity.extraData),
      comments = comments.map(toResponse),
      userLiked = userLiked.map(toResponse)
    )
  }
}