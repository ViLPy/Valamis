package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.Parameter
import com.arcusys.valamis.model.SkipTake
import org.scalatra.ScalatraBase
import com.arcusys.learn.models.BaseCollectionRequest

object UserRequest extends BaseCollectionRequest {
  val UserId = "userID"
  val ResultAs = "resultAs"
  val CompanyId = "companyID"
  val OrgId = "orgId"
  val Scope = "scope"

  val ModuleId = "moduleId"
  val Available = "available"
  val IsOnlyPublished = "isOnlyPublished"
  val CertificateId = "certificateId"
  val WithOpenbadges = "withOpenBadges"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(val scalatra: ScalatraBase) extends BaseCollectionFilteredRequestModel(scalatra) with OAuthModel {
    def requestedUserId = Parameter(UserId).intRequired

    def isUserIdRequest = Parameter(UserId).option.isDefined

    def skipTake = {
      val page = Parameter(Page).option
      val count = Parameter(Count).intOption

      if (page.isDefined && count.isDefined)
        Some(SkipTake(skip, count.get))
      else
        None
    }

    def orgId = Parameter(OrgId).longOption.filterNot(_ == -1)

    def moduleID = Parameter(ModuleId).intRequired

    def isShortResult = Parameter(ResultAs).option match {
      case Some(value) => value == "short"
      case None        => true
    }

    def available = Parameter(Available).booleanOption match {
      case Some(value) => value
      case None        => false
    }

    def scope = Parameter(Scope).longOption

    def isOnlyPublished = Parameter(IsOnlyPublished).booleanOption match {
      case Some(value) => value
      case None        => true
    }

    def certificateId = Parameter(CertificateId).intRequired

    def withOpenBadges = Parameter(WithOpenbadges).booleanOption match {
      case Some(value) => value
      case None        => false
    }
  }
}
