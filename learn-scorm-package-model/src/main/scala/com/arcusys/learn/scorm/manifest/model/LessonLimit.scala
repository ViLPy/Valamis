package com.arcusys.learn.scorm.manifest.model

import com.arcusys.learn.scorm.manifest.model.LessonType.LessonType
import com.arcusys.learn.scorm.manifest.model.PeriodType.PeriodType

/**
 * User: Yulia.Glushonkova
 * Date: 22.10.2014
 */
case class LessonLimit(itemID: Int, itemType: LessonType, passingLimit: Int, rerunInterval: Int, rerunIntervalType: PeriodType)
