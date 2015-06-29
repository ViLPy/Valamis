package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.{ AntiSamyHelper, Parameter }
import com.arcusys.learn.models.request.AchievementActionType.AchievementActionType
import com.arcusys.learn.models.request.AchievementActionTypeConverters._
import org.scalatra.{ ScalatraKernel, ScalatraBase }
import org.joda.time.DateTime

/**
 * Created by Iliya Tryapitsin on 04.03.14.
 */

object AchievementRequest extends BaseCollectionFilteredRequest with BaseRequest {
  val UserId = "userId"
  val Title = "title"
  val Description = "description"
  val Logo = "logo"
  val StartDate = "startDate"
  val AchievementId = "achievementId"
  val ActivityClassName = "activityClassName"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) extends BaseCollectionFilteredRequestModel(scalatra) {

    def actionType: AchievementActionType = Parameter(AchievementRequest.Action).required.toUpperCase
    def userId: Int = Parameter(AchievementRequest.UserId).intRequired
    def title = AntiSamyHelper.sanitize(Parameter(AchievementRequest.Title).required)
    def description = AntiSamyHelper.sanitize(Parameter(AchievementRequest.Description).required)
    def logoUrl = Parameter(AchievementRequest.Logo).required
    def startDate: DateTime = new DateTime(Parameter(AchievementRequest.StartDate).longRequired)
    def achievementId = Parameter(AchievementRequest.AchievementId).intRequired
    def activityClassName = Parameter(AchievementRequest.ActivityClassName).required
  }
}

