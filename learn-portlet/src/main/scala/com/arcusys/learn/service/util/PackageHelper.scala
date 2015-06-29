package com.arcusys.learn.service.util

import com.arcusys.learn.models.valamispackage.PackageResponse
import com.arcusys.valamis.lesson.model.BaseManifest
import com.arcusys.valamis.lesson.scorm.model
import com.arcusys.valamis.lesson.scorm.model.manifest
import com.arcusys.valamis.lesson.scorm.model.manifest.Manifest
import com.arcusys.valamis.lesson.tincan.model.TincanManifest

object PackageHelper {
  def toPackageWithLogoUrl(manifest: BaseManifest): BaseManifest = {

    manifest match {
      case tincan: TincanManifest         => toPackageWithLogoUrl(tincan)
      case scorm: model.manifest.Manifest => toPackageWithLogoUrl(scorm)
    }
  }

  def toPackageWithLogoUrl(tincan: TincanManifest): TincanManifest = {
    tincan.copy(logo = Some(getLogoUrl(tincan.id, tincan.logo)))
  }

  def toPackageWithLogoUrl(scorm: manifest.Manifest): Manifest = {
    scorm.copy(logo = Some(getLogoUrl(scorm.id, scorm.logo)))
  }

  def toPackageWithLogoUrl(valamisPackage: PackageResponse): PackageResponse = {
    valamisPackage.copy(logo = Some(getLogoUrl(valamisPackage.id, valamisPackage.logo)))
  }

  def getLogoUrl(packageId: Long, logoNameOption: Option[String]): String = {
    val default = ""
    logoNameOption match {
      case Some("")               => default
      case Some(logoName: String) => "/delegate/files/images?folderId=package_logo_" + packageId + "&file=" + logoName
      case _                      => default
    }
  }
}
