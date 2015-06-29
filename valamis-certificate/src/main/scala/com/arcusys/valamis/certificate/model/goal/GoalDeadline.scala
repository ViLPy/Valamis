package com.arcusys.valamis.certificate.model.goal

import org.joda.time.DateTime

case class GoalDeadline[T](goal: T, deadline: Option[DateTime])
