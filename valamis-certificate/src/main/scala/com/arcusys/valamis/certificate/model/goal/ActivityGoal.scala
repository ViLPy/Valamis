package com.arcusys.valamis.certificate.model.goal

import com.arcusys.valamis.model.PeriodTypes.PeriodType

case class ActivityGoal(
  certificateId: Int,
  activityName: String,
  count: Int,
  periodValue: Int,
  periodType: PeriodType
)