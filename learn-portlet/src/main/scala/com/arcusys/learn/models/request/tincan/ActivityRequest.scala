package com.arcusys.learn.models.request.tincan

import com.arcusys.learn.models.request.BaseRequest
import org.scalatra.ScalatraBase

/**
 * Created by ematyukhin on 08/10/14.
 */
object ActivityRequest {
  val AGENT = "agent"
  val ACTIVITY = "activity"
  val ACTIVITYID = "activityId"
  val STATEID = "stateId"
  val PROFILEID = "profileId"
  val REGISTRATION = "registration"
  val SINCE = "since"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) extends BaseRequest {
    implicit val httpRequest = scalatra.request
    implicit val _scalatra = scalatra

  }
}
