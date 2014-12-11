package com.arcusys.learn.tincan.manifest.model

import com.arcusys.learn.scorm.manifest.model.PackageType.PackageType
import com.arcusys.learn.scorm.manifest.model.{ PeriodType, BaseManifest, PackageType }
import PeriodType.PeriodType

case class TincanManifest(
    id: Int,
    title: String,
    summary: Option[String],
    courseID: Option[Int],
    assetRefID: Option[Long] = None,

    visibility: Option[Boolean] = None,
    logo: Option[String] = None,
    isDefault: Boolean,
    passingLimit: Int = 0,
    rerunInterval: Int = 0,
    rerunIntervalType: PeriodType = PeriodType.UNLIMITED) extends BaseManifest {
  def getType: PackageType = PackageType.TINCAN

  def getId: Int = id

  def getTitle: String = title

  def getSummary: Option[String] = summary

  def getVisibility: Option[Boolean] = visibility

  def getDefault: Boolean = isDefault

  def getPassingLimit: Int = passingLimit
  def getRerunInterval: Int = rerunInterval
  def getRerunIntervalType: PeriodType = rerunIntervalType

  def getLogo: String = logo.getOrElse("")
}
