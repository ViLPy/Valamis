package com.arcusys.learn.models

import org.joda.time.DateTime

case class GoalsDeadlineResponse(
  courses: Seq[CourseDeadlineResponse],
  activities: Seq[ActivityDeadlineResponse],
  statements: Seq[StatementDeadlineResponse])

case class CourseDeadlineResponse(id: Int, deadline: Option[DateTime])
case class ActivityDeadlineResponse(name: String, deadline: Option[DateTime])
case class StatementDeadlineResponse(obj: String, verb: String, deadline: Option[DateTime])