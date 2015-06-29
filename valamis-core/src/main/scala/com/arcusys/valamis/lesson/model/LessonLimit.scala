package com.arcusys.valamis.lesson.model

import com.arcusys.valamis.lesson.model.LessonType.LessonType
import com.arcusys.valamis.model.PeriodTypes
import com.arcusys.valamis.model.PeriodTypes._

/**
 * User: Yulia.Glushonkova
 * Date: 22.10.2014
 */
case class LessonLimit(itemID: Int, itemType: LessonType, passingLimit: Int, rerunInterval: Int, rerunIntervalType: PeriodType)
