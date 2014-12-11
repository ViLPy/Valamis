package com.arcusys.learn.bl.models.valamispackage

import com.arcusys.learn.scorm.manifest.model.PeriodType.PeriodType

case class ValamisPackage(id: Int, title: String, description: Option[String],
  version: Option[String], visibility: Boolean,
  isDefault: Boolean, packageType: String, logo: Option[String], suspendedID: Option[String],
  passingLimit: Int, rerunInterval: Int, rerunIntervalType: PeriodType, attemptCount: Int)

case class PackageUploadModel(id: Int, title: String, description: String, packageType: String, logo: String)

object PackageSortBy extends Enumeration {
  type PackageSortBy = Value
  val Name, Date = Value
  def apply(v: String): PackageSortBy = v.toLowerCase() match {
    case "name" => Name
    case "date" => Date
    case _      => throw new IllegalArgumentException()
  }
}