package com.arcusys.learn.models.response.certificates

import com.arcusys.learn.models._
import com.arcusys.learn.models.response.users.UserShortResponse
import com.arcusys.valamis.model.PeriodTypes
import org.joda.time.DateTime

case class CertificateResponse(id: Int,
    title: String,
    shortDescription: String,
    description: String,
    logo: String,
    isPublished: Boolean,
    validPeriod: ValidPeriod,
    createdAt: DateTime,
    isOpenBadgesIntegration: Boolean,
    courses: Iterable[CourseGoalResponse],
    statements: Iterable[StatementGoalResponse],
    activities: Iterable[ActivityGoalResponse],
    packages: Iterable[PackageGoalResponse],
    users: Map[String, UserShortResponse],
    scope: Option[CourseResponse]) extends CertificateResponseContract {
  def expirationDate = PeriodTypes.getEndDate(PeriodTypes.parse(validPeriod.valueType), validPeriod.value, createdAt)
}
