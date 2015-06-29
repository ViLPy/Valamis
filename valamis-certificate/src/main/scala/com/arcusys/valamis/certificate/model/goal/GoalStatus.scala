package com.arcusys.valamis.certificate.model.goal

import org.joda.time.DateTime

case class GoalStatus[T](goal: T, status: GoalStatuses.Value, finishDate: Option[DateTime])