package com.arcusys.learn.scorm.manifest.model

import com.arcusys.learn.scorm.manifest.model.PackageType.PackageType

object PackageType extends Enumeration {
  type PackageType = Value

  val SCORM = Value("scorm")
  val TINCAN = Value("tincan")
}

trait BaseManifest {
  def getType: PackageType
  def getId: Int
  def getTitle: String
  def getSummary: Option[String]
  def getVisibility: Option[Boolean]
  def getDefault: Boolean

  def getLogo: String
}

