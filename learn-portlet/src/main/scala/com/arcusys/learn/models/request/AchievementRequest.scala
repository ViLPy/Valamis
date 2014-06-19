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
  val USER_ID = "userId"
  val TITLE = "title"
  val DESCRIPTION = "description"
  val LOGO = "logo"
  val START_DATE = "startDate"
  val ACHIEVEMENT_ID = "achievementId"
  val ACTIVITY_CLASS_NAME = "activityClassName"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) extends BaseCollectionFilteredRequestModel(scalatra) {

    def actionType: AchievementActionType = Parameter(AchievementRequest.ACTION).required.toUpperCase
    def userId: Int = Parameter(AchievementRequest.USER_ID).intRequired
    def title = AntiSamyHelper.sanitize(Parameter(AchievementRequest.TITLE).required)
    def description = AntiSamyHelper.sanitize(Parameter(AchievementRequest.DESCRIPTION).required)
    def logoUrl = Parameter(AchievementRequest.LOGO).required
    def startDate: DateTime = new DateTime(Parameter(AchievementRequest.START_DATE).longRequired)
    def achievementId = Parameter(AchievementRequest.ACHIEVEMENT_ID).intRequired
    def activityClassName = Parameter(AchievementRequest.ACTIVITY_CLASS_NAME).required
  }
}

