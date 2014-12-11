package com.arcusys.learn.models.response.certificates

import com.arcusys.learn.models._
import com.arcusys.learn.models.response.users.UserShortResponse
import com.arcusys.learn.scorm.manifest.model.PeriodType
import org.joda.time.DateTime

/**
 * Created by Iliya Tryapitsin on 05.03.14.
 */
case class CertificateResponse(id: Int,
    title: String,
    shortDescription: String,
    description: String,
    logo: String,
    isPublished: Boolean,
    validPeriod: ValidPeriod,
    createdAt: DateTime,
    //value: Option[Int],
    //valueType: String,
    isOpenBadgesIntegration: Boolean,
    courses: Iterable[CertificateCourseResponse],
    statements: Iterable[StatementResponse],
    activities: Iterable[ActivityResponse],
    users: Map[String, UserShortResponse],
    scope: Option[CourseResponse]) extends CertificateResponseContract {
  def expirationDate = PeriodType.getEndDate(PeriodType.parse(validPeriod.valueType), validPeriod.value, createdAt)
}

