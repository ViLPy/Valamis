package com.arcusys.learn.models.response.certificates

/**
 * Created by mminin on 03.03.15.
 */

case class GoalsStatusResponse(
  courses: Iterable[CourseStatusResponse],
  activities: Iterable[ActivityStatusResponse],
  statements: Iterable[StatementStatusResponse],
  packages: Iterable[PackageStatusResponse])

case class ActivityStatusResponse(name: String, status: String, dateFinish: String)

case class CourseStatusResponse(id: Long, status: String, dateFinish: String)

case class StatementStatusResponse(obj: String, verb: String, status: String, dateFinish: String)

case class PackageStatusResponse(packageId: Long, status: String, dateFinish: String)