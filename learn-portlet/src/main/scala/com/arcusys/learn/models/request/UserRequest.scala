package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.Parameter
import org.scalatra.ScalatraBase
import com.arcusys.learn.models.BaseCollectionRequest

/**
 * Created by Iliya Tryapitsin on 12.03.14.
 */
object UserRequest extends BaseCollectionRequest {
  val USER_ID = "userID"
  val RESULT_AS = "resultAs"
  val COMPANY_ID = "companyID"
  val ORG_ID = "orgId"
  val SCOPE = "scope"

  val MODULE_ID = "moduleId"
  val AVAILABLE = "available"
  val IS_ONLY_PUBLISHED = "isOnlyPublished"
  val CERTIFICATE_ID = "certificateId"
  val WITH_OPENBADGES = "withOpenBadges"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) extends BaseCollectionFilteredRequestModel(scalatra) {
    def requestedUserId = Parameter(USER_ID).intRequired

    def isUserIdRequest = Parameter(USER_ID).option.isDefined

    def orgId = Parameter(ORG_ID).longRequired

    def moduleID = Parameter(MODULE_ID).intRequired

    def isShortResult = Parameter(RESULT_AS).option match {
      case Some(value) => value == "short"
      case None        => true
    }

    def available = Parameter(AVAILABLE).booleanOption match {
      case Some(value) => value
      case None        => false
    }

    def scope = Parameter(SCOPE).longOption

    def isOnlyPublished = Parameter(IS_ONLY_PUBLISHED).booleanOption match {
      case Some(value) => value
      case None        => true
    }

    def certificateId = Parameter(CERTIFICATE_ID).intRequired

    def withOpenBadges = Parameter(WITH_OPENBADGES).booleanOption match {
      case Some(value) => value
      case None        => false
    }
  }
}
