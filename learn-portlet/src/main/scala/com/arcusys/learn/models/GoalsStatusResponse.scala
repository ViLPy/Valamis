package com.arcusys.learn.models

import com.arcusys.learn.models.response.certificates.{ StatementStatusResponse, ActivityStatusResponse, CourseStatusResponse }

/**
 * Created by Iliya Tryapitsin on 05.06.2014.
 */
case class GoalsStatusResponse(courses: Iterable[CourseStatusResponse],
  activities: Iterable[ActivityStatusResponse],
  statements: Iterable[StatementStatusResponse])
