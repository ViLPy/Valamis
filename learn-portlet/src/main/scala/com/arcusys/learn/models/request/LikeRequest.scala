package com.arcusys.learn.models.request

import com.arcusys.learn.liferay.util.PortalUtilHelper
import com.arcusys.learn.service.util.Parameter
import com.arcusys.valamis.model.Order
import com.arcusys.valamis.social.model.{Like, LikeSortByCriteria, LikeSortBy}
import org.joda.time.DateTime
import org.json4s.DefaultFormats
import org.json4s.ext.EnumNameSerializer
import org.scalatra.ScalatraServlet
import com.arcusys.valamis.social

import scala.util.Try

object LikeRequest extends BaseRequest {
  val Id = "id"
  val UserId = "userId"
  val SortByCriterion = "sortByCriterion"
  val SortOrder = "sortOrder"
  val ActivityId = "activityId"

  def apply(controller: ScalatraServlet) = new Model(controller)

  implicit val serializationFormats = DefaultFormats ++ org.json4s.ext.JodaTimeSerializers.all

  class Model(val controller: ScalatraServlet) extends OAuthModel {
    implicit val scalatra = controller
    def action = Parameter(Action).required

    def id = Parameter(Id).longRequired
    def userId = Parameter(UserId).longRequired
    def activityId = Parameter(ActivityId).longRequired

    def like = Like(
      id = Parameter(Id).longOption,
      companyId =  PortalUtilHelper.getCompanyId(controller.request),
      userId = Parameter(UserId).longRequired,
      activityId = Parameter(ActivityId).longRequired)

    def likeRequest = social.model.LikeFilter(
      companyId =  PortalUtilHelper.getCompanyId(controller.request),
      userId = Parameter(UserId).longOption,
      activityId = Parameter(ActivityId).longOption,
      sortBy = Try {
        val sortByCriterion = LikeSortByCriteria.withName(Parameter(SortByCriterion).required)
        val sortOrder = Order.withName(Parameter(SortOrder).required)
        LikeSortBy(sortByCriterion, sortOrder)
      }.toOption
    )
  }
}