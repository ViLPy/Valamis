package com.arcusys.valamis.certificate.model.goal

import com.arcusys.valamis.model.PeriodTypes

case class PackageGoal(
    certificateId: Long,
    packageId: Long,
    periodValue: Int,
    periodType: PeriodTypes.Value)