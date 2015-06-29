package com.arcusys.valamis.lesson.storage

import com.arcusys.valamis.lesson.model.LessonLimit
import com.arcusys.valamis.lesson.model.LessonType._
import com.arcusys.valamis.model.PeriodTypes._

trait LessonLimitStorage {
  def getByID(packageId: Long, packageType: LessonType): Option[LessonLimit]
  def getByIDs(packageIds: Seq[Long]): Seq[LessonLimit]

  def setLimit(packageId: Long, packageType: LessonType, passingLimit: Int, rerunInterval: Int, rerunIntervalType: PeriodType): LessonLimit
}
