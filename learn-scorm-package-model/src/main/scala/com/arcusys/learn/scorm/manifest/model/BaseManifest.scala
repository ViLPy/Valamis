package com.arcusys.learn.scorm.manifest.model

import com.arcusys.learn.scorm.manifest.model.PackageType.PackageType
import com.arcusys.learn.scorm.manifest.model.PeriodType._

object PackageType extends Enumeration {
  type PackageType = Value

  val SCORM = Value("scorm")
  val TINCAN = Value("tincan")
  val ALL = Value("all")
}

trait BaseManifest {
  def getType: PackageType
  def getId: Int
  def getTitle: String
  def getSummary: Option[String]
  def getVisibility: Option[Boolean]
  def getDefault: Boolean
  def getPassingLimit: Int
  def getRerunInterval: Int
  def getRerunIntervalType: PeriodType

  def getLogo: String
}

