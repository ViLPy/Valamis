package com.arcusys.valamis.certificate.model.goal

import com.arcusys.valamis.model.PeriodTypes

case class StatementGoal(
    certificateId: Long,
    verb: String,
    obj: String,
    periodValue: Int,
    periodType: PeriodTypes.Value)