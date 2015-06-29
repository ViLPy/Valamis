package com.arcusys.valamis.certificate.model.goal

import com.arcusys.valamis.model.PeriodTypes

case class CourseGoal(
    certificateId: Long,
    courseId: Long,
    periodValue: Int,
    periodType: PeriodTypes.Value,
    arrangementIndex: Int
)