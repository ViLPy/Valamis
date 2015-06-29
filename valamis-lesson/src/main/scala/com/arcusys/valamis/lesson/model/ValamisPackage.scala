package com.arcusys.valamis.lesson.model

import com.arcusys.valamis.lesson.model.LessonType.LessonType
import com.arcusys.valamis.lesson.model.PackageState.PackageState
import com.arcusys.valamis.model.PeriodTypes.PeriodType
import org.joda.time.DateTime

object PackageState extends Enumeration {
  type PackageState = Value
  val None, Attempted, Finished = Value
}

case class ValamisPackage(id: Long,
  title: String,
  description: Option[String],
  version: Option[String],
  visibility: Boolean,
  isDefault: Boolean,
  packageType: LessonType,
  logo: Option[String],
  suspendedId: Option[String],
  passingLimit: Int,
  rerunInterval: Int,
  rerunIntervalType: PeriodType,
  attemptsCount: Int,
  stateType: PackageState,
  tags: Seq[ValamisTag],
  beginDate: Option[DateTime],
  endDate: Option[DateTime])

case class PackageUploadModel(id: Int,
  title: String,
  description: String,
  packageType: String,
  logo: String)

object PackageSortBy extends Enumeration {
  type PackageSortBy = Value
  val Name, Date = Value

  def apply(v: String): PackageSortBy = v.toLowerCase() match {
    case "name" => Name
    case "date" => Date
    case _      => throw new IllegalArgumentException()
  }
}