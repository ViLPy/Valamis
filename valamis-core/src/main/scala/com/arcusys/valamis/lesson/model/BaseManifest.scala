package com.arcusys.valamis.lesson.model

import com.arcusys.valamis.lesson.model.LessonType.LessonType
import com.arcusys.valamis.model.PeriodTypes.PeriodType
import org.joda.time.DateTime

trait BaseManifest {
  def getType: LessonType
  def id: Long
  def title: String
  def summary: Option[String]
  def visibility: Option[Boolean]
  def isDefault: Boolean
  def passingLimit: Int
  def rerunInterval: Int
  def rerunIntervalType: PeriodType
  def assetRefId: Option[Long]

  def logo: Option[String]

  def beginDate: Option[DateTime]
  def endDate: Option[DateTime]
  def courseId: Option[Int]
}

